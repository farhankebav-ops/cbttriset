package com.bytedance.sdk.openadsdk;

import a1.a;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.CustomRequestHeader;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.core.settings.vCE;
import com.bytedance.sdk.openadsdk.multipro.tV.tV;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.C2605va;
import com.ironsource.Q6;
import com.ironsource.Y1;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ApmHelper {
    private static IlO Bc = null;
    private static String EO = null;
    private static volatile boolean IlO = false;
    private static boolean tV;
    private static MY vCE;
    private static final AtomicBoolean MY = new AtomicBoolean(false);
    private static boolean Cc = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public final Throwable EO;
        public final String IlO;
        public final String MY;

        public IlO(String str, String str2, Throwable th) {
            this.IlO = str;
            this.MY = str2;
            this.EO = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO(String str, String str2, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> DmF() {
        HashMap map = new HashMap();
        oeT oetIlO = com.bytedance.sdk.openadsdk.utils.MY.IlO();
        if (oetIlO != null) {
            map.put("adType", String.valueOf(oetIlO.fHv()));
            map.put(C2605va.f10440b, String.valueOf(oetIlO.jk()));
            map.put("cid", oetIlO.ED());
            map.put("reqId", oetIlO.JAC());
            map.put("rit", oetIlO.pP(Y1.f7808f));
            int iNvX = oetIlO.nvX();
            if (oetIlO.oc() != 2) {
                iNvX = -1;
            }
            map.put("render_type", String.valueOf(iNvX));
        }
        return map;
    }

    @NonNull
    public static Pair<String, String> generateRequestHeader() {
        String string = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            jSONObject.put("ipv6", tV.MY("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, ""));
            jSONObject.put("region", cl.tV().mmj());
        } catch (JSONException unused) {
        }
        JSONObject jSONObjectEncryptType4WithNoWrapBase64 = PangleEncryptManager.encryptType4WithNoWrapBase64(jSONObject, new com.bytedance.sdk.openadsdk.core.oeT(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        String str = "0";
        if (jSONObjectEncryptType4WithNoWrapBase64 != null) {
            int iOptInt = jSONObjectEncryptType4WithNoWrapBase64.optInt("cypher");
            if (iOptInt == 4) {
                string = jSONObjectEncryptType4WithNoWrapBase64.optString("message");
                str = "4";
            } else if (iOptInt == 3) {
                string = jSONObjectEncryptType4WithNoWrapBase64.optString("message");
                str = ExifInterface.GPS_MEASUREMENT_3D;
            } else {
                string = jSONObject.toString();
            }
        }
        return new Pair<>(str, string);
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        if (MY.compareAndSet(false, true) && !IlO) {
            mmj.IlO(new lEW("init-apm") { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ApmHelper.IlO) {
                        vCE vceTV = cl.tV();
                        boolean unused = ApmHelper.tV = vceTV.gQ();
                        String strHp = zLG.hp();
                        if (ApmHelper.tV && !TextUtils.isEmpty(strHp)) {
                            String unused2 = ApmHelper.EO = initConfig.getAppId();
                            String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk", "com.bykv.vk", "com.iab.omid.library.bytedance2", "com.bytedance.adsdk"};
                            String strIlO = rp.IlO(context);
                            try {
                                Npth.setCrashWaitTime(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("apm_crash_wait_time", 10000));
                                Npth.enableLoopMonitor(false);
                                Npth.enableAnrInfo(false);
                                Npth.enableNativeDump(false);
                                Npth.enableActivityDump(false);
                                Npth.enableMessageDump(false);
                                MonitorCrash.setCustomRequestHeaderCallback(new CustomRequestHeader() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.1
                                    @Override // com.apm.insight.CustomRequestHeader
                                    public void addRequestHeader(HttpURLConnection httpURLConnection) {
                                        Pair<String, String> pairGenerateRequestHeader = ApmHelper.generateRequestHeader();
                                        httpURLConnection.setRequestProperty("cypher", (String) pairGenerateRequestHeader.first);
                                        httpURLConnection.setRequestProperty("transfer-param", (String) pairGenerateRequestHeader.second);
                                        httpURLConnection.setRequestProperty("x-pangle-target-idc", cl.tV().eDn());
                                    }
                                });
                                final MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(context, "10000001", 7206L, BuildConfig.VERSION_NAME, strArr);
                                monitorCrashInitSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.2
                                    @Override // com.apm.insight.AttachUserData
                                    @Nullable
                                    public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                        Map<? extends String, ? extends String> mapDmF = ApmHelper.DmF();
                                        if (mapDmF.containsKey("render_type")) {
                                            monitorCrashInitSDK.addTags("render_type", mapDmF.get("render_type"));
                                            return mapDmF;
                                        }
                                        monitorCrashInitSDK.addTags("render_type", "-2");
                                        return mapDmF;
                                    }
                                });
                                if (vceTV.HTA()) {
                                    monitorCrashInitSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so", "tt_ugen_layout.so"});
                                }
                                monitorCrashInitSDK.config().setDeviceId(strIlO);
                                monitorCrashInitSDK.setReportUrl(strHp);
                                monitorCrashInitSDK.addTags("host_appid", ApmHelper.EO);
                                monitorCrashInitSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                                MY unused3 = ApmHelper.vCE = new MY() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.3
                                    @Override // com.bytedance.sdk.openadsdk.ApmHelper.MY
                                    public void IlO(String str, String str2, Throwable th) {
                                        monitorCrashInitSDK.reportCustomErr(str, str2, th);
                                    }
                                };
                                boolean unused4 = ApmHelper.IlO = true;
                                ApmHelper.EO(strIlO, strHp);
                                monitorCrashInitSDK.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.4
                                    @Override // com.apm.insight.ICrashCallback
                                    public void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
                                        if (!ApmHelper.Cc) {
                                            ApmHelper.tV(crashType.getName());
                                        }
                                        boolean unused5 = ApmHelper.Cc = true;
                                    }
                                }, CrashType.ALL);
                                IlO ilO = ApmHelper.Bc;
                                IlO unused5 = ApmHelper.Bc = null;
                                if (ilO != null) {
                                    ApmHelper.vCE.IlO(ilO.IlO, ilO.MY, ilO.EO);
                                }
                            } catch (Throwable unused6) {
                                boolean unused7 = ApmHelper.IlO = false;
                            }
                        }
                    }
                    ApmHelper.MY.set(false);
                }
            });
        }
    }

    public static boolean isIsInit() {
        return IlO;
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        MY my = vCE;
        if (my != null) {
            my.IlO(str, str2, th);
        } else {
            Bc = new IlO(str, str2, th);
        }
    }

    public static void reportPvFromBackGround() {
        if (tV) {
            MY(rp.IlO(cl.IlO()), zLG.hp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tV(final String str) {
        final oeT oetIlO = com.bytedance.sdk.openadsdk.utils.MY.IlO();
        if (oetIlO != null) {
            String strIlO = zLG.IlO(oetIlO);
            if (TextUtils.isEmpty(strIlO)) {
                return;
            }
            EO.IlO(System.currentTimeMillis(), oetIlO, strIlO, "sdk_crash_info", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.2
                @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                public JSONObject IlO() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", str);
                        jSONObject2.put("material", com.bytedance.sdk.component.utils.IlO.IlO(oetIlO.eDn()).toString());
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (JSONException unused) {
                    }
                    return jSONObject;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO(String str, String str2) {
        MY(str, str2);
    }

    private static JSONObject EO(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", EO);
            jSONObject2.putOpt(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, jSONObject3);
            jSONObject2.put(Q6.F, C2300e4.f8279d);
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put(C2605va.f10440b, "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("apm_id", "20000001");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("ApmHelper", e.getMessage());
            return jSONObject;
        }
    }

    private static void MY(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String strM = a.m("https://", str2, "/monitor/collect/c/session?version_code=7206&device_platform=android&aid=10000001");
        cl.EO().IlO(EO(str), strM);
    }
}
