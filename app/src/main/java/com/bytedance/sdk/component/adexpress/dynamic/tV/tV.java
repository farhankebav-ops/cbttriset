package com.bytedance.sdk.component.adexpress.dynamic.tV;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public String EO;
    public List<IlO> IlO;
    public String MY;
    public String tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public int IlO;
        public JSONObject MY;
    }

    public static tV IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tV tVVar = new tV();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    IlO ilO = new IlO();
                    ilO.IlO = jSONObjectOptJSONObject.optInt("id");
                    ilO.MY = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(ilO);
                }
            }
        } catch (JSONException unused) {
        }
        tVVar.IlO = arrayList;
        tVVar.MY = jSONObject.optString("diff_data");
        tVVar.EO = jSONObject.optString("style_diff");
        tVVar.tV = jSONObject.optString("tag_diff");
        return tVVar;
    }
}
