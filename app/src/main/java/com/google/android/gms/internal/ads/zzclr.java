package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclr implements zzdjc {
    private final zzckz zza;
    private zzfdq zzb;
    private zzfcu zzc;
    private zzdeo zzd;
    private zzcxx zze;
    private zzena zzf;

    public /* synthetic */ zzclr(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc, com.google.android.gms.internal.ads.zzcxu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdjd zzh() {
        zzifp.zzc(this.zzd, zzdeo.class);
        zzifp.zzc(this.zze, zzcxx.class);
        zzifp.zzc(this.zzf, zzena.class);
        return new zzcls(this.zza, new zzcuu(), new zzfht(), new zzcwv(), new zzdvx(), this.zzd, this.zze, zzelg.zza(), this.zzf, null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdjc
    public final /* synthetic */ zzdjc zzb(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc
    public final /* synthetic */ zzdjc zzc(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc
    public final /* bridge */ /* synthetic */ zzdjc zzd(zzena zzenaVar) {
        this.zzf = zzenaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc
    public final /* bridge */ /* synthetic */ zzdjc zze(zzcxx zzcxxVar) {
        this.zze = zzcxxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc
    public final /* bridge */ /* synthetic */ zzdjc zzf(zzdeo zzdeoVar) {
        this.zzd = zzdeoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzi(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjc, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzj(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }
}
