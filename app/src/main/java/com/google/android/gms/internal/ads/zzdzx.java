package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdzx implements zzdbu, zzdhh, zzdac {
    private final Context zza;
    private final zzdvi zzb;

    public zzdzx(Context context, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = zzdviVar;
    }

    private final void zzf(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfi)).booleanValue()) {
            zzcbv.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc(context);
                }
            });
        }
    }

    public final /* synthetic */ void zzc(Context context) {
        com.google.android.gms.ads.internal.zzt.zzn().zza(context, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zzd(@Nullable com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfl)).booleanValue()) {
            zzf(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdT(zzbxj zzbxjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfk)).booleanValue()) {
            zzf(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfm)).booleanValue()) {
            zzf(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdU(zzfgf zzfgfVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zze(@Nullable String str) {
    }
}
