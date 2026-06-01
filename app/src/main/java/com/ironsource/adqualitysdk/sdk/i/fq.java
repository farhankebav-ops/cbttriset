package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fq extends fr {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char f2085 = 21582;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2086 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char f2087 = 41192;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2088 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2089 = 30239;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f2090 = 49190;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private fr f2091;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee f2092;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private fr f2093;

    public fq(ee eeVar, fr frVar, fr frVar2) {
        this.f2092 = eeVar;
        this.f2091 = frVar;
        this.f2093 = frVar2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2236(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2087)) ^ ((c8 >>> 5) + f2085)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2090) ^ ((c9 + i9) ^ ((c9 << 4) + f2089))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r2.equals(r5.f2091) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
    
        if (r5.f2091 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        r2 = r4.f2093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r2 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        r0 = com.ironsource.adqualitysdk.sdk.i.fq.f2086 + com.vungle.ads.internal.protos.Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        com.ironsource.adqualitysdk.sdk.i.fq.f2088 = r0 % 128;
        r0 = r0 % 2;
        r5 = r5.f2093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r0 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        return r2.equals(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r2.equals(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        if (r5.f2093 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        return true;
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
            int r5 = com.ironsource.adqualitysdk.sdk.i.fq.f2086
            int r5 = r5 + 87
            int r5 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.fq.f2088 = r5
            return r0
        Lc:
            r1 = 0
            if (r5 == 0) goto L6f
            int r2 = com.ironsource.adqualitysdk.sdk.i.fq.f2086
            int r2 = r2 + 27
            int r2 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.fq.f2088 = r2
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.fq> r2 = com.ironsource.adqualitysdk.sdk.i.fq.class
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L20
            goto L6f
        L20:
            com.ironsource.adqualitysdk.sdk.i.fq r5 = (com.ironsource.adqualitysdk.sdk.i.fq) r5
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r4.f2092
            if (r2 == 0) goto L2f
            com.ironsource.adqualitysdk.sdk.i.ee r3 = r5.f2092
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L34
            goto L33
        L2f:
            com.ironsource.adqualitysdk.sdk.i.ee r2 = r5.f2092
            if (r2 == 0) goto L34
        L33:
            return r1
        L34:
            com.ironsource.adqualitysdk.sdk.i.fr r2 = r4.f2091
            if (r2 == 0) goto L49
            int r3 = com.ironsource.adqualitysdk.sdk.i.fq.f2086
            int r3 = r3 + 65
            int r3 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.fq.f2088 = r3
            com.ironsource.adqualitysdk.sdk.i.fr r3 = r5.f2091
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4e
            goto L4d
        L49:
            com.ironsource.adqualitysdk.sdk.i.fr r2 = r5.f2091
            if (r2 == 0) goto L4e
        L4d:
            return r1
        L4e:
            com.ironsource.adqualitysdk.sdk.i.fr r2 = r4.f2093
            if (r2 == 0) goto L6a
            int r0 = com.ironsource.adqualitysdk.sdk.i.fq.f2086
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.fq.f2088 = r1
            int r0 = r0 % 2
            com.ironsource.adqualitysdk.sdk.i.fr r5 = r5.f2093
            if (r0 == 0) goto L65
            boolean r5 = r2.equals(r5)
            return r5
        L65:
            r2.equals(r5)
            r5 = 0
            throw r5
        L6a:
            com.ironsource.adqualitysdk.sdk.i.fr r5 = r5.f2093
            if (r5 != 0) goto L6f
            return r0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.fq.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode;
        int iHashCode2;
        ee eeVar = this.f2092;
        if (eeVar != null) {
            int i2 = f2086 + 81;
            f2088 = i2 % 128;
            if (i2 % 2 == 0) {
                eeVar.hashCode();
                throw null;
            }
            iHashCode = eeVar.hashCode();
        } else {
            iHashCode = 0;
        }
        int i8 = iHashCode * 31;
        fr frVar = this.f2091;
        if (frVar != null) {
            iHashCode2 = frVar.hashCode();
        } else {
            f2088 = (f2086 + 5) % 128;
            iHashCode2 = 0;
        }
        int i9 = (i8 + iHashCode2) * 31;
        fr frVar2 = this.f2093;
        return i9 + (frVar2 != null ? frVar2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2236("蓧擰閑\ud81a", 4 - Color.green(0)).intern());
        sb.append(this.f2092);
        sb.append(m2236("좧厸", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern());
        if (this.f2091 instanceof fk) {
            sb.append(m2236("Ꙩꨑ", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1).intern());
        } else {
            sb.append(m2236("볈\ue2d7", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern());
        }
        sb.append(this.f2091);
        fr frVar = this.f2093;
        if (frVar != null) {
            if (frVar instanceof fk) {
                sb.append(m2236("Ꙩꨑ", 1 - View.MeasureSpec.getMode(0)).intern());
            } else {
                sb.append(m2236("볈\ue2d7", (ViewConfiguration.getLongPressTimeout() >> 16) + 1).intern());
            }
            sb.append(m2236("뾭氀磢쩬", 4 - ExpandableListView.getPackedPositionGroup(0L)).intern());
            if (this.f2093 instanceof fk) {
                int i2 = f2086 + 113;
                f2088 = i2 % 128;
                sb.append(m2236("Ꙩꨑ", i2 % 2 == 0 ? 1 % (ViewConfiguration.getLongPressTimeout() / 95) : 1 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern());
            } else {
                sb.append(m2236("볈\ue2d7", 1 - View.MeasureSpec.getMode(0)).intern());
                f2088 = (f2086 + 5) % 128;
            }
            sb.append(this.f2093);
        }
        String string = sb.toString();
        f2086 = (f2088 + 3) % 128;
        return string;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        if (this.f2092.m2189(dsVar, cpVar).m2150()) {
            f2086 = (f2088 + 57) % 128;
            return this.f2091.mo2225(dsVar, cpVar);
        }
        fr frVar = this.f2093;
        if (frVar == null) {
            return new du(Boolean.FALSE);
        }
        du duVarMo2225 = frVar.mo2225(dsVar, cpVar);
        int i2 = f2086 + 35;
        f2088 = i2 % 128;
        if (i2 % 2 != 0) {
            return duVarMo2225;
        }
        throw null;
    }
}
