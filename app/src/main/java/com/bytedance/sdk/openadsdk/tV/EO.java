package com.bytedance.sdk.openadsdk.tV;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import com.bytedance.sdk.openadsdk.core.kBB;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.dY;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.IlO;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static void Cc(oeT oet, final com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO, final String str) {
        IlO(System.currentTimeMillis(), oet, str, "web_behavior_click", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.31
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", ilO.EO());
                    jSONObject2.put("current_url_index", ilO.tV());
                    jSONObject2.put("arbi_start_x", ilO.Cc());
                    jSONObject2.put("arbi_start_y", ilO.vCE());
                    jSONObject2.put("click_duration", ilO.Bc());
                    jSONObject2.put("is_trigger_jump", ilO.lEW());
                    jSONObject2.put("click_type", String.valueOf(ilO.es()));
                    if (ilO.IlO() != -1) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("hit_type", ilO.IlO());
                        jSONObject3.put("hit_extra", ilO.MY());
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "onWebBehaviorClick", th.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void EO(oeT oet, String str, final long j) {
        IlO(System.currentTimeMillis(), oet, str, "load_feeling_duration", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.6
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", th.getMessage());
                }
                jSONObject.toString();
                return jSONObject;
            }
        });
    }

    @WorkerThread
    public static void IlO() {
        try {
            Class.forName(EO.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void MY(oeT oet, String str, final long j) {
        if (oet != null && j > 0 && j < 200000) {
            IlO(System.currentTimeMillis(), oet, str, "video_click_duration", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.3
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("video_click_duration_time", j);
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    @DungeonFlag
    private static void tV(final oeT oet, final String str, final String str2, final JSONObject jSONObject) {
        if (oet == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (oet.vh() && C2461n2.f9471v.equals(str)) {
            return;
        }
        if (C2461n2.f9471v.equals(str)) {
            oet.lEW(true);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        IlO(new com.bytedance.sdk.component.lEW.lEW("onShow") { // from class: com.bytedance.sdk.openadsdk.tV.EO.49
            @Override // java.lang.Runnable
            public void run() {
                final String strIlO;
                if (com.bytedance.sdk.openadsdk.core.cl.tV().pFe()) {
                    strIlO = com.bytedance.sdk.openadsdk.core.DmF.IlO.IlO.IlO((Application) com.bytedance.sdk.openadsdk.core.cl.IlO()).IlO(str2, DeviceUtils.IlO(), oet.hFV());
                } else {
                    strIlO = "none";
                }
                EO.IlO(jCurrentTimeMillis, oet, str2, str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.49.1
                    @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                    public JSONObject IlO() {
                        Object obj;
                        try {
                            kBB.MY(oet);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                AnonymousClass49 anonymousClass49 = AnonymousClass49.this;
                                JSONObject jSONObject3 = jSONObject;
                                if (jSONObject3 != null) {
                                    jSONObject3.put("interaction_method", oet.kBB());
                                    AnonymousClass49 anonymousClass492 = AnonymousClass49.this;
                                    jSONObject.put("real_interaction_method", oet.vAh());
                                    jSONObject.put("video_skip_result", com.bytedance.sdk.openadsdk.core.cl.tV().rp(String.valueOf(oet.hFV())));
                                    jSONObject.put("au_show", strIlO);
                                    AnonymousClass49 anonymousClass493 = AnonymousClass49.this;
                                    com.bytedance.sdk.openadsdk.xF.IlO.IlO.IlO(oet, jSONObject);
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                } else {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("interaction_method", oet.kBB());
                                    jSONObject4.put("real_interaction_method", oet.vAh());
                                    jSONObject4.put("video_skip_result", com.bytedance.sdk.openadsdk.core.cl.tV().rp(String.valueOf(oet.hFV())));
                                    jSONObject4.put("au_show", strIlO);
                                    com.bytedance.sdk.openadsdk.xF.IlO.IlO.IlO(oet, jSONObject4);
                                    jSONObject2.put("ad_extra_data", jSONObject4.toString());
                                }
                                jSONObject2.putOpt("log_extra", oet.KT());
                                float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - oet.ZUt()).floatValue();
                                if (fFloatValue <= 0.0f) {
                                    fFloatValue = 0.0f;
                                }
                                jSONObject2.putOpt("show_time", Float.valueOf(fFloatValue));
                                jSONObject2.putOpt("ua_policy", Integer.valueOf(oet.quf()));
                                String strMmj = oet.mmj();
                                if (!TextUtils.isEmpty(strMmj) && !TextUtils.isEmpty(strMmj)) {
                                    try {
                                        jSONObject2.put("ttdsp_price", Math.round(Float.parseFloat(strMmj) * 100000.0f));
                                    } catch (Throwable th) {
                                        jSONObject2.put("ttdsp_price", 0);
                                        com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", th.getMessage());
                                    }
                                }
                                if (oet.tN() == null) {
                                    return jSONObject2;
                                }
                                try {
                                    Object obj2 = oet.tN().get(TTAdConstant.SDK_BIDDING_TYPE);
                                    if (obj2 == null || Integer.parseInt(obj2.toString()) != 2 || (obj = oet.tN().get("price")) == null) {
                                        return jSONObject2;
                                    }
                                    jSONObject2.put("ttdsp_price", Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                                    return jSONObject2;
                                } catch (Throwable th2) {
                                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.AdEvent", "client bidding price error: ", th2);
                                    return jSONObject2;
                                }
                            } catch (Exception unused) {
                                return jSONObject2;
                            }
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                });
                if (C2461n2.f9471v.equals(str)) {
                    if (!oet.ct()) {
                        if (oet.pS()) {
                            com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(oet.qvT(), new EO.MY("show_urls", oet));
                        } else {
                            EO.IlO(oet);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        int iOptInt = jSONObject2.optInt("dynamic_show_type");
                        if (oet.Emj() == 1 && (iOptInt == 7 || iOptInt == 10)) {
                            com.bytedance.sdk.component.utils.DmF.IlO().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.EO.49.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("auto_click", true);
                                        AnonymousClass49 anonymousClass49 = AnonymousClass49.this;
                                        EO.MY(oet, str2, C2318f4.f8523d, jSONObject3);
                                    } catch (Exception unused) {
                                        com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "ugen click exception");
                                    }
                                }
                            }, com.bytedance.sdk.openadsdk.core.settings.hp.aP().ED());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.DmF.EO.IlO(oet, strIlO);
                }
            }
        });
    }

    public static void Cc(oeT oet, String str, JSONObject jSONObject) {
        tV(oet, "activity_recreate", str, jSONObject);
    }

    public static void EO(oeT oet, String str, final int i2) {
        IlO(System.currentTimeMillis(), oet, str, "check_meta_more", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.8
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("error_code", i2);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.hp.aP().tf());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void IlO(oeT oet, String str, final int i2) {
        IlO(System.currentTimeMillis(), oet, str, "open_url_h5", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.1
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("preload_status", Integer.valueOf(i2));
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void MY(oeT oet, String str, final int i2) {
        IlO(System.currentTimeMillis(), oet, str, "check_meta", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.7
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("error_code", i2);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.hp.aP().tf());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public static void IlO(String str, final JSONObject jSONObject, oeT oet) {
            String strIlO = zLG.IlO(oet);
            if (strIlO == null) {
                return;
            }
            EO.IlO(System.currentTimeMillis(), oet, strIlO.concat("_landingpage"), str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.IlO.1
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        return jSONObject2;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.loadEvent error", th);
                        return jSONObject2;
                    }
                }
            });
        }

        public static void IlO(final int i2, final int i8, oeT oet) {
            String strIlO = zLG.IlO(oet);
            if (strIlO == null) {
                return;
            }
            EO.IlO(System.currentTimeMillis(), oet, strIlO.concat("_landingpage"), "local_res_hit_rate", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.IlO.2
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("all_times", i8);
                        jSONObject2.put("hit_times", i2);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }

        public static void IlO(final long j, final oeT oet, String str, final ILoader iLoader, final String str2) {
            if (str == null) {
                return;
            }
            EO.IlO(System.currentTimeMillis(), oet, str, "landingpage_init", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.IlO.3
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(iLoader, str2);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(oeT.EO, oet.nm() ? 1 : 0);
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                        jSONObject2.put("url", oet.pFe());
                        jSONObject2.put("channel_name", oet.tU());
                        jSONObject2.put("interceptor_status", (TextUtils.isEmpty(oet.tU()) || iIlO <= 0) ? 0 : 1);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("resource_count", iIlO);
                        jSONObject2.put("resource_info", jSONObject4);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("duration", j);
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }

        public static void IlO(final int i2, final int i8, final int i9, final int i10, final oeT oet, String str, final int i11) {
            if (str == null || TextUtils.isEmpty(oet.tU())) {
                return;
            }
            EO.IlO(System.currentTimeMillis(), oet, str, "landing_page_resource_detail", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.IlO.4
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("next_url", oet.pFe());
                        jSONObject2.put("channel_name", oet.tU());
                        jSONObject2.put("preload_status", i2 <= 0 ? 0 : 2);
                        jSONObject2.put("first_page", i11);
                        jSONObject2.put("preload_h5_type", oet.eVC());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("channel_response", i2);
                        jSONObject3.put("failResourceCount", i8);
                        jSONObject3.put("successCount", i9);
                        jSONObject3.put("failCount", i10);
                        jSONObject2.put("resource_info", jSONObject3);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }
    }

    public static void EO(final oeT oet, String str) {
        if (oet == null || !oeT.EO(oet) || oet.QtY() == null) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str, "endcard_show", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.26
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", oet.QtY().EO());
                    jSONObject2.putOpt("id", oet.QtY().IlO());
                    jSONObject2.putOpt("md5", oet.QtY().MY());
                    if (oet.fdM() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(oet.fdM().l));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(final oeT oet, String str) {
        IlO(System.currentTimeMillis(), oet, str, "endcard_load_start", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.12
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (oeT.EO(oet)) {
                        if (oet.QtY() != null) {
                            jSONObject2.putOpt("url", oet.QtY().EO());
                            jSONObject2.putOpt("id", oet.QtY().IlO());
                            jSONObject2.putOpt("md5", oet.QtY().MY());
                        }
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", oet.fdM().h);
                        jSONObject2.putOpt("style_id", oet.jS());
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void MY(final oeT oet, String str) {
        IlO(System.currentTimeMillis(), oet, str, "picture_click", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.14
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("ad_slot_type", oet.ssS().getNativeAdType());
                    jSONObject.put("interaction_method", oet.kBB());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void IlO(final oeT oet, String str, final long j) {
        IlO(System.currentTimeMillis(), oet, str, "endcard_load_finish", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.22
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (oeT.EO(oet)) {
                        if (oet.QtY() != null) {
                            jSONObject2.putOpt("url", oet.QtY().EO());
                            jSONObject2.putOpt("id", oet.QtY().IlO());
                            jSONObject2.putOpt("md5", oet.QtY().MY());
                        }
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", oet.fdM().h);
                        jSONObject2.putOpt("style_id", oet.jS());
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void MY(oeT oet, String str, String str2, final JSONObject jSONObject) {
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.19
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void EO(oeT oet, final com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO, final String str) {
        IlO(System.currentTimeMillis(), oet, str, "web_behavior_stay", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.29
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", ilO.EO());
                    jSONObject2.put("current_url_index", ilO.tV());
                    jSONObject2.put("arbi_stay_duration", ilO.bWL());
                    jSONObject2.put("browsing_percentage", ilO.ea());
                    jSONObject2.put("out_focus_scene", ilO.zPa());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "onWebBehaviorStay", th.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(final oeT oet, String str, final long j, final int i2, final String str2, final String str3) {
        IlO(System.currentTimeMillis(), oet, str, "endcard_load_fail", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.33
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (oeT.EO(oet)) {
                        if (oet.QtY() != null) {
                            jSONObject2.putOpt("url", oet.QtY().EO());
                            jSONObject2.putOpt("id", oet.QtY().IlO());
                            jSONObject2.putOpt("md5", oet.QtY().MY());
                        }
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", oet.fdM().h);
                        jSONObject2.putOpt("style_id", oet.jS());
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject2.putOpt("error_url", str3);
                        }
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject2.put("error_code", i2);
                    jSONObject2.put("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void MY(final long j, final oeT oet, String str, final String str2) {
        IlO(System.currentTimeMillis(), oet, str, "endcard_feeling_duraion", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.25
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("duration", j);
                    if (oeT.EO(oet)) {
                        if (oet.QtY() != null) {
                            jSONObject2.putOpt("url", oet.QtY().EO());
                            jSONObject2.putOpt("id", oet.QtY().IlO());
                            jSONObject2.putOpt("md5", oet.QtY().MY());
                        }
                        jSONObject2.putOpt("from", str2);
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.put("url", oet.fdM().h);
                        jSONObject2.put("style_id", oet.jS());
                        if (oet.fdM() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void EO(oeT oet, final String str, final String str2, final JSONObject jSONObject) {
        if (oet == null || jSONObject == null) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.37
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(final oeT oet, String str, final long j, final int i2, final int i8) {
        IlO(System.currentTimeMillis(), oet, str, "load", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.44
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("interaction_method", Integer.valueOf(oet.kBB()));
                    jSONObject2.put("first_page", i8);
                    jSONObject2.put("preload_h5_type", oet.eVC());
                    int i9 = i2;
                    if (i9 >= 0) {
                        jSONObject2.putOpt("preload_status", Integer.valueOf(i9));
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME));
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void MY(oeT oet, final com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO, final String str) {
        IlO(System.currentTimeMillis(), oet, str, "web_behavior_load", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.28
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", ilO.EO());
                    jSONObject2.put("current_url_index", ilO.tV());
                    jSONObject2.put("arbi_load_duration", ilO.cL());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "onWebBehaviorLoad", th.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void tV(final oeT oet, final String str, final int i2) {
        IlO(System.currentTimeMillis(), oet, str, "material_status", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.13
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("trigger_type", i2);
                    jSONObject3.put("image_mode", oet.uI());
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject.toString();
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void EO(oeT oet, final String str, final JSONObject jSONObject) {
        IlO(System.currentTimeMillis(), oet, str, MY.vCE, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.39
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                String str2 = MY.IlO;
                return jSONObject2;
            }
        });
    }

    public static void IlO(String str, oeT oet, String str2, final Map<String, Object> map) {
        IlO(System.currentTimeMillis(), oet, str2, str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.47
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (map != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void MY(oeT oet, String str, String str2, final JSONObject jSONObject, final long j) {
        if (oet == null || jSONObject == null) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.36
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void tV(oeT oet, final com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO, final String str) {
        IlO(System.currentTimeMillis(), oet, str, "web_behavior_scroll", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.30
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", ilO.EO());
                    jSONObject2.put("current_url_index", ilO.tV());
                    jSONObject2.put("trigger_scroll_x", ilO.DmF());
                    jSONObject2.put("trigger_scroll_y", ilO.NV());
                    jSONObject2.put("arbi_offset_y", ilO.EV());
                    jSONObject2.put("scroll_type", ilO.rp());
                    jSONObject2.put("scroll_duration", ilO.hp());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "onWebBehaviorScroll", th.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(long j, oeT oet, String str, String str2, final JSONObject jSONObject, Bc bc, com.bytedance.sdk.openadsdk.tV.MY.IlO ilO) {
        IlO(j, oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.48
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                return jSONObject;
            }
        });
    }

    public static void MY(oeT oet, final String str, final JSONObject jSONObject) {
        IlO(System.currentTimeMillis(), oet, str, MY.Cc, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.38
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                String str2 = MY.IlO;
                return jSONObject2;
            }
        });
    }

    public static void tV(oeT oet, String str, JSONObject jSONObject) {
        if (oet == null) {
            return;
        }
        IlO(oet, str, -1L, jSONObject);
    }

    @DungeonFlag
    public static void IlO(oeT oet, String str, JSONObject jSONObject) {
        tV(oet, C2461n2.f9471v, str, jSONObject);
    }

    public static void MY(oeT oet, String str, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i2);
        } catch (JSONException unused) {
        }
        MY(oet, str, "download_app_ad_track", jSONObject);
    }

    public static void IlO(oeT oet) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.rp.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()))) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(oet.qvT(), true), 1, oet.ED());
    }

    @DungeonFlag
    public static void IlO(final String str, final oeT oet, final String str2, final Bc bc) {
        if (oet == null || bc == null || !bc.IlO()) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.50
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", str);
                    Bc bc2 = bc;
                    if (bc2 != null && bc2.MY() != null) {
                        JSONObject jSONObjectMY = bc.MY();
                        if (str2.equals("open_ad")) {
                            jSONObjectMY.put("is_icon_only", oet.mV() ? 1 : 0);
                        }
                        jSONObject.put("ad_extra_data", jSONObjectMY.toString());
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(final oeT oet, final String str, final DM dm) {
        if (oet == null) {
            return;
        }
        final long jTV = dm.tV();
        IlO(System.currentTimeMillis(), oet, str, "stay_duration", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.2
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("click_stay_time", jTV);
                    jSONObject.put("click_time", dm.IlO);
                    if (str.equals("open_ad")) {
                        jSONObject.put("is_icon_only", oet.mV() ? 1 : 0);
                    }
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(oeT oet, final String str, final int i2, final String str2, final long j, final boolean z2, final int i8, final long j3) {
        IlO(System.currentTimeMillis(), oet, str, MY.tV, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.4
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("invisible_scene", i2);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("loading_visible_time", j);
                    jSONObject.put("arbi_trigger_start", z2);
                    jSONObject.put("arbi_convert_count", i8);
                    jSONObject.put("loading_start_timestamp", j3);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(oeT oet, String str, final long j, final boolean z2) {
        IlO(System.currentTimeMillis(), oet, str, "lp_loading", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.5
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("if_lp_loading_success", z2 ? 1 : 2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                    return jSONObject2;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void IlO(oeT oet, final String str, final int i2, final String str2, final int i8) {
        IlO(System.currentTimeMillis(), oet, str, MY.IlO, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.9
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i2);
                    jSONObject.put("arbi_current_url", str2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("new_index", i8);
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(oeT oet, final String str, final int i2, final String str2, final float f4) {
        IlO(System.currentTimeMillis(), oet, str, MY.MY, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.10
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i2);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("arbi_load_duration", f4);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(oeT oet, final String str, final int i2, final String str2, final String str3, final int i8) {
        IlO(System.currentTimeMillis(), oet, str, MY.EO, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.11
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i2);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("load_url", str3);
                    jSONObject.put("url_flag", i8);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                }
                return jSONObject2;
            }
        });
    }

    @DungeonFlag
    public static void IlO(final String str, final oeT oet, final com.bytedance.sdk.openadsdk.core.model.NV nv, final String str2, final boolean z2, final Map<String, Object> map, final int i2) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        IlO(new com.bytedance.sdk.component.lEW.lEW("onClick") { // from class: com.bytedance.sdk.openadsdk.tV.EO.15
            @Override // java.lang.Runnable
            public void run() {
                oeT oet2 = oet;
                if (oet2 == null) {
                    return;
                }
                EO.IlO(jCurrentTimeMillis, oet2, str2, str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.15.1
                    @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                    public JSONObject IlO() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            com.bytedance.sdk.openadsdk.core.model.NV nv2 = nv;
                            if (nv2 != null) {
                                JSONObject jSONObjectIlO = nv2.IlO();
                                jSONObjectIlO.put("is_valid", z2);
                                int i8 = i2;
                                if (i8 > 0 && i8 <= 2) {
                                    jSONObjectIlO.put("user_behavior_type", i8);
                                }
                                Map map2 = map;
                                if (map2 != null) {
                                    if (map2.containsKey("duration")) {
                                        jSONObject.put("duration", map.get("duration"));
                                    }
                                    for (Map.Entry entry : map.entrySet()) {
                                        if (!"duration".equals(entry.getKey())) {
                                            jSONObjectIlO.put((String) entry.getKey(), entry.getValue());
                                        }
                                    }
                                }
                                jSONObjectIlO.put("interaction_method", oet.kBB());
                                if (str2.equals("open_ad")) {
                                    jSONObjectIlO.put("is_icon_only", oet.mV() ? 1 : 0);
                                }
                                jSONObject.put("ad_extra_data", jSONObjectIlO.toString());
                            }
                            jSONObject.putOpt("log_extra", oet.KT());
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - oet.ZUt()).floatValue();
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject.putOpt("show_time", Float.valueOf(fFloatValue));
                            jSONObject.putOpt("ua_policy", Integer.valueOf(oet.quf()));
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    }
                });
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.rp.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO())) && C2318f4.f8523d.equals(str)) {
                    com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(oet.ts(), true), 2, oet.ED());
                }
                if (C2318f4.f8523d.equals(str)) {
                    kBB.EO(oet);
                }
            }
        });
    }

    public static void IlO(oeT oet, String str, String str2, final JSONObject jSONObject) {
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.16
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    if (!jSONObject.has("duration")) {
                        return jSONObject2;
                    }
                    jSONObject2.put("duration", jSONObject.get("duration"));
                    return jSONObject2;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", e.getMessage());
                    return jSONObject2;
                }
            }
        });
        if (C2318f4.f8523d.equals(str2)) {
            kBB.EO(oet);
        }
    }

    public static void IlO(oeT oet, String str, final int i2, final long j) {
        IlO(System.currentTimeMillis(), oet, str, "video_choose", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.17
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("video_choose", i2);
                    jSONObject2.put("video_choose_duration", j);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void IlO(oeT oet, String str, final String str2, final long j, final int i2, JSONObject jSONObject, final Bc bc) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        final JSONObject jSONObject2 = jSONObject;
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.18
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                Bc bc2;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("duration", j);
                    jSONObject3.put("percent", i2);
                    if (("feed_break".equals(str2) || "feed_over".equals(str2)) && (bc2 = bc) != null) {
                        bc2.IlO(jSONObject2);
                    }
                    jSONObject3.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject3;
            }
        });
    }

    public static void IlO(oeT oet, String str, String str2, final JSONObject jSONObject, final long j) {
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.20
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                    jSONObject2.put("duration", j);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(final oeT oet, String str, String str2, final Map<String, Object> map) {
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.21
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        Object obj = map.get("duration");
                        if (obj instanceof Long) {
                            jSONObject.put("duration", obj);
                        }
                    }
                    jSONObject2.put("dp_creative_type", oet.lQ());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void IlO(long j, oeT oet, String str, String str2) {
        IlO(j, oet, str, str2, (com.bytedance.sdk.openadsdk.ea.EO.IlO) null);
    }

    @DungeonFlag
    public static void IlO(final long j, final oeT oet, final String str, final String str2, final com.bytedance.sdk.openadsdk.ea.EO.IlO ilO) {
        if (oet == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || IlO(oet.aQ(), str2)) {
            return;
        }
        IlO(new com.bytedance.sdk.component.lEW.lEW(str2) { // from class: com.bytedance.sdk.openadsdk.tV.EO.23
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO ilO2 = ilO;
                    if (ilO2 != null) {
                        jSONObject = ilO2.IlO();
                        if (jSONObject == null) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.putOpt("log_extra", oet.KT());
                    jSONObject.putOpt("ua_policy", Integer.valueOf(oet.quf()));
                } catch (Exception unused2) {
                    jSONObject = null;
                }
                new IlO.C0117IlO(j, oet).MY(str).EO(str2).Cc(oet.ED()).lEW(oet.Jm()).IlO(oet.PTq()).IlO(jSONObject).Bc(oet.JAC()).IlO((com.bytedance.sdk.openadsdk.tV.MY.IlO) null);
            }
        });
    }

    public static void IlO(oeT oet, String str, final String str2, final com.bytedance.sdk.openadsdk.ea.EO.IlO ilO) {
        IlO(System.currentTimeMillis(), oet, str, "playable_track", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.24
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO ilO2 = ilO;
                    if (ilO2 == null || (jSONObject = ilO2.IlO()) == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("is_new_playable", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pag_json_data", jSONObject.toString());
                    jSONObject3.put("playable_event", str2);
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void IlO(oeT oet, final com.bytedance.sdk.openadsdk.ea.IlO.IlO ilO, final String str) {
        IlO(System.currentTimeMillis(), oet, str, "web_behavior_keyword", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.27
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", ilO.EO());
                    jSONObject2.put("keyword", ilO.cl());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", "onWebBehaviorKeyword", th.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(final long j, final oeT oet, String str) {
        if (oet == null || !oeT.EO(oet) || oet.QtY() == null) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str, "endcard_close", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.32
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", oet.QtY().EO());
                    jSONObject2.putOpt("id", oet.QtY().IlO());
                    jSONObject2.putOpt("md5", oet.QtY().MY());
                    if (oet.fdM() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(oet.fdM().l));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void IlO(oeT oet, String str, final String str2) {
        IlO(System.currentTimeMillis(), oet, str, "show_error", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.34
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(oeT oet, String str, String str2, final long j, final JSONObject jSONObject) {
        if (oet == null || jSONObject == null) {
            return;
        }
        IlO(System.currentTimeMillis(), oet, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.35
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("duration", j);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", e.getMessage());
                    return jSONObject2;
                }
            }
        });
    }

    public static void IlO(String str, long j) {
        com.bytedance.sdk.openadsdk.core.Bc.EO.IlO(str, j);
    }

    @DungeonFlag
    public static void IlO(final oeT oet, final String str, final String str2, final String str3, final long j, final long j3, final JSONObject jSONObject, final boolean z2) {
        if (oet == null || IlO(oet.aQ(), str3)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        IlO(new com.bytedance.sdk.component.lEW.lEW("sendJsAdEvent") { // from class: com.bytedance.sdk.openadsdk.tV.EO.40
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArrayOptJSONArray;
                String strPTq = oet.PTq();
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        String strOptString = jSONObject.optString("ad_extra_data");
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject2 = new JSONObject(strOptString);
                        }
                        if (!C2318f4.f8523d.equals(str3)) {
                            jSONObject2.put(C2300e4.h.G, DeviceUtils.Bc(com.bytedance.sdk.openadsdk.core.cl.IlO()).toString());
                        }
                        if (C2318f4.f8523d.equals(str3)) {
                            if (z2) {
                                jSONObject2.put("click_scence", 1);
                            } else if (OOq.MY(oet)) {
                                jSONObject2.put("click_scence", 3);
                            }
                        }
                        if (oet.nt()) {
                            try {
                                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("pag_json_data");
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                jSONObjectOptJSONObject.put("is_new_playable", 1);
                                if (oet.jm()) {
                                    jSONObjectOptJSONObject.put("is_pre_render", 1);
                                }
                                jSONObject2.put("pag_json_data", jSONObjectOptJSONObject.toString());
                            } catch (Throwable unused) {
                            }
                        }
                        if (com.bytedance.sdk.openadsdk.hp.IlO.EO(oet)) {
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("pag_json_data");
                            if (jSONObjectOptJSONObject2 == null) {
                                jSONObjectOptJSONObject2 = new JSONObject();
                            }
                            jSONObjectOptJSONObject2.put("is_lp_pre_render", oet.CuC() ? 1 : 0);
                            jSONObject2.put("pag_json_data", jSONObjectOptJSONObject2.toString());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("tag", str2);
                        int iOptInt = jSONObject2.optInt("agg_request_type", -1);
                        if (z2 && iOptInt == 2) {
                            strPTq = jSONObject2.optString("app_log_url");
                        }
                        int i2 = 0;
                        if (C2318f4.f8523d.equals(str3)) {
                            kBB.EO(oet);
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - oeT.MY(jSONObject.optString("log_extra"))).floatValue();
                            JSONObject jSONObject3 = jSONObject;
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject3.putOpt("show_time", Float.valueOf(fFloatValue));
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.rp.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()))) {
                                if (z2 && iOptInt == 2) {
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("click_tracking_url");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        ArrayList arrayList = new ArrayList();
                                        while (i2 < jSONArrayOptJSONArray2.length()) {
                                            arrayList.add(jSONArrayOptJSONArray2.optString(i2));
                                            i2++;
                                        }
                                        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(arrayList, true), 2, String.valueOf(j));
                                    }
                                } else {
                                    oeT oet2 = oet;
                                    if (oet2 != null) {
                                        com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(oet2.ts(), true), 2, oet.ED());
                                    }
                                }
                            }
                        } else if (C2461n2.f9471v.equals(str3) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.rp.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO())) && z2 && iOptInt == 2 && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("show_tracking_url")) != null) {
                            ArrayList arrayList2 = new ArrayList();
                            while (i2 < jSONArrayOptJSONArray.length()) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i2));
                                i2++;
                            }
                            com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO(com.bytedance.sdk.openadsdk.kBB.IlO.IlO(arrayList2, true), 1, String.valueOf(j));
                        }
                    } catch (Exception unused2) {
                    }
                }
                new IlO.C0117IlO(jCurrentTimeMillis, oet).tV(str).MY(str2).EO(str3).Cc(String.valueOf(j)).vCE(String.valueOf(j3)).IlO(strPTq).IlO(jSONObject).lEW(oet.Jm()).Bc(oet.JAC()).IlO((com.bytedance.sdk.openadsdk.tV.MY.IlO) null);
            }
        });
    }

    public static void IlO(oeT oet, String str, final long j, final JSONObject jSONObject) {
        IlO(System.currentTimeMillis(), oet, "open_ad", str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.41
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    long j3 = j;
                    if (j3 != -1) {
                        jSONObject2.put("duration", j3);
                    }
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                        return jSONObject2;
                    }
                    jSONObject2.put("ad_extra_data", new JSONObject().toString());
                    return jSONObject2;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", e.getMessage());
                    return jSONObject2;
                }
            }
        });
    }

    public static void IlO(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lew == null) {
            return;
        }
        if (mmj.vCE()) {
            com.bytedance.sdk.component.utils.DmF.IlO().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.EO.42
                @Override // java.lang.Runnable
                public void run() {
                    mmj.MY(lew, 10);
                }
            });
        } else if (!mmj.Bc()) {
            mmj.MY(lew, 10);
        } else {
            lew.run();
        }
    }

    public static void IlO(final com.bytedance.sdk.openadsdk.ea.IlO.MY my) {
        if (my == null || my.MY() == null) {
            return;
        }
        final oeT oetMY = my.MY();
        final int iJz = oetMY.Jz();
        if (iJz == 2 || iJz == 8 || (zLG.tV(oetMY) && MY.IlO.tV.equals(my.IlO()))) {
            IlO(System.currentTimeMillis(), oetMY, my.EO(), "open_browser", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.43
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iTV = my.tV();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(NewHtcHomeBadger.COUNT, zLG.bWL(com.bytedance.sdk.openadsdk.core.cl.IlO()));
                        jSONObject2.put("interceptor", iTV);
                        jSONObject2.put("success", my.Cc());
                        jSONObject2.put("link", my.IlO());
                        jSONObject2.put("interaction_type", iJz);
                        jSONObject2.put("real_interaction_type", my.Bc());
                        if (my.tV() == 9) {
                            jSONObject2.put("is_act_signals_api_available", my.lEW());
                            jSONObject2.put("is_act_signals_callback", my.DmF());
                        }
                        if (!TextUtils.isEmpty(my.vCE())) {
                            jSONObject2.put("exception_msg", my.vCE());
                        }
                        if (iTV == 2 || iTV == 5) {
                            jSONObject2.put("meta", oetMY.eDn().toString());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", e.getMessage());
                        return jSONObject;
                    }
                }
            });
        }
    }

    public static void IlO(JSONObject jSONObject, int i2, int i8) {
        try {
            jSONObject.put("skip_show_time", i2);
            jSONObject.put("skip_time", i8);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("skip_after_time", i8 - (i2 * 1000));
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    public static void IlO(oeT oet, String str, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i2);
        } catch (JSONException unused) {
        }
        MY(oet, str, "open_ad_land_page_links", jSONObject);
    }

    public static void IlO(oeT oet, String str, final boolean z2, final boolean z7, final boolean z8, final boolean z9, final int i2, final Map<String, Object> map) {
        IlO(System.currentTimeMillis(), oet, str, "start_show_plb", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.45
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isSkip", z2);
                    jSONObject2.put("force", z7);
                    jSONObject2.put("isFromLandingPage", z8);
                    jSONObject2.put("finishing", z9);
                    jSONObject2.put("from", i2);
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void IlO(final oeT oet, final boolean z2, String str, final String str2, final long j, final String str3, final String str4, final int i2, final String str5) {
        IlO(System.currentTimeMillis(), oet, str, "load_ugen_template", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EO.46
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                oeT.IlO ilOUvo;
                dY dYVarEa;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String str6 = str4;
                    int iHashCode = str6.hashCode();
                    if (iHashCode != -1606803861) {
                        if (iHashCode != 3107) {
                            if (iHashCode == 2989536 && str6.equals("adv3") && (dYVarEa = oet.Ea()) != null) {
                                jSONObject2.putOpt("url", dYVarEa.EO());
                                jSONObject2.putOpt("id", dYVarEa.IlO());
                                jSONObject2.putOpt("md5", dYVarEa.MY());
                            }
                        } else if (str6.equals("ad") && (ilOUvo = oet.uvo()) != null) {
                            jSONObject2.putOpt("url", ilOUvo.ea());
                            jSONObject2.putOpt("id", ilOUvo.vCE());
                            jSONObject2.putOpt("md5", ilOUvo.zPa());
                        }
                    } else if (str6.equals("endcard")) {
                        if (z2) {
                            com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilOXqE = oet.xqE();
                            if (ilOXqE != null) {
                                jSONObject2.putOpt("url", ilOXqE.EO());
                                jSONObject2.putOpt("id", ilOXqE.IlO());
                                jSONObject2.putOpt("md5", ilOXqE.MY());
                            }
                        } else {
                            com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilOQtY = oet.QtY();
                            if (ilOQtY != null) {
                                jSONObject2.putOpt("url", ilOQtY.EO());
                                jSONObject2.putOpt("id", ilOQtY.IlO());
                                jSONObject2.putOpt("md5", ilOQtY.MY());
                            }
                        }
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put("from", str3);
                    jSONObject2.put("ugen_scene", str4);
                    if (C2300e4.f.e.equals(str2)) {
                        jSONObject2.put("error_code", i2);
                        jSONObject2.put("error_msg", str5);
                    }
                    jSONObject.put("duration", j);
                } catch (Throwable th) {
                    try {
                        jSONObject2.put("error_code", Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE);
                        jSONObject2.put("error_msg", "send template error " + th.getMessage());
                    } catch (Throwable unused) {
                    }
                }
                try {
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused2) {
                }
                return jSONObject;
            }
        });
    }

    private static boolean IlO(int i2, String str) {
        int iWPn;
        try {
            Set<String> setEeU = com.bytedance.sdk.openadsdk.core.settings.hp.aP().eeU();
            if ((i2 == 1 && setEeU != null && setEeU.contains(str)) || (iWPn = com.bytedance.sdk.openadsdk.core.settings.hp.aP().wPn(str)) == 0) {
                return true;
            }
            if (iWPn != 100) {
                if (((int) ((Math.random() * 100.0d) + 1.0d)) > iWPn) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdEvent", th.getMessage());
            return false;
        }
    }

    public static void IlO(int i2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_show_order", i2);
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }
}
