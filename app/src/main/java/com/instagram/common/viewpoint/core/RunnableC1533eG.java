package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1533eG implements Runnable {
    public final /* synthetic */ C1536eJ A00;

    public RunnableC1533eG(C1536eJ c1536eJ) {
        this.A00 = c1536eJ;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0A();
            this.A00.A01.removeCallbacks(this);
            this.A00.A01.postDelayed(this, 250L);
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
