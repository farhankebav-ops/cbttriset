package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class OOq {
    private int Bc;
    private String Cc;
    private int DmF;
    private boolean EO;
    private int IlO;
    private int MY;
    private boolean NV;
    private int lEW;
    private int tV;
    private String vCE;

    public OOq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.EO = jSONObject.optBoolean("is_playable");
        this.tV = jSONObject.optInt("playable_type", 0);
        this.Cc = jSONObject.optString("playable_style");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playable");
        if (jSONObjectOptJSONObject != null) {
            this.vCE = jSONObjectOptJSONObject.optString("playable_url", "");
            this.Bc = jSONObjectOptJSONObject.optInt("playable_orientation", 0);
            this.MY = jSONObjectOptJSONObject.optInt("new_style", 0);
            this.IlO = jSONObjectOptJSONObject.optInt("close_2_app", 0);
            int iMY = MY(this.tV);
            this.lEW = jSONObjectOptJSONObject.optInt("playable_webview_timeout", iMY);
            this.DmF = jSONObjectOptJSONObject.optInt("playable_js_timeout", iMY);
            this.NV = jSONObjectOptJSONObject.optInt("playable_backup_enable", 0) == 1;
        }
    }

    public static long AXM(oeT oet) {
        if (kBB(oet) == null) {
            return 5L;
        }
        return r2.IlO();
    }

    public static boolean Bc(oeT oet) {
        OOq oOqKBB = kBB(oet);
        return (oOqKBB == null || oet.nt() || !oOqKBB.EO || TextUtils.isEmpty(hp(oet))) ? false : true;
    }

    public static boolean Cc(oeT oet) {
        OOq oOqKBB = kBB(oet);
        return oOqKBB != null && oet.nt() && oOqKBB.EO && !TextUtils.isEmpty(hp(oet));
    }

    public static boolean DmF(oeT oet) {
        OOq oOqOeT = oet.oeT();
        return oOqOeT != null && oOqOeT.EO && oOqOeT.MY == 1;
    }

    public static boolean EO(oeT oet) {
        return MY(oet) && pP(oet) == 1;
    }

    public static String EV(oeT oet) {
        OOq oOqKBB = kBB(oet);
        if (oOqKBB == null) {
            return null;
        }
        return oOqKBB.Cc;
    }

    public static int IlO(int i2) {
        return i2 + 10;
    }

    private static int MY(int i2) {
        return i2 == 1 ? 10 : 5;
    }

    public static boolean NV(oeT oet) {
        OOq oOqOeT = oet.oeT();
        return oOqOeT != null && oet.nt() && oOqOeT.EO && oOqOeT.MY == 1;
    }

    public static boolean bWL(oeT oet) {
        return true;
    }

    public static boolean cL(oeT oet) {
        return Bc(oet) && pP(oet) == 1;
    }

    public static int cl(oeT oet) {
        OOq oOqKBB = kBB(oet);
        if (oOqKBB == null) {
            return 0;
        }
        return oOqKBB.Bc;
    }

    public static boolean ea(oeT oet) {
        return ((oet == null || oet.fdM() == null) ? 0 : oet.fdM().f4691n) != 1;
    }

    public static boolean es(oeT oet) {
        return Bc(oet) && pP(oet) == 0;
    }

    public static String hp(oeT oet) {
        if (oet == null) {
            return null;
        }
        OOq oOqOeT = oet.oeT();
        if (oOqOeT != null && oOqOeT.EO) {
            String str = oOqOeT.vCE;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (oet.vAh() == 20) {
            return oet.pFe();
        }
        if (oet.fdM() != null) {
            return oet.fdM().h;
        }
        return null;
    }

    private static OOq kBB(oeT oet) {
        if (oet == null) {
            return null;
        }
        return oet.oeT();
    }

    public static boolean lEW(oeT oet) {
        OOq oOqOeT = oet.oeT();
        return oOqOeT != null && !oet.nt() && oOqOeT.EO && oOqOeT.MY == 1;
    }

    public static long oeT(oeT oet) {
        if (kBB(oet) == null) {
            return 5L;
        }
        return r2.MY();
    }

    private static int pP(oeT oet) {
        OOq oOqKBB = kBB(oet);
        if (oOqKBB == null) {
            return 0;
        }
        return oOqKBB.tV;
    }

    public static String rp(oeT oet) {
        OOq oOqKBB = kBB(oet);
        if (oOqKBB == null) {
            return null;
        }
        return oOqKBB.vCE;
    }

    public static boolean tV(oeT oet) {
        return EO(oet) && !DmF(oet);
    }

    public static boolean vAh(oeT oet) {
        OOq oOqKBB = kBB(oet);
        return oOqKBB != null && oOqKBB.EO();
    }

    public static boolean vCE(oeT oet) {
        return Cc(oet) && pP(oet) == 1;
    }

    public static long xF(oeT oet) {
        return Math.max(AXM(oet), oeT(oet));
    }

    public static boolean zPa(oeT oet) {
        c cVarFdM = oet.fdM();
        return cVarFdM != null && cVarFdM.f4691n == 1;
    }

    public static int IlO(oeT oet) {
        int i2;
        OOq oOqOeT = oet.oeT();
        if (oOqOeT != null && (i2 = oOqOeT.IlO) >= 0 && i2 <= 100) {
            return i2;
        }
        return 0;
    }

    public static boolean MY(oeT oet) {
        OOq oOqKBB = kBB(oet);
        return (oOqKBB == null || !oOqKBB.EO || TextUtils.isEmpty(hp(oet))) ? false : true;
    }

    public boolean EO() {
        return this.NV;
    }

    public void IlO(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.EO);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("PlayableModel", e.getMessage());
        }
        if (!TextUtils.isEmpty(this.vCE)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.vCE);
                jSONObject2.put("playable_orientation", this.Bc);
                jSONObject2.put("new_style", this.MY);
                jSONObject2.put("close_2_app", this.IlO);
                jSONObject2.put("playable_webview_timeout", this.lEW);
                jSONObject2.put("playable_js_timeout", this.DmF);
                jSONObject2.put("playable_backup_enable", this.NV ? 1 : 0);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e4) {
                com.bytedance.sdk.component.utils.oeT.EO("PlayableModel", e4.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.tV);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.oeT.EO("PlayableModel", e8.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.Cc);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.oeT.EO("PlayableModel", e9.getMessage());
        }
    }

    public int MY() {
        return this.DmF;
    }

    public int IlO() {
        return this.lEW;
    }
}
