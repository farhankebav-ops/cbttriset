package com.ironsource.adapters.pangle;

import com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback;
import com.ironsource.adapters.unityads.UnityAdsAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.unity3d.ads.IUnityAdsTokenListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements BiddingTokenCallback, IUnityAdsTokenListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BiddingDataCallback f7986a;

    public /* synthetic */ a(BiddingDataCallback biddingDataCallback) {
        this.f7986a = biddingDataCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback
    public void onBiddingTokenCollected(String str) {
        PangleAdapter.collectBiddingData$lambda$18(this.f7986a, str);
    }

    @Override // com.unity3d.ads.IUnityAdsTokenListener
    public void onUnityAdsTokenReady(String str) {
        UnityAdsAdapter.collectBiddingData$lambda$7(this.f7986a, str);
    }
}
