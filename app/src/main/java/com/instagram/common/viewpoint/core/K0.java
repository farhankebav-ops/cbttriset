package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K0 implements InterfaceC1261Zo {
    public final WeakReference<C04995h> A00;

    public K0(C04995h c04995h) {
        this.A00 = new WeakReference<>(c04995h);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1261Zo
    public final void ADT(C1260Zn c1260Zn) {
        C04995h c04995h = this.A00.get();
        if (c04995h != null) {
            c04995h.A04 = c1260Zn.A00() != null;
            c04995h.A02();
        }
    }
}
