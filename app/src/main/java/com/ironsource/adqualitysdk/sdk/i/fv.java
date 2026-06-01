package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fv extends fr {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2104 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f2105 = 8100505761840843407L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2106;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<ee> f2107;

    public fv(List<ee> list) {
        this.f2107 = list;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2244(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2105, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2105));
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

    public final String toString() {
        int i2 = f2104 + 83;
        f2106 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f2107 == null) {
            String strIntern = m2244("\ueee0䙇Ϊ镄\uee96\u0ca9集䫉쓧", 1 - View.resolveSize(0, 0)).intern();
            f2104 = (f2106 + 7) % 128;
            return strIntern;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2244("暕彪쀚ᒙ曣ᖄ啶쬔", 1 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern());
        sb.append(TextUtils.join(m2244("\ue246႔㌚䗬\ue26a娻", 1 - Drawable.resolveOpacity(0, 0)).intern(), this.f2107));
        return com.google.android.gms.ads.internal.client.a.z(sb, m2244("ꩼ銋跘벷ꩇ", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[PHI: r1
  0x0032: PHI (r1v6 com.ironsource.adqualitysdk.sdk.i.ee) = (r1v5 com.ironsource.adqualitysdk.sdk.i.ee), (r1v10 com.ironsource.adqualitysdk.sdk.i.ee) binds: [B:11:0x0030, B:8:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[PHI: r1
  0x0036: PHI (r1v8 com.ironsource.adqualitysdk.sdk.i.ee) = (r1v5 com.ironsource.adqualitysdk.sdk.i.ee), (r1v10 com.ironsource.adqualitysdk.sdk.i.ee) binds: [B:11:0x0030, B:8:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ironsource.adqualitysdk.sdk.i.du mo2225(com.ironsource.adqualitysdk.sdk.i.ds r7, com.ironsource.adqualitysdk.sdk.i.cp r8) {
        /*
            r6 = this;
            java.util.List<com.ironsource.adqualitysdk.sdk.i.ee> r0 = r6.f2107
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L78
            int r1 = com.ironsource.adqualitysdk.sdk.i.fv.f2106
            int r1 = r1 + 25
            int r3 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.fv.f2104 = r3
            int r1 = r1 % 2
            r3 = 0
            if (r1 != 0) goto L28
            java.lang.Object r1 = r0.next()
            com.ironsource.adqualitysdk.sdk.i.ee r1 = (com.ironsource.adqualitysdk.sdk.i.ee) r1
            boolean r4 = r1 instanceof com.ironsource.adqualitysdk.sdk.i.em
            r5 = 33
            int r5 = r5 / r3
            if (r4 == 0) goto L36
            goto L32
        L28:
            java.lang.Object r1 = r0.next()
            com.ironsource.adqualitysdk.sdk.i.ee r1 = (com.ironsource.adqualitysdk.sdk.i.ee) r1
            boolean r4 = r1 instanceof com.ironsource.adqualitysdk.sdk.i.em
            if (r4 == 0) goto L36
        L32:
            r2 = r1
            com.ironsource.adqualitysdk.sdk.i.em r2 = (com.ironsource.adqualitysdk.sdk.i.em) r2
            goto L49
        L36:
            boolean r4 = r1 instanceof com.ironsource.adqualitysdk.sdk.i.dz
            if (r4 == 0) goto L49
            int r2 = com.ironsource.adqualitysdk.sdk.i.fv.f2106
            int r2 = r2 + 109
            int r2 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.fv.f2104 = r2
            r2 = r1
            com.ironsource.adqualitysdk.sdk.i.dz r2 = (com.ironsource.adqualitysdk.sdk.i.dz) r2
            com.ironsource.adqualitysdk.sdk.i.em r2 = r2.m2176()
        L49:
            if (r2 == 0) goto L74
            int r4 = com.ironsource.adqualitysdk.sdk.i.fv.f2104
            int r4 = r4 + 65
            int r5 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.fv.f2106 = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L67
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r2 = r2.m2208()
            r4[r3] = r2
            java.util.List r2 = java.util.Arrays.asList(r4)
        L63:
            r7.m2137(r2)
            goto L74
        L67:
            java.lang.String r2 = r2.m2208()
            java.lang.String[] r2 = new java.lang.String[]{r2}
            java.util.List r2 = java.util.Arrays.asList(r2)
            goto L63
        L74:
            r1.mo2156(r7, r8)
            goto L6
        L78:
            com.ironsource.adqualitysdk.sdk.i.du r7 = new com.ironsource.adqualitysdk.sdk.i.du
            r7.<init>(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.fv.mo2225(com.ironsource.adqualitysdk.sdk.i.ds, com.ironsource.adqualitysdk.sdk.i.cp):com.ironsource.adqualitysdk.sdk.i.du");
    }
}
