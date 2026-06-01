package com.bytedance.sdk.openadsdk.xF;

import a1.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.ironsource.C2300e4;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private int AK;
    private String AXM;
    private float Aw;
    private int BC;
    private String BES;
    private String BK;
    private IlO BO;
    private String BS;
    private final String Bc;
    private String CQo;
    public final String Cc;
    private String Ct;
    private long DM;
    private boolean DYs;
    private Runnable DmF;
    private int Dxv;
    private vCE ED;
    public final String EO;
    private Runnable EV;
    private int Ea;
    private boolean Fv;
    private String HSR;
    private int HTA;
    private long Hg;
    private String IK;
    private int IRy;
    public final String IlO;
    private String Jz;
    private int KC;
    private int KS;
    private int KT;
    private ViewTreeObserver.OnGlobalLayoutListener LO;
    private List<JSONObject> LT;
    private JSONObject La;
    public final String MY;
    private boolean NI;
    private int NST;
    private Runnable NV;
    private long OOq;
    private String OW;
    private int Os;
    private com.bytedance.sdk.openadsdk.xF.IlO PTq;
    private volatile boolean Pbh;
    private boolean QLG;
    private int QfH;
    private boolean TU;
    private int Tx;
    private int VFH;
    private EO VH;
    private String XfO;
    private int XvI;
    private long YA;
    private int aP;
    private WeakReference<View> aa;
    private int ao;
    private Runnable bWL;
    private String cJK;
    private boolean cL;
    private boolean cl;
    private boolean ct;
    private boolean dM;
    private long dY;
    private Context dm;
    private float eDn;
    private MY ea;
    private String eeU;
    private Set<String> es;
    private int fdM;
    private String gQ;

    @Nullable
    private WebView gm;
    private boolean hHv;
    private int hL;
    private Runnable hp;
    private int ii;
    private String jM;
    private boolean kBB;
    private final Handler lEW;
    private long lMM;
    private long mmj;
    private int nm;
    private long nvX;
    private long oc;
    private boolean oeT;
    private long pFe;
    private String pP;
    private volatile boolean qIK;
    private int quf;
    private int qvT;
    private boolean qyG;
    private JSONObject qz;
    private final Handler rp;
    private String ssS;
    private JSONObject tN;
    private String tU;
    public final String tV;
    private Map<String, String> tf;
    private long tl;
    private int ts;
    private float uF;
    private JSONObject uI;
    private boolean uvo;
    private boolean vAh;
    private final String vCE;
    private long vSq;
    private String vZk;
    private boolean wD;
    private int wPn;
    private String xF;
    private int xJ;
    private long zLG;
    private boolean zPa;
    private int zTS;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private lEW(Context context, WebView webView, EO eo, com.bytedance.sdk.openadsdk.xF.IlO ilO, IlO ilO2) {
        this.vCE = "playable_stuck_check_ping";
        this.Bc = "playable_apply_media_permission_callback";
        this.lEW = new Handler(Looper.getMainLooper());
        this.rp = new Handler(Looper.getMainLooper());
        this.zPa = true;
        this.cl = true;
        this.cL = true;
        this.IlO = "PL_sdk_playable_global_viewable";
        this.MY = "PL_sdk_page_screen_blank";
        this.EO = "PL_sdk_playable_destroy_analyze_summary";
        this.tV = "PL_sdk_playable_hardware_dialog_cancel";
        this.Cc = "PL_sdk_playable_hardware_dialog_setting";
        this.es = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.xF = null;
        this.AXM = "embeded_ad";
        this.oeT = true;
        this.vAh = true;
        this.kBB = false;
        this.pP = "";
        this.tl = 10L;
        this.OOq = 10L;
        this.wPn = 700;
        this.oc = 0L;
        this.vSq = 0L;
        this.dY = -1L;
        this.lMM = -1L;
        this.nvX = -1L;
        this.YA = -1L;
        this.mmj = -1L;
        this.DM = -1L;
        this.zLG = -1L;
        this.BS = "";
        this.ssS = "";
        this.gQ = "";
        this.HSR = "";
        this.AK = 0;
        this.quf = 0;
        this.uvo = false;
        this.KC = 0;
        this.Ea = -1;
        this.Dxv = 0;
        this.fdM = 0;
        this.hL = 0;
        this.Jz = null;
        this.wD = false;
        this.nm = 0;
        this.ii = 0;
        this.HTA = 0;
        this.Tx = 0;
        this.pFe = 0L;
        this.Hg = 0L;
        this.qvT = -2;
        this.ts = 0;
        this.zTS = 0;
        this.KT = 0;
        this.uI = new JSONObject();
        this.tf = new HashMap();
        this.tN = new JSONObject();
        this.BES = "";
        this.Aw = 0.0f;
        this.uF = 0.0f;
        this.ct = false;
        this.TU = false;
        this.hHv = false;
        this.LT = new ArrayList();
        this.QLG = true;
        this.Pbh = true;
        this.qIK = true;
        this.LO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) lEW.this.aa.get();
                    if (view == null) {
                        return;
                    }
                    lEW.this.MY(view);
                } catch (Throwable th) {
                    Bc.IlO("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.VFH = -1;
        this.qvT = 0;
        this.BO = ilO2;
        this.gm = webView;
        DmF.IlO(webView);
        IlO(webView);
        IlO(context, eo, ilO);
    }

    private void BS() {
        this.ea = new MY(this, this.wPn);
        this.DmF = new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.5
            @Override // java.lang.Runnable
            public void run() {
                if (lEW.this.oeT) {
                    lEW.this.oeT = false;
                    lEW.this.lEW.removeCallbacks(lEW.this.NV);
                    lEW.this.IlO(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.NV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.6
            @Override // java.lang.Runnable
            public void run() {
                if (lEW.this.oeT) {
                    lEW.this.oeT = false;
                    lEW.this.Pbh = false;
                    lEW.this.lEW.removeCallbacks(lEW.this.DmF);
                    lEW.this.IlO(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.hp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.7
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (lEW.this.gm != null) {
                    lEW.this.gm.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.7.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (lEW.this.ea != null) {
                                lEW.this.ea.IlO(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (lEW.this.rp != null) {
                    lEW.this.rp.postDelayed(this, 500L);
                }
            }
        };
        this.bWL = new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.8
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                lEW.this.IlO("playable_stuck_check_ping", new JSONObject());
                if (lEW.this.rp != null) {
                    lEW.this.rp.postDelayed(this, 500L);
                }
            }
        };
        this.EV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.9
            @Override // java.lang.Runnable
            public void run() {
                if (lEW.this.Hg <= 0) {
                    lEW.this.MY(1, "Clicking on the hot zone causes the program to freeze.");
                } else {
                    if (lEW.this.Hg - lEW.this.pFe > lEW.this.wPn) {
                        lEW.this.MY(1, "Clicking on the hot zone causes the program to freeze.");
                        return;
                    }
                    lEW.this.dY();
                    lEW.this.pFe = 0L;
                    lEW.this.Hg = 0L;
                }
            }
        };
    }

    private void gQ() {
        Runnable runnable;
        Runnable runnable2;
        this.ea.IlO(System.currentTimeMillis());
        Handler handler = this.rp;
        if (handler != null) {
            int i2 = this.qvT;
            if (i2 == 0 && (runnable2 = this.hp) != null) {
                handler.post(runnable2);
            } else if ((i2 == 1 || i2 == 2) && (runnable = this.bWL) != null) {
                handler.post(runnable);
            }
            this.ea.IlO(500);
        }
    }

    public static /* synthetic */ int hp(lEW lew) {
        int i2 = lew.quf;
        lew.quf = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int rp(lEW lew) {
        int i2 = lew.AK;
        lew.AK = i2 + 1;
        return i2;
    }

    private void ssS() {
        String str;
        if (this.tN == null || (str = this.vZk) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.tN.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.vZk).getHost();
        if (TextUtils.isEmpty(host)) {
            this.vZk = a.s(new StringBuilder(), this.vZk, "/cid_", strOptString);
        } else {
            this.vZk = this.vZk.replace(host, a.D(host, "/cid_", strOptString));
        }
    }

    public void AXM() {
        com.bytedance.sdk.openadsdk.xF.IlO ilO = this.PTq;
        if (ilO != null) {
            ilO.MY();
        }
    }

    public String DM() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public void OOq() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.mmj > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.mmj);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.nvX > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.nvX);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            EO("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void YA() {
        if (this.hHv) {
            return;
        }
        this.hHv = true;
        this.vSq = 0L;
        this.cl = true;
        nvX();
        try {
            View view = this.aa.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.LO);
            }
        } catch (Throwable unused) {
        }
        try {
            this.ED.MY();
        } catch (Throwable unused2) {
        }
        try {
            MY my = this.ea;
            if (my != null) {
                my.IlO();
                this.ea = null;
            }
            Handler handler = this.rp;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            th.toString();
        }
        try {
            if (!TextUtils.isEmpty(this.vZk)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.AK);
                jSONObject.put("playable_hit_times", this.quf);
                int i2 = this.AK;
                if (i2 > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.quf) / (((double) i2) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                EO("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.vZk)) {
                if (this.dY != -1) {
                    this.oc += System.currentTimeMillis() - this.dY;
                    this.dY = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.oc);
                EO("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.Pbh = false;
        this.qIK = false;
        this.lEW.removeCallbacks(this.DmF);
        this.lEW.removeCallbacks(this.NV);
        this.lEW.removeCallbacksAndMessages(null);
    }

    public JSONObject bWL() {
        boolean zIlO;
        boolean zIlO2;
        try {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zIlO = Cc.IlO(this.dm, "android.permission.READ_MEDIA_IMAGES");
                zIlO2 = true;
            } else {
                zIlO = Cc.IlO(this.dm, "android.permission.READ_EXTERNAL_STORAGE");
                zIlO2 = Cc.IlO(this.dm, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zIlO);
            jSONObject.put("isHasWrite", zIlO2);
            if (!zIlO || !zIlO2) {
                z2 = false;
            }
            jSONObject.put("result", z2);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject cL() {
        if (this.uI.isNull("width")) {
            View view = this.aa.get();
            if (view == null) {
                return this.uI;
            }
            MY(view);
        }
        return this.uI;
    }

    public com.bytedance.sdk.openadsdk.xF.IlO cl() {
        return this.PTq;
    }

    public void dY() {
        if (this.vAh) {
            this.DM = System.currentTimeMillis();
            if (this.BO == IlO.FEED_AWEME) {
                if (this.Fv && this.ts == 3) {
                    MY my = this.ea;
                    if (my != null && my.MY()) {
                        gQ();
                        return;
                    } else {
                        if (this.ea == null) {
                            this.ea = new MY(this, this.wPn);
                            gQ();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.Fv && this.ts == 2) {
                MY my2 = this.ea;
                if (my2 != null && my2.MY()) {
                    gQ();
                } else if (this.ea == null) {
                    this.ea = new MY(this, this.wPn);
                    gQ();
                }
            }
        }
    }

    public JSONObject ea() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.BO.ordinal());
            jSONObject.put("safe_area_top_height", this.Aw);
            jSONObject.put("safe_area_bottom_height", this.uF);
            jSONObject.put("playable_enter_from", this.fdM);
            jSONObject.put("playable_retry_count", this.Dxv);
            jSONObject.put("playable_card_session", this.BS);
            jSONObject.put("playable_video_session", this.ssS);
            jSONObject.put("playable_network_type", zPa());
            jSONObject.put("aweme_id", this.HSR);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public JSONObject es() {
        return this.tN;
    }

    public void kBB() {
        this.wD = true;
    }

    public void lMM() {
        try {
            MY my = this.ea;
            if (my != null) {
                my.IlO();
            }
            Handler handler = this.rp;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public int mmj() {
        return (this.lMM == -1 || !this.Fv) ? 1 : 2;
    }

    public void nvX() {
        this.zTS = 0;
        this.KT = 0;
        this.eDn = 0.0f;
        this.NST = 0;
        this.aP = 0;
        this.ao = 0;
        this.XvI = 0;
        this.IRy = 0;
        this.BC = 0;
        this.xJ = 0;
        this.QfH = 0;
        this.Os = 0;
        this.KS = 0;
    }

    public void oc() {
        int i2;
        int i8 = this.qvT;
        if (i8 == 0 || i8 == 1 || i8 == 2) {
            if (this.Pbh) {
                this.lEW.postDelayed(this.DmF, this.tl * 1000);
            }
            if ((this.qIK && rp(this.vZk)) || (i2 = this.qvT) == 1 || i2 == 2) {
                this.lEW.postDelayed(this.NV, this.OOq * 1000);
            }
        }
    }

    public void oeT() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.mmj > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.mmj);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.nvX > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.nvX;
                this.zLG = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            EO("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void pP() {
        if (this.PTq != null) {
            IlO ilO = IlO.LAND_PAGE;
        }
    }

    public void tl() {
        if (this.PTq != null) {
            IlO ilO = IlO.LAND_PAGE;
        }
    }

    public void vAh() {
        this.Ea = 2;
    }

    public void vSq() {
        this.qIK = false;
        this.lEW.removeCallbacks(this.NV);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.nvX > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.nvX);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            EO("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void wPn() {
        MY my;
        this.Hg = System.currentTimeMillis();
        int i2 = this.qvT;
        if ((i2 == 1 || i2 == 2) && (my = this.ea) != null) {
            my.IlO(System.currentTimeMillis());
        }
    }

    public JSONObject xF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.eDn);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.NST);
            jSONObject2.put("height", this.aP);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.XvI);
            jSONObject3.put("y", this.ao);
            jSONObject3.put("width", this.IRy);
            jSONObject3.put("height", this.BC);
            jSONObject.put(C2300e4.h.K, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.QfH);
            jSONObject4.put("y", this.xJ);
            jSONObject4.put("width", this.Os);
            jSONObject4.put("height", this.KS);
            jSONObject.put("visible", jSONObject4);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "getViewport error", th);
            return jSONObject;
        }
    }

    public int zLG() {
        return this.VFH;
    }

    public String zPa() {
        com.bytedance.sdk.openadsdk.xF.IlO ilO;
        if (TextUtils.isEmpty(this.gQ) && (ilO = this.PTq) != null) {
            this.gQ = ilO.IlO().toString();
        }
        return this.gQ;
    }

    private boolean rp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public String Bc() {
        return this.CQo;
    }

    public String Cc() {
        return this.cJK;
    }

    public boolean DmF() {
        return this.Fv;
    }

    public JSONObject EO() {
        return this.La;
    }

    public Set<String> EV() {
        return this.ED.IlO();
    }

    public JSONObject NV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.NI);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public JSONObject hp() {
        try {
            boolean zIlO = Cc.IlO(this.dm, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zIlO);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public boolean lEW() {
        return this.qyG;
    }

    public String tV() {
        return this.tU;
    }

    public String vCE() {
        return this.OW;
    }

    public lEW Bc(String str) {
        int iIndexOf;
        String strDecode;
        this.BES = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                String host = uri.getHost();
                if (!C2300e4.h.K.equalsIgnoreCase(host) && (host == null || !host.contains(C2300e4.h.K))) {
                    if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                        if (this.qvT == -1) {
                            MY(2);
                        } else {
                            MY(1);
                        }
                    }
                } else {
                    MY(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                }
            } else {
                MY(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            }
        } catch (Throwable unused) {
        }
        this.vZk = str;
        return this;
    }

    public lEW Cc(String str) {
        this.CQo = str;
        return this;
    }

    public void DmF(String str) {
        WebView webView;
        boolean z2 = this.ts == -1;
        this.ts = 2;
        if (!z2) {
            this.jM = str;
            JSONObject jSONObject = new JSONObject();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.YA = jCurrentTimeMillis;
                long j = this.nvX;
                jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
                jSONObject.put("playable_has_show", mmj());
            } catch (Throwable th) {
                Bc.IlO("PlayablePlugin", "reportUrlLoadFinish error", th);
            }
            EO("PL_sdk_html_load_finish", jSONObject);
        }
        this.Pbh = false;
        this.lEW.removeCallbacks(this.DmF);
        try {
            if (this.qvT == 0) {
                if (this.zPa && (webView = this.gm) != null) {
                    this.zPa = false;
                    webView.evaluateJavascript(DM(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.11
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                dY();
            }
        } catch (Throwable th2) {
            Bc.IlO("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public lEW EO(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.La = jSONObject;
            return this;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "setPlayableStyle error", th);
            return this;
        }
    }

    public void EV(String str) {
        this.lEW.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.3
            @Override // java.lang.Runnable
            public void run() {
                lEW.hp(lEW.this);
            }
        });
    }

    public JSONObject lEW(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt == 1) {
                jSONObject2.put("result", Cc.MY(this.dm, "android.permission.RECORD_AUDIO"));
            } else {
                if (iOptInt == 2) {
                    jSONObject2.put("result", Cc.MY(this.dm, "android.permission.CAMERA"));
                    return jSONObject2;
                }
                if (iOptInt == 3) {
                    jSONObject2.put("result", Cc.IlO(this.dm));
                    return jSONObject2;
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public JSONObject rp() {
        try {
            boolean zIlO = Cc.IlO(this.dm, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zIlO);
            return jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public lEW tV(String str) {
        this.OW = str;
        return this;
    }

    public lEW vCE(String str) {
        this.AXM = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.zTS == view.getWidth() && this.KT == view.getHeight()) {
                return;
            }
            this.zTS = view.getWidth();
            this.KT = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.zTS);
            jSONObject.put("height", this.KT);
            IlO(WebViewManager.EVENT_TYPE_RESIZE, jSONObject);
            this.uI = jSONObject;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void Cc(JSONObject jSONObject) {
        this.qz = jSONObject;
        this.hL++;
        lMM();
        this.lEW.removeCallbacks(this.EV);
        if (this.vAh) {
            this.DM = System.currentTimeMillis();
            this.pFe = System.currentTimeMillis();
            this.Hg = 0L;
            int i2 = this.qvT;
            if (i2 == 0) {
                WebView webView = this.gm;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.10
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            lEW.this.Hg = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i2 == 1 || i2 == 2) {
                IlO("playable_stuck_check_ping", new JSONObject());
            }
            this.lEW.postDelayed(this.EV, this.wPn);
        }
    }

    public lEW tV(boolean z2) {
        this.NI = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.NI);
            IlO("change_playable_click", jSONObject);
            return this;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "setPlayableClick error", th);
            return this;
        }
    }

    public void vCE(JSONObject jSONObject) {
        MY(2, jSONObject != null ? jSONObject.optString("error_msg", "The material directly invokes the exception pocket mask on the client") : "The material directly invokes the exception pocket mask on the client");
    }

    private void IlO(Context context, EO eo, com.bytedance.sdk.openadsdk.xF.IlO ilO) {
        this.xF = UUID.randomUUID().toString();
        this.dm = context;
        this.PTq = ilO;
        this.VH = eo;
        NV.IlO(ilO);
        this.ED = new vCE(this);
        BS();
        if (this.gm == null) {
            this.VFH = 4;
            this.lEW.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.4
                @Override // java.lang.Runnable
                public void run() {
                    lEW.this.IlO(5, "webview is null");
                }
            });
        }
    }

    public void NV(String str) {
        this.lEW.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.2
            @Override // java.lang.Runnable
            public void run() {
                lEW.rp(lEW.this);
            }
        });
    }

    public lEW EO(boolean z2) {
        if (this.VFH != -1 && this.Fv != z2) {
            this.Fv = z2;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.Fv) {
                    jSONObject.put("playable_background_show_type", this.ii);
                }
            } catch (JSONException unused) {
            }
            EO(this.Fv ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
            if (this.lMM == -1 && this.Fv) {
                this.lMM = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("render_type", this.VFH == 1 ? 1 : 2);
                    int i2 = this.VFH;
                    if (i2 != -1) {
                        jSONObject2.put("webview_state", i2);
                    }
                } catch (JSONException unused2) {
                }
                EO("PL_sdk_page_show", jSONObject2);
            }
            if (this.lMM != -1 && !this.Fv && !this.ct) {
                this.ct = true;
            }
            if (this.Fv) {
                this.dY = System.currentTimeMillis();
            } else if (this.dY != -1) {
                this.oc += System.currentTimeMillis() - this.dY;
                this.dY = -1L;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("viewStatus", this.Fv);
                IlO(C2300e4.g.V, jSONObject3);
            } catch (Throwable th) {
                Bc.IlO("PlayablePlugin", "setViewable error", th);
            }
            if (this.Fv) {
                dY();
            } else {
                lMM();
            }
        }
        return this;
    }

    public void vCE(boolean z2) {
        this.DYs = z2;
    }

    public void tV(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Jz = jSONObject.optString("section");
        }
    }

    private String tV(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.vZk = str3;
        return str3;
    }

    public void lEW(String str) {
        this.ts = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.nvX = jCurrentTimeMillis;
            long j = this.lMM;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        EO("PL_sdk_html_load_start", jSONObject);
        this.Pbh = true;
        this.qIK = true;
        if (this.QLG) {
            oc();
            this.Pbh = false;
            this.qIK = false;
        }
        if (this.cl) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (Cc.IlO(this.dm, Cc.rp)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (Cc.MY(this.dm, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (Cc.IlO(this.dm, Cc.EV)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (Cc.IlO(this.dm, Cc.NV)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (Cc.IlO(this.dm, Cc.DmF)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (Cc.IlO(this.dm, Cc.lEW)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (Cc.MY(this.dm, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (Cc.IlO(this.dm, Cc.Bc)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (Cc.IlO(this.dm)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                EO("PL_sdk_hardware_detect", jSONObject2);
                this.cl = false;
            } catch (Throwable th2) {
                Bc.IlO("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public JSONObject tV(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        if (Bc.IlO() && jSONObject != null) {
            jSONObject.toString();
        }
        JSONObject jSONObjectIlO = this.ED.IlO(str, jSONObject);
        if (Bc.IlO()) {
            System.currentTimeMillis();
            if (jSONObjectIlO != null) {
                jSONObjectIlO.toString();
            }
        }
        return jSONObjectIlO;
    }

    public Map<String, String> MY() {
        return this.tf;
    }

    public lEW MY(String str) {
        this.tU = str;
        return this;
    }

    public void IlO(View view) {
        if (view == null) {
            return;
        }
        try {
            this.aa = new WeakReference<>(view);
            MY(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.LO);
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public lEW MY(boolean z2) {
        this.dM = z2;
        return this;
    }

    public lEW MY(long j) {
        if (j <= 0) {
            this.OOq = 10L;
            return this;
        }
        this.OOq = j;
        return this;
    }

    private void Cc(String str, JSONObject jSONObject) {
        try {
            int i2 = this.qvT;
            if (i2 == 0) {
                if (this.BO != IlO.LAND_PAGE && !rp(this.vZk)) {
                    ssS();
                }
                jSONObject.put("playable_url", this.vZk);
            } else if (i2 == 3 || i2 == 4) {
                jSONObject.put("playable_url", tV(this.IK, this.Ct));
            } else if (i2 == 1 || i2 == 2) {
                jSONObject.put("playable_url", EO(this.BK, this.XfO));
            }
            jSONObject.put("playable_render_type", this.qvT);
            if (this.PTq != null) {
                if (this.qvT == 0 && (this.BO != IlO.LAND_PAGE || rp(this.vZk))) {
                    this.PTq.IlO(jSONObject);
                } else if (this.qvT != 0) {
                    this.PTq.IlO(jSONObject);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void MY(JSONObject jSONObject) {
        if (this.PTq != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public Context IlO() {
        return this.dm;
    }

    public lEW IlO(String str, String str2) {
        this.tf.put(str, str2);
        return this;
    }

    public void MY(String str, String str2) {
        Bitmap bitmapIlO;
        if (TextUtils.isEmpty(str2) || (bitmapIlO = Cc.IlO(str2)) == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(this.dm.getContentResolver(), bitmapIlO, str, "");
    }

    public lEW IlO(String str) {
        this.cJK = str;
        return this;
    }

    public void DmF(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.ts = 3;
                dY();
            } else {
                this.ts = -2;
            }
            if (zOptBoolean || !this.oeT) {
                return;
            }
            this.oeT = false;
            this.Pbh = false;
            this.qIK = false;
            this.lEW.removeCallbacks(this.DmF);
            this.lEW.removeCallbacks(this.NV);
            IlO(4, "CaseRenderFail");
        }
    }

    public lEW IlO(boolean z2) {
        this.qyG = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.qyG);
            IlO("volumeChange", jSONObject);
            return this;
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "setIsMute error", th);
            return this;
        }
    }

    public JSONObject Bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return rp();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : bWL();
        }
        return hp();
    }

    public lEW MY(int i2) {
        this.qvT = i2;
        return this;
    }

    public void MY(int i2, String str) {
        this.Ea = i2;
        if (this.qz == null) {
            this.qz = new JSONObject();
        }
        try {
            this.qz.put("playable_stuck_type", i2);
            this.qz.put("playable_stuck_reason", str);
            if (this.DM > 0) {
                this.qz.put("playable_stuck_duration", System.currentTimeMillis() - this.DM);
            } else {
                this.qz.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        EO("PL_sdk_page_stuck", this.qz);
        lMM();
        if (this.PTq == null || i2 != 2) {
            return;
        }
        this.qz = new JSONObject();
    }

    public lEW IlO(long j) {
        if (j <= 0) {
            this.tl = 10L;
            return this;
        }
        this.tl = j;
        return this;
    }

    public lEW Cc(boolean z2) {
        this.QLG = z2;
        return this;
    }

    public void IlO(int i2) {
        this.VFH = i2;
    }

    public void IlO(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.xF.IlO ilO = this.PTq;
        if (ilO == null || ilO.MY(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            MY(strOptString2, strOptString);
        }
    }

    public lEW EO(JSONObject jSONObject) {
        this.tN = jSONObject;
        return this;
    }

    private void EO(int i2, String str) {
        com.bytedance.sdk.openadsdk.xF.IlO ilO = this.PTq;
        if (ilO != null) {
            ilO.IlO(i2, str);
        }
    }

    public void IlO(String str, JSONObject jSONObject) {
        if (Bc.IlO() && jSONObject != null) {
            jSONObject.toString();
        }
        EO eo = this.VH;
        if (eo != null) {
            eo.IlO(str, jSONObject);
        }
    }

    public void MY(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Cc(str, jSONObject);
    }

    private String EO(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.eeU) && !TextUtils.isEmpty(this.BES)) {
            Uri uri = Uri.parse(this.BES);
            String host = uri.getHost();
            if (!"lynxview".equalsIgnoreCase(host) && (host == null || !host.contains("lynxview"))) {
                queryParameter = "";
                queryParameter2 = "";
            } else {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.eeU = builderAppendQueryParameter.toString();
        }
        return this.eeU;
    }

    public lEW IlO(float f4) {
        this.eDn = f4;
        return this;
    }

    public void IlO(int i2, String str) {
        lMM();
        EO(i2, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i2);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "reportRenderFatal error", th);
        }
        EO("PL_sdk_global_faild", jSONObject);
    }

    public void IlO(int i2, String str, String str2) {
        this.ts = -1;
        this.jM = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i2);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
            jSONObject.put("playable_has_show", mmj());
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "onWebReceivedError error", th);
        }
        EO("PL_sdk_html_load_error", jSONObject);
        if (this.oeT) {
            this.oeT = false;
            this.Pbh = false;
            this.qIK = false;
            this.lEW.removeCallbacks(this.DmF);
            this.lEW.removeCallbacks(this.NV);
            IlO(1, "ContainerLoadFail");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void EO(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.uvo && this.quf > 0) {
                this.uvo = true;
            }
            if ("PL_sdk_html_load_start".equals(str) || "PL_sdk_html_load_finish".equals(str) || "PL_sdk_html_load_error".equals(str)) {
                jSONObject.put("usecache", this.DYs ? 1 : 0);
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.Fv);
            jSONObject.put("playable_session_id", this.xF);
            int i2 = this.qvT;
            if (i2 == 0) {
                if (this.BO != IlO.LAND_PAGE && !rp(this.vZk)) {
                    ssS();
                }
                jSONObject.put("playable_url", this.vZk);
            } else if (i2 == 3 || i2 == 4) {
                jSONObject.put("playable_url", tV(this.IK, this.Ct));
            } else if (i2 == 1 || i2 == 2) {
                jSONObject.put("playable_url", EO(this.BK, this.XfO));
            }
            jSONObject.put("playable_full_url", this.BES);
            jSONObject.put("playable_replay_count", this.KC);
            jSONObject.put("playable_is_prerender", this.dM);
            jSONObject.put("playable_is_preload", this.uvo);
            jSONObject.put("playable_render_type", this.qvT);
            jSONObject.put("playable_scenes_type", this.BO.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.BK) ? "" : this.BK);
            if (!TextUtils.isEmpty(this.XfO)) {
                str2 = this.XfO;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.6.0");
            jSONObject.put("playable_minigamelite_id", this.IK);
            jSONObject.put("playable_minigamelite_schema", this.Ct);
            jSONObject.put("playable_is_debug", this.TU);
            jSONObject.put("playable_retry_count", this.Dxv);
            jSONObject.put("playable_enter_from", this.fdM);
            jSONObject.put("playable_sequence", this.hL);
            jSONObject.put("playable_current_section", this.Jz);
            jSONObject.put("is_playable_finish", this.wD);
            jSONObject.put("playable_card_session", this.BS);
            jSONObject.put("playable_video_session", this.ssS);
            jSONObject.put("playable_network_type", zPa());
            jSONObject.put("playable_lynx_version", this.pP);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.AXM);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.tN.opt("cid"));
            jSONObject2.put("log_extra", this.tN.opt("log_extra"));
            int i8 = this.qvT;
            if (i8 != -1 && i8 != -2) {
                if (this.PTq != null) {
                    List<JSONObject> list = this.LT;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.LT.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.qvT);
                                jSONObjectOptJSONObject.put("playable_url", this.vZk);
                            }
                            this.PTq.IlO(jSONObjectOptJSONObject);
                        }
                        this.LT.clear();
                    }
                    if (this.qvT == 0 && (this.BO != IlO.LAND_PAGE || rp(this.vZk))) {
                        this.PTq.IlO(jSONObject);
                        return;
                    } else {
                        if (this.qvT != 0) {
                            this.PTq.IlO(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.LT == null) {
                this.LT = new ArrayList();
            }
            this.LT.add(jSONObject2);
        } catch (Throwable th) {
            Bc.IlO("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void IlO(boolean z2, String str, int i2) {
        if (z2) {
            this.ts = -1;
            this.jM = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i2);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
                jSONObject.put("playable_has_show", mmj());
            } catch (Throwable th) {
                Bc.IlO("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            EO("PL_sdk_html_load_error", jSONObject);
            if (this.oeT) {
                this.oeT = false;
                this.Pbh = false;
                this.qIK = false;
                this.lEW.removeCallbacks(this.DmF);
                this.lEW.removeCallbacks(this.NV);
                IlO(1, "ContainerLoadFail");
            }
        }
    }

    private lEW(Context context, int i2, EO eo, com.bytedance.sdk.openadsdk.xF.IlO ilO) {
        this.vCE = "playable_stuck_check_ping";
        this.Bc = "playable_apply_media_permission_callback";
        this.lEW = new Handler(Looper.getMainLooper());
        this.rp = new Handler(Looper.getMainLooper());
        this.zPa = true;
        this.cl = true;
        this.cL = true;
        this.IlO = "PL_sdk_playable_global_viewable";
        this.MY = "PL_sdk_page_screen_blank";
        this.EO = "PL_sdk_playable_destroy_analyze_summary";
        this.tV = "PL_sdk_playable_hardware_dialog_cancel";
        this.Cc = "PL_sdk_playable_hardware_dialog_setting";
        this.es = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.xF = null;
        this.AXM = "embeded_ad";
        this.oeT = true;
        this.vAh = true;
        this.kBB = false;
        this.pP = "";
        this.tl = 10L;
        this.OOq = 10L;
        this.wPn = 700;
        this.oc = 0L;
        this.vSq = 0L;
        this.dY = -1L;
        this.lMM = -1L;
        this.nvX = -1L;
        this.YA = -1L;
        this.mmj = -1L;
        this.DM = -1L;
        this.zLG = -1L;
        this.BS = "";
        this.ssS = "";
        this.gQ = "";
        this.HSR = "";
        this.AK = 0;
        this.quf = 0;
        this.uvo = false;
        this.KC = 0;
        this.Ea = -1;
        this.Dxv = 0;
        this.fdM = 0;
        this.hL = 0;
        this.Jz = null;
        this.wD = false;
        this.nm = 0;
        this.ii = 0;
        this.HTA = 0;
        this.Tx = 0;
        this.pFe = 0L;
        this.Hg = 0L;
        this.qvT = -2;
        this.ts = 0;
        this.zTS = 0;
        this.KT = 0;
        this.uI = new JSONObject();
        this.tf = new HashMap();
        this.tN = new JSONObject();
        this.BES = "";
        this.Aw = 0.0f;
        this.uF = 0.0f;
        this.ct = false;
        this.TU = false;
        this.hHv = false;
        this.LT = new ArrayList();
        this.QLG = true;
        this.Pbh = true;
        this.qIK = true;
        this.LO = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.xF.lEW.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) lEW.this.aa.get();
                    if (view == null) {
                        return;
                    }
                    lEW.this.MY(view);
                } catch (Throwable th) {
                    Bc.IlO("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.VFH = -1;
        this.qvT = i2;
        this.BO = IlO.LAND_PAGE;
        IlO(context, eo, ilO);
    }

    public static lEW IlO(Context context, @Nullable WebView webView, EO eo, com.bytedance.sdk.openadsdk.xF.IlO ilO) {
        if (eo == null || ilO == null) {
            return null;
        }
        if (webView == null) {
            return new lEW(context, 0, eo, ilO);
        }
        return new lEW(context, webView, eo, ilO, IlO.LAND_PAGE);
    }
}
