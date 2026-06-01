package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzacq implements zzaed {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzacq(long j, long j3, int i2, int i8, boolean z2) {
        long jZze;
        this.zza = j;
        this.zzb = j3;
        this.zzc = i8 == -1 ? 1 : i8;
        this.zze = i2;
        if (j == -1) {
            this.zzd = -1L;
            jZze = -9223372036854775807L;
        } else {
            this.zzd = j - j3;
            jZze = zze(j, j3, i2);
        }
        this.zzf = jZze;
    }

    private static long zze(long j, long j3, int i2) {
        return (Math.max(0L, j - j3) * 8000000) / ((long) i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return this.zzd != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long j3 = this.zzd;
        if (j3 == -1) {
            zzaee zzaeeVar = new zzaee(0L, this.zzb);
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        long j8 = ((long) this.zze) * j;
        long j9 = this.zzc;
        long jMin = ((j8 / 8000000) / j9) * j9;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3 - j9);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZzd = zzd(jMax);
        zzaee zzaeeVar2 = new zzaee(jZzd, jMax);
        if (j3 != -1 && jZzd < j) {
            long j10 = jMax + j9;
            if (j10 < this.zza) {
                return new zzaeb(zzaeeVar2, new zzaee(zzd(j10), j10));
            }
        }
        return new zzaeb(zzaeeVar2, zzaeeVar2);
    }

    public final long zzd(long j) {
        return zze(j, this.zzb, this.zze);
    }
}
