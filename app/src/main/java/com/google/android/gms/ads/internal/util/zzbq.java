package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzfuz;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbq {
    private HandlerThread zza = null;
    private Handler zzb = null;
    private int zzc = 0;
    private final Object zzd = new Object();

    public final Looper zza() {
        Looper looper;
        Object obj = this.zzd;
        synchronized (obj) {
            try {
                if (this.zzc != 0) {
                    Preconditions.checkNotNull(this.zza, "Invalid state: handlerThread should already been initialized.");
                } else if (this.zza == null) {
                    zze.zza("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.zza = handlerThread;
                    handlerThread.start();
                    this.zzb = new zzfuz(this.zza.getLooper());
                    zze.zza("Looper thread started.");
                } else {
                    zze.zza("Resuming the looper thread");
                    obj.notifyAll();
                }
                this.zzc++;
                looper = this.zza.getLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public final Handler zzb() {
        return this.zzb;
    }
}
