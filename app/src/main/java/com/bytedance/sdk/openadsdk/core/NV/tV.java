package com.bytedance.sdk.openadsdk.core.NV;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static String IlO = "";

    private static JSONArray EO(oeT oet) {
        try {
            oeT.IlO ilOUvo = oet.uvo();
            if (ilOUvo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(ilOUvo.EV());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("original_price", Double.valueOf(jSONObject.optDouble("original_price", 0.0d)));
            jSONObject2.putOpt("price_unit", jSONObject.optString("price_unit"));
            jSONObject2.putOpt(FirebaseAnalytics.Param.DISCOUNT, Double.valueOf(jSONObject.optDouble(FirebaseAnalytics.Param.DISCOUNT, 0.0d)));
            jSONObject2.putOpt("product_name", jSONObject.optString("dpa_product_name"));
            jSONObject2.putOpt("description", jSONObject.optString("dpa_description"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dpa_images");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                jSONObject2.putOpt("image", jSONArrayOptJSONArray.get(0));
            }
            jSONObject2.putOpt("brand_name", jSONObject.optString("dpa_brand_name"));
            jSONObject2.putOpt("sale_price_i18n", Integer.valueOf(jSONObject.optInt("sale_price_i18n")));
            jSONObject2.putOpt("real_price", Double.valueOf(jSONObject.optDouble("real_price", 0.0d)));
            jSONObject2.put("button_text", oet.aa());
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("dpa_related_products");
            if (jSONArrayOptJSONArray2 != null) {
                jSONArray.put(jSONObject2);
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    try {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                        jSONObject3.put("button_text", oet.aa());
                        jSONArray.put(jSONObject3);
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean IlO(int i2) {
        return i2 == 10 || i2 == 9;
    }

    public static boolean MY(oeT oet) {
        return oet != null && oet.nvX() == 10;
    }

    public static JSONObject IlO(oeT oet, String str) {
        JSONObject jSONObjectEDn = oet.eDn();
        try {
            jSONObjectEDn.put("show_dislike", oet.uF());
            jSONObjectEDn.put("language", rp.MY());
            if ("open_ad".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                String strLEW = DmF.MY().lEW();
                int iDmF = DmF.MY().DmF();
                jSONObject.put("app_name", strLEW);
                jSONObject.put("app_icon_id", "@".concat(String.valueOf(iDmF)));
                jSONObjectEDn.put("open_app_info", jSONObject);
            }
            jSONObjectEDn.put(Q6.F, C2300e4.f8279d);
            JSONArray jSONArrayEO = EO(oet);
            if (jSONArrayEO != null) {
                jSONObjectEDn.put("dpa_data", jSONArrayEO);
            }
            return jSONObjectEDn;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("UgenUtils", "parseUGenDataInfo exception", th.getMessage());
            return jSONObjectEDn;
        }
    }

    public static boolean IlO(oeT oet) {
        return oet != null && oet.nvX() == 7;
    }

    public static String IlO() {
        return IlO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public static JSONObject IlO(oeT oet, com.bytedance.sdk.openadsdk.core.NV.vCE.EO eo) {
        eo.IlO("ad");
        String strCl = "";
        IlO = "";
        ?? r42 = 0;
        try {
            oeT.IlO ilOUvo = oet.uvo();
            if (ilOUvo != null) {
                strCl = ilOUvo.cl();
                if (TextUtils.isEmpty(strCl) && !TextUtils.isEmpty(ilOUvo.zPa()) && !TextUtils.isEmpty(ilOUvo.vCE())) {
                    strCl = com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO("ad", ilOUvo.vCE(), ilOUvo.zPa());
                }
            }
            try {
                if (!TextUtils.isEmpty(strCl)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strCl);
                        try {
                            IlO = "getTemplate success";
                            eo.MY("local");
                            return jSONObject;
                        } catch (JSONException unused) {
                            String strConcat = "parse json exception data is ".concat(String.valueOf(strCl));
                            IlO = strConcat;
                            eo.IlO(2, strConcat, "local");
                            return null;
                        }
                    } catch (JSONException unused2) {
                    }
                } else {
                    String str = "local data is null id is " + ilOUvo.vCE() + " md5 is " + ilOUvo.zPa();
                    IlO = str;
                    eo.IlO(3, str, "net");
                    return null;
                }
            } catch (Throwable th) {
                r42 = ilOUvo;
                th = th;
                String str2 = "get template error " + th.getMessage();
                IlO = str2;
                eo.IlO(2, str2, "local");
                return r42;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
