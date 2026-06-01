package com.ironsource.adqualitysdk.sdk.i;

import android.view.ViewConfiguration;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fd extends eg {

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2046 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2047 = 272;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f2048 = {315};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f2049 = true;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2050 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f2051 = true;

    public fd(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2223(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f2048;
                int i8 = f2047;
                if (f2049) {
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
                if (f2051) {
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

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        du duVarM2189 = m2196().m2189(dsVar, cpVar);
        du duVarM21892 = m2194().m2189(dsVar, cpVar);
        if ((duVarM2189.m2153() instanceof String) || (duVarM21892.m2153() instanceof String)) {
            StringBuilder sb = new StringBuilder();
            sb.append(duVarM2189.m2153());
            sb.append(duVarM21892.m2153());
            return new du(sb.toString());
        }
        Number numberM2152 = duVarM2189.m2152();
        Number numberM21522 = duVarM21892.m2152();
        if (!(numberM2152 instanceof Double)) {
            f2050 = (f2046 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            if (!(numberM21522 instanceof Double)) {
                if ((numberM2152 instanceof Long) || (numberM21522 instanceof Long)) {
                    return new du(Long.valueOf(numberM21522.longValue() + numberM2152.longValue()));
                }
                return new du(Integer.valueOf(numberM21522.intValue() + numberM2152.intValue()));
            }
        }
        du duVar = new du(Double.valueOf(numberM21522.doubleValue() + numberM2152.doubleValue()));
        int i2 = f2050 + 77;
        f2046 = i2 % 128;
        if (i2 % 2 != 0) {
            return duVar;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.eg
    /* JADX INFO: renamed from: ﻛ */
    public final String mo2195() {
        int i2 = f2050 + 101;
        f2046 = i2 % 128;
        String strIntern = m2223(null, i2 % 2 == 0 ? 19 << (ViewConfiguration.getMinimumFlingVelocity() - 103) : (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, null, "\u0081").intern();
        f2046 = (f2050 + 61) % 128;
        return strIntern;
    }
}
