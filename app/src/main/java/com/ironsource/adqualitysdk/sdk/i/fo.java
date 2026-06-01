package com.ironsource.adqualitysdk.sdk.i;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class fo extends fr {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2072 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int[] f2073 = {859732408, 1614578408, 873075883, 383878866, -712237202, -1737379884, -1967363732, -235926320, 1629569907, 1360839406, -596225569, -630482873, 349544504, 334753471, 550135799, 1195138204, 7664139, -1751550761};

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2074;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ee f2075;

    public fo(ee eeVar) {
        this.f2075 = eeVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.fo.f2074
            int r1 = r0 + 105
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.fo.f2072 = r2
            int r1 = r1 % 2
            r3 = 0
            if (r1 == 0) goto L67
            r1 = 1
            if (r6 != r7) goto L1c
            int r0 = r0 + 63
            int r7 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.fo.f2072 = r7
            int r0 = r0 % 2
            if (r0 == 0) goto L1b
            return r1
        L1b:
            throw r3
        L1c:
            r0 = 0
            if (r7 == 0) goto L66
            int r2 = r2 + 81
            int r4 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.fo.f2074 = r4
            int r2 = r2 % 2
            if (r2 == 0) goto L37
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r4 = r7.getClass()
            r5 = 52
            int r5 = r5 / r0
            if (r2 == r4) goto L42
            goto L66
        L37:
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r4 = r7.getClass()
            if (r2 == r4) goto L42
            goto L66
        L42:
            com.ironsource.adqualitysdk.sdk.i.fo r7 = (com.ironsource.adqualitysdk.sdk.i.fo) r7
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r6.f2075
            if (r2 == 0) goto L61
            int r0 = com.ironsource.adqualitysdk.sdk.i.fo.f2074
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.fo.f2072 = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L5b
            com.ironsource.adqualitysdk.sdk.i.ee r7 = r7.f2075
            boolean r7 = r2.equals(r7)
            return r7
        L5b:
            com.ironsource.adqualitysdk.sdk.i.ee r7 = r7.f2075
            r2.equals(r7)
            throw r3
        L61:
            com.ironsource.adqualitysdk.sdk.i.ee r7 = r7.f2075
            if (r7 != 0) goto L66
            return r1
        L66:
            return r0
        L67:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.fo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ee eeVar = this.f2075;
        if (eeVar == null) {
            return 0;
        }
        int i2 = f2074 + 49;
        f2072 = i2 % 128;
        int i8 = i2 % 2;
        int iHashCode = eeVar.hashCode();
        if (i8 == 0) {
            int i9 = 39 / 0;
        }
        f2074 = (f2072 + 59) % 128;
        return iHashCode;
    }

    public String toString() {
        int i2 = f2074 + 51;
        f2072 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (this.f2075 == null) {
            return m2232(new int[]{-452054545, -1358511187}, View.resolveSize(0, 0) + 1).intern();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2075);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2232(new int[]{-452054545, -1358511187}, KeyEvent.normalizeMetaState(0) + 1));
        int i8 = f2074 + 51;
        f2072 = i8 % 128;
        if (i8 % 2 != 0) {
            return strZ;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public du mo2225(ds dsVar, cp cpVar) {
        int i2 = f2072;
        f2074 = (i2 + 103) % 128;
        ee eeVar = this.f2075;
        if (eeVar == null) {
            return new du(null);
        }
        int i8 = i2 + 19;
        f2074 = i8 % 128;
        if (i8 % 2 != 0) {
            eeVar.m2189(dsVar, cpVar);
            throw null;
        }
        du duVarM2189 = eeVar.m2189(dsVar, cpVar);
        f2072 = (f2074 + 111) % 128;
        return duVarM2189;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final ee m2233() {
        int i2 = f2074 + 19;
        f2072 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f2075;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2232(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2073.clone();
                d.f1665 = 0;
                while (true) {
                    int i8 = d.f1665;
                    if (i8 < iArr.length) {
                        int i9 = iArr[i8];
                        char c7 = (char) (i9 >> 16);
                        cArr[0] = c7;
                        char c8 = (char) i9;
                        cArr[1] = c8;
                        char c9 = (char) (iArr[i8 + 1] >> 16);
                        cArr[2] = c9;
                        char c10 = (char) iArr[i8 + 1];
                        cArr[3] = c10;
                        d.f1663 = (c7 << 16) + c8;
                        d.f1666 = (c9 << 16) + c10;
                        d.m1895(iArr2);
                        for (int i10 = 0; i10 < 16; i10++) {
                            int i11 = d.f1663 ^ iArr2[i10];
                            d.f1663 = i11;
                            int iM1894 = d.m1894(i11) ^ d.f1666;
                            int i12 = d.f1663;
                            d.f1663 = iM1894;
                            d.f1666 = i12;
                        }
                        int i13 = d.f1663;
                        int i14 = d.f1666;
                        d.f1663 = i14;
                        d.f1666 = i13;
                        int i15 = i13 ^ iArr2[16];
                        d.f1666 = i15;
                        int i16 = i14 ^ iArr2[17];
                        d.f1663 = i16;
                        cArr[0] = (char) (i16 >>> 16);
                        cArr[1] = (char) i16;
                        cArr[2] = (char) (i15 >>> 16);
                        cArr[3] = (char) i15;
                        d.m1895(iArr2);
                        int i17 = d.f1665;
                        cArr2[i17 << 1] = cArr[0];
                        cArr2[(i17 << 1) + 1] = cArr[1];
                        cArr2[(i17 << 1) + 2] = cArr[2];
                        cArr2[(i17 << 1) + 3] = cArr[3];
                        d.f1665 = i17 + 2;
                    } else {
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
