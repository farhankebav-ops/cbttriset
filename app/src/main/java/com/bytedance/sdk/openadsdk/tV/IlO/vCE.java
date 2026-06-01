package com.bytedance.sdk.openadsdk.tV.IlO;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    public static AtomicInteger IlO = new AtomicInteger(0);
    public static AtomicInteger MY = new AtomicInteger(0);
    public static AtomicInteger EO = new AtomicInteger(0);
    public static AtomicInteger tV = new AtomicInteger(0);
    public static AtomicInteger Cc = new AtomicInteger(0);
    public static AtomicInteger vCE = new AtomicInteger(0);
    public static AtomicInteger Bc = new AtomicInteger(0);
    public static AtomicInteger lEW = new AtomicInteger(0);
    public static AtomicInteger DmF = new AtomicInteger(0);

    public static void Cc() {
        try {
            if (DeviceUtils.MY()) {
                return;
            }
            DmF.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void EO() {
        try {
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad", "get_ad_event_key", tV().toString());
        } catch (Throwable unused) {
        }
    }

    public static void IlO() {
        try {
            long jIlO = com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad", "get_ad_event_time_key", 0L);
            if (jIlO > 0 && System.currentTimeMillis() - jIlO >= SignalManager.TWENTY_FOUR_HOURS_MILLIS) {
                MY();
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (jIlO <= 0 || jIlO > System.currentTimeMillis()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            int iOptInt = jSONObject.optInt("load_get_ad_version", 0);
            if (iOptInt >= 5702 && (iOptInt < 5800 || iOptInt >= 5802)) {
                IlO.addAndGet(jSONObject.optInt("load_times"));
                MY.addAndGet(jSONObject.optInt("load_success"));
                EO.addAndGet(jSONObject.optInt("load_fail"));
                tV.addAndGet(jSONObject.optInt("load_success_and_parse_success"));
                Cc.addAndGet(jSONObject.optInt("load_success_and_parse_fail"));
                vCE.addAndGet(jSONObject.optInt("load_success_and_no_ad"));
                Bc.addAndGet(jSONObject.optInt("load_fail_by_no_net"));
                lEW.addAndGet(jSONObject.optInt("load_fail_by_io"));
                DmF.addAndGet(jSONObject.optInt("load_fail_in_background"));
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void MY() {
        try {
            com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO("pangle_sdk_get_ad_track", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static JSONObject tV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", IlO.get());
            jSONObject.put("load_success", MY.get());
            jSONObject.put("load_fail", EO.get());
            jSONObject.put("load_fail_in_background", DmF.get());
            jSONObject.put("load_success_and_parse_success", tV.get());
            jSONObject.put("load_success_and_parse_fail", Cc.get());
            jSONObject.put("load_success_and_no_ad", vCE.get());
            jSONObject.put("load_fail_by_no_net", Bc.get());
            jSONObject.put("load_fail_by_io", lEW.get());
            jSONObject.put("load_get_ad_version", BuildConfig.VERSION_CODE);
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void IlO(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
