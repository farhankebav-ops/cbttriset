package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Os, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0984Os extends XO {
    public final /* synthetic */ View A00;
    public final /* synthetic */ ScaleAnimation A01;

    public C0984Os(View view, ScaleAnimation scaleAnimation) {
        this.A00 = view;
        this.A01 = scaleAnimation;
    }

    @Override // com.instagram.common.viewpoint.core.XO, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A00.startAnimation(this.A01);
    }
}
