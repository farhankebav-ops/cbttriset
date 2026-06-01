package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1693gu implements InterfaceC0955Nn {
    public final /* synthetic */ C1694gv A00;
    public final /* synthetic */ C1692gt A01;

    public C1693gu(C1692gt c1692gt, C1694gv c1694gv) {
        this.A01 = c1692gt;
        this.A00 = c1694gv;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0955Nn
    public final InterfaceC0954Nm A5K(InterfaceC0942Na interfaceC0942Na, AbstractC1711hD abstractC1711hD, HandlerC0949Nh handlerC0949Nh) {
        return new C1691gs(this.A00.A05(), this.A00, interfaceC0942Na, abstractC1711hD, handlerC0949Nh);
    }
}
