package com.bytedance.sdk.openadsdk.core.widget.IlO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.component.utils.MY;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.tV.EV;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.vAh;
import com.bytedance.sdk.openadsdk.utils.xF;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2318f4;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends vCE.IlO {
    private static final HashSet<String> AXM;
    protected boolean Bc;
    protected final String Cc;
    protected boolean DmF;
    protected final vSq EO;
    private Map<String, Object> EV;
    private final boolean IlO;
    private String MY;
    private NV NV;
    private String bWL;
    private com.bytedance.sdk.openadsdk.core.rp.tV.MY cL;
    private TTCeilingLandingPageActivity.IlO cl;
    private final Stack<String> ea;
    private JSONObject es;
    private com.bytedance.sdk.openadsdk.common.tV hp;
    protected boolean lEW;
    private boolean rp;
    protected final Context tV;
    protected EV vCE;
    private oeT xF;
    private boolean zPa;

    static {
        HashSet<String> hashSet = new HashSet<>();
        AXM = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public Cc(Context context, vSq vsq, String str, com.bytedance.sdk.openadsdk.common.tV tVVar, EV ev, boolean z2, boolean z7, TTCeilingLandingPageActivity.IlO ilO) {
        this(context, vsq, str, tVVar, ev, z2);
        this.zPa = z7;
        this.cl = ilO;
    }

    private boolean Cc(String str) {
        if (es.lEW(this.xF)) {
            return TextUtils.equals(this.xF.qIK(), str);
        }
        return false;
    }

    public static String tV(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !AXM.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/".concat(strSubstring);
    }

    public void EO() {
        if (TextUtils.isEmpty(this.MY) || !es.Bc(this.xF) || this.rp) {
            return;
        }
        NV nv = this.NV;
        if (nv != null) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, this.xF, nv, this.MY, true, this.EV, 1);
            this.rp = true;
            return;
        }
        JSONObject jSONObject = this.es;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.xF, this.MY, C2318f4.f8523d, jSONObject);
            this.rp = true;
        }
    }

    public EV MY() {
        return this.vCE;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        EV ev = this.vCE;
        if (ev != null) {
            ev.IlO(webView, str, this.IlO);
        }
        com.bytedance.sdk.openadsdk.common.tV tVVar = this.hp;
        if (tVVar != null) {
            tVVar.MY(webView, str, this.IlO);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebView webView2;
        String str2;
        oeT oet;
        super.onPageStarted(webView, str, bitmap);
        oeT oet2 = this.xF;
        int iIlO = (oet2 != null && oet2.nm() && com.bytedance.sdk.openadsdk.AXM.IlO.IlO("opt_web_index", false)) ? zLG.IlO(webView) : -1;
        EV ev = this.vCE;
        if (ev != null) {
            webView2 = webView;
            str2 = str;
            ev.IlO(webView2, str2, bitmap, this.IlO, iIlO);
        } else {
            webView2 = webView;
            str2 = str;
        }
        com.bytedance.sdk.openadsdk.common.tV tVVar = this.hp;
        if (tVVar != null) {
            tVVar.EO(webView2, str2, this.IlO);
        }
        if (this.IlO && (oet = this.xF) != null && oet.nm() && this.xF.cl().IlO() >= 2) {
            if (!TextUtils.isEmpty(str2) && !str2.equals(this.bWL)) {
                if (this.ea.contains(str2)) {
                    while (!str2.equals(this.ea.peek())) {
                        this.ea.pop();
                    }
                } else {
                    this.ea.push(str2);
                }
            }
            this.bWL = str2;
        }
        if (!this.lEW || this.DmF) {
            return;
        }
        this.DmF = true;
        EO.IlO(this.tV).IlO(true).MY(webView2.getSettings().getBuiltInZoomControls()).IlO(webView2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.vCE == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        String str = requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "";
        this.vCE.IlO(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str, webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.vCE != null) {
            int primaryError = 0;
            String strConcat = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    strConcat = "SslError: ".concat(String.valueOf(sslError));
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str = url;
            this.vCE.IlO(webView, primaryError, strConcat, str, tV(str), true);
        }
    }

    @Override // com.bytedance.sdk.component.DmF.vCE.IlO, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().MY();
        } catch (Exception unused) {
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        Cc cc;
        String str2;
        Uri uri;
        final String lowerCase;
        Intent uri2;
        EV ev = this.vCE;
        if (ev != null) {
            ev.IlO(str, this.IlO);
        }
        com.bytedance.sdk.openadsdk.common.tV tVVar = this.hp;
        if (tVVar != null) {
            tVVar.IlO(webView, str, this.IlO);
        }
        if (IlO(webView, str)) {
            return true;
        }
        oeT oet = this.xF;
        if (oet != null && oet.DmF() == 1 && ((com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.IlO(str, this.xF) || com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.IlO(this.xF, str)) && com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.MY(this.xF, this.tV, true))) {
            return true;
        }
        try {
            uri = Uri.parse(str);
            lowerCase = uri.getScheme().toLowerCase();
        } catch (Throwable unused) {
            cc = this;
            str2 = str;
        }
        if ("bytedance".equals(lowerCase)) {
            xF.IlO(uri, this.EO);
            return true;
        }
        if (EO(str)) {
            return true;
        }
        if (com.bytedance.sdk.component.utils.xF.IlO(str)) {
            str2 = str;
            return super.shouldOverrideUrlLoading(webView, str2);
        }
        if (es.lEW(this.xF)) {
            IlO(lowerCase, str);
            return true;
        }
        try {
            if (str.startsWith("intent:")) {
                uri2 = Intent.parseUri(str, 1);
            } else if (str.startsWith("android-app:")) {
                uri2 = Intent.parseUri(str, 2);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                uri2 = intent;
            }
            uri2.addFlags(268435456);
            com.bytedance.sdk.component.utils.MY.IlO(this.tV, uri2, new MY.InterfaceC0060MY() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.Cc.1
                @Override // com.bytedance.sdk.component.utils.MY.InterfaceC0060MY
                public void IlO() {
                    Cc.this.IlO(lowerCase, true, 0, "", str);
                }

                @Override // com.bytedance.sdk.component.utils.MY.InterfaceC0060MY
                public void IlO(Throwable th) {
                    Cc.this.IlO(lowerCase, false, 2, th.getMessage(), str);
                }
            });
            cc = this;
            str2 = str;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("WebChromeClient", "parseUri", th);
            cc = this;
            str2 = str;
            try {
                cc.IlO(lowerCase, false, 1, th.getMessage(), str2);
            } catch (Throwable unused2) {
            }
        }
        com.bytedance.sdk.openadsdk.core.rp.tV.MY my = cc.cL;
        if (my != null) {
            my.EV();
        }
        return true;
        vSq vsq = cc.EO;
        if (vsq != null && vsq.Cc()) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str2);
    }

    public void IlO(NV nv) {
        this.NV = nv;
    }

    public boolean MY(String str) {
        String strEO;
        String strIlO;
        if (this.tV == null) {
            return false;
        }
        oeT oet = this.xF;
        if (oet == null || oet.VH() == null) {
            strEO = "";
            strIlO = "";
        } else {
            strEO = this.xF.VH().EO();
            strIlO = this.xF.VH().IlO();
        }
        if (!com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO()) {
            return com.bytedance.sdk.openadsdk.es.IlO.IlO.IlO.IlO(str, this.tV, this.MY, this.xF, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.es.IlO.IlO.IlO.IlO(this.xF, strEO, this.tV, this.MY, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.es.IlO.IlO.tV.IlO(this.tV, strIlO, strEO, this.MY, this.xF);
        }
        Context context = this.tV;
        oeT oet2 = this.xF;
        return com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO(context, str, oet2, zLG.MY(oet2), null, true) || com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.IlO(this.xF, strEO, this.tV, this.MY, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.es.IlO.IlO.Cc.IlO(this.tV, strIlO, strEO, this.MY, this.xF);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.vCE == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        String str = requestHeaders.containsKey("accept") ? requestHeaders.get("accept") : "";
        this.vCE.IlO(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str, webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        EV ev = this.vCE;
        if (ev != null) {
            ev.MY(webView, str, this.IlO);
        }
        com.bytedance.sdk.openadsdk.common.tV tVVar = this.hp;
        if (tVVar != null) {
            tVVar.IlO(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void IlO(Map<String, Object> map) {
        this.EV = map;
    }

    public Cc(Context context, vSq vsq, String str, com.bytedance.sdk.openadsdk.common.tV tVVar, EV ev, boolean z2) {
        this(context, vsq, str, ev, z2);
        this.hp = tVVar;
    }

    public void IlO(JSONObject jSONObject) {
        this.es = jSONObject;
    }

    public void IlO(String str) {
        this.MY = str;
    }

    public Cc(Context context, vSq vsq, String str, EV ev, boolean z2) {
        this.Bc = true;
        this.lEW = true;
        this.DmF = false;
        this.tV = context;
        this.EO = vsq;
        this.Cc = str;
        this.vCE = ev;
        this.IlO = z2;
        this.ea = new Stack<>();
    }

    public void IlO(oeT oet) {
        this.xF = oet;
    }

    private void IlO(String str, String str2) {
        if ((Cc(str) || "market".equals(str)) && ((this.NV != null || this.es != null) && MY(str2))) {
            EO();
        }
        this.NV = null;
        this.es = null;
    }

    public boolean EO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if ("play.google.com".equals(uri.getHost())) {
                if (es.lEW(this.xF) && this.es == null && this.NV == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.tV instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(uri);
                intent.setPackage("com.android.vending");
                this.tV.startActivity(intent);
                EO();
                this.es = null;
                this.NV = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean IlO(WebView webView, String str) {
        if (!zLG.tV(this.xF) || this.xF.cl() == null || webView == null) {
            return false;
        }
        int iIlO = this.xF.cl().IlO();
        int size = this.ea.size();
        if (this.zPa) {
            size++;
        }
        if (size + 1 != iIlO) {
            return false;
        }
        vAh.IlO(this.tV, str, this.xF, MY.IlO.tV);
        TTCeilingLandingPageActivity.IlO ilO = this.cl;
        if (ilO != null) {
            ilO.IlO();
        }
        return true;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        this.cL = my;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final String str, final boolean z2, final int i2, final String str2, final String str3) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), this.xF, this.MY, "lp_not_http_open", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.widget.IlO.Cc.2
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("schema", str);
                    jSONObject3.put("jump_url", str3);
                    jSONObject3.put("success", z2);
                    jSONObject3.put("error_type", i2);
                    jSONObject3.put("error_reason", str2);
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("WebChromeClient", "onLpNotHttpLpOpen", th);
                    return jSONObject;
                }
            }
        });
    }
}
