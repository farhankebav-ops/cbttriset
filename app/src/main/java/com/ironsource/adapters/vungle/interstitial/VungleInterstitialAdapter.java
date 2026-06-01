package com.ironsource.adapters.vungle.interstitial;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.vungle.VungleAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.AdConfig;
import com.vungle.ads.FullscreenAd;
import com.vungle.ads.InterstitialAd;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleInterstitialAdapter extends AbstractInterstitialAdapter<VungleAdapter> {
    private final ConcurrentHashMap<String, InterstitialSmashListener> mInterstitialPlacementToListenerMap;
    private final ConcurrentHashMap<String, Boolean> mPlacementIdToAdAvailability;
    private final ConcurrentHashMap<String, InterstitialAd> mPlacementToInterstitialAd;

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
    public VungleInterstitialAdapter(VungleAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
        this.mPlacementToInterstitialAd = new ConcurrentHashMap<>();
        this.mInterstitialPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mPlacementIdToAdAvailability = new ConcurrentHashMap<>();
    }

    private final void initInterstitialInternal(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String placementId = jSONObject.optString(VungleAdapter.PLACEMENT_ID);
        String appId = jSONObject.optString(VungleAdapter.APP_ID);
        k.d(placementId, "placementId");
        if (placementId.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(VungleAdapter.PLACEMENT_ID));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementId), "Interstitial"));
            return;
        }
        k.d(appId, "appId");
        if (appId.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(VungleAdapter.APP_ID));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(appId), "Interstitial"));
            return;
        }
        a.r("placementId = ", placementId, ", appId = ", appId, IronLog.ADAPTER_API);
        this.mInterstitialPlacementToListenerMap.put(placementId, interstitialSmashListener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            interstitialSmashListener.onInterstitialInitSuccess();
            return;
        }
        if (i2 == 2) {
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Vungle SDK Init Failed", "Interstitial"));
            return;
        }
        VungleAdapter adapter = getAdapter();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        adapter.initSDK(applicationContext, appId);
    }

    private final void loadInterstitialInternal(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str) {
        String placementId = jSONObject.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("loadInterstitial Vungle ad with placementId = " + placementId);
        k.d(placementId, "placementId");
        setInterstitialAdAvailability$vungleadapter_release(placementId, false);
        VungleInterstitialAdListener vungleInterstitialAdListener = new VungleInterstitialAdListener(new WeakReference(this), interstitialSmashListener, placementId);
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        InterstitialAd interstitialAd = new InterstitialAd(applicationContext, placementId, new AdConfig());
        interstitialAd.setAdListener(vungleInterstitialAdListener);
        this.mPlacementToInterstitialAd.put(placementId, interstitialAd);
        interstitialAd.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInterstitial$lambda$3(InterstitialAd interstitialAd) {
        if (interstitialAd != null) {
            FullscreenAd.DefaultImpls.play$default(interstitialAd, null, 1, null);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        initInterstitialInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        initInterstitialInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        InterstitialAd interstitialAd;
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
        if (bool.booleanValue() && (interstitialAd = this.mPlacementToInterstitialAd.get(placementId)) != null) {
            return interstitialAd.canPlayAd().booleanValue();
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject config, JSONObject jSONObject, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        a.p("loadInterstitial Vungle ad with placementId = ", config.optString(VungleAdapter.PLACEMENT_ID), IronLog.ADAPTER_API);
        loadInterstitialInternal(config, listener, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject jSONObject, String str, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        a.p("loadInterstitial Vungle ad with placementId = ", config.optString(VungleAdapter.PLACEMENT_ID), IronLog.ADAPTER_API);
        loadInterstitialInternal(config, listener, str);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Collection<InterstitialSmashListener> collectionValues = this.mInterstitialPlacementToListenerMap.values();
        k.d(collectionValues, "mInterstitialPlacementToListenerMap.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((InterstitialSmashListener) it.next()).onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Collection<InterstitialSmashListener> collectionValues = this.mInterstitialPlacementToListenerMap.values();
        k.d(collectionValues, "mInterstitialPlacementToListenerMap.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((InterstitialSmashListener) it.next()).onInterstitialInitSuccess();
        }
    }

    public final void setInterstitialAdAvailability$vungleadapter_release(String placementId, boolean z2) {
        k.e(placementId, "placementId");
        this.mPlacementIdToAdAvailability.put(placementId, Boolean.valueOf(z2));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + placementId);
        if (!isInterstitialReady(config)) {
            IronLog.INTERNAL.error("There is no ad available for placementId = " + placementId);
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
            return;
        }
        InterstitialAd interstitialAd = this.mPlacementToInterstitialAd.get(placementId);
        ironLog.verbose("showInterstitial vungle ad <" + placementId);
        postOnUIThread(new com.vungle.ads.internal.omsdk.a(interstitialAd, 14));
        k.d(placementId, "placementId");
        setInterstitialAdAvailability$vungleadapter_release(placementId, false);
    }
}
