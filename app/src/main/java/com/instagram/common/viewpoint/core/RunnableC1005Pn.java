package com.instagram.common.viewpoint.core;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1005Pn implements Runnable {
    public final /* synthetic */ C05276j A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC1005Pn(C05276j c05276j, ArrayList arrayList) {
        this.A00 = c05276j;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (C1014Pw c1014Pw : this.A01) {
            this.A00.A0e(c1014Pw.A04, c1014Pw.A00, c1014Pw.A01, c1014Pw.A02, c1014Pw.A03);
        }
        this.A01.clear();
        this.A00.A05.remove(this.A01);
    }
}
