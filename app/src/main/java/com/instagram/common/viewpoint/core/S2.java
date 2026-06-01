package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S2 extends Thread {
    public final long A00;

    public S2(long j) {
        this.A00 = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        while (true) {
            try {
                try {
                    Thread.sleep(this.A00);
                } catch (InterruptedException unused) {
                }
                S0.A01();
            } catch (Throwable th) {
                AbstractC1156Vl.A00(th, this);
                return;
            }
        }
    }
}
