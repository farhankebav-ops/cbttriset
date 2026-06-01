package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1279a8 extends RelativeLayout {
    public static String[] A06 = {"5SHdRwFrRc5I045mD2ED8hkR", "u607MEARHNz8UhlPP1yTj4t381pEaF91", "vukf6ONNN7udfcALTJGLQQCjk2MRvNqz", "", "LcpvFkzcfh74Tt7JU5VGWxCVkX9ufVQR", "0vcUNZ0oTZNrvLONhpGozykOOsxw8rlk", "", "YDZhxKGTPmLilHONF7GF9MvjPIJLKPZP"};
    public final int A00;
    public final LinearLayout A01;
    public final C1750hw A02;
    public final C1477dL A03;
    public final US A04;
    public final InterfaceC1208Xn A05;

    public C1279a8(C1477dL c1477dL, C1750hw c1750hw, US us, InterfaceC1208Xn interfaceC1208Xn, int i2, int i8) {
        super(c1477dL);
        this.A03 = c1477dL;
        this.A02 = c1750hw;
        this.A04 = us;
        this.A05 = interfaceC1208Xn;
        this.A00 = i2;
        this.A01 = new LinearLayout(c1477dL);
        A00();
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        setLayoutOrientation(i8);
    }

    private void A00() {
        int i2 = 0;
        while (true) {
            int iA1u = this.A02.A1u();
            String[] strArr = A06;
            String str = strArr[2];
            String str2 = strArr[4];
            int iCharAt = str.charAt(18);
            int i8 = str2.charAt(18);
            if (iCharAt == i8) {
                throw new RuntimeException();
            }
            A06[7] = "iNncIzrUEB4NW29LDzlz6YUCQOx5Utak";
            if (i2 < iA1u) {
                KI ki = new KI(this.A03, this.A02.A1x(i2), this.A04, this.A05);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.weight = 1.0f;
                int i9 = KI.A0C;
                int i10 = KI.A0C;
                int i11 = KI.A0C;
                int i12 = KI.A0C;
                layoutParams.setMargins(i9, i10, i11, i12);
                ki.setLayoutParams(layoutParams);
                this.A01.addView(ki);
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutOrientation(configuration.orientation);
    }

    private void setLayoutOrientation(int i2) {
        if (i2 != 1) {
            this.A01.setOrientation(0);
            this.A01.setPadding(0, this.A00, 0, (int) (((double) this.A00) * 0.25d));
        } else {
            this.A01.setOrientation(1);
            this.A01.setPadding(0, (int) (((double) this.A00) * 1.5d), 0, this.A00);
        }
    }
}
