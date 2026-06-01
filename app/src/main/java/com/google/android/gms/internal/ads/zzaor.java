package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaor implements zzaed {
    private final zzaoo zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaor(zzaoo zzaooVar, int i2, long j, long j3) {
        this.zza = zzaooVar;
        this.zzb = i2;
        this.zzc = j;
        long j8 = (j3 - j) / ((long) zzaooVar.zzd);
        this.zzd = j8;
        this.zze = zzd(j8);
    }

    private final long zzd(long j) {
        return zzep.zzt(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long j3 = this.zzb;
        zzaoo zzaooVar = this.zza;
        long j8 = (((long) zzaooVar.zzc) * j) / (j3 * 1000000);
        String str = zzep.zza;
        long j9 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j8, j9));
        long j10 = zzaooVar.zzd;
        long jZzd = zzd(jMax);
        long j11 = this.zzc;
        zzaee zzaeeVar = new zzaee(jZzd, (jMax * j10) + j11);
        if (jZzd >= j || jMax == j9) {
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        long j12 = jMax + 1;
        return new zzaeb(zzaeeVar, new zzaee(zzd(j12), (j10 * j12) + j11));
    }
}
