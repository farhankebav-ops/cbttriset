package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static Boolean IlO;

    public static boolean EO() {
        Boolean bool = IlO;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!bWL.Cc()) {
            return false;
        }
        if (IlO == null) {
            IlO = Boolean.valueOf(com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_info", "is_support_multi_process", false));
        }
        return IlO.booleanValue();
    }

    public static void IlO() {
        Boolean bool = Boolean.TRUE;
        IlO = bool;
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_info", "is_support_multi_process", bool);
    }

    public static void MY() {
        IlO = Boolean.FALSE;
        BinderPoolService.IlO = true;
    }
}
