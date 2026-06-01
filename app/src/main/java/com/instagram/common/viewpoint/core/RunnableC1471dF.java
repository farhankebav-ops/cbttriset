package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1471dF implements Runnable {
    public final /* synthetic */ C0715Ef A00;

    public RunnableC1471dF(C0715Ef c0715Ef) {
        this.A00 = c0715Ef;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0B() != 0) {
                this.A00.A05.scrollBy(this.A00.A01, 0);
                this.A00.A04.postDelayed(this, 16L);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
