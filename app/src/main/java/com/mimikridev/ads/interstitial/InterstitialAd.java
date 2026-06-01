package com.mimikridev.ads.interstitial;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.ironsource.C2300e4;
import com.ironsource.Mf;
import com.mimikridev.ads.listener.OnInterstitialAdDismissedListener;
import com.mimikridev.ads.listener.OnInterstitialAdErrorListener;
import com.mimikridev.ads.listener.OnInterstitialAdLoadedListener;
import com.mimikridev.ads.listener.OnInterstitialAdShowedListener;
import com.mimikridev.ads.util.Constant;
import com.mimikridev.ads.util.Tools;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InterstitialAd {
    private static final String TAG = "AdNetwork";
    private Activity activity;
    private AdManagerInterstitialAd adManagerInterstitialAd;
    private com.google.android.gms.ads.interstitial.InterstitialAd adMobInterstitialAd;
    private com.facebook.ads.InterstitialAd fanInterstitialAd;
    private LevelPlayInterstitialAd ironSourceInterstitialAd;
    private OnInterstitialAdDismissedListener onInterstitialAdDismissedListener;
    private PAGInterstitialAd pangleInterstitialAd;
    private int retryAttempt;
    private int counter = 1;
    private String adStatus = "";
    private String adNetwork = "";
    private String backupAdNetwork = "";
    private String adMobInterstitialId = "";
    private String googleAdManagerInterstitialId = "";
    private String fanInterstitialId = "";
    private String unityInterstitialId = "";
    private String appLovinInterstitialId = "";
    private String appLovinInterstitialZoneId = "";
    private String ironSourceInterstitialId = "";
    private String pangleInterstitialId = "";
    private int placementStatus = 1;
    private int interval = 1;
    private boolean legacyGDPR = false;
    private boolean withListener = false;
    private boolean isAdShowing = false;
    private boolean isAdReady = false;

    public InterstitialAd(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void loadBackupInterstitialAd() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.backupAdNetwork;
        switch (str.hashCode()) {
            case -995541405:
                if (str.equals(Constant.PANGLE)) {
                    PAGInterstitialAd.loadAd(this.pangleInterstitialId, new PAGInterstitialRequest(), new PAGInterstitialAdLoadListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.8
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i2, String str2) {
                            InterstitialAd.this.isAdReady = false;
                            InterstitialAd.this.pangleInterstitialAd = null;
                            Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.backupAdNetwork + "] [backup] Failed: " + i2 + " : " + str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                            InterstitialAd.this.isAdReady = true;
                            InterstitialAd.this.pangleInterstitialAd = pAGInterstitialAd;
                            InterstitialAd.this.pangleInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.8.1
                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdDismissed() {
                                    InterstitialAd.this.loadInterstitialAd();
                                    if (InterstitialAd.this.withListener && InterstitialAd.this.onInterstitialAdDismissedListener != null) {
                                        InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                                    }
                                    Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.backupAdNetwork + "] [backup] Interstitial Ad Dismissed");
                                }

                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdClicked() {
                                }

                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdShowed() {
                                }
                            });
                            Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.backupAdNetwork + "] [backup] Interstitial Ad Loaded");
                        }
                    });
                }
                break;
            case -927389981:
                if (str.equals(Constant.IRONSOURCE)) {
                    LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(this.ironSourceInterstitialId);
                    this.ironSourceInterstitialAd = levelPlayInterstitialAd;
                    levelPlayInterstitialAd.setListener(new LevelPlayInterstitialAdListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.7
                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial clicked");
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial closed");
                            InterstitialAd.this.loadInterstitialAd();
                            if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                                return;
                            }
                            InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial display failed");
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial displayed");
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial info changed");
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial failed");
                            InterstitialAd.this.ironSourceInterstitialAd = null;
                            InterstitialAd.this.isAdReady = false;
                        }

                        @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                        public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                            Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial loaded");
                            InterstitialAd.this.isAdReady = true;
                        }
                    });
                    this.ironSourceInterstitialAd.loadAd();
                }
                break;
            case 3387192:
                str.equals("none");
                break;
            case 92668925:
                if (str.equals(Constant.ADMOB)) {
                    Activity activity = this.activity;
                    com.google.android.gms.ads.interstitial.InterstitialAd.load(activity, this.adMobInterstitialId, Tools.getAdRequest(activity, Boolean.valueOf(this.legacyGDPR)), new InterstitialAdLoadCallback() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.5
                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.i(InterstitialAd.TAG, loadAdError.getMessage());
                            InterstitialAd.this.isAdReady = false;
                            InterstitialAd.this.adMobInterstitialAd = null;
                            Log.d(InterstitialAd.TAG, "Failed load AdMob Interstitial Ad");
                        }

                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                            InterstitialAd.this.isAdReady = true;
                            InterstitialAd.this.adMobInterstitialAd = interstitialAd;
                            InterstitialAd.this.adMobInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.5.1
                                @Override // com.google.android.gms.ads.FullScreenContentCallback
                                public void onAdDismissedFullScreenContent() {
                                    InterstitialAd.this.loadInterstitialAd();
                                    if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                                        return;
                                    }
                                    InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                                }

                                @Override // com.google.android.gms.ads.FullScreenContentCallback
                                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                    Log.d(InterstitialAd.TAG, "The ad failed to show.");
                                }

                                @Override // com.google.android.gms.ads.FullScreenContentCallback
                                public void onAdShowedFullScreenContent() {
                                    InterstitialAd.this.adMobInterstitialAd = null;
                                    Log.d(InterstitialAd.TAG, "The ad was shown.");
                                }
                            });
                            Log.i(InterstitialAd.TAG, Mf.j);
                        }
                    });
                }
                break;
            case 497130182:
                if (str.equals(Constant.FACEBOOK)) {
                    this.fanInterstitialAd = new com.facebook.ads.InterstitialAd(this.activity, this.fanInterstitialId);
                    this.fanInterstitialAd.loadAd(this.fanInterstitialAd.buildLoadAdConfig().withAdListener(new InterstitialAdListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.6
                        @Override // com.facebook.ads.AdListener
                        public void onAdLoaded(Ad ad) {
                            Log.d(InterstitialAd.TAG, "FAN Interstitial is loaded");
                            InterstitialAd.this.isAdReady = true;
                        }

                        @Override // com.facebook.ads.AdListener
                        public void onError(Ad ad, com.facebook.ads.AdError adError) {
                            InterstitialAd.this.isAdReady = false;
                        }

                        @Override // com.facebook.ads.InterstitialAdListener
                        public void onInterstitialDismissed(Ad ad) {
                            InterstitialAd.this.fanInterstitialAd.loadAd();
                            if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                                return;
                            }
                            InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                        }

                        @Override // com.facebook.ads.AdListener
                        public void onAdClicked(Ad ad) {
                        }

                        @Override // com.facebook.ads.InterstitialAdListener
                        public void onInterstitialDisplayed(Ad ad) {
                        }

                        @Override // com.facebook.ads.AdListener
                        public void onLoggingImpression(Ad ad) {
                        }
                    }).build());
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterstitialAd() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        String str = this.adNetwork;
        str.getClass();
        switch (str) {
            case "pangle":
                PAGInterstitialAd.loadAd(this.pangleInterstitialId, new PAGInterstitialRequest(), new PAGInterstitialAdLoadListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.4
                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                    public void onError(int i2, String str2) {
                        InterstitialAd.this.isAdReady = false;
                        InterstitialAd.this.loadBackupInterstitialAd();
                        InterstitialAd.this.pangleInterstitialAd = null;
                        Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.adNetwork + "] Failed: " + i2 + " : " + str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                    public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                        InterstitialAd.this.isAdReady = true;
                        InterstitialAd.this.pangleInterstitialAd = pAGInterstitialAd;
                        InterstitialAd.this.pangleInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.4.1
                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdDismissed() {
                                InterstitialAd.this.loadInterstitialAd();
                                if (InterstitialAd.this.withListener && InterstitialAd.this.onInterstitialAdDismissedListener != null) {
                                    InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                                }
                                Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.adNetwork + "] Interstitial Ad Dismissed");
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdClicked() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                            public void onAdShowed() {
                            }
                        });
                        Log.d(InterstitialAd.TAG, C2300e4.i.f8403d + InterstitialAd.this.adNetwork + "] Interstitial Ad Loaded");
                    }
                });
                break;
            case "ironsource":
                LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(this.ironSourceInterstitialId);
                this.ironSourceInterstitialAd = levelPlayInterstitialAd;
                levelPlayInterstitialAd.setListener(new LevelPlayInterstitialAdListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.3
                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdClicked(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial clicked");
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial closed");
                        InterstitialAd.this.loadInterstitialAd();
                        if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                            return;
                        }
                        InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial display failed");
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial displayed");
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial info changed");
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                        InterstitialAd.this.isAdReady = false;
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial failed");
                        InterstitialAd.this.ironSourceInterstitialAd = null;
                        InterstitialAd.this.loadBackupInterstitialAd();
                    }

                    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
                    public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(InterstitialAd.TAG, "[Ironsource] Interstitial loaded");
                        InterstitialAd.this.isAdReady = true;
                    }
                });
                this.ironSourceInterstitialAd.loadAd();
                break;
            case "admob":
                Activity activity = this.activity;
                com.google.android.gms.ads.interstitial.InterstitialAd.load(activity, this.adMobInterstitialId, Tools.getAdRequest(activity, Boolean.valueOf(this.legacyGDPR)), new InterstitialAdLoadCallback() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.1
                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.i(InterstitialAd.TAG, loadAdError.getMessage());
                        InterstitialAd.this.isAdReady = false;
                        InterstitialAd.this.adMobInterstitialAd = null;
                        InterstitialAd.this.loadBackupInterstitialAd();
                        Log.d(InterstitialAd.TAG, "Failed load AdMob Interstitial Ad");
                    }

                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                        InterstitialAd.this.adMobInterstitialAd = interstitialAd;
                        InterstitialAd.this.isAdReady = true;
                        InterstitialAd.this.adMobInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.1.1
                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdDismissedFullScreenContent() {
                                InterstitialAd.this.loadInterstitialAd();
                                if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                                    return;
                                }
                                InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                Log.d(InterstitialAd.TAG, "The ad failed to show.");
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void onAdShowedFullScreenContent() {
                                InterstitialAd.this.adMobInterstitialAd = null;
                                Log.d(InterstitialAd.TAG, "The ad was shown.");
                            }
                        });
                        Log.i(InterstitialAd.TAG, Mf.j);
                    }
                });
                break;
            case "facebook":
                this.fanInterstitialAd = new com.facebook.ads.InterstitialAd(this.activity, this.fanInterstitialId);
                this.fanInterstitialAd.loadAd(this.fanInterstitialAd.buildLoadAdConfig().withAdListener(new InterstitialAdListener() { // from class: com.mimikridev.ads.interstitial.InterstitialAd.2
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        Log.d(InterstitialAd.TAG, "FAN Interstitial is loaded");
                        InterstitialAd.this.isAdReady = true;
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, com.facebook.ads.AdError adError) {
                        InterstitialAd.this.isAdReady = false;
                    }

                    @Override // com.facebook.ads.InterstitialAdListener
                    public void onInterstitialDismissed(Ad ad) {
                        InterstitialAd.this.fanInterstitialAd.loadAd();
                        if (!InterstitialAd.this.withListener || InterstitialAd.this.onInterstitialAdDismissedListener == null) {
                            return;
                        }
                        InterstitialAd.this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.InterstitialAdListener
                    public void onInterstitialDisplayed(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }
                }).build());
                break;
        }
    }

    private void showBackupInterstitialAd() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        Log.d(TAG, "Show Backup Interstitial Ad [" + this.backupAdNetwork.toUpperCase() + C2300e4.i.e);
        String str = this.backupAdNetwork;
        str.getClass();
        switch (str) {
            case "pangle":
                PAGInterstitialAd pAGInterstitialAd = this.pangleInterstitialAd;
                if (pAGInterstitialAd != null) {
                    pAGInterstitialAd.show(this.activity);
                    this.isAdReady = false;
                    break;
                } else {
                    if (this.withListener) {
                        this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }
                    break;
                }
                break;
            case "ironsource":
                LevelPlayInterstitialAd levelPlayInterstitialAd = this.ironSourceInterstitialAd;
                if (levelPlayInterstitialAd == null || !levelPlayInterstitialAd.isAdReady()) {
                    Log.d(TAG, "[Ironsource] Interstitial not available, trying backup");
                    if (this.withListener) {
                        this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }
                    break;
                } else {
                    this.ironSourceInterstitialAd.showAd(this.activity);
                    this.isAdReady = false;
                    Log.d(TAG, "[Ironsource] Showing interstitial ad");
                    break;
                }
                break;
            case "none":
                if (this.withListener) {
                    this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    break;
                }
                break;
            case "admob":
                com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd = this.adMobInterstitialAd;
                if (interstitialAd != null) {
                    interstitialAd.show(this.activity);
                    this.isAdReady = false;
                    break;
                } else {
                    if (this.withListener) {
                        this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }
                    break;
                }
                break;
            case "facebook":
                com.facebook.ads.InterstitialAd interstitialAd2 = this.fanInterstitialAd;
                if (interstitialAd2 == null || !interstitialAd2.isAdLoaded()) {
                    if (this.withListener) {
                        this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                    }
                    break;
                } else {
                    this.fanInterstitialAd.show();
                    this.isAdReady = false;
                    break;
                }
                break;
        }
    }

    private void showInterstitialAd() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        int i2 = this.counter;
        if (i2 == this.interval) {
            String str = this.adNetwork;
            str.getClass();
            switch (str) {
                case "pangle":
                    PAGInterstitialAd pAGInterstitialAd = this.pangleInterstitialAd;
                    if (pAGInterstitialAd == null) {
                        showBackupInterstitialAd();
                        Log.d(TAG, "Pangle Interstitial Null");
                        break;
                    } else {
                        pAGInterstitialAd.show(this.activity);
                        this.isAdReady = false;
                        Log.d(TAG, "Show Pangle Interstitial Ad");
                        break;
                    }
                    break;
                case "ironsource":
                    LevelPlayInterstitialAd levelPlayInterstitialAd = this.ironSourceInterstitialAd;
                    if (levelPlayInterstitialAd != null && levelPlayInterstitialAd.isAdReady()) {
                        this.ironSourceInterstitialAd.showAd(this.activity);
                        Log.d(TAG, "[Ironsource] Showing interstitial ad");
                        this.isAdReady = false;
                        break;
                    } else {
                        Log.d(TAG, "[Ironsource] Interstitial not available, trying backup");
                        showBackupInterstitialAd();
                        break;
                    }
                    break;
                case "admob":
                    com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd = this.adMobInterstitialAd;
                    if (interstitialAd == null) {
                        showBackupInterstitialAd();
                        Log.d(TAG, "admob interstitial null");
                        break;
                    } else {
                        interstitialAd.show(this.activity);
                        this.isAdReady = false;
                        Log.d(TAG, "admob interstitial not null");
                        break;
                    }
                    break;
                case "facebook":
                    com.facebook.ads.InterstitialAd interstitialAd2 = this.fanInterstitialAd;
                    if (interstitialAd2 != null && interstitialAd2.isAdLoaded()) {
                        this.fanInterstitialAd.show();
                        this.isAdReady = false;
                        Log.d(TAG, "fan interstitial not null");
                        break;
                    } else {
                        showBackupInterstitialAd();
                        Log.d(TAG, "fan interstitial null");
                        break;
                    }
                    break;
                default:
                    if (this.withListener) {
                        this.onInterstitialAdDismissedListener.onInterstitialAdDismissed();
                        break;
                    }
                    break;
            }
            this.counter = 1;
        } else {
            this.counter = i2 + 1;
        }
        Log.d(TAG, "Current counter : " + this.counter);
    }

    public InterstitialAd build() {
        loadInterstitialAd();
        return this;
    }

    public boolean isAdReady() {
        return this.isAdReady;
    }

    public InterstitialAd setAdMobInterstitialId(String str) {
        this.adMobInterstitialId = str;
        return this;
    }

    public InterstitialAd setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public InterstitialAd setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public InterstitialAd setAppLovinInterstitialId(String str) {
        this.appLovinInterstitialId = str;
        return this;
    }

    public InterstitialAd setAppLovinInterstitialZoneId(String str) {
        this.appLovinInterstitialZoneId = str;
        return this;
    }

    public InterstitialAd setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public InterstitialAd setFanInterstitialId(String str) {
        this.fanInterstitialId = str;
        return this;
    }

    public InterstitialAd setGoogleAdManagerInterstitialId(String str) {
        this.googleAdManagerInterstitialId = str;
        return this;
    }

    public InterstitialAd setInterval(int i2) {
        this.interval = i2;
        return this;
    }

    public InterstitialAd setIronSourceInterstitialId(String str) {
        this.ironSourceInterstitialId = str;
        return this;
    }

    public InterstitialAd setLegacyGDPR(boolean z2) {
        this.legacyGDPR = z2;
        return this;
    }

    public InterstitialAd setPangleInterstitialId(String str) {
        this.pangleInterstitialId = str;
        return this;
    }

    public InterstitialAd setPlacementStatus(int i2) {
        this.placementStatus = i2;
        return this;
    }

    public InterstitialAd setUnityInterstitialId(String str) {
        this.unityInterstitialId = str;
        return this;
    }

    public InterstitialAd setWithListener(boolean z2, OnInterstitialAdDismissedListener onInterstitialAdDismissedListener, OnInterstitialAdShowedListener onInterstitialAdShowedListener, OnInterstitialAdErrorListener onInterstitialAdErrorListener, OnInterstitialAdLoadedListener onInterstitialAdLoadedListener) {
        this.withListener = z2;
        this.onInterstitialAdDismissedListener = onInterstitialAdDismissedListener;
        return this;
    }

    public void show() {
        showInterstitialAd();
    }

    public void updateActivity(Activity activity) {
        this.activity = activity;
    }
}
