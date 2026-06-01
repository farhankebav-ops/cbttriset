package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1269Zw implements Runnable {
    public final /* synthetic */ KL A00;

    public RunnableC1269Zw(KL kl) {
        this.A00 = kl;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0H.getVisibility() == 0) {
                this.A00.A0p(8);
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
