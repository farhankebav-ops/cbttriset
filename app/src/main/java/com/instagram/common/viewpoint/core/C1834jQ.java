package com.instagram.common.viewpoint.core;

import java.io.File;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1834jQ implements InterfaceC0883Ks<File> {
    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final C0882Kr<File> A3p(File file, LA la) {
        if (file.exists()) {
            return new C0882Kr<>(true, file);
        }
        return new C0882Kr<>(false, null);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final void A55(File file, LA la) {
    }
}
