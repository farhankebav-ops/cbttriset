package com.ironsource.adapters.admob.rewardedvideo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobRewardedVideoAdapter extends AbstractRewardedVideoAdapter<AdMobAdapter> {
    private final ConcurrentHashMap<String, RewardedAd> mAdUnitIdToAd;
    private final ConcurrentHashMap<String, JSONObject> mAdUnitIdToAdData;
    private final ConcurrentHashMap<String, Boolean> mAdUnitIdToAdsAvailability;
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mAdUnitIdToListener;
    private final CopyOnWriteArraySet<String> mAdUnitIdsForInitCallbacks;

    public AdMobRewardedVideoAdapter(AdMobAdapter adMobAdapter) {
        super(adMobAdapter);
        this.mAdUnitIdToListener = new ConcurrentHashMap<>();
        this.mAdUnitIdToAdData = new ConcurrentHashMap<>();
        this.mAdUnitIdToAd = new ConcurrentHashMap<>();
        this.mAdUnitIdToAdsAvailability = new ConcurrentHashMap<>();
        this.mAdUnitIdsForInitCallbacks = new CopyOnWriteArraySet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RewardedAd getRewardedVideoAd(String str) {
        if (TextUtils.isEmpty(str) || !this.mAdUnitIdToAd.containsKey(str)) {
            return null;
        }
        return this.mAdUnitIdToAd.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRewardedVideoAvailableForAdUnitId(String str) {
        return !TextUtils.isEmpty(str) && this.mAdUnitIdToAdsAvailability.containsKey(str) && this.mAdUnitIdToAdsAvailability.get(str).booleanValue();
    }

    private void loadRewardedVideoAdInternal(final String str, final JSONObject jSONObject, final String str2, @NonNull final RewardedVideoSmashListener rewardedVideoSmashListener) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.rewardedvideo.AdMobRewardedVideoAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                a.t(new StringBuilder("adUnitId = "), str, IronLog.ADAPTER_API);
                AdMobRewardedVideoAdapter.this.mAdUnitIdToAdsAvailability.put(str, Boolean.FALSE);
                RewardedAd.load(ContextProvider.getInstance().getApplicationContext(), str, AdMobRewardedVideoAdapter.this.getAdapter().createAdRequest(jSONObject, str2), new AdMobRewardedVideoAdLoadListener(AdMobRewardedVideoAdapter.this, str, rewardedVideoSmashListener));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(@NonNull JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        getAdapter().collectBiddingData(biddingDataCallback, AdFormat.REWARDED, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, @NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull RewardedVideoSmashListener rewardedVideoSmashListener) {
        String adUnitIdKey = getAdapter().getAdUnitIdKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, adUnitIdKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(adUnitIdKey));
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        a.p("adUnitId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mAdUnitIdToListener.put(configStringValueFromKey, rewardedVideoSmashListener);
        if (getAdapter().getInitState() == AdMobAdapter.InitState.INIT_STATE_SUCCESS) {
            loadRewardedVideoAdInternal(configStringValueFromKey, jSONObject2, null, rewardedVideoSmashListener);
            return;
        }
        if (getAdapter().getInitState() != AdMobAdapter.InitState.INIT_STATE_FAILED) {
            if (jSONObject2 != null) {
                this.mAdUnitIdToAdData.put(configStringValueFromKey, jSONObject2);
            }
            getAdapter().initSDK(jSONObject);
        } else {
            IronLog.INTERNAL.verbose("onRewardedVideoAvailabilityChanged(false) - adUnitId = " + configStringValueFromKey);
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, @NonNull JSONObject jSONObject, @NonNull RewardedVideoSmashListener rewardedVideoSmashListener) {
        String adUnitIdKey = getAdapter().getAdUnitIdKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, adUnitIdKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(adUnitIdKey));
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(adUnitIdKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        a.p("adUnitId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mAdUnitIdToListener.put(configStringValueFromKey, rewardedVideoSmashListener);
        this.mAdUnitIdsForInitCallbacks.add(configStringValueFromKey);
        if (getAdapter().getInitState() == AdMobAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onRewardedVideoInitSuccess - adUnitId = " + configStringValueFromKey);
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            return;
        }
        if (getAdapter().getInitState() != AdMobAdapter.InitState.INIT_STATE_FAILED) {
            getAdapter().initSDK(jSONObject);
            return;
        }
        IronLog.INTERNAL.verbose("init failed - adUnitId = " + configStringValueFromKey);
        rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("AdMob sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(@NonNull JSONObject jSONObject) {
        return isRewardedVideoAvailableForAdUnitId(getConfigStringValueFromKey(jSONObject, getAdapter().getAdUnitIdKey()));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoAdInternal(getConfigStringValueFromKey(jSONObject, getAdapter().getAdUnitIdKey()), jSONObject2, null, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(@NonNull JSONObject jSONObject, JSONObject jSONObject2, String str, @NonNull RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoAdInternal(getConfigStringValueFromKey(jSONObject, getAdapter().getAdUnitIdKey()), jSONObject2, str, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        for (String str2 : this.mAdUnitIdToListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mAdUnitIdToListener.get(str2);
            if (this.mAdUnitIdsForInitCallbacks.contains(str2)) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        for (String str : this.mAdUnitIdToListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mAdUnitIdToListener.get(str);
            if (this.mAdUnitIdsForInitCallbacks.contains(str)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoAdInternal(str, this.mAdUnitIdToAdData.get(str), null, rewardedVideoSmashListener);
            }
        }
    }

    public void onRewardedVideoAdLoaded(String str, RewardedAd rewardedAd) {
        this.mAdUnitIdToAd.put(str, rewardedAd);
        this.mAdUnitIdToAdsAvailability.put(str, Boolean.TRUE);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(@NonNull final JSONObject jSONObject, @NonNull final RewardedVideoSmashListener rewardedVideoSmashListener) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.rewardedvideo.AdMobRewardedVideoAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                AdMobRewardedVideoAdapter adMobRewardedVideoAdapter = AdMobRewardedVideoAdapter.this;
                String configStringValueFromKey = adMobRewardedVideoAdapter.getConfigStringValueFromKey(jSONObject, adMobRewardedVideoAdapter.getAdapter().getAdUnitIdKey());
                RewardedAd rewardedVideoAd = AdMobRewardedVideoAdapter.this.getRewardedVideoAd(configStringValueFromKey);
                a.p("adUnitId = ", configStringValueFromKey, IronLog.ADAPTER_API);
                if (rewardedVideoAd == null || !AdMobRewardedVideoAdapter.this.isRewardedVideoAvailableForAdUnitId(configStringValueFromKey)) {
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else {
                    AdMobRewardedVideoAdShowListener adMobRewardedVideoAdShowListener = new AdMobRewardedVideoAdShowListener(configStringValueFromKey, rewardedVideoSmashListener);
                    rewardedVideoAd.setFullScreenContentCallback(adMobRewardedVideoAdShowListener);
                    rewardedVideoAd.show(ContextProvider.getInstance().getCurrentActiveActivity(), adMobRewardedVideoAdShowListener);
                }
                AdMobRewardedVideoAdapter.this.mAdUnitIdToAdsAvailability.put(configStringValueFromKey, Boolean.FALSE);
            }
        });
    }
}
