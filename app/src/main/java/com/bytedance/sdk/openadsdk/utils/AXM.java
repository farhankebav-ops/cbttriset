package com.bytedance.sdk.openadsdk.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM {
    public static int IlO() {
        try {
            int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 33554432);
            if (iMaxMemory <= 2) {
                return 2;
            }
            if (iMaxMemory >= 5) {
                return 5;
            }
            return iMaxMemory;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
