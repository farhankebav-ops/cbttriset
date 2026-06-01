package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QA implements Runnable {
    public final /* synthetic */ C05246g A00;

    public QA(C05246g c05246g) {
        this.A00 = c05246g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.A00.A05 != null) {
            this.A00.A05.A0I();
        }
        this.A00.A0K = false;
    }
}
