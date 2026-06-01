package com.bytedance.sdk.openadsdk.tV.IlO;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.OOq;
import com.bytedance.sdk.openadsdk.utils.kBB;
import com.bytedance.sdk.openadsdk.utils.oc;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.C2605va;
import com.ironsource.Q6;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private final String Cc;
    private final Context EO;
    private long IlO;
    private int MY;
    private final boolean tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private static final EO IlO = new EO();
    }

    private String Cc() {
        return DeviceUtils.EO(this.EO) ? "tv" : DeviceUtils.MY(this.EO) ? "android_pad" : "android";
    }

    private boolean EO() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static EO IlO() {
        return IlO.IlO;
    }

    private int tV() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String vCE() {
        StringBuilder sb = new StringBuilder();
        try {
            if (OOq.Cc()) {
                sb.append("MIUI-");
            } else if (OOq.MY()) {
                sb.append("FLYME-");
            } else {
                String strBWL = OOq.bWL();
                if (OOq.IlO(strBWL)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strBWL)) {
                    sb.append(strBWL);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public List<com.bytedance.sdk.openadsdk.tV.IlO> MY(List<com.bytedance.sdk.openadsdk.tV.IlO> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.tV.IlO ilO : list) {
            try {
                JSONObject jSONObjectEO = ilO.EO();
                jSONObjectEO.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.tV.IlO(ilO.IlO, jSONObjectEO));
            } catch (Exception e) {
                oeT.EO("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    private EO() {
        this.tV = EO();
        this.EO = cl.IlO().getApplicationContext();
        this.Cc = Cc();
    }

    public String IlO(List<com.bytedance.sdk.openadsdk.tV.IlO> list) {
        return zLG.Cc((list.size() <= 0 || list.get(0) == null || list.get(0).EO() == null) ? "" : list.get(0).EO().optString("app_log_url"));
    }

    private void IlO(com.bytedance.sdk.openadsdk.tV.IlO ilO, boolean z2) {
        if (ilO == null) {
            return;
        }
        try {
            String strOptString = z2 ? ilO.EO().optJSONObject("params").optString("log_extra", "") : ilO.EO().optString("log_extra", "");
            long jIlO = com.bytedance.sdk.openadsdk.core.model.oeT.IlO(strOptString);
            int iTV = com.bytedance.sdk.openadsdk.core.model.oeT.tV(strOptString);
            if (jIlO == 0) {
                jIlO = this.IlO;
            }
            this.IlO = jIlO;
            if (iTV == 0) {
                iTV = this.MY;
            }
            this.MY = iTV;
        } catch (Exception e) {
            oeT.EO("AdLogParamsGenerate", "getInfoFromLogExtra exception", e.getMessage());
        }
    }

    public JSONObject MY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Q6.d0, zLG.EO());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", zLG.Bc());
            jSONObject.put("sim_op", IlO(this.EO));
            jSONObject.put("root", this.tV ? 1 : 0);
            jSONObject.put("timezone", tV());
            jSONObject.put("access", kBB.IlO(this.EO));
            jSONObject.put(Q6.F, C2300e4.f8279d);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.Cc);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", BS.Cc(this.EO) + "x" + BS.EO(this.EO));
            jSONObject.put("display_density", IlO(BS.DmF(this.EO)));
            jSONObject.put("density_dpi", BS.DmF(this.EO));
            jSONObject.put(C2605va.f10440b, "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.rp.IlO(this.EO));
            jSONObject.put("rom", vCE());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.MY);
            jSONObject.put("uid", this.IlO);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            jSONObject.put("locale_language", DeviceUtils.tV());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.Cc() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.MY() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.vCE vceTV = cl.tV();
            jSONObject.put("force_language", pP.IlO(this.EO, "tt_choose_language"));
            if (vceTV.OOq("mnc")) {
                jSONObject.put("mnc", oc.EO());
            }
            if (vceTV.OOq("mcc")) {
                jSONObject.put("mcc", oc.MY());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public JSONObject IlO(List<com.bytedance.sdk.openadsdk.tV.IlO> list, long j, JSONObject jSONObject, boolean z2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            IlO(list.get(0), z2);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.tV.IlO> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().IlO(z2));
            }
            if (z2) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, jSONArray);
            }
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.tV.IlO> IlO(List<com.bytedance.sdk.openadsdk.tV.IlO> list, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.tV.IlO ilO : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectEO = ilO.EO();
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, jSONObjectEO.optString("label"));
                long jOptLong = jSONObjectEO.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.tV.vCE.EO.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObjectEO.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, jSONObjectEO.opt(next));
                    }
                }
                if (z2) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.tV.vCE(ilO.IlO, jSONObject));
            } catch (Exception e) {
                oeT.EO("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    private String IlO(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private String IlO(int i2) {
        if (i2 == 120) {
            return "ldpi";
        }
        if (i2 == 160) {
            return "mdpi";
        }
        if (i2 == 240) {
            return "hdpi";
        }
        if (i2 == 320) {
            return "xhdpi";
        }
        if (i2 == 480) {
            return "xxhdpi";
        }
        if (i2 != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }
}
