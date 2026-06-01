package com.ironsource.adqualitysdk.sdk.i;

import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dv extends ee {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1885 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1886 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1887 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1888 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f1889 = 31941;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1890;

    public dv(String str, Cdo cdo) {
        super(cdo);
        this.f1890 = dy.m2174(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (com.ironsource.adqualitysdk.sdk.i.dv.class == r5.getClass()) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        r5 = (com.ironsource.adqualitysdk.sdk.i.dv) r5;
        r0 = r4.f1890;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.dv.f1885 = (com.ironsource.adqualitysdk.sdk.i.dv.f1886 + 93) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        return r0.equals(r5.f1890);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (r5.f1890 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r4 == r5) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r4 == r5) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.dv.f1886 = (r0 + 107) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.dv.f1885
            int r1 = r0 + 67
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.dv.f1886 = r2
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L14
            r1 = 99
            int r1 = r1 / r3
            if (r4 != r5) goto L1d
            goto L16
        L14:
            if (r4 != r5) goto L1d
        L16:
            int r0 = r0 + 107
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.dv.f1886 = r0
            return r2
        L1d:
            if (r5 == 0) goto L42
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.dv> r0 = com.ironsource.adqualitysdk.sdk.i.dv.class
            java.lang.Class r1 = r5.getClass()
            if (r0 == r1) goto L28
            goto L42
        L28:
            com.ironsource.adqualitysdk.sdk.i.dv r5 = (com.ironsource.adqualitysdk.sdk.i.dv) r5
            java.lang.String r0 = r4.f1890
            if (r0 == 0) goto L3d
            int r1 = com.ironsource.adqualitysdk.sdk.i.dv.f1886
            int r1 = r1 + 93
            int r1 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.dv.f1885 = r1
            java.lang.String r5 = r5.f1890
            boolean r5 = r0.equals(r5)
            return r5
        L3d:
            java.lang.String r5 = r5.f1890
            if (r5 != 0) goto L42
            return r2
        L42:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dv.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        String str = this.f1890;
        if (str == null) {
            f1886 = (f1885 + 41) % 128;
            return 0;
        }
        int i2 = f1886 + 91;
        f1885 = i2 % 128;
        if (i2 % 2 == 0) {
            str.hashCode();
            throw null;
        }
        int iHashCode = str.hashCode();
        int i8 = f1886 + 97;
        f1885 = i8 % 128;
        if (i8 % 2 != 0) {
            return iHashCode;
        }
        throw null;
    }

    public final String toString() {
        int i2 = f1886 + 97;
        f1885 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1890;
        }
        int i8 = 18 / 0;
        return this.f1890;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final du mo2156(ds dsVar, cp cpVar) {
        du duVar = new du(cpVar.m1733().m882(ka.m2882(this.f1890, m2155("恤夣ڃ垡", (char) (41222 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), "\ue78cᏏ\ue29c\ue353蓪䪁", ViewConfiguration.getDoubleTapTimeout() >> 16, "\u0000\u0000\u0000\u0000").intern())));
        int i2 = f1885 + 69;
        f1886 = i2 % 128;
        if (i2 % 2 == 0) {
            return duVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2155(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1887) ^ ((long) f1888)) ^ ((long) f1889));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }
}
