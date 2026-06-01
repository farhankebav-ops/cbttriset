package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ee {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f1954 = -3316788841076341711L;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f1955 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1956;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Cdo f1957;

    public ee(Cdo cdo) {
        this.f1957 = cdo;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2187(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1954, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1954));
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

    /* JADX INFO: renamed from: ﻛ */
    public abstract du mo2156(ds dsVar, cp cpVar);

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ironsource.adqualitysdk.sdk.i.du m2189(com.ironsource.adqualitysdk.sdk.i.ds r4, com.ironsource.adqualitysdk.sdk.i.cp r5) {
        /*
            r3 = this;
            r0 = r3
        L1:
            com.ironsource.adqualitysdk.sdk.i.du r0 = r0.mo2156(r4, r5)
            if (r0 == 0) goto L32
            int r1 = com.ironsource.adqualitysdk.sdk.i.ee.f1955
            int r1 = r1 + 7
            int r1 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.ee.f1956 = r1
            java.lang.Object r1 = r0.m2153()
            boolean r1 = r1 instanceof com.ironsource.adqualitysdk.sdk.i.ee
            if (r1 == 0) goto L32
            int r1 = com.ironsource.adqualitysdk.sdk.i.ee.f1956
            int r1 = r1 + 9
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.ee.f1955 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L2a
            java.lang.Object r0 = r0.m2153()
            com.ironsource.adqualitysdk.sdk.i.ee r0 = (com.ironsource.adqualitysdk.sdk.i.ee) r0
            goto L1
        L2a:
            java.lang.Object r4 = r0.m2153()
            com.ironsource.adqualitysdk.sdk.i.ee r4 = (com.ironsource.adqualitysdk.sdk.i.ee) r4
            r4 = 0
            throw r4
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ee.m2189(com.ironsource.adqualitysdk.sdk.i.ds, com.ironsource.adqualitysdk.sdk.i.cp):com.ironsource.adqualitysdk.sdk.i.du");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final int m2191() {
        int i2 = f1956;
        f1955 = (i2 + 39) % 128;
        Cdo cdo = this.f1957;
        if (cdo == null) {
            return -1;
        }
        f1955 = (i2 + 23) % 128;
        int iM2068 = cdo.m2068();
        f1956 = (f1955 + 99) % 128;
        return iM2068;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static String m2188(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        f1955 = (f1956 + 13) % 128;
        boolean z2 = true;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            if (!z2) {
                int i8 = f1956 + 99;
                f1955 = i8 % 128;
                sb.append(m2187("쎻쎗紎㤟瀓鎕", i8 % 2 == 0 ? 1 >> Color.alpha(0) : Color.alpha(0) + 1).intern());
            }
            if (obj instanceof String) {
                sb.append(m2187("醢醀㙔뙌\uf086", TextUtils.getCapsMode("", 0, 0) + 1).intern());
                sb.append(obj);
                sb.append(m2187("醢醀㙔뙌\uf086", (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1).intern());
            } else {
                sb.append(obj);
            }
            i2++;
            z2 = false;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2190() {
        f1956 = (f1955 + 103) % 128;
        if (this.f1957 == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2187("癨癈롫賎ﰻӘ櫖曁ꢫ鶊ꙥ筚垏駦괒", -MotionEvent.axisFromString("")).intern());
        sb.append(this.f1957);
        String string = sb.toString();
        int i2 = f1956 + 21;
        f1955 = i2 % 128;
        if (i2 % 2 != 0) {
            return string;
        }
        throw null;
    }
}
