package com.ironsource.adqualitysdk.sdk.i;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.my.target.common.MyTargetManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gp extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2205 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2206 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2207 = 174;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2268(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f2207);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        int i2 = f2205 + 71;
        f2206 = i2 % 128;
        int i8 = i2 % 2;
        long zoomControlsTimeout = ViewConfiguration.getZoomControlsTimeout();
        return (i8 != 0 ? m2268(17744 / (zoomControlsTimeout > 1L ? 1 : (zoomControlsTimeout == 1L ? 0 : -1)), 92 % (ViewConfiguration.getScrollDefaultDelay() * 65), "\u0005\ufff4\u0007\f\u0000\u0007\ufff8\ufffa", 4 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), false) : m2268((zoomControlsTimeout > 0L ? 1 : (zoomControlsTimeout == 0L ? 0 : -1)) + 282, 8 - (ViewConfiguration.getScrollDefaultDelay() >> 16), "\u0005\ufff4\u0007\f\u0000\u0007\ufff8\ufffa", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 4, true)).intern();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2206;
        f2205 = (i2 + 67) % 128;
        f2205 = (i2 + 55) % 128;
        return MyTargetManager.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        bx bxVar = new bx(mo2240());
        int i2 = f2206 + 13;
        f2205 = i2 % 128;
        if (i2 % 2 != 0) {
            return bxVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2206 + 99;
        f2205 = i2 % 128;
        return (i2 % 2 == 0 ? m2268(21293 >>> TextUtils.getOffsetBefore("", 0), 126 / (ViewConfiguration.getMaximumDrawingCacheSize() / 27), "\u0010\uffff\u0012ￌ\u0017\u000bￌ\u000b\r\u0001\u0010\u0003\u0005\uffff\f\uffff￫\u0012\u0003\u0005\u0010\uffff\ufff2\u0017￫ￌ\f\r\u000b\u000b\r\u0001ￌ\u0012\u0003\u0005", 85 << TextUtils.indexOf("", ""), true) : m2268(272 - TextUtils.getOffsetBefore("", 0), 36 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), "\u0010\uffff\u0012ￌ\u0017\u000bￌ\u000b\r\u0001\u0010\u0003\u0005\uffff\f\uffff￫\u0012\u0003\u0005\u0010\uffff\ufff2\u0017￫ￌ\f\r\u000b\u000b\r\u0001ￌ\u0012\u0003\u0005", TextUtils.indexOf("", "") + 10, true)).intern();
    }
}
