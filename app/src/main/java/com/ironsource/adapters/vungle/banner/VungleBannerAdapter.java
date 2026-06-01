package com.ironsource.adapters.vungle.banner;

import android.content.Context;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.vungle.VungleAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.services.ads.operation.show.b;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleBannerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleBannerAdapter extends AbstractBannerAdapter<VungleAdapter> {
    private final ConcurrentHashMap<String, BannerSmashListener> mBannerPlacementToListenerMap;
    private final ConcurrentHashMap<String, VungleBannerView> mPlacementToBannerAd;

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
    public VungleBannerAdapter(VungleAdapter adapter) {
        super(adapter);
        k.e(adapter, "adapter");
        this.mBannerPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mPlacementToBannerAd = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBanner$lambda$4(JSONObject config, VungleBannerAdapter this$0) {
        k.e(config, "$config");
        k.e(this$0, "this$0");
        String strOptString = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog ironLog = IronLog.ADAPTER_API;
        a.p("placementId = ", strOptString, ironLog);
        VungleBannerView vungleBannerView = this$0.mPlacementToBannerAd.get(strOptString);
        if (vungleBannerView != null) {
            ironLog.verbose("destroyBanner Vungle ad, with PlacementId - " + strOptString);
            vungleBannerView.finishAd();
            this$0.mPlacementToBannerAd.remove(strOptString);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final VungleAdSize getBannerSize(ISBannerSize iSBannerSize) {
        String description = iSBannerSize.getDescription();
        if (description == null) {
            return null;
        }
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals(l.f9206c)) {
                    return VungleAdSize.MREC;
                }
                return null;
            case 72205083:
                if (!description.equals(l.f9205b)) {
                    return null;
                }
                break;
            case 79011241:
                if (description.equals(l.e)) {
                    return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? VungleAdSize.BANNER_LEADERBOARD : VungleAdSize.BANNER;
                }
                return null;
            case 1951953708:
                if (!description.equals(l.f9204a)) {
                    return null;
                }
                break;
            case 1999208305:
                if (description.equals("CUSTOM")) {
                    return VungleAdSize.Companion.getAdSizeWithWidthAndHeight(iSBannerSize.getWidth(), iSBannerSize.getHeight());
                }
                return null;
            default:
                return null;
        }
        return VungleAdSize.BANNER;
    }

    private final void initBannersInternal(JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String placementId = jSONObject.optString(VungleAdapter.PLACEMENT_ID);
        String appId = jSONObject.optString(VungleAdapter.APP_ID);
        if (placementId == null || placementId.length() == 0) {
            IronLog ironLog = IronLog.INTERNAL;
            k.d(placementId, "placementId");
            ironLog.error(getAdUnitIdMissingErrorString(placementId));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementId), "Banner"));
            return;
        }
        if (appId == null || appId.length() == 0) {
            IronLog ironLog2 = IronLog.INTERNAL;
            k.d(appId, "appId");
            ironLog2.error(getAdUnitIdMissingErrorString(appId));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(appId), "Banner"));
            return;
        }
        a.r("placementId = ", placementId, ", appId = ", appId, IronLog.ADAPTER_API);
        ConcurrentHashMap<String, BannerSmashListener> concurrentHashMap = this.mBannerPlacementToListenerMap;
        k.d(placementId, "placementId");
        concurrentHashMap.put(placementId, bannerSmashListener);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i2 == 1) {
            bannerSmashListener.onBannerInitSuccess();
            return;
        }
        if (i2 == 2) {
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Vungle SDK init failed", "Banner"));
            return;
        }
        VungleAdapter adapter = getAdapter();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        k.d(appId, "appId");
        adapter.initSDK(applicationContext, appId);
    }

    private final void loadBannerInternal(String str, ISBannerSize iSBannerSize, BannerSmashListener bannerSmashListener, String str2) throws Throwable {
        IronLog ironLog = IronLog.ADAPTER_API;
        a.p("placementId = ", str, ironLog);
        if (iSBannerSize == null) {
            IronLog.INTERNAL.error("banner size is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        VungleAdSize bannerSize = getBannerSize(iSBannerSize);
        if (bannerSize == null) {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        k.d(applicationContext, "getInstance().applicationContext");
        VungleBannerView vungleBannerView = new VungleBannerView(applicationContext, str, bannerSize);
        vungleBannerView.setAdListener(new VungleBannerAdListener(bannerSmashListener, str, vungleBannerView));
        this.mPlacementToBannerAd.put(str, vungleBannerView);
        ironLog.verbose("size = " + bannerSize);
        vungleBannerView.load(str2);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        k.e(config, "config");
        postOnUIThread(new b(15, config, this));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject config, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        initBannersInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String str, String str2, JSONObject config, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        initBannersInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject config, JSONObject jSONObject, ISBannerSize iSBannerSize, BannerSmashListener listener) throws Throwable {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + placementId);
        k.d(placementId, "placementId");
        loadBannerInternal(placementId, iSBannerSize, listener, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject jSONObject, String str, ISBannerSize iSBannerSize, BannerSmashListener listener) throws Throwable {
        k.e(config, "config");
        k.e(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + placementId);
        k.d(placementId, "placementId");
        loadBannerInternal(placementId, iSBannerSize, listener, str);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Collection<BannerSmashListener> collectionValues = this.mBannerPlacementToListenerMap.values();
        k.d(collectionValues, "mBannerPlacementToListenerMap.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((BannerSmashListener) it.next()).onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Collection<BannerSmashListener> collectionValues = this.mBannerPlacementToListenerMap.values();
        k.d(collectionValues, "mBannerPlacementToListenerMap.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((BannerSmashListener) it.next()).onBannerInitSuccess();
        }
    }
}
