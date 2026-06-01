package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.ironsource.Mf;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdwv {
    private final zzbmx zza;

    public zzdwv(zzbmx zzbmxVar) {
        this.zza = zzbmxVar;
    }

    private final void zzs(zzdwu zzdwuVar) throws RemoteException {
        String strZza = zzdwuVar.zza();
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdwu(MobileAdsBridgeBase.initializeMethodName, null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("creation", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("nativeObjectCreated");
        zzs(zzdwuVar);
    }

    public final void zzc(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("creation", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("nativeObjectNotCreated");
        zzs(zzdwuVar);
    }

    public final void zzd(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzdwuVar);
    }

    public final void zze(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc(Mf.j);
        zzs(zzdwuVar);
    }

    public final void zzf(long j, int i2) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdFailedToLoad");
        zzdwuVar.zzd(Integer.valueOf(i2));
        zzs(zzdwuVar);
    }

    public final void zzg(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc(Mf.f7242c);
        zzs(zzdwuVar);
    }

    public final void zzh(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc(Mf.f7244f);
        this.zza.zzb(zzdwuVar.zza());
    }

    public final void zzi(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("interstitial", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc(Mf.g);
        zzs(zzdwuVar);
    }

    public final void zzj(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzdwuVar);
    }

    public final void zzk(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdLoaded");
        zzs(zzdwuVar);
    }

    public final void zzl(long j, int i2) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdFailedToLoad");
        zzdwuVar.zzd(Integer.valueOf(i2));
        zzs(zzdwuVar);
    }

    public final void zzm(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdOpened");
        zzs(zzdwuVar);
    }

    public final void zzn(long j, int i2) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdFailedToShow");
        zzdwuVar.zzd(Integer.valueOf(i2));
        zzs(zzdwuVar);
    }

    public final void zzo(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdClosed");
        zzs(zzdwuVar);
    }

    public final void zzp(long j, zzbyl zzbylVar) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onUserEarnedReward");
        zzdwuVar.zze(zzbylVar.zze());
        zzdwuVar.zzf(Integer.valueOf(zzbylVar.zzf()));
        zzs(zzdwuVar);
    }

    public final void zzq(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdImpression");
        zzs(zzdwuVar);
    }

    public final void zzr(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc(Mf.f7244f);
        zzs(zzdwuVar);
    }
}
