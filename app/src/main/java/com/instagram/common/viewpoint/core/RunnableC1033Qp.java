package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1033Qp implements Runnable {
    public final /* synthetic */ C1034Qq A00;

    public RunnableC1033Qp(C1034Qq c1034Qq) {
        this.A00 = c1034Qq;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05 = 0L;
            this.A00.A06 = false;
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
