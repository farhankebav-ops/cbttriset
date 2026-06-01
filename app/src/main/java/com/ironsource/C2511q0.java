package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2511q0 implements InterfaceC2352h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2314f0 f9686a;

    public C2511q0(C2314f0 adProperties) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        this.f9686a = adProperties;
    }

    @Override // com.ironsource.InterfaceC2352h2
    public void a(com.ironsource.mediationsdk.i auctionRequestParams) {
        kotlin.jvm.internal.k.e(auctionRequestParams, "auctionRequestParams");
        auctionRequestParams.b(this.f9686a.c());
        auctionRequestParams.a(this.f9686a.a().toString());
        auctionRequestParams.a(Boolean.TRUE);
    }
}
