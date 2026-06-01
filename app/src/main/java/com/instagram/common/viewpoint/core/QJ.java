package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QJ {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final QJ A00(AbstractC1024Qg abstractC1024Qg, int i2) {
        View view = abstractC1024Qg.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final QJ A01(AbstractC1024Qg abstractC1024Qg) {
        return A00(abstractC1024Qg, 0);
    }
}
