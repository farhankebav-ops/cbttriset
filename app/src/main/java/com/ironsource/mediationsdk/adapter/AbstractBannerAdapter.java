package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBannerAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements BannerAdapterInterface {
    public AbstractBannerAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectBannerBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> bannerBiddingData = getBannerBiddingData(config, jSONObject);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyBanner(JSONObject config) {
        k.e(config, "config");
    }

    public int getAdaptiveHeight(int i2) {
        return -1;
    }

    public Map<String, Object> getBannerBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return null;
    }

    public LoadWhileShowSupportState getBannerLoadWhileShowSupportState(JSONObject jSONObject) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public void initBannerForBidding(String str, String str2, JSONObject config, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void initBanners(String str, String str2, JSONObject config, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void loadBanner(JSONObject config, JSONObject jSONObject, ISBannerSize iSBannerSize, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void loadBannerForBidding(JSONObject config, JSONObject jSONObject, String str, ISBannerSize iSBannerSize, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForDemandOnlyForBidding(JSONObject config, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewBound(JSONObject config) {
        k.e(config, "config");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewWillBind(JSONObject config) {
        k.e(config, "config");
    }
}
