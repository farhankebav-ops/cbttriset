package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.lEW.EO;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.ironsource.C2318f4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends com.bytedance.sdk.component.DmF.vCE implements EO.InterfaceC0099EO {
    AtomicBoolean Bc;
    protected boolean Cc;
    private EO DmF;
    private String EV;
    private com.bytedance.sdk.openadsdk.core.model.oeT NV;
    private MY bWL;
    private int ea;
    private List<String> hp;
    private vAh lEW;
    private int rp;
    protected boolean tV;
    AtomicBoolean vCE;
    private long zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends vCE.IlO {
        public static final Set<String> IlO = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Cc.IlO.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        EO.InterfaceC0099EO MY;

        public IlO(EO.InterfaceC0099EO interfaceC0099EO) {
            this.MY = interfaceC0099EO;
        }

        private void IlO(String str) {
            int iLastIndexOf;
            EO.InterfaceC0099EO interfaceC0099EO;
            if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!IlO.contains(str.substring(iLastIndexOf).toLowerCase()) || (interfaceC0099EO = this.MY) == null) {
                    return;
                }
                interfaceC0099EO.MY(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            EO.InterfaceC0099EO interfaceC0099EO = this.MY;
            if (interfaceC0099EO != null) {
                interfaceC0099EO.IlO();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                IlO(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            IlO(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.MY.IlO(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            IlO(webResourceRequest.getUrl().toString());
        }

        private void IlO(String str, int i2, String str2) {
            EO.InterfaceC0099EO interfaceC0099EO = this.MY;
            if (interfaceC0099EO != null) {
                interfaceC0099EO.IlO(106, i2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        View IlO();

        void IlO(int i2, int i8);

        void IlO(View view, int i2);

        View MY();

        void i_();
    }

    public Cc(Context context) {
        super(context);
        this.tV = false;
        this.Cc = false;
        this.vCE = new AtomicBoolean(false);
        this.Bc = new AtomicBoolean(false);
        this.rp = 0;
    }

    private void AXM() {
        if (this.hp == null) {
            com.bytedance.sdk.openadsdk.tV.EO.MY(this.NV, this.EV, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.lEW.Cc.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Cc.this.hp != null && Cc.this.Bc.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = Cc.this.hp.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.tV.EO.MY(Cc.this.NV, Cc.this.EV, "dsp_html_error_url", jSONObject);
                            Cc.this.hp = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void es() {
        MY my = this.bWL;
        if (my != null) {
            my.i_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.zPa);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.NV, this.EV, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.component.DmF.vCE, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.tV) {
            this.DmF.IlO(getWebView());
        }
    }

    @Override // com.bytedance.sdk.component.DmF.vCE, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.DmF.IlO();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.ea / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.NV, this.EV, "load_rate", jSONObject);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        boolean z2 = i2 == 0;
        this.Cc = z2;
        this.DmF.IlO(z2);
    }

    public void xF() {
        this.vCE.set(false);
        String strKS = this.NV.KS();
        if (TextUtils.isEmpty(strKS)) {
            return;
        }
        String strIlO = com.bytedance.sdk.openadsdk.core.EV.Cc.IlO(strKS);
        String str = TextUtils.isEmpty(strIlO) ? strKS : strIlO;
        this.rp = 0;
        IlO(null, str, "text/html", Key.STRING_CHARSET_NAME, null);
        this.zPa = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.component.DmF.vCE
    public void zPa() {
        this.DmF.MY();
        super.zPa();
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.EO.InterfaceC0099EO
    public void MY(String str) {
        if (this.hp == null) {
            this.hp = new ArrayList();
        }
        this.hp.add(str);
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, MY my, String str) {
        this.bWL = my;
        this.NV = oet;
        this.EV = str;
        this.DmF = new EO();
        this.lEW = new vAh(getContext());
        setWebViewClient(new IlO(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Cc.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                Cc.this.ea = i2;
                super.onProgressChanged(webView, i2);
                if (i2 >= 100) {
                    Cc.this.IlO();
                }
            }
        });
        com.bytedance.sdk.component.utils.DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Cc.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = Cc.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.lEW.Cc.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            Cc.this.lEW.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO {
        protected int IlO = 0;
        private com.bytedance.sdk.openadsdk.core.EV.vCE MY = com.bytedance.sdk.openadsdk.core.EV.vCE.IlO();

        public void IlO(WebView webView) {
            if (webView != null && this.IlO == 0) {
                if (this.MY == null) {
                    this.MY = com.bytedance.sdk.openadsdk.core.EV.vCE.IlO();
                }
                this.MY.IlO(webView);
                this.MY.MY();
                this.IlO = 1;
            }
        }

        public void MY() {
            IlO();
        }

        public void IlO(boolean z2) {
            com.bytedance.sdk.openadsdk.core.EV.vCE vce;
            if (this.IlO == 1 && z2 && (vce = this.MY) != null) {
                vce.EO();
                this.IlO = 3;
            }
        }

        public void IlO(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.EV.vCE vce = this.MY;
            if (vce != null) {
                vce.IlO(view, friendlyObstructionPurpose);
            }
        }

        public void IlO() {
            com.bytedance.sdk.openadsdk.core.EV.vCE vce;
            int i2 = this.IlO;
            if (i2 != 0 && i2 != 4 && (vce = this.MY) != null) {
                vce.tV();
            }
            this.IlO = 4;
            this.MY = null;
        }
    }

    public void IlO(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.DmF.IlO(view, friendlyObstructionPurpose);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.EO.InterfaceC0099EO
    public void IlO(String str) {
        String strMY;
        boolean zIlO;
        View view;
        if (TextUtils.isEmpty(str) || this.NV == null || !this.lEW.MY()) {
            return;
        }
        int iIlO = zLG.IlO(this.EV);
        View view2 = null;
        if (com.bytedance.sdk.component.utils.xF.IlO(str) || !(this.NV.zTS() == null || TextUtils.isEmpty(this.NV.zTS().IlO()))) {
            strMY = str;
        } else {
            com.bytedance.sdk.openadsdk.core.model.EV ev = new com.bytedance.sdk.openadsdk.core.model.EV();
            ev.IlO(str);
            this.NV.IlO(ev);
            strMY = null;
        }
        this.NV.IlO(true);
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.NV;
        if (oet == null || oet.zTS() == null || TextUtils.isEmpty(this.NV.zTS().IlO())) {
            zIlO = false;
        } else {
            zIlO = lMM.IlO(getContext(), this.NV, iIlO, this.EV, true, (Map<String, Object>) null);
            if (!zIlO && !TextUtils.isEmpty(this.NV.zTS().MY())) {
                strMY = this.NV.zTS().MY();
                com.bytedance.sdk.openadsdk.tV.EO.IlO(this.NV, this.EV, "open_fallback_url", (Map<String, Object>) null);
            }
        }
        String str2 = strMY;
        if (!zIlO) {
            if (TextUtils.isEmpty(str2)) {
                return;
            } else {
                lMM.IlO(getContext(), this.NV, iIlO, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.EO.IlO) null, this.EV, true, str2);
            }
        }
        if (this.lEW != null) {
            MY my = this.bWL;
            if (my != null) {
                View viewIlO = my.IlO();
                View viewMY = this.bWL.MY();
                this.bWL.IlO(this, 2);
                view2 = viewMY;
                view = viewIlO;
            } else {
                view = null;
            }
            com.bytedance.sdk.openadsdk.core.model.NV nvIlO = this.lEW.IlO(getContext(), view2, view);
            HashMap map = new HashMap();
            map.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, this.NV, nvIlO, this.EV, true, (Map<String, Object>) map, this.lEW.MY() ? 1 : 2);
        }
        vAh vah = this.lEW;
        if (vah != null) {
            vah.IlO();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.EO.InterfaceC0099EO
    public void IlO(int i2, int i8) {
        MY my = this.bWL;
        if (my != null) {
            my.IlO(i2, i8);
        }
        this.rp = i8;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", i8);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.zPa);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(this.NV, this.EV, "render_html_fail", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lEW.EO.InterfaceC0099EO
    public void IlO() {
        if (this.vCE.compareAndSet(false, true)) {
            this.tV = true;
            this.DmF.IlO(getWebView());
            this.DmF.IlO(this.Cc);
            es();
            AXM();
        }
    }
}
