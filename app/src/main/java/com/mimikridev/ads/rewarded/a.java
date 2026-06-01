package com.mimikridev.ads.rewarded;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.mimikridev.ads.listener.OnRewardedAdCompleteListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements OnUserEarnedRewardListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RewardedAd f10687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OnRewardedAdCompleteListener f10688c;

    public /* synthetic */ a(RewardedAd rewardedAd, OnRewardedAdCompleteListener onRewardedAdCompleteListener, int i2) {
        this.f10686a = i2;
        this.f10687b = rewardedAd;
        this.f10688c = onRewardedAdCompleteListener;
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public final void onUserEarnedReward(RewardItem rewardItem) {
        switch (this.f10686a) {
            case 0:
                this.f10687b.lambda$showRewardedAd$0(this.f10688c, rewardItem);
                break;
            default:
                this.f10687b.lambda$showRewardedBackupAd$1(this.f10688c, rewardItem);
                break;
        }
    }
}
