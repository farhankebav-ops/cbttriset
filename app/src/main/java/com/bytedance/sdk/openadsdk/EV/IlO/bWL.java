package com.bytedance.sdk.openadsdk.EV.IlO;

import android.view.ViewGroup;
import com.bytedance.sdk.component.IlO.cl;
import com.bytedance.sdk.openadsdk.core.dY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.utils.mmj;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject> {
    private vSq EO;
    private com.bytedance.sdk.component.DmF.vCE IlO;
    private String MY;
    private oeT tV;

    public bWL(com.bytedance.sdk.component.DmF.vCE vce, String str, vSq vsq, oeT oet) {
        this.IlO = vce;
        this.MY = str;
        this.EO = vsq;
        this.tV = oet;
    }

    public static void IlO(cl clVar, com.bytedance.sdk.component.DmF.vCE vce, vSq vsq, oeT oet) {
        clVar.IlO("closeWebview", new bWL(vce, "closeWebview", vsq, oet));
        clVar.IlO("makeVisible", new bWL(vce, "makeVisible", vsq, oet));
        clVar.IlO("getCurrentVisibleState", new bWL(vce, "getCurrentVisibleState", vsq, oet));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.IlO.Cc
    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.component.IlO.vCE vce) throws Exception {
        JSONObject jSONObject2;
        jSONObject2 = new JSONObject();
        String str = this.MY;
        str.getClass();
        switch (str) {
            case "getCurrentVisibleState":
                oeT oet = this.tV;
                if (oet != null) {
                    jSONObject2.put("visibleState", !dY.IlO(this.IlO, 20, oet.fHv(), false) ? 1 : 0);
                }
                return jSONObject2;
            case "closeWebview":
                mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.EV.IlO.bWL.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bWL.this.IlO != null) {
                            bWL.this.IlO.setVisibility(8);
                            ViewGroup viewGroup = (ViewGroup) bWL.this.IlO.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(bWL.this.IlO);
                            }
                        }
                    }
                });
                jSONObject2.put("success", true);
                return jSONObject2;
            case "makeVisible":
                if (this.IlO != null) {
                    jSONObject2.put("success", true);
                    mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.EV.IlO.bWL.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bWL.this.IlO != null) {
                                bWL.this.IlO.setVisibility(0);
                            }
                        }
                    });
                    return jSONObject2;
                }
                jSONObject2.put("success", false);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
