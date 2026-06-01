package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1432cb implements Runnable {
    public final /* synthetic */ C04573r A00;

    public RunnableC1432cb(C04573r c04573r) {
        this.A00 = c04573r;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            ((G2) this.A00).A09.A4b(((G2) this.A00).A0A.A7o());
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
