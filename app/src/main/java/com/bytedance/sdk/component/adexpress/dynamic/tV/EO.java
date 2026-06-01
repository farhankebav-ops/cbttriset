package com.bytedance.sdk.component.adexpress.dynamic.tV;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private HashMap<String, Object> IlO = new HashMap<>();
    private JSONObject MY;

    public EO(JSONObject jSONObject) {
        this.MY = jSONObject;
    }

    public Object IlO(String str) {
        if (this.IlO.containsKey(str)) {
            return this.IlO.get(str);
        }
        return null;
    }

    public boolean MY(String str) {
        return this.IlO.containsKey(str);
    }

    public void IlO() {
        Iterator<String> itKeys = this.MY.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.MY.opt(next);
            int i2 = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i2 < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                                    this.IlO.put(next + "." + i2 + "." + next2, objOpt2);
                                }
                            }
                            i2++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt3 = jSONObject.opt(next3);
                            if ((objOpt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i8 = 0; i8 < ((JSONArray) objOpt3).length(); i8++) {
                                    this.IlO.put(next + "." + next3 + "." + i8, ((JSONArray) objOpt3).opt(i8));
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, FirebaseAnalytics.Param.COUPON)) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt3).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    Object objOpt4 = ((JSONObject) objOpt3).opt(next4);
                                    this.IlO.put(next + "." + next3 + "." + next4, objOpt4);
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                IlO(next, next3, objOpt3);
                            } else {
                                this.IlO.put(next + "." + next3, objOpt3);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else if (objOpt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    Object objOpt5 = jSONObject2.opt(next5);
                    this.IlO.put(next + "." + next5, objOpt5);
                }
            } else {
                this.IlO.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.IlO.put(next, objOpt);
                }
            }
        }
    }

    private void IlO(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i2 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i2 < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                            this.IlO.put(str + "." + str2 + "." + next + "." + i2 + "." + next2, objOpt2);
                        }
                        i2++;
                    }
                }
            } else {
                this.IlO.put(str + "." + str2 + "." + next, objOpt);
            }
        }
    }
}
