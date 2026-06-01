package com.bytedance.adsdk.MY.EO;

import com.bytedance.adsdk.MY.bWL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static final Cc IlO = new Cc();
    private final bWL<String, com.bytedance.adsdk.MY.Bc> MY = new bWL<>(20);

    public static Cc IlO() {
        return IlO;
    }

    public com.bytedance.adsdk.MY.Bc IlO(String str) {
        if (str == null) {
            return null;
        }
        return this.MY.IlO(str);
    }

    public void IlO(String str, com.bytedance.adsdk.MY.Bc bc) {
        if (str == null) {
            return;
        }
        this.MY.IlO(str, bc);
    }
}
