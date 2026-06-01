package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
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
public class UnityRewardedAd implements MediationRewardedAd {
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;

    @Nullable
    private MediationRewardedAdCallback mediationRewardedAdCallback;

    @Nullable
    private String objectId;

    @Nullable
    private String placementId;
    private final UnityAdsLoader unityAdsLoader;
    private final UnityInitializer unityInitializer;

    @VisibleForTesting
    final IUnityAdsLoadListener unityLoadListener = new IUnityAdsLoadListener() { // from class: com.google.ads.mediation.unity.UnityRewardedAd.1
        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsAdLoaded(String str) {
            Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads rewarded ad successfully loaded placement ID: ", str));
            UnityRewardedAd.this.placementId = str;
            UnityRewardedAd unityRewardedAd = UnityRewardedAd.this;
            unityRewardedAd.mediationRewardedAdCallback = (MediationRewardedAdCallback) unityRewardedAd.mediationAdLoadCallback.onSuccess(UnityRewardedAd.this);
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            UnityRewardedAd.this.placementId = str;
            AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsLoadError, str2);
            Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
            UnityRewardedAd.this.mediationAdLoadCallback.onFailure(adErrorCreateSDKError);
        }
    };

    @VisibleForTesting
    final IUnityAdsShowListener unityShowListener = new IUnityAdsShowListener() { // from class: com.google.ads.mediation.unity.UnityRewardedAd.2
        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            if (UnityRewardedAd.this.mediationRewardedAdCallback != null) {
                UnityRewardedAd.this.mediationRewardedAdCallback.reportAdClicked();
            }
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            if (UnityRewardedAd.this.mediationRewardedAdCallback == null) {
                return;
            }
            if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                UnityRewardedAd.this.mediationRewardedAdCallback.onVideoComplete();
                UnityRewardedAd.this.mediationRewardedAdCallback.onUserEarnedReward();
            }
            UnityRewardedAd.this.mediationRewardedAdCallback.onAdClosed();
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            if (UnityRewardedAd.this.mediationRewardedAdCallback != null) {
                UnityRewardedAd.this.mediationRewardedAdCallback.onAdFailedToShow(UnityAdsAdapterUtils.createSDKError(unityAdsShowError, str2));
            }
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            if (UnityRewardedAd.this.mediationRewardedAdCallback == null) {
                return;
            }
            UnityRewardedAd.this.mediationRewardedAdCallback.onAdOpened();
            UnityRewardedAd.this.mediationRewardedAdCallback.reportAdImpression();
            UnityRewardedAd.this.mediationRewardedAdCallback.onVideoStart();
        }
    };
    private final String watermark;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class UnityAdsInitializationListener implements IUnityAdsInitializationListener {

        @Nullable
        private final String adMarkup;
        private final Context context;
        private final String gameId;
        private final String placementId;

        public UnityAdsInitializationListener(Context context, String str, String str2, @Nullable String str3) {
            this.context = context;
            this.gameId = str;
            this.placementId = str2;
            this.adMarkup = str3;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() {
            Log.d(UnityMediationAdapter.TAG, a1.a.n("Unity Ads is initialized for game ID '", this.gameId, "' and can now load rewarded ad with placement ID: ", this.placementId));
            UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), this.context);
            UnityRewardedAd.this.objectId = UUID.randomUUID().toString();
            UnityAdsLoadOptions unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId = UnityRewardedAd.this.unityAdsLoader.createUnityAdsLoadOptionsWithId(UnityRewardedAd.this.objectId);
            String str = this.adMarkup;
            if (str != null) {
                unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId.setAdMarkup(str);
            }
            UnityRewardedAd.this.unityAdsLoader.load(this.placementId, unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId, UnityRewardedAd.this.unityLoadListener);
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, "Unity Ads initialization failed for game ID '" + this.gameId + "' with error message: " + str);
            Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
            UnityRewardedAd.this.mediationAdLoadCallback.onFailure(adErrorCreateSDKError);
        }
    }

    public UnityRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull UnityInitializer unityInitializer, @NonNull UnityAdsLoader unityAdsLoader) {
        this.watermark = mediationRewardedAdConfiguration.getWatermark();
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        this.unityInitializer = unityInitializer;
        this.unityAdsLoader = unityAdsLoader;
    }

    public void loadAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        Context context = mediationRewardedAdConfiguration.getContext();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        String string = serverParameters.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string2 = serverParameters.getString("zoneId");
        if (UnityAdsAdapterUtils.areValidIds(string, string2)) {
            this.unityInitializer.initializeUnityAds(context, string, new UnityAdsInitializationListener(context, string, string2, mediationRewardedAdConfiguration.getBidResponse()));
        } else {
            AdError adError = new AdError(101, "Missing or invalid server parameters.", "com.google.ads.mediation.unity");
            Log.w(UnityMediationAdapter.TAG, adError.toString());
            this.mediationAdLoadCallback.onFailure(adError);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (this.placementId == null) {
                Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
            }
            UnityAdsShowOptions unityAdsShowOptionsCreateUnityAdsShowOptionsWithId = this.unityAdsLoader.createUnityAdsShowOptionsWithId(this.objectId);
            unityAdsShowOptionsCreateUnityAdsShowOptionsWithId.set("watermark", this.watermark);
            this.unityAdsLoader.show(activity, this.placementId, unityAdsShowOptionsCreateUnityAdsShowOptionsWithId, this.unityShowListener);
            return;
        }
        AdError adError = new AdError(105, "Unity Ads requires an Activity context to load ads.", "com.google.ads.mediation.unity");
        Log.e(UnityMediationAdapter.TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }
}
