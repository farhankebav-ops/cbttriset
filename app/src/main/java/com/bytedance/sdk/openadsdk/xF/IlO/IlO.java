package com.bytedance.sdk.openadsdk.xF.IlO;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.core.widget.DmF;
import com.bytedance.sdk.openadsdk.core.widget.IlO.Cc;
import com.bytedance.sdk.openadsdk.core.widget.NV;
import com.bytedance.sdk.openadsdk.rp.vCE;
import com.bytedance.sdk.openadsdk.utils.xF;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.xF.Bc;
import com.bytedance.sdk.openadsdk.xF.lEW;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private vSq Bc;
    private final FrameLayout Cc;
    private final String DmF;
    private final oeT EO;

    @Nullable
    private vCE EV;
    protected com.bytedance.sdk.component.DmF.vCE IlO;
    private final Context MY;
    private lEW NV;
    private volatile boolean bWL;
    private InterfaceC0123IlO cL;
    private com.bytedance.sdk.openadsdk.core.MY.IlO cl;
    private AtomicBoolean ea;
    private volatile boolean hp;
    private String lEW;
    private boolean rp;
    private final int tV;

    @Nullable
    private NV vCE;
    private DmF zPa;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.xF.IlO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0123IlO {
        void IlO();
    }

    public IlO(Context context, oeT oet, int i2, boolean z2, FrameLayout frameLayout) {
        this(context, oet, i2, z2, frameLayout, false);
    }

    public IlO(Context context, oeT oet, int i2, boolean z2, FrameLayout frameLayout, boolean z7) {
        this.rp = true;
        this.ea = new AtomicBoolean(false);
        this.MY = context;
        this.EO = oet;
        this.tV = i2;
        String strEO = zLG.EO(oet.ssS().getDurationSlotType());
        this.lEW = strEO;
        int iIlO = zLG.IlO(strEO);
        if (z7) {
            this.lEW = zLG.MY(iIlO);
        }
        this.DmF = OOq.hp(oet);
        this.Cc = frameLayout;
        IlO(frameLayout);
        IlO(iIlO);
        EO(z2);
        Bc();
    }

    private void Bc() {
        this.IlO.setWebViewClient(new Cc(cl.IlO(), this.Bc, this.EO.ED(), null, true) { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (IlO.this.NV != null) {
                    IlO.this.NV.DmF(str);
                }
                if (IlO.this.rp) {
                    IlO.this.IlO(0, 0);
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), IlO.this.EO, IlO.this.lEW, "py_loading_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                IlO.this.rp = false;
                if (IlO.this.NV != null) {
                    IlO.this.NV.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(IlO.this.EO));
                    IlO.this.NV.IlO(i2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    IlO.this.rp = false;
                    if (IlO.this.NV != null) {
                        IlO.this.NV.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(IlO.this.EO));
                        IlO.this.NV.IlO(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (IlO.this.EO.fdM() != null && !TextUtils.isEmpty(IlO.this.EO.fdM().f4690i)) {
                        if (IlO.this.NV != null) {
                            IlO.this.NV.NV(str);
                        }
                        String strHp = OOq.hp(IlO.this.EO);
                        WebResourceResponse webResourceResponseIlO = com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(IlO.this.EO.fdM().f4690i, strHp, str);
                        if (webResourceResponseIlO == null) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        if (IlO.this.NV != null) {
                            IlO.this.NV.EV(str);
                        }
                        return webResourceResponseIlO;
                    }
                    return super.shouldInterceptRequest(webView, str);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.Cc, android.webkit.WebViewClient
            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    IlO.this.rp = false;
                    if (IlO.this.NV == null || webResourceError == null) {
                        return;
                    }
                    IlO.this.NV.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(IlO.this.EO));
                    IlO.this.NV.IlO(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                }
            }
        });
        this.IlO.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.IlO.tV(this.Bc) { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.IlO.tV, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                if (IlO.this.vCE == null || IlO.this.vCE.getVisibility() != 0) {
                    return;
                }
                IlO.this.vCE.setProgress(i2);
            }
        });
        com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(this.MY).IlO(false).MY(false).IlO(this.IlO.getWebView());
        com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
        vce.setUserAgentString(xF.IlO(vce.getWebView(), BuildConfig.VERSION_CODE));
        this.IlO.setMixedContentMode(0);
    }

    private void EO(boolean z2) {
        com.bytedance.sdk.component.IlO.cl clVarMY;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.EO.ED());
            jSONObject.put("log_extra", this.EO.KT());
        } catch (Throwable unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.DmF.MY().es()) {
            Bc.IlO(new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.1
            });
        }
        lEW lewIlO = lEW.IlO(cl.IlO(), this.IlO.getWebView(), new com.bytedance.sdk.openadsdk.xF.EO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.2
            @Override // com.bytedance.sdk.openadsdk.xF.EO
            public void IlO(String str, JSONObject jSONObject2) {
                if (IlO.this.Bc != null) {
                    IlO.this.Bc.IlO(str, jSONObject2);
                }
            }
        }, new com.bytedance.sdk.openadsdk.xF.IlO() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.3
            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public com.bytedance.sdk.openadsdk.xF.tV IlO() {
                String strVCE = com.bytedance.sdk.openadsdk.common.MY.vCE();
                strVCE.getClass();
                switch (strVCE) {
                    case "2g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_2G;
                    case "3g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_3G;
                    case "4g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_4G;
                    case "5g":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_5G;
                    case "wifi":
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_WIFI;
                    default:
                        return com.bytedance.sdk.openadsdk.xF.tV.TYPE_UNKNOWN;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public void MY() {
                IlO.this.Bc.EO(true);
                if (IlO.this.EV != null) {
                    IlO.this.EV.IlO();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public void IlO(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_new_playable", 1);
                    if (IlO.this.EO.jm()) {
                        jSONObject3.put("is_pre_render", 1);
                    }
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.oeT.EO("PlayableManager", e.getMessage());
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(IlO.this.EO, IlO.this.lEW, "playable_track", jSONObject2);
            }

            @Override // com.bytedance.sdk.openadsdk.xF.IlO
            public void IlO(int i2, String str) {
                IlO.this.rp = false;
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    IlO.this.IlO(2, i2);
                } else if (i2 == 5) {
                    IlO.this.IlO(3, i2);
                } else {
                    IlO.this.IlO(1, 0);
                }
            }
        });
        this.NV = lewIlO;
        lewIlO.Bc(this.DmF).Cc(com.bytedance.sdk.openadsdk.common.MY.IlO(cl.IlO())).MY(com.bytedance.sdk.openadsdk.common.MY.Cc()).IlO(com.bytedance.sdk.openadsdk.common.MY.IlO()).tV(com.bytedance.sdk.openadsdk.common.MY.tV()).EO(jSONObject).EO(OOq.EV(this.EO)).tV(true).IlO(z2).EO(false).IlO(OOq.xF(this.EO)).MY(OOq.xF(this.EO)).IlO("sdkEdition", com.bytedance.sdk.openadsdk.common.MY.EO()).Cc(OOq.vCE(this.EO)).vCE(this.lEW);
        this.NV.IlO(com.bytedance.sdk.openadsdk.xF.Cc.MY(this.MY));
        Set<String> setEV = this.NV.EV();
        final WeakReference weakReference = new WeakReference(this.NV);
        for (String str : setEV) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (clVarMY = this.Bc.MY()) != null) {
                clVarMY.IlO(str, new com.bytedance.sdk.component.IlO.Cc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.4
                    @Override // com.bytedance.sdk.component.IlO.Cc
                    public JSONObject IlO(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.IlO.vCE vce) {
                        try {
                            lEW lew = (lEW) weakReference.get();
                            if (lew == null) {
                                return null;
                            }
                            return lew.tV(IlO(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    public boolean Cc() {
        return this.hp;
    }

    public void MY() {
        lEW lew;
        if (!this.ea.get() || (lew = this.NV) == null) {
            return;
        }
        lew.EO(true);
    }

    public void tV() {
        lEW lew = this.NV;
        if (lew != null) {
            lew.YA();
        }
        com.bytedance.sdk.component.DmF.vCE vce = this.IlO;
        if (vce != null) {
            vce.zPa();
        }
        vSq vsq = this.Bc;
        if (vsq != null) {
            vsq.rp();
        }
        this.IlO = null;
    }

    public boolean vCE() {
        vSq vsq = this.Bc;
        if (vsq != null) {
            return vsq.vCE();
        }
        return false;
    }

    public static void IlO(oeT oet, JSONObject jSONObject) {
        if (jSONObject == null || oet == null || !OOq.MY(oet) || !oet.nt()) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_new_playable", 1);
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    public void MY(boolean z2) {
        lEW lew = this.NV;
        if (lew != null) {
            lew.Cc(z2);
        }
    }

    private void IlO(FrameLayout frameLayout) {
        com.bytedance.sdk.component.DmF.vCE vce = new com.bytedance.sdk.component.DmF.vCE(this.MY);
        this.IlO = vce;
        vce.Cc();
        this.IlO.setLayerType(2, null);
        this.IlO.setVisibility(4);
        this.IlO.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.IlO.setEnabled(true);
        this.IlO.setTag(this.lEW);
        this.IlO.setMaterialMeta(this.EO.Ct());
        this.IlO.setLandingPage(true);
        frameLayout.addView(this.IlO, new FrameLayout.LayoutParams(-1, -1));
        DmF dmF = new DmF(this.MY);
        this.zPa = dmF;
        dmF.IlO(this.EO, this.lEW, this.cl);
        frameLayout.addView(this.zPa, new FrameLayout.LayoutParams(-1, -1));
        if (this.EO.VFH()) {
            NV nv = new NV(this.MY);
            this.vCE = nv;
            nv.MY();
            frameLayout.addView(this.vCE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void IlO(int i2) {
        HashMap map = new HashMap();
        map.put("click_scence", 3);
        this.Bc = new vSq(this.MY);
        this.Bc.MY(this.IlO).IlO(this.EO).IlO(com.bytedance.sdk.openadsdk.core.lEW.IlO.MY.IlO(this.EO)).EO(this.EO.ED()).tV(this.EO.KT()).MY(i2).Cc(this.EO.tcT()).IlO(this.IlO).MY(this.lEW).IlO(map).IlO(new com.bytedance.sdk.openadsdk.tV.cl(3, this.lEW, this.EO));
    }

    public void EO() {
        lEW lew;
        if (!this.ea.get() || (lew = this.NV) == null) {
            return;
        }
        lew.EO(false);
    }

    public void IlO(boolean z2, vCE vce) {
        this.EV = vce;
        this.NV.MY(z2);
        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().MY(this.EO);
        this.IlO.a_(this.DmF);
        lEW lew = this.NV;
        if (lew != null) {
            lew.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.EO));
            this.NV.lEW(this.DmF);
        }
    }

    public void IlO() {
        boolean z2;
        NV nv;
        if (this.ea.getAndSet(true)) {
            return;
        }
        FrameLayout frameLayout = this.Cc;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (!this.bWL && (nv = this.vCE) != null) {
            nv.MY(this.EO, this.tV);
            lEW lew = this.NV;
            if (lew != null) {
                lew.oc();
            }
            z2 = true;
        } else {
            this.NV.EO(true);
            z2 = false;
        }
        if (this.NV != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("webview_state", this.NV.zLG());
                jSONObject2.put("has_loading", z2);
                jSONObject2.put("is_new_playable", 1);
                jSONObject.put("pag_json_data", jSONObject2.toString());
                jSONObject.put("playable_event", "start_show_plb");
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.EO, this.lEW, "playable_track", jSONObject);
            this.NV.vCE(com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().IlO(this.EO));
        }
        this.IlO.setVisibility(0);
    }

    public void IlO(final int i2, final int i8) {
        lEW lew;
        InterfaceC0123IlO interfaceC0123IlO;
        if (this.bWL) {
            return;
        }
        this.bWL = true;
        if (i2 == 2) {
            this.hp = true;
            this.NV.IlO(3);
        } else if (i2 == 1) {
            this.hp = true;
            this.NV.IlO(2);
        } else if (i2 == 3) {
            this.hp = true;
            this.NV.IlO(4);
        } else if (i2 == 0) {
            this.NV.IlO(1);
        }
        if (this.hp && (interfaceC0123IlO = this.cL) != null) {
            interfaceC0123IlO.IlO();
        }
        if (this.ea.get() && (lew = this.NV) != null) {
            lew.EO(true);
        }
        NV nv = this.vCE;
        if (nv != null) {
            nv.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.IlO.7
                @Override // java.lang.Runnable
                public void run() {
                    if (IlO.this.hp) {
                        IlO.this.zPa.setVisibility(0);
                        IlO.this.IlO(true);
                    }
                    IlO.this.vCE.EO();
                    if (IlO.this.ea.get()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("remove_loading_page_type", i2);
                            jSONObject2.put("remove_loading_page_reason", i8);
                            jSONObject2.put("playable_url", IlO.this.DmF);
                            jSONObject2.put("duration", IlO.this.vCE.getDisplayDuration());
                            jSONObject2.put("is_new_playable", 1);
                            jSONObject.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("playable_event", "remove_loading_page");
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.tV.EO.MY(IlO.this.EO, IlO.this.lEW, "playable_track", jSONObject);
                    }
                }
            });
        }
    }

    public void IlO(boolean z2) {
        lEW lew = this.NV;
        if (lew != null) {
            lew.IlO(z2);
        }
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        this.cl = ilO;
        NV nv = this.vCE;
        if (nv != null && nv.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.Cc.lEW downloadButton = this.vCE.getDownloadButton();
            downloadButton.setOnClickListener(ilO);
            downloadButton.setOnTouchListener(ilO);
        }
        DmF dmF = this.zPa;
        if (dmF != null) {
            dmF.setClickListener(ilO);
        }
    }

    public void IlO(InterfaceC0123IlO interfaceC0123IlO) {
        this.cL = interfaceC0123IlO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        vSq vsq = this.Bc;
        if (vsq != null) {
            vsq.IlO(my);
        }
    }
}
