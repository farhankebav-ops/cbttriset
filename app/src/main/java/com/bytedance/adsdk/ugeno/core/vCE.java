package com.bytedance.adsdk.ugeno.core;

import a1.a;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private boolean Bc;
    private String Cc;
    private String EO;
    private JSONObject IlO;
    private JSONObject MY;
    private JSONObject tV;
    private JSONObject vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private String Bc;
        private LinkedList<IlO> Cc;
        private boolean DmF;
        private JSONObject EO;
        private String IlO;
        private String MY;
        private boolean NV;
        private String lEW;
        private JSONObject tV;
        private IlO vCE;

        public List<IlO> Cc() {
            return this.Cc;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UGNode{id='");
            sb.append(this.IlO);
            sb.append("', name='");
            return a.r(sb, this.MY, "'}");
        }

        public JSONObject vCE() {
            return this.tV;
        }

        public JSONObject tV() {
            return this.EO;
        }

        public String EO() {
            return this.MY;
        }

        public String MY() {
            return this.Bc;
        }

        public String IlO() {
            return this.IlO;
        }

        public void MY(boolean z2) {
            this.NV = z2;
        }

        public void IlO(String str) {
            this.MY = str;
        }

        public void MY(IlO ilO) {
            if (this.Cc == null) {
                this.Cc = new LinkedList<>();
            }
            this.Cc.addLast(ilO);
        }

        public void IlO(boolean z2) {
            this.DmF = z2;
        }

        public void IlO(IlO ilO) {
            if (this.Cc == null) {
                this.Cc = new LinkedList<>();
            }
            this.Cc.add(ilO);
        }

        public void IlO(int i2, IlO ilO) {
            if (this.Cc == null) {
                this.Cc = new LinkedList<>();
            }
            this.Cc.add(i2, ilO);
        }
    }

    public vCE(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    private IlO Cc() {
        if (!tV()) {
            return IlO(this.IlO, (IlO) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            String strOptString = this.tV.optString("xSize");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (jSONObject2.optInt("width") > 0) {
                    jSONObject.put("width", jSONObject2.optInt("width"));
                }
                if (jSONObject2.optInt("height") > 0) {
                    jSONObject.put("height", jSONObject2.optInt("height"));
                }
            }
        } catch (JSONException unused) {
        }
        IlO ilO = new IlO();
        ilO.MY = "View";
        ilO.IlO = "virtualNode";
        ilO.EO = jSONObject;
        ilO.vCE = null;
        ilO.Bc = this.EO;
        ilO.lEW = this.Cc;
        ilO.IlO(IlO(this.IlO, ilO));
        return ilO;
    }

    public List<IlO> EO() {
        if (this.MY == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.MY.keys();
        while (itKeys.hasNext()) {
            IlO IlO2 = IlO(this.MY.optJSONObject(itKeys.next()), (IlO) null);
            if (IlO2 != null) {
                arrayList.add(IlO2);
            }
        }
        return arrayList;
    }

    public IlO IlO() {
        return Cc();
    }

    public String MY() {
        return this.EO;
    }

    public boolean tV() {
        return this.Bc;
    }

    public vCE(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has(C2300e4.h.E0)) {
                this.IlO = jSONObject.optJSONObject(C2300e4.h.E0);
            } else {
                this.IlO = jSONObject.optJSONObject("main_template");
            }
            this.MY = jSONObject.optJSONObject("sub_templates");
            JSONObject jSONObjectOptJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has(C2300e4.h.E0)) {
                    this.Bc = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.EO = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.EO = "3.0";
                    }
                } else {
                    this.EO = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.Cc = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has(C2300e4.h.E0)) {
                this.EO = "3.0";
                this.Bc = true;
            }
            this.tV = jSONObject2;
            this.vCE = jSONObject3;
        }
    }

    private IlO IlO(JSONObject jSONObject, IlO ilO) {
        IlO IlO2;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        IlO ilO2 = new IlO();
        ilO2.IlO = strOptString2;
        if (this.Bc && TextUtils.equals("Video", strOptString)) {
            ilO2.MY = strOptString + "V3";
        } else {
            ilO2.MY = strOptString;
        }
        ilO2.EO = jSONObject2;
        ilO2.vCE = ilO;
        ilO2.Bc = this.EO;
        ilO2.lEW = this.Cc;
        if (jSONObject2.has("i18n")) {
            ilO2.tV = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            IlO(jSONObject, ilO2.EO);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i2 = 0;
            for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i8);
                String strOptString3 = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
                String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectOptJSONObject.optString("id"), this.tV);
                if (TextUtils.equals(strOptString3, "Template")) {
                    JSONObject jSONObject3 = this.MY;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strIlO);
                        IlO2 = IlO(jSONObjectOptJSONObject, ilO2);
                    } else {
                        IlO2 = null;
                    }
                } else {
                    IlO2 = IlO(jSONObjectOptJSONObject, ilO2);
                }
                if (IlO2 != null) {
                    IlO2.MY(MY(IlO2));
                    IlO2.IlO(IlO(IlO2));
                }
                if (EO(IlO2)) {
                    i2++;
                    ilO2.MY(IlO2);
                } else if (IlO2 != null) {
                    ilO2.IlO(i8 - i2, IlO2);
                }
            }
        }
        return ilO2;
    }

    public static boolean tV(IlO ilO) {
        return (ilO == null || ilO.EO == null) ? false : true;
    }

    public boolean MY(IlO ilO) {
        JSONObject jSONObjectTV;
        if (ilO == null || (jSONObjectTV = ilO.tV()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectTV.optString("height"), "match_parent");
    }

    public boolean EO(IlO ilO) {
        JSONObject jSONObjectTV;
        if (ilO == null || (jSONObjectTV = ilO.tV()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectTV.optString(C2300e4.h.L), "absolute");
    }

    public boolean IlO(IlO ilO) {
        JSONObject jSONObjectTV;
        if (ilO == null || (jSONObjectTV = ilO.tV()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectTV.optString("width"), "match_parent");
    }

    private void IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.vCE == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.vCE.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.Bc.MY.IlO(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }
}
