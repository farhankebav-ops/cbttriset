package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.oc;
import com.bytedance.sdk.openadsdk.utils.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends com.bytedance.sdk.component.lEW.lEW {
    private final Set<Cc> EO;
    private final IlO IlO;
    private final NV MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(boolean z2);
    }

    public EV(IlO ilO, NV nv, Cc... ccArr) {
        super("SetF");
        HashSet hashSet = new HashSet();
        this.EO = hashSet;
        this.IlO = ilO;
        this.MY = nv;
        hashSet.addAll(Arrays.asList(ccArr));
    }

    private JSONObject MY(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d("TTAD.SdkSettingsFetch", "Start Try");
        int iIlO = wPn.IlO(cl.IlO(), 0L);
        if (iIlO == 0) {
            Log.d("TTAD.SdkSettingsFetch", "No net");
            this.IlO.IlO(false);
            return;
        }
        JSONObject jSONObjectIlO = IlO(iIlO);
        com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
        try {
            tVVarMY.MY(com.bytedance.sdk.openadsdk.lEW.tV.IlO(tVVarMY, zLG.IlO("/api/ad/union/sdk/settings/", false, true)));
            tVVarMY.MY("User-Agent", zLG.EO());
        } catch (Exception unused) {
        }
        String string = MY(jSONObjectIlO).toString();
        if (cl.tV().quf() && com.bytedance.sdk.openadsdk.core.wPn.IlO().tV() == 1) {
            zLG.IlO("Pangle_Debug_Mode", string, cl.IlO());
        }
        tVVarMY.IlO(string, cl.tV().zPa());
        tVVarMY.IlO(6);
        tVVarMY.IlO("setting");
        com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.settings.EV.1
            @Override // com.bytedance.sdk.openadsdk.cl.tV
            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                return a.d("settings_fetch");
            }
        });
        tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.settings.EV.2
            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                JSONObject jSONObject;
                int iOptInt;
                int iIlO2 = my.IlO();
                String strTV = my.tV();
                if (cl.tV().quf() && com.bytedance.sdk.openadsdk.core.wPn.IlO().tV() == 1) {
                    zLG.IlO("Pangle_Debug_Mode", strTV, cl.IlO());
                }
                if (!my.vCE() || TextUtils.isEmpty(strTV)) {
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.settings.EV.2.2
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return a.d("settings_fetch");
                        }
                    });
                    if (eo != null) {
                        oeT.IlO(eo.tV());
                    }
                } else {
                    String strEO = null;
                    try {
                        jSONObject = new JSONObject(strTV);
                    } catch (JSONException unused2) {
                        jSONObject = null;
                    }
                    if (jSONObject != null && (iOptInt = jSONObject.optInt("cypher", -1)) != -1) {
                        if (iOptInt == 3) {
                            strEO = com.bytedance.sdk.component.utils.IlO.EO(jSONObject.optString("message"));
                            if (!TextUtils.isEmpty(strEO)) {
                                try {
                                    jSONObject = new JSONObject(strEO);
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                        try {
                            EV.this.IlO(strEO, my.EO());
                        } catch (Throwable unused4) {
                        }
                        try {
                            EV.this.IlO(jSONObject);
                            cl.tV().IlO(System.currentTimeMillis());
                            com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.settings.EV.2.1
                                @Override // com.bytedance.sdk.openadsdk.cl.tV
                                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                    return a.d("settings_fetch");
                                }
                            });
                            oeT.MY();
                        } catch (Throwable unused5) {
                        }
                        EV.this.IlO.IlO(true);
                        return;
                    }
                }
                if (!my.vCE()) {
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("settings_fetch", eo.tV(), iIlO2, my.MY());
                }
                EV.this.IlO.IlO(false);
            }

            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                EV.this.IlO.IlO(false);
                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.settings.EV.2.3
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        return a.d("settings_fetch");
                    }
                });
                if (eo != null) {
                    oeT.IlO(eo.tV());
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("settings_fetch", eo.tV(), -1, iOException != null ? iOException.getMessage() : null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.EV.MY(com.bytedance.sdk.openadsdk.core.rp.IlO(cl.IlO()));
        DeviceUtils.EV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, Map<String, String> map) {
        int i2 = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap map2 = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        map2.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                int i8 = Integer.parseInt((String) map2.get("active-control"));
                long j = Long.parseLong((String) map2.get("ts"));
                String str2 = (String) map2.get("pst");
                String strA = s.a.a(str + i8 + j);
                if (strA != null) {
                    if (strA.equalsIgnoreCase(str2)) {
                        i2 = i8;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        DmF.IlO(i2);
    }

    public static JSONObject IlO(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            vCE vceTV = cl.tV();
            jSONObject.put(Q6.B, Build.MODEL);
            jSONObject.put("device_city", zLG.cL());
            com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(jSONObject);
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.DmF.MY().NV());
            jSONObject.put("pa_consent", com.bytedance.sdk.openadsdk.core.DmF.MY().EV());
            if (vceTV.OOq("mcc")) {
                jSONObject.put("mcc", oc.MY());
            }
            Context contextIlO = cl.IlO();
            jSONObject.put("conn_type", zLG.Bc(i2));
            jSONObject.put(Q6.F, 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("aos_api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.rp.MY());
            jSONObject.put("time_zone", zLG.AXM());
            jSONObject.put(C2300e4.h.V, zLG.Cc());
            jSONObject.put(C2300e4.h.L, zLG.IlO() ? 1 : 2);
            jSONObject.put("app_version", zLG.Bc());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.rp.EO(contextIlO));
            String strTV = com.bytedance.sdk.openadsdk.core.DmF.MY().tV();
            if (strTV != null) {
                jSONObject.put("app_id", strTV);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (strTV != null) {
                strConcat = strTV.concat(String.valueOf(jCurrentTimeMillis)).concat(BuildConfig.VERSION_NAME);
            }
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.Cc.IlO(strConcat));
            jSONObject.put("tcstring", hp.EO(contextIlO));
            jSONObject.put("tcf_gdpr", hp.MY(contextIlO));
            jSONObject.put("lmt", DeviceUtils.EO());
            jSONObject.put("locale_language", DeviceUtils.tV());
            jSONObject.put("channel", C2300e4.h.Z);
            JSONObject jSONObjectCc = vceTV.Cc();
            if (jSONObjectCc != null) {
                jSONObject.put("digest", jSONObjectCc);
            }
            jSONObject.put("data_time", vceTV.vCE());
            jSONObject.put("app_set_id_scope", tV.MY());
            jSONObject.put("app_set_id", tV.EO());
            jSONObject.put("installed_source", tV.tV());
            if (vceTV.OOq(Q6.U0)) {
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.rp.IlO(cl.IlO()));
            }
            jSONObject.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            String strBc = com.bytedance.sdk.openadsdk.core.DmF.MY().Bc();
            if (!TextUtils.isEmpty(strBc)) {
                jSONObject.put("mediation", strBc);
            }
            jSONObject.put(C2300e4.h.G, DeviceUtils.IlO(contextIlO, true));
            jSONObject.put("adx_id", com.bytedance.sdk.openadsdk.core.DmF.MY().tl());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public boolean IlO(@NonNull JSONObject jSONObject) {
        this.MY.IlO(jSONObject);
        for (Cc cc : this.EO) {
            if (cc != null) {
                cc.IlO(jSONObject);
            }
        }
        return this.MY.EO;
    }

    public static boolean IlO() {
        return BinderPoolService.IlO;
    }
}
