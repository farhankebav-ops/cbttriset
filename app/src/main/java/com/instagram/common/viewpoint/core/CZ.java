package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CZ implements InterfaceC1519e2 {
    public ViewPropertyAnimator A00;
    public EnumC1518e1 A01 = EnumC1518e1.A04;
    public final int A02;
    public final View A03;
    public final boolean A04;

    public CZ(View view, int i2, boolean z2) {
        this.A02 = i2;
        this.A03 = view;
        this.A04 = z2;
    }

    private void A04(boolean z2) {
        this.A01 = EnumC1518e1.A03;
        if (this.A04) {
            XP.A0J(this.A03);
        }
        if (!z2) {
            this.A03.setAlpha(1.0f);
            this.A01 = EnumC1518e1.A02;
        } else {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new C1523e6(this));
        }
    }

    private void A05(boolean z2) {
        this.A01 = EnumC1518e1.A05;
        if (!z2) {
            this.A03.setAlpha(0.0f);
            this.A01 = EnumC1518e1.A04;
        } else {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration(this.A02).setListener(new C1524e7(this));
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void A42(boolean z2, boolean z7) {
        if (z7) {
            A05(z2);
        } else {
            A04(z2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final EnumC1518e1 A93() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void cancel() {
        this.A03.clearAnimation();
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
