package com.ironsource.adapters.facebook.rewardedvideo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookRewardedVideoAdapter extends AbstractRewardedVideoAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, Boolean> mAdsAvailability;
    private final ConcurrentHashMap<String, RewardedVideoAd> mPlacementIdToAd;
    private final ConcurrentHashMap<String, FacebookRewardedVideoAdListener> mPlacementIdToFacebookAdListener;
    protected ConcurrentHashMap<String, Boolean> mPlacementIdToShowAttempts;
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToSmashListener;

    public FacebookRewardedVideoAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
        this.mPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAd = new ConcurrentHashMap<>();
        this.mPlacementIdToFacebookAdListener = new ConcurrentHashMap<>();
        this.mAdsAvailability = new ConcurrentHashMap<>();
        this.mPlacementIdToShowAttempts = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(@NonNull JSONObject jSONObject, JSONObject jSONObject2) {
        return getAdapter().getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, @NonNull JSONObject jSONObject, @NonNull RewardedVideoSmashListener rewardedVideoSmashListener) {
        String placementIdKey = getAdapter().getPlacementIdKey();
        String allPlacementIdsKey = getAdapter().getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        a.p("placementId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        this.mPlacementIdToSmashListener.put(configStringValueFromKey, rewardedVideoSmashListener);
        if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onRewardedVideoInitSuccess - placementId = " + configStringValueFromKey);
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            return;
        }
        if (getAdapter().getInitState() != FacebookAdapter.InitState.INIT_STATE_FAILED) {
            getAdapter().initSDK(configStringValueFromKey2);
            return;
        }
        IronLog.INTERNAL.verbose("onRewardedVideoInitFailed - placementId = " + configStringValueFromKey);
        rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(@NonNull JSONObject jSONObject) {
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        return this.mAdsAvailability.containsKey(configStringValueFromKey) && Boolean.TRUE.equals(this.mAdsAvailability.get(configStringValueFromKey));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(@NonNull JSONObject jSONObject, JSONObject jSONObject2, final String str, @NonNull final RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        a.p("placementId = ", configStringValueFromKey, IronLog.ADAPTER_API);
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.mAdsAvailability;
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.put(configStringValueFromKey, bool);
        this.mPlacementIdToShowAttempts.put(configStringValueFromKey, bool);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.rewardedvideo.FacebookRewardedVideoAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (FacebookRewardedVideoAdapter.this.mPlacementIdToAd.containsKey(configStringValueFromKey)) {
                        IronLog.ADAPTER_API.verbose("destroying previous ad with placementId " + configStringValueFromKey);
                        ((RewardedVideoAd) FacebookRewardedVideoAdapter.this.mPlacementIdToAd.get(configStringValueFromKey)).destroy();
                        FacebookRewardedVideoAdapter.this.mPlacementIdToAd.remove(configStringValueFromKey);
                    }
                    RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(ContextProvider.getInstance().getApplicationContext(), configStringValueFromKey);
                    FacebookRewardedVideoAdListener facebookRewardedVideoAdListener = new FacebookRewardedVideoAdListener(FacebookRewardedVideoAdapter.this, configStringValueFromKey, rewardedVideoSmashListener);
                    FacebookRewardedVideoAdapter.this.mPlacementIdToFacebookAdListener.put(configStringValueFromKey, facebookRewardedVideoAdListener);
                    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig = rewardedVideoAd.buildLoadAdConfig();
                    rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withAdListener(facebookRewardedVideoAdListener);
                    if (!TextUtils.isEmpty(str)) {
                        rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withBid(str);
                    }
                    if (!TextUtils.isEmpty(FacebookRewardedVideoAdapter.this.getAdapter().getDynamicUserId())) {
                        rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withRewardData(new RewardData(FacebookRewardedVideoAdapter.this.getAdapter().getDynamicUserId(), ""));
                    }
                    FacebookRewardedVideoAdapter.this.mPlacementIdToAd.put(configStringValueFromKey, rewardedVideoAd);
                    rewardedVideoAd.loadAd(rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.build());
                } catch (Exception unused) {
                    rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<RewardedVideoSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Iterator<RewardedVideoSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onRewardedVideoInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(@NonNull JSONObject jSONObject, @NonNull final RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.rewardedvideo.FacebookRewardedVideoAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RewardedVideoAd rewardedVideoAd = (RewardedVideoAd) FacebookRewardedVideoAdapter.this.mPlacementIdToAd.get(configStringValueFromKey);
                    if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded() || rewardedVideoAd.isAdInvalidated()) {
                        rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    } else {
                        FacebookRewardedVideoAdapter.this.mPlacementIdToShowAttempts.put(configStringValueFromKey, Boolean.TRUE);
                        rewardedVideoAd.show();
                    }
                    FacebookRewardedVideoAdapter.this.mAdsAvailability.put(configStringValueFromKey, Boolean.FALSE);
                } catch (Exception e) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e.getMessage());
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, e.getMessage()));
                }
            }
        });
    }
}
