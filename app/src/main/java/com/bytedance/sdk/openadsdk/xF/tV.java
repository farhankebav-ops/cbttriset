package com.bytedance.sdk.openadsdk.xF;

import com.ironsource.C2228a4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum tV {
    TYPE_2G("2g"),
    TYPE_3G(C2228a4.f7945a),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI(C2228a4.f7946b),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String lEW;

    tV(String str) {
        this.lEW = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.lEW;
    }
}
