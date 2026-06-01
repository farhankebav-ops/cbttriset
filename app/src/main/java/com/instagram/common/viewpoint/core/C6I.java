package com.instagram.common.viewpoint.core;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6I implements QQ {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C6I(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1127Uh
    public final void ACD() {
        AbstractC1155Vk.A00(new QG(this));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1127Uh
    public final void ACH() {
        AbstractC1155Vk.A00(new QH(this));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1127Uh
    public final void ADB(V1 v12) {
        AbstractC1155Vk.A00(new QN(this, v12));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1127Uh
    public final void AE6() {
        AbstractC1155Vk.A00(new Q0(this));
    }

    @Override // com.instagram.common.viewpoint.core.QQ
    public final void AEB() {
        AbstractC1155Vk.A00(new QL(this));
    }
}
