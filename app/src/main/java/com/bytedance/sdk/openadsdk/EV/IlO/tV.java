package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.openadsdk.core.vSq;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private final vSq IlO;

    public tV(vSq vsq) {
        this.IlO = vsq;
    }

    public static void IlO(cl clVar, vSq vsq) {
        clVar.IlO("expressAdViewStartZoom", new tV(vsq));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        this.IlO.tV(jSONObject);
        return null;
    }
}
