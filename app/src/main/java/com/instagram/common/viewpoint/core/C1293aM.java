package com.instagram.common.viewpoint.core;

import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1293aM extends LinearLayout {
    public static final int A06 = (int) (AbstractC1180Wl.A02 * 4.0f);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C1477dL A04;
    public final C1294aN[] A05;

    public C1293aM(C1477dL c1477dL, int i2, int i8, int i9, int i10) {
        super(c1477dL);
        this.A00 = A06;
        this.A04 = c1477dL;
        setOrientation(0);
        this.A03 = i2;
        this.A01 = i9;
        this.A02 = i10;
        this.A05 = new C1294aN[i8];
        for (int i11 = 0; i11 < i8; i11++) {
            this.A05[i11] = A00();
            addView(this.A05[i11]);
        }
        A01();
    }

    private C1294aN A00() {
        C1294aN c1294aN = new C1294aN(this.A04, this.A01, this.A02);
        LinearLayout.LayoutParams starRatingViewParams = new LinearLayout.LayoutParams(this.A03, this.A03);
        starRatingViewParams.gravity = 16;
        c1294aN.setLayoutParams(starRatingViewParams);
        return c1294aN;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.aN[] r0 = r3.A05
            int r0 = r0.length
            if (r2 >= r0) goto L1b
            com.facebook.ads.redexgen.X.aN[] r0 = r3.A05
            r0 = r0[r2]
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            if (r2 != 0) goto L18
            r0 = 0
        L13:
            r1.leftMargin = r0
            int r2 = r2 + 1
            goto L1
        L18:
            int r0 = r3.A00
            goto L13
        L1b:
            r3.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1293aM.A01():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(float r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.aN[] r0 = r3.A05
            int r0 = r0.length
            if (r2 >= r0) goto L1f
            float r0 = (float) r2
            float r1 = r4 - r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = java.lang.Math.min(r0, r1)
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L15
            r1 = 0
        L15:
            com.facebook.ads.redexgen.X.aN[] r0 = r3.A05
            r0 = r0[r2]
            r0.setFillRatio(r1)
            int r2 = r2 + 1
            goto L1
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1293aM.A02(float):void");
    }

    public void setItemSpacing(int i2) {
        this.A00 = i2;
        A01();
    }

    public void setRating(float f4) {
        A02(f4);
    }
}
