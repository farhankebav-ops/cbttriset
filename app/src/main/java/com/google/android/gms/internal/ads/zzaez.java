package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaez implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaez(int i2, int i8, int i9, int i10) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
    }

    public static zzaez zzb(zzeg zzegVar) {
        int iZzC = zzegVar.zzC();
        zzegVar.zzk(8);
        int iZzC2 = zzegVar.zzC();
        int iZzC3 = zzegVar.zzC();
        zzegVar.zzk(4);
        int iZzC4 = zzegVar.zzC();
        zzegVar.zzk(12);
        return new zzaez(iZzC, iZzC2, iZzC3, iZzC4);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return 1751742049;
    }
}
