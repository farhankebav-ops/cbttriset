package com.instagram.common.viewpoint.core;

import java.io.File;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1833jP implements InterfaceC0883Ks<String> {
    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final C0882Kr<String> A3p(File file, LA la) {
        String strA05 = LB.A05(file);
        return new C0882Kr<>(strA05 != null, strA05);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final void A55(File file, LA la) {
    }
}
