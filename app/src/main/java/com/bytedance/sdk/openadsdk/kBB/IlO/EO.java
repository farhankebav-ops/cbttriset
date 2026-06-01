package com.bytedance.sdk.openadsdk.kBB.IlO;

import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static String EO = "engaged_view";
    public static boolean IlO = false;
    public static int MY = 6;

    private static MY EO(oeT oet) {
        if (oet == null || !oet.CL()) {
            return null;
        }
        return oet.Yq();
    }

    public static void IlO(oeT oet) {
        MY myEO = EO(oet);
        if (myEO == null) {
            return;
        }
        myEO.IlO();
    }

    public static void MY(oeT oet) {
        MY myEO = EO(oet);
        if (myEO == null) {
            return;
        }
        myEO.MY();
    }

    public static void IlO(oeT oet, int i2) {
        MY myEO = EO(oet);
        if (myEO == null || myEO.EO()) {
            return;
        }
        myEO.IlO(i2);
    }

    public static void IlO(oeT oet, boolean z2) {
        MY myEO = EO(oet);
        if (myEO == null || myEO.EO()) {
            return;
        }
        myEO.IlO(z2);
        myEO.IlO(z2 ? 4 : 8);
    }
}
