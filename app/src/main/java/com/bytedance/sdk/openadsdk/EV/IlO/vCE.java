package com.bytedance.sdk.openadsdk.EV.IlO;

import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private final WeakReference<vSq> IlO;

    public vCE(vSq vsq) {
        this.IlO = new WeakReference<>(vsq);
    }

    public static void IlO(cl clVar, vSq vsq) {
        clVar.IlO("interactiveFinish", new vCE(vsq));
    }

    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<vSq> weakReference = this.IlO;
        if (weakReference != null && weakReference.get() != null) {
            vSq vsq = this.IlO.get();
            oeT oetTV = vsq.tV();
            try {
                boolean z2 = true;
                int i2 = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z2 = false;
                }
                int iOptInt = jSONObject.optInt("reduce_duration", -1);
                int iCQo = oetTV != null ? oetTV.CQo() : 0;
                if (iOptInt >= 0 && iCQo >= 0) {
                    iOptInt = Math.min(iOptInt, iCQo);
                } else if (iOptInt < 0) {
                    iOptInt = iCQo >= 0 ? iCQo : 0;
                }
                if (z2) {
                    vsq.EO(iOptInt);
                } else {
                    i2 = -1;
                }
                jSONObject2.put("code", i2);
                jSONObject2.put("reduce_duration", iOptInt);
                return jSONObject2;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO("InteractiveFinishMethod", e.getMessage());
            }
        }
        return jSONObject2;
    }
}
