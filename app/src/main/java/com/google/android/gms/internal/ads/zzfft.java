package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfft {
    private final Clock zza;
    private final zzdvi zzb;
    private final Object zzc = new Object();
    private volatile int zze = 1;
    private volatile long zzd = 0;

    public zzfft(Clock clock, zzdvi zzdviVar) {
        this.zza = clock;
        this.zzb = zzdviVar;
    }

    private final void zze() {
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzc) {
            try {
                if (this.zze == 3) {
                    if (this.zzd + ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgz)).longValue() <= jCurrentTimeMillis) {
                        this.zze = 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzf(int i2, int i8) {
        zze();
        Object obj = this.zzc;
        long jCurrentTimeMillis = this.zza.currentTimeMillis();
        synchronized (obj) {
            try {
                if (this.zze != i2) {
                    return;
                }
                this.zze = i8;
                if (this.zze == 3) {
                    this.zzd = jCurrentTimeMillis;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzod)).booleanValue()) {
            zzdvh zzdvhVarZza = this.zzb.zza();
            zzdvhVarZza.zzc("action", "mbs_state");
            zzdvhVarZza.zzc("mbs_state", true != z2 ? "0" : "1");
            zzdvhVarZza.zzd();
        }
        if (z2) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzb() {
        boolean z2;
        synchronized (this.zzc) {
            zze();
            z2 = this.zze == 2;
        }
        return z2;
    }

    public final boolean zzc() {
        boolean z2;
        synchronized (this.zzc) {
            zze();
            z2 = this.zze == 3;
        }
        return z2;
    }

    public final void zzd() {
        zzf(2, 3);
    }
}
