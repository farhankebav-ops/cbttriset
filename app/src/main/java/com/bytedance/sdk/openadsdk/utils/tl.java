package com.bytedance.sdk.openadsdk.utils;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tl {
    public static boolean IlO = IlO();

    private static boolean IlO() {
        SharedPreferences sharedPreferences;
        try {
            if (com.bytedance.sdk.openadsdk.core.cl.IlO() != null && (sharedPreferences = com.bytedance.sdk.openadsdk.core.cl.IlO().getSharedPreferences("pag_sp_prop_switch", 0)) != null) {
                return sharedPreferences.getInt("perf_con_use_prop", 1) == 1;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
        }
        return true;
    }

    public static void IlO(int i2) {
        try {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.core.cl.IlO().getSharedPreferences("pag_sp_prop_switch", 0).edit();
            editorEdit.putInt("perf_con_use_prop", i2);
            editorEdit.apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
        }
    }
}
