package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fm extends fi<String> {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2065 = 149;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2066 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2067;

    public fm(String str, Cdo cdo) {
        super(dy.m2174(str), cdo);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2230(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f2065);
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

    @Override // com.ironsource.adqualitysdk.sdk.i.fi
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2230(183 - Color.alpha(0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), "\u0000", -TextUtils.indexOf((CharSequence) "", '0'), false).intern());
        sb.append(super.toString());
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2230(TextUtils.indexOf("", "") + 183, 1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), "\u0000", 1 - Color.red(0), false));
        int i2 = f2066 + 9;
        f2067 = i2 % 128;
        if (i2 % 2 == 0) {
            return strZ;
        }
        throw null;
    }
}
