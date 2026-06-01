package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.unity.UnityAdsAdapterUtils;
import com.google.ads.mediation.unity.eventadapters.UnityInterstitialEventAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class UnityAdapter extends UnityMediationAdapter implements MediationInterstitialAdapter {
    private WeakReference<Activity> activityWeakReference;
    private UnityInterstitialEventAdapter eventAdapter;
    private MediationInterstitialListener mediationInterstitialListener;
    private String objectId;
    private String placementId;
    private final IUnityAdsLoadListener unityLoadListener = new IUnityAdsLoadListener() { // from class: com.google.ads.mediation.unity.UnityAdapter.1
        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsAdLoaded(String str) {
            Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad successfully loaded for placement ID: ", str));
            UnityAdapter.this.placementId = str;
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.LOADED);
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            UnityAdapter.this.placementId = str;
            AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsLoadError, str2);
            Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
            if (UnityAdapter.this.mediationInterstitialListener != null) {
                UnityAdapter.this.mediationInterstitialListener.onAdFailedToLoad(UnityAdapter.this, adErrorCreateSDKError);
            }
        }
    };
    private final IUnityAdsShowListener unityShowListener = new IUnityAdsShowListener() { // from class: com.google.ads.mediation.unity.UnityAdapter.3
        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad was clicked for placement ID: ", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.CLICKED);
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.LEFT_APPLICATION);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad finished playing for placement ID: ", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.CLOSED);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            Log.w(UnityMediationAdapter.TAG, UnityAdsAdapterUtils.createSDKError(unityAdsShowError, str2).toString());
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.OPENED);
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.CLOSED);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            Log.d(UnityMediationAdapter.TAG, a1.a.l("Unity Ads interstitial ad started for placement ID: ", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.OPENED);
        }
    };

    private void sendAdFailedToLoad(int i2, String str) {
        AdError adErrorCreateAdError = UnityAdsAdapterUtils.createAdError(i2, str);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateAdError.toString());
        MediationInterstitialListener mediationInterstitialListener = this.mediationInterstitialListener;
        if (mediationInterstitialListener != null) {
            mediationInterstitialListener.onAdFailedToLoad(this, adErrorCreateAdError);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        this.mediationInterstitialListener = null;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(@NonNull Context context, @NonNull MediationInterstitialListener mediationInterstitialListener, @NonNull Bundle bundle, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) {
        this.mediationInterstitialListener = mediationInterstitialListener;
        this.eventAdapter = new UnityInterstitialEventAdapter(mediationInterstitialListener, this);
        final String string = bundle.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string2 = bundle.getString("zoneId");
        this.placementId = string2;
        if (!UnityAdsAdapterUtils.areValidIds(string, string2)) {
            sendAdFailedToLoad(101, "Missing or invalid server parameters.");
            return;
        }
        if (!(context instanceof Activity)) {
            sendAdFailedToLoad(105, "Unity Ads requires an Activity context to load ads.");
            return;
        }
        this.activityWeakReference = new WeakReference<>((Activity) context);
        UnityInitializer.getInstance().initializeUnityAds(context, string, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityAdapter.2
            @Override // com.unity3d.ads.IUnityAdsInitializationListener
            public void onInitializationComplete() {
                Log.d(UnityMediationAdapter.TAG, a1.a.n("Unity Ads is initialized for game ID '", string, "' and can now load interstitial ad with placement ID: ", UnityAdapter.this.placementId));
            }

            @Override // com.unity3d.ads.IUnityAdsInitializationListener
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, "Unity Ads initialization failed for game ID '" + string + "' with error message: " + str);
                Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                if (UnityAdapter.this.mediationInterstitialListener != null) {
                    UnityAdapter.this.mediationInterstitialListener.onAdFailedToLoad(UnityAdapter.this, adErrorCreateSDKError);
                }
            }
        });
        UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
        this.objectId = UUID.randomUUID().toString();
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        unityAdsLoadOptions.setObjectId(this.objectId);
        UnityAds.load(this.placementId, unityAdsLoadOptions, this.unityLoadListener);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity != null) {
            if (this.placementId == null) {
                Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
            }
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(this.objectId);
            UnityAds.show(activity, this.placementId, unityAdsShowOptions, this.unityShowListener);
            return;
        }
        Log.w(UnityMediationAdapter.TAG, "Failed to show interstitial ad for placement ID '" + this.placementId + "' from Unity Ads: Activity context is null.");
        this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.CLOSED);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }
}
