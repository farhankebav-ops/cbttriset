package com.bytedance.sdk.component.vCE.IlO.IlO.IlO;

import a1.a;
import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    public static String IlO = "com.bytedance.openadsdk";
    public static String MY = a.r(new StringBuilder("content://"), IlO, ".TTMultiProvider");

    static {
        IlO();
    }

    public static void IlO() {
        if (lEW.Bc().vCE() != null) {
            IlO = lEW.Bc().vCE().getPackageName();
            MY = a.r(new StringBuilder("content://"), IlO, ".TTMultiProvider");
        }
    }
}
