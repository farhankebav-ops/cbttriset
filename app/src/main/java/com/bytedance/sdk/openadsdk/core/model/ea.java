package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea {
    private IlO IlO;

    public ea(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable")) == null) {
            return;
        }
        this.IlO = new IlO(jSONObjectOptJSONObject.optJSONObject("components"));
    }

    public static boolean IlO(oeT oet) {
        ea eaVarFv;
        IlO ilO;
        return (oet == null || (eaVarFv = oet.Fv()) == null || (ilO = eaVarFv.IlO) == null || !ilO.IlO()) ? false : true;
    }

    public static IlO MY(oeT oet) {
        ea eaVarFv;
        if (oet == null || (eaVarFv = oet.Fv()) == null) {
            return null;
        }
        return eaVarFv.IlO;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        C0103IlO IlO;
        C0103IlO MY;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.model.ea$IlO$IlO, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static class C0103IlO {
            String IlO;

            public C0103IlO(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.IlO = jSONObject.optString("entry");
            }

            public boolean IlO() {
                return !TextUtils.isEmpty(this.IlO);
            }
        }

        public IlO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.has("vertical")) {
                this.IlO = new C0103IlO(jSONObject.optJSONObject("vertical"));
            }
            if (jSONObject.has("horizontal")) {
                this.MY = new C0103IlO(jSONObject.optJSONObject("horizontal"));
            }
        }

        public boolean IlO() {
            C0103IlO c0103IlO = this.MY;
            if (c0103IlO != null && c0103IlO.IlO()) {
                return true;
            }
            C0103IlO c0103IlO2 = this.IlO;
            return c0103IlO2 != null && c0103IlO2.IlO();
        }

        public String IlO(boolean z2) {
            if (z2) {
                C0103IlO c0103IlO = this.IlO;
                if (c0103IlO != null) {
                    return c0103IlO.IlO;
                }
                return "";
            }
            C0103IlO c0103IlO2 = this.MY;
            if (c0103IlO2 != null) {
                return c0103IlO2.IlO;
            }
            return "";
        }
    }
}
