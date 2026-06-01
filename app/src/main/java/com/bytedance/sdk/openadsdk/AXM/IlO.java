package com.bytedance.sdk.openadsdk.AXM;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.lEW;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.DmF.MY;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.oeT;
import com.bytedance.sdk.openadsdk.core.settings.EV;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.oeT.EO;
import com.bytedance.sdk.openadsdk.oeT.tV;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile EO EO;
    public static final ConcurrentHashMap<String, Object> IlO = new ConcurrentHashMap<>();
    public static String MY;

    private static EO Bc() {
        return IlO(cl.IlO(), DmF.MY().tV());
    }

    public static int Cc() {
        if (MY()) {
            return IlO("ad_load_and_render_opt", "webview_preload_cache", 0);
        }
        return 0;
    }

    public static boolean EO() {
        return MY() && IlO("ad_load_and_render_opt", "thread_switch_opt", 0) == 1;
    }

    public static EO IlO(final Context context, final String str) {
        if (EO == null) {
            synchronized (IlO.class) {
                try {
                    if (EO == null) {
                        try {
                            EO eo = new EO(new tV() { // from class: com.bytedance.sdk.openadsdk.AXM.IlO.1
                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public Map<String, String> Bc() {
                                    HashMap map = new HashMap();
                                    map.put("User-Agent", zLG.EO());
                                    String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
                                    if (!strMY.isEmpty()) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("ipv6", strMY);
                                        } catch (JSONException unused) {
                                        }
                                        JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject, new oeT(PangleEncryptConstant.CryptDataScene.UNKNOWN));
                                        if (jSONObjectEncryptType4 != null) {
                                            map.put("transfer-param", jSONObjectEncryptType4.optString("message"));
                                            if (jSONObjectEncryptType4.optInt("cypher") == 4) {
                                                map.put("cypher", "4");
                                            } else {
                                                map.put("cypher", ExifInterface.GPS_MEASUREMENT_3D);
                                            }
                                        }
                                    }
                                    try {
                                        map.put("x-pangle-target-idc", hp.aP().eDn());
                                    } catch (Throwable unused2) {
                                    }
                                    return map;
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public String Cc() {
                                    String strIlO = zLG.IlO("/api/ad/union/sdk/strategies/adn", false, true);
                                    IlO.MY = strIlO;
                                    return strIlO;
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public String EO() {
                                    return "pag_adn_strategy_center";
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public ExecutorService IlO() {
                                    return mmj.Cc();
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public Context MY() {
                                    Context context2 = context;
                                    return context2 != null ? context2 : cl.IlO();
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public Handler tV() {
                                    return bWL.MY();
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public JSONObject vCE() {
                                    try {
                                        JSONObject jSONObjectIlO = EV.IlO(wPn.IlO(cl.IlO(), 0L));
                                        if (!jSONObjectIlO.has("app_id")) {
                                            if (!TextUtils.isEmpty(str)) {
                                                jSONObjectIlO.put("app_id", str);
                                            } else {
                                                if (TextUtils.isEmpty(DmF.MY().tV())) {
                                                    return null;
                                                }
                                                jSONObjectIlO.put("app_id", DmF.MY().tV());
                                            }
                                        }
                                        return com.bytedance.sdk.component.utils.IlO.IlO(jSONObjectIlO);
                                    } catch (Throwable th) {
                                        com.bytedance.sdk.component.utils.oeT.EO("StrategyUtils", th.getMessage());
                                        return null;
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public JSONObject IlO(JSONObject jSONObject) {
                                    int iOptInt = jSONObject.optInt("cypher", -1);
                                    if (iOptInt != -1 && iOptInt == 3) {
                                        String strEO = com.bytedance.sdk.component.utils.IlO.EO(jSONObject.optString("message"));
                                        if (!TextUtils.isEmpty(strEO)) {
                                            try {
                                                return new JSONObject(strEO);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    }
                                    return jSONObject;
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.tV
                                public HandlerThread IlO(String str2, int i2) {
                                    return lEW.IlO(str2, i2);
                                }
                            });
                            EO = eo;
                            eo.IlO(new com.bytedance.sdk.openadsdk.oeT.IlO() { // from class: com.bytedance.sdk.openadsdk.AXM.IlO.2
                                @Override // com.bytedance.sdk.openadsdk.oeT.IlO
                                public void IlO() {
                                    com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.AXM.IlO.2.1
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("strategy_fetch");
                                        }
                                    });
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.IlO
                                public void MY() {
                                    com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.AXM.IlO.2.2
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("strategy_fetch");
                                        }
                                    });
                                    com.bytedance.sdk.openadsdk.vCE.IlO.IlO().MY();
                                    com.bytedance.sdk.openadsdk.xF.IlO.EO.IlO().MY();
                                    com.bytedance.sdk.openadsdk.utils.oeT.MY();
                                    HashMap map = new HashMap();
                                    String strIlO = IlO.IlO(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
                                    if (!TextUtils.isEmpty(strIlO)) {
                                        map.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, strIlO);
                                    }
                                    MY.MY().IlO(map);
                                }

                                @Override // com.bytedance.sdk.openadsdk.oeT.IlO
                                public void IlO(int i2, String str2) {
                                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.AXM.IlO.2.3
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("strategy_fetch");
                                        }
                                    });
                                    com.bytedance.sdk.openadsdk.utils.oeT.IlO(IlO.MY);
                                }
                            });
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return EO;
    }

    public static boolean MY() {
        return IlO("ad_load_and_render_opt", com.ironsource.mediationsdk.metadata.a.j, 0) == 1;
    }

    public static boolean tV() {
        return MY() && IlO("ad_load_and_render_opt", "sync_barrier_switch_opt", 0) == 1;
    }

    public static int vCE() {
        if (MY()) {
            return IlO("ad_load_and_render_opt", "webview_preload_cache_v3", 0);
        }
        return 0;
    }

    public static int IlO(String str, int i2) {
        EO eoBc = Bc();
        return eoBc != null ? eoBc.IlO(str, i2) : i2;
    }

    public static boolean IlO(String str, boolean z2) {
        EO eoBc = Bc();
        return eoBc != null ? eoBc.IlO(str, z2) : z2;
    }

    public static String IlO(String str, String str2) {
        EO eoBc = Bc();
        return eoBc != null ? eoBc.IlO(str, str2) : str2;
    }

    public static int IlO(String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String strD = a1.a.D(str, "_", str2);
            ConcurrentHashMap<String, Object> concurrentHashMap = IlO;
            Object obj = concurrentHashMap.get(strD);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            try {
                String strIlO = Bc().IlO(str, "");
                if (!TextUtils.isEmpty(strIlO)) {
                    int iOptInt = new JSONObject(strIlO).optInt(str2, i2);
                    concurrentHashMap.put(strD, Integer.valueOf(iOptInt));
                    return iOptInt;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("StrategyUtils", th.getMessage());
            }
        }
        return i2;
    }

    public static String IlO(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String strD = a1.a.D(str, "_", str2);
            ConcurrentHashMap<String, Object> concurrentHashMap = IlO;
            Object obj = concurrentHashMap.get(strD);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
            try {
                String strIlO = Bc().IlO(str, "");
                if (!TextUtils.isEmpty(strIlO)) {
                    String strOptString = new JSONObject(strIlO).optString(str2, str3);
                    concurrentHashMap.put(strD, strOptString);
                    return strOptString;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("StrategyUtils", th.getMessage());
            }
        }
        return str3;
    }

    public static void IlO() {
        EO eoBc = Bc();
        if (eoBc != null) {
            eoBc.IlO();
        }
    }
}
