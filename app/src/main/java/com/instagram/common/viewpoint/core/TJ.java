package com.instagram.common.viewpoint.core;

import com.facebook.ads.AudienceNetworkAds;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TJ implements AudienceNetworkAds.InitResult {
    public final String A00;
    public final boolean A01;

    public TJ(boolean z2, String str) {
        this.A01 = z2;
        this.A00 = str;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitResult
    public final String getMessage() {
        return this.A00;
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitResult
    public final boolean isSuccess() {
        return this.A01;
    }
}
