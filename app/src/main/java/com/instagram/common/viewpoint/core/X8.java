package com.instagram.common.viewpoint.core;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class X8 implements InterfaceC1595fH {
    public final /* synthetic */ C1451cu A00;
    public final /* synthetic */ VR A01;

    public X8(VR vr, C1451cu c1451cu) {
        this.A01 = vr;
        this.A00 = c1451cu;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1595fH
    public final Map<String, String> A7r() {
        return this.A01.A0A(TY.A00().A01(this.A00, true).A06());
    }
}
