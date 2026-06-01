package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadl implements zzaed {
    private final zzadn zza;
    private final long zzb;

    public zzadl(zzadn zzadnVar, long j) {
        this.zza = zzadnVar;
        this.zzb = j;
    }

    private final zzaee zzd(long j, long j3) {
        return new zzaee((j * 1000000) / ((long) this.zza.zze), this.zzb + j3);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzadn zzadnVar = this.zza;
        zzadm zzadmVar = zzadnVar.zzk;
        zzadmVar.getClass();
        long jZzb = zzadnVar.zzb(j);
        long[] jArr = zzadmVar.zza;
        int iZzm = zzep.zzm(jArr, jZzb, true, false);
        long j3 = iZzm == -1 ? 0L : jArr[iZzm];
        long[] jArr2 = zzadmVar.zzb;
        zzaee zzaeeVarZzd = zzd(j3, iZzm != -1 ? jArr2[iZzm] : 0L);
        if (zzaeeVarZzd.zzb == j || iZzm == jArr.length - 1) {
            return new zzaeb(zzaeeVarZzd, zzaeeVarZzd);
        }
        int i2 = iZzm + 1;
        return new zzaeb(zzaeeVarZzd, zzd(jArr[i2], jArr2[i2]));
    }
}
