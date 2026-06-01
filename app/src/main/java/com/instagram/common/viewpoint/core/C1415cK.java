package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1415cK implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C4K A00;

    public C1415cK(C4K c4k) {
        this.A00 = c4k;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        this.A00.A0X.getLayoutParams().height = num.intValue();
        this.A00.A0X.requestLayout();
    }
}
