package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC0721El implements Runnable {
    public final InterfaceC0720Ek A00;

    public RunnableC0721El(InterfaceC0720Ek interfaceC0720Ek) {
        this.A00 = interfaceC0720Ek;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.AE4();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
