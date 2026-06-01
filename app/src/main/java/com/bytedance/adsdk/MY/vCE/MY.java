package com.bytedance.adsdk.MY.vCE;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static float IlO(float f4) {
        return f4 <= 0.0031308f ? f4 * 12.92f : (float) ((Math.pow(f4, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float MY(float f4) {
        return f4 <= 0.04045f ? f4 / 12.92f : (float) Math.pow((f4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int IlO(float f4, int i2, int i8) {
        if (i2 == i8) {
            return i2;
        }
        float f8 = ((i2 >> 24) & 255) / 255.0f;
        float f9 = ((i8 >> 24) & 255) / 255.0f;
        float fMY = MY(((i2 >> 16) & 255) / 255.0f);
        float fMY2 = MY(((i2 >> 8) & 255) / 255.0f);
        float fMY3 = MY((i2 & 255) / 255.0f);
        float fMY4 = MY(((i8 >> 16) & 255) / 255.0f);
        float fMY5 = MY(((i8 >> 8) & 255) / 255.0f);
        float fMY6 = MY((i8 & 255) / 255.0f);
        float fA = a.a(f9, f8, f4, f8);
        float fA2 = a.a(fMY4, fMY, f4, fMY);
        float fA3 = a.a(fMY5, fMY2, f4, fMY2);
        float fA4 = a.a(fMY6, fMY3, f4, fMY3);
        float fIlO = IlO(fA2) * 255.0f;
        float fIlO2 = IlO(fA3) * 255.0f;
        return Math.round(IlO(fA4) * 255.0f) | (Math.round(fIlO) << 16) | (Math.round(fA * 255.0f) << 24) | (Math.round(fIlO2) << 8);
    }
}
