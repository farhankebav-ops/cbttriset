package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractInterstitialAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements InterstitialAdapterInterface {
    public AbstractInterstitialAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectInterstitialBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        k.e(config, "config");
        k.e(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(config, jSONObject);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject config, JSONObject jSONObject) {
        k.e(config, "config");
        return null;
    }

    public void initInterstitial(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public boolean isInterstitialReady(JSONObject config) {
        k.e(config, "config");
        return false;
    }

    public void loadInterstitial(JSONObject config, JSONObject jSONObject, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void loadInterstitialForBidding(JSONObject config, JSONObject jSONObject, String str, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        k.e(config, "config");
        k.e(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void destroyInterstitialAd(JSONObject jSONObject) {
    }
}
