package com.bytedance.sdk.openadsdk.ea;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import com.mimikridev.ads.util.Constant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static volatile EO IlO;

    private EO() {
    }

    private boolean EO(tV tVVar) {
        return tVVar == null;
    }

    public static EO IlO() {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = new EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public static void MY(final oeT oet) {
        if (zLG.IlO(oet) == null || TextUtils.isEmpty(oet.tU())) {
            return;
        }
        IlO("download_gecko_start", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.19
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", oet.pFe());
                jSONObject.put("channel_name", oet.tU());
                return tV.MY().IlO("download_gecko_start").IlO(oet.fHv()).MY(jSONObject.toString());
            }
        });
    }

    public static void tV() {
        IlO("disk_log", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.11
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long jIlO = EO.IlO(file2);
                        j += jIlO;
                        jSONObject.put(file2.getName(), jIlO);
                    }
                }
                if (j < 524288000) {
                    return null;
                }
                return tV.MY().IlO("disk_log").MY(jSONObject.toString());
            }
        });
    }

    public void EO() {
        IlO("blind_mode_status", true, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.9
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return tV.MY().IlO("blind_mode_status");
            }
        });
    }

    public static void EO(final String str, final String str2) {
        IlO("playable_url_mime", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.16
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    String str3 = str;
                    Object obj = "not validate";
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "not validate";
                    }
                    jSONObject.put("original_mime", str3);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str2));
                    if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                        obj = mimeTypeFromExtension;
                    }
                    jSONObject.put("new_mime", obj);
                    jSONObject.put("url", str2);
                    jSONObject.put("is_same", str3.equals(obj) ? 1 : 0);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("playable_url_mime").MY(jSONObject.toString());
            }
        });
    }

    public void MY(final tV tVVar) {
        if (EO(tVVar)) {
            return;
        }
        tVVar.IlO("show_backup_endcard");
        cl.Cc().IlO(new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.22
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return tVVar;
            }
        });
    }

    public static void IlO(final oeT oet) {
        if (oet == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        IlO("bidding_receive", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reveice_ts", jCurrentTimeMillis);
                if (oet.fHv() == 3) {
                    jSONObject.put("is_icon_only", oet.mV() ? 1 : 0);
                }
                return tV.MY().IlO("bidding_receive").MY(jSONObject.toString());
            }
        });
    }

    public void MY(final String str) {
        IlO("close_playable_test_tool", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.3
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("close_playable_test_tool").MY(jSONObject.toString());
            }
        });
    }

    public static void MY() {
        mmj.EO(new lEW("showFailLog") { // from class: com.bytedance.sdk.openadsdk.ea.EO.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EO.IlO().IlO("show_fail_log", new JSONObject());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("StatsLogManager", th.getMessage());
                }
            }
        });
    }

    public static void IlO(oeT oet, final long j) {
        if (oet == null) {
            return;
        }
        IlO("bidding_load", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.12
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j);
                return tV.MY().IlO("bidding_load").MY(jSONObject.toString());
            }
        });
    }

    public static void MY(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                final tV tVVarMY = tV.MY().IlO(str).MY(str2);
                cl.Cc().IlO(new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.13
                    @Override // com.bytedance.sdk.openadsdk.ea.MY
                    public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                        return tVVarMY;
                    }
                }, false);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("StatsLogManager", th.getMessage());
        }
    }

    public static void IlO(final String str, final com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO) {
        if (ilO == null) {
            return;
        }
        IlO(str, false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.18
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObjectEO = ilO.EO();
                if (jSONObjectEO == null) {
                    jSONObjectEO = new JSONObject();
                }
                com.bytedance.sdk.openadsdk.tV.Cc.MY.EO eoTV = ilO.tV();
                if (eoTV != null) {
                    eoTV.IlO(jSONObjectEO);
                }
                return tV.MY().IlO(str).IlO(ilO.IlO().fHv()).MY(jSONObjectEO.toString());
            }
        });
    }

    public static void IlO(final oeT oet, final JSONObject jSONObject) {
        if (zLG.IlO(oet) == null || TextUtils.isEmpty(oet.tU())) {
            return;
        }
        IlO("download_gecko_end", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.20
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", oet.pFe());
                jSONObject2.put("channel_name", oet.tU());
                jSONObject2.put("data", jSONObject);
                return tV.MY().IlO("download_gecko_end").IlO(oet.fHv()).MY(jSONObject2.toString());
            }
        });
    }

    public void IlO(final tV tVVar) {
        if (EO(tVVar)) {
            return;
        }
        tVVar.IlO("express_ad_render");
        cl.Cc().IlO(new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.21
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return tVVar;
            }
        });
    }

    public void IlO(final String str) {
        IlO("click_playable_test_tool", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.2
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("click_playable_test_tool").MY(jSONObject.toString());
            }
        });
    }

    public void IlO(final String str, final int i2, final String str2) {
        IlO("use_playable_test_tool_error", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.4
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put("error_code", i2);
                    jSONObject.put("error_message", str2);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("use_playable_test_tool_error").MY(jSONObject.toString());
            }
        });
    }

    public void IlO(final long j, final long j3) {
        final long j8 = j3 - j;
        IlO("general_label", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.5
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                int i2 = !bWL.MY.get() ? 1 : 0;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j);
                    jSONObject.put("endtime", j3);
                    jSONObject.put("start_type", i2);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("general_label").lEW(String.valueOf(j8)).MY(jSONObject.toString());
            }
        });
    }

    public void IlO(final String str, final JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        IlO(str, false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.7
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return tV.MY().IlO(str).MY(jSONObject.toString());
            }
        });
    }

    public void IlO(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IlO(str, false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.8
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                return tV.MY().IlO(str).MY(str2);
            }
        });
    }

    public void IlO(final JSONObject jSONObject) {
        if (jSONObject == null) {
            com.bytedance.sdk.component.utils.oeT.IlO("adRevenuePangle", "You must pass adRevenue json to pangle");
            return;
        }
        Object objOpt = jSONObject.opt("device_ad_mediation_platform");
        if (!(objOpt instanceof String) || TextUtils.isEmpty((String) objOpt)) {
            com.bytedance.sdk.component.utils.oeT.IlO("adRevenuePangle", "You must pass device_ad_mediation_platform to pangle");
        } else {
            com.bytedance.sdk.component.utils.oeT.IlO("adRevenuePangle", Constant.PANGLE, "You successfully passed the parameters to pangle. The parameters are:", jSONObject);
            IlO("ad_revenue", true, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.10
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_EVENT, 272);
                        jSONObject.put("uuid", rp.EO(cl.IlO()));
                        String strIlO = "";
                        try {
                            if (rp.IlO(cl.IlO()) != null) {
                                strIlO = rp.IlO(cl.IlO());
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                        jSONObject.put("device_id", strIlO);
                        jSONObject.put(Q6.H, "android");
                        jSONObject.put("partner", "PangleSDK");
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                    return tV.MY().IlO("ad_revenue").MY(jSONObject.toString());
                }
            });
        }
    }

    public static long IlO(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long jIlO = 0;
        for (File file2 : file.listFiles()) {
            jIlO += IlO(file2);
        }
        return jIlO;
    }

    public static void IlO(String str, boolean z2, MY my) {
        IlO(str, z2, 100, my);
    }

    public static void IlO(String str, boolean z2, int i2, MY my) {
        int iIlO = hp.aP().IlO(str, i2);
        if (TextUtils.isEmpty(str) || iIlO == 0 || my == null) {
            return;
        }
        boolean z7 = iIlO == 100;
        if (!z7) {
            z7 = ((int) ((Math.random() * 100.0d) + 1.0d)) <= iIlO;
        }
        if (z7) {
            cl.Cc().IlO(my, z2);
        }
    }

    public static void IlO(long j, long j3, final String str, final int i2) {
        if (j == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long j8 = jElapsedRealtime - j;
        final long j9 = jElapsedRealtime - j3;
        final long j10 = j3 - j;
        IlO("ad_show_cost_time", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.14
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j8);
                jSONObject.put("renderDuration", j9);
                jSONObject.put("showToRenderDuration", j10);
                jSONObject.put("tag", str);
                jSONObject.put("renderType", i2);
                return tV.MY().IlO("ad_show_cost_time").MY(jSONObject.toString());
            }
        });
    }

    public static void IlO(int i2, String str) {
        IlO(i2, str, 0, (String) null);
    }

    public static void IlO(final int i2, final String str, final int i8, final String str2) {
        IlO("ipv6_req", false, (MY) new MY<com.bytedance.sdk.openadsdk.ea.IlO.EO>() { // from class: com.bytedance.sdk.openadsdk.ea.EO.15
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                String str3;
                JSONObject jSONObject = new JSONObject();
                int i9 = i2;
                if (i9 == 1) {
                    str3 = "success";
                } else if (i9 == -1) {
                    jSONObject.put("error_code", i8);
                    jSONObject.put("error_msg", str2);
                    str3 = C2300e4.f.e;
                } else {
                    str3 = "start";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("url", str);
                }
                jSONObject.put("status", str3);
                return tV.MY().IlO("ipv6_req").MY(jSONObject.toString());
            }
        });
    }

    public static void IlO(final String str, final boolean z2) {
        IlO("img_error_param", false, new MY() { // from class: com.bytedance.sdk.openadsdk.ea.EO.17
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_new", z2 ? 1 : 0);
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                } catch (Throwable unused) {
                }
                return tV.MY().IlO("img_error_param").MY(jSONObject.toString());
            }
        });
    }
}
