package com.ironsource.adapters.facebook.interstitial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookInterstitialAdapter extends AbstractInterstitialAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, Boolean> mAdsAvailability;
    private final ConcurrentHashMap<String, InterstitialAd> mPlacementIdToAd;
    private final ConcurrentHashMap<String, FacebookInterstitialAdListener> mPlacementIdToFacebookAdListener;
    protected ConcurrentHashMap<String, Boolean> mPlacementIdToShowAttempts;
    private final ConcurrentHashMap<String, InterstitialSmashListener> mPlacementIdToSmashListener;

    public FacebookInterstitialAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
        this.mPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAd = new ConcurrentHashMap<>();
        this.mPlacementIdToFacebookAdListener = new ConcurrentHashMap<>();
        this.mAdsAvailability = new ConcurrentHashMap<>();
        this.mPlacementIdToShowAttempts = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public Map<String, Object> getInterstitialBiddingData(@NonNull JSONObject jSONObject, JSONObject jSONObject2) {
        return getAdapter().getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, @NonNull JSONObject jSONObject, @NonNull InterstitialSmashListener interstitialSmashListener) {
        String placementIdKey = getAdapter().getPlacementIdKey();
        String allPlacementIdsKey = getAdapter().getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), "Interstitial"));
            return;
        }
        if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), "Interstitial"));
            return;
        }
        a.p("placementId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mPlacementIdToSmashListener.put(configStringValueFromKey, interstitialSmashListener);
        if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onInterstitialInitSuccess - placementId = " + configStringValueFromKey);
            interstitialSmashListener.onInterstitialInitSuccess();
            return;
        }
        if (getAdapter().getInitState() != FacebookAdapter.InitState.INIT_STATE_FAILED) {
            getAdapter().initSDK(configStringValueFromKey2);
            return;
        }
        IronLog.INTERNAL.verbose("onInterstitialInitFailed - placementId = " + configStringValueFromKey);
        interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", "Interstitial"));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public final boolean isInterstitialReady(@NonNull JSONObject jSONObject) {
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        return this.mAdsAvailability.containsKey(configStringValueFromKey) && Boolean.TRUE.equals(this.mAdsAvailability.get(configStringValueFromKey));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(@NonNull JSONObject jSONObject, JSONObject jSONObject2, final String str, @NonNull final InterstitialSmashListener interstitialSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.mPlacementIdToShowAttempts;
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.put(configStringValueFromKey, bool);
        this.mAdsAvailability.put(configStringValueFromKey, bool);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.interstitial.FacebookInterstitialAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("placementId = " + configStringValueFromKey);
                    if (FacebookInterstitialAdapter.this.mPlacementIdToAd.containsKey(configStringValueFromKey)) {
                        ironLog.verbose("destroying previous ad with placementId " + configStringValueFromKey);
                        ((InterstitialAd) FacebookInterstitialAdapter.this.mPlacementIdToAd.get(configStringValueFromKey)).destroy();
                        FacebookInterstitialAdapter.this.mPlacementIdToAd.remove(configStringValueFromKey);
                    }
                    InterstitialAd interstitialAd = new InterstitialAd(ContextProvider.getInstance().getApplicationContext(), configStringValueFromKey);
                    FacebookInterstitialAdListener facebookInterstitialAdListener = new FacebookInterstitialAdListener(FacebookInterstitialAdapter.this, configStringValueFromKey, interstitialSmashListener);
                    FacebookInterstitialAdapter.this.mPlacementIdToFacebookAdListener.put(configStringValueFromKey, facebookInterstitialAdListener);
                    InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderBuildLoadAdConfig = interstitialAd.buildLoadAdConfig();
                    EnumSet<CacheFlag> cacheFlags = FacebookInterstitialAdapter.this.getAdapter().getCacheFlags();
                    interstitialAdLoadConfigBuilderBuildLoadAdConfig.withCacheFlags(cacheFlags);
                    interstitialAdLoadConfigBuilderBuildLoadAdConfig.withAdListener(facebookInterstitialAdListener);
                    if (!TextUtils.isEmpty(str)) {
                        interstitialAdLoadConfigBuilderBuildLoadAdConfig.withBid(str);
                    }
                    ironLog.verbose("loading placementId = " + configStringValueFromKey + " with facebook cache flags = " + cacheFlags.toString());
                    interstitialAd.loadAd(interstitialAdLoadConfigBuilderBuildLoadAdConfig.build());
                    FacebookInterstitialAdapter.this.mPlacementIdToAd.put(configStringValueFromKey, interstitialAd);
                } catch (Exception e) {
                    interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(e.getLocalizedMessage()));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<InterstitialSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Iterator<InterstitialSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(@NonNull JSONObject jSONObject, @NonNull final InterstitialSmashListener interstitialSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        a.p("placementId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mAdsAvailability.put(configStringValueFromKey, Boolean.FALSE);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.interstitial.FacebookInterstitialAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InterstitialAd interstitialAd = (InterstitialAd) FacebookInterstitialAdapter.this.mPlacementIdToAd.get(configStringValueFromKey);
                    if (interstitialAd == null || !interstitialAd.isAdLoaded() || interstitialAd.isAdInvalidated()) {
                        interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
                    } else {
                        FacebookInterstitialAdapter.this.mPlacementIdToShowAttempts.put(configStringValueFromKey, Boolean.TRUE);
                        interstitialAd.show();
                    }
                } catch (Exception e) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e.getMessage());
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", e.getMessage()));
                }
            }
        });
    }
}
