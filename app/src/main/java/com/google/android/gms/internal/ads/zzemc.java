package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzemc extends zzbyf {
    final /* synthetic */ zzdaz zza;
    final /* synthetic */ zzcym zzb;
    final /* synthetic */ zzczv zzc;
    final /* synthetic */ zzdhe zzd;

    public zzemc(zzemd zzemdVar, zzdaz zzdazVar, zzcym zzcymVar, zzczv zzczvVar, zzdhe zzdheVar) {
        this.zza = zzdazVar;
        this.zzb = zzcymVar;
        this.zzc = zzczvVar;
        this.zzd = zzdheVar;
        Objects.requireNonNull(zzemdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzi(IObjectWrapper iObjectWrapper) {
        this.zzd.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzdY(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzk(IObjectWrapper iObjectWrapper, zzbyh zzbyhVar) {
        this.zzd.zzb(zzbyhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzp(IObjectWrapper iObjectWrapper) {
        this.zzd.zzb(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzg(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzf(IObjectWrapper iObjectWrapper, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbyg
    public final void zzm(IObjectWrapper iObjectWrapper, int i2) {
    }
}
