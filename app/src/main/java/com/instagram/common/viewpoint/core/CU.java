package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CU implements InterfaceC1519e2 {
    public ValueAnimator A00;
    public EnumC1518e1 A01 = EnumC1518e1.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public CU(View view, int i2, int i8, int i9) {
        this.A05 = view;
        this.A02 = i2;
        this.A04 = i8;
        this.A03 = i9;
    }

    private ValueAnimator A00(View view, int i2, int i8) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i8);
        valueAnimatorOfInt.setDuration(this.A02);
        valueAnimatorOfInt.addUpdateListener(new C1528eB(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A00 != null) {
            this.A00.removeAllListeners();
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        if (z2) {
            this.A01 = EnumC1518e1.A05;
            this.A00 = A00(this.A05, this.A03, this.A04);
            this.A00.addListener(new C1527eA(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        XP.A0F(this.A05);
        this.A01 = EnumC1518e1.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z2) {
        XP.A0J(this.A05);
        if (z2) {
            this.A01 = EnumC1518e1.A03;
            this.A00 = A00(this.A05, this.A04, this.A03);
            this.A00.addListener(new C1526e9(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A03);
        this.A01 = EnumC1518e1.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void A42(boolean z2, boolean z7) {
        if (z7) {
            A08(z2);
        } else {
            A09(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final EnumC1518e1 A93() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
