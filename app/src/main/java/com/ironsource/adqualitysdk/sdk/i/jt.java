package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.ironsource.adqualitysdk.sdk.i.az;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class jt implements jm {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Map<WebView, jt> f2887 = new WeakHashMap();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private jp f2888;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Set<jm> f2889 = new HashSet();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f2890;

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.jt$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass5 extends WebChromeClient {

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private boolean f2895 = false;

        public AnonymousClass5() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            jt.this.mo305(webView, str2);
            return false;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView webView, int i2) {
            if (i2 != 100 || this.f2895) {
                return;
            }
            this.f2895 = true;
            jt.this.mo304(webView);
        }
    }

    private jt(WebView webView, String str) {
        this.f2890 = str;
        jp jpVar = new jp(webView);
        this.f2888 = jpVar;
        jpVar.m2753(new AnonymousClass2());
        this.f2888.m2750(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final az.e m2768() {
        return this.f2888.m2749();
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2770(jm jmVar) {
        this.f2889.remove(jmVar);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2771() {
        this.f2888.m2750(new AnonymousClass5());
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2773() {
        this.f2888.m2753(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.jt$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 extends WebViewClient {

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private boolean f2894 = false;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private boolean f2891 = false;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private String f2893 = null;

        public AnonymousClass2() {
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private boolean m2775(WebView webView) {
            if (this.f2894 && this.f2891) {
                return true;
            }
            return (webView.getOriginalUrl() == null || this.f2893 == null || webView.getOriginalUrl().equals(this.f2893)) ? false : true;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            jt.this.mo304(webView);
            this.f2894 = false;
            this.f2891 = true;
            if (this.f2893 == null) {
                this.f2893 = webView.getOriginalUrl();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            jt.this.mo304(webView);
            this.f2894 = true;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (m2776(webView, str)) {
                return true;
            }
            if (this.f2893 == null) {
                this.f2893 = webView.getOriginalUrl();
            }
            jt.this.mo303(webView, str, m2775(webView));
            this.f2891 = true;
            this.f2894 = false;
            return false;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private boolean m2776(WebView webView, String str) {
            if (!str.startsWith(jt.this.f2890)) {
                return false;
            }
            this.f2893 = webView.getOriginalUrl();
            String strSubstring = str.substring(jt.this.f2890.length());
            jt jtVar = jt.this;
            jtVar.mo302(webView, jtVar.f2890, strSubstring);
            return true;
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 24)
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static jt m2766(WebView webView, String str) {
        jt jtVar = f2887.get(webView);
        if (jtVar != null) {
            return jtVar;
        }
        jt jtVar2 = new jt(webView, str);
        f2887.put(webView, jtVar2);
        return jtVar2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final WebView m2769() {
        return this.f2888.m2752();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jm
    /* JADX INFO: renamed from: ﻛ */
    public final void mo302(WebView webView, String str, String str2) {
        for (jm jmVar : new HashSet(this.f2889)) {
            if (jmVar != null) {
                jmVar.mo302(webView, str, str2);
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2774(jm jmVar) {
        this.f2889.add(jmVar);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final boolean m2772() {
        return this.f2888.m2751();
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jm
    /* JADX INFO: renamed from: ﾒ */
    public final void mo304(WebView webView) {
        for (jm jmVar : new HashSet(this.f2889)) {
            if (jmVar != null) {
                jmVar.mo304(webView);
            }
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jm
    /* JADX INFO: renamed from: ﻛ */
    public final void mo303(WebView webView, String str, boolean z2) {
        for (jm jmVar : new HashSet(this.f2889)) {
            if (jmVar != null) {
                jmVar.mo303(webView, str, z2);
            }
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.jm
    /* JADX INFO: renamed from: ﾒ */
    public final void mo305(WebView webView, String str) {
        for (jm jmVar : new HashSet(this.f2889)) {
            if (jmVar != null) {
                jmVar.mo305(webView, str);
            }
        }
    }
}
