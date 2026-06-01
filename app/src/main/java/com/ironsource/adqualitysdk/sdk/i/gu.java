package com.ironsource.adqualitysdk.sdk.i;

import com.smaato.sdk.core.SmaatoSdk;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class gu extends gk {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2231 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2232;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2233 = {134, 265, 256, 250, 259, 266, 231, 233, 260, 256, 229, 225, 258, 265, 260, 226, 217, 249, 256, 250, 259, 266, 250, 244, 256, 256, 258, 263, 230, 'M', 151, 142, 136, 145, 152};

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻐ */
    public final String mo2240() {
        f2231 = (f2232 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        String strIntern = m2274("\u0000\u0000\u0000\u0000\u0001\u0001", false, new int[]{29, 6, 39, 6}).intern();
        f2231 = (f2232 + 101) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo2241() {
        int i2 = f2231;
        f2232 = (i2 + 91) % 128;
        f2232 = (i2 + 3) % 128;
        return SmaatoSdk.class;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾇ */
    public final bg mo2242() {
        cb cbVar = new cb(mo2240());
        int i2 = f2231 + 45;
        f2232 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 51 / 0;
        }
        return cbVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.gk
    /* JADX INFO: renamed from: ﾒ */
    public final String mo2243() {
        int i2 = f2232 + 49;
        f2231 = i2 % 128;
        String strIntern = (i2 % 2 == 0 ? m2274("\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001", false, new int[]{0, 29, 153, 25}) : m2274("\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001", false, new int[]{0, 29, 153, 25})).intern();
        int i8 = f2232 + 83;
        f2231 = i8 % 128;
        if (i8 % 2 != 0) {
            return strIntern;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2274(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f2233, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
