package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdf {
    private boolean zza;

    public zzdf() {
        throw null;
    }

    public final synchronized boolean zza() {
        if (this.zza) {
            return false;
        }
        this.zza = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzb() {
        boolean z2;
        z2 = this.zza;
        this.zza = false;
        return z2;
    }

    public final synchronized void zzc() throws InterruptedException {
        while (!this.zza) {
            wait();
        }
    }

    public final synchronized void zzd() {
        boolean z2 = false;
        while (!this.zza) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean zze(long j) {
        if (j > 0) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = j + jElapsedRealtime;
                if (j3 < jElapsedRealtime) {
                    zzd();
                } else {
                    boolean z2 = false;
                    while (!this.zza && jElapsedRealtime < j3) {
                        try {
                            wait(j3 - jElapsedRealtime);
                        } catch (InterruptedException unused) {
                            z2 = true;
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zza;
    }

    public final synchronized boolean zzf() {
        return this.zza;
    }

    public zzdf(zzdc zzdcVar) {
    }
}
