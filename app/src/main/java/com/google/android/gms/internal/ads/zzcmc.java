package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcmc implements zzdrm {
    private final zzckz zza;
    private zzfdq zzb;
    private zzfcu zzc;
    private zzdeo zzd;
    private zzcxx zze;

    public /* synthetic */ zzcmc(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm, com.google.android.gms.internal.ads.zzcxu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdrn zzh() {
        zzifp.zzc(this.zzd, zzdeo.class);
        zzifp.zzc(this.zze, zzcxx.class);
        return new zzcmd(this.zza, new zzcuu(), new zzfht(), new zzcwv(), new zzdvx(), this.zzd, this.zze, zzelg.zza(), null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final /* synthetic */ zzdrm zzb(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final /* synthetic */ zzdrm zzc(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final /* bridge */ /* synthetic */ zzdrm zzd(zzcxx zzcxxVar) {
        this.zze = zzcxxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm
    public final /* bridge */ /* synthetic */ zzdrm zze(zzdeo zzdeoVar) {
        this.zzd = zzdeoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzi(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdrm, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzj(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }
}
