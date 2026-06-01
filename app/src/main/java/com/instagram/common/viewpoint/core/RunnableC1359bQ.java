package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1359bQ implements Runnable {
    public final /* synthetic */ C0831Is A00;

    public RunnableC1359bQ(C0831Is c0831Is) {
        this.A00 = c0831Is;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0C = true;
            this.A00.A0c.A0E().AFE(true);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
