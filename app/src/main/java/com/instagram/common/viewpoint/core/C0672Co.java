package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Co, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0672Co implements InterfaceC1519e2 {
    public int A00;
    public ValueAnimator A01;
    public EnumC1518e1 A02 = EnumC1518e1.A04;
    public final int A03;
    public final int A04;
    public final View A05;

    public C0672Co(View view, int i2, int i8, int i9) {
        this.A05 = view;
        this.A03 = i2;
        this.A00 = i8;
        this.A04 = i9;
    }

    private ValueAnimator A00(int i2, int i8, View view) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, i8);
        valueAnimatorOfInt.setDuration(this.A03);
        valueAnimatorOfInt.addUpdateListener(new C1522e5(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z2) {
        if (z2) {
            this.A02 = EnumC1518e1.A05;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new C1521e4(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        XP.A0F(this.A05);
        this.A02 = EnumC1518e1.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        XP.A0J(this.A05);
        if (z2) {
            this.A02 = EnumC1518e1.A03;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new C1520e3(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = EnumC1518e1.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void A42(boolean z2, boolean z7) {
        if (z7) {
            A07(z2);
        } else {
            A08(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final EnumC1518e1 A93() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void cancel() {
        if (this.A01 != null) {
            this.A01.cancel();
        }
    }
}
