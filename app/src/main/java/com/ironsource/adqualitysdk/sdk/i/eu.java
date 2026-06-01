package com.ironsource.adqualitysdk.sdk.i;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class eu extends en {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2012 = {' '};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2013 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2014;

    public eu(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        f2013 = (f2014 + 13) % 128;
        String strIntern = m2215("\u0001", true, new int[]{0, 1, 28, 0}).intern();
        f2013 = (f2014 + 57) % 128;
        return strIntern;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.en
    /* JADX INFO: renamed from: ﾒ */
    public final Number mo2209(Number number, Number number2) {
        int i2 = (f2013 + 81) % 128;
        f2014 = i2;
        if (!(number instanceof Double)) {
            f2013 = (i2 + 109) % 128;
            if (!(number2 instanceof Double)) {
                if (!(number instanceof Long)) {
                    f2013 = (i2 + 15) % 128;
                    if (!(number2 instanceof Long)) {
                        Integer numValueOf = Integer.valueOf(number.intValue() % number2.intValue());
                        int i8 = f2013 + 73;
                        f2014 = i8 % 128;
                        if (i8 % 2 == 0) {
                            return numValueOf;
                        }
                        throw null;
                    }
                }
                return Long.valueOf(number.longValue() % number2.longValue());
            }
        }
        return Double.valueOf(number.doubleValue() % number2.doubleValue());
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2215(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2012, i2, cArr, 0, i8);
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
