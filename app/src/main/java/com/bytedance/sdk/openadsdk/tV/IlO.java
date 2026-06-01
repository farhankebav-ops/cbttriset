package com.bytedance.sdk.openadsdk.tV;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.component.vCE.IlO.tV.IlO.MY {
    private String AXM;
    private int Bc;
    private long Cc;
    private int DmF;
    private boolean EO;
    public final String IlO;
    protected final JSONObject MY;
    private String bWL;
    private String cL;
    private String cl;
    private String ea;
    private String es;
    private JSONObject hp;
    private String kBB;
    private int lEW;
    private String oeT;
    private final AtomicBoolean rp;
    private long tV;
    private int vAh;
    private final String vCE;
    private com.bytedance.sdk.openadsdk.tV.MY.IlO xF;
    private String zPa;
    private static final Set<String> NV = new HashSet(Arrays.asList("insight_log"));
    private static final Map<String, String> EV = new HashMap<String, String>() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.1
        {
            put("id", "extra_id");
            put("source", "extra_source");
            put("url", "extra_url");
            put("toolType", "extra_tool_type");
            put("storeOpenType", "store_open_type");
            put(IronSourceConstants.EVENTS_ERROR_CODE, "error_code");
            put("md5", "extra_md5");
            put("areaType", "area_type");
            put("rectInfo", "rect_info");
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C0117IlO {
        private String Bc;
        private String Cc;
        private String DmF;
        private String EO;
        private String EV;
        public int IlO;
        private String MY;
        private JSONObject NV;
        private com.bytedance.sdk.openadsdk.tV.MY.MY bWL;
        private int cL;
        private int cl;
        private com.bytedance.sdk.openadsdk.tV.MY.IlO ea;
        private boolean es;
        private String hp;
        private String lEW;
        private final int rp;
        private String tV;
        private String vCE;
        private String xF;
        private final long zPa;

        public C0117IlO(long j, oeT oet) {
            this.cl = -1;
            this.cL = -1;
            this.IlO = -1;
            if (oet != null) {
                this.es = OOq.MY(oet);
                this.cl = oet.kBB();
                this.cL = oet.vAh();
                this.IlO = oet.uI();
            }
            this.zPa = j;
            this.rp = xF.EO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        }

        public C0117IlO Bc(String str) {
            this.Bc = str;
            return this;
        }

        public C0117IlO Cc(String str) {
            this.lEW = str;
            return this;
        }

        public C0117IlO EO(String str) {
            this.tV = str;
            return this;
        }

        public C0117IlO MY(String str) {
            this.EO = str;
            return this;
        }

        public C0117IlO lEW(String str) {
            this.xF = str;
            return this;
        }

        public C0117IlO tV(String str) {
            this.Cc = str;
            return this;
        }

        public C0117IlO vCE(String str) {
            this.DmF = str;
            return this;
        }

        public C0117IlO IlO(String str) {
            this.hp = str;
            return this;
        }

        public C0117IlO IlO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.NV = jSONObject;
            return this;
        }

        public void IlO(com.bytedance.sdk.openadsdk.tV.MY.IlO ilO) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO(this.tV, this.xF, this.Bc, this.EO);
            this.ea = ilO;
            final IlO ilO2 = new IlO(this);
            try {
                com.bytedance.sdk.openadsdk.tV.MY.MY my = this.bWL;
                if (my != null) {
                    my.IlO(ilO2.MY, this.zPa);
                } else {
                    new com.bytedance.sdk.openadsdk.tV.MY.EO().IlO(ilO2.MY, this.zPa);
                }
            } catch (Throwable unused) {
            }
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                mmj.EO(new com.bytedance.sdk.component.lEW.lEW("dispatchEvent") { // from class: com.bytedance.sdk.openadsdk.tV.IlO.IlO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(ilO2);
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(ilO2);
            }
        }
    }

    public IlO(String str, JSONObject jSONObject) {
        this.vCE = "adiff";
        this.rp = new AtomicBoolean(false);
        this.hp = new JSONObject();
        this.IlO = str;
        this.MY = jSONObject;
    }

    private void Bc() throws JSONException {
        this.MY.putOpt("app_log_url", this.kBB);
        this.MY.putOpt("tag", this.bWL);
        this.MY.putOpt("label", this.ea);
        this.MY.putOpt("category", this.zPa);
        if (!TextUtils.isEmpty(this.cl)) {
            try {
                this.MY.putOpt("value", Long.valueOf(Long.parseLong(this.cl)));
            } catch (NumberFormatException unused) {
                this.MY.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.es)) {
            try {
                this.MY.putOpt("ext_value", Long.valueOf(Long.parseLong(this.es)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.oeT)) {
            this.MY.putOpt("log_extra", this.oeT);
        }
        if (!TextUtils.isEmpty(this.AXM)) {
            try {
                this.MY.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.AXM)));
            } catch (NumberFormatException unused3) {
            }
        }
        IlO(this.MY, this.ea);
        try {
            this.MY.putOpt("nt", Integer.valueOf(this.vAh));
        } catch (Exception unused4) {
        }
        Iterator<String> itKeys = this.hp.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.MY.putOpt(next, this.hp.opt(next));
        }
    }

    private boolean IlO(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.getClass();
        switch (str2) {
        }
        return false;
    }

    private boolean MY(String str) {
        str.getClass();
        switch (str) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private void vCE() {
        JSONObject jSONObject = this.hp;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("value");
            String strOptString2 = this.hp.optString("category");
            String strOptString3 = this.hp.optString("log_extra");
            if (IlO(this.cl, this.zPa, this.oeT)) {
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(strOptString2) && !MY(strOptString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(strOptString) || TextUtils.equals(strOptString, "0")) && (TextUtils.isEmpty(this.cl) || TextUtils.equals(this.cl, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.zPa) || !MY(this.zPa)) && (TextUtils.isEmpty(strOptString2) || !MY(strOptString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.oeT) && TextUtils.isEmpty(strOptString3)) {
                    return;
                }
            }
        } else if (!IlO(this.cl, this.zPa, this.oeT)) {
            return;
        }
        this.tV = com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO.incrementAndGet();
    }

    public boolean Cc() {
        Set<String> setRp;
        if (this.MY == null || (setRp = com.bytedance.sdk.openadsdk.core.cl.tV().rp()) == null) {
            return false;
        }
        String strOptString = this.MY.optString("label");
        if (!TextUtils.isEmpty(strOptString)) {
            return setRp.contains(strOptString);
        }
        if (TextUtils.isEmpty(this.ea)) {
            return false;
        }
        return setRp.contains(this.ea);
    }

    public JSONObject EO() {
        if (this.rp.get()) {
            return this.MY;
        }
        try {
            Bc();
            if (this.MY.has("ad_extra_data")) {
                Object objOpt = this.MY.opt("ad_extra_data");
                if (objOpt != null) {
                    try {
                        if (objOpt instanceof JSONObject) {
                            this.MY.put("ad_extra_data", IlO((JSONObject) objOpt).toString());
                        } else if (objOpt instanceof String) {
                            this.MY.put("ad_extra_data", IlO(new JSONObject((String) objOpt)).toString());
                        }
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.oeT.EO("AdEvent", "json error", e.getMessage());
                    }
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("adiff", this.IlO);
                    if (this.EO) {
                        jSONObject.put("interaction_method", this.Bc);
                        jSONObject.put("real_interaction_method", this.lEW);
                        jSONObject.put("image_mode", this.DmF);
                    }
                    this.MY.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException e4) {
                    com.bytedance.sdk.component.utils.oeT.EO("AdEvent", "json error", e4.getMessage());
                }
            }
            this.rp.set(true);
        } catch (Throwable unused) {
        }
        return this.MY;
    }

    public String tV() {
        return this.IlO;
    }

    private void MY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : EV.keySet()) {
            try {
                if (jSONObject.has(str)) {
                    Object objOpt = jSONObject.opt(str);
                    jSONObject.remove(str);
                    jSONObject.put(EV.get(str), objOpt);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private JSONObject IlO(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("adiff")) {
                jSONObject.put("adiff", this.IlO);
            }
            if (this.EO) {
                if (!jSONObject.has("interaction_method")) {
                    jSONObject.put("interaction_method", this.Bc);
                }
                if (!jSONObject.has("real_interaction_method")) {
                    jSONObject.put("real_interaction_method", this.lEW);
                }
                if (!jSONObject.has("image_mode")) {
                    jSONObject.put("image_mode", this.DmF);
                }
            }
            if (com.bytedance.sdk.openadsdk.AXM.IlO.IlO("replace_log_extra_key", false)) {
                MY(jSONObject);
            }
            jSONObject.put("pangle_client_unique_id", "pangle-" + this.IlO + "-" + System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("AdEvent", th.getMessage() == null ? "error " : th.getMessage());
            return jSONObject;
        }
    }

    public IlO(C0117IlO c0117IlO) {
        this.vCE = "adiff";
        this.rp = new AtomicBoolean(false);
        this.hp = new JSONObject();
        if (!TextUtils.isEmpty(c0117IlO.MY)) {
            this.IlO = c0117IlO.MY;
        } else {
            this.IlO = pP.IlO();
        }
        this.xF = c0117IlO.ea;
        this.oeT = c0117IlO.vCE;
        this.bWL = c0117IlO.EO;
        this.ea = c0117IlO.tV;
        if (!TextUtils.isEmpty(c0117IlO.Cc)) {
            this.zPa = c0117IlO.Cc;
        } else {
            this.zPa = "app_union";
        }
        this.AXM = c0117IlO.EV;
        this.cl = c0117IlO.lEW;
        this.es = c0117IlO.DmF;
        this.cL = c0117IlO.Bc;
        this.vAh = c0117IlO.rp;
        this.kBB = c0117IlO.hp;
        this.hp = c0117IlO.NV = c0117IlO.NV != null ? c0117IlO.NV : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.MY = jSONObject;
        if (!TextUtils.isEmpty(c0117IlO.hp)) {
            try {
                jSONObject.put("app_log_url", c0117IlO.hp);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO("AdEvent", e.getMessage());
            }
        }
        this.Bc = c0117IlO.cl;
        this.lEW = c0117IlO.cL;
        this.DmF = c0117IlO.IlO;
        this.EO = c0117IlO.es;
        this.Cc = System.currentTimeMillis();
        vCE();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO.MY
    public long MY() {
        return this.tV;
    }

    public JSONObject IlO(boolean z2) {
        JSONObject jSONObjectEO = EO();
        try {
            if (z2) {
                JSONObject jSONObject = new JSONObject(jSONObjectEO.toString());
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject == null) {
                    return jSONObject;
                }
                jSONObjectOptJSONObject.remove("app_log_url");
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObjectEO.toString());
            jSONObject2.remove("app_log_url");
            return jSONObject2;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("AdEvent", e.getMessage());
            return jSONObjectEO;
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO.MY
    public JSONObject IlO(String str) {
        return EO();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO.MY
    public long IlO() {
        return this.Cc;
    }

    private static void IlO(JSONObject jSONObject, String str) {
        try {
            Set<String> set = NV;
            if (!set.contains(str) && !set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("AdEvent", th);
        }
    }
}
