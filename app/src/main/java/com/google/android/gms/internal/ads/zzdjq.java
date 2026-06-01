package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdz;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdjq implements zzcyo, zzdga {
    private final zzcac zza;
    private final Context zzb;
    private final zzcaf zzc;

    @Nullable
    private final View zzd;
    private String zze;
    private final zzbdz.zza.EnumC0130zza zzf;

    public zzdjq(zzcac zzcacVar, Context context, zzcaf zzcafVar, @Nullable View view, zzbdz.zza.EnumC0130zza enumC0130zza) {
        this.zza = zzcacVar;
        this.zzb = context;
        this.zzc = zzcafVar;
        this.zzd = view;
        this.zzf = enumC0130zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzd(zzbxv zzbxvVar, String str, String str2) {
        zzcaf zzcafVar = this.zzc;
        Context context = this.zzb;
        if (zzcafVar.zza(context)) {
            try {
                zzcafVar.zzo(context, zzcafVar.zzj(context), this.zza.zzb(), zzbxvVar.zzb(), zzbxvVar.zzc());
            } catch (RemoteException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Remote Exception to get reward item.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdx() {
        this.zza.zza(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdy() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzg(view.getContext(), this.zze);
        }
        this.zza.zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzh() {
        zzbdz.zza.EnumC0130zza enumC0130zza = this.zzf;
        if (enumC0130zza == zzbdz.zza.EnumC0130zza.APP_OPEN) {
            return;
        }
        String strZzf = this.zzc.zzf(this.zzb);
        this.zze = strZzf;
        this.zze = String.valueOf(strZzf).concat(enumC0130zza == zzbdz.zza.EnumC0130zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzdO() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzg() {
    }
}
