package com.bytedance.sdk.openadsdk.core.lEW.IlO;

import a1.a;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.NV.vCE.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.IlO;
import com.bytedance.sdk.openadsdk.core.model.dY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vAh;
import com.bytedance.sdk.openadsdk.core.model.zPa;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import com.unity3d.services.core.device.MimeTypes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static String IlO = "https://pag_open_icon_id/appicon.png";
    private static String MY = "";

    private static JSONObject EO(oeT oet) {
        JSONObject jSONObject = new JSONObject();
        try {
            vSq.IlO(jSONObject, oet);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String IlO() {
        return MY;
    }

    public static boolean MY() {
        return true;
    }

    public static JSONObject IlO(float f4, float f8, boolean z2, @NonNull oeT oet) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Q6.H, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f4);
            jSONObject2.put("height", f8);
            if (z2) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            if (!(oet instanceof vAh) || !((vAh) oet).dvD()) {
                jSONObject.put("creative", IlO(false, oet));
                jSONObject.put("template_Plugin", MY(oet.uvo()));
                jSONObject.put("diff_template_Plugin", IlO(oet.uvo()));
                return jSONObject;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("choose_ui_data", jSONObject3);
            IlO.C0102IlO c0102IlOLqZ = ((vAh) oet).LqZ();
            JSONObject jSONObjectMY = c0102IlOLqZ.MY();
            if (TextUtils.isEmpty(c0102IlOLqZ.DmF())) {
                jSONObjectMY.put("data", MY(c0102IlOLqZ));
            }
            jSONObject3.put("tpl_info", jSONObjectMY);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("creatives", jSONArray);
            for (oeT oet2 : ((vAh) oet).Klw()) {
                JSONObject jSONObjectIlO = IlO(false, oet2);
                if (jSONObjectIlO != null) {
                    jSONObjectIlO.put("template_Plugin", MY(oet2.uvo()));
                    jSONObjectIlO.put("diff_template_Plugin", IlO(oet2.uvo()));
                    jSONArray.put(jSONObjectIlO);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String MY(oeT.IlO ilO) {
        com.bytedance.sdk.component.adexpress.IlO.EO.MY myEO;
        if (ilO == null) {
            return "";
        }
        String strDmF = ilO.DmF();
        return (!TextUtils.isEmpty(strDmF) || (myEO = com.bytedance.sdk.component.adexpress.IlO.MY.MY.EO(ilO.vCE())) == null) ? strDmF : myEO.Cc();
    }

    public static Map<String, String> MY(oeT oet) {
        HashMap map = null;
        if (oet == null) {
            return null;
        }
        List<zPa> listHg = oet.Hg();
        if (listHg != null && listHg.size() > 0) {
            map = new HashMap();
            for (zPa zpa : listHg) {
                if (zpa != null) {
                    map.put(zpa.IlO(), zpa.Bc());
                }
            }
            zPa zpaHTA = oet.HTA();
            if (zpaHTA != null) {
                map.put(zpaHTA.IlO(), zpaHTA.Bc());
            }
        }
        return map;
    }

    public static JSONObject IlO(oeT oet) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (oet == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            vSq.MY(jSONObject3);
            jSONObject3.put(Q6.H, "android");
            jSONObject.put("xAppInfo", jSONObject3);
            JSONObject jSONObjectMY = vSq.MY(oet);
            jSONObjectMY.put("language", rp.MY());
            jSONObject.put("xSetting", jSONObjectMY);
            IlO(jSONObject, oet, false);
            return jSONObject;
        } catch (Throwable th2) {
            th = th2;
            jSONObject2 = jSONObject;
            th.getMessage();
            return jSONObject2;
        }
    }

    private static void IlO(JSONObject jSONObject, oeT oet, boolean z2) {
        if (oet == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String strRv = oet.rv();
        if (strRv != null) {
            try {
                if (jSONObject.has("raw_response_info")) {
                    jSONObject.remove("raw_response_info");
                }
                JSONObject jSONObject2 = new JSONObject(strRv);
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("creatives");
                if (z2 && jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    jSONArrayOptJSONArray.remove(0);
                }
                jSONObject.put("xRestCreatives", jSONArrayOptJSONArray);
                jSONObject2.remove("creatives");
                jSONObject.put("xRestResponse", jSONObject2);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TemplateUtils", "filterTemplateInfo", th);
            }
        }
    }

    public static JSONObject IlO(float f4, float f8, boolean z2, @NonNull oeT oet, String str, EO eo) {
        MY = "";
        if (oet == null) {
            return null;
        }
        try {
            JSONObject jSONObjectEDn = oet.eDn();
            IlO(jSONObjectEDn, oet, str);
            JSONObject jSONObjectMY = vSq.MY(oet);
            jSONObjectMY.put("language", rp.MY());
            jSONObjectEDn.put("xSetting", jSONObjectMY);
            jSONObjectEDn.put("xAdInfo", IlO(str, EO(oet), oet));
            JSONObject jSONObject = new JSONObject();
            vSq.MY(jSONObject);
            jSONObject.put(Q6.H, "android");
            jSONObjectEDn.put("xAppInfo", jSONObject);
            IlO(jSONObjectEDn, oet, true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f4);
            jSONObject2.put("height", f8);
            if (z2) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObjectEDn.put("xSize", jSONObject2);
            if (eo != null) {
                eo.IlO("adv3");
            }
            dY dYVarEa = oet.Ea();
            if (dYVarEa != null) {
                String strTV = dYVarEa.tV();
                if (!TextUtils.isEmpty(strTV)) {
                    jSONObjectEDn.put("xTemplate", new JSONObject(strTV));
                    MY = "getTemplate success by local data";
                    if (eo != null) {
                        eo.MY("local");
                        return jSONObjectEDn;
                    }
                } else {
                    String strIlO = com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO("adv3", dYVarEa.IlO(), dYVarEa.MY());
                    if (!TextUtils.isEmpty(strIlO)) {
                        jSONObjectEDn.put("xTemplate", new JSONObject(strIlO));
                        MY = "getTemplate success by db data";
                        if (eo != null) {
                            eo.MY("local");
                            return jSONObjectEDn;
                        }
                    } else {
                        String str2 = "local db data is null id is " + dYVarEa.IlO() + " md5 is " + dYVarEa.MY();
                        MY = str2;
                        if (eo != null) {
                            eo.IlO(3, str2, "net");
                        }
                    }
                }
            }
            return jSONObjectEDn;
        } catch (Exception e) {
            String strJ = a.j(e, new StringBuilder("load template exception "));
            MY = strJ;
            if (eo != null) {
                eo.IlO(3, strJ, "net");
            }
            return null;
        }
    }

    private static void IlO(JSONObject jSONObject, oeT oet, String str) {
        c cVarFdM;
        if (oet == null || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("h265_video")) {
                jSONObject.remove("h265_video");
            }
            if (!jSONObject.has(MimeTypes.BASE_TYPE_VIDEO) || (cVarFdM = oet.fdM()) == null) {
                return;
            }
            JSONObject jSONObjectB = cVarFdM.b();
            if ("open_ad".equals(str)) {
                jSONObjectB.put("video_duration", cl.tV().oeT(String.valueOf(oet.hFV())));
            } else {
                jSONObjectB.put("video_duration", cVarFdM.f4688d * ((double) cVarFdM.f4694r));
            }
            jSONObject.put(MimeTypes.BASE_TYPE_VIDEO, jSONObjectB);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static JSONObject IlO(String str, JSONObject jSONObject, oeT oet) {
        if (oet != null) {
            try {
                if ("open_ad".equals(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("app_name", DmF.MY().lEW());
                    int iDmF = DmF.MY().DmF();
                    if (iDmF != 0) {
                        int iNvX = oet.nvX();
                        if (9 == iNvX) {
                            jSONObject2.put("app_icon", IlO);
                        } else if (10 == iNvX) {
                            jSONObject2.put("app_icon", "@".concat(String.valueOf(iDmF)));
                        }
                    }
                    jSONObject.put("open_app_info", jSONObject2);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(UserMetadata.KEYDATA_FILENAME);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i2);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("dynamic_configs", jSONObject.opt("dynamic_configs"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                jSONObject3.put("xRestCreatives", jSONObject.opt("xRestCreatives"));
                jSONObject3.put("xRestResponse", jSONObject.opt("xRestResponse"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String IlO(oeT.IlO ilO) {
        if (ilO != null) {
            return ilO.NV();
        }
        return "";
    }

    public static JSONObject IlO(boolean z2, @NonNull oeT oet) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", oet.aa());
            if (oet.HTA() != null) {
                if (oet.HTA() != null && !TextUtils.isEmpty(oet.HTA().IlO())) {
                    jSONObject.put(C2300e4.h.H0, oet.HTA().IlO());
                } else {
                    jSONObject.put(C2300e4.h.H0, "");
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (oet.Hg() != null) {
                for (int i2 = 0; i2 < oet.Hg().size(); i2++) {
                    zPa zpa = oet.Hg().get(i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", zpa.EO());
                    jSONObject2.put("width", zpa.MY());
                    jSONObject2.put("url", zpa.IlO());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", oet.uI());
            jSONObject.put("interaction_type", oet.Jz());
            jSONObject.put("interaction_method", oet.kBB());
            jSONObject.put("is_compliance_template", MY());
            jSONObject.put("title", oet.dm());
            jSONObject.put("description", oet.gm());
            jSONObject.put("source", oet.hL());
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.model.cl clVarZPa = oet.zPa();
            if (clVarZPa == null) {
                clVarZPa = new com.bytedance.sdk.openadsdk.core.model.cl();
            }
            jSONObject3.put("ceiling_time", clVarZPa.tV());
            jSONObject3.put("ceiling_ratio", clVarZPa.Cc());
            jSONObject3.put("expand_ratio", clVarZPa.vCE());
            jSONObject.put("interaction_params", jSONObject3);
            if (oet.VH() != null) {
                jSONObject.put("comment_num", oet.VH().Cc());
                jSONObject.put(FirebaseAnalytics.Param.SCORE, oet.VH().tV());
                jSONObject.put("app_size", oet.VH().vCE());
                jSONObject.put("app", oet.VH().lEW());
            }
            c cVarFdM = oet.fdM();
            if (cVarFdM != null) {
                JSONObject jSONObjectB = cVarFdM.b();
                jSONObjectB.put("video_duration", cVarFdM.f4688d * ((double) cVarFdM.f4694r));
                jSONObject.put(MimeTypes.BASE_TYPE_VIDEO, jSONObjectB);
            }
            if (oet.uvo() != null) {
                jSONObject.put("dynamic_creative", oet.uvo().EV());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String IlO(oeT oet, String str) {
        List<zPa> listHg;
        if (oet != null && (listHg = oet.Hg()) != null && listHg.size() > 0) {
            for (zPa zpa : listHg) {
                if (zpa != null && TextUtils.equals(str, zpa.IlO())) {
                    return zpa.Bc();
                }
            }
        }
        return null;
    }
}
