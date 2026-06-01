package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ea extends ee {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f1930 = 5367734982562869474L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1931 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1932 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1933;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee f1934;

    public ea(ee eeVar, String str, Cdo cdo) {
        super(cdo);
        this.f1934 = eeVar;
        this.f1933 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        r0 = r0 + com.vungle.ads.internal.protos.Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        com.ironsource.adqualitysdk.sdk.i.ea.f1931 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if ((r0 % 2) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (com.ironsource.adqualitysdk.sdk.i.ea.class == r5.getClass()) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        r5 = (com.ironsource.adqualitysdk.sdk.i.ea) r5;
        r0 = r4.f1934;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r0.equals(r5.f1934) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r5.f1934 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r0 = r4.f1933;
        r5 = r5.f1933;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        return r0.equals(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.ea.f1931 = (com.ironsource.adqualitysdk.sdk.i.ea.f1932 + 17) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r4 == r5) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r4 == r5) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r5 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.ea.f1932
            int r1 = r0 + 75
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.ea.f1931 = r2
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L14
            r1 = 68
            int r1 = r1 / r3
            if (r4 != r5) goto L17
            goto L16
        L14:
            if (r4 != r5) goto L17
        L16:
            return r2
        L17:
            if (r5 == 0) goto L59
            int r0 = r0 + 125
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ea.f1931 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L57
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.ea> r0 = com.ironsource.adqualitysdk.sdk.i.ea.class
            java.lang.Class r1 = r5.getClass()
            if (r0 == r1) goto L2c
            goto L59
        L2c:
            com.ironsource.adqualitysdk.sdk.i.ea r5 = (com.ironsource.adqualitysdk.sdk.i.ea) r5
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r4.f1934
            if (r0 == 0) goto L3b
            com.ironsource.adqualitysdk.sdk.i.ee r1 = r5.f1934
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L40
            goto L3f
        L3b:
            com.ironsource.adqualitysdk.sdk.i.ee r0 = r5.f1934
            if (r0 == 0) goto L40
        L3f:
            return r3
        L40:
            java.lang.String r0 = r4.f1933
            java.lang.String r5 = r5.f1933
            if (r0 == 0) goto L4b
            boolean r5 = r0.equals(r5)
            return r5
        L4b:
            if (r5 != 0) goto L4e
            return r2
        L4e:
            int r5 = com.ironsource.adqualitysdk.sdk.i.ea.f1932
            int r5 = r5 + 17
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.ea.f1931 = r5
            return r3
        L57:
            r5 = 0
            throw r5
        L59:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ea.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        f1932 = (f1931 + 63) % 128;
        ee eeVar = this.f1934;
        int iHashCode = 0;
        int iHashCode2 = (eeVar != null ? eeVar.hashCode() : 0) * 31;
        String str = this.f1933;
        if (str != null) {
            int i2 = f1932 + 105;
            f1931 = i2 % 128;
            if (i2 % 2 != 0) {
                str.hashCode();
                throw null;
            }
            iHashCode = str.hashCode();
        }
        return iHashCode2 + iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1934.toString());
        sb.append(m2177("\uf2a7\uf289☨\ue654쒚", View.combineMeasuredStates(0, 0)).intern());
        sb.append(this.f1933);
        String string = sb.toString();
        int i2 = f1931 + 25;
        f1932 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 66 / 0;
        }
        return string;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        f1932 = (f1931 + 61) % 128;
        Object objM2153 = this.f1934.m2189(dsVar, cpVar).m2153();
        if (!(objM2153 instanceof cp)) {
            try {
                return new du(objM2153.getClass().getDeclaredField(this.f1933).get(objM2153));
            } catch (Exception unused) {
                return new du(null);
            }
        }
        du duVar = new du(((cp) objM2153).m1729(this.f1933));
        int i2 = f1931 + 101;
        f1932 = i2 % 128;
        if (i2 % 2 != 0) {
            return duVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2177(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1930, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1930));
                        i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
