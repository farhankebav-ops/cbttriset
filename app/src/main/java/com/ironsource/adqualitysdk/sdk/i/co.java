package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;
import android.view.ViewConfiguration;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class co {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1384 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f1385 = true;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean f1386 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1387 = 11;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1388;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f1389 = {'^', ']', 'W', '+', ':'};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m1671(String str, String str2, Throwable th) {
        int i2 = f1388 + 115;
        f1384 = i2 % 128;
        int i8 = i2 % 2;
        m1673(str, str2, th);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f1384 + 79;
        f1388 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m1672(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(m1670(null, 127 - View.MeasureSpec.makeMeasureSpec(0, 0), null, "\u0084\u0083\u0082\u0081").intern());
        sb.append(str);
        k.m2865(sb.toString(), str2);
        f1388 = (f1384 + 21) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m1673(String str, String str2, Throwable th) {
        kd.m2913(a0.d(new StringBuilder(), m1670(null, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 127, null, "\u0085\u0083\u0082\u0081"), str), str2, Integer.toHexString(str2.hashCode()), th, (JSONObject) null, false);
        int i2 = f1388 + 99;
        f1384 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1670(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f1389;
                int i8 = f1387;
                if (f1386) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f1385) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
