package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1305aY implements Runnable {
    public final /* synthetic */ C0862Jx A00;

    public RunnableC1305aY(C0862Jx c0862Jx) {
        this.A00 = c0862Jx;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A02 = true;
            if (((AbstractC1311ae) this.A00).A06.A0E() != null) {
                ((AbstractC1311ae) this.A00).A06.A0E().AFE(true);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
