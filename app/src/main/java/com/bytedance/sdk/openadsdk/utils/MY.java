package com.bytedance.sdk.openadsdk.utils;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static SoftReference<com.bytedance.sdk.openadsdk.core.model.oeT> IlO;

    public static com.bytedance.sdk.openadsdk.core.model.oeT IlO() {
        SoftReference<com.bytedance.sdk.openadsdk.core.model.oeT> softReference = IlO;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null) {
            return;
        }
        IlO = new SoftReference<>(oet);
    }
}
