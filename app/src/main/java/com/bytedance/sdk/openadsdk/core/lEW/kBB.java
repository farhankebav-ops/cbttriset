package com.bytedance.sdk.openadsdk.core.lEW;

import android.R;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.utils.YA;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class kBB extends com.bytedance.sdk.component.adexpress.Cc.IlO {
    private final Runnable AXM;
    private Context Bc;
    private com.bytedance.sdk.openadsdk.core.model.oeT DmF;
    private com.bytedance.sdk.openadsdk.tV.tV.Cc EV;
    private JSONObject NV;
    private final Map<String, com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE> bWL;
    private volatile int cL;
    private oeT.IlO cl;
    private vSq ea;
    private NV es;
    private com.bytedance.sdk.openadsdk.tV.EV hp;
    private String lEW;
    private String rp;
    com.bytedance.sdk.openadsdk.utils.IlO vCE;
    private final com.bytedance.sdk.component.lEW.lEW xF;
    private com.bytedance.sdk.component.adexpress.MY.Bc zPa;

    public kBB(Context context, com.bytedance.sdk.component.adexpress.MY.hp hpVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.tV.tV.Cc cc, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        super(context, hpVar, themeStatusBroadcastReceiver);
        this.bWL = Collections.synchronizedMap(new HashMap());
        this.cL = 0;
        this.xF = new com.bytedance.sdk.component.lEW.lEW("webviewrender_template") { // from class: com.bytedance.sdk.openadsdk.core.lEW.kBB.1
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.component.adexpress.Cc.IlO) kBB.this).Cc.get()) {
                    return;
                }
                if ((kBB.this.DmF instanceof com.bytedance.sdk.openadsdk.core.model.vAh) && ((com.bytedance.sdk.openadsdk.core.model.vAh) kBB.this.DmF).dvD()) {
                    kBB.this.MY(true);
                }
                kBB kbb = kBB.this;
                kbb.NV = kbb.EV().EO();
                kBB kbb2 = kBB.this;
                kbb2.IlO(kbb2.NV);
                if (kBB.this.cL == 0) {
                    kBB.this.cl();
                }
                com.bytedance.sdk.openadsdk.core.bWL.EO().post(kBB.this.AXM);
            }
        };
        this.AXM = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.kBB.2
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.component.adexpress.Cc.IlO) kBB.this).Cc.get() || kBB.this.zPa == null) {
                    return;
                }
                kBB.this.rp();
                kBB kbb = kBB.this;
                kBB.super.IlO(kbb.zPa);
            }
        };
        if (this.EO == null) {
            return;
        }
        this.Bc = context;
        this.lEW = hpVar.tV();
        this.DmF = oet;
        this.EV = cc;
        themeStatusBroadcastReceiver.IlO(this);
        cl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        com.bytedance.sdk.component.DmF.vCE vce = this.EO;
        if (vce == null || vce.getWebView() == null || this.cL == 2) {
            return;
        }
        this.rp = IlO(this.DmF);
        this.EO.setDisplayZoomControls(false);
        IlO(YA.IlO(this.rp));
        hp();
        vSq vsq = new vSq(this.Bc);
        this.ea = vsq;
        vsq.tV(true);
        bWL();
        this.cL = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        if (this.EO.getWebView() != null && mmj.vCE()) {
            cL();
        } else {
            this.cL = 1;
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.kBB.3
                @Override // java.lang.Runnable
                public void run() {
                    kBB.this.cL();
                }
            });
        }
    }

    public void bWL() {
        com.bytedance.sdk.component.DmF.vCE vce = this.EO;
        if (vce == null || vce.getWebView() == null) {
            return;
        }
        this.EO.setBackgroundColor(0);
        this.EO.setBackgroundResource(R.color.transparent);
        IlO(this.EO);
        if (IlO() != null) {
            this.hp = new com.bytedance.sdk.openadsdk.tV.EV(this.DmF, IlO().getWebView()).MY(false);
        }
        this.hp.IlO(this.EV);
        NV nv = new NV(this.Bc, this.ea, this.DmF, this.hp, EV());
        this.es = nv;
        this.EO.setWebViewClient(nv);
        this.EO.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.ea, this.hp));
        com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().IlO(this.EO, this.ea);
    }

    public NV ea() {
        return this.es;
    }

    public void hp() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.DmF;
        if (oet == null || oet.uvo() == null) {
            return;
        }
        this.cl = this.DmF.uvo();
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.IlO
    public void onThemeChanged(int i2) {
        if (this.ea == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i2);
        } catch (JSONException unused) {
        }
        this.ea.IlO("themeChange", jSONObject);
    }

    public void rp() {
        vSq vsq;
        com.bytedance.sdk.component.DmF.vCE vce = this.EO;
        if (vce == null || vce.getWebView() == null || (vsq = this.ea) == null) {
            return;
        }
        vsq.MY(this.EO).IlO(this.DmF).EO(this.DmF.ED()).tV(this.DmF.KT()).MY(zLG.IlO(this.lEW)).Cc(this.DmF.tcT()).IlO(this).IlO(this.NV).IlO(this.EO).IlO(this.EV);
    }

    public vSq zPa() {
        return this.ea;
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void Bc() {
        vSq vsq = this.ea;
        if (vsq == null) {
            return;
        }
        vsq.IlO("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void DmF() {
        super.DmF();
        com.bytedance.sdk.openadsdk.utils.IlO ilOCc = com.bytedance.sdk.openadsdk.core.ea.IlO().Cc();
        this.vCE = ilOCc;
        ilOCc.IlO(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO, com.bytedance.sdk.component.adexpress.MY.tV
    public int EO() {
        return this.DmF.nvX();
    }

    public void MY(int i2) {
        if (this.ea == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("zoom_type", i2);
            this.ea.IlO("expressAdViewWillZoom", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.WebViewRender", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void NV() {
        super.NV();
        com.bytedance.sdk.openadsdk.utils.IlO ilO = this.vCE;
        if (ilO != null) {
            ilO.MY(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void lEW() {
        super.lEW();
        if (this.ea == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.ea.IlO("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void tV() {
        if (this.Cc.get()) {
            return;
        }
        super.tV();
        vSq vsq = this.ea;
        if (vsq != null) {
            vsq.EO();
            this.ea.rp();
            this.ea = null;
        }
        com.bytedance.sdk.openadsdk.tV.EV ev = this.hp;
        if (ev != null) {
            ev.tV(false);
        }
        com.bytedance.sdk.openadsdk.core.bWL.EO().removeCallbacks(this.AXM);
        this.bWL.clear();
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void vCE() {
        if (IlO() == null) {
            return;
        }
        try {
            IlO().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    private void EO(boolean z2) {
        if (this.ea == null || this.EO == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z2);
            this.ea.IlO("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public static String IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        return com.bytedance.sdk.component.adexpress.IlO.MY.MY.tV((oet == null || !oet.KC()) ? null : "v3");
    }

    public static boolean MY(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO, com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
        this.zPa = bc;
        mmj.MY(this.xF);
    }

    private void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.Bc).IlO(false).IlO(vce.getWebView());
            vce.setVerticalScrollBarEnabled(false);
            vce.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(vce);
            vce.bWL();
            vce.setUserAgentString(com.bytedance.sdk.openadsdk.utils.xF.IlO(vce.getWebView(), BuildConfig.VERSION_CODE));
            vce.setMixedContentMode(0);
            vce.setJavaScriptEnabled(true);
            vce.setJavaScriptCanOpenWindowsAutomatically(true);
            vce.setDomStorageEnabled(true);
            vce.setDatabaseEnabled(true);
            vce.setAllowFileAccess(false);
            vce.setSupportZoom(true);
            vce.setBuiltInZoomControls(true);
            vce.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            vce.setUseWideViewPort(true);
            vce.setCacheMode(-1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.WebViewRender", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public com.bytedance.sdk.component.DmF.vCE IlO() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO
    public void IlO(int i2) {
        if (i2 == this.tV) {
            return;
        }
        this.tV = i2;
        EO(i2 == 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.Cc.IlO, com.bytedance.sdk.component.adexpress.MY.EV
    public void IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        super.IlO(bwl);
        if (this.MY) {
            com.bytedance.sdk.component.utils.DmF.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.kBB.4
                @Override // java.lang.Runnable
                public void run() {
                    WebView webView = ((com.bytedance.sdk.component.adexpress.Cc.IlO) kBB.this).EO.getWebView();
                    if (webView != null) {
                        webView.resumeTimers();
                    }
                }
            }, 2000L);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        vSq vsq = this.ea;
        if (vsq != null) {
            vsq.IlO(my);
        }
    }
}
