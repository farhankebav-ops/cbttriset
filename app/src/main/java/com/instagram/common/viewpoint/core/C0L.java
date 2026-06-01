package com.instagram.common.viewpoint.core;

import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0L extends AbstractViewOnTouchListenerC03670d implements InterfaceC1441ck {
    public static byte[] A07;
    public static String[] A08 = {"J7yX0QGw9CwhbXJlOgK1AZPNtt2UF0On", "oXMSY1TARkqssgt6s8jHvILUEU9", "ivvOLLZvAzFcQQYEM", "46hEJr0dkjUa2YxjnqHHZtVzHBYgDtfX", "qOyhICr4SrTKnx9gG6JsVKrXp45uLK", "kbgvhlczlSdLn8qANYfrfCagYhnCySOb", "Z6RoLzaVoBLmlhzvAeWOPUTl5laN13sF", "YB9cTMd7bVO"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public InterfaceC1219Xy A04;
    public boolean A05;
    public final C6F A06;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 46);
            if (A08[0].charAt(21) != 'Z') {
                throw new RuntimeException();
            }
            A08[3] = "76s3uTgYoGqvxE8PFJZmOuk3NB8C1jhQ";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-68, -69, -99, -82, -76, -78, -112, -75, -82, -69, -76, -78, -79};
    }

    static {
        A03();
    }

    public C0L(C1477dL c1477dL) {
        super(c1477dL);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C6F(c1477dL, new C1438ch(), new C1437cg());
        A02();
    }

    public C0L(C1477dL c1477dL, AttributeSet attributeSet) {
        super(c1477dL, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C6F(c1477dL, new C1438ch(), new C1437cg());
        A02();
    }

    public C0L(C1477dL c1477dL, AttributeSet attributeSet, int i2) {
        super(c1477dL, attributeSet, i2);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C6F(c1477dL, new C1438ch(), new C1437cg());
        A02();
    }

    private int A00(int i2) {
        int i8 = this.A00 * 2;
        int measuredWidth = getMeasuredWidth();
        int spacing = getPaddingLeft();
        int i9 = (measuredWidth - spacing) - i8;
        int itemSize = getAdapter().A0B();
        int numFullItems = 0;
        int spacing2 = Integer.MAX_VALUE;
        while (spacing2 > i2) {
            numFullItems++;
            if (numFullItems >= itemSize) {
                return i2;
            }
            int spacing3 = numFullItems * i8;
            spacing2 = (int) ((i9 - spacing3) / (numFullItems + 0.333f));
        }
        return spacing2;
    }

    private void A02() {
        this.A06.A2C(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        XP.A0I(this);
    }

    private void A04(int i2, int i8) {
        if (i2 == this.A03 && i8 == this.A02) {
            return;
        }
        this.A03 = i2;
        this.A02 = i8;
        if (A08[3].charAt(25) != 'B') {
            throw new RuntimeException();
        }
        A08[2] = "arB2ao";
        if (0 != 0) {
            throw new NullPointerException(A01(0, 13, 31));
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractViewOnTouchListenerC03670d
    public final void A20(int i2, boolean z2) {
        super.A20(i2, z2);
        A04(i2, 0);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1441ck
    public final int A8g(int i2) {
        int iAbs = Math.abs(i2);
        int scrollXAbs = ((AbstractViewOnTouchListenerC03670d) this).A06;
        if (iAbs <= scrollXAbs) {
            return 0;
        }
        int scrollXAbs2 = this.A01;
        if (scrollXAbs2 == 0) {
            return 1;
        }
        int scrollXAbs3 = this.A01;
        return 1 + (iAbs / scrollXAbs3);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.C05246g, android.view.View
    public final void onMeasure(int i2, int i8) {
        int height;
        int itemSize;
        super.onMeasure(i2, i8);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A05) {
            int i9 = (int) AbstractC1180Wl.A02;
            int verticalPadding = U7.A0F(getContext());
            height = (i9 * verticalPadding) + paddingTop;
        } else {
            int verticalPadding2 = getMeasuredWidth();
            height = Math.round(verticalPadding2 / 1.91f);
        }
        int verticalPadding3 = View.MeasureSpec.getMode(i8);
        switch (verticalPadding3) {
            case Integer.MIN_VALUE:
                int verticalPadding4 = View.MeasureSpec.getSize(i8);
                height = Math.min(verticalPadding4, height);
                break;
            case BasicMeasure.EXACTLY /* 1073741824 */:
                height = View.MeasureSpec.getSize(i8);
                break;
        }
        int height2 = height - paddingTop;
        if (this.A05) {
            int verticalPadding5 = C1214Xt.A09;
            itemSize = Math.min(verticalPadding5, height2);
        } else {
            itemSize = A00(height2);
        }
        int height3 = getMeasuredWidth();
        int verticalPadding6 = itemSize + paddingTop;
        setMeasuredDimension(height3, verticalPadding6);
        if (!this.A05) {
            int verticalPadding7 = this.A00;
            setChildWidth((verticalPadding7 * 2) + itemSize);
        }
    }

    @Override // com.instagram.common.viewpoint.core.C05246g
    public void setAdapter(QC qc) {
        this.A06.A2J(qc == null ? -1 : qc.hashCode());
        super.setAdapter(qc);
    }

    public void setChildSpacing(int i2) {
        this.A00 = i2;
    }

    public void setChildWidth(int i2) {
        this.A01 = i2;
        int measuredWidth = getMeasuredWidth();
        int pageWidth = getPaddingLeft();
        int i8 = measuredWidth - pageWidth;
        int pageWidth2 = getPaddingRight();
        int i9 = i8 - pageWidth2;
        C6F c6f = this.A06;
        int pageWidth3 = this.A01;
        c6f.A2K((i9 - pageWidth3) / 2);
        C6F c6f2 = this.A06;
        int pageWidth4 = this.A01;
        c6f2.A2I(((double) pageWidth4) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i2) {
        A20(i2, false);
    }

    public void setOnPageChangedListener(InterfaceC1219Xy interfaceC1219Xy) {
        this.A04 = interfaceC1219Xy;
    }

    public void setShowTextInCarousel(boolean z2) {
        this.A05 = z2;
    }
}
