package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcme implements com.google.android.gms.ads.nonagon.signalgeneration.zzab {
    private final zzckz zza;
    private zzcxx zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzay zzc;

    public /* synthetic */ zzcme(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzac zza() {
        zzifp.zzc(this.zzb, zzcxx.class);
        zzifp.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzay.class);
        return new zzcmf(this.zza, this.zzc, new zzcuu(), new zzcwv(), new zzdvx(), this.zzb, null, null);
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        this.zzc = zzayVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zzc(zzcxx zzcxxVar) {
        this.zzb = zzcxxVar;
        return this;
    }
}
