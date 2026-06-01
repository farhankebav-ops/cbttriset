package com.instagram.common.viewpoint.core;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1198Xd {
    public static C1198Xd A02;
    public final C0978Om A00;
    public final C1200Xf A01;

    public C1198Xd(C1477dL c1477dL, Executor executor, TE te) {
        this.A01 = new C1200Xf(c1477dL);
        this.A00 = new C0978Om(executor, te, c1477dL);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C1477dL c1477dL, Executor executor, TE te) {
        if (!U7.A1X(c1477dL)) {
            return;
        }
        if (A02 == null) {
            A02 = new C1198Xd(c1477dL, executor, te);
            A02.A00();
        } else {
            A02.A02(te);
        }
    }

    private void A02(TE te) {
        this.A00.A07(te);
    }
}
