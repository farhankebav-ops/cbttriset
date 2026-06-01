package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.ironsource.adqualitysdk.sdk.i.ja;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2181 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2182 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int[] f2183 = {-488189151, 862013811, -1356092223, -2000759684, -557259937, 277078035, -1559089447, -269331505, -455314635, -99922519, -1033203497, -2127591108, -641179185, -330969738, 1867937624, -632430638, -1315236123, 1561693569};

    /* JADX INFO: renamed from: ﻐ */
    public abstract String mo2240();

    /* JADX INFO: renamed from: ﻛ */
    public abstract Class mo2241();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final ja.d m2262() {
        f2182 = (f2181 + 39) % 128;
        if (!aq.m530().mo543().m528()) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2261(new int[]{-613240978, 2139210726, 1287102905, -1912709791, -2104033295, -446635869}, 11 - Color.argb(0, 0, 0, 0)).intern());
            sb.append(mo2240());
            return new ja.d(sb.toString(), m2261(new int[]{-423878329, -1777612289}, View.MeasureSpec.getMode(0) + 3).intern());
        }
        String strM527 = aq.m530().mo543().m527(mo2240());
        if (!TextUtils.isEmpty(strM527)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2261(new int[]{-613240978, 2139210726, 1287102905, -1912709791, -2104033295, -446635869}, 11 - (KeyEvent.getMaxKeyCode() >> 16)).intern());
            sb2.append(mo2240());
            return new ja.e(sb2.toString(), m2261(new int[]{-423878329, -1777612289}, TextUtils.getCapsMode("", 0, 0) + 3).intern(), strM527);
        }
        int i2 = f2181 + 53;
        f2182 = i2 % 128;
        if (i2 % 2 != 0) {
            return null;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ */
    public abstract bg mo2242();

    /* JADX INFO: renamed from: ﾒ */
    public abstract String mo2243();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2261(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2183.clone();
                d.f1665 = 0;
                while (true) {
                    int i8 = d.f1665;
                    if (i8 < iArr.length) {
                        int i9 = iArr[i8];
                        char c7 = (char) (i9 >> 16);
                        cArr[0] = c7;
                        char c8 = (char) i9;
                        cArr[1] = c8;
                        char c9 = (char) (iArr[i8 + 1] >> 16);
                        cArr[2] = c9;
                        char c10 = (char) iArr[i8 + 1];
                        cArr[3] = c10;
                        d.f1663 = (c7 << 16) + c8;
                        d.f1666 = (c9 << 16) + c10;
                        d.m1895(iArr2);
                        for (int i10 = 0; i10 < 16; i10++) {
                            int i11 = d.f1663 ^ iArr2[i10];
                            d.f1663 = i11;
                            int iM1894 = d.m1894(i11) ^ d.f1666;
                            int i12 = d.f1663;
                            d.f1663 = iM1894;
                            d.f1666 = i12;
                        }
                        int i13 = d.f1663;
                        int i14 = d.f1666;
                        d.f1663 = i14;
                        d.f1666 = i13;
                        int i15 = i13 ^ iArr2[16];
                        d.f1666 = i15;
                        int i16 = i14 ^ iArr2[17];
                        d.f1663 = i16;
                        cArr[0] = (char) (i16 >>> 16);
                        cArr[1] = (char) i16;
                        cArr[2] = (char) (i15 >>> 16);
                        cArr[3] = (char) i15;
                        d.m1895(iArr2);
                        int i17 = d.f1665;
                        cArr2[i17 << 1] = cArr[0];
                        cArr2[(i17 << 1) + 1] = cArr[1];
                        cArr2[(i17 << 1) + 2] = cArr[2];
                        cArr2[(i17 << 1) + 3] = cArr[3];
                        d.f1665 = i17 + 2;
                    } else {
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
