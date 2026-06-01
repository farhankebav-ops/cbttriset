package com.instagram.common.viewpoint.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0684Da extends RelativeLayout implements InterfaceC1494dc {
    public E1 A00;

    public AbstractC0684Da(C1477dL c1477dL) {
        super(c1477dL);
    }

    public AbstractC0684Da(C1477dL c1477dL, AttributeSet attributeSet, int i2) {
        super(c1477dL, attributeSet, i2);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AAm(E1 e12) {
        this.A00 = e12;
        A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494dc
    public final void AJk(E1 e12) {
        A08();
        this.A00 = null;
    }

    public E1 getVideoView() {
        return this.A00;
    }
}
