package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbzh extends zzbyu {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbzi zzb;

    public zzbzh(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbzi zzbziVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zze() {
        zzbzi zzbziVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzbziVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzbziVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzf(int i2) {
    }
}
