package com.bytedance.sdk.openadsdk.core.DmF;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.Cc;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.ironsource.Hc;
import com.ironsource.Y1;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static boolean IlO = false;

    public static int Cc() {
        if (cl.tV().HSR()) {
            return MY.MY().Bc();
        }
        return 6;
    }

    public static String EO() {
        return cl.tV().HSR() ? MY.MY().Cc() : "";
    }

    public static void IlO() {
        if (!IlO && cl.tV().HSR()) {
            MY.MY();
            IlO = MY.MY().EO();
        }
    }

    public static void MY(String str) {
        if (TextUtils.isEmpty(str) || !cl.tV().HSR()) {
            return;
        }
        MY.MY().MY(str);
    }

    public static long tV() {
        if (cl.tV().HSR()) {
            return MY.MY().vCE();
        }
        return 0L;
    }

    public static String vCE() {
        if (cl.tV().HSR()) {
            return MY.MY().tV();
        }
        return null;
    }

    public static void MY() {
        if (cl.tV().HSR()) {
            MY.MY().IlO();
        }
    }

    public static void IlO(String str) {
        if (cl.tV().HSR()) {
            MY.MY().IlO(str);
        }
    }

    public static void IlO(oeT oet, String str) {
        long jOptLong;
        long jOptLong2;
        long jOptLong3;
        Object obj;
        if (cl.tV().HSR()) {
            HashMap map = new HashMap();
            map.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            map.put("au_show", str);
            if (oet != null) {
                String strJAC = oet.JAC();
                boolean zIsEmpty = TextUtils.isEmpty(strJAC);
                String strOptString = Y1.f7808f;
                if (!zIsEmpty) {
                    map.put("request_id", strJAC);
                } else {
                    map.put("request_id", Y1.f7808f);
                }
                try {
                    long j = -1;
                    if (oet.DYs() != null) {
                        jOptLong = oet.DYs().optLong("ad_id", -1L);
                        jOptLong2 = oet.DYs().optLong("rit", -1L);
                        jOptLong3 = oet.DYs().optLong("ad_slot_type", -1L);
                        strOptString = oet.DYs().optString("ad_type", Y1.f7808f);
                    } else {
                        jOptLong = -1;
                        jOptLong2 = -1;
                        jOptLong3 = -1;
                    }
                    map.put("ad_id", Long.valueOf(jOptLong));
                    map.put("rit", Long.valueOf(jOptLong2));
                    map.put("ad_slot_type", Long.valueOf(jOptLong3));
                    map.put("ad_type", strOptString);
                    Map<String, Object> mapTN = oet.tN();
                    if (mapTN != null && (obj = mapTN.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j = Long.parseLong(obj.toString());
                    }
                    map.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j));
                    MY.MY().IlO(PglSSManager.REPORT_SCENE_ADSHOW, map);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> IlO(String str, String str2) {
        if (cl.tV().HSR()) {
            return MY.MY().IlO(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static void IlO(MotionEvent motionEvent) {
        if (cl.tV().HSR()) {
            MY.MY().IlO(motionEvent);
        }
    }

    public static void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (cl.tV().HSR()) {
                IlO();
                if (Cc() == 0) {
                    jSONObject.put("sec_did", MY.MY().tV());
                    String strIlO = Cc.IlO(jSONObject.toString());
                    Map<String, String> mapIlO = MY.MY().IlO("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", strIlO != null ? strIlO.getBytes() : new byte[0]);
                    if (mapIlO != null && mapIlO.size() > 0) {
                        for (String str : mapIlO.keySet()) {
                            jSONObject.put(str, mapIlO.get(str));
                        }
                        jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                        jSONObject.put("pangle_m", strIlO);
                    } else {
                        jSONObject.put("pglx", "8");
                    }
                    jSONObject.put("ec", MY.MY().vCE());
                    return;
                }
                jSONObject.put("pglx", String.valueOf(Cc()));
                return;
            }
            jSONObject.put("pglx", "6");
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("SecSdkHelperUtil", th.getMessage());
            try {
                jSONObject.put("pglx", Hc.e);
            } catch (JSONException unused) {
            }
        }
    }
}
