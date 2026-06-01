package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclm implements zzdws {
    private final zzckz zza;
    private final zzclp zzb;
    private Long zzc;
    private String zzd;

    public /* synthetic */ zzclm(zzckz zzckzVar, zzclp zzclpVar, byte[] bArr) {
        this.zza = zzckzVar;
        this.zzb = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final zzdwt zza() {
        zzifp.zzc(this.zzc, Long.class);
        zzifp.zzc(this.zzd, String.class);
        return new zzcln(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final /* bridge */ /* synthetic */ zzdws zzb(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final /* bridge */ /* synthetic */ zzdws zzc(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }
}
