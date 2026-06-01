package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzaj;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbmx;
import com.google.android.gms.internal.ads.zzbna;
import com.google.android.gms.internal.ads.zzbrj;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvi;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzbyo;
import com.google.android.gms.internal.ads.zzcas;
import com.google.android.gms.internal.ads.zzcjn;
import com.google.android.gms.internal.ads.zzdmj;
import com.google.android.gms.internal.ads.zzdml;
import com.google.android.gms.internal.ads.zzdwz;
import com.google.android.gms.internal.ads.zzenv;
import com.google.android.gms.internal.ads.zzfax;
import com.google.android.gms.internal.ads.zzfck;
import com.google.android.gms.internal.ads.zzfea;
import com.google.android.gms.internal.ads.zzffn;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ClientApi extends zzcq {
    @KeepForSdk
    public ClientApi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzb(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfck zzfckVarZzj = zzcjn.zza(context, zzbrjVar, i2).zzj();
        zzfckVarZzj.zzd(context);
        zzfckVarZzj.zzb(zzrVar);
        zzfckVarZzj.zzc(str);
        return zzfckVarZzj.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfea zzfeaVarZzn = zzcjn.zza(context, zzbrjVar, i2).zzn();
        zzfeaVarZzn.zzd(context);
        zzfeaVarZzn.zzb(zzrVar);
        zzfeaVarZzn.zzc(str);
        return zzfeaVarZzn.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt zzd(IObjectWrapper iObjectWrapper, String str, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzenv(zzcjn.zza(context, zzbrjVar, i2), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbim zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdml((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbxy zzf(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzffn zzffnVarZzq = zzcjn.zza(context, zzbrjVar, i2).zzq();
        zzffnVarZzq.zzc(context);
        return zzffnVarZzq.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbvi zzg(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new zzw(activity);
        }
        int i2 = adOverlayInfoParcelZza.zzk;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? new zzw(activity) : new zzag(activity) : new zzac(activity, adOverlayInfoParcelZza) : new zzaj(activity) : new zzai(activity) : new zzv(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck zzh(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2) {
        return zzcjn.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrjVar, i2).zzf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb zzi(IObjectWrapper iObjectWrapper, int i2) {
        return zzcjn.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i2).zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i2) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i2, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbis zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdmj((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbyo zzl(IObjectWrapper iObjectWrapper, String str, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzffn zzffnVarZzq = zzcjn.zza(context, zzbrjVar, i2).zzq();
        zzffnVarZzq.zzc(context);
        zzffnVarZzq.zzb(str);
        return zzffnVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzm(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbrj zzbrjVar, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfax zzfaxVarZzl = zzcjn.zza(context, zzbrjVar, i2).zzl();
        zzfaxVarZzl.zzb(str);
        zzfaxVarZzl.zzc(context);
        return zzfaxVarZzl.zza().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzcas zzn(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2) {
        return zzcjn.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrjVar, i2).zzs();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbvb zzo(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2) {
        return zzcjn.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrjVar, i2).zzu();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbna zzp(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2, zzbmx zzbmxVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdwz zzdwzVarZzA = zzcjn.zza(context, zzbrjVar, i2).zzA();
        zzdwzVarZzA.zzc(context);
        zzdwzVarZzA.zzb(zzbmxVar);
        return zzdwzVarZzA.zza().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw zzq(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i2) {
        return zzcjn.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrjVar, i2).zzC();
    }
}
