package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwb implements zzut {
    private final zzga zza;
    private final zzvm zzb;
    private int zzc;
    private final zzze zzd;

    public zzwb(zzga zzgaVar, final zzadg zzadgVar) {
        zzvm zzvmVar = new zzvm() { // from class: com.google.android.gms.internal.ads.zzwa
            @Override // com.google.android.gms.internal.ads.zzvm
            public final /* synthetic */ zzvn zza(zzpc zzpcVar) {
                return new zztw(zzadgVar);
            }
        };
        zzze zzzeVar = new zzze(-1);
        this.zza = zzgaVar;
        this.zzb = zzvmVar;
        this.zzd = zzzeVar;
        this.zzc = 1048576;
    }

    public final zzwb zza(int i2) {
        this.zzc = i2;
        return this;
    }

    public final zzwc zzb(zzak zzakVar) {
        zzakVar.zzb.getClass();
        return new zzwc(zzakVar, this.zza, this.zzb, zzrz.zza, this.zzd, this.zzc, 0, null, null, null);
    }
}
