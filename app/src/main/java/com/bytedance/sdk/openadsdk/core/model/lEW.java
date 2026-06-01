package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private String IlO;
    private List<String> MY;

    public lEW(String str) {
        this.IlO = "";
        this.MY = new ArrayList();
        HashMap<String, Object> map = TextUtils.isEmpty(str) ? new HashMap<>() : IlO(str);
        try {
            this.IlO = (String) map.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) map.get("auto_test_hosts"));
            this.MY = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.MY.add(jSONArray.optString(i2));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("AutoTestModel", e.getMessage());
        }
    }

    public String IlO() {
        return this.IlO;
    }

    public List<String> MY() {
        return this.MY;
    }

    private static final HashMap<String, Object> IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                map.put(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value"));
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }
}
