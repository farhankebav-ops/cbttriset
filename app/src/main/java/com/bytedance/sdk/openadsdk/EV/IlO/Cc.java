package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private JSONObject IlO;

    public Cc(JSONObject jSONObject) {
        this.IlO = jSONObject;
    }

    public static void IlO(cl clVar, JSONObject jSONObject) {
        clVar.IlO("getData", new Cc(jSONObject));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        return com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.IlO, jSONObject);
    }
}
