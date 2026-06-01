package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private long Bc;
    private boolean Cc;
    private String EO;
    private int EV;
    private String IlO;
    private int MY;
    private String hp;
    private boolean lEW;
    private AXM rp;
    private C0102IlO tV;
    private List<oeT> vCE = new ArrayList();
    private JSONObject DmF = new JSONObject();
    private volatile boolean NV = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.model.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0102IlO extends oeT.IlO {
        private int IlO;

        public void IlO(int i2) {
            this.IlO = i2;
        }

        public JSONObject MY() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", vCE());
                jSONObject.put("md5", Bc());
                jSONObject.put("url", lEW());
                jSONObject.put("data", DmF());
                jSONObject.put("diff_data", NV());
                jSONObject.put("version", Cc());
                jSONObject.put("dynamic_creative", EV());
                jSONObject.put("count_down_time", IlO());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public int IlO() {
            return this.IlO;
        }

        public static C0102IlO IlO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0102IlO c0102IlO = new C0102IlO();
            c0102IlO.EO(jSONObject.optString("id"));
            c0102IlO.tV(jSONObject.optString("md5"));
            c0102IlO.Cc(jSONObject.optString("url"));
            c0102IlO.vCE(jSONObject.optString("data"));
            c0102IlO.Bc(jSONObject.optString("diff_data"));
            c0102IlO.MY(jSONObject.optString("version"));
            c0102IlO.lEW(jSONObject.optString("dynamic_creative"));
            c0102IlO.IlO(jSONObject.optInt("count_down_time"));
            if (IlO(c0102IlO)) {
                return c0102IlO;
            }
            return null;
        }

        private static boolean IlO(C0102IlO c0102IlO) {
            return (c0102IlO == null || TextUtils.isEmpty(c0102IlO.vCE()) || TextUtils.isEmpty(c0102IlO.lEW())) ? false : true;
        }
    }

    public boolean Bc() {
        if (DmF() == null || tV() == null || tV().size() <= 1) {
            this.Cc = false;
            IlO((C0102IlO) null);
        } else {
            this.Cc = true;
        }
        return this.Cc;
    }

    public boolean Cc() {
        List<oeT> list = this.vCE;
        return list != null && list.size() > 0;
    }

    public C0102IlO DmF() {
        return this.tV;
    }

    public int EO() {
        return this.MY;
    }

    public boolean EV() {
        return this.NV;
    }

    public JSONObject IlO() {
        return this.DmF;
    }

    public String MY() {
        oeT oetVCE = vCE();
        return oetVCE != null ? oetVCE.JAC() : "";
    }

    public AXM NV() {
        return this.rp;
    }

    @Nullable
    public JSONObject bWL() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0102IlO c0102IlODmF = DmF();
            if (c0102IlODmF != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectMY = c0102IlODmF.MY();
                if (jSONObjectMY != null) {
                    jSONObject2.put("tpl_info", jSONObjectMY);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            AXM axmNV = NV();
            if (axmNV != null) {
                jSONObject.put("loop_config", axmNV.EV());
            }
            List<oeT> list = this.vCE;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.vCE.size(); i2++) {
                    jSONArray.put(this.vCE.get(i2).eDn());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.lEW);
            jSONObject.put("multi_ad_style", this.EV);
            jSONObject.put("request_id", this.IlO);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("AdInfo", "toJsonObj: ", th);
            return null;
        }
    }

    public String ea() {
        return this.hp;
    }

    public boolean hp() {
        return this.EV == 1;
    }

    public boolean lEW() {
        return this.lEW;
    }

    public void rp() {
        this.NV = false;
    }

    public List<oeT> tV() {
        return this.vCE;
    }

    public oeT vCE() {
        if (this.vCE.size() > 0) {
            return this.vCE.get(0);
        }
        return null;
    }

    public static IlO EO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            IlO ilO = new IlO();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (jSONObjectOptJSONObject != null) {
                ilO.MY(jSONObjectOptJSONObject);
            }
            ilO.IlO(AXM.IlO(jSONObject.optJSONObject("loop_config")));
            ilO.MY(jSONObject.optInt("multi_ad_style", 0));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    oeT oetIlO = com.bytedance.sdk.openadsdk.core.MY.IlO(jSONArrayOptJSONArray.optJSONObject(i2));
                    if (oetIlO != null) {
                        oetIlO.DmF(ilO.hp());
                        arrayList.add(oetIlO);
                    }
                }
                ilO.IlO(arrayList);
            }
            ilO.IlO(jSONObject.optBoolean("is_choose_ad_original", false));
            ilO.IlO(jSONObject.optString("request_id", ""));
            return ilO;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("AdInfo", "fromJson: ", th);
            return null;
        }
    }

    public void IlO(JSONObject jSONObject) {
        this.DmF = jSONObject;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void IlO(int i2) {
        this.MY = i2;
    }

    public void MY(String str) {
        this.EO = str;
    }

    public void IlO(oeT oet) {
        this.vCE.add(oet);
    }

    public void MY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        IlO(C0102IlO.IlO(jSONObject.optJSONObject("tpl_info")));
    }

    public void IlO(List<oeT> list) {
        this.vCE = list;
    }

    public void MY(int i2) {
        this.EV = i2;
    }

    public void IlO(long j) {
        this.Bc = j;
    }

    public static Map<String, oeT> IlO(IlO ilO) {
        if (ilO == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (oeT oet : ilO.tV()) {
            if (!TextUtils.isEmpty(oet.tU())) {
                map.put(oet.tU(), oet);
            }
        }
        if (map.size() != 0) {
            return map;
        }
        return null;
    }

    public void IlO(boolean z2) {
        this.lEW = z2;
    }

    public void IlO(C0102IlO c0102IlO) {
        this.tV = c0102IlO;
        if (c0102IlO == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(oeT.IlO.IlO(c0102IlO, ""));
    }

    public void EO(String str) {
        this.hp = str;
    }

    public void IlO(AXM axm) {
        this.rp = axm;
    }
}
