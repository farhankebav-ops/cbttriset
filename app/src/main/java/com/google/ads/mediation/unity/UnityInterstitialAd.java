package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class UnityInterstitialAd implements MediationInterstitialAd, IUnityAdsLoadListener, IUnityAdsShowListener {
    static final String ERROR_MSG_INTERSTITIAL_INITIALIZATION_FAILED = "Unity Ads initialization failed for game ID '%s' with error message: %s";
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;

    @Nullable
    private MediationInterstitialAdCallback interstitialAdCallback;
    private String objectId;
    private String placementId;
    private final UnityAdsLoader unityAdsLoader;
    private final UnityInitializer unityInitializer;
    private final String watermark;

    public UnityInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull UnityInitializer unityInitializer, @NonNull UnityAdsLoader unityAdsLoader) {
        this.watermark = mediationInterstitialAdConfiguration.getWatermark();
        this.adLoadCallback = mediationAdLoadCallback;
        this.unityInitializer = unityInitializer;
        this.unityAdsLoader = unityAdsLoader;
    }

    public void loadAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        final Context context = mediationInterstitialAdConfiguration.getContext();
        Bundle serverParameters = mediationInterstitialAdConfiguration.getServerParameters();
        final String string = serverParameters.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string2 = serverParameters.getString("zoneId");
        this.placementId = string2;
        if (UnityAdsAdapterUtils.areValidIds(string, string2)) {
            final String bidResponse = mediationInterstitialAdConfiguration.getBidResponse();
            this.unityInitializer.initializeUnityAds(context, string, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityInterstitialAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    Log.d(UnityMediationAdapter.TAG, a1.a.n("Unity Ads is initialized for game ID '", string, "' and can now load interstitial ad with placement ID: ", UnityInterstitialAd.this.placementId));
                    UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
                    UnityInterstitialAd.this.objectId = UUID.randomUUID().toString();
                    UnityAdsLoadOptions unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId = UnityInterstitialAd.this.unityAdsLoader.createUnityAdsLoadOptionsWithId(UnityInterstitialAd.this.objectId);
                    String str = bidResponse;
                    if (str != null) {
                        unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId.setAdMarkup(str);
                    }
                    UnityInterstitialAd.this.unityAdsLoader.load(UnityInterstitialAd.this.placementId, unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId, UnityInterstitialAd.this);
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, "Unity Ads initialization failed for game ID '" + string + "' with error message: " + str);
                    Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                    UnityInterstitialAd.this.adLoadCallback.onFailure(adErrorCreateSDKError);
                }
            });
        } else {
            this.adLoadCallback.onFailure(new AdError(101, "Missing or invalid server parameters.", "com.google.ads.mediation.unity"));
        }
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad successfully loaded for placement ID: ", str));
        this.placementId = str;
        this.interstitialAdCallback = this.adLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        this.placementId = str;
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsLoadError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        this.adLoadCallback.onFailure(adErrorCreateSDKError);
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad was clicked for placement ID: ", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad finished playing for placement ID: ", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsShowError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adErrorCreateSDKError);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad started for placement ID: ", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        if (this.placementId == null) {
            Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
        }
        UnityAdsShowOptions unityAdsShowOptionsCreateUnityAdsShowOptionsWithId = this.unityAdsLoader.createUnityAdsShowOptionsWithId(this.objectId);
        unityAdsShowOptionsCreateUnityAdsShowOptionsWithId.set("watermark", this.watermark);
        this.unityAdsLoader.show((Activity) context, this.placementId, unityAdsShowOptionsCreateUnityAdsShowOptionsWithId, this);
    }
}
