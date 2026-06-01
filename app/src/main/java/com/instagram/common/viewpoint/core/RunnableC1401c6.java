package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1401c6 implements Runnable {
    public final /* synthetic */ C04794n A00;

    public RunnableC1401c6(C04794n c04794n) {
        this.A00 = c04794n;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A07 = true;
            this.A00.A0M.AFE(true);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
