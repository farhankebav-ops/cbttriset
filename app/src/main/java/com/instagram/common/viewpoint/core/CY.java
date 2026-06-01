package com.instagram.common.viewpoint.core;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CY implements InterfaceC1519e2 {
    public static byte[] A06;
    public ValueAnimator A00;
    public EnumC1518e1 A01 = EnumC1518e1.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{49, 32, 61, 49, 6, 42, 41, 42, 55};
    }

    public CY(View view, int i2, int i8, int i9) {
        this.A02 = i2;
        this.A05 = view;
        this.A04 = i8;
        this.A03 = i9;
    }

    private void A06(int i2, int i8) {
        this.A01 = i2 == this.A04 ? EnumC1518e1.A03 : EnumC1518e1.A05;
        this.A00 = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 85), i2, i8);
        this.A00.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C1525e8(this, i2, i8));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i2, int i8, boolean z2) {
        if (z2) {
            A06(i2, i8);
        } else {
            ((TextView) this.A05).setTextColor(i8);
            this.A01 = i8 == this.A03 ? EnumC1518e1.A02 : EnumC1518e1.A04;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1519e2
    public final void A42(boolean z2, boolean z7) {
        int endColor = z7 ? this.A03 : this.A04;
        int startColor = z7 ? this.A04 : this.A03;
        A07(endColor, startColor, z2);
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
