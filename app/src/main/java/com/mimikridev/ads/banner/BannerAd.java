package com.mimikridev.ads.banner;

import android.app.Activity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.mimikridev.ads.R;
import com.mimikridev.ads.util.Constant;
import com.mimikridev.ads.util.Tools;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class BannerAd {
    private static final String TAG = "AdNetwork";
    private Activity activity;
    private AdManagerAdView adManagerAdView;
    private AdView adView;
    private com.facebook.ads.AdView fanAdView;
    private FrameLayout ironSourceBannerView;
    private LevelPlayBannerAdView levelPlayBannerAd;
    private String adStatus = "";
    private String adNetwork = "";
    private String backupAdNetwork = "";
    private String adMobBannerId = "";
    private String googleAdManagerBannerId = "";
    private String fanBannerId = "";
    private String unityBannerId = "";
    private String appLovinBannerId = "";
    private String appLovinBannerZoneId = "";
    private String ironSourceBannerId = "";
    private String pangleBannerId = "";
    private int placementStatus = 1;
    private boolean darkTheme = false;
    private boolean legacyGDPR = false;
    private boolean collapsibleBanner = false;

    public BannerAd(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBackupBannerAd$1(final FrameLayout frameLayout, final FrameLayout frameLayout2, final RelativeLayout relativeLayout) {
        AdView adView = new AdView(this.activity);
        this.adView = adView;
        adView.setAdUnitId(this.adMobBannerId);
        frameLayout.removeAllViews();
        frameLayout.addView(this.adView);
        this.adView.setAdSize(Tools.getAdSize(this.activity));
        this.adView.loadAd(Tools.getAdRequest(this.collapsibleBanner));
        this.adView.setAdListener(new AdListener() { // from class: com.mimikridev.ads.banner.BannerAd.5
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                frameLayout.setVisibility(8);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                frameLayout.setVisibility(0);
                frameLayout2.setVisibility(8);
                relativeLayout.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBannerAd$0(final FrameLayout frameLayout, final FrameLayout frameLayout2, final RelativeLayout relativeLayout) {
        AdView adView = new AdView(this.activity);
        this.adView = adView;
        adView.setAdUnitId(this.adMobBannerId);
        frameLayout.removeAllViews();
        frameLayout.addView(this.adView);
        this.adView.setAdSize(Tools.getAdSize(this.activity));
        this.adView.loadAd(Tools.getAdRequest(this.collapsibleBanner));
        this.adView.setAdListener(new AdListener() { // from class: com.mimikridev.ads.banner.BannerAd.1
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                frameLayout.setVisibility(8);
                BannerAd.this.loadBackupBannerAd();
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                frameLayout.setVisibility(0);
                frameLayout2.setVisibility(8);
                relativeLayout.setVisibility(8);
            }
        });
    }

    public BannerAd build() {
        loadBannerAd();
        return this;
    }

    public void destroyAndDetachBanner() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            return;
        }
        if (this.adNetwork.equals(Constant.IRONSOURCE) || this.backupAdNetwork.equals(Constant.IRONSOURCE)) {
            if (this.levelPlayBannerAd == null) {
                Log.d(TAG, "IronSource LevelPlay banner is null");
                return;
            }
            Log.d(TAG, "IronSource LevelPlay banner is not null, ready to destroy");
            this.levelPlayBannerAd.destroy();
            FrameLayout frameLayout = this.ironSourceBannerView;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            this.levelPlayBannerAd = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadBackupBannerAd() {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mimikridev.ads.banner.BannerAd.loadBackupBannerAd():void");
    }

    public void loadBannerAd() {
        if (!this.adStatus.equals("1") || this.placementStatus == 0) {
            Log.d(TAG, "Banner Ad is disabled");
            return;
        }
        String str = this.adNetwork;
        str.getClass();
        switch (str) {
            case "pangle":
                final RelativeLayout relativeLayout = (RelativeLayout) this.activity.findViewById(R.id.pangle_banner_view_container);
                final FrameLayout frameLayout = (FrameLayout) this.activity.findViewById(R.id.admob_banner_view_container);
                final FrameLayout frameLayout2 = (FrameLayout) this.activity.findViewById(R.id.ironsource_banner_view_container);
                PAGBannerAd.loadAd(this.pangleBannerId, new PAGBannerRequest(PAGBannerSize.BANNER_W_320_H_50), new PAGBannerAdLoadListener() { // from class: com.mimikridev.ads.banner.BannerAd.4
                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                    public void onError(int i2, String str2) {
                        Log.d(BannerAd.TAG, BannerAd.this.adNetwork + " Banner Ad " + BannerAd.this.pangleBannerId + " Error: " + i2 + " : " + str2);
                        relativeLayout.setVisibility(8);
                        BannerAd.this.loadBackupBannerAd();
                    }

                    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                    public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                        Log.d(BannerAd.TAG, BannerAd.this.adNetwork + " Banner Ad Loaded");
                        if (pAGBannerAd != null) {
                            relativeLayout.removeAllViews();
                            relativeLayout.addView(pAGBannerAd.getBannerView());
                            relativeLayout.setVisibility(0);
                            frameLayout.setVisibility(8);
                            frameLayout2.setVisibility(8);
                            pAGBannerAd.setAdInteractionListener(new PAGBannerAdInteractionListener() { // from class: com.mimikridev.ads.banner.BannerAd.4.1
                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdClicked() {
                                }

                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdDismissed() {
                                }

                                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                                public void onAdShowed() {
                                }
                            });
                        }
                    }
                });
                break;
            case "ironsource":
                final RelativeLayout relativeLayout2 = (RelativeLayout) this.activity.findViewById(R.id.pangle_banner_view_container);
                final FrameLayout frameLayout3 = (FrameLayout) this.activity.findViewById(R.id.admob_banner_view_container);
                final FrameLayout frameLayout4 = (FrameLayout) this.activity.findViewById(R.id.ironsource_banner_view_container);
                LevelPlayAdSize levelPlayAdSizeCreateAdaptiveAdSize = LevelPlayAdSize.createAdaptiveAdSize(this.activity);
                if (levelPlayAdSizeCreateAdaptiveAdSize == null) {
                    levelPlayAdSizeCreateAdaptiveAdSize = LevelPlayAdSize.BANNER;
                }
                LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(this.activity, this.ironSourceBannerId, new LevelPlayBannerAdView.Config.Builder().setAdSize(levelPlayAdSizeCreateAdaptiveAdSize).setPlacementName("DefaultBanner").build());
                levelPlayBannerAdView.setBannerListener(new LevelPlayBannerAdViewListener() { // from class: com.mimikridev.ads.banner.BannerAd.3
                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdClicked(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] Banner ad clicked");
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdCollapsed(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] Banner ad collapsed to original size");
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdDisplayFailed(@NonNull LevelPlayAdInfo levelPlayAdInfo, @NonNull LevelPlayAdError levelPlayAdError) {
                        Log.e(BannerAd.TAG, "[IronSource] Failed to display banner ad: " + levelPlayAdError.getErrorMessage());
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdDisplayed(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] Banner ad displayed");
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdExpanded(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] Banner ad expanded to full screen");
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdLeftApplication(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] User left the application via banner ad");
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdLoadFailed(@NonNull LevelPlayAdError levelPlayAdError) {
                        Log.e(BannerAd.TAG, "[IronSource] Banner ad load failed: " + levelPlayAdError.getErrorMessage());
                        frameLayout4.setVisibility(8);
                        BannerAd.this.loadBackupBannerAd();
                    }

                    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
                    public void onAdLoaded(@NonNull LevelPlayAdInfo levelPlayAdInfo) {
                        Log.d(BannerAd.TAG, "[IronSource] Banner ad loaded successfully");
                        frameLayout4.setVisibility(0);
                        frameLayout3.setVisibility(8);
                        relativeLayout2.setVisibility(8);
                    }
                });
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                frameLayout4.removeAllViews();
                frameLayout4.addView(levelPlayBannerAdView, layoutParams);
                levelPlayBannerAdView.loadAd();
                break;
            case "admob":
                FrameLayout frameLayout5 = (FrameLayout) this.activity.findViewById(R.id.admob_banner_view_container);
                frameLayout5.post(new a(this, frameLayout5, (FrameLayout) this.activity.findViewById(R.id.ironsource_banner_view_container), (RelativeLayout) this.activity.findViewById(R.id.pangle_banner_view_container), 0));
                Log.d(TAG, this.adNetwork + " Banner Ad unit Id : " + this.adMobBannerId);
                break;
            case "facebook":
                this.fanAdView = new com.facebook.ads.AdView(this.activity, this.fanBannerId, AdSize.BANNER_HEIGHT_50);
                final RelativeLayout relativeLayout3 = (RelativeLayout) this.activity.findViewById(R.id.fan_banner_view_container);
                relativeLayout3.addView(this.fanAdView);
                this.fanAdView.loadAd(this.fanAdView.buildLoadAdConfig().withAdListener(new com.facebook.ads.AdListener() { // from class: com.mimikridev.ads.banner.BannerAd.2
                    @Override // com.facebook.ads.AdListener
                    public void onAdLoaded(Ad ad) {
                        relativeLayout3.setVisibility(0);
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onError(Ad ad, AdError adError) {
                        relativeLayout3.setVisibility(8);
                        BannerAd.this.loadBackupBannerAd();
                        Log.d(BannerAd.TAG, "Error load FAN : " + adError.getErrorMessage());
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onAdClicked(Ad ad) {
                    }

                    @Override // com.facebook.ads.AdListener
                    public void onLoggingImpression(Ad ad) {
                    }
                }).build());
        }
        Log.d(TAG, "Banner Ad is enabled");
    }

    public BannerAd setAdMobBannerId(String str) {
        this.adMobBannerId = str;
        return this;
    }

    public BannerAd setAdNetwork(String str) {
        this.adNetwork = str;
        return this;
    }

    public BannerAd setAdStatus(String str) {
        this.adStatus = str;
        return this;
    }

    public BannerAd setAppLovinBannerId(String str) {
        this.appLovinBannerId = str;
        return this;
    }

    public BannerAd setAppLovinBannerZoneId(String str) {
        this.appLovinBannerZoneId = str;
        return this;
    }

    public BannerAd setBackupAdNetwork(String str) {
        this.backupAdNetwork = str;
        return this;
    }

    public BannerAd setDarkTheme(boolean z2) {
        this.darkTheme = z2;
        return this;
    }

    public BannerAd setFanBannerId(String str) {
        this.fanBannerId = str;
        return this;
    }

    public BannerAd setGoogleAdManagerBannerId(String str) {
        this.googleAdManagerBannerId = str;
        return this;
    }

    public BannerAd setIronSourceBannerId(String str) {
        this.ironSourceBannerId = str;
        return this;
    }

    public BannerAd setIsCollapsibleBanner(boolean z2) {
        this.collapsibleBanner = z2;
        return this;
    }

    public BannerAd setLegacyGDPR(boolean z2) {
        this.legacyGDPR = z2;
        return this;
    }

    public BannerAd setPangleBannerId(String str) {
        this.pangleBannerId = str;
        return this;
    }

    public BannerAd setPlacementStatus(int i2) {
        this.placementStatus = i2;
        return this;
    }

    public BannerAd setUnityBannerId(String str) {
        this.unityBannerId = str;
        return this;
    }

    public void updateActivity(Activity activity) {
        this.activity = activity;
    }
}
