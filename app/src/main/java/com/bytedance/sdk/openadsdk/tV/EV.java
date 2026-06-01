package com.bytedance.sdk.openadsdk.tV;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.mlkit.common.MlKitException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private static final int[] EO = {10, 30, 50, 75, 100};
    private final AtomicInteger AK;
    private int AXM;
    private boolean BS;
    private final AtomicBoolean Bc;
    private long Cc;
    private boolean DM;
    private final AtomicBoolean DmF;
    private volatile long Dxv;
    private int EV;
    private volatile long Ea;
    private final AtomicInteger HSR;
    public vCE.IlO IlO;
    private String Jz;
    private int KC;
    AtomicBoolean MY;
    private final AtomicBoolean NV;
    private long OOq;
    private final AtomicInteger YA;
    private String bWL;
    private com.bytedance.sdk.openadsdk.xF.lEW cL;
    private boolean cl;
    private long dY;
    private final Context ea;
    private lEW es;
    private volatile long fdM;
    private volatile long gQ;
    private final AtomicBoolean hL;
    private String hp;
    private String ii;
    private int kBB;
    private final AtomicBoolean lEW;
    private boolean lMM;
    private WeakReference<WebView> mmj;
    private final AtomicBoolean nm;
    private final boolean nvX;
    private long oc;
    private long oeT;
    private final oeT pP;
    private final AtomicBoolean quf;
    private boolean rp;
    private NV ssS;
    private int tV;
    private String tl;
    private volatile int uvo;
    private long vAh;
    private int vCE;
    private long vSq;
    private long wD;
    private long wPn;
    private boolean xF;
    private com.bytedance.sdk.openadsdk.tV.tV.Cc zLG;
    private com.bytedance.sdk.openadsdk.core.widget.IlO.vCE zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO {
        private IlO() {
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i2 = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i2 = 100;
                } else if (iIntValue >= 0) {
                    i2 = iIntValue;
                }
            } catch (Throwable unused) {
            }
            EV.this.YA.set(i2);
        }
    }

    public EV(oeT oet, WebView webView, NV nv, int i2) {
        this(oet, webView);
        this.ssS = nv;
        this.KC = i2;
    }

    private boolean DmF() {
        oeT oet;
        return this.BS && (oet = this.pP) != null && oet.QNg();
    }

    private int NV() {
        WeakReference<WebView> weakReference = this.mmj;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null) {
                    if (webBackForwardListCopyBackForwardList.getCurrentIndex() == 0) {
                        return 1;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public void Bc() {
        if (this.dY == 0) {
            this.dY = System.currentTimeMillis();
        }
        this.OOq = System.currentTimeMillis();
        if ("landingpage".equals(this.tl) || "landingpage_endcard".equals(this.tl) || "landingpage_split_screen".equals(this.tl) || "landingpage_direct".equals(this.tl) || "aggregate_page".equals(this.tl)) {
            if (this.nm.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("landingStart", this.pP, this.ii);
            } else {
                com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("landingContinue", this.pP, this.ii);
            }
        }
        if (es.vCE(this.pP) || es.MY(this.pP)) {
            IlO(true, SystemClock.elapsedRealtime());
        }
    }

    public void lEW() {
        if (("landingpage".equals(this.tl) || "landingpage_endcard".equals(this.tl) || "landingpage_split_screen".equals(this.tl) || "landingpage_direct".equals(this.tl) || "aggregate_page".equals(this.tl) || "landingpage_split_ceiling".equals(this.tl)) && this.vCE == 2) {
            if (this.wPn > 0 || !EO()) {
                long jCurrentTimeMillis = System.currentTimeMillis() - Math.max(this.OOq, this.wPn);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.vCE);
                    jSONObject.put("max_scroll_percent", this.YA.get());
                    jSONObject.put("jump_times", this.HSR.getAndSet(0));
                    jSONObject.put("click_times", this.AK.getAndSet(0));
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                this.NV.set(true);
                IlO("stay_page", jSONObject, Math.min(jCurrentTimeMillis, TTAdConstant.AD_MAX_EVENT_TIME));
                com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("landingPause", this.pP, this.ii);
            }
        }
    }

    public void vCE() {
        if (DmF() && this.Dxv > 0 && this.fdM > 0 && !this.hL.getAndSet(true)) {
            EO.MY(this.fdM - this.Dxv, this.pP, this.Jz, (String) null);
        }
    }

    public void Cc() {
        if (DmF()) {
            this.Dxv = SystemClock.elapsedRealtime();
            vCE();
        }
    }

    public boolean EO() {
        return this.BS;
    }

    public com.bytedance.sdk.openadsdk.tV.tV.Cc MY() {
        return this.zLG;
    }

    public void tV() {
        if (DmF()) {
            this.Ea = SystemClock.elapsedRealtime();
            EO.IlO(this.pP, this.Jz);
        }
    }

    public void EO(boolean z2) {
        this.BS = z2;
    }

    public EV MY(boolean z2) {
        this.DM = z2;
        return this;
    }

    public EV(oeT oet, WebView webView) {
        this(oet, webView, false);
    }

    private String EO(String str) {
        return "javascript:".concat(String.valueOf(str));
    }

    public oeT IlO() {
        return this.pP;
    }

    public void MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Jz = str;
    }

    public EV(oeT oet, WebView webView, boolean z2) {
        this.tV = 0;
        this.Cc = -1L;
        this.vCE = 1;
        this.Bc = new AtomicBoolean(false);
        this.lEW = new AtomicBoolean(false);
        this.DmF = new AtomicBoolean(false);
        this.NV = new AtomicBoolean(false);
        this.EV = -1;
        this.xF = false;
        this.AXM = 0;
        this.MY = new AtomicBoolean(false);
        this.tl = "landingpage";
        this.OOq = 0L;
        this.wPn = 0L;
        this.oc = 0L;
        this.vSq = 0L;
        this.dY = 0L;
        this.lMM = false;
        this.nvX = false;
        this.YA = new AtomicInteger(0);
        this.DM = false;
        this.BS = false;
        this.gQ = 0L;
        this.HSR = new AtomicInteger(0);
        this.AK = new AtomicInteger(0);
        this.quf = new AtomicBoolean(false);
        this.uvo = 0;
        this.KC = -1;
        this.hL = new AtomicBoolean(false);
        this.nm = new AtomicBoolean(false);
        Context contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO();
        this.ea = contextIlO;
        this.pP = oet;
        if (webView == null) {
            return;
        }
        this.xF = z2;
        WeakReference<WebView> weakReference = new WeakReference<>(webView);
        this.mmj = weakReference;
        WebView webView2 = weakReference.get();
        if (webView2 == null) {
            return;
        }
        if (oet != null && oet.wD()) {
            com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = new com.bytedance.sdk.openadsdk.core.widget.IlO.vCE(webView2, oet, contextIlO, this.xF);
            this.zPa = vce;
            this.IlO = vce.EO();
        }
        if (oet != null && oet.nm() && com.bytedance.sdk.openadsdk.core.settings.hp.aP().KT()) {
            this.es = new lEW(oet, webView, this.xF);
        }
        if (webView instanceof com.bytedance.sdk.component.DmF.Cc) {
            this.wD = ((com.bytedance.sdk.component.DmF.Cc) webView2).IlO;
        } else {
            this.wD = System.currentTimeMillis();
        }
        try {
            webView2.addJavascriptInterface(new IlO(), "JS_LANDING_PAGE_LOG_OBJ");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("LandingPageLog", "addJavascriptInterface exception", e);
        }
        if (oet != null && oet.DYs() != null) {
            this.Cc = oet.DYs().optLong("page_id", -1L);
        }
        this.ii = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void IlO(boolean z2) {
        if (z2) {
            this.AXM = 1;
        }
    }

    public void tV(boolean z2) {
        WeakReference<WebView> weakReference = this.mmj;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.IlO("LandingPageLog", "removeJavascriptInterface exception", e);
            }
        }
        if (this.lEW.compareAndSet(false, true)) {
            IlO(z2, "1");
            if (this.DM) {
                EO.IlO(this.pP, this.tl, System.currentTimeMillis() - this.dY, this.KC, NV());
            }
        } else if (this.vCE == 2 && !this.NV.get()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.vCE);
                jSONObject.put("max_scroll_percent", this.YA.get());
                jSONObject.put("jump_times", this.HSR.getAndSet(0));
                jSONObject.put("click_times", this.AK.getAndSet(0));
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            IlO("stay_page", jSONObject, 0L);
        }
        if ("landingpage".equals(this.tl) || "landingpage_endcard".equals(this.tl) || "landingpage_split_screen".equals(this.tl) || "landingpage_direct".equals(this.tl) || "aggregate_page".equals(this.tl) || "landingpage_split_ceiling".equals(this.tl)) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("landingFinish", this.pP, this.ii);
        }
    }

    public void IlO(NV nv) {
        this.ssS = nv;
    }

    public void MY(WebView webView, String str, boolean z2) {
        lEW lew = this.es;
        if (lew == null || !z2) {
            return;
        }
        lew.IlO(webView, str);
    }

    public void IlO(long j) {
        this.wPn = j;
    }

    public void IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce != null) {
            vce.IlO(str);
        }
        lEW lew = this.es;
        if (lew != null) {
            lew.EO(str);
        }
        this.tl = str;
    }

    public void MY(int i2) {
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce == null || !this.cl) {
            return;
        }
        vce.IlO(i2);
    }

    public void IlO(int i2) {
        this.KC = i2;
    }

    public void IlO(com.bytedance.sdk.openadsdk.tV.tV.Cc cc) {
        this.zLG = cc;
    }

    public void IlO(com.bytedance.sdk.openadsdk.xF.lEW lew) {
        this.cL = lew;
    }

    public void IlO(WebView webView, int i2) {
        if (webView == null) {
            return;
        }
        if (this.gQ == 0) {
            this.gQ = SystemClock.elapsedRealtime();
        }
        if (this.oc == 0 && i2 > 0) {
            this.oc = System.currentTimeMillis();
        } else if (this.vSq == 0 && i2 == 100) {
            this.vSq = System.currentTimeMillis();
        }
        if (this.tV != EO.length && ("landingpage".equals(this.tl) || "landingpage_endcard".equals(this.tl) || "landingpage_split_screen".equals(this.tl) || "landingpage_direct".equals(this.tl) || "aggregate_page".equals(this.tl))) {
            int i8 = this.tV;
            while (true) {
                int[] iArr = EO;
                if (i8 >= iArr.length || i2 < iArr[this.tV]) {
                    break;
                }
                int i9 = i8 + 1;
                this.tV = i9;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", webView.getUrl());
                    long j = this.Cc;
                    if (j != -1) {
                        jSONObject.put("page_id", j);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("pct", iArr[i8]);
                } catch (Exception unused) {
                }
                IlO("progress_load_finish", jSONObject);
                i8 = i9;
            }
        }
        if (i2 == 100) {
            IlO(false, SystemClock.elapsedRealtime());
            IlO(webView.getUrl(), "progress", Math.min(this.vSq - this.oc, TTAdConstant.AD_MAX_EVENT_TIME));
        }
    }

    private void IlO(String str, String str2, long j) {
        if (this.DmF.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (str.length() > 200) {
                    int iIndexOf = str.indexOf(38, 200);
                    int i2 = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
                    if (iIndexOf == -1 || iIndexOf > 300) {
                        iIndexOf = str.indexOf(63);
                    }
                    if (iIndexOf != -1 && iIndexOf <= 300) {
                        i2 = iIndexOf;
                    }
                    str = str.substring(0, i2);
                }
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            IlO("load_finish_progress", jSONObject, j);
        }
    }

    public void IlO(WebView webView, String str, Bitmap bitmap, boolean z2, int i2) {
        this.cl = z2;
        this.kBB++;
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce != null && z2) {
            vce.MY(str);
            this.zPa.MY();
        }
        lEW lew = this.es;
        if (lew != null && z2) {
            lew.IlO(str, i2);
        }
        WeakReference<WebView> weakReference = this.mmj;
        WebView webView2 = weakReference != null ? weakReference.get() : null;
        if (webView2 != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView2.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() > this.uvo) {
                    this.HSR.incrementAndGet();
                }
                this.uvo = webBackForwardListCopyBackForwardList.getCurrentIndex();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.IlO("LandingPageLog", "copyBackForwardList exception", e);
            }
        }
        if (this.gQ == 0) {
            this.gQ = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.zLG;
        if (cc != null) {
            cc.Cc();
        }
        if (this.Bc.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i8 = this.KC;
                if (i8 >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i8));
                }
            } catch (Exception unused) {
            }
            IlO("load_start", jSONObject);
        }
    }

    public void IlO(WebView webView, String str, boolean z2) {
        IlO(false, SystemClock.elapsedRealtime());
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce != null && z2) {
            vce.IlO();
        }
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.zLG;
        if (cc != null) {
            cc.vCE();
        }
        lEW lew = this.es;
        if (lew != null && z2) {
            lew.IlO(str);
        }
        if (webView != null && !this.lMM && this.DM) {
            this.lMM = true;
            com.bytedance.sdk.component.utils.bWL.IlO(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.lEW.compareAndSet(false, true)) {
            if (this.vCE != 3) {
                this.vCE = 2;
            }
            this.OOq = System.currentTimeMillis();
            boolean z7 = this.vCE == 2;
            int iNV = NV();
            if (z7) {
                long j = this.vSq - this.oc;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", this.EV);
                    jSONObject.put("error_msg", this.hp);
                    jSONObject.put("error_url", this.bWL);
                    int i2 = this.KC;
                    if (i2 >= 0) {
                        jSONObject.put("preload_status", i2);
                    }
                    jSONObject.put("first_page", iNV);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("url", this.pP.pFe());
                    jSONObject.put("preload_h5_type", this.pP.eVC());
                } catch (Exception unused) {
                }
                IlO(z2, "0");
                long jMin = Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME);
                IlO("load_finish", jSONObject, jMin);
                if (DmF()) {
                    this.fdM = SystemClock.elapsedRealtime();
                    vCE();
                    EO.IlO(this.pP, this.Jz, this.fdM - this.Ea);
                }
                IlO(str, "load_finish", jMin);
                NV nv = this.ssS;
                if (nv != null) {
                    nv.IlO(iNV);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.EV);
                jSONObject2.put("error_msg", this.hp);
                jSONObject2.put("error_url", this.bWL);
                jSONObject2.put("first_page", iNV);
                int i8 = this.KC;
                if (i8 >= 0) {
                    jSONObject2.put("preload_status", i8);
                }
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put("url", this.pP.pFe());
                jSONObject2.put("preload_h5_type", this.pP.eVC());
            } catch (Exception unused2) {
            }
            IlO(z2, "2");
            IlO("load_fail", jSONObject2);
            if (DmF()) {
                EO.IlO(this.pP, this.Jz, SystemClock.elapsedRealtime() - this.Ea, this.EV, this.hp, this.bWL);
            }
            if (this.rp) {
                jSONObject2.remove("render_type");
                jSONObject2.remove("render_type_2");
                IlO("load_fail_main", jSONObject2);
            }
        }
    }

    public void IlO(WebView webView, int i2, String str, String str2, String str3, boolean z2) {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.zLG;
        if (cc != null) {
            cc.IlO((JSONObject) null);
        }
        if ((str3 == null || !str3.startsWith("image")) && this.vCE != 2) {
            this.vCE = 3;
        }
        this.EV = i2;
        this.hp = str;
        this.bWL = str2;
        this.rp = z2;
    }

    public void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        int iJz;
        Bitmap bitmapIlO;
        oeT oet;
        if ((!"landingpage".equals(this.tl) && !"landingpage_endcard".equals(this.tl) && !"landingpage_split_screen".equals(this.tl) && !"landingpage_direct".equals(this.tl) && !"aggregate_page".equals(this.tl)) || (iJz = com.bytedance.sdk.openadsdk.core.cl.tV().Jz()) == 0 || new Random().nextInt(100) + 1 > iJz || vce == null || vce.getWebView() == null || vce.getVisibility() != 0 || (bitmapIlO = BS.IlO(vce)) == null || (oet = this.pP) == null) {
            return;
        }
        BS.IlO(oet, this.tl, "landing_page_blank", bitmapIlO, vce.getUrl(), this.Cc);
    }

    private void IlO(String str, JSONObject jSONObject) {
        IlO(str, jSONObject, -1L);
    }

    private void IlO(final String str, final JSONObject jSONObject, final long j) {
        if (!this.DM || this.pP == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.xF.lEW lew = this.cL;
        final int iMmj = lew != null ? lew.mmj() : -1;
        EO.IlO(System.currentTimeMillis(), this.pP, this.tl, str, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EV.1
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject2 = null;
                if (jSONObject != null) {
                    try {
                        boolean zMY = OOq.MY(EV.this.pP);
                        jSONObject.put("is_playable", zMY ? 1 : 0);
                        jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(EV.this.pP) ? 1 : 0);
                        if (zMY && ("load_finish".equals(str) || "load_fail".equals(str))) {
                            jSONObject.put("playable_has_show", iMmj);
                        }
                        if (com.bytedance.sdk.openadsdk.hp.IlO.EO(EV.this.pP)) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("is_lp_pre_render", EV.this.AXM);
                            jSONObject.put("pag_json_data", jSONObject3.toString());
                        }
                        if ("stay_page".equals(str)) {
                            jSONObject.put("first_page", EV.this.kBB > 1 ? 0 : 1);
                        }
                    } catch (JSONException unused) {
                    }
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put("ad_extra_data", jSONObject.toString());
                            long j3 = j;
                            if (j3 > 0) {
                                jSONObject4.put("duration", j3);
                            }
                        } catch (JSONException unused2) {
                        }
                        jSONObject2 = jSONObject4;
                    } catch (JSONException unused3) {
                    }
                }
                String unused4 = EV.this.tl;
                return jSONObject2;
            }
        });
    }

    public void IlO(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce != null && this.cl) {
            vce.IlO(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.gQ != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.AK.incrementAndGet();
                if (this.quf.getAndSet(true)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.pP.pFe());
                } catch (JSONException unused) {
                }
                IlO("click_time", jSONObject, Math.max(SystemClock.elapsedRealtime() - this.gQ, 0L));
            }
        }
    }

    public void IlO(String str, boolean z2) {
        com.bytedance.sdk.openadsdk.core.widget.IlO.vCE vce = this.zPa;
        if (vce != null && z2) {
            vce.EO(str);
        }
        lEW lew = this.es;
        if (lew == null || !z2) {
            return;
        }
        lew.MY(str);
    }

    private void IlO(boolean z2, final String str) {
        if (z2) {
            final int iNV = NV();
            EO.IlO(new com.bytedance.sdk.component.lEW.lEW("sendPrefLog") { // from class: com.bytedance.sdk.openadsdk.tV.EV.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.openadsdk.core.settings.Bc bcVAh = com.bytedance.sdk.openadsdk.core.cl.tV().vAh();
                        boolean zIlO = EV.this.IlO(bcVAh, str);
                        if (zIlO) {
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.Bc.MY)) {
                                EV.this.IlO(iNV, str);
                                return;
                            }
                            if (TextUtils.isEmpty(bcVAh.EO) || !zIlO) {
                                return;
                            }
                            String str2 = bcVAh.EO;
                            com.bytedance.sdk.component.Bc.MY.MY myEO = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().EO();
                            myEO.MY(str2);
                            HashMap map = new HashMap();
                            map.put("content-type", "application/json; charset=utf-8");
                            myEO.tV(map);
                            myEO.IlO(9);
                            myEO.IlO("sendPrefLog");
                            myEO.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EV.2.1
                                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                                }

                                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                                    try {
                                        com.bytedance.sdk.openadsdk.core.settings.Bc.MY = my.tV();
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        EV.this.IlO(iNV, str);
                                    } catch (Exception e) {
                                        com.bytedance.sdk.component.utils.oeT.IlO("LandingPageLog", "TTWebViewClient : onPageFinished", e);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2, String str) {
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.Bc.MY)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.settings.Bc.MY);
            jSONObject.putOpt("cid", IlO().ED());
            jSONObject.putOpt("ad_id", IlO().ED());
            jSONObject.put("log_extra", IlO().KT());
            zLG.IlO(sb, "\"/** adInfo **/\"", jSONObject.toString());
            zLG.IlO(sb, "\"/** first_page **/\"", String.valueOf(i2));
            zLG.IlO(sb, "\"/** ix_to_externalurl **/\"", this.Cc != -1 ? "1" : "0");
            zLG.IlO(sb, "\"/** preload_status **/\"", this.KC == 2 ? "2" : "0");
            zLG.IlO(sb, "\"/** scene_state **/\"", str);
            zLG.IlO(sb, "\"/** web_init_time **/\"", String.valueOf(this.wD));
            zLG.IlO(sb, "\"/** channel_name **/\"", "\"" + IlO().tU() + "\"");
            zLG.IlO(sb, "\"/** session_id **/\"", "\"" + UUID.randomUUID().toString() + "\"");
            zLG.IlO(sb, "\"/** web_url **/\"", "\"" + IlO().pFe() + "\"");
            String string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            final String strEO = EO(string);
            WeakReference<WebView> weakReference = this.mmj;
            final WebView webView = weakReference != null ? weakReference.get() : null;
            if (TextUtils.isEmpty(strEO) || webView == null) {
                return;
            }
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.tV.EV.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.bWL.IlO(webView, strEO);
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(com.bytedance.sdk.openadsdk.core.settings.Bc bc, String str) {
        str.getClass();
        switch (str) {
            case "0":
                return bc.tV;
            case "1":
                return bc.Cc;
            case "2":
                return bc.vCE;
            default:
                return false;
        }
    }

    public void IlO(boolean z2, long j) {
        if (z2) {
            this.oeT = j;
        } else {
            this.vAh = j;
        }
        if (this.oeT <= 0 || this.vAh <= 0 || !this.cl || !this.MY.compareAndSet(false, true)) {
            return;
        }
        IlO(this.pP, this.tl, this.vAh - this.oeT, this.AXM);
    }

    public static void IlO(final oeT oet, final String str, final long j, final int i2) {
        EO.IlO(System.currentTimeMillis(), oet, str, "lp_feeling_duration", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.EV.4
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_lp_pre_render", i2);
                    jSONObject3.put("meta_pre_render", oet.CuC() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.model.cl clVarZPa = oet.zPa();
                    if (clVarZPa == null) {
                        clVarZPa = new com.bytedance.sdk.openadsdk.core.model.cl();
                    }
                    jSONObject3.put("pre_render_status", clVarZPa.EO());
                    jSONObject3.put("pre_render_use_gecko", clVarZPa.MY());
                    jSONObject3.put("pre_render_add_type", clVarZPa.IlO());
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }
}
