package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractNativeAdAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements NativeAdAdapterInterface {
    public AbstractNativeAdAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectNativeAdBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(config, jSONObject);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyNativeAd(JSONObject config) {
        k.e(config, "config");
    }

    public Map<String, Object> getNativeAdBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return null;
    }

    public final NativeAdProperties getNativeAdProperties(JSONObject config) {
        k.e(config, "config");
        return new NativeAdProperties(config);
    }

    public void initNativeAdForBidding(String str, String str2, JSONObject config, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void initNativeAds(String str, String str2, JSONObject config, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void loadNativeAd(JSONObject config, JSONObject jSONObject, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void loadNativeAdForBidding(JSONObject config, JSONObject jSONObject, String str, NativeAdSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }
}
