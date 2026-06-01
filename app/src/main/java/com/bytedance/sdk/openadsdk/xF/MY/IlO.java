package com.bytedance.sdk.openadsdk.xF.MY;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private List<C0124IlO> EO;
    private String IlO;
    private List<C0124IlO> MY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.xF.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0124IlO {
        private int EO;
        private String IlO;
        private String MY;

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0124IlO)) {
                return super.equals(obj);
            }
            String str2 = this.IlO;
            if (str2 != null) {
                C0124IlO c0124IlO = (C0124IlO) obj;
                if (str2.equals(c0124IlO.IlO) && (str = this.MY) != null && str.equals(c0124IlO.MY)) {
                    return true;
                }
            }
            return false;
        }

        public static C0124IlO IlO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0124IlO c0124IlO = new C0124IlO();
            c0124IlO.IlO = jSONObject.optString("url");
            c0124IlO.MY = jSONObject.optString("md5");
            c0124IlO.EO = jSONObject.optInt("type");
            return c0124IlO;
        }

        public String IlO() {
            return this.IlO;
        }
    }

    public List<C0124IlO> EO() {
        return this.EO;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(List<C0124IlO> list) {
        this.EO = list;
    }

    public void IlO(List<C0124IlO> list) {
        this.MY = list;
    }

    public List<C0124IlO> MY() {
        return this.MY;
    }

    public static IlO MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            IlO ilO = new IlO();
            ilO.IlO(jSONObject.optString("version"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    C0124IlO c0124IlOIlO = C0124IlO.IlO(jSONArrayOptJSONArray.optJSONObject(i2));
                    if (c0124IlOIlO != null) {
                        if (c0124IlOIlO.EO != 1) {
                            if (c0124IlOIlO.EO == 2 && arrayList2.size() < 10) {
                                arrayList2.add(c0124IlOIlO);
                            }
                        } else {
                            arrayList.add(c0124IlOIlO);
                        }
                    }
                }
            }
            ilO.IlO(arrayList);
            ilO.MY(arrayList2);
            return ilO;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String IlO() {
        return this.IlO;
    }
}
