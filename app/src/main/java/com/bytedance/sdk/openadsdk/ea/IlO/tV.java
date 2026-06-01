package com.bytedance.sdk.openadsdk.ea.IlO;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV<T extends tV> implements EO {
    private String Bc;
    private String DmF;
    private String EO;
    private String EV;
    private String IlO;
    private String MY;
    private String NV;
    private String rp;
    private final String tV = BuildConfig.VERSION_NAME;
    private long Cc = System.currentTimeMillis() / 1000;
    private int vCE = 0;
    private int lEW = 0;

    public static tV<tV> MY() {
        return new tV<>();
    }

    private JSONObject ea() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Q6.F, 1);
            jSONObject.put(Q6.B, Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(C2300e4.h.V, zLG.Cc());
            jSONObject.put(Q6.d0, zLG.EO());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String Bc() {
        return TextUtils.isEmpty(BuildConfig.VERSION_NAME) ? "" : BuildConfig.VERSION_NAME;
    }

    public String Cc() {
        return this.MY;
    }

    public int DmF() {
        return this.vCE;
    }

    public String EO() {
        return this.IlO;
    }

    public int EV() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.openadsdk.ea.IlO.EO
    public JSONObject IlO() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ad_sdk_version", Bc());
            jSONObject2.put("app_version", zLG.Bc());
            jSONObject2.put("timestamp", lEW());
            jSONObject2.put("conn_type", xF.MY(cl.IlO()));
            jSONObject2.put("appid", TextUtils.isEmpty(DmF.MY().tV()) ? "" : DmF.MY().tV());
            jSONObject2.put("device_info", ea());
            if (!TextUtils.isEmpty(EO())) {
                jSONObject2.put("type", EO());
            }
            jSONObject2.put("error_code", EV());
            if (!TextUtils.isEmpty(rp())) {
                jSONObject2.put("error_msg", rp());
            }
            if (!TextUtils.isEmpty(Cc())) {
                jSONObject2.put("rit", Cc());
            }
            if (!TextUtils.isEmpty(vCE())) {
                jSONObject2.put("creative_id", vCE());
            }
            if (DmF() > 0) {
                jSONObject2.put("adtype", DmF());
            }
            if (!TextUtils.isEmpty(NV())) {
                jSONObject2.put("req_id", NV());
            }
            if (!TextUtils.isEmpty(hp())) {
                jSONObject2.put("extra", hp());
            }
            String strTV = tV();
            if (TextUtils.isEmpty(strTV)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(strTV);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONObject.put("os_version_int", Build.VERSION.SDK_INT);
                jSONObject2.put("event_extra", jSONObject.toString());
            } else if (!TextUtils.isEmpty(strTV)) {
                jSONObject2.put("event_extra", strTV);
            }
            if (!TextUtils.isEmpty(bWL())) {
                jSONObject2.put("duration", bWL());
            }
        } catch (Throwable th) {
            oeT.EO("LogStatsBase", th.getMessage());
        }
        return jSONObject2;
    }

    public String NV() {
        return this.Bc;
    }

    public String bWL() {
        return this.rp;
    }

    public String hp() {
        return this.NV;
    }

    public long lEW() {
        return this.Cc;
    }

    public String rp() {
        return this.DmF;
    }

    public String tV() {
        return this.EV;
    }

    public String vCE() {
        return this.EO;
    }

    public T Bc(String str) {
        this.NV = str;
        return (T) zPa();
    }

    public T Cc(String str) {
        this.Bc = str;
        return (T) zPa();
    }

    public T EO(String str) {
        this.MY = str;
        return (T) zPa();
    }

    public T MY(String str) {
        this.EV = str;
        return (T) zPa();
    }

    public T lEW(String str) {
        this.rp = str;
        return (T) zPa();
    }

    public T tV(String str) {
        this.EO = str;
        return (T) zPa();
    }

    public T vCE(String str) {
        this.DmF = str;
        return (T) zPa();
    }

    public T MY(int i2) {
        this.lEW = i2;
        return (T) zPa();
    }

    private T zPa() {
        return this;
    }

    public T IlO(String str) {
        this.IlO = str;
        return (T) zPa();
    }

    public T IlO(int i2) {
        this.vCE = i2;
        return (T) zPa();
    }
}
