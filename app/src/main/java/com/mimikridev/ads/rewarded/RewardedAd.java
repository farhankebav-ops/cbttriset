package com.mimikridev.ads.rewarded;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.facebook.ads.Ad;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.C2300e4;
import com.mimikridev.ads.listener.OnRewardedAdCompleteListener;
import com.mimikridev.ads.listener.OnRewardedAdDismissedListener;
import com.mimikridev.ads.listener.OnRewardedAdErrorListener;
import com.mimikridev.ads.util.Constant;
import com.mimikridev.ads.util.Tools;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAd;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class RewardedAd {
    private static final String TAG = "SoloRewarded";
    private Activity activity;
    private com.google.android.gms.ads.rewarded.RewardedAd adManagerRewardedAd;
    private com.google.android.gms.ads.rewarded.RewardedAd adMobRewardedAd;
    private RewardedVideoAd fanRewardedVideoAd;
    private LevelPlayRewardedAd ironSourceRewardedAd;
    private PAGRewardedAd pangleRewardedAd;
    private String adStatus = "";
    private String mainAds = "";
    private String backupAds = "";
    private String adMobRewardedId = "";
    private String adManagerRewardedId = "";
    private String fanRewardedId = "";
    private String unityRewardedId = "";
    private String applovinMaxRewardedId = "";
    private String applovinDiscRewardedZoneId = "";
    private String ironSourceRewardedId = "";
    private String pangleRewardedId = "";
    private int placementStatus = 1;
    private boolean legacyGDPR = false;
    private boolean isAdReady = false;

    public RewardedAd(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardedAd$0(OnRewardedAdCompleteListener onRewardedAdCompleteListener, RewardItem rewardItem) {
        onRewardedAdCompleteListener.onRewardedAdComplete();
        this.isAdReady = false;
        Log.d(TAG, "The user earned the reward.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardedBackupAd$1(OnRewardedAdCompleteListener onRewardedAdCompleteListener, RewardItem rewardItem) {
        onRewardedAdCompleteListener.onRewardedAdComplete();
        this.isAdReady = false;
        Log.d(TAG, "The user earned the reward.");
    }

    public RewardedAd build(OnRewardedAdCompleteListener onRewardedAdCompleteListener, OnRewardedAdDismissedListener onRewardedAdDismissedListener) {
        loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
        return this;
    }

    public void destroyRewardedAd() {
        RewardedVideoAd rewardedVideoAd;
        RewardedVideoAd rewardedVideoAd2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.mainAds;
        str.getClass();
        if (str.equals(Constant.FACEBOOK) && (rewardedVideoAd2 = this.fanRewardedVideoAd) != null) {
            rewardedVideoAd2.destroy();
            this.fanRewardedVideoAd = null;
        }
        String str2 = this.backupAds;
        str2.getClass();
        if (str2.equals(Constant.FACEBOOK) && (rewardedVideoAd = this.fanRewardedVideoAd) != null) {
            rewardedVideoAd.destroy();
            this.fanRewardedVideoAd = null;
        }
    }

    public boolean isAdReady() {
        return this.isAdReady;
    }

    public void loadRewardedAd(final OnRewardedAdCompleteListener onRewardedAdCompleteListener, final OnRewardedAdDismissedListener onRewardedAdDismissedListener) {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.mainAds;
        str.getClass();
        switch (str) {
            case "pangle":
                PAGRewardedAd.loadAd(this.pangleRewardedId, new PAGRewardedRequest(), new PAGRewardedAdLoadListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.4
                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                    public void onError(int i2, String str2) {
                        RewardedAd.this.isAdReady = false;
                        RewardedAd.this.pangleRewardedAd = null;
                        RewardedAd.this.loadRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad error: " + i2 + " : " + str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                    public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                        RewardedAd.this.isAdReady = true;
                        RewardedAd.this.pangleRewardedAd = pAGRewardedAd;
                        RewardedAd.this.pangleRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.4.1
                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdDismissed() {
                                RewardedAd.this.pangleRewardedAd = null;
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                                onRewardedAdDismissedListener.onRewardedAdDismissed();
                                Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad dismissed");
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
                            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                                onRewardedAdCompleteListener.onRewardedAdComplete();
                                Log.d(RewardedAd.TAG, "The user earned the reward.");
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdClicked() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdShowed() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
                            public void onUserEarnedRewardFail(int i2, String str2) {
                            }
                        });
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad loaded");
                    }
                });
                break;
            case "ironsource":
                LevelPlayRewardedAd levelPlayRewardedAd = new LevelPlayRewardedAd(this.ironSourceRewardedId);
                this.ironSourceRewardedAd = levelPlayRewardedAd;
                levelPlayRewardedAd.setListener(new LevelPlayRewardedAdListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.3
                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video clicked");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video closed");
                        RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                        Log.e(RewardedAd.TAG, "[IronSource] Rewarded show failed: " + levelPlayAdError.getErrorMessage());
                        RewardedAd.this.loadRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video displayed");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded info changed");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                        RewardedAd.this.isAdReady = false;
                        Log.e(RewardedAd.TAG, "[IronSource] Rewarded load failed: " + levelPlayAdError.getErrorMessage());
                        RewardedAd.this.loadRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                        RewardedAd.this.isAdReady = true;
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video loaded");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdRewarded(LevelPlayReward levelPlayReward, LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Reward granted: " + levelPlayReward.getAmount() + " " + levelPlayReward.getName());
                        OnRewardedAdCompleteListener onRewardedAdCompleteListener2 = onRewardedAdCompleteListener;
                        if (onRewardedAdCompleteListener2 != null) {
                            onRewardedAdCompleteListener2.onRewardedAdComplete();
                        }
                    }
                });
                this.ironSourceRewardedAd.loadAd();
                break;
            case "admob":
                Activity activity = this.activity;
                com.google.android.gms.ads.rewarded.RewardedAd.load(activity, this.adMobRewardedId, Tools.getAdRequest(activity, Boolean.valueOf(this.legacyGDPR)), new RewardedAdLoadCallback() { // from class: com.mimikridev.ads.rewarded.RewardedAd.1
                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d(RewardedAd.TAG, loadAdError.toString());
                        RewardedAd.this.isAdReady = false;
                        RewardedAd.this.adMobRewardedAd = null;
                        RewardedAd.this.loadRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] failed to load rewarded ad: " + loadAdError.getMessage() + ", try to load backup ad: " + RewardedAd.this.backupAds);
                    }

                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdLoaded(@NonNull com.google.android.gms.ads.rewarded.RewardedAd rewardedAd) {
                        RewardedAd.this.adMobRewardedAd = rewardedAd;
                        RewardedAd.this.isAdReady = true;
                        RewardedAd.this.adMobRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.rewarded.RewardedAd.1.1
                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                RewardedAd.this.adMobRewardedAd = null;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                                onRewardedAdDismissedListener.onRewardedAdDismissed();
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                RewardedAd.this.adMobRewardedAd = null;
                            }
                        });
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad loaded");
                    }
                });
                break;
            case "facebook":
                RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(this.activity, this.fanRewardedId);
                this.fanRewardedVideoAd = rewardedVideoAd;
                rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(new RewardedVideoAdListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.2
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        RewardedAd.this.isAdReady = true;
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad loaded");
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                        RewardedAd.this.isAdReady = false;
                        RewardedAd.this.loadRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] failed to load rewarded ad: " + RewardedAd.this.fanRewardedId + ", try to load backup ad: " + RewardedAd.this.backupAds);
                    }

                    @Override // com.facebook.ads.RewardedVideoAdListener
                    public void onRewardedVideoClosed() {
                        RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                        onRewardedAdDismissedListener.onRewardedAdDismissed();
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad closed");
                    }

                    @Override // com.facebook.ads.RewardedVideoAdListener
                    public void onRewardedVideoCompleted() {
                        onRewardedAdCompleteListener.onRewardedAdComplete();
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.mainAds + "] rewarded ad complete");
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }
                }).build());
                break;
        }
    }

    public void loadRewardedBackupAd(final OnRewardedAdCompleteListener onRewardedAdCompleteListener, final OnRewardedAdDismissedListener onRewardedAdDismissedListener) {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.backupAds;
        str.getClass();
        switch (str) {
            case "pangle":
                PAGRewardedAd.loadAd(this.pangleRewardedId, new PAGRewardedRequest(), new PAGRewardedAdLoadListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.8
                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                    public void onError(int i2, String str2) {
                        RewardedAd.this.pangleRewardedAd = null;
                        RewardedAd.this.isAdReady = false;
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad error: " + i2 + " : " + str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                    public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                        RewardedAd.this.isAdReady = true;
                        RewardedAd.this.pangleRewardedAd = pAGRewardedAd;
                        RewardedAd.this.pangleRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.8.1
                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdDismissed() {
                                RewardedAd.this.pangleRewardedAd = null;
                                AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                                onRewardedAdDismissedListener.onRewardedAdDismissed();
                                Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] reward ad dismissed");
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
                            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                                onRewardedAdCompleteListener.onRewardedAdComplete();
                                Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] The user earned the reward.");
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdClicked() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdShowed() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
                            public void onUserEarnedRewardFail(int i2, String str2) {
                            }
                        });
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad loaded");
                    }
                });
                break;
            case "ironsource":
                LevelPlayRewardedAd levelPlayRewardedAd = new LevelPlayRewardedAd(this.ironSourceRewardedId);
                this.ironSourceRewardedAd = levelPlayRewardedAd;
                levelPlayRewardedAd.setListener(new LevelPlayRewardedAdListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.7
                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video clicked");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video closed");
                        RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                        Log.e(RewardedAd.TAG, "[IronSource] Rewarded show failed: " + levelPlayAdError.getErrorMessage());
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video displayed");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded info changed");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                        RewardedAd.this.isAdReady = false;
                        Log.e(RewardedAd.TAG, "[IronSource] Rewarded load failed: " + levelPlayAdError.getErrorMessage());
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                        RewardedAd.this.isAdReady = true;
                        Log.d(RewardedAd.TAG, "[IronSource] Rewarded video loaded");
                    }

                    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
                    public void onAdRewarded(LevelPlayReward levelPlayReward, LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(RewardedAd.TAG, "[IronSource] Reward granted: " + levelPlayReward.getAmount() + " " + levelPlayReward.getName());
                        OnRewardedAdCompleteListener onRewardedAdCompleteListener2 = onRewardedAdCompleteListener;
                        if (onRewardedAdCompleteListener2 != null) {
                            onRewardedAdCompleteListener2.onRewardedAdComplete();
                        }
                    }
                });
                this.ironSourceRewardedAd.loadAd();
                break;
            case "admob":
                Activity activity = this.activity;
                com.google.android.gms.ads.rewarded.RewardedAd.load(activity, this.adMobRewardedId, Tools.getAdRequest(activity, Boolean.valueOf(this.legacyGDPR)), new RewardedAdLoadCallback() { // from class: com.mimikridev.ads.rewarded.RewardedAd.5
                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d(RewardedAd.TAG, loadAdError.toString());
                        RewardedAd.this.isAdReady = false;
                        RewardedAd.this.adMobRewardedAd = null;
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] failed to load rewarded ad: " + loadAdError.getMessage() + ", try to load backup ad: " + RewardedAd.this.backupAds);
                    }

                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdLoaded(@NonNull com.google.android.gms.ads.rewarded.RewardedAd rewardedAd) {
                        RewardedAd.this.isAdReady = true;
                        RewardedAd.this.adMobRewardedAd = rewardedAd;
                        RewardedAd.this.adMobRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.rewarded.RewardedAd.5.1
                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                RewardedAd.this.adMobRewardedAd = null;
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                                onRewardedAdDismissedListener.onRewardedAdDismissed();
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                RewardedAd.this.adMobRewardedAd = null;
                            }
                        });
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad loaded");
                    }
                });
                break;
            case "facebook":
                RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(this.activity, this.fanRewardedId);
                this.fanRewardedVideoAd = rewardedVideoAd;
                rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(new RewardedVideoAdListener() { // from class: com.mimikridev.ads.rewarded.RewardedAd.6
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        RewardedAd.this.isAdReady = true;
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad loaded");
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                        RewardedAd.this.isAdReady = false;
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] failed to load rewarded ad: " + RewardedAd.this.fanRewardedId + ", try to load backup ad: " + RewardedAd.this.backupAds);
                    }

                    @Override // com.facebook.ads.RewardedVideoAdListener
                    public void onRewardedVideoClosed() {
                        RewardedAd.this.loadRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener);
                        onRewardedAdDismissedListener.onRewardedAdDismissed();
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad closed");
                    }

                    @Override // com.facebook.ads.RewardedVideoAdListener
                    public void onRewardedVideoCompleted() {
                        onRewardedAdCompleteListener.onRewardedAdComplete();
                        Log.d(RewardedAd.TAG, C2300e4.i.f8403d + RewardedAd.this.backupAds + "] [backup] rewarded ad complete");
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }
                }).build());
                break;
        }
    }

    public RewardedAd setAdManagerRewardedId(String str) {
        this.adManagerRewardedId = str;
        return this;
    }

    public RewardedAd setAdMobRewardedId(String str) {
        this.adMobRewardedId = str;
        return this;
    }

    public RewardedAd setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public RewardedAd setApplovinDiscRewardedZoneId(String str) {
        this.applovinDiscRewardedZoneId = str;
        return this;
    }

    public RewardedAd setApplovinMaxRewardedId(String str) {
        this.applovinMaxRewardedId = str;
        return this;
    }

    public RewardedAd setBackupAds(String str) {
        this.backupAds = str;
        return this;
    }

    public RewardedAd setFanRewardedId(String str) {
        this.fanRewardedId = str;
        return this;
    }

    public RewardedAd setIronSourceRewardedId(String str) {
        this.ironSourceRewardedId = str;
        return this;
    }

    public RewardedAd setLegacyGDPR(boolean z2) {
        this.legacyGDPR = z2;
        return this;
    }

    public RewardedAd setMainAds(String str) {
        this.mainAds = str;
        return this;
    }

    public RewardedAd setPangleRewardedId(String str) {
        this.pangleRewardedId = str;
        return this;
    }

    public RewardedAd setPlacementStatus(int i2) {
        this.placementStatus = i2;
        return this;
    }

    public RewardedAd setUnityRewardedId(String str) {
        this.unityRewardedId = str;
        return this;
    }

    public RewardedAd show(OnRewardedAdCompleteListener onRewardedAdCompleteListener, OnRewardedAdDismissedListener onRewardedAdDismissedListener, OnRewardedAdErrorListener onRewardedAdErrorListener) {
        showRewardedAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener, onRewardedAdErrorListener);
        return this;
    }

    public void showRewardedAd(OnRewardedAdCompleteListener onRewardedAdCompleteListener, OnRewardedAdDismissedListener onRewardedAdDismissedListener, OnRewardedAdErrorListener onRewardedAdErrorListener) {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.mainAds;
        str.getClass();
        i2 = 0;
        switch (str) {
            case "pangle":
                PAGRewardedAd pAGRewardedAd = this.pangleRewardedAd;
                if (pAGRewardedAd == null) {
                    onRewardedAdErrorListener.onRewardedAdError();
                    showRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener, onRewardedAdErrorListener);
                    break;
                } else {
                    pAGRewardedAd.show(this.activity);
                    this.isAdReady = false;
                    break;
                }
                break;
            case "ironsource":
                LevelPlayRewardedAd levelPlayRewardedAd = this.ironSourceRewardedAd;
                if (levelPlayRewardedAd != null && levelPlayRewardedAd.isAdReady()) {
                    this.ironSourceRewardedAd.showAd(this.activity);
                    this.isAdReady = false;
                    Log.d(TAG, "[IronSource] Showing rewarded ad");
                    break;
                } else {
                    Log.d(TAG, "[IronSource] Rewarded ad not available");
                    onRewardedAdErrorListener.onRewardedAdError();
                    showRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener, onRewardedAdErrorListener);
                    break;
                }
                break;
            case "admob":
                com.google.android.gms.ads.rewarded.RewardedAd rewardedAd = this.adMobRewardedAd;
                if (rewardedAd == null) {
                    showRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener, onRewardedAdErrorListener);
                    break;
                } else {
                    rewardedAd.show(this.activity, new a(this, onRewardedAdCompleteListener, i2));
                    break;
                }
                break;
            case "facebook":
                RewardedVideoAd rewardedVideoAd = this.fanRewardedVideoAd;
                if (rewardedVideoAd != null && rewardedVideoAd.isAdLoaded()) {
                    this.fanRewardedVideoAd.show();
                    this.isAdReady = false;
                    break;
                } else {
                    showRewardedBackupAd(onRewardedAdCompleteListener, onRewardedAdDismissedListener, onRewardedAdErrorListener);
                    break;
                }
                break;
            default:
                onRewardedAdErrorListener.onRewardedAdError();
                break;
        }
    }

    public void showRewardedBackupAd(OnRewardedAdCompleteListener onRewardedAdCompleteListener, OnRewardedAdDismissedListener onRewardedAdDismissedListener, OnRewardedAdErrorListener onRewardedAdErrorListener) {
        int i2;
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.backupAds;
        str.getClass();
        i2 = 1;
        switch (str) {
            case "pangle":
                PAGRewardedAd pAGRewardedAd = this.pangleRewardedAd;
                if (pAGRewardedAd == null) {
                    onRewardedAdErrorListener.onRewardedAdError();
                    break;
                } else {
                    pAGRewardedAd.show(this.activity);
                    this.isAdReady = false;
                    break;
                }
                break;
            case "ironsource":
                LevelPlayRewardedAd levelPlayRewardedAd = this.ironSourceRewardedAd;
                if (levelPlayRewardedAd != null && levelPlayRewardedAd.isAdReady()) {
                    this.ironSourceRewardedAd.showAd(this.activity);
                    this.isAdReady = false;
                    Log.d(TAG, "[IronSource] Showing rewarded ad");
                    break;
                } else {
                    Log.d(TAG, "[IronSource] Rewarded ad not available");
                    onRewardedAdErrorListener.onRewardedAdError();
                    break;
                }
                break;
            case "admob":
                com.google.android.gms.ads.rewarded.RewardedAd rewardedAd = this.adMobRewardedAd;
                if (rewardedAd == null) {
                    onRewardedAdErrorListener.onRewardedAdError();
                    break;
                } else {
                    rewardedAd.show(this.activity, new a(this, onRewardedAdCompleteListener, i2));
                    break;
                }
                break;
            case "facebook":
                RewardedVideoAd rewardedVideoAd = this.fanRewardedVideoAd;
                if (rewardedVideoAd != null && rewardedVideoAd.isAdLoaded()) {
                    this.fanRewardedVideoAd.show();
                    this.isAdReady = false;
                    break;
                } else {
                    onRewardedAdErrorListener.onRewardedAdError();
                    break;
                }
                break;
            default:
                onRewardedAdErrorListener.onRewardedAdError();
                break;
        }
    }

    public void updateActivity(Activity activity) {
        this.activity = activity;
    }
}
