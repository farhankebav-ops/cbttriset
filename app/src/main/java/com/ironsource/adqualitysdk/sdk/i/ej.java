package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ej extends ee {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1979 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static boolean f1980 = true;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1981 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean f1982 = true;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1983 = 296;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f1984 = {387, 389};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ee f1985;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee f1986;

    public ej(ee eeVar, ee eeVar2, Cdo cdo) {
        super(cdo);
        this.f1986 = eeVar;
        this.f1985 = eeVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r2.equals(r5.f1986) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r5.f1986 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r2 = r4.f1985;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.ej.f1981 = (com.ironsource.adqualitysdk.sdk.i.ej.f1979 + 37) % 128;
        r5 = r2.equals(r5.f1985);
        r0 = com.ironsource.adqualitysdk.sdk.i.ej.f1981 + 17;
        com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        if (r5.f1985 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.ej.f1979 = (com.ironsource.adqualitysdk.sdk.i.ej.f1981 + 1) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            r1 = 0
            if (r5 == 0) goto L5b
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L12
            goto L5b
        L12:
            com.ironsource.adqualitysdk.sdk.i.ej r5 = (com.ironsource.adqualitysdk.sdk.i.ej) r5
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f1986
            if (r2 == 0) goto L29
            int r3 = com.ironsource.adqualitysdk.sdk.i.ej.f1981
            int r3 = r3 + 3
            int r3 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r3
            com.ironsource.adqualitysdk.sdk.i.ee r3 = r5.f1986
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2e
            goto L2d
        L29:
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r5.f1986
            if (r2 == 0) goto L2e
        L2d:
            return r1
        L2e:
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f1985
            if (r2 == 0) goto L4f
            int r0 = com.ironsource.adqualitysdk.sdk.i.ej.f1979
            int r0 = r0 + 37
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1981 = r0
            com.ironsource.adqualitysdk.sdk.i.ee r5 = r5.f1985
            boolean r5 = r2.equals(r5)
            int r0 = com.ironsource.adqualitysdk.sdk.i.ej.f1981
            int r0 = r0 + 17
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L4d
            return r5
        L4d:
            r5 = 0
            throw r5
        L4f:
            com.ironsource.adqualitysdk.sdk.i.ee r5 = r5.f1985
            if (r5 != 0) goto L5b
            int r5 = com.ironsource.adqualitysdk.sdk.i.ej.f1981
            int r5 = r5 + r0
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r5
            return r0
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ej.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hashCode() {
        /*
            r5 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.ej.f1981
            int r1 = r0 + 13
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L15
            com.ironsource.adqualitysdk.sdk.i.ee r1 = r5.f1986
            r3 = 99
            int r3 = r3 / r2
            if (r1 == 0) goto L26
            goto L19
        L15:
            com.ironsource.adqualitysdk.sdk.i.ee r1 = r5.f1986
            if (r1 == 0) goto L26
        L19:
            int r0 = r0 + 119
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r0
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r5.f1986
            int r0 = r0.hashCode()
            goto L27
        L26:
            r0 = r2
        L27:
            int r0 = r0 * 31
            com.ironsource.adqualitysdk.sdk.i.ee r1 = r5.f1985
            if (r1 == 0) goto L46
            int r3 = com.ironsource.adqualitysdk.sdk.i.ej.f1981
            int r3 = r3 + 67
            int r4 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.ej.f1979 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L42
            int r1 = r1.hashCode()
            r3 = 70
            int r3 = r3 / r2
            r2 = r1
            goto L46
        L42:
            int r2 = r1.hashCode()
        L46:
            int r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ej.hashCode():int");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2201().toString());
        sb.append(m2200(null, 127 - TextUtils.getOffsetBefore("", 0), null, "\u0081").intern());
        sb.append(m2202().toString());
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2200(null, (ViewConfiguration.getFadingEdgeLength() >> 16) + 127, null, "\u0082"));
        int i2 = f1981 + 95;
        f1979 = i2 % 128;
        if (i2 % 2 != 0) {
            return strZ;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final ee m2201() {
        int i2 = f1981;
        int i8 = i2 + 55;
        f1979 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        ee eeVar = this.f1986;
        int i9 = i2 + 57;
        f1979 = i9 % 128;
        if (i9 % 2 != 0) {
            return eeVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final ee m2202() {
        int i2 = (f1979 + 75) % 128;
        f1981 = i2;
        ee eeVar = this.f1985;
        int i8 = i2 + 75;
        f1979 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 96 / 0;
        }
        return eeVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2200(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1984;
                int i8 = f1983;
                if (f1980) {
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
                if (f1982) {
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
