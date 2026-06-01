package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzclg implements zzcsk {
    private final zzckz zza;
    private zzfdq zzb;
    private zzfcu zzc;
    private zzdeo zzd;
    private zzcxx zze;
    private zzena zzf;
    private zzctg zzg;
    private zzele zzh;
    private zzcrd zzi;
    private zzdju zzj;

    public /* synthetic */ zzclg(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk, com.google.android.gms.internal.ads.zzcxu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcsl zzh() {
        zzifp.zzc(this.zzd, zzdeo.class);
        zzifp.zzc(this.zze, zzcxx.class);
        zzifp.zzc(this.zzf, zzena.class);
        zzifp.zzc(this.zzg, zzctg.class);
        if (this.zzh == null) {
            this.zzh = zzelg.zza();
        }
        zzifp.zzc(this.zzi, zzcrd.class);
        zzifp.zzc(this.zzj, zzdju.class);
        return new zzclh(this.zza, this.zzi, this.zzj, new zzcuu(), new zzfht(), new zzcwv(), new zzdvx(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* synthetic */ zzcsk zzb(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* synthetic */ zzcsk zzc(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzd(zzdju zzdjuVar) {
        this.zzj = zzdjuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zze(zzcrd zzcrdVar) {
        this.zzi = zzcrdVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzf(zzele zzeleVar) {
        this.zzh = zzeleVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzg(zzctg zzctgVar) {
        this.zzg = zzctgVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzi(@Nullable zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk, com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzj(@Nullable zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzk(zzena zzenaVar) {
        this.zzf = zzenaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzl(zzcxx zzcxxVar) {
        this.zze = zzcxxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcsk
    public final /* bridge */ /* synthetic */ zzcsk zzm(zzdeo zzdeoVar) {
        this.zzd = zzdeoVar;
        return this;
    }
}
