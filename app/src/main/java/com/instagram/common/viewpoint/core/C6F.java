package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6F extends C1657gI {
    public static String[] A08 = {"3Z4oVcBXIxTGfHDkJENHcNR3oKWZn0O4", "rFv82zPhlr6ageKpcxYW53i7WQEhI", "2tYR0SC80tVMegpE61nD", "NxUbiyfiYIyXyrFLuBvPtjT94e88s", "0hjSAQsR9gnR7LOOW", "3YJcpQnZmcsLDiaVOnEQeEpmcgGPkAOH", "Bqc2ZUTwiywYobMvaWapE1roD64Q2E5u", "7wlgBc9wtLyqXjV7RP"};
    public float A00;
    public int A01;
    public int A02;
    public C6G A03;
    public int[] A04;
    public final C1477dL A05;
    public final C1437cg A06;
    public final C1438ch A07;

    public C6F(C1477dL c1477dL, C1438ch c1438ch, C1437cg c1437cg) {
        super(c1477dL);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = c1477dL;
        this.A07 = c1438ch;
        this.A06 = c1437cg;
        this.A01 = -1;
        this.A03 = new C6G(this, this.A05);
    }

    @Override // com.instagram.common.viewpoint.core.QO
    public final void A1L(QW qw, C1021Qd c1021Qd, int i2, int widthMode) {
        int[] iArrA02;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(widthMode);
        if ((mode == 1073741824 && A28() == 1) || (mode2 == 1073741824 && A28() == 0)) {
            super.A1L(qw, c1021Qd, i2, widthMode);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(widthMode);
        if (this.A06.A01(this.A01)) {
            iArrA02 = this.A06.A02(this.A01);
        } else {
            iArrA02 = new int[]{0, 0};
            if (c1021Qd.A03() >= 1) {
                int i8 = A0Y() > 0 ? 1 : A0Y();
                for (int heightMode = 0; heightMode < i8; heightMode++) {
                    View viewA1o = A1o(heightMode);
                    if (viewA1o == null) {
                        break;
                    }
                    this.A04 = this.A07.A00(viewA1o, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (A28() == 0) {
                        iArrA02[0] = iArrA02[0] + this.A04[0];
                        if (heightMode == 0) {
                            iArrA02[1] = this.A04[1] + A0i() + A0f();
                        }
                    } else {
                        iArrA02[1] = iArrA02[1] + this.A04[1];
                        if (heightMode == 0) {
                            iArrA02[0] = this.A04[0] + A0g() + A0h();
                        }
                    }
                }
                int i9 = this.A01;
                String[] strArr = A08;
                if (strArr[1].length() != strArr[3].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[0] = "c7gaApi93PYPuTyj4vut3Dl9rZW6DyZw";
                strArr2[7] = "eCokdcVdwhThfuMVf9";
                if (i9 != -1) {
                    this.A06.A00(this.A01, iArrA02);
                }
            }
        }
        if (mode == 1073741824) {
            iArrA02[0] = size;
        }
        if (mode2 == 1073741824) {
            iArrA02[1] = size2;
        }
        A15(iArrA02[0], iArrA02[1]);
    }

    @Override // com.instagram.common.viewpoint.core.C1657gI, com.instagram.common.viewpoint.core.QO
    public final void A1r(int i2) {
        A2D(i2, this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.C1657gI, com.instagram.common.viewpoint.core.QO
    public final void A1z(C05246g c05246g, C1021Qd c1021Qd, int i2) {
        this.A03.A0A(i2);
        A1N(this.A03);
    }

    public final void A2I(double d8) {
        if (d8 <= 0.0d) {
            d8 = 1.0d;
        }
        this.A00 = (float) (50.0d / d8);
        this.A03 = new C6G(this, this.A05);
    }

    public final void A2J(int i2) {
        this.A01 = i2;
    }

    public final void A2K(int i2) {
        this.A02 = i2;
    }
}
