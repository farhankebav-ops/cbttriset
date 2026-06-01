package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT {
    public static final String[] EO = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    public static int IlO = Integer.MIN_VALUE;
    public static int MY = Integer.MIN_VALUE;

    public static String IlO() {
        if (IlO == Integer.MIN_VALUE) {
            IlO = com.bytedance.sdk.openadsdk.core.DmF.Cc();
        }
        if (IlO < 0) {
            IlO = 0;
        }
        String[] strArr = EO;
        try {
            return strArr[IlO % strArr.length];
        } catch (Throwable unused) {
            return strArr[0];
        }
    }

    public static synchronized void MY() {
        if (MY == 0) {
            return;
        }
        MY = 0;
        com.bytedance.sdk.openadsdk.core.DmF.MY(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
    
        r2 = com.bytedance.sdk.openadsdk.utils.oeT.IlO + 1;
        com.bytedance.sdk.openadsdk.utils.oeT.IlO = r2;
        com.bytedance.sdk.openadsdk.core.DmF.IlO(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void IlO(java.lang.String r5) {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.utils.oeT> r0 = com.bytedance.sdk.openadsdk.utils.oeT.class
            monitor-enter(r0)
            if (r5 != 0) goto L7
            monitor-exit(r0)
            return
        L7:
            r1 = 0
            r2 = r1
        L9:
            java.lang.String[] r3 = com.bytedance.sdk.openadsdk.utils.oeT.EO     // Catch: java.lang.Throwable -> L20
            int r4 = r3.length     // Catch: java.lang.Throwable -> L20
            if (r2 >= r4) goto L28
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L20
            boolean r3 = r5.contains(r3)     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L22
            int r2 = com.bytedance.sdk.openadsdk.utils.oeT.IlO     // Catch: java.lang.Throwable -> L20
            int r2 = r2 + 1
            com.bytedance.sdk.openadsdk.utils.oeT.IlO = r2     // Catch: java.lang.Throwable -> L20
            com.bytedance.sdk.openadsdk.core.DmF.IlO(r2)     // Catch: java.lang.Throwable -> L20
            goto L28
        L20:
            r2 = move-exception
            goto L25
        L22:
            int r2 = r2 + 1
            goto L9
        L25:
            r2.getMessage()     // Catch: java.lang.Throwable -> L39
        L28:
            java.lang.String r2 = "/api/ad/union/sdk/settings/"
            boolean r2 = r5.contains(r2)     // Catch: java.lang.Throwable -> L39
            if (r2 != 0) goto L3b
            java.lang.String r2 = "/api/ad/union/sdk/strategies/adn"
            boolean r5 = r5.contains(r2)     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L75
            goto L3b
        L39:
            r5 = move-exception
            goto L77
        L3b:
            int r5 = com.bytedance.sdk.openadsdk.utils.oeT.MY     // Catch: java.lang.Throwable -> L39
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 != r2) goto L47
            int r5 = com.bytedance.sdk.openadsdk.core.DmF.vCE()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.utils.oeT.MY = r5     // Catch: java.lang.Throwable -> L39
        L47:
            int r5 = com.bytedance.sdk.openadsdk.utils.oeT.MY     // Catch: java.lang.Throwable -> L39
            int r5 = r5 + 1
            com.bytedance.sdk.openadsdk.utils.oeT.MY = r5     // Catch: java.lang.Throwable -> L39
            r2 = 3
            if (r5 < r2) goto L70
            com.bytedance.sdk.openadsdk.core.settings.vCE r5 = com.bytedance.sdk.openadsdk.core.settings.hp.aP()     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = r5.vSq()     // Catch: java.lang.Throwable -> L39
            int r2 = com.bytedance.sdk.openadsdk.utils.oeT.MY     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.core.settings.vCE r3 = com.bytedance.sdk.openadsdk.core.settings.hp.aP()     // Catch: java.lang.Throwable -> L39
            r3.BES()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.utils.oeT.MY = r1     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.ea.EO.IlO()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "clear_domain"
            com.bytedance.sdk.openadsdk.utils.oeT$1 r4 = new com.bytedance.sdk.openadsdk.utils.oeT$1     // Catch: java.lang.Throwable -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.ea.EO.IlO(r3, r1, r4)     // Catch: java.lang.Throwable -> L39
        L70:
            int r5 = com.bytedance.sdk.openadsdk.utils.oeT.MY     // Catch: java.lang.Throwable -> L39
            com.bytedance.sdk.openadsdk.core.DmF.MY(r5)     // Catch: java.lang.Throwable -> L39
        L75:
            monitor-exit(r0)
            return
        L77:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.oeT.IlO(java.lang.String):void");
    }

    public static void IlO(com.bytedance.sdk.component.DmF.vCE vce, String str) {
        HashMap map = new HashMap();
        map.put("Referer", TTAdConstant.REQUEST_HEAD_REFERER);
        vce.IlO(str, map);
    }
}
