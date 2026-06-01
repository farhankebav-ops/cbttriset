package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.component.DmF.vCE> IlO;

    public NV(com.bytedance.sdk.component.DmF.vCE vce) {
        this.IlO = new WeakReference<>(vce);
    }

    public static void IlO(cl clVar, com.bytedance.sdk.component.DmF.vCE vce) {
        clVar.IlO("preventTouchEvent", new NV(vce));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            com.bytedance.sdk.component.DmF.vCE vce2 = this.IlO.get();
            if (vce2 != null) {
                vce2.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
                return jSONObject2;
            }
            jSONObject2.put("success", false);
            return jSONObject2;
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
            return jSONObject2;
        }
    }
}
