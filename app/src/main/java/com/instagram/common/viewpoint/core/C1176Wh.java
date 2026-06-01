package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1176Wh {
    public static String[] A05 = {"hdh4k6eZclrlxxYg19ck", "OIQuDIQFpzBifrZrtJIvg4BasUaQd63c", "6y0NffGMqcG8EugdtirNjkqg6svCH2Zl", "13Ua2r6CYJwc6p6BI5coDxRAaPqMz7yS", "7WkbYpbXunBRly3lB1oHckvOip2eqLp6", "2PYz6J8qU0vRqLO17bgOak7iCaiihwk", "gvpJ77qQnx", "SLFhDDNvl2CxgKHJ1vqMDyCxDe74woQD"};
    public boolean A00 = false;
    public final Handler A01 = new Handler(Looper.getMainLooper());
    public final AbstractC1752hy A02;
    public final C1477dL A03;
    public final Wf A04;

    public C1176Wh(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, Wf wf) {
        this.A03 = c1477dL;
        this.A04 = wf;
        this.A02 = abstractC1752hy;
    }

    public static C1176Wh A00(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, Wf wf) {
        Object creativeAsCtaLoggingHelper = c1477dL.A0I();
        if (creativeAsCtaLoggingHelper == null) {
            creativeAsCtaLoggingHelper = new C1176Wh(c1477dL, abstractC1752hy, wf);
            c1477dL.A0P(creativeAsCtaLoggingHelper);
        }
        return (C1176Wh) creativeAsCtaLoggingHelper;
    }

    public static boolean A01(C1477dL c1477dL) {
        return U7.A1b(c1477dL) && WN.A0I(c1477dL);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.instagram.common.viewpoint.core.C1175Wg A02(com.instagram.common.viewpoint.core.AbstractC1752hy r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.dL r0 = r6.A03
            boolean r0 = com.instagram.common.viewpoint.core.U7.A1h(r0)
            r4 = 1
            if (r0 == 0) goto L1f
            boolean r0 = r7.A1W()
            if (r0 == 0) goto L1d
            com.facebook.ads.redexgen.X.dL r0 = r6.A03
            boolean r0 = A01(r0)
            if (r0 == 0) goto L1d
        L17:
            com.facebook.ads.redexgen.X.Wg r0 = new com.facebook.ads.redexgen.X.Wg
            r0.<init>(r4, r4)
            return r0
        L1d:
            r4 = 0
            goto L17
        L1f:
            boolean r3 = r7.A1W()
            if (r3 == 0) goto L51
            com.facebook.ads.redexgen.X.dL r0 = r6.A03
            boolean r5 = A01(r0)
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1176Wh.A05
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C1176Wh.A05
            java.lang.String r1 = "D5RQoHah0ZffyX7n6MMHscTeZuBHZQ8g"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "oKN8Sif1fTCm3hFJqGEcKAR8lt3N8fjA"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L51
        L4b:
            com.facebook.ads.redexgen.X.Wg r0 = new com.facebook.ads.redexgen.X.Wg
            r0.<init>(r3, r4)
            return r0
        L51:
            r4 = 0
            goto L4b
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1176Wh.A02(com.facebook.ads.redexgen.X.hy):com.facebook.ads.redexgen.X.Wg");
    }

    public final void A03() {
        this.A00 = false;
        this.A01.removeCallbacksAndMessages(null);
    }
}
