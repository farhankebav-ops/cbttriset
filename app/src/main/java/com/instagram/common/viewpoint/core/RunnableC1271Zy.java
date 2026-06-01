package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1271Zy implements Runnable {
    public final /* synthetic */ KL A00;

    public RunnableC1271Zy(KL kl) {
        this.A00 = kl;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0m();
            this.A00.A0n();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
