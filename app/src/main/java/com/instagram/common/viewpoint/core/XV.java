package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.bridge.gms.AdvertisingId;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class XV implements SU {
    public final /* synthetic */ AdvertisingId A00;
    public final /* synthetic */ XN A01;

    public XV(XN xn, AdvertisingId advertisingId) {
        this.A01 = xn;
        this.A00 = advertisingId;
    }

    @Override // com.instagram.common.viewpoint.core.SU
    public final boolean AAO() {
        return this.A00.isLimitAdTracking();
    }

    @Override // com.instagram.common.viewpoint.core.SU
    public final String getId() {
        return this.A00.getId();
    }
}
