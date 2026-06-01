package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzbwf;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaw extends zzba {
    final /* synthetic */ FrameLayout zza;
    final /* synthetic */ FrameLayout zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ zzaz zzd;

    public zzaw(zzaz zzazVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
        Objects.requireNonNull(zzazVar);
        this.zzd = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzm(this.zzc, "native_ad_view_delegate");
        return new zzfn();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        Context context = this.zzc;
        zzbeu.zza(context);
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzlI)).booleanValue()) {
            zzaz zzazVar = this.zzd;
            return zzazVar.zzq().zza(this.zzc, this.zza, this.zzb);
        }
        try {
            return zzbil.zzdK(((zzbip) com.google.android.gms.ads.internal.util.client.zzs.zza(context, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzav.zza)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ModuleDescriptor.MODULE_VERSION));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzd;
            zzazVar2.zzu(zzbwf.zza(this.zzc));
            zzazVar2.zzt().zzh(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }
}
