package com.bytedance.sdk.openadsdk.component.tV;

import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.vSq;
import com.bytedance.sdk.openadsdk.ea.EO;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.ea.MY;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.ironsource.C2461n2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static void IlO(final int i2, final int i8) {
        EO.IlO("openad_load_ad_timeout", false, new MY() { // from class: com.bytedance.sdk.openadsdk.component.tV.IlO.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i2);
                jSONObject.put("user_timeout_time", i8);
                return tV.MY().IlO("openad_load_ad_timeout").MY(jSONObject.toString());
            }
        });
    }

    public static void MY(oeT oet) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAppOpenAdReport", "reportCacheLoss json error", e);
        }
        com.bytedance.sdk.openadsdk.tV.EO.tV(oet, "cache_loss", jSONObject);
    }

    public static void IlO(oeT oet, int i2, int i8, float f4) {
        JSONObject jSONObject = new JSONObject();
        try {
            IlO(jSONObject, oet);
            jSONObject.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("total_time", f4);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(jSONObject, i8, i2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAppOpenAdReport", "reportSkip json error", e);
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "skip", i2, jSONObject);
    }

    public static void MY(oeT oet, long j, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", oet.fdM().f4687c);
            jSONObject.put("video_duration", oet.fdM().f4688d);
            jSONObject.put(C2461n2.f9470u, z2 ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "download_video_duration", j, jSONObject);
    }

    public static void IlO(oeT oet, long j, float f4, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            IlO(jSONObject, oet);
            jSONObject.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
            if (z2) {
                double d8 = f4;
                jSONObject.put("video_duration", d8);
                jSONObject.put("video_percent", (int) (((j * 1.0d) / 10.0d) / d8));
            } else {
                jSONObject.put("image_duration", f4);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAppOpenAdReport", "reportDestroy json error", e);
        }
        com.bytedance.sdk.openadsdk.tV.EO.tV(oet, "destroy", jSONObject);
    }

    public static void IlO(oeT oet) {
        com.bytedance.sdk.openadsdk.tV.EO.tV(oet, "cache_expire", (JSONObject) null);
    }

    public static void IlO(oeT oet, long j, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C2461n2.f9470u, z2 ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "download_image_duration", j, jSONObject);
    }

    public static void IlO(oeT oet, int i2, vSq vsq) {
        JSONObject jSONObject = new JSONObject();
        long jVCE = 0;
        try {
            jSONObject.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i2);
            if (vsq != null) {
                vsq.MY(DM.MY());
                IlO(jSONObject, oet);
                jSONObject.put("client_start_time", vsq.MY());
                jSONObject.put("sever_time", vsq.tV());
                jSONObject.put("network_time", vsq.EO());
                jSONObject.put("client_end_time", vsq.Cc());
                jSONObject.put("download_resource_duration", vsq.Bc());
                jSONObject.put("resource_source", vsq.lEW());
                jSONObject.put("is_bidding", vsq.IlO ? 1 : 0);
                if (vsq.IlO) {
                    jSONObject.put("load_wait_time", vsq.MY);
                }
                jVCE = vsq.vCE();
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAppOpenAdReport", "reportLoadNetDuration json error", e);
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "load_net_duration", jVCE, jSONObject);
    }

    public static void IlO(oeT oet, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            IlO(jSONObject, oet);
            jSONObject.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "load_cache_duration", j, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void IlO(org.json.JSONObject r1, com.bytedance.sdk.openadsdk.core.model.oeT r2) {
        /*
            java.lang.String r0 = "is_icon_only"
            if (r2 == 0) goto Lc
            boolean r2 = r2.mV()     // Catch: org.json.JSONException -> L11
            if (r2 == 0) goto Lc
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            r1.put(r0, r2)     // Catch: org.json.JSONException -> L11
            return
        L11:
            r1 = move-exception
            java.lang.String r2 = "TTAppOpenAdReport"
            java.lang.String r1 = r1.getMessage()
            com.bytedance.sdk.component.utils.oeT.EO(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(org.json.JSONObject, com.bytedance.sdk.openadsdk.core.model.oeT):void");
    }
}
