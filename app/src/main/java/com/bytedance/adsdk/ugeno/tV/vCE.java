package com.bytedance.adsdk.ugeno.tV;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private IlO IlO;
    private List<IlO> MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private Map<String, String> Cc;
        private String EO = "global";
        private String IlO;
        private String MY;
        private String tV;
        private Map<String, Object> vCE;

        public String Cc() {
            return this.MY;
        }

        public Map<String, String> EO() {
            return this.Cc;
        }

        public String IlO() {
            return this.EO;
        }

        public String MY() {
            return this.tV;
        }

        public String tV() {
            return this.IlO;
        }

        public String toString() {
            return "Action{scheme='" + this.EO + "', name='" + this.tV + "', params=" + this.Cc + ", host='" + this.MY + "', origin='" + this.IlO + "', extra=" + this.vCE + '}';
        }

        public void EO(String str) {
            this.IlO = str;
        }

        public void IlO(String str) {
            this.EO = str;
        }

        public void MY(String str) {
            this.tV = str;
        }

        public void tV(String str) {
            this.MY = str;
        }

        public void IlO(Map<String, String> map) {
            this.Cc = map;
        }

        public void MY(Map<String, Object> map) {
            this.vCE = map;
        }
    }

    public IlO IlO() {
        return this.IlO;
    }

    public List<IlO> MY() {
        return this.MY;
    }

    public static vCE IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        vCE vce = new vCE();
        String strOptString = jSONObject.optString("on");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        vce.IlO = rp.IlO(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            IlO IlO2 = rp.IlO(jSONArrayOptJSONArray.optString(i2), jSONObject2);
            if (IlO2 != null) {
                arrayList.add(IlO2);
            }
        }
        vce.MY = arrayList;
        return vce;
    }
}
