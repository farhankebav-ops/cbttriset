package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class am {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f353 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f354 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int[] f355 = {-18141971, -849801677, -1230063022, -1139601234, 1610706320, -786974146, 1371731156, 1794864289, -543346180, -553240993, -1449673962, 324677547, 877985079, 1291306637, -1035993481, -1126282278, 1877025155, -682675487};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean m513(Map<String, String> map) {
        f354 = (f353 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        boolean zContainsKey = map.containsKey(m516(new int[]{-643108026, -314972584, 1296785441, 1266784023, 1258538523, -1469826701, 1154589446, -2045118827}, 13 - KeyEvent.keyCodeFromString("")).intern());
        int i2 = f354 + 11;
        f353 = i2 % 128;
        if (i2 % 2 == 0) {
            return zContainsKey;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static boolean m514(String str) {
        f353 = (f354 + 103) % 128;
        boolean zEquals = m516(new int[]{-643108026, -314972584, 1296785441, 1266784023, 1258538523, -1469826701, 1154589446, -2045118827}, 13 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern().equals(str);
        int i2 = f353 + 87;
        f354 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 78 / 0;
        }
        return zEquals;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m516(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f355.clone();
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static boolean m517(Map<String, String> map, String str) {
        int i2;
        if (map.containsKey(str)) {
            return false;
        }
        int size = map.size();
        if (m513(map)) {
            f354 = (f353 + 111) % 128;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (size < 5 + i2) {
            return false;
        }
        int i8 = f354 + 13;
        f353 = i8 % 128;
        if (i8 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static boolean m515(String str, String str2) {
        f353 = (f354 + 23) % 128;
        if (!ka.m2881(str, 64)) {
            return false;
        }
        int i2 = f353 + 57;
        f354 = i2 % 128;
        if (i2 % 2 == 0) {
            if (!ka.m2881(str2, 65)) {
                return false;
            }
        } else if (!ka.m2881(str2, 64)) {
            return false;
        }
        f353 = (f354 + 47) % 128;
        return true;
    }
}
