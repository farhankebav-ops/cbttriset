package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1302aV {
    public static float A00(C0931Mp c0931Mp) {
        int height = c0931Mp.A0H().A01();
        int width = c0931Mp.A0H().A00();
        if (width > 0) {
            return height / width;
        }
        return -1.0f;
    }

    public static int A01(double d8) {
        int availableWidth = (int) (((double) (AbstractC1179Wk.A00().widthPixels - (AbstractC1311ae.A07 * 2))) / d8);
        return availableWidth;
    }

    public static int A02(int bottomMargin) {
        int ctaMargin = XP.A01(16);
        int ctaTextHeight = AbstractC1282aB.A0D;
        int ctaSpacing = ctaTextHeight * 2;
        int ctaTextHeight2 = AbstractC1311ae.A07;
        int ctaMargin2 = ctaMargin + ctaSpacing + (ctaTextHeight2 * 2);
        int ctaTextHeight3 = AbstractC1179Wk.A00().heightPixels;
        return (ctaTextHeight3 - bottomMargin) - ctaMargin2;
    }

    public static ViewOnClickListenerC1301aU A03(KE ke, String str) {
        return new ViewOnClickListenerC1301aU(ke, str);
    }

    public static boolean A04(double d8) {
        return d8 < 0.9d;
    }

    public static boolean A05(double d8, int i2) {
        return A02(i2) < A01(d8);
    }

    public static boolean A06(int i2, int i8, double d8) {
        return i2 == 2 || A05(d8, i8);
    }
}
