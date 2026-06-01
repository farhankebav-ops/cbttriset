package com.ironsource.adqualitysdk.sdk.i;

import android.view.ViewConfiguration;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fw extends fr {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2108 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2109 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static boolean f2110 = true;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2111 = 52;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char[] f2112 = {171, 156, 157, 160, 153, 'T', '\\', ']'};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean f2113 = true;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ee f2114;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private fr f2115;

    public fw(ee eeVar, fr frVar) {
        this.f2114 = eeVar;
        this.f2115 = frVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2245(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f2112;
                int i8 = f2111;
                if (f2110) {
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
                if (f2113) {
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

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r5.f2114 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto Lc
            int r5 = com.ironsource.adqualitysdk.sdk.i.fw.f2109
            int r5 = r5 + 19
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.fw.f2108 = r5
            return r0
        Lc:
            r1 = 0
            if (r5 == 0) goto L4b
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.fw> r2 = com.ironsource.adqualitysdk.sdk.i.fw.class
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L18
            goto L4b
        L18:
            com.ironsource.adqualitysdk.sdk.i.fw r5 = (com.ironsource.adqualitysdk.sdk.i.fw) r5
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f2114
            if (r2 == 0) goto L2f
            com.ironsource.adqualitysdk.sdk.i.ee r3 = r5.f2114
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L34
            int r5 = com.ironsource.adqualitysdk.sdk.i.fw.f2109
            int r5 = r5 + 25
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.fw.f2108 = r5
            goto L33
        L2f:
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r5.f2114
            if (r2 == 0) goto L34
        L33:
            return r1
        L34:
            com.ironsource.adqualitysdk.sdk.i.fr r2 = r4.f2115
            com.ironsource.adqualitysdk.sdk.i.fr r5 = r5.f2115
            if (r2 == 0) goto L3f
            boolean r5 = r2.equals(r5)
            return r5
        L3f:
            if (r5 != 0) goto L42
            return r0
        L42:
            int r5 = com.ironsource.adqualitysdk.sdk.i.fw.f2108
            int r5 = r5 + 59
        L46:
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.fw.f2109 = r5
            return r1
        L4b:
            int r5 = com.ironsource.adqualitysdk.sdk.i.fw.f2108
            int r5 = r5 + 35
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.fw.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode;
        ee eeVar = this.f2114;
        int iHashCode2 = 0;
        if (eeVar != null) {
            f2109 = (f2108 + 63) % 128;
            iHashCode = eeVar.hashCode();
            f2108 = (f2109 + 15) % 128;
        } else {
            iHashCode = 0;
        }
        int i2 = iHashCode * 31;
        fr frVar = this.f2115;
        if (frVar != null) {
            int i8 = f2108 + 33;
            f2109 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 20 / 0;
                iHashCode2 = frVar.hashCode();
            } else {
                iHashCode2 = frVar.hashCode();
            }
        }
        int i10 = i2 + iHashCode2;
        f2108 = (f2109 + 113) % 128;
        return i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2245(null, 127 - (ViewConfiguration.getPressedStateDuration() >> 16), null, "\u0087\u0086\u0085\u0084\u0083\u0082\u0081").intern());
        sb.append(this.f2114);
        sb.append(m2245(null, 127 - (ViewConfiguration.getTapTimeout() >> 16), null, "\u0086\u0088").intern());
        sb.append(this.f2115);
        String string = sb.toString();
        int i2 = f2108 + 13;
        f2109 = i2 % 128;
        if (i2 % 2 == 0) {
            return string;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        while (this.f2114.m2189(dsVar, cpVar).m2150()) {
            du duVarMo2225 = this.f2115.mo2225(dsVar, cpVar);
            if (duVarMo2225.m2154()) {
                break;
            }
            f2109 = (f2108 + 107) % 128;
            if (duVarMo2225.m2151()) {
                return duVarMo2225;
            }
        }
        du duVar = new du(null);
        int i2 = f2109 + 21;
        f2108 = i2 % 128;
        if (i2 % 2 != 0) {
            return duVar;
        }
        throw null;
    }
}
