package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.C2300e4;
import com.ironsource.K8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.p8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2502p8 implements K8 {
    private static final String g = "loadWithUrl | webView is not null";
    private static final String h = "p8";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9631i = "file://";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f9634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C2467n8 f9635d;
    private C2376i8 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f9636f;

    /* JADX INFO: renamed from: com.ironsource.p8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f9638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9639c;

        public a(String str, JSONObject jSONObject, String str2) {
            this.f9637a = str;
            this.f9638b = jSONObject;
            this.f9639c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2502p8.this.f9634c != null) {
                A8.a(C2328fe.f8541q, new C2603v8().a(G5.A, C2502p8.g).a());
            }
            try {
                C2502p8.this.b(this.f9637a);
                C2502p8.this.f9634c.loadUrl(C2502p8.this.a(this.f9638b.getString("urlForWebView")));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", C2502p8.this.f9632a);
                C2502p8.this.f9635d.a(this.f9639c, jSONObject);
            } catch (Exception e) {
                C2531r4.d().a(e);
                C2502p8.this.b(this.f9637a, e.getMessage());
                A8.a(C2328fe.f8541q, new C2603v8().a(G5.A, e.getMessage()).a());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p8$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9642b;

        public b(String str, String str2) {
            this.f9641a = str;
            this.f9642b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WebView webView = C2502p8.this.f9634c;
                if (webView != null) {
                    webView.destroy();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", C2502p8.this.f9632a);
                C2467n8 c2467n8 = C2502p8.this.f9635d;
                if (c2467n8 != null) {
                    c2467n8.a(this.f9641a, jSONObject);
                    C2502p8.this.f9635d.b();
                }
                C2502p8 c2502p8 = C2502p8.this;
                c2502p8.f9635d = null;
                c2502p8.f9636f = null;
            } catch (Exception e) {
                C2531r4.d().a(e);
                Log.e(C2502p8.h, "performCleanup | could not destroy ISNAdView webView ID: " + C2502p8.this.f9632a);
                A8.a(C2328fe.f8542r, new C2603v8().a(G5.A, e.getMessage()).a());
                C2502p8.this.b(this.f9642b, e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p8$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements K8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9644a;

        public c(String str) {
            this.f9644a = str;
        }

        @Override // com.ironsource.K8.a
        public void a(String str) {
            Logger.i(C2502p8.h, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
            C2502p8.this.b(this.f9644a, str);
        }

        @Override // com.ironsource.K8.a
        public void b(String str) {
            Logger.i(C2502p8.h, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
            try {
                ((ViewGroup) C2502p8.this.f9634c.getParent()).removeView(C2502p8.this.f9634c);
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            C2502p8.this.d();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p8$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d extends WebChromeClient {
        public /* synthetic */ d(C2502p8 c2502p8, int i2) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z2, boolean z7, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(C2502p8.this.new d());
            webView2.setWebViewClient(new e(C2502p8.this, 0));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        private d() {
        }
    }

    /* JADX INFO: renamed from: com.ironsource.p8$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends WebViewClient {
        public /* synthetic */ e(C2502p8 c2502p8, int i2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(C2502p8.h, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context = webView.getContext();
            Intent intentA = new OpenUrlActivity.e(new k.b()).a(str).b(false).a(context);
            intentA.addFlags(268435456);
            context.startActivity(intentA);
            return true;
        }

        private e() {
        }
    }

    public C2502p8(InterfaceC2429l8 interfaceC2429l8, Context context, String str, C2376i8 c2376i8) {
        this.f9636f = context;
        C2467n8 c2467n8 = new C2467n8();
        this.f9635d = c2467n8;
        c2467n8.g(str);
        this.f9632a = str;
        this.f9635d.a(interfaceC2429l8);
        this.e = c2376i8;
    }

    @Override // com.ironsource.K8
    public WebView getPresentingView() {
        return this.f9634c;
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        this.f9635d.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        a("", "");
    }

    public String a() {
        return this.f9632a;
    }

    public C2467n8 b() {
        return this.f9635d;
    }

    public C2376i8 c() {
        return this.e;
    }

    public void e(String str) {
        this.f9633b = str;
    }

    private String d(String str) {
        String strSubstring = str.substring(str.indexOf("/") + 1);
        return strSubstring.substring(strSubstring.indexOf("/"));
    }

    @Override // com.ironsource.K8
    public void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.f9635d.e(str);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            Logger.i(h, "sendHandleGetViewVisibility fail with reason: " + e4.getMessage());
        }
    }

    @Override // com.ironsource.K8
    public void b(JSONObject jSONObject, String str, String str2) {
        V7.f7731a.d(new a(str2, jSONObject, str));
    }

    @Override // com.ironsource.K8
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.f9635d.a(jSONObject.getString("params"), str, str2);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            Logger.i(h, "sendMessageToAd fail message: " + e4.getMessage());
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Logger.i(h, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(this.f9636f);
        this.f9634c = webView;
        webView.addJavascriptInterface(new C2447m8(this), C2393j8.e);
        this.f9634c.setWebViewClient(new C2485o8(new c(str)));
        this.f9634c.setWebChromeClient(new d(this, 0));
        Ng.a(this.f9634c);
        this.f9635d.a(this.f9634c);
    }

    @Override // com.ironsource.K8
    public synchronized void a(String str, String str2) {
        if (this.f9636f == null) {
            return;
        }
        Logger.i(h, "performCleanup");
        V7.f7731a.d(new b(str, str2));
    }

    private boolean c(String str) {
        return str.startsWith(".");
    }

    @Override // com.ironsource.K8
    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, C2300e4.c.D);
            return;
        }
        Logger.i(h, "trying to perform WebView Action: " + str);
        try {
            if (str.equals(C2300e4.h.t0)) {
                this.f9634c.onPause();
                this.f9635d.f(str2);
            } else if (str.equals(C2300e4.h.f8387u0)) {
                this.f9634c.onResume();
                this.f9635d.f(str2);
            } else {
                b(str3, C2300e4.c.C);
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            b(str3, C2300e4.c.E);
        }
    }

    public void b(String str, String str2) {
        C2467n8 c2467n8 = this.f9635d;
        if (c2467n8 != null) {
            c2467n8.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (!c(str)) {
            return str;
        }
        return "file://" + this.f9633b + d(str);
    }
}
