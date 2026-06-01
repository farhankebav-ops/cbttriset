package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class zzlg {
    private final Object zza;

    @Nullable
    @GuardedBy("lock")
    private Looper zzb;

    @Nullable
    @GuardedBy("lock")
    private HandlerThread zzc;

    @GuardedBy("lock")
    private int zzd;

    public zzlg() {
        throw null;
    }

    public final Looper zza() {
        Looper looper;
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    boolean z2 = false;
                    if (this.zzd == 0 && this.zzc == null) {
                        z2 = true;
                    }
                    zzgmd.zzh(z2);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.zzc = handlerThread;
                    handlerThread.start();
                    this.zzb = this.zzc.getLooper();
                }
                this.zzd++;
                looper = this.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public final void zzb() {
        HandlerThread handlerThread;
        synchronized (this.zza) {
            try {
                zzgmd.zzh(this.zzd > 0);
                int i2 = this.zzd - 1;
                this.zzd = i2;
                if (i2 == 0 && (handlerThread = this.zzc) != null) {
                    handlerThread.quit();
                    this.zzc = null;
                    this.zzb = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzlg(@Nullable Looper looper) {
        this.zza = new Object();
        this.zzb = null;
        this.zzc = null;
        this.zzd = 0;
    }
}
