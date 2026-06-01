package com.instagram.common.viewpoint.core;

import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0754Fs extends XO {
    public final /* synthetic */ C0753Fr A00;

    public C0754Fs(C0753Fr c0753Fr) {
        this.A00 = c0753Fr;
    }

    @Override // com.instagram.common.viewpoint.core.XO, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        XP.A0F(this.A00.A01);
        this.A00.A00.ADh();
    }
}
