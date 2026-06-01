package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdzd extends RewardedAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdzl zzb;

    public zzdzd(zzdzl zzdzlVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdzlVar);
        this.zzb = zzdzlVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
        this.zzb.zzg(zzdzl.zzm(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(@NonNull RewardedAd rewardedAd) {
        this.zzb.zzf(this.zza, rewardedAd);
    }
}
