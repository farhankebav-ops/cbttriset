package com.instagram.common.viewpoint.core;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0753Fr extends AbstractRunnableC1164Vt {
    public final /* synthetic */ InterfaceC1427cW A00;
    public final /* synthetic */ C1428cX A01;

    public C0753Fr(C1428cX c1428cX, InterfaceC1427cW interfaceC1427cW) {
        this.A01 = c1428cX;
        this.A00 = interfaceC1427cW;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C0754Fs(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
