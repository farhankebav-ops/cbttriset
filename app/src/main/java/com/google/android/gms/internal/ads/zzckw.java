package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzckw implements zzdjy {
    private final zzckz zza;
    private zzfdq zzb;
    private zzfcu zzc;
    private zzdeo zzd;
    private zzcxx zze;
    private zzdju zzf;
    private zzcrd zzg;

    public /* synthetic */ zzckw(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy, com.google.android.gms.internal.ads.zzcxu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdjz zzh() {
        zzifp.zzc(this.zzd, zzdeo.class);
        zzifp.zzc(this.zze, zzcxx.class);
        zzifp.zzc(this.zzf, zzdju.class);
        zzifp.zzc(this.zzg, zzcrd.class);
        return new zzckx(this.zza, this.zzg, this.zzf, new zzcuu(), new zzfht(), new zzcwv(), new zzdvx(), this.zzd, this.zze, zzelg.zza(), null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* synthetic */ zzdjy zzb(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* synthetic */ zzdjy zzc(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* bridge */ /* synthetic */ zzdjy zzd(zzcrd zzcrdVar) {
        this.zzg = zzcrdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* bridge */ /* synthetic */ zzdjy zze(zzdju zzdjuVar) {
        this.zzf = zzdjuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* bridge */ /* synthetic */ zzdjy zzf(zzcxx zzcxxVar) {
        this.zze = zzcxxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* bridge */ /* synthetic */ zzdjy zzg(zzdeo zzdeoVar) {
        this.zzd = zzdeoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzi(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzj(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }
}
