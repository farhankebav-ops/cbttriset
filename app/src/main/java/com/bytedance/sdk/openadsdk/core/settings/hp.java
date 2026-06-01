package com.bytedance.sdk.openadsdk.core.settings;

import a1.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.Cc;
import com.bytedance.sdk.openadsdk.core.settings.EV;
import com.bytedance.sdk.openadsdk.core.settings.TTSdkSettings;
import com.bytedance.sdk.openadsdk.core.settings.rp;
import com.bytedance.sdk.openadsdk.tV.IlO.bWL;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.mlkit.common.MlKitException;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp implements EV.IlO, vCE {
    private static final lEW AXM;
    public static String Cc;
    private static final String DmF;
    public static final String EO;
    private static final com.bytedance.sdk.component.lEW.lEW EV;
    public static final String IlO;
    public static final String MY;
    private static boolean rp;
    public static String tV;
    static final ConcurrentHashMap<String, Integer> vCE;
    private static final ConcurrentLinkedQueue<rp.IlO> xF;
    final Cc.MY<ConcurrentHashMap<String, Integer>> Bc;
    private Set<String> NV;
    private Cc.MY<JSONObject> OOq;
    private final NV bWL;
    private int cL;
    private int cl;
    private final AtomicBoolean ea;
    private boolean es;
    private final com.bytedance.sdk.openadsdk.core.settings.IlO hp;
    private final Cc.MY<Map<String, Integer>> kBB;
    Cc.MY<bWL> lEW;
    private final BroadcastReceiver oeT;
    private final Set<String> pP;
    private final Cc.MY<Set<String>> tl;
    private final Runnable vAh;
    private volatile boolean zPa;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.hp$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass9 extends BroadcastReceiver {
        private final Runnable MY = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.9.1
            @Override // java.lang.Runnable
            public void run() {
                mmj.MY(new com.bytedance.sdk.component.lEW.lEW("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.9.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            hp.this.MY();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        public AnonymousClass9() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            mmj.MY(new com.bytedance.sdk.component.lEW.lEW("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.9.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        hp.this.IlO(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.DmF.IlO().removeCallbacks(AnonymousClass9.this.MY);
                        com.bytedance.sdk.component.utils.DmF.IlO().postDelayed(AnonymousClass9.this.MY, WorkRequest.MIN_BACKOFF_MILLIS);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        static final hp IlO = new hp();
    }

    static {
        CharSequence[] charSequenceArr = {"bus_con_collect", zLG.kBB()};
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceArr[0]);
        sb.append((CharSequence) "_");
        sb.append(charSequenceArr[1]);
        IlO = sb.toString();
        CharSequence[] charSequenceArr2 = {"bus_con", zLG.kBB(), zLG.vAh(), "timeout"};
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequenceArr2[0]);
        for (int i2 = 1; i2 < 4; i2++) {
            sb2.append((CharSequence) "_");
            sb2.append(charSequenceArr2[i2]);
        }
        MY = sb2.toString();
        CharSequence[] charSequenceArr3 = {"bus_con", zLG.kBB(), zLG.vAh(), "alpha"};
        StringBuilder sb3 = new StringBuilder();
        sb3.append(charSequenceArr3[0]);
        for (int i8 = 1; i8 < 4; i8++) {
            sb3.append((CharSequence) "_");
            sb3.append(charSequenceArr3[i8]);
        }
        EO = sb3.toString();
        DmF = zLG.cl();
        EV = new com.bytedance.sdk.component.lEW.lEW("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.IlO.MY.Cc.MY().DmF();
                com.bytedance.sdk.component.adexpress.IlO.MY.Cc.MY().MY(false);
                com.bytedance.sdk.component.adexpress.IlO.MY.MY.MY();
                com.bytedance.sdk.component.adexpress.IlO.MY.Cc.MY().EO();
            }
        };
        tV = "";
        Cc = "IABTCF_TCString";
        rp = false;
        xF = new ConcurrentLinkedQueue<>();
        AXM = new lEW();
        vCE = new ConcurrentHashMap<>();
    }

    public static boolean BC() {
        return rp;
    }

    private static int EO(boolean z2) {
        return z2 ? 20 : 5;
    }

    private Set<String> KS() {
        return (Set) this.bWL.IlO("perf_con_applog_send", this.pP, this.tl);
    }

    public static void NST() {
        Context contextIlO;
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO() && (contextIlO = cl.IlO()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextIlO.getPackageName());
                intent.setAction("_dataChanged");
                contextIlO.sendBroadcast(intent);
            } catch (Throwable th) {
                oeT.IlO("TTAD.SdkSettings", "", th);
            }
        }
    }

    private String Os() {
        return this.bWL.IlO("force_language", "");
    }

    public static vCE aP() {
        if (cl.IlO() != null) {
            return IlO.IlO;
        }
        IllegalStateException illegalStateException = new IllegalStateException("context is null");
        Log.e("TTAD.SdkSettings", "context is null", illegalStateException);
        ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
        return AXM;
    }

    @Nullable
    private static SharedPreferences tV(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean AK() {
        return this.bWL.IlO("bus_con_dislike_report_raw", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public long AXM() {
        return this.bWL.IlO("duration", WorkRequest.MIN_BACKOFF_MILLIS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean Aw() {
        return this.bWL.IlO("privacy_app_reg", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void BES() {
        Cc.IlO IlO2 = this.bWL.IlO();
        IlO2.IlO("settings_url", "");
        IlO2.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String BO() {
        return this.bWL.IlO("bus_con_express_host", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean BS() {
        int iIlO = this.bWL.IlO("privacy_ad_enable", Integer.MAX_VALUE);
        if (iIlO == 1) {
            return true;
        }
        if (iIlO == 0) {
            return false;
        }
        int iEs = zLG.es();
        return iEs == 1 || iEs == 2 || iEs == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void Bc() {
        this.bWL.IlO().IlO("tt_sdk_settings").IlO("ab_test_param").IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    @Nullable
    public JSONObject Cc() {
        return (JSONObject) this.bWL.IlO("digest", null, Cc.IlO);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int DM() {
        return this.bWL.IlO("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String DmF() {
        return this.bWL.IlO("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int Dxv() {
        int iIlO = this.bWL.IlO("perf_con_webview_cache_count", 0);
        if (iIlO < 0) {
            return 0;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int ED() {
        int iIlO = this.bWL.IlO("bus_con_auto_click_delay", 3000);
        if (iIlO <= 0) {
            return 3000;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int EV() {
        return this.bWL.IlO("splash_video_load_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean Ea() {
        return this.bWL.IlO("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean HSR() {
        return this.bWL.IlO("bus_con_sec_type", Integer.MAX_VALUE) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean HTA() {
        return this.bWL.IlO("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public long Hg() {
        return this.bWL.IlO("perf_con_adlog_expire_time", 0L);
    }

    public void IRy() {
        if (EV.IlO()) {
            com.bytedance.sdk.openadsdk.core.bWL.MY().removeCallbacks(this.vAh);
            com.bytedance.sdk.openadsdk.core.bWL.MY().postDelayed(this.vAh, ao());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int Jz() {
        return this.bWL.IlO("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean KC() {
        return this.bWL.IlO("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean KT() {
        return this.bWL.IlO(IlO, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public Set<String> La() {
        return (Set) this.bWL.IlO("privacy_fields_allowed", Collections.EMPTY_SET, Cc.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int NV() {
        return this.bWL.IlO("load_callback_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void OOq() {
        String strOs = Os();
        if (TextUtils.isEmpty(strOs)) {
            return;
        }
        if (strOs.equals("zh-Hant")) {
            com.bytedance.sdk.component.utils.rp.IlO(cl.IlO(), "zh", "tw");
        } else {
            com.bytedance.sdk.component.utils.rp.IlO(cl.IlO(), strOs, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th) {
            oeT.EO("TTAD.SdkSettings", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String OW() {
        return this.bWL.IlO("bus_con_check_clz", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public bWL PTq() {
        return (bWL) this.bWL.IlO("perf_con_track_url_strategy", bWL.IlO, this.lEW);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int Tx() {
        return this.bWL.IlO("perf_con_thread_stack_size", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int VH() {
        return this.bWL.IlO("perf_con_drawable_code", 0);
    }

    public long XvI() {
        return this.bWL.IlO("last_req_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String YA() {
        return this.bWL.IlO("dyn_draw_engine_url", DmF);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String aa() {
        return this.bWL.IlO("dual_event_url", (String) null);
    }

    public long ao() {
        long jIlO = this.bWL.IlO("req_inter_min", TTAdConstant.AD_MAX_EVENT_TIME);
        return (jIlO < 0 || jIlO > SignalManager.TWENTY_FOUR_HOURS_MILLIS) ? TTAdConstant.AD_MAX_EVENT_TIME : jIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int bWL() {
        KS();
        return this.cl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public float cJK() {
        return this.bWL.IlO(EO, 1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int cL() {
        return this.bWL.IlO("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean cl() {
        return this.bWL.IlO("ad_revenue_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String dY() {
        return this.bWL.IlO("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int dm() {
        return this.bWL.IlO("bus_con_behavior_count", MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String eDn() {
        return this.bWL.IlO("target_region", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean ea() {
        return this.bWL.IlO("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public Set<String> eeU() {
        return (Set) this.bWL.IlO("perf_con_drop2rt_skip_label_list", Collections.EMPTY_SET, Cc.MY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String es() {
        return this.bWL.IlO("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int fdM() {
        int iIlO = this.bWL.IlO("perf_con_webview_cache_count_v3", 0);
        if (iIlO < 0) {
            return 0;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean gQ() {
        int iIlO = this.hp.IlO("perf_con_apm", 100);
        if (iIlO == 0) {
            return false;
        }
        return iIlO < 0 || iIlO >= 100 || iIlO > ((int) (Math.random() * 100.0d));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean gm() {
        return this.bWL.IlO("perf_con_use_new_thread_pool", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String[] hL() {
        Set<String> set;
        try {
            set = this.NV;
        } catch (Throwable unused) {
        }
        if (set == null || set.size() == 0) {
            JSONArray jSONArray = new JSONArray(this.bWL.IlO("gecko_hosts", (String) null));
            if (jSONArray.length() != 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.NV.add(jSONArray.getString(i2));
                }
            }
            Set<String> setIlO = NV.IlO(this.NV);
            this.NV = setIlO;
            if (setIlO != null) {
                if (setIlO.size() == 0) {
                }
            }
            return null;
        }
        return (String[]) this.NV.toArray(new String[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int hp() {
        KS();
        return this.cL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int ii() {
        return this.bWL.IlO("bus_con_send_log_type", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean jM() {
        return this.bWL.IlO("bus_con_video_keep_screen_on", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String kBB() {
        return this.bWL.IlO("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean lEW() {
        return this.bWL.IlO("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String lMM() {
        return this.bWL.IlO("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String mmj() {
        return this.bWL.IlO("dc", "TX");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean nm() {
        if (com.bytedance.sdk.component.adexpress.tV.MY.IlO(cl.IlO())) {
            return this.bWL.IlO("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int nvX() {
        return this.bWL.IlO("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String oc() {
        return this.bWL.IlO("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int oeT() {
        return this.bWL.IlO("max", 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean pFe() {
        return this.bWL.IlO("bus_con_adshow_check_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int pP() {
        int iIlO = this.bWL.IlO("fetch_tpl_timeout_ctrl", 3000);
        if (iIlO <= 0) {
            return 3000;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean quf() {
        return this.bWL.IlO("privacy_debug_unlock", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean qvT() {
        return this.bWL.IlO("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean qz() {
        return this.bWL.IlO("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public Set<String> rp() {
        return KS();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int ssS() {
        int iIlO = this.bWL.IlO("privacy_personalized_ad", Integer.MAX_VALUE);
        if (iIlO != Integer.MAX_VALUE) {
            return iIlO;
        }
        int iEs = zLG.es();
        if (iEs == 1 || iEs == 2) {
            return 2;
        }
        return iEs != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int tN() {
        return this.bWL.IlO("perf_con_close_button_delay_check_time", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean tU() {
        return this.bWL.IlO("bus_con_rewardedfull_link", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean tf() {
        return this.bWL.IlO("bus_con_url_check", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int tl() {
        int iIlO = this.bWL.IlO("fetch_tpl_second", 0);
        if (iIlO <= 0) {
            return 0;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int ts() {
        int iIlO = this.bWL.IlO("bus_con_token_thread_count", 4);
        if (iIlO <= 0 || iIlO > 30) {
            return 4;
        }
        return iIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean uF() {
        return this.bWL.IlO("token_enable", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int uI() {
        return this.bWL.IlO(MY, 10000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean uvo() {
        return this.zPa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public Bc vAh() {
        return (Bc) this.bWL.IlO("insert_js_config", Bc.IlO, new Cc.MY<Bc>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.8
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Bc MY(String str) {
                return new Bc(str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public long vCE() {
        return this.bWL.IlO("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String vSq() {
        return this.bWL.IlO("settings_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean vZk() {
        return this.bWL.IlO("perf_con_is_new_net_thread", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public JSONObject wD() {
        return (JSONObject) this.bWL.IlO("video_cache_config", null, Cc.IlO);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int wPn(String str) {
        Integer num;
        Map map = (Map) this.bWL.IlO("perf_con_applog_rate", null, this.kBB);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean xF() {
        return this.bWL.IlO("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int zLG() {
        return this.bWL.IlO("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean zPa() {
        return this.bWL.IlO("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public JSONObject zTS() {
        return (JSONObject) this.bWL.IlO("perf_con_thread_pool_config", new JSONObject(), this.OOq);
    }

    private hp() {
        this.NV = Collections.synchronizedSet(new HashSet());
        this.hp = new com.bytedance.sdk.openadsdk.core.settings.IlO();
        this.bWL = new NV(new rp.IlO() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.5
            @Override // com.bytedance.sdk.openadsdk.core.settings.rp.IlO
            public void IlO() {
                rp.IlO[] ilOArr;
                boolean unused = hp.rp = true;
                if (hp.xF == null || hp.xF.size() == 0 || (ilOArr = (rp.IlO[]) hp.xF.toArray()) == null) {
                    return;
                }
                for (rp.IlO ilO : ilOArr) {
                    ilO.IlO();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.rp.IlO
            public void MY() {
                if (hp.xF == null || hp.xF.isEmpty()) {
                    return;
                }
                Iterator it = hp.xF.iterator();
                while (it.hasNext()) {
                    ((rp.IlO) it.next()).MY();
                }
            }
        });
        this.ea = new AtomicBoolean(false);
        this.zPa = false;
        this.cl = 5000;
        this.cL = 10;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        this.oeT = anonymousClass9;
        this.vAh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.10
            @Override // java.lang.Runnable
            public void run() {
                hp.this.tV(2);
                hp.this.IRy();
            }
        };
        this.Bc = new Cc.MY<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.11
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> MY(String str) {
                if (TextUtils.isEmpty(str)) {
                    return hp.vCE;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        int iOptInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && iOptInt >= 0 && iOptInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(iOptInt));
                        }
                    }
                    return concurrentHashMap;
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                    return concurrentHashMap;
                }
            }
        };
        this.kBB = new Cc.MY<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.12
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> MY(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap map = new HashMap(jSONObject.length());
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int iOptInt = jSONObject.optInt(next, 100);
                            if (iOptInt < 0 || iOptInt > 100) {
                                map.put(next, 100);
                            } else {
                                map.put(next, Integer.valueOf(iOptInt));
                            }
                        }
                    }
                    return map;
                } catch (Exception e) {
                    oeT.EO(a.j(e, new StringBuilder("get applog rate from sp failed:")), new Object[0]);
                    return null;
                }
            }
        };
        this.pP = new HashSet();
        this.tl = new Cc.MY<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Set<String> MY(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int iOptInt = jSONObject.optInt("applog_count");
                        if (iOptInt >= 2 && iOptInt <= 100) {
                            hp.this.cL = iOptInt;
                        }
                        int iOptInt2 = jSONObject.optInt("applog_interval");
                        if (iOptInt2 >= 100 && iOptInt2 <= 30000) {
                            hp.this.cl = iOptInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                String string = jSONArray.getString(i2);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Log.i("TTAD.SdkSettings", e.getMessage());
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList(C2318f4.f8523d, C2461n2.f9471v, "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.OOq = new Cc.MY<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public JSONObject MY(String str) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th) {
                    oeT.EO("TTAD.SdkSettings", th.getMessage());
                    jSONObject = null;
                }
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        };
        this.lEW = new Cc.MY<bWL>() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.4
            @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public bWL MY(String str) {
                bWL bwl = new bWL();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    bwl.IlO(jSONObject.optInt("enable_strategy", 0) == 1);
                    bwl.IlO(IlO(jSONObject.optJSONObject("default")));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adid_configs");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            bwl.IlO(next, IlO(jSONObjectOptJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return bwl;
            }

            private bWL.IlO IlO(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new bWL.IlO(jSONObject.optInt("retry_times", -1), jSONObject.optInt("time_interval", -1));
                }
                return null;
            }
        };
        try {
            Context contextIlO = cl.IlO();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                contextIlO.registerReceiver(anonymousClass9, intentFilter, 4);
            } else {
                contextIlO.registerReceiver(anonymousClass9, intentFilter);
            }
        } catch (Exception e) {
            oeT.IlO("TTAD.SdkSettings", "", e);
        }
    }

    public static String EO(Context context) {
        SharedPreferences sharedPreferencesTV;
        return (context == null || (sharedPreferencesTV = tV(context)) == null) ? "" : sharedPreferencesTV.getString(Cc, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int AXM(String str) {
        return tl(str).OOq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean Bc(String str) {
        return str == null || tl(str).bWL == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean Cc(String str) {
        return tl(str).Bc == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int DmF(String str) {
        return tl(str).EV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean EV(String str) {
        try {
            return tl(str).vAh != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int NV(String str) {
        return tl(str).rp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int cL(String str) {
        return tl(str).xF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public JSONObject cl(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(this.bWL.IlO("core_settings", ""));
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put("ad_slot_setting", tl(str).YA);
            return jSONObject;
        } catch (JSONException e4) {
            e = e4;
            jSONObject2 = jSONObject;
            oeT.EO("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
            return jSONObject2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean ea(String str) {
        return tl(str).oeT == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean es(String str) {
        return tl(str).AXM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int kBB(String str) {
        return tl(str).lMM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int lEW(String str) {
        if (str == null) {
            return 1500;
        }
        return tl(str).zPa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean oc(String str) {
        Set set;
        if (TextUtils.isEmpty(str) || (set = (Set) this.bWL.IlO("token_adx_ids", Collections.EMPTY_SET, Cc.MY)) == null || set.size() == 0) {
            return false;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int oeT(String str) {
        return tl(str).wPn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean pP(String str) {
        return cl.tV().tl(str).ea == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int rp(String str) {
        return tl(String.valueOf(str)).lEW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int tV() {
        return this.bWL.IlO("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    @NonNull
    public MY tl(String str) {
        return EO.IlO(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean vAh(String str) {
        return tl(str).dY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int vCE(String str) {
        return tl(str).cL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int xF(String str) {
        return tl(str).tl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean zPa(String str) {
        return str == null || DeviceUtils.NV(cl.IlO()) == 0 || tl(str).hp == 1;
    }

    private static void MY(int i2, boolean z2) {
        Context contextIlO = cl.IlO();
        if (contextIlO != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextIlO.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z2);
                intent.putExtra("_source", i2);
                contextIlO.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void IlO() {
        File file;
        try {
            EO.IlO();
            this.bWL.EO();
            this.hp.EO();
            Context contextIlO = cl.IlO();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                file = new File(contextIlO.getDataDir(), "shared_prefs");
            } else {
                file = new File(contextIlO.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String strReplace = file2.getName().replace(".xml", "");
                if (i2 >= 24) {
                    contextIlO.deleteSharedPreferences(strReplace);
                } else {
                    contextIlO.getSharedPreferences(strReplace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.Bc.EO(file2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int bWL(String str) {
        return tl(str).NV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean hp(String str) {
        return rp(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean tV(String str) {
        int i2 = tl(str).Cc;
        if (i2 != 1) {
            return i2 == 2 && xF.EO(cl.IlO()) != 0;
        }
        return xF.tV(cl.IlO());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public String EO() {
        return this.bWL.IlO("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean wPn() {
        return this.bWL.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean EO(String str) {
        return tl(str).oc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void tV(@TTSdkSettings.FETCH_REQUEST_SOURCE int i2) {
        IlO(i2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int EO(int i2) {
        return tl(String.valueOf(i2)).DmF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean OOq(@NonNull String str) {
        Set set = (Set) this.bWL.IlO("privacy_fields_allowed", Collections.EMPTY_SET, Cc.MY);
        if (set.isEmpty()) {
            int iEs = zLG.es();
            if (iEs != 1) {
                if (iEs != 2 && iEs != 3) {
                    return false;
                }
                if (!"mcc".equals(str) && !"mnc".equals(str)) {
                    return false;
                }
            }
            return true;
        }
        return set.contains(str);
    }

    public static int MY(Context context) {
        SharedPreferences sharedPreferencesTV;
        if (context == null || (sharedPreferencesTV = tV(context)) == null) {
            return -2;
        }
        int i2 = sharedPreferencesTV.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i8 = sharedPreferencesTV.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i2 == Integer.MIN_VALUE && i8 == Integer.MIN_VALUE) {
            return -2;
        }
        return sharedPreferencesTV.getInt(Cookie.IABTCF_GDPR_APPLIES, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    @WorkerThread
    public synchronized void MY() {
        SystemClock.elapsedRealtime();
        boolean z2 = this.zPa;
        this.hp.IlO(this.zPa);
        this.bWL.IlO(this.zPa);
        EO.IlO(!z2);
        this.zPa = true;
        SystemClock.elapsedRealtime();
        if (!z2) {
            com.bytedance.sdk.openadsdk.core.bWL.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!EV.IlO()) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().MY();
                    } else {
                        hp.this.tV(1);
                        hp.this.IRy();
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void IlO(JSONObject jSONObject, Cc.IlO ilO) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        NV nv = this.bWL;
        String str = DmF;
        String strIlO = nv.IlO("dyn_draw_engine_url", str);
        final String strOptString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(strIlO) && !TextUtils.isEmpty(strOptString) && !strOptString.equals(strIlO)) {
            com.bytedance.sdk.openadsdk.core.bWL.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.hp.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(hp.this.bWL.IlO("dyn_draw_engine_url", hp.DmF), strOptString)) {
                        com.bytedance.sdk.component.adexpress.IlO.MY.Cc.MY().EO();
                    }
                }
            }, 5000L);
        }
        ilO.IlO("dyn_draw_engine_url", strOptString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void MY(JSONObject jSONObject, Cc.IlO ilO) {
        if (jSONObject.has("is_gdpr_user")) {
            int iOptInt = jSONObject.optInt("is_gdpr_user", -1);
            ilO.IlO("isGdprUser", (iOptInt == -1 || iOptInt == 1 || iOptInt == 0) ? iOptInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int IlO(String str) {
        if (str == null) {
            return 0;
        }
        return cl.tV().tl(str).es;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean MY(String str) {
        return tl(str).EO == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int IlO(String str, int i2) {
        Integer num;
        Map map = (Map) this.bWL.IlO("perf_con_stats_rate", vCE, this.Bc);
        return (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) ? i2 : num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int MY(int i2) {
        return tl(String.valueOf(i2)).MY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int IlO(String str, boolean z2) {
        if (str == null) {
            return EO(z2);
        }
        int i2 = tl(str).pP;
        return i2 != -1 ? i2 : EO(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public int IlO(int i2) {
        return tl(String.valueOf(i2)).nvX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void IlO(long j) {
        this.bWL.IlO().IlO("last_req_time", j).IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void IlO(@TTSdkSettings.FETCH_REQUEST_SOURCE int i2, boolean z2) {
        if (!com.bytedance.sdk.openadsdk.core.bWL.Cc() && i2 != 1 && i2 != 2) {
            if (z2) {
                this.es = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.DmF.MY().tV())) {
                return;
            }
            if (this.es) {
                this.es = false;
                if (!z2) {
                    z2 = true;
                }
            }
            long jXvI = XvI();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jAo = ao();
            long j = jCurrentTimeMillis - jXvI;
            if (z2 || j >= jAo) {
                if (!EV.IlO()) {
                    MY(i2, z2);
                } else if (this.ea.compareAndSet(false, true)) {
                    mmj.MY((com.bytedance.sdk.component.lEW.lEW) new EV(this, this.bWL, this.hp));
                    com.bytedance.sdk.openadsdk.core.bWL.MY().removeCallbacks(this.vAh);
                }
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("settings request error", "settings", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.EV.IlO
    public void IlO(boolean z2) {
        this.ea.set(false);
        IRy();
        if (z2) {
            HashMap map = new HashMap();
            Set<String> setLa = La();
            if (setLa != null && !setLa.isEmpty()) {
                map.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, setLa);
            }
            String strHp = zLG.hp();
            if (!TextUtils.isEmpty(strHp)) {
                map.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, strHp);
            }
            map.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, eDn());
            com.bytedance.sdk.openadsdk.core.DmF.MY.MY().IlO(map);
            NST();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public void IlO(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.oeT, intentFilter, 4);
            } else {
                context.registerReceiver(this.oeT, intentFilter);
            }
        } catch (Exception e) {
            oeT.IlO("TTAD.SdkSettings", "", e);
        }
        if (uvo()) {
            tV(1);
            IRy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.vCE
    public boolean IlO(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        if (cryptDataScene != PangleEncryptConstant.CryptDataScene.GET_ADS && cryptDataScene != PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) {
            if (cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG) {
                return this.bWL.IlO("perf_con_crypt_V4_applog", false);
            }
            return this.bWL.IlO("perf_con_crypt_V4", false);
        }
        return this.bWL.IlO("perf_con_crypt_V4_get_ad", false);
    }

    public static void IlO(rp.IlO ilO) {
        ConcurrentLinkedQueue<rp.IlO> concurrentLinkedQueue = xF;
        if (concurrentLinkedQueue.contains(ilO)) {
            return;
        }
        concurrentLinkedQueue.add(ilO);
    }
}
