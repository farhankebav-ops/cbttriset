package com.instagram.common.viewpoint.core;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1488dW extends ViewOutlineProvider {
    public final /* synthetic */ float A00;
    public final /* synthetic */ C1490dY A01;

    public C1488dW(C1490dY c1490dY, float f4) {
        this.A01 = c1490dY;
        this.A00 = f4;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.A00);
    }
}
