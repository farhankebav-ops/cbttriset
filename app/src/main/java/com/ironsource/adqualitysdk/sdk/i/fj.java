package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fj extends fr {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2053 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int[] f2054 = {1381757024, 515208469, 975253045, -1059569956, -1791072698, 757905094, 1844761415, -2145139965, 613622000, -702716822, -116149158, 910095063, -1760979370, 180452743, 1516759432, -484896406, -591791176, 628013984};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2055;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2224(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2054.clone();
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

    public final String toString() {
        f2053 = (f2055 + 23) % 128;
        String strIntern = m2224(new int[]{955313793, -1785226786, -1644227813, 2026985309, 376173136, -1416315260}, View.MeasureSpec.getSize(0) + 9).intern();
        int i2 = f2053 + 27;
        f2055 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 75 / 0;
        }
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final du mo2225(ds dsVar, cp cpVar) {
        du duVar = new du(null);
        duVar.m2146();
        int i2 = f2055 + 9;
        f2053 = i2 % 128;
        if (i2 % 2 != 0) {
            return duVar;
        }
        throw null;
    }
}
