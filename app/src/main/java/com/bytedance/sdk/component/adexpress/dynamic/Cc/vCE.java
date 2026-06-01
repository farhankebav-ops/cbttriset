package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.dynamic.Cc.Cc;
import com.ironsource.C2300e4;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private static HashMap<String, String> Bc;
    private EO Cc;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.EO EO;
    private JSONObject IlO;
    private JSONObject MY;
    private IlO tV;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.tV vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        boolean EO;
        float IlO;
        float MY;

        public static IlO IlO(JSONObject jSONObject) {
            IlO ilO = new IlO();
            if (jSONObject != null) {
                ilO.IlO = (float) jSONObject.optDouble("width");
                ilO.MY = (float) jSONObject.optDouble("height");
                ilO.EO = jSONObject.optBoolean("isLandscape");
            }
            return ilO;
        }
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        Bc = map;
        map.put("subtitle", "description");
        Bc.put("source", "source|app.app_name");
        Bc.put("screenshot", "dynamic_creative.screenshot");
    }

    public vCE(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.IlO = jSONObject;
        this.MY = jSONObject2;
        this.EO = new com.bytedance.sdk.component.adexpress.dynamic.tV.EO(jSONObject2);
        this.tV = IlO.IlO(jSONObject3);
        this.vCE = com.bytedance.sdk.component.adexpress.dynamic.tV.tV.IlO(jSONObject4);
    }

    private void MY(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        com.bytedance.sdk.component.adexpress.dynamic.tV.EO eo;
        Object objIlO;
        Object objIlO2;
        Object objIlO3;
        Object objIlO4;
        if (lew == null || (eo = this.EO) == null || (objIlO = eo.IlO("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objIlO);
        if (TextUtils.isEmpty(strValueOf) || (objIlO2 = this.EO.IlO("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objIlO2);
        if (TextUtils.isEmpty(strValueOf2) || (objIlO3 = this.EO.IlO("description")) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objIlO3);
        if (TextUtils.isEmpty(strValueOf3) || (objIlO4 = this.EO.IlO(C2300e4.h.H0)) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objIlO4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objIlO5 = this.EO.IlO("app.app_name");
        Object objIlO6 = this.EO.IlO("source");
        if (objIlO5 == null && objIlO6 == null) {
            return;
        }
        if (objIlO5 == null) {
            objIlO5 = objIlO6;
        }
        String strValueOf5 = String.valueOf(objIlO5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        lew.IlO("imageUrl", strValueOf);
        lew.IlO("title", strValueOf2);
        lew.IlO("description", strValueOf3);
        lew.IlO(C2300e4.h.H0, strValueOf4);
        lew.IlO("app_name", strValueOf5);
        lew.IlO(true);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.tV.lEW IlO(double d8, int i2, double d9, String str, hp hpVar) {
        JSONObject jSONObject;
        this.EO.IlO();
        try {
            jSONObject = new JSONObject(this.vCE.MY);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewIlO = IlO(tV.IlO(this.IlO, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW) null);
        IlO(lewIlO);
        Cc cc = new Cc(d8, i2, d9, str, hpVar);
        Cc.IlO ilO = new Cc.IlO();
        IlO ilO2 = this.tV;
        ilO.IlO = ilO2.IlO;
        ilO.MY = ilO2.MY;
        ilO.EO = 0.0f;
        cc.IlO(ilO);
        cc.IlO(lewIlO, 0.0f, 0.0f);
        cc.IlO();
        com.bytedance.sdk.component.adexpress.dynamic.tV.MY my = cc.IlO;
        if (my.tV == 65536.0f) {
            return null;
        }
        return my.vCE;
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        int iIlO;
        if (lew == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() != null) {
            iIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().ea();
        } else {
            iIlO = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO());
        }
        int iMY = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), iIlO);
        IlO ilO = this.tV;
        float fMin = ilO.EO ? ilO.IlO : Math.min(ilO.IlO, iMY);
        if (this.tV.MY == 0.0f) {
            lew.Cc(fMin);
            lew.NV().Cc().NV("auto");
            lew.vCE(0.0f);
        } else {
            lew.Cc(fMin);
            int iMY2 = com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO(), com.bytedance.sdk.component.adexpress.tV.Bc.MY(com.bytedance.sdk.component.adexpress.tV.IlO()));
            IlO ilO2 = this.tV;
            lew.vCE(ilO2.EO ? ilO2.MY : Math.min(ilO2.MY, iMY2));
            lew.NV().Cc().NV("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.tV.lEW IlO(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.vCE != null) {
                EO eo = new EO();
                this.Cc = eo;
                JSONObject jSONObjectIlO = eo.IlO(this.vCE.IlO, iOptInt, jSONObject);
                if (jSONObjectIlO != null) {
                    jSONObject = jSONObjectIlO;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewIlO = IlO(jSONObject);
        lewIlO.IlO(lew);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            lewIlO.IlO((List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW>) null);
            return lewIlO;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i2);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = lewIlO.NV().Cc().ts();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i8 = 0; i8 < length; i8++) {
                    com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewIlO2 = IlO(jSONArrayOptJSONArray2.optJSONObject(i8), lewIlO);
                    if (com.bytedance.sdk.component.adexpress.tV.MY() && "skip-with-time".equals(lewIlO.NV().MY()) && !C2300e4.h.T.equals(lewIlO.vAh()) && !TextUtils.isEmpty(lewIlO.vAh())) {
                        lewIlO2.EO(lewIlO.vAh());
                    }
                    arrayList.add(lewIlO2);
                    arrayList3.add(lewIlO2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            lewIlO.IlO(arrayList);
        }
        if (arrayList2.size() > 0) {
            lewIlO.MY(arrayList2);
        }
        return lewIlO;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.tV.lEW IlO(JSONObject jSONObject) {
        String strIlO;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        DmF.IlO(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectIlO = DmF.IlO(strOptString, DmF.IlO(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = new com.bytedance.sdk.component.adexpress.dynamic.tV.lEW();
        if (TextUtils.isEmpty(strOptString2)) {
            lew.MY(String.valueOf(lew.hashCode()));
        } else {
            lew.MY(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            MY(lew);
            lew.EO((float) jSONObjectOptJSONObject.optDouble("x"));
            lew.tV((float) jSONObjectOptJSONObject.optDouble("y"));
            lew.Cc((float) jSONObjectOptJSONObject.optDouble("width"));
            lew.vCE((float) jSONObjectOptJSONObject.optDouble("height"));
            lew.Bc(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.tV.Cc cc = new com.bytedance.sdk.component.adexpress.dynamic.tV.Cc();
            cc.IlO(strOptString);
            cc.MY(jSONObjectOptJSONObject.optString("data"));
            cc.EO(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceIlO = com.bytedance.sdk.component.adexpress.dynamic.tV.vCE.IlO(jSONObjectOptJSONObject);
            cc.IlO(vceIlO);
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceIlO2 = com.bytedance.sdk.component.adexpress.dynamic.tV.vCE.IlO(jSONObjectIlO);
            if (vceIlO2 == null) {
                cc.MY(vceIlO);
            } else {
                cc.MY(vceIlO2);
            }
            IlO(vceIlO);
            IlO(vceIlO2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.MY) != null) {
                IlO(cc, jSONObject2.optInt("image_mode"));
            }
            String strMY = cc.MY();
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = cc.Cc();
            if (Bc.containsKey(strMY) && !vceCc.hL()) {
                vceCc.xF(Bc.get(strMY));
            }
            if (vceCc.hL()) {
                strIlO = cc.EO();
            } else {
                strIlO = IlO(cc.EO());
            }
            if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                if (TextUtils.equals(strMY, "star") || TextUtils.equals(strMY, "text_star")) {
                    strIlO = IlO("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(strMY, "score-count") || TextUtils.equals(strMY, "score-count-type-1") || TextUtils.equals(strMY, "score-count-type-2")) {
                    strIlO = IlO("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(strMY) && vceIlO.XvI()) {
                    strIlO = IlO("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(IlO()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                StringBuilder sbX = a.x(strIlO, "adx:");
                sbX.append(IlO());
                cc.MY(sbX.toString());
            } else {
                cc.MY(strIlO);
            }
            lew.IlO(cc);
        }
        return lew;
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.Cc cc, int i2) {
        int iLastIndexOf;
        if (i2 != 5 && i2 != 15 && i2 != 50 && i2 != 154) {
            cc.IlO("image");
            String strIlO = DmF.IlO("image");
            com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc = cc.Cc();
            vceCc.xF(strIlO);
            cc.Bc().xF(strIlO);
            String strIlO2 = DmF.IlO("image", "clickArea");
            if (!TextUtils.isEmpty(strIlO2)) {
                vceCc.ea(strIlO2);
                cc.Bc().ea(strIlO2);
            }
            JSONObject jSONObjectCQo = vceCc.CQo();
            if (jSONObjectCQo != null) {
                vceCc.vAh(jSONObjectCQo.optString("imageLottieTosPath"));
                vceCc.rp(jSONObjectCQo.optBoolean("animationsLoop"));
                vceCc.tl(jSONObjectCQo.optInt("lottieAppNameMaxLength"));
                vceCc.wPn(jSONObjectCQo.optInt("lottieAdDescMaxLength"));
                vceCc.OOq(jSONObjectCQo.optInt("lottieAdTitleMaxLength"));
            }
            cc.MY(strIlO);
            if (strIlO != null && (iLastIndexOf = strIlO.lastIndexOf(".")) > 0) {
                String strSubstring = strIlO.substring(0, iLastIndexOf);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", IlO(strSubstring + ".width"));
                    jSONObject.put("height", IlO(strSubstring + ".height"));
                } catch (JSONException unused) {
                }
                cc.EO(jSONObject.toString());
            }
            vceCc.ct();
            return;
        }
        cc.IlO(MimeTypes.BASE_TYPE_VIDEO);
        String strIlO3 = DmF.IlO(MimeTypes.BASE_TYPE_VIDEO);
        cc.Cc().xF(strIlO3);
        String strIlO4 = DmF.IlO(MimeTypes.BASE_TYPE_VIDEO, "clickArea");
        if (!TextUtils.isEmpty(strIlO4)) {
            cc.Cc().ea(strIlO4);
            cc.Bc().ea(strIlO4);
        }
        cc.Bc().xF(strIlO3);
        cc.MY(strIlO3);
        cc.Cc().Fv();
    }

    private String IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.EO.MY(str2)) {
                String strValueOf = String.valueOf(this.EO.IlO(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String IlO() {
        Object objIlO;
        com.bytedance.sdk.component.adexpress.dynamic.tV.EO eo = this.EO;
        return (eo == null || (objIlO = eo.IlO("adx_name")) == null) ? "" : String.valueOf(objIlO);
    }

    private void IlO(com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vce) {
        if (vce == null) {
            return;
        }
        String strOc = vce.oc();
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            String strEO = com.bytedance.sdk.component.adexpress.tV.Bc.EO(com.bytedance.sdk.component.adexpress.tV.IlO());
            if ("zh".equals(strEO)) {
                strEO = "cn";
            }
            if (!TextUtils.isEmpty(strEO) && vce.vCE() != null) {
                String strOptString = vce.vCE().optString(strEO);
                if (!TextUtils.isEmpty(strOptString)) {
                    strOc = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strOc)) {
            return;
        }
        int iIndexOf = strOc.indexOf("{{");
        int iIndexOf2 = strOc.indexOf("}}");
        if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf2 >= iIndexOf) {
            String strIlO = IlO(strOc.substring(iIndexOf + 2, iIndexOf2));
            StringBuilder sb = new StringBuilder(strOc.substring(0, iIndexOf));
            if (!TextUtils.isEmpty(strIlO)) {
                sb.append(strIlO);
            }
            sb.append(strOc.substring(iIndexOf2 + 2));
            vce.rp(sb.toString());
            return;
        }
        vce.rp(strOc);
    }
}
