package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static volatile EO IlO;

    private EO() {
    }

    public static EO IlO(Context context) {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = new EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public String MY(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("ttopenadsdk", str, str2);
    }

    public int MY(String str, int i2) {
        return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", str, i2);
    }

    public Long MY(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", str, j));
    }

    public void IlO(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", str, str2);
    }

    public void IlO(String str, int i2) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", str, Integer.valueOf(i2));
    }

    public void IlO(String str, long j) {
        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", str, Long.valueOf(j));
    }
}
