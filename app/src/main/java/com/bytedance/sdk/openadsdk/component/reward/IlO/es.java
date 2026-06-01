package com.bytedance.sdk.openadsdk.component.reward.IlO;

import a1.a;
import android.R;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.adexpress.tV.DmF;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.nvX;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.core.widget.IlO.vCE;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.C2318f4;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements com.bytedance.sdk.openadsdk.rp.DmF {
    private boolean AXM;
    private boolean BS;
    com.bytedance.sdk.openadsdk.tV.EV Cc;
    private String Dxv;

    @NonNull
    private final oeT EV;
    private boolean HSR;
    private com.bytedance.sdk.openadsdk.common.tV HTA;
    private boolean Hg;
    vSq IlO;
    private int KC;
    vSq MY;
    private float OOq;
    private boolean Tx;
    private boolean YA;
    private final boolean bWL;
    private com.bytedance.sdk.component.DmF.vCE cL;
    private com.bytedance.sdk.component.DmF.vCE cl;
    private int ea;
    private ILoader fdM;
    private boolean gQ;
    private int hp;
    private vCE.IlO ii;
    private View kBB;
    protected com.bytedance.sdk.openadsdk.tV.tV.Cc lEW;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO mmj;
    private boolean nm;
    private com.bytedance.sdk.openadsdk.common.hp nvX;
    private boolean oeT;
    private String pFe;
    private View pP;
    private long quf;
    private final String rp;
    private boolean ssS;
    protected String tV;
    private float tl;
    private boolean vAh;
    private long wPn;
    private com.bytedance.sdk.openadsdk.core.widget.IlO.Cc zLG;
    private int zPa;
    protected boolean EO = true;
    private boolean es = false;
    private final AtomicBoolean xF = new AtomicBoolean(true);
    int vCE = 0;
    String Bc = "";
    boolean DmF = false;
    private SparseArray<EO.IlO> oc = new SparseArray<>();
    private boolean vSq = true;
    private float dY = -1.0f;
    private float lMM = -1.0f;
    private boolean DM = false;
    private long AK = -1;
    private volatile int uvo = 0;
    private int Ea = -1;
    private volatile int hL = 0;
    private volatile int Jz = 0;
    private long wD = 0;
    public boolean NV = false;
    private int qz = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements com.bytedance.sdk.openadsdk.rp.EV {
        private final com.bytedance.sdk.component.DmF.vCE IlO;

        @Override // com.bytedance.sdk.openadsdk.rp.EV
        public void IlO() {
            com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
            if (vce == null) {
                return;
            }
            vce.ea();
        }

        @Override // com.bytedance.sdk.openadsdk.rp.EV
        public void MY() {
            com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
            if (vce == null) {
                return;
            }
            vce.cL();
        }

        private EO(com.bytedance.sdk.component.DmF.vCE vce) {
            this.IlO = vce;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements com.bytedance.sdk.openadsdk.rp.IlO {
        private final View IlO;

        public MY(View view) {
            this.IlO = view;
        }

        @Override // com.bytedance.sdk.openadsdk.rp.IlO
        public int IlO() {
            View view = this.IlO;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO()) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.rp.IlO
        public int MY() {
            View view = this.IlO;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO()) : measuredWidth;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface tV {
        void IlO(WebView webView, int i2);

        void IlO(WebView webView, String str);

        void IlO(WebView webView, String str, Bitmap bitmap);
    }

    public es(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.mmj = ilO;
        this.EV = ilO.MY;
        this.rp = ilO.Cc;
        this.bWL = ilO.tV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        this.BS = true;
        this.Hg = false;
        this.mmj.HSR.removeMessages(600);
        this.mmj.HSR.removeMessages(700);
        this.mmj.HSR.removeMessages(900);
        this.mmj.YA.tV(false);
        this.mmj.es.set(true);
        this.mmj.qz.ea();
        this.EV.NLy();
        if (this.EV.NLy() || !zLG.lEW(OOq.IlO(this.EV))) {
            return;
        }
        View viewNV = this.mmj.DM.NV();
        View.OnClickListener onClickListener = (View.OnClickListener) viewNV.getTag(viewNV.getId());
        if (onClickListener != null) {
            IlO ilO = new IlO(this.mmj, viewNV, onClickListener);
            viewNV.setOnClickListener(ilO);
            viewNV.setOnTouchListener(ilO);
        }
    }

    public static /* synthetic */ int bWL(es esVar) {
        int i2 = esVar.hL;
        esVar.hL = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int cl(es esVar) {
        int i2 = esVar.uvo;
        esVar.uvo = i2 + 1;
        return i2;
    }

    private void quf() {
        this.MY.IlO("showPlayableEndCardOverlay", (JSONObject) null);
        this.mmj.HSR.sendEmptyMessageDelayed(600, 1000L);
        this.mmj.HSR.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.5
            @Override // java.lang.Runnable
            public void run() {
                es.this.AK();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.mmj.ts;
        if (bwl != null) {
            bwl.IlO(0L);
        }
    }

    private com.bytedance.sdk.openadsdk.tV.tV.Cc uvo() {
        return new com.bytedance.sdk.openadsdk.tV.cl(OOq.Bc(this.EV) ? 3 : 2, this.bWL ? "rewarded_video" : "fullscreen_interstitial_ad", this.EV);
    }

    public static /* synthetic */ int zPa(es esVar) {
        int i2 = esVar.Jz;
        esVar.Jz = i2 + 1;
        return i2;
    }

    public boolean BS() {
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        return vce == null || vce.getWebView() == null;
    }

    public boolean DM() {
        return this.AXM && this.xF.get();
    }

    public boolean HSR() {
        return this.NV;
    }

    public void YA() {
        BS.IlO((View) this.cl, 0);
        BS.IlO((View) this.cL, 8);
    }

    public boolean gQ() {
        return this.BS;
    }

    public void mmj() {
        BS.IlO((View) this.cL, 8);
    }

    public boolean nvX() {
        vSq vsq = this.IlO;
        if (vsq == null) {
            return false;
        }
        return vsq.DmF();
    }

    public void ssS() {
        com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
        if (ev != null) {
            ev.Cc();
        }
    }

    public boolean zLG() {
        return this.Hg;
    }

    public void AXM() {
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        if (vce != null) {
            vce.ea();
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = this.cL;
        if (vce2 != null) {
            vce2.ea();
        }
        if (this.AK > 0) {
            this.quf = (SystemClock.elapsedRealtime() - this.AK) + this.quf;
            this.AK = 0L;
        }
        vSq vsq = this.IlO;
        if (vsq != null) {
            vsq.MY(false);
            MY(this.IlO, false);
            IlO(this.IlO, true, false);
        }
        if (this.MY == null || !OOq.lEW(this.EV)) {
            return;
        }
        this.MY.MY(false);
        MY(this.MY, false);
        IlO(this.MY, true, false);
    }

    public void DmF() {
        this.IlO.IlO("showPlayableEndCardOverlay", (JSONObject) null);
        this.mmj.HSR.sendEmptyMessageDelayed(600, 1000L);
        this.mmj.HSR.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.6
            @Override // java.lang.Runnable
            public void run() {
                es.this.AK();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.bWL bwl = this.mmj.ts;
        if (bwl != null) {
            bwl.IlO(0L);
        }
    }

    public com.bytedance.sdk.component.DmF.vCE EV() {
        return this.cL;
    }

    public com.bytedance.sdk.component.DmF.vCE NV() {
        return this.cl;
    }

    public void OOq() {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc != null) {
            cc.lEW();
        }
    }

    public com.bytedance.sdk.openadsdk.tV.EV bWL() {
        return this.Cc;
    }

    public boolean cL() {
        return this.xF.get();
    }

    public boolean cl() {
        String str = this.tV;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void dY() {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc != null) {
            cc.EO();
            this.lEW.tV();
        }
    }

    public void ea() {
        c cVarFdM;
        com.bytedance.sdk.openadsdk.activity.vCE vce;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.mmj;
        if (ilO.gm && (vce = ilO.ED) != null && vce.kBB()) {
            oeT oet = this.EV;
            if (oet != null && oet.ie() != null) {
                this.tV = this.EV.ie().IlO();
            }
        } else if (OOq.Cc(this.EV)) {
            oeT oet2 = this.EV;
            if (oet2 != null && (cVarFdM = oet2.fdM()) != null) {
                this.tV = cVarFdM.h;
            }
        } else {
            this.tV = OOq.hp(this.EV);
        }
        String strIlO = IlO(this.tV, this.EV, this.hp, this.zPa, this.ea);
        this.tV = strIlO;
        if (TextUtils.isEmpty(strIlO)) {
            return;
        }
        this.ssS = this.tV.contains("use_second_endcard=1");
    }

    public boolean es() {
        return this.AXM;
    }

    public vSq hp() {
        return this.MY;
    }

    public String kBB() {
        return this.Bc;
    }

    public void lMM() {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc != null) {
            cc.NV();
        }
    }

    public void oc() {
        com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
        if (ev != null) {
            ev.IlO(System.currentTimeMillis());
        }
    }

    public void oeT() {
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        if (vce != null) {
            vce.hp();
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = this.cL;
        if (vce2 != null) {
            vce2.hp();
        }
        if (this.AK == 0) {
            this.AK = SystemClock.elapsedRealtime();
        }
        vSq vsq = this.IlO;
        if (vsq != null) {
            vsq.EV();
            com.bytedance.sdk.component.DmF.vCE vce3 = this.cl;
            if (vce3 != null) {
                if (vce3.getVisibility() == 0) {
                    this.IlO.MY(true);
                    MY(this.IlO, true);
                    IlO(this.IlO, false, true);
                    if (OOq.NV(this.EV) && !this.BS && this.mmj.MY.NLy()) {
                        DmF();
                    }
                } else {
                    this.IlO.MY(false);
                    MY(this.IlO, false);
                    IlO(this.IlO, true, false);
                }
            }
        }
        if (this.MY != null && OOq.lEW(this.EV)) {
            this.MY.EV();
            com.bytedance.sdk.component.DmF.vCE vce4 = this.cL;
            if (vce4 != null) {
                if (vce4.getVisibility() == 0) {
                    this.MY.MY(true);
                    MY(this.MY, true);
                    IlO(this.MY, false, true);
                    if (!this.BS && this.mmj.MY.NLy()) {
                        quf();
                    }
                } else {
                    this.MY.MY(false);
                    MY(this.MY, false);
                    IlO(this.MY, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
        if (ev != null) {
            ev.Bc();
        }
    }

    public String pP() {
        return this.tV;
    }

    public vSq rp() {
        return this.IlO;
    }

    public boolean tl() {
        return oeT.EO(this.EV) ? this.ssS && !this.gQ && this.mmj.nvX.rp() : this.ssS && !this.gQ && this.xF.get() && this.AXM;
    }

    public int vAh() {
        return this.vCE;
    }

    public boolean vSq() {
        return this.DmF;
    }

    public void wPn() {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc != null) {
            cc.Bc();
        }
    }

    public void xF() {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc != null) {
            cc.DmF();
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
        if (ev != null) {
            ev.lEW();
        }
    }

    public void zPa() {
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        if (vce != null) {
            nvX.IlO(vce.getWebView());
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = this.cL;
        if (vce2 != null) {
            nvX.IlO(vce2.getWebView());
        }
        long j = this.quf;
        if (j > 0) {
            if (this.AK > 0) {
                this.quf = (SystemClock.elapsedRealtime() - this.AK) + j;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("endcard_overlay_render_type", oeT.EO(this.EV) ? 7 : 0);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.mmj.MY, this.rp, "second_endcard_duration", jSONObject, this.quf);
        }
        this.cl = null;
        if (this.lEW != null && !com.bytedance.sdk.openadsdk.core.model.es.tV(this.EV) && !com.bytedance.sdk.openadsdk.core.model.es.Cc(this.EV) && !oeT.EO(this.EV)) {
            this.lEW.IlO(true);
            this.lEW.rp();
        }
        vSq vsq = this.IlO;
        if (vsq != null) {
            vsq.rp();
        }
        vSq vsq2 = this.MY;
        if (vsq2 != null) {
            vsq2.rp();
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
        if (ev != null) {
            ev.tV(this.EV.AK() || OOq.Bc(this.EV));
        }
        DeviceUtils.AudioInfoReceiver.MY(this);
    }

    public void Bc() {
        c cVarFdM = this.EV.fdM();
        if (cVarFdM == null) {
            return;
        }
        String str = cVarFdM.h;
        this.pFe = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.pFe = IlO(this.pFe, this.EV, this.hp, this.zPa, this.ea);
        this.cL.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO(), this.MY, this.EV.ED(), this.Cc, this.EV.AK() || OOq.Bc(this.EV)) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                com.bytedance.sdk.openadsdk.tV.tV.Cc cc = es.this.lEW;
                if (cc != null) {
                    cc.vCE();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                com.bytedance.sdk.openadsdk.tV.tV.Cc cc = es.this.lEW;
                if (cc != null) {
                    cc.Cc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str2, String str3) {
                if (es.this.IlO(str3)) {
                    return;
                }
                es.this.oeT = false;
                es esVar = es.this;
                esVar.vCE = i2;
                esVar.Bc = str2;
                if (esVar.lEW != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i2);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str2);
                        es.this.lEW.IlO(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i2, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    es.this.oeT = false;
                    if (webResourceResponse != null) {
                        es.this.vCE = webResourceResponse.getStatusCode();
                        es.this.Bc = "onReceivedHttpError";
                    }
                }
                if (es.this.lEW != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        es.this.lEW.IlO(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !es.this.IlO(webResourceRequest.getUrl().toString())) {
                    es.this.oeT = false;
                    if (es.this.lEW != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            es.this.lEW.IlO(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        es.this.vCE = webResourceError.getErrorCode();
                        es.this.Bc = String.valueOf(webResourceError.getDescription());
                    }
                    if (webResourceRequest == null) {
                        return;
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }
        });
        this.cL.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.MY, this.Cc) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                if (!es.this.mmj.Bc || es.this.mmj.pFe == null) {
                    return;
                }
                es.this.mmj.pFe.IlO(webView, i2, es.this.ii);
            }
        });
        com.bytedance.sdk.openadsdk.utils.oeT.IlO(this.cL, this.pFe);
        this.oeT = true;
    }

    public void Cc() {
        if (OOq.Cc(this.EV)) {
            return;
        }
        vCE();
    }

    public void lEW() {
        if (this.cl == null) {
            return;
        }
        this.xF.set(this.oeT);
        if (this.cL.getVisibility() == 0 && this.oeT) {
            quf();
            return;
        }
        this.mmj.YA.EO(false);
        this.mmj.pP.Bc(lEW.EO);
        IlO(this.IlO, true, false);
        MY(this.IlO, false);
        IlO(this.IlO, false);
        this.cl.zPa();
        if (this.oeT) {
            this.cL.setVisibility(0);
            IlO(this.MY, this.mmj.uvo, true);
            MY(this.MY, true);
            IlO(this.MY, true);
            this.mmj.HSR.removeMessages(600);
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.mmj;
            if (!ilO.mmj.EO(ilO.qz)) {
                this.mmj.qz.kBB();
            }
        } else {
            if (this.mmj.pP.IlO()) {
                this.mmj.pP.IlO(5);
            }
            this.mmj.mmj.tV();
            this.mmj.ts.IlO(r0.lEW);
        }
        this.Hg = true;
    }

    public void vCE() {
        if (TextUtils.isEmpty(oeT.IlO(this.mmj.gQ, this.EV))) {
            oeT oet = this.EV;
            if (oet != null && !oet.QNg() && this.fdM == null && cl()) {
                this.Dxv = this.EV.tU();
                this.fdM = com.bytedance.sdk.openadsdk.Bc.MY.IlO().MY();
                int iIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(this.fdM, this.Dxv);
                this.KC = iIlO;
                this.Ea = iIlO > 0 ? 2 : 0;
                if (!TextUtils.isEmpty(this.Dxv)) {
                    com.bytedance.sdk.openadsdk.tV.EV ev = this.Cc;
                    if (ev != null) {
                        ev.IlO(this.Ea);
                    }
                    EO.IlO.IlO(this.wD, this.EV, "landingpage_endcard", this.fdM, this.Dxv);
                }
            }
            if ((TextUtils.isEmpty(this.tV) || !this.tV.contains("play.google.com/store")) && !com.bytedance.sdk.openadsdk.core.model.es.vCE(this.EV) && !com.bytedance.sdk.openadsdk.core.model.es.Cc(this.EV)) {
                Log.d("TTAD.RFWVM", "preLoadEndCardForce: return mShouldPreloadEndCard " + this.EO + ",webViewIsLoading " + this.Tx);
                if (this.EO) {
                    boolean z2 = this.mmj.gm;
                    if (this.cl != null && ((z2 || !TextUtils.isEmpty(this.tV)) && oeT.MY(this.EV))) {
                        if (this.Tx) {
                            return;
                        }
                        String strR = a.r(new StringBuilder(), this.tV, "&is_pre_render=1");
                        com.bytedance.sdk.openadsdk.tV.EV ev2 = this.Cc;
                        if (ev2 != null) {
                            ev2.tV();
                        }
                        if (OOq.Bc(this.EV)) {
                            com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().MY(this.EV);
                        }
                        com.bytedance.sdk.openadsdk.utils.oeT.IlO(this.cl, strR);
                        this.mmj.pP.IlO(strR);
                        this.Tx = true;
                        return;
                    }
                    if (oeT.EO(this.EV)) {
                        this.mmj.nvX.EO();
                        return;
                    }
                    return;
                }
                return;
            }
            this.DmF = true;
        }
    }

    public boolean EO() {
        return this.HSR;
    }

    public void MY() {
        com.bytedance.sdk.openadsdk.common.hp hpVar;
        this.kBB = this.mmj.BS.findViewById(R.id.content);
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.mmj;
        boolean z2 = ilO.Bc;
        this.YA = z2;
        if (z2 && (hpVar = this.nvX) != null) {
            this.cl = hpVar.tV();
        } else {
            com.bytedance.sdk.component.DmF.vCE vce = (com.bytedance.sdk.component.DmF.vCE) ilO.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.bWL);
            this.cl = vce;
            if (vce != null && oeT.MY(this.EV)) {
                this.cl.Cc();
            } else {
                BS.IlO((View) this.cl, 8);
            }
        }
        com.bytedance.sdk.component.DmF.vCE vce2 = (com.bytedance.sdk.component.DmF.vCE) this.mmj.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.zPa);
        this.cL = vce2;
        if (vce2 != null && OOq.Bc(this.EV) && OOq.lEW(this.EV)) {
            this.cL.Cc();
            this.cL.setDisplayZoomControls(false);
        } else {
            BS.IlO((View) this.cL, 8);
        }
        com.bytedance.sdk.component.DmF.vCE vce3 = this.cl;
        if (vce3 != null) {
            vce3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (es.this.cl == null || es.this.cl.getViewTreeObserver() == null) {
                        return;
                    }
                    es.this.cl.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = es.this.cl.getMeasuredWidth();
                    int measuredHeight = es.this.cl.getMeasuredHeight();
                    if (es.this.cl.getVisibility() == 0) {
                        es.this.IlO(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        com.bytedance.sdk.component.DmF.vCE vce4 = this.cL;
        if (vce4 != null) {
            vce4.setLandingPage(true);
            this.cL.setTag(OOq.Bc(this.EV) ? this.rp : "landingpage_endcard");
            this.cL.setWebViewClient(new vCE.IlO());
            this.cL.setMaterialMeta(this.EV.Ct());
        }
    }

    public boolean tV() {
        return this.gQ;
    }

    public void Cc(boolean z2) {
        if (this.IlO == null || this.mmj.BS.isFinishing()) {
            return;
        }
        this.mmj.pP.Cc(z2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            this.IlO.IlO("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void EO(boolean z2) {
        MY(this.IlO, z2);
    }

    public void tV(boolean z2) {
        if (OOq.MY(this.EV)) {
            return;
        }
        Cc(z2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends com.bytedance.sdk.openadsdk.core.MY.IlO implements MY.IlO {
        private final View.OnClickListener EO;
        private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO IlO;
        private final View MY;

        public IlO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO, View view, View.OnClickListener onClickListener) {
            super(ilO.BS, ilO.MY, ilO.Cc, ilO.tV ? 7 : 5);
            this.IlO = ilO;
            this.MY = view;
            this.EO = onClickListener;
            HashMap map = new HashMap();
            map.put("close_auto_click", Boolean.TRUE);
            map.put("click_scence", 2);
            IlO(map);
            IlO(ilO.kBB.EO());
            IlO(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
        public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
            if (!((com.bytedance.sdk.openadsdk.core.MY.MY) this).vCE.NLy()) {
                super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
                this.IlO.ssS.c_();
            } else {
                this.EO.onClick(view);
                this.MY.setOnTouchListener(null);
                this.MY.setOnClickListener(this.EO);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
        public void IlO(View view, int i2) {
            this.MY.setOnTouchListener(null);
            this.MY.setOnClickListener(this.EO);
        }
    }

    public void IlO() {
        if (this.vAh) {
            return;
        }
        this.vAh = true;
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.mmj;
        this.hp = ilO.fdM;
        this.ea = ilO.Jz;
        this.zPa = ilO.wD;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        MY();
        this.wD = SystemClock.elapsedRealtime() - jElapsedRealtime;
    }

    public void Bc(boolean z2) {
        this.Hg = z2;
    }

    public void IlO(String str, final com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        IlO(str, new tV() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.12
            @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.es.tV
            public void IlO(WebView webView, String str2) {
                if (es.this.mmj.BS.isFinishing()) {
                    return;
                }
                es.this.mmj.pP.MY(es.this.cL());
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.es.tV
            public void IlO(WebView webView, String str2, Bitmap bitmap) {
                if (es.this.DM || !OOq.cL(es.this.mmj.MY)) {
                    return;
                }
                es.this.DM = true;
                es.this.mmj.pP.IlO(es.this.mmj.vCE, es.this.mmj.MY, es.this.mmj.MY.EJ());
                if (!OOq.lEW(es.this.EV)) {
                    es.this.mmj.HSR.sendEmptyMessageDelayed(600, es.this.mmj.pP.DmF() * 1000);
                }
                es.this.mmj.pP.NV();
                es.this.mmj.ssS.EV();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.es.tV
            public void IlO(WebView webView, int i2) {
                try {
                    if (!OOq.cL(es.this.mmj.MY) || !es.this.mmj.MY.VFH() || es.this.mmj.BS.isFinishing()) {
                        if (!es.this.mmj.Bc || es.this.mmj.pFe == null) {
                            return;
                        }
                        es.this.mmj.pFe.IlO(webView, i2, es.this.ii);
                        return;
                    }
                    es.this.mmj.pP.EO(i2);
                } catch (Exception unused) {
                }
            }
        });
        if (OOq.cL(this.mmj.MY)) {
            IlO(this.cL);
            this.mmj.pP.IlO(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.13
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    es.this.mmj.kBB.MY();
                    com.bytedance.sdk.openadsdk.core.rp.tV.MY my2 = my;
                    if (my2 != null) {
                        my2.tV();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.mmj;
        ilO.pP.EO(ilO.HTA);
        IlO(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                es.this.mmj.kBB.MY();
                com.bytedance.sdk.openadsdk.core.rp.tV.MY my2 = my;
                if (my2 != null) {
                    my2.tV();
                }
            }
        });
    }

    public void IlO(com.bytedance.sdk.openadsdk.rp.vCE vce, String str, final com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        if (this.cl == null) {
            return;
        }
        HashMap map = new HashMap();
        if (OOq.Bc(this.EV)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 2);
        }
        this.lEW = uvo();
        vSq vsq = new vSq(this.mmj.BS);
        this.IlO = vsq;
        vsq.IlO(this.mmj.ssS);
        String strTcT = this.EV.tcT();
        this.IlO.MY(this.cl).IlO(this.EV).IlO(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.EV)).EO(this.EV.ED()).tV(this.EV.KT()).MY(this.EV.EJ() ? 7 : 5).IlO(new MY(this.cl)).Cc(strTcT).IlO(this.cl).MY(cl() ? "landingpage_endcard" : str).IlO(map).IlO(this.lEW).IlO(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
            public void IlO() {
                if (es.this.zLG != null) {
                    es.this.zLG.EO();
                }
                com.bytedance.sdk.openadsdk.core.rp.tV.MY my2 = my;
                if (my2 != null) {
                    my2.tV();
                }
            }
        }).IlO(new vSq.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.15
            @Override // com.bytedance.sdk.openadsdk.core.vSq.IlO
            public void IlO() {
                es.this.AK();
            }
        });
        HashMap map2 = new HashMap();
        if (OOq.lEW(this.EV)) {
            map2.put("click_scence", 2);
        }
        vSq vsq2 = new vSq(this.mmj.BS);
        this.MY = vsq2;
        vsq2.IlO(this.mmj.ssS);
        vSq vsqCc = this.MY.MY(this.cL).IlO(this.EV).IlO(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.EV)).EO(this.EV.ED()).tV(this.EV.KT()).MY(this.EV.EJ() ? 7 : 5).IlO(new MY(this.cL)).IlO(this.cL).Cc(strTcT);
        if (cl()) {
            str = "landingpage_endcard";
        }
        vsqCc.MY(str).IlO(map2).IlO(this.lEW).IlO(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
            public void IlO() {
                if (es.this.zLG != null) {
                    es.this.zLG.EO();
                }
            }
        }).IlO(new vSq.IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.17
            @Override // com.bytedance.sdk.openadsdk.core.vSq.IlO
            public void IlO() {
                es.this.AK();
            }
        });
        this.IlO.IlO(new EO(this.cl));
        this.MY.IlO(new EO(this.cL));
        this.IlO.IlO(this.mmj.DM.NV()).IlO(this.mmj.HTA).IlO(vce).IlO(this.mmj.pP.EV()).IlO(new com.bytedance.sdk.openadsdk.rp.EO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.19
            @Override // com.bytedance.sdk.openadsdk.rp.EO
            public void IlO(boolean z2, int i2, String str2) {
                if (z2) {
                    es esVar = es.this;
                    esVar.NV = true;
                    if (esVar.nm) {
                        es.this.nm = false;
                        es esVar2 = es.this;
                        esVar2.IlO(esVar2.mmj.uvo, true);
                    }
                }
                if (!oeT.tV(es.this.mmj.MY) || OOq.Bc(es.this.mmj.MY)) {
                    return;
                }
                es.this.IlO(z2, i2, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.rp.EO
            public void IlO() {
                es.this.HSR = true;
                es.this.mmj.DM.NV().performClick();
            }
        });
        this.IlO.Cc(this.ssS);
        this.MY.IlO(this.mmj.DM.NV()).IlO(new com.bytedance.sdk.openadsdk.rp.EO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.2
            @Override // com.bytedance.sdk.openadsdk.rp.EO
            public void IlO(boolean z2, int i2, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.rp.EO
            public void IlO() {
                es.this.HSR = true;
                es.this.mmj.DM.NV().performClick();
            }
        });
    }

    public void MY(boolean z2) {
        IlO(this.IlO, z2);
    }

    public void MY(vSq vsq, boolean z2) {
        try {
            this.mmj.pP.tV(z2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z2 ? 1 : 0);
            vsq.IlO(C2300e4.g.V, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.rp.DmF
    public void MY(int i2) {
        int i8 = this.qz;
        if (i8 <= 0 && i2 > 0) {
            tV(false);
        } else if (i8 > 0 && i2 == 0) {
            tV(true);
        }
        this.qz = i2;
    }

    public void vCE(boolean z2) {
        this.gQ = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endcard_overlay_render_type", oeT.EO(this.EV) ? 7 : 0);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.EV, this.rp, "use_second_endcard", jSONObject);
        this.AK = SystemClock.elapsedRealtime();
        try {
            if (!oeT.EO(this.EV)) {
                this.IlO.IlO("click_endcard_close", (JSONObject) null);
            } else if (z2) {
                this.mmj.nvX.lEW();
                com.bytedance.sdk.openadsdk.tV.EO.MY(this.EV, this.rp, "endcard_close_skip", jSONObject);
            }
        } catch (Exception unused2) {
        }
        this.mmj.ts.IlO(r5.lEW);
    }

    public void IlO(int i2, int i8) {
        if (this.IlO == null || this.mmj.BS.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i8);
            this.IlO.IlO(WebViewManager.EVENT_TYPE_RESIZE, jSONObject);
        } catch (Exception e) {
            Log.e("TTAD.RFWVM", "", e);
        }
    }

    public void IlO(boolean z2) {
        this.EO = z2;
    }

    private static String IlO(String str, oeT oet, int i2, int i8, int i9) {
        String strConcat;
        String strConcat2;
        float fLa = oet.La();
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 1) {
                if (str.contains("?")) {
                    strConcat2 = str.concat(C2300e4.i.f8401c);
                } else {
                    strConcat2 = str.concat("?");
                }
                str = a.C(strConcat2, "orientation=portrait");
            }
            if (str.contains("?")) {
                strConcat = str.concat(C2300e4.i.f8401c);
            } else {
                strConcat = str.concat("?");
            }
            str = strConcat + "height=" + i8 + "&width=" + i9 + "&aspect_ratio=" + fLa;
        }
        return !OOq.Bc(oet) ? com.bytedance.sdk.openadsdk.utils.vCE.IlO(str) : str;
    }

    public void IlO(int i2) {
        BS.IlO((View) this.cl, i2);
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        if (vce != null) {
            BS.IlO((View) vce.getWebView(), i2);
        }
        if (this.cl != null && (this.EV.AK() || OOq.Bc(this.EV))) {
            this.cl.setLandingPage(true);
            this.cl.setTag(OOq.Bc(this.EV) ? this.rp : "landingpage_endcard");
            this.cl.setMaterialMeta(this.EV.Ct());
        }
        if (i2 == 0 && OOq.lEW(this.EV)) {
            Bc();
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.common.hp hpVar) {
        this.nvX = hpVar;
    }

    public void IlO(float f4) {
        BS.IlO(this.cl, f4);
    }

    public void IlO(vSq vsq, boolean z2) {
        if (this.IlO == null || this.mmj.BS.isFinishing()) {
            return;
        }
        vsq.MY(z2);
    }

    private void IlO(String str, final tV tVVar) {
        com.bytedance.sdk.component.DmF.vCE vce;
        com.bytedance.sdk.component.DmF.vCE vce2 = this.cl;
        if (vce2 == null || vce2.getWebView() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.EV evMY = new com.bytedance.sdk.openadsdk.tV.EV(this.EV, this.cl.getWebView(), new com.bytedance.sdk.openadsdk.tV.NV() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.7
            @Override // com.bytedance.sdk.openadsdk.tV.NV
            public void IlO(int i2) {
                if (TextUtils.isEmpty(es.this.Dxv)) {
                    return;
                }
                EO.IlO.IlO(es.this.KC, es.this.uvo, es.this.Jz, es.this.hL - es.this.Jz, es.this.EV, "landingpage_endcard", i2);
            }
        }, this.Ea).MY(true);
        this.Cc = evMY;
        this.ii = evMY.IlO;
        evMY.IlO(cl() ? "landingpage_endcard" : str);
        this.Cc.MY(this.rp);
        this.Cc.EO(true);
        int i2 = Build.VERSION.SDK_INT;
        this.cl.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.8
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i8, int i9, int i10, int i11) {
                com.bytedance.sdk.openadsdk.tV.EV ev = es.this.Cc;
                if (ev != null) {
                    ev.MY(i9);
                }
            }
        });
        lEW lew = this.mmj.pP;
        if (lew != null) {
            this.Cc.IlO(lew.tV());
        }
        com.bytedance.sdk.openadsdk.common.tV tVVarIlO = zLG.IlO(this.EV, this.cl, this.mmj.BS, this.rp);
        this.HTA = tVVarIlO;
        if (tVVarIlO != null) {
            tVVarIlO.IlO(cl() ? "landingpage_endcard" : str);
        }
        if (cl()) {
            zLG.IlO(this.EV, this.cl);
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.widget.IlO.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO(), this.IlO, this.EV.ED(), this.HTA, this.Cc, this.EV.AK() || OOq.Bc(this.EV)) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                es.this.Tx = false;
                es.this.AXM = true;
                if (es.this.mmj.lMM.tl()) {
                    View viewNV = es.this.mmj.DM.NV();
                    if (viewNV instanceof com.bytedance.sdk.openadsdk.core.Cc.tV) {
                        ((com.bytedance.sdk.openadsdk.core.Cc.tV) viewNV).setImageResource(pP.tV(es.this.mmj.gQ, "tt_skip_btn"));
                    }
                }
                DeviceUtils.AudioInfoReceiver.IlO(es.this);
                es.this.qz = DeviceUtils.Bc();
                com.bytedance.sdk.openadsdk.tV.tV.Cc cc2 = es.this.lEW;
                if (cc2 != null) {
                    cc2.vCE();
                }
                es.this.mmj.pP.MY(str2);
                tV tVVar2 = tVVar;
                if (tVVar2 != null) {
                    tVVar2.IlO(webView, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                com.bytedance.sdk.openadsdk.tV.tV.Cc cc2 = es.this.lEW;
                if (cc2 != null) {
                    cc2.Cc();
                }
                tV tVVar2 = tVVar;
                if (tVVar2 != null) {
                    tVVar2.IlO(webView, str2, bitmap);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i8, String str2, String str3) {
                super.onReceivedError(webView, i8, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                es.this.mmj.pP.IlO(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                if (webResourceRequest.getUrl() != null) {
                    Log.i("TTAD.RFWVM", "onReceivedHttpError:url =" + webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest.isForMainFrame()) {
                    es.this.xF.set(false);
                    es.this.Tx = false;
                    es.this.vCE = webResourceResponse.getStatusCode();
                    es.this.Bc = "onReceivedHttpError";
                }
                if (es.this.lEW != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        es.this.lEW.IlO(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                String str3;
                if (OOq.Bc(es.this.EV)) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    WebResourceResponse webResourceResponseIlO = com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(es.this.EV.fdM().f4690i, OOq.hp(es.this.EV), str2);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (es.this.lEW != null) {
                        DmF.IlO IlO2 = com.bytedance.sdk.component.adexpress.tV.DmF.IlO(str2);
                        int i8 = webResourceResponseIlO != null ? 1 : 2;
                        if (IlO2 == DmF.IlO.HTML) {
                            str3 = str2;
                            es.this.lEW.IlO(str3, jCurrentTimeMillis, jCurrentTimeMillis2, i8);
                        } else {
                            str3 = str2;
                            if (IlO2 == DmF.IlO.JS) {
                                es.this.lEW.MY(str3, jCurrentTimeMillis, jCurrentTimeMillis2, i8);
                            }
                        }
                    } else {
                        str3 = str2;
                    }
                    return webResourceResponseIlO != null ? webResourceResponseIlO : super.shouldInterceptRequest(webView, str3);
                }
                try {
                    if (TextUtils.isEmpty(es.this.Dxv)) {
                        return super.shouldInterceptRequest(webView, str2);
                    }
                    es.bWL(es.this);
                    WebResourceResponseModel webResourceResponseModelIlO = com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(es.this.fdM, es.this.Dxv, str2);
                    if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getWebResourceResponse() != null) {
                        es.zPa(es.this);
                        return webResourceResponseModelIlO.getWebResourceResponse();
                    }
                    if (webResourceResponseModelIlO != null && webResourceResponseModelIlO.getMsg() == 2) {
                        es.cl(es.this);
                    }
                    return super.shouldInterceptRequest(webView, str2);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFWVM", "shouldInterceptRequest url error", th);
                    return super.shouldInterceptRequest(webView, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceError != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                    Log.i("TTAD.RFWVM", "onReceivedError WebResourceError : description=" + ((Object) webResourceError.getDescription()) + "  url =" + webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !es.this.IlO(webResourceRequest.getUrl().toString())) {
                    if (webResourceError != null && webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                        es.this.mmj.pP.IlO(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                    }
                    if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                        es.this.xF.set(false);
                        es.this.Tx = false;
                    }
                    if (es.this.lEW != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            es.this.lEW.IlO(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        es.this.vCE = webResourceError.getErrorCode();
                        es.this.Bc = String.valueOf(webResourceError.getDescription());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.RFWVM", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }
        };
        this.zLG = cc;
        this.cl.setWebViewClient(cc);
        this.zLG.IlO(this.EV);
        this.zLG.IlO(this.bWL ? "rewarded_video" : "fullscreen_interstitial_ad");
        if (this.EV.AK() && (vce = this.cl) != null && vce.getWebView() != null) {
            this.cl.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.10
                private final int MY = com.bytedance.sdk.openadsdk.core.cl.MY();

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int actionMasked;
                    int i8;
                    com.bytedance.sdk.openadsdk.tV.EV ev = es.this.Cc;
                    if (ev != null) {
                        ev.IlO(motionEvent);
                    }
                    if (es.this.HTA != null) {
                        es.this.HTA.IlO(motionEvent);
                    }
                    try {
                        actionMasked = motionEvent.getActionMasked();
                    } catch (Throwable th) {
                        Log.e("TTAD.RFWVM", "TouchRecordTool onTouch error", th);
                    }
                    if (actionMasked != 0) {
                        int i9 = 3;
                        if (actionMasked == 1) {
                            i8 = i9;
                        } else if (actionMasked != 2) {
                            i9 = actionMasked != 3 ? -1 : 4;
                            i8 = i9;
                        } else {
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            if (Math.abs(rawX - es.this.tl) >= this.MY || Math.abs(rawY - es.this.OOq) >= this.MY) {
                                es.this.vSq = false;
                            }
                            es.this.dY += Math.abs(motionEvent.getX() - es.this.tl);
                            es.this.lMM += Math.abs(motionEvent.getY() - es.this.OOq);
                            int i10 = (System.currentTimeMillis() - es.this.wPn <= 200 || (es.this.dY <= 8.0f && es.this.lMM <= 8.0f)) ? 2 : 1;
                            if (es.this.YA) {
                                if (rawY - es.this.OOq > 8.0f) {
                                    es.this.nvX.IlO();
                                }
                                if (rawY - es.this.OOq < -8.0f) {
                                    es.this.nvX.MY();
                                }
                            }
                            i8 = i10;
                        }
                        return false;
                    }
                    es.this.vSq = true;
                    es.this.oc = new SparseArray();
                    es.this.tl = motionEvent.getRawX();
                    es.this.OOq = motionEvent.getRawY();
                    es.this.wPn = System.currentTimeMillis();
                    try {
                        long landingPageClickBegin = es.this.cl.getLandingPageClickBegin();
                        if (landingPageClickBegin > 0 && landingPageClickBegin < es.this.wPn) {
                            es.this.wPn = landingPageClickBegin;
                            es.this.cl.setLandingPageClickBegin(-1L);
                        }
                    } catch (Exception unused) {
                    }
                    es.this.dY = -1.0f;
                    es.this.lMM = -1.0f;
                    i8 = 0;
                    es.this.oc.put(motionEvent.getActionMasked(), new EO.IlO(i8, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
                    if (motionEvent.getAction() == 1 && view.getVisibility() == 0 && Float.valueOf(view.getAlpha()).intValue() == 1 && ((!es.this.es || com.bytedance.sdk.openadsdk.core.model.es.lEW(es.this.EV)) && es.this.vSq)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("down_x", es.this.tl);
                        jSONObject.put("down_y", es.this.OOq);
                        jSONObject.put("down_time", es.this.wPn);
                        jSONObject.put("up_x", motionEvent.getRawX());
                        jSONObject.put("up_y", motionEvent.getRawY());
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            long landingPageClickEnd = es.this.cl.getLandingPageClickEnd();
                            if (landingPageClickEnd > 0 && landingPageClickEnd < jCurrentTimeMillis) {
                                try {
                                    es.this.cl.setLandingPageClickEnd(-1L);
                                } catch (Exception unused2) {
                                }
                                jCurrentTimeMillis = landingPageClickEnd;
                            }
                        } catch (Exception unused3) {
                        }
                        jSONObject.put("up_time", jCurrentTimeMillis);
                        int[] iArr = new int[2];
                        if (es.this.YA) {
                            es esVar = es.this;
                            esVar.pP = esVar.mmj.zLG.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.ts);
                        } else {
                            es esVar2 = es.this;
                            esVar2.pP = esVar2.mmj.zLG.findViewById(520093713);
                        }
                        if (es.this.pP != null) {
                            es.this.pP.getLocationOnScreen(iArr);
                            jSONObject.put("button_x", iArr[0]);
                            jSONObject.put("button_y", iArr[1]);
                            jSONObject.put("button_width", es.this.pP.getWidth());
                            jSONObject.put("button_height", es.this.pP.getHeight());
                        }
                        if (es.this.kBB != null) {
                            int[] iArr2 = new int[2];
                            es.this.kBB.getLocationOnScreen(iArr2);
                            jSONObject.put("ad_x", iArr2[0]);
                            jSONObject.put("ad_y", iArr2[1]);
                            jSONObject.put("width", es.this.kBB.getWidth());
                            jSONObject.put("height", es.this.kBB.getHeight());
                        }
                        jSONObject.put("toolType", motionEvent.getToolType(0));
                        jSONObject.put("deviceId", motionEvent.getDeviceId());
                        jSONObject.put("source", motionEvent.getSource());
                        jSONObject.put("ft", com.bytedance.sdk.openadsdk.core.model.NV.IlO(es.this.oc, com.bytedance.sdk.openadsdk.core.DmF.MY().IlO() ? 1 : 2));
                        jSONObject.put("user_behavior_type", es.this.vSq ? 1 : 2);
                        jSONObject.put("click_scence", 2);
                        if (es.this.zLG != null) {
                            es.this.zLG.IlO(jSONObject);
                        }
                        if (!es.this.es && !com.bytedance.sdk.openadsdk.core.model.es.Bc(es.this.EV)) {
                            if (es.this.bWL) {
                                com.bytedance.sdk.openadsdk.tV.EO.IlO(es.this.EV, "rewarded_video", C2318f4.f8523d, jSONObject);
                            } else {
                                com.bytedance.sdk.openadsdk.tV.EO.IlO(es.this.EV, "fullscreen_interstitial_ad", C2318f4.f8523d, jSONObject);
                            }
                            es.this.es = true;
                        }
                        return false;
                    }
                    return false;
                }
            });
        }
        com.bytedance.sdk.component.DmF.vCE vce3 = this.cl;
        if (vce3 != null) {
            vce3.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.IlO, this.Cc, this.HTA) { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.es.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i8) {
                    super.onProgressChanged(webView, i8);
                    tV tVVar2 = tVVar;
                    if (tVVar2 != null) {
                        tVVar2.IlO(webView, i8);
                    }
                }
            });
        }
        IlO(this.cl);
        if (i2 >= 24) {
            this.cl.setLayerType(1, null);
        }
        this.cl.setBackgroundColor(-1);
        this.cl.setDisplayZoomControls(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.EV.AK() && str.endsWith(".mp4");
    }

    public void IlO(DownloadListener downloadListener) {
        com.bytedance.sdk.component.DmF.vCE vce = this.cl;
        if (vce == null || downloadListener == null) {
            return;
        }
        vce.setDownloadListener(downloadListener);
    }

    public void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.mmj.BS).IlO(false).MY(false).IlO(vce.getWebView());
        vce.setUserAgentString(com.bytedance.sdk.openadsdk.utils.xF.IlO(vce.getWebView(), BuildConfig.VERSION_CODE));
        vce.setMixedContentMode(0);
    }

    public void IlO(boolean z2, boolean z7) {
        IlO(this.IlO, z2, z7);
    }

    public void IlO(vSq vsq, boolean z2, boolean z7) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            jSONObject.put("endcard_show", z7);
            com.bytedance.sdk.openadsdk.activity.vCE vce = this.mmj.ED;
            if (vce != null) {
                jSONObject.put("multi_ads_show", vce.pP().DmF());
            }
            vsq.IlO("endcard_control_event", jSONObject);
            if (z7) {
                if (this.AXM) {
                    return;
                }
                this.nm = true;
                return;
            }
            this.nm = false;
        } catch (Exception unused) {
        }
    }

    public void IlO(boolean z2, int i2, String str) {
        com.bytedance.sdk.openadsdk.tV.tV.Cc cc = this.lEW;
        if (cc == null) {
            return;
        }
        if (z2) {
            cc.MY();
        } else {
            cc.IlO(i2, str);
        }
    }
}
