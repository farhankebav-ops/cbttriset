package com.bytedance.sdk.openadsdk.kBB.MY;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private final float EO;
    private final int IlO;
    private final int MY;

    public IlO(int i2, int i8, float f4) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = f4;
    }

    public static JSONObject IlO(IlO ilO) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", ilO.IlO);
        jSONObject.put("height", ilO.MY);
        jSONObject.put("alpha", ilO.EO);
        return jSONObject;
    }
}
