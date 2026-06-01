package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Il, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0824Il implements InterfaceC1261Zo {
    public final WeakReference<C5Q> A00;

    public C0824Il(C5Q c5q) {
        this.A00 = new WeakReference<>(c5q);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1261Zo
    public final void ADT(C1260Zn c1260Zn) {
        C5Q c5q = this.A00.get();
        if (c5q != null) {
            c5q.A06 = c1260Zn.A00() != null;
            c5q.A02();
        }
    }
}
