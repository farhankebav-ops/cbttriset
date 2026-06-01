package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ko, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0879Ko extends AbstractRunnableC1164Vt {
    public final WeakReference<C1550eX> A00;

    public C0879Ko(C1550eX c1550eX) {
        this.A00 = new WeakReference<>(c1550eX);
    }

    public C0879Ko(WeakReference<C1550eX> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        C1550eX viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
