package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzani implements zzanq {
    private zzv zza;
    private zzem zzb;
    private zzaem zzc;

    public zzani(String str, String str2) {
        zzt zztVar = new zzt();
        zztVar.zzl("video/mp2t");
        zztVar.zzm(str);
        this.zza = zztVar.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
        this.zzb = zzemVar;
        zzaoeVar.zza();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzc = zzaemVarZzu;
        zzaemVarZzu.zzu(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zzb(zzeg zzegVar) {
        this.zzb.getClass();
        String str = zzep.zza;
        long jZzb = this.zzb.zzb();
        long jZzc = this.zzb.zzc();
        if (jZzb == -9223372036854775807L || jZzc == -9223372036854775807L) {
            return;
        }
        zzv zzvVar = this.zza;
        if (jZzc != zzvVar.zzt) {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzr(jZzc);
            zzv zzvVarZzM = zztVarZza.zzM();
            this.zza = zzvVarZzM;
            this.zzc.zzu(zzvVarZzM);
        }
        int iZzd = zzegVar.zzd();
        this.zzc.zzz(zzegVar, iZzd);
        this.zzc.zzx(jZzb, 1, iZzd, 0, null);
    }
}
