package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.NativeAdViewTypeApi;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RN implements NativeAdViewTypeApi {
    public final EnumC1138Us A00;

    public RN(int i2) {
        this.A00 = EnumC1138Us.A00(i2);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getHeight() {
        return this.A00.A04();
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getValue() {
        return this.A00.A05();
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
    public final int getWidth() {
        return this.A00.A06();
    }
}
