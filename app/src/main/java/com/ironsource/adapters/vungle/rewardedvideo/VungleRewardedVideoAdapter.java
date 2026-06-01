package com.ironsource.adapters.vungle.rewardedvideo;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.vungle.VungleAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.AdConfig;
import com.vungle.ads.FullscreenAd;
import com.vungle.ads.RewardedAd;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleRewardedVideoAdapter extends AbstractRewardedVideoAdapter<VungleAdapter> {
    private final ConcurrentHashMap<String, Boolean> mPlacementIdToAdAvailability;
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToListener;
    private final ConcurrentHashMap<String, RewardedAd> mPlacementToRewardedVideoAd;
    private final CopyOnWriteArraySet<String> mRewardedVideoPlacementIdsForInitCallbacks;
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mRewardedVideoPlacementToListenerMap;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VungleAdapter.Companion.InitState.values().length];
            try {
                iArr[VungleAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VungleAdapter.Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleRewardedVideoAdapter(VungleAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
        this.mPlacementIdToListener = new ConcurrentHashMap<>();
        this.mPlacementToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mPlacementIdToAdAvailability = new ConcurrentHashMap<>();
    }

    private final void loadRewardedVideoInternal(String str, RewardedVideoSmashListener rewardedVideoSmashListener, String str2) {
        a.p("loadRewardedVideo Vungle ad with placementId = ", str, IronLog.ADAPTER_API);
        setRewardedVideoAdAvailability$vungleadapter_release(str, false);
        VungleRewardedVideoAdListener vungleRewardedVideoAdListener = new VungleRewardedVideoAdListener(new WeakReference(this), rewardedVideoSmashListener, str);
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        RewardedAd rewardedAd = new RewardedAd(applicationContext, str, new AdConfig());
        rewardedAd.setAdListener(vungleRewardedVideoAdListener);
        this.mPlacementToRewardedVideoAd.put(str, rewardedAd);
        rewardedAd.load(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRewardedVideo$lambda$4(RewardedAd rewardedAd) {
        if (rewardedAd != null) {
            FullscreenAd.DefaultImpls.play$default(rewardedAd, null, 1, null);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject config, JSONObject jSONObject, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        String appId = config.optString(VungleAdapter.APP_ID);
        if (placementId == null || placementId.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(VungleAdapter.PLACEMENT_ID));
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        if (appId == null || appId.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(VungleAdapter.APP_ID));
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        a.r("placementId = ", placementId, ", appId = ", appId, ironLog);
        ConcurrentHashMap<String, RewardedVideoSmashListener> concurrentHashMap = this.mRewardedVideoPlacementToListenerMap;
        k.d(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[VungleAdapter.Companion.getMInitState$vungleadapter_release().ordinal()];
        if (i2 == 1) {
            ironLog.verbose("initRewardedVideo: load rv ".concat(placementId));
            loadRewardedVideoInternal(placementId, listener, null);
        } else {
            if (i2 == 2) {
                ironLog.verbose("initRewardedVideo - onRewardedVideoAvailabilityChanged(false)");
                listener.onRewardedVideoAvailabilityChanged(false);
                return;
            }
            VungleAdapter adapter = getAdapter();
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            k.d(applicationContext, "getInstance().applicationContext");
            k.d(appId, "appId");
            adapter.initSDK(applicationContext, appId);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject config, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        String appId = config.optString(VungleAdapter.APP_ID);
        if (placementId == null || placementId.length() == 0) {
            IronLog ironLog = IronLog.INTERNAL;
            k.d(placementId, "placementId");
            ironLog.error(getAdUnitIdMissingErrorString(placementId));
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementId), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        if (appId == null || appId.length() == 0) {
            IronLog ironLog2 = IronLog.INTERNAL;
            k.d(appId, "appId");
            ironLog2.error(getAdUnitIdMissingErrorString(appId));
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(appId), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        a.r("placementId = ", placementId, ", appId = ", appId, IronLog.ADAPTER_API);
        ConcurrentHashMap<String, RewardedVideoSmashListener> concurrentHashMap = this.mPlacementIdToListener;
        k.d(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        this.mRewardedVideoPlacementIdsForInitCallbacks.add(placementId);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            listener.onRewardedVideoInitSuccess();
            return;
        }
        if (i2 == 2) {
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Vungle SDK Init Failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        VungleAdapter adapter = getAdapter();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        k.d(appId, "appId");
        adapter.initSDK(applicationContext, appId);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        RewardedAd rewardedAd;
        k.e(config, "config");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = <" + placementId + ">");
        k.d(placementId, "placementId");
        if (placementId.length() == 0) {
            return false;
        }
        Boolean bool = this.mPlacementIdToAdAvailability.get(placementId);
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue() && (rewardedAd = this.mPlacementToRewardedVideoAd.get(placementId)) != null) {
            return rewardedAd.canPlayAd().booleanValue();
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject config, JSONObject jSONObject, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = " + placementId);
        k.d(placementId, "placementId");
        loadRewardedVideoInternal(placementId, listener, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject jSONObject, String str, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = " + placementId);
        k.d(placementId, "placementId");
        loadRewardedVideoInternal(placementId, listener, str);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mRewardedVideoPlacementToListenerMap.entrySet()) {
            String key = entry.getKey();
            RewardedVideoSmashListener value = entry.getValue();
            if (this.mRewardedVideoPlacementIdsForInitCallbacks.contains(key)) {
                value.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                value.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Set<Map.Entry<String, RewardedVideoSmashListener>> setEntrySet = this.mRewardedVideoPlacementToListenerMap.entrySet();
        k.d(setEntrySet, "mRewardedVideoPlacementToListenerMap.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            k.d(entry, "(rewardedVideoPlacement, rewardedVideoListener)");
            String rewardedVideoPlacement = (String) entry.getKey();
            RewardedVideoSmashListener rewardedVideoListener = (RewardedVideoSmashListener) entry.getValue();
            if (this.mRewardedVideoPlacementIdsForInitCallbacks.contains(rewardedVideoPlacement)) {
                rewardedVideoListener.onRewardedVideoInitSuccess();
            } else {
                k.d(rewardedVideoPlacement, "rewardedVideoPlacement");
                k.d(rewardedVideoListener, "rewardedVideoListener");
                loadRewardedVideoInternal(rewardedVideoPlacement, rewardedVideoListener, null);
            }
        }
    }

    public final void setRewardedVideoAdAvailability$vungleadapter_release(String placementId, boolean z2) {
        k.e(placementId, "placementId");
        this.mPlacementIdToAdAvailability.put(placementId, Boolean.valueOf(z2));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + placementId);
        if (!isRewardedVideoAvailable(config)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(VungleAdapter.PLACEMENT_ID));
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        RewardedAd rewardedAd = this.mPlacementToRewardedVideoAd.get(placementId);
        String dynamicUserId = getAdapter().getDynamicUserId();
        if (dynamicUserId != null && rewardedAd != null) {
            rewardedAd.setUserId(dynamicUserId);
        }
        ironLog.verbose("showRewardedVideo vungle ad " + placementId);
        postOnUIThread(new com.vungle.ads.internal.omsdk.a(rewardedAd, 18));
        k.d(placementId, "placementId");
        setRewardedVideoAdAvailability$vungleadapter_release(placementId, false);
    }
}
