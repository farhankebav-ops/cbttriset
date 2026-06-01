package com.bytedance.sdk.openadsdk.multipro;

import a1.a;
import com.bytedance.sdk.openadsdk.core.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static String IlO = "com.bytedance.openadsdk";
    public static String MY = a.r(new StringBuilder("content://"), IlO, ".TTMultiProvider");

    static {
        IlO();
    }

    public static void IlO() {
        if (cl.IlO() != null) {
            IlO = cl.IlO().getPackageName();
            MY = a.r(new StringBuilder("content://"), IlO, ".TTMultiProvider");
        }
    }
}
