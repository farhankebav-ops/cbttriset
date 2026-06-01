package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dz extends ee {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static boolean f1918 = true;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1919 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1920 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f1921 = {'E', 'b'};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1922 = 37;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f1923 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private em f1924;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee f1925;

    public dz(em emVar, ee eeVar, Cdo cdo) {
        super(cdo);
        this.f1924 = emVar;
        this.f1925 = eeVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2175(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1921;
                int i8 = f1922;
                if (f1918) {
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
                if (f1923) {
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            f1920 = (f1919 + 21) % 128;
            return true;
        }
        if (obj == null || dz.class != obj.getClass()) {
            return false;
        }
        dz dzVar = (dz) obj;
        em emVar = this.f1924;
        if (emVar == null ? dzVar.f1924 != null : !emVar.equals(dzVar.f1924)) {
            return false;
        }
        ee eeVar = this.f1925;
        if (eeVar != null) {
            f1919 = (f1920 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            return eeVar.equals(dzVar.f1925);
        }
        if (dzVar.f1925 == null) {
            return true;
        }
        int i2 = f1919 + 15;
        f1920 = i2 % 128;
        if (i2 % 2 == 0) {
            return false;
        }
        throw null;
    }

    public final int hashCode() {
        int iHashCode;
        int i2 = (f1919 + 79) % 128;
        f1920 = i2;
        em emVar = this.f1924;
        int iHashCode2 = 0;
        if (emVar != null) {
            iHashCode = emVar.hashCode();
            f1919 = (f1920 + 115) % 128;
        } else {
            f1919 = (i2 + 115) % 128;
            iHashCode = 0;
        }
        int i8 = iHashCode * 31;
        ee eeVar = this.f1925;
        if (eeVar != null) {
            f1920 = (f1919 + 17) % 128;
            iHashCode2 = eeVar.hashCode();
        }
        return i8 + iHashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1924);
        sb.append(m2175(null, 126 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), null, "\u0081\u0082\u0081").intern());
        sb.append(this.f1925);
        String string = sb.toString();
        f1920 = (f1919 + 35) % 128;
        return string;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        f1920 = (f1919 + 15) % 128;
        du duVarM2189 = this.f1925.m2189(dsVar, cpVar);
        dsVar.m2135(this.f1924.m2208(), duVarM2189.m2153());
        f1919 = (f1920 + 61) % 128;
        return duVarM2189;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final em m2176() {
        int i2 = f1919 + 105;
        f1920 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1924;
        }
        int i8 = 28 / 0;
        return this.f1924;
    }
}
