package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafs extends zzafr {
    private final zzeg zzb;
    private final zzeg zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafs(zzaem zzaemVar) {
        super(zzaemVar);
        this.zzb = new zzeg(zzfm.zza);
        this.zzc = new zzeg(4);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zza(zzeg zzegVar) throws zzafq {
        int iZzs = zzegVar.zzs();
        int i2 = iZzs >> 4;
        int i8 = iZzs & 15;
        if (i8 != 7) {
            throw new zzafq(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i8).length() + 28), "Video format not supported: ", i8));
        }
        this.zzg = i2;
        return i2 != 5;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb(zzeg zzegVar, long j) throws zzat {
        int i2;
        int iZzs = zzegVar.zzs();
        long jZzy = zzegVar.zzy();
        if (iZzs == 0) {
            if (!this.zze) {
                zzeg zzegVar2 = new zzeg(new byte[zzegVar.zzd()]);
                zzegVar.zzm(zzegVar2.zzi(), 0, zzegVar.zzd());
                zzacf zzacfVarZza = zzacf.zza(zzegVar2);
                this.zzd = zzacfVarZza.zzb;
                zzt zztVar = new zzt();
                zztVar.zzl("video/x-flv");
                zztVar.zzm("video/avc");
                zztVar.zzj(zzacfVarZza.zzl);
                zztVar.zzt(zzacfVarZza.zzc);
                zztVar.zzu(zzacfVarZza.zzd);
                zztVar.zzz(zzacfVarZza.zzk);
                zztVar.zzp(zzacfVarZza.zza);
                this.zza.zzu(zztVar.zzM());
                this.zze = true;
                return false;
            }
        } else if (iZzs == 1 && this.zze) {
            int i8 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i2 = i8;
            } else if (i8 != 0) {
                i2 = 1;
            }
            zzeg zzegVar3 = this.zzc;
            byte[] bArrZzi = zzegVar3.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i9 = 4 - this.zzd;
            int i10 = 0;
            while (zzegVar.zzd() > 0) {
                zzegVar.zzm(zzegVar3.zzi(), i9, this.zzd);
                zzegVar3.zzh(0);
                zzeg zzegVar4 = this.zzb;
                int iZzH = zzegVar3.zzH();
                zzegVar4.zzh(0);
                zzaem zzaemVar = this.zza;
                zzaemVar.zzz(zzegVar4, 4);
                zzaemVar.zzz(zzegVar, iZzH);
                i10 = i10 + 4 + iZzH;
            }
            this.zza.zzx((jZzy * 1000) + j, i2, i10, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
