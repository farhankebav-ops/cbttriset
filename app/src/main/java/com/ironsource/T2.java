package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class T2 extends C2511q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ISBannerSize f7613b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T2(C2314f0 adProperties, ISBannerSize iSBannerSize) {
        super(adProperties);
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        this.f7613b = iSBannerSize;
    }

    @Override // com.ironsource.C2511q0, com.ironsource.InterfaceC2352h2
    public void a(com.ironsource.mediationsdk.i auctionRequestParams) {
        kotlin.jvm.internal.k.e(auctionRequestParams, "auctionRequestParams");
        super.a(auctionRequestParams);
        auctionRequestParams.a(this.f7613b);
    }
}
