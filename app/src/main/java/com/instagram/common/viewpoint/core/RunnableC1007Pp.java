package com.instagram.common.viewpoint.core;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1007Pp implements Runnable {
    public final /* synthetic */ C05276j A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC1007Pp(C05276j c05276j, ArrayList arrayList) {
        this.A00 = c05276j;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (AbstractC1024Qg holder : this.A01) {
            this.A00.A0d(holder);
        }
        this.A01.clear();
        this.A00.A01.remove(this.A01);
    }
}
