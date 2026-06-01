package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1252Zf implements Runnable {
    public final /* synthetic */ C1253Zg A00;
    public final /* synthetic */ InterfaceC1254Zh A01;

    public RunnableC1252Zf(C1253Zg c1253Zg, InterfaceC1254Zh interfaceC1254Zh) {
        this.A00 = c1253Zg;
        this.A01 = interfaceC1254Zh;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A01.ACO();
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
