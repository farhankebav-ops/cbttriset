package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class A4 implements InterfaceC2200pt {
    public final C2194pm A00;

    public A4(C2194pm c2194pm) {
        this.A00 = c2194pm;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2200pt
    public final void onStart() {
        this.A00.A0D();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2200pt
    public final void onStop() {
        this.A00.A0C();
    }
}
