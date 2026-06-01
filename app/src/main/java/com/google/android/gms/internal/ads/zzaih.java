package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaih implements zzaie {
    private final int zza;
    private final int zzb;
    private final zzeg zzc;

    public zzaih(zzev zzevVar, zzv zzvVar) {
        zzeg zzegVar = zzevVar.zza;
        this.zzc = zzegVar;
        zzegVar.zzh(12);
        int iZzH = zzegVar.zzH();
        if ("audio/raw".equals(zzvVar.zzo)) {
            int iZzE = zzep.zzE(zzvVar.zzI) * zzvVar.zzG;
            if (iZzH == 0 || iZzH % iZzE != 0) {
                zzdt.zzc("BoxParsers", a1.a.f(iZzE, iZzH, "Audio sample size mismatch. stsd sample size: ", ", stsz sample size: ", new StringBuilder(String.valueOf(iZzE).length() + 66 + String.valueOf(iZzH).length())));
                iZzH = iZzE;
            }
        }
        this.zza = iZzH == 0 ? -1 : iZzH;
        this.zzb = zzegVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zzc() {
        int i2 = this.zza;
        return i2 == -1 ? this.zzc.zzH() : i2;
    }
}
