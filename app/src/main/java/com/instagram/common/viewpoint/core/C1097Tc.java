package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1097Tc implements InterfaceC1130Uk {
    public WeakReference<C1020Qc> A00;

    public C1097Tc(C1020Qc c1020Qc) {
        this.A00 = new WeakReference<>(c1020Qc);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1130Uk
    public final void AEW(boolean z2) {
        if (this.A00.get() != null) {
            this.A00.get().A1f(z2, false);
        }
    }
}
