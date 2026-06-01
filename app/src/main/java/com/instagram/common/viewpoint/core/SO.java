package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SO {
    public final AtomicBoolean A00 = new AtomicBoolean(false);

    public final void A00(boolean z2) {
        this.A00.set(z2);
    }

    public final boolean A01() {
        return this.A00.get();
    }
}
