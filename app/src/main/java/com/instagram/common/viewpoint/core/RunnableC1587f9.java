package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1587f9 implements Runnable {
    public final /* synthetic */ C0655Bw A00;

    public RunnableC1587f9(C0655Bw c0655Bw) {
        this.A00 = c0655Bw;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            C0655Bw.A03(this.A00);
            throw null;
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
