package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class UnityMediationBannerAd implements MediationBannerAd, BannerView.IListener {
    static final String ERROR_MSG_INITIALIZATION_FAILED_FOR_GAME_ID = "Unity Ads initialization failed for game ID '%s' with error message: %s";
    static final String ERROR_MSG_NO_MATCHING_AD_SIZE = "There is no matching Unity Ads ad size for Google ad size: ";
    private String bannerPlacementId;
    private String gameId;

    @Nullable
    private MediationBannerAdCallback mediationBannerAdCallback;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationBannerAdLoadCallback;
    private final UnityAdsLoader unityAdsLoader;
    private final UnityBannerViewFactory unityBannerViewFactory;

    @Nullable
    private UnityBannerViewWrapper unityBannerViewWrapper;
    private final UnityInitializer unityInitializer;

    public UnityMediationBannerAd(@NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, @NonNull UnityInitializer unityInitializer, @NonNull UnityBannerViewFactory unityBannerViewFactory, @NonNull UnityAdsLoader unityAdsLoader) {
        this.mediationBannerAdLoadCallback = mediationAdLoadCallback;
        this.unityBannerViewFactory = unityBannerViewFactory;
        this.unityInitializer = unityInitializer;
        this.unityAdsLoader = unityAdsLoader;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.unityBannerViewWrapper.getBannerView();
    }

    public void loadAd(final MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        final Context context = mediationBannerAdConfiguration.getContext();
        Bundle serverParameters = mediationBannerAdConfiguration.getServerParameters();
        AdSize adSize = mediationBannerAdConfiguration.getAdSize();
        this.gameId = serverParameters.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string = serverParameters.getString("zoneId");
        this.bannerPlacementId = string;
        if (!UnityAdsAdapterUtils.areValidIds(this.gameId, string)) {
            AdError adError = new AdError(101, "Missing or invalid server parameters.", "com.google.ads.mediation.unity");
            Log.w(UnityMediationAdapter.TAG, adError.toString());
            this.mediationBannerAdLoadCallback.onFailure(adError);
            return;
        }
        if (!(context instanceof Activity)) {
            AdError adError2 = new AdError(105, "Unity Ads requires an Activity context to load ads.", "com.google.ads.mediation.unity");
            Log.w(UnityMediationAdapter.TAG, adError2.toString());
            this.mediationBannerAdLoadCallback.onFailure(adError2);
            return;
        }
        final Activity activity = (Activity) context;
        final String bidResponse = mediationBannerAdConfiguration.getBidResponse();
        final UnityBannerSize unityBannerSize = UnityAdsAdapterUtils.getUnityBannerSize(context, adSize, !TextUtils.isEmpty(bidResponse));
        if (unityBannerSize != null) {
            this.unityInitializer.initializeUnityAds(context, this.gameId, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityMediationBannerAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    Log.d(UnityMediationAdapter.TAG, a1.a.n("Unity Ads is initialized for game ID '", UnityMediationBannerAd.this.gameId, "' and can now load banner ad with placement ID: ", UnityMediationBannerAd.this.bannerPlacementId));
                    UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
                    if (UnityMediationBannerAd.this.unityBannerViewWrapper == null) {
                        UnityMediationBannerAd unityMediationBannerAd = UnityMediationBannerAd.this;
                        unityMediationBannerAd.unityBannerViewWrapper = unityMediationBannerAd.unityBannerViewFactory.createBannerView(activity, UnityMediationBannerAd.this.bannerPlacementId, unityBannerSize);
                    }
                    UnityMediationBannerAd.this.unityBannerViewWrapper.setListener(UnityMediationBannerAd.this);
                    UnityAdsLoadOptions unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId = UnityMediationBannerAd.this.unityAdsLoader.createUnityAdsLoadOptionsWithId(UUID.randomUUID().toString());
                    unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId.set("watermark", mediationBannerAdConfiguration.getWatermark());
                    String str = bidResponse;
                    if (str != null) {
                        unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId.setAdMarkup(str);
                    }
                    UnityMediationBannerAd.this.unityBannerViewWrapper.load(unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId);
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, "Unity Ads initialization failed for game ID '" + UnityMediationBannerAd.this.gameId + "' with error message: " + str);
                    Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                    UnityMediationBannerAd.this.mediationBannerAdLoadCallback.onFailure(adErrorCreateSDKError);
                }
            });
            return;
        }
        AdError adError3 = new AdError(110, ERROR_MSG_NO_MATCHING_AD_SIZE + adSize, "com.google.ads.mediation.unity");
        Log.w(UnityMediationAdapter.TAG, adError3.toString());
        this.mediationBannerAdLoadCallback.onFailure(adError3);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerClick(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads banner ad was clicked for placement ID: ", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback == null) {
            return;
        }
        mediationBannerAdCallback.reportAdClicked();
        this.mediationBannerAdCallback.onAdOpened();
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        AdError adErrorCreateAdError = UnityAdsAdapterUtils.createAdError(UnityAdsAdapterUtils.getMediationErrorCode(bannerErrorInfo), bannerErrorInfo.errorMessage);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateAdError.toString());
        this.mediationBannerAdLoadCallback.onFailure(adErrorCreateAdError);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLeftApplication(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads banner ad left application for placement ID: ", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback == null) {
            return;
        }
        mediationBannerAdCallback.onAdLeftApplication();
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLoaded(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads finished loading banner ad for placement ID: ", bannerView.getPlacementId()));
        this.mediationBannerAdCallback = this.mediationBannerAdLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerShown(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads banner ad was shown for placement ID: ", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }
}
