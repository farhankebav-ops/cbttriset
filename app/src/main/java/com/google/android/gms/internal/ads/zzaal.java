package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaal extends HandlerThread implements Handler.Callback {
    private zzdi zza;
    private Handler zzb;

    @Nullable
    private Error zzc;

    @Nullable
    private RuntimeException zzd;

    @Nullable
    private zzaam zze;

    public zzaal() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzdi zzdiVar;
        int i2 = message.what;
        try {
            if (i2 == 1) {
                try {
                    int i8 = message.arg1;
                    zzdi zzdiVar2 = this.zza;
                    if (zzdiVar2 == null) {
                        throw null;
                    }
                    zzdiVar2.zza(i8);
                    this.zze = new zzaam(this, this.zza.zzc(), i8 != 0, null);
                    synchronized (this) {
                        notify();
                    }
                } catch (zzdj e) {
                    zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.zzd = new IllegalStateException(e);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                    this.zzc = e4;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e8) {
                    zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e8);
                    this.zzd = e8;
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i2 == 2) {
                try {
                    zzdiVar = this.zza;
                } finally {
                    try {
                    } finally {
                    }
                }
                if (zzdiVar == null) {
                    throw null;
                }
                zzdiVar.zzb();
                return true;
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }

    public final zzaam zza(int i2) {
        boolean z2;
        start();
        Handler handler = new Handler(getLooper(), this);
        this.zzb = handler;
        this.zza = new zzdi(handler, null);
        synchronized (this) {
            z2 = false;
            this.zzb.obtainMessage(1, i2, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzaam zzaamVar = this.zze;
        zzaamVar.getClass();
        return zzaamVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
