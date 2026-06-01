package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.bumptech.glide.load.Key;
import com.ironsource.A8;
import com.ironsource.B4;
import com.ironsource.B7;
import com.ironsource.C1;
import com.ironsource.C2228a4;
import com.ironsource.C2246b4;
import com.ironsource.C2265c5;
import com.ironsource.C2291dd;
import com.ironsource.C2300e4;
import com.ironsource.C2306ea;
import com.ironsource.C2309ed;
import com.ironsource.C2328fe;
import com.ironsource.C2336g4;
import com.ironsource.C2346ge;
import com.ironsource.C2354h4;
import com.ironsource.C2360ha;
import com.ironsource.C2366hg;
import com.ironsource.C2385j0;
import com.ironsource.C2390j5;
import com.ironsource.C2411k8;
import com.ironsource.C2425l4;
import com.ironsource.C2481o4;
import com.ironsource.C2519q8;
import com.ironsource.C2528r1;
import com.ironsource.C2531r4;
import com.ironsource.C2569t8;
import com.ironsource.C2586u8;
import com.ironsource.C2603v8;
import com.ironsource.C2654y8;
import com.ironsource.C8;
import com.ironsource.G5;
import com.ironsource.InterfaceC2249b7;
import com.ironsource.InterfaceC2303e7;
import com.ironsource.InterfaceC2407k4;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.InterfaceC2554sa;
import com.ironsource.InterfaceC2562t1;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.InterfaceC2599v4;
import com.ironsource.InterfaceC2616w4;
import com.ironsource.InterfaceC2633x4;
import com.ironsource.InterfaceC2650y4;
import com.ironsource.Je;
import com.ironsource.K8;
import com.ironsource.L;
import com.ironsource.Mb;
import com.ironsource.Mg;
import com.ironsource.Ng;
import com.ironsource.Ob;
import com.ironsource.Pc;
import com.ironsource.Q6;
import com.ironsource.Sc;
import com.ironsource.Tc;
import com.ironsource.Uc;
import com.ironsource.V7;
import com.ironsource.Y0;
import com.ironsource.Y1;
import com.ironsource.Y3;
import com.ironsource.Y4;
import com.ironsource.Z0;
import com.ironsource.Z4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.ironsource.ii;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.og;
import com.ironsource.ri;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.controller.m;
import com.ironsource.sdk.controller.p;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class v implements com.ironsource.sdk.controller.l, Pc, DownloadListener {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final String f10081b0 = "about:blank";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static int f10082c0 = 0;
    public static String d0 = "is_store";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static String f10083e0 = "external_url";
    public static String f0 = "secondary_web_view";
    private static String g0 = "success";
    private static String h0 = "fail";
    private String A;
    private com.ironsource.sdk.controller.d B;
    private og C;
    private Z0 D;
    private Z4 G;
    private com.ironsource.sdk.controller.o H;
    private com.ironsource.sdk.controller.q I;
    private com.ironsource.sdk.controller.u J;
    private com.ironsource.sdk.controller.i K;
    private com.ironsource.sdk.controller.a L;
    private com.ironsource.sdk.controller.j M;
    private C2528r1 N;
    private B4 O;
    private Mg P;
    private com.ironsource.sdk.controller.c Q;
    private Y3 R;
    private JSONObject S;
    private l.a T;
    private l.b U;
    private C2481o4 V;
    private boolean W;
    C2354h4 Y;
    final C2360ha Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V7 f10084a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Sc f10085a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2407k4 f10086b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10089f;
    private String g;
    private final C2390j5 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10090i;
    private p j;
    private boolean k;
    private CountDownTimer l;
    public CountDownTimer m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final o f10093q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private View f10094r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FrameLayout f10095s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f10096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FrameLayout f10097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private u f10098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f10099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private InterfaceC2650y4 f10100x;
    private InterfaceC2633x4 y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private InterfaceC2616w4 f10101z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10087c = "v";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10088d = "IronSource";
    private final String e = "We're sorry, some error occurred. we will investigate it";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f10091n = 50;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f10092o = 50;
    private String p = C2300e4.e.f8332b;
    private Object E = new Object();
    private boolean F = false;
    private final B7 X = Mb.U().i();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2586u8 f10103a;

        public b(C2586u8 c2586u8) {
            this.f10103a = c2586u8;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.Q.c("controller html - failed to download - " + this.f10103a.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10105a;

        public c(Context context) {
            this.f10105a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e(this.f10105a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10107a;

        public d(Context context) {
            this.f10107a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.f(this.f10107a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2569t8.e f10109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10110b;

        public e(C2569t8.e eVar, String str) {
            this.f10109a = eVar;
            this.f10110b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2599v4 interfaceC2599v4A;
            C2569t8.e eVar = this.f10109a;
            if ((eVar == C2569t8.e.RewardedVideo || eVar == C2569t8.e.Interstitial) && (interfaceC2599v4A = v.this.a(eVar)) != null) {
                interfaceC2599v4A.b(this.f10109a, this.f10110b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class g implements Mg {
        public g() {
        }

        @Override // com.ironsource.Mg
        public void a(String str, JSONObject jSONObject) {
            v.this.i(v.this.e(str, jSONObject.toString()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f10114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WebView f10115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10116c;

        public h(JSONObject jSONObject, WebView webView, String str) {
            this.f10114a = jSONObject;
            this.f10115b = webView;
            this.f10116c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(this.f10114a, this.f10115b);
            v.this.l("about:blank");
            v.this.l(this.f10116c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10118a;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Q.c(C2300e4.c.j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(long j, long j3, int i2) {
            super(j, j3);
            this.f10118a = i2;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(v.this.f10087c, "Loading Controller Timer Finish");
            int i2 = this.f10118a;
            if (i2 == 3) {
                v.this.b(new a());
            } else {
                v.this.a(i2 + 1);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(v.this.f10087c, "Loading Controller Timer Tick " + j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class j implements s {
        public j() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C2569t8.e eVar, Y4 y42) {
            v.this.a(str, eVar, y42);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class k implements s {
        public k() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C2569t8.e eVar, Y4 y42) {
            v.this.a(str, eVar, y42);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class l implements s {
        public l() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C2569t8.e eVar, Y4 y42) {
            v.this.a(str, eVar, y42);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C2569t8.e f10124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Y4 f10125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10126c;

        public m(C2569t8.e eVar, Y4 y42, String str) {
            this.f10124a = eVar;
            this.f10125b = y42;
            this.f10126c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y4 y42;
            C2569t8.e eVar = C2569t8.e.RewardedVideo;
            C2569t8.e eVar2 = this.f10124a;
            if ((eVar != eVar2 && C2569t8.e.Interstitial != eVar2 && C2569t8.e.Banner != eVar2) || (y42 = this.f10125b) == null || TextUtils.isEmpty(y42.h())) {
                return;
            }
            InterfaceC2599v4 interfaceC2599v4A = v.this.a(this.f10124a);
            Log.d(v.this.f10087c, "onAdProductInitFailed (message:" + this.f10126c + ")(" + this.f10124a + ")");
            if (interfaceC2599v4A != null) {
                interfaceC2599v4A.a(this.f10124a, this.f10125b.h(), this.f10126c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class o extends WebChromeClient {
        public /* synthetic */ o(v vVar, int i2) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(v.this.Z.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z2, boolean z7, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new q(v.this, 0));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            View view = v.this.f10094r;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            v vVar = v.this;
            vVar.f10095s.removeView(vVar.f10094r);
            v vVar2 = v.this;
            vVar2.f10094r = null;
            vVar2.f10095s.setVisibility(8);
            v.this.f10096t.onCustomViewHidden();
            v.this.Z.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            v.this.Z.setVisibility(8);
            if (v.this.f10094r != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            v.this.f10095s.addView(view);
            v vVar = v.this;
            vVar.f10094r = view;
            vVar.f10096t = customViewCallback;
            vVar.f10095s.setVisibility(0);
        }

        private o() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        C2569t8.e f10130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f10131b;

        public p(C2569t8.e eVar, String str) {
            this.f10130a = eVar;
            this.f10131b = str;
        }

        public String a() {
            return this.f10131b;
        }

        public C2569t8.e b() {
            return this.f10130a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class q extends WebViewClient {
        public /* synthetic */ q(v vVar, int i2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(v.this.f10087c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context contextP = v.this.p();
            contextP.startActivity(new OpenUrlActivity.e(new k.b()).a(str).b(false).a(contextP));
            return true;
        }

        private q() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class r {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10134a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10135b;

            public a(String str, String str2) {
                this.f10134a = str;
                this.f10135b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f10134a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f10087c, "onRVShowFail(message:" + this.f10134a + ")");
                v.this.f10100x.b(this.f10135b, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10137a;

            public b(String str) {
                this.f10137a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f10087c, "onInterstitialInitSuccess()");
                v.this.y.a(C2569t8.e.Interstitial, this.f10137a, (Y0) null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10139a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10140b;

            public c(String str, String str2) {
                this.f10139a = str;
                this.f10140b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f10139a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f10087c, "onInterstitialInitFail(message:" + str + ")");
                v.this.y.a(C2569t8.e.Interstitial, this.f10140b, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC2599v4 f10142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ C2569t8.e f10143b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f10144c;

            public d(InterfaceC2599v4 interfaceC2599v4, C2569t8.e eVar, String str) {
                this.f10142a = interfaceC2599v4;
                this.f10143b = eVar;
                this.f10144c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f10142a.a(this.f10143b, this.f10144c);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10146a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ JSONObject f10147b;

            public e(String str, JSONObject jSONObject) {
                this.f10146a = str;
                this.f10147b = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.a(this.f10146a, this.f10147b);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10149a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10150b;

            public f(String str, String str2) {
                this.f10149a = str;
                this.f10150b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f10149a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.a(this.f10150b, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10152a;

            public g(String str) {
                this.f10152a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f10087c, "onBannerInitSuccess()");
                v.this.f10101z.a(C2569t8.e.Banner, this.f10152a, (Y0) null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10154a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10155b;

            public h(String str, String str2) {
                this.f10154a = str;
                this.f10155b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f10154a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f10087c, "onBannerInitFail(message:" + str + ")");
                v.this.f10101z.a(C2569t8.e.Banner, this.f10155b, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ C2411k8 f10158b;

            public i(String str, C2411k8 c2411k8) {
                this.f10157a = str;
                this.f10158b = c2411k8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f10087c, "onBannerLoadSuccess()");
                v.this.f10101z.a(this.f10157a, this.f10158b);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class j implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10160a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10161b;

            public j(String str, String str2) {
                this.f10160a = str;
                this.f10161b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f10087c, "onLoadBannerFail()");
                String str = this.f10160a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.f10101z.c(this.f10161b, str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class k implements Runnable {
            public k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.E();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class l implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10164a;

            public l(String str) {
                this.f10164a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (new JSONObject(this.f10164a).has(f.b.f9965b)) {
                        v.this.T.a(f.a.a(this.f10164a));
                    } else {
                        v.this.U.a(Ob.a(this.f10164a));
                    }
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    Logger.e(v.this.f10087c, "failed to parse received message");
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class m implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C2569t8.e f10166a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10167b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f10168c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ JSONObject f10169d;

            public m(C2569t8.e eVar, String str, String str2, JSONObject jSONObject) {
                this.f10166a = eVar;
                this.f10167b = str;
                this.f10168c = str2;
                this.f10169d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC2599v4 interfaceC2599v4A;
                C2569t8.e eVar = this.f10166a;
                if ((eVar == C2569t8.e.Interstitial || eVar == C2569t8.e.RewardedVideo || eVar == C2569t8.e.Banner) && (interfaceC2599v4A = v.this.a(eVar)) != null) {
                    interfaceC2599v4A.a(this.f10166a, this.f10167b, this.f10168c, this.f10169d);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class n implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10170a;

            public n(String str) {
                this.f10170a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.i(v.this.f10087c, "omidAPI(" + this.f10170a + ")");
                    v.this.H.a(new C2346ge(this.f10170a).toString(), r.this.new w());
                } catch (Exception e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.f10087c, "omidAPI failed with exception " + e.getMessage());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class o implements Runnable {
            public o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.A();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class p implements Runnable {
            public p() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.removeJavascriptInterface(C2300e4.e);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class q implements Runnable {
            public q() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.getSettings().setMixedContentMode(0);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$r, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class RunnableC0199r implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f10175a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10176b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Y0 f10177c;

            public RunnableC0199r(int i2, String str, Y0 y02) {
                this.f10175a = i2;
                this.f10176b = str;
                this.f10177c = y02;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f10175a <= 0) {
                    v.this.f10100x.c(this.f10176b);
                } else {
                    Log.d(v.this.f10087c, "onRVInitSuccess()");
                    v.this.f10100x.a(C2569t8.e.RewardedVideo, this.f10176b, this.f10177c);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class s implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10179a;

            public s(String str) {
                this.f10179a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    v.this.M.a(new JSONObject(this.f10179a), r.this.new w());
                } catch (Exception e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.f10087c, "fileSystemAPI failed with exception " + e.getMessage());
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class t implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10181a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10182b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f10183c;

            public t(String str, String str2, int i2) {
                this.f10181a = str;
                this.f10182b = str2;
                this.f10183c = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f10181a.equalsIgnoreCase(C2569t8.e.RewardedVideo.toString())) {
                    v.this.f10100x.a(this.f10182b, this.f10183c);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class u implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10185a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f10186b;

            public u(String str, int i2) {
                this.f10185a = str;
                this.f10186b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.onInterstitialAdRewarded(this.f10185a, this.f10186b);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$v, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class RunnableC0200v implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f10188a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f10189b;

            public RunnableC0200v(String str, String str2) {
                this.f10188a = str;
                this.f10189b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f10188a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f10087c, "onRVInitFail(message:" + str + ")");
                v.this.f10100x.a(C2569t8.e.RewardedVideo, this.f10189b, str);
            }
        }

        public r() {
        }

        @JavascriptInterface
        public void adClicked(String str) {
            Logger.i(v.this.f10087c, "adClicked(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d(C2300e4.h.m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            C2569t8.e eVarG = v.this.g(strD);
            InterfaceC2599v4 interfaceC2599v4A = v.this.a(eVarG);
            if (eVarG == null || interfaceC2599v4A == null) {
                return;
            }
            v.this.b(new d(interfaceC2599v4A, eVarG, strFetchDemandSourceId));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            Log.d(v.this.f10088d, "adCredited(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d(C2300e4.h.k);
            int i2 = strD != null ? Integer.parseInt(strD) : 0;
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            String strD2 = c2346ge.d(C2300e4.h.m);
            if (TextUtils.isEmpty(strD2)) {
                Log.d(v.this.f10088d, "adCredited | product type is missing");
            }
            if (C2569t8.e.Interstitial.toString().equalsIgnoreCase(strD2)) {
                a(strFetchDemandSourceId, i2);
            } else if (v.this.q(strD2)) {
                v.this.b(new t(strD2, strFetchDemandSourceId, i2));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            Logger.i(v.this.f10087c, "adUnitsReady(" + str + ")");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new C2346ge(str));
            Y0 y02 = new Y0(str);
            if (!y02.g()) {
                v.this.a(str, false, C2300e4.c.f8317r, (String) null);
                return;
            }
            v.this.a(str, true, (String) null, (String) null);
            String strD = y02.d();
            if (C2569t8.e.RewardedVideo.toString().equalsIgnoreCase(strD) && v.this.q(strD)) {
                v.this.b(new RunnableC0199r(Integer.parseInt(y02.c()), strFetchDemandSourceId, y02));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                Logger.i(v.this.f10087c, "adViewAPI(" + str + ")");
                v.this.L.a(new C2346ge(str).toString(), new w());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                Logger.i(v.this.f10087c, "adViewAPI failed with exception " + e4.getMessage());
            }
        }

        @JavascriptInterface
        public void androidSandboxApi(String str) {
            V7.f7731a.b(new a3.c(24, this, str));
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(v.this.f10087c, "bannerViewAPI is not supported in this native version, only adview API");
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            C2569t8.e eVarG;
            try {
                Logger.i(v.this.f10087c, "cleanAdInstance(" + str + ")");
                C2346ge c2346ge = new C2346ge(str);
                String strD = c2346ge.d(C2300e4.h.m);
                String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
                if (TextUtils.isEmpty(strFetchDemandSourceId) || (eVarG = v.this.g(strD)) == null) {
                    return;
                }
                v.this.G.b(eVarG, strFetchDemandSourceId);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> arrayListA = C2306ea.e().a();
                C2346ge c2346ge = new C2346ge(str);
                if (!arrayListA.isEmpty()) {
                    c2346ge.b(C2300e4.h.f8393x0, arrayListA.toString());
                }
                v.this.a(c2346ge.toString(), true, (String) null, (String) null);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        public void d(String str) {
            v.this.i(v.this.a(C2300e4.g.e, str, (String) null, (String) null));
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                Logger.i(v.this.f10087c, "deleteFile(" + str + ")");
                C2346ge c2346ge = new C2346ge(str);
                String strD = c2346ge.d(C2300e4.h.f8363b);
                String strD2 = c2346ge.d("path");
                if (strD2 != null && !TextUtils.isEmpty(strD)) {
                    C8 c8 = new C8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD2), strD);
                    IronSourceStorageUtils.ensurePathSafety(c8, v.this.A);
                    if (!c8.exists()) {
                        v.this.a(str, false, C2300e4.c.f8312f, "1");
                        return;
                    } else {
                        v.this.a(str, IronSourceStorageUtils.deleteFile(c8), (String) null, (String) null);
                        return;
                    }
                }
                v.this.a(str, false, C2300e4.c.g, "1");
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                Logger.i(v.this.f10087c, "deleteFolder(" + str + ")");
                String strD = new C2346ge(str).d("path");
                if (strD == null) {
                    v.this.a(str, false, C2300e4.c.g, "1");
                    return;
                }
                C8 c8 = new C8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD));
                IronSourceStorageUtils.ensurePathSafety(c8, v.this.A);
                if (!c8.exists()) {
                    v.this.a(str, false, C2300e4.c.e, "1");
                } else {
                    v.this.a(str, IronSourceStorageUtils.deleteFolder(c8.getPath()), (String) null, (String) null);
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                Logger.i(v.this.f10087c, "deviceDataAPI(" + str + ")");
                v.this.K.a(new C2346ge(str).toString(), new w());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                Logger.i(v.this.f10087c, "deviceDataAPI failed with exception " + e4.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            a0.m("displayWebView(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
            C2346ge c2346ge = new C2346ge(str);
            boolean zBooleanValue = ((Boolean) c2346ge.b("display")).booleanValue();
            String strD = c2346ge.d(C2300e4.h.m);
            boolean zC = c2346ge.c(C2300e4.h.f8386u);
            String strD2 = c2346ge.d("adViewId");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            boolean zC2 = c2346ge.c(C2300e4.h.f8396z0);
            if (!zBooleanValue) {
                v.this.a(u.Gone);
                v.this.n();
                return;
            }
            v.this.F = c2346ge.c(C2300e4.h.f8388v);
            boolean zC3 = c2346ge.c(C2300e4.h.y);
            u uVarU = v.this.u();
            u uVar = u.Display;
            if (uVarU == uVar) {
                Logger.i(v.this.f10087c, "State: " + v.this.f10098v);
                return;
            }
            v.this.a(uVar);
            Logger.i(v.this.f10087c, "State: " + v.this.f10098v);
            Context contextP = v.this.p();
            String strS = v.this.s();
            int iK = v.this.X.K(contextP);
            if (zC) {
                com.ironsource.sdk.controller.h hVar = new com.ironsource.sdk.controller.h(contextP);
                hVar.addView(v.this.f10097u);
                hVar.a(v.this);
                return;
            }
            Intent intent = zC3 ? new Intent(contextP, (Class<?>) InterstitialActivity.class) : new Intent(contextP, (Class<?>) ControllerActivity.class);
            C2569t8.e eVar = C2569t8.e.RewardedVideo;
            if (eVar.toString().equalsIgnoreCase(strD)) {
                if ("application".equals(strS)) {
                    strS = SDKUtils.translateRequestedOrientation(v.this.X.N(contextP));
                }
                intent.putExtra(C2300e4.h.m, eVar.toString());
                v.this.D.a(eVar.ordinal());
                v.this.D.f(strFetchDemandSourceId);
                if (v.this.q(eVar.toString())) {
                    v.this.f10100x.c(eVar, strFetchDemandSourceId);
                }
            } else {
                C2569t8.e eVar2 = C2569t8.e.Interstitial;
                if (eVar2.toString().equalsIgnoreCase(strD)) {
                    if ("application".equals(strS)) {
                        strS = SDKUtils.translateRequestedOrientation(v.this.X.N(contextP));
                    }
                    intent.putExtra(C2300e4.h.m, eVar2.toString());
                }
            }
            if (strD2 != null) {
                intent.putExtra("adViewId", strD2);
            }
            intent.putExtra(C2300e4.h.f8396z0, zC2);
            intent.setFlags(536870912);
            intent.putExtra(C2300e4.h.f8388v, v.this.F);
            intent.putExtra(C2300e4.h.A, strS);
            intent.putExtra(C2300e4.h.B, iK);
            v vVar = v.this;
            vVar.j = new p(vVar.g(strD), strFetchDemandSourceId);
            contextP.startActivity(intent);
        }

        @JavascriptInterface
        public void dsSharedSignalsAPI(String str) {
            try {
                Logger.i(v.this.f10087c, "dsSharedSignalsAPI(" + str + ")");
                v.this.O.a(new C2346ge(str).toString(), new w());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                Logger.i(v.this.f10087c, "dsSharedSignalsAPI failed with exception " + e4.getMessage());
            }
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            a0.m("fileSystemAPI(", str, ")", v.this.f10087c);
            v.this.a(new s(str));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.B(r0)
                java.lang.String r1 = "getApplicationInfo("
                java.lang.String r2 = ")"
                com.ironsource.adqualitysdk.sdk.i.a0.m(r1, r5, r2, r0)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.f0(r0, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = com.ironsource.sdk.controller.v.d0(r1, r5)
                com.ironsource.ge r2 = new com.ironsource.ge
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.d(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.SDKUtils.fetchDemandSourceId(r2)
                com.ironsource.sdk.controller.v r3 = com.ironsource.sdk.controller.v.this
                java.lang.Object[] r5 = com.ironsource.sdk.controller.v.j0(r3, r5, r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L46
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L4d
                r0 = r1
                goto L4e
            L46:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L4d
                goto L4e
            L4d:
                r0 = 0
            L4e:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L63
                com.ironsource.sdk.controller.v r5 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = com.ironsource.sdk.controller.v.Y(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                com.ironsource.sdk.controller.v.l0(r0, r5)
            L63:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.v.r.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            a0.m("getCachedFilesMap(", str, ")", v.this.f10087c);
            String strE = v.this.e(str);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            C2346ge c2346ge = new C2346ge(str);
            if (!c2346ge.a("path")) {
                v.this.a(str, false, C2300e4.c.f8318s, (String) null);
                return;
            }
            String str2 = (String) c2346ge.b("path");
            if (!IronSourceStorageUtils.isPathExist(v.this.A, str2)) {
                v.this.a(str, false, C2300e4.c.f8319t, (String) null);
                return;
            }
            v.this.i(v.this.a(strE, IronSourceStorageUtils.getCachedFilesMap(v.this.A, str2), C2300e4.g.f8352s, C2300e4.g.f8351r));
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String strE;
            Logger.i(v.this.f10087c, "getConnectivityInfo(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d(v.g0);
            String strD2 = c2346ge.d(v.h0);
            JSONObject jSONObject = new JSONObject();
            v vVar = v.this;
            Y3 y32 = vVar.R;
            if (y32 != null) {
                jSONObject = y32.a(vVar.Z.getContext());
            }
            if (jSONObject.length() > 0) {
                strE = v.this.e(strD, jSONObject.toString());
            } else {
                strE = v.this.e(strD2, v.Z(v.this, "errMsg", C2300e4.c.A, null, null, null, null, null, null));
            }
            v.this.i(strE);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            Logger.i(v.this.f10087c, "getControllerConfig(" + str + ")");
            String strD = new C2346ge(str).d(v.g0);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            c(controllerConfigAsJSONObject);
            v.this.i(v.this.e(strD, controllerConfigAsJSONObject.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String strD;
            Logger.i(v.this.f10087c, "getMediationState(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD2 = c2346ge.d("demandSourceName");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            String strD3 = c2346ge.d(C2300e4.h.m);
            if (strD3 == null || strD2 == null) {
                return;
            }
            try {
                C2569t8.e productType = SDKUtils.getProductType(strD3);
                if (productType != null) {
                    Y4 y4A = v.this.G.a(productType, strFetchDemandSourceId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C2300e4.h.m, strD3);
                    jSONObject.put("demandSourceName", strD2);
                    jSONObject.put("demandSourceId", strFetchDemandSourceId);
                    if (y4A == null || y4A.a(-1)) {
                        strD = v.this.d(str);
                    } else {
                        strD = v.this.e(str);
                        jSONObject.put("state", y4A.j());
                    }
                    a(strD, jSONObject.toString());
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.B(r0)
                java.lang.String r1 = "getDeviceStatus("
                java.lang.String r2 = ")"
                com.ironsource.adqualitysdk.sdk.i.a0.m(r1, r5, r2, r0)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.f0(r0, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                java.lang.String r5 = com.ironsource.sdk.controller.v.d0(r1, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                com.ironsource.ha r2 = r1.Z
                android.content.Context r2 = r2.getContext()
                java.lang.Object[] r1 = com.ironsource.sdk.controller.v.e0(r1, r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L3d
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L44
                r0 = r5
                goto L45
            L3d:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L44
                goto L45
            L44:
                r0 = 0
            L45:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L5a
                com.ironsource.sdk.controller.v r5 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = com.ironsource.sdk.controller.v.Y(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                com.ironsource.sdk.controller.v.l0(r0, r5)
            L5a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.v.r.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            a0.m("getDeviceVolume(", str, ")", v.this.f10087c);
            try {
                Context context = v.this.Z.getContext();
                float fA = C2265c5.b(context).a(context);
                C2346ge c2346ge = new C2346ge(str);
                c2346ge.b(C2300e4.i.P, String.valueOf(fA));
                v.this.a(c2346ge.toString(), true, (String) null, (String) null);
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            Logger.i(v.this.f10087c, "getInitSummery(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            c2346ge.a(C2300e4.i.f8418r0, v.this.S);
            v.this.a(c2346ge.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            A8.a(C2328fe.f8549z, new C2603v8().a(G5.y, str).a());
            String strE = v.this.e(str);
            String string = SDKUtils.getOrientation(v.this.Z.getContext()).toString();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            v.this.i(v.this.a(strE, string, C2300e4.g.X, C2300e4.g.Y));
        }

        @JavascriptInterface
        public void getUserData(String str) {
            Logger.i(v.this.f10087c, "getUserData(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            if (!c2346ge.a(C2300e4.h.W)) {
                v.this.a(str, false, C2300e4.c.F, (String) null);
                return;
            }
            String strE = v.this.e(str);
            String strD = c2346ge.d(C2300e4.h.W);
            v.this.i(v.this.e(strE, v.Z(v.this, strD, C2306ea.e().a(strD), null, null, null, null, null, null)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                Logger.i(v.this.f10087c, "iabTokenAPI(" + str + ")");
                v.this.J.a(new C2346ge(str).toString(), new w());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                Logger.i(v.this.f10087c, "iabTokenAPI failed with exception " + e4.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            Logger.i(v.this.f10087c, "initController(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            CountDownTimer countDownTimer = v.this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                v.this.m = null;
            }
            if (c2346ge.a(C2300e4.h.f8379q)) {
                String strD = c2346ge.d(C2300e4.h.f8379q);
                if (C2300e4.h.f8383s.equalsIgnoreCase(strD)) {
                    v vVar = v.this;
                    vVar.f10090i = true;
                    vVar.Q.d();
                } else if (C2300e4.h.f8381r.equalsIgnoreCase(strD)) {
                    v.this.Q.c();
                } else if (!C2300e4.h.f8385t.equalsIgnoreCase(strD)) {
                    Logger.i(v.this.f10087c, "No STAGE mentioned! should not get here!");
                } else {
                    v.this.Q.c(a1.a.l("controller js failed to initialize : ", c2346ge.d("errMsg")));
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            v.this.c(new n(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            a0.m("onAdWindowsClosed(", str, ")", v.this.f10087c);
            v.this.D.a();
            v.this.D.f(null);
            v.this.j = null;
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d(C2300e4.h.m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            C2569t8.e eVarG = v.this.g(strD);
            Log.d(v.this.f10088d, "onAdClosed() with type " + eVarG);
            if (v.this.q(strD)) {
                v.this.a(eVarG, strFetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            Logger.i(v.this.f10087c, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            a0.m("onGetApplicationInfoFail(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            a0.m("onGetApplicationInfoSuccess(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            a0.m("onGetCachedFilesMapFail(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            a0.m("onGetCachedFilesMapSuccess(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            a0.m("onGetDeviceStatusFail(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            a0.m("onGetDeviceStatusSuccess(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            Logger.i(v.this.f10087c, "onInitBannerFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f10087c, "onInitBannerFail failed with no demand source");
                return;
            }
            Z4 z42 = v.this.G;
            C2569t8.e eVar = C2569t8.e.Banner;
            Y4 y4A = z42.a(eVar, strFetchDemandSourceId);
            if (y4A != null) {
                y4A.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new h(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(v.this.f10087c, "onInitBannerSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new C2346ge(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f10087c, "onInitBannerSuccess failed with no demand source");
            } else if (v.this.q(C2569t8.e.Banner.toString())) {
                v.this.b(new g(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            Logger.i(v.this.f10087c, "onInitInterstitialFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f10087c, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            Z4 z42 = v.this.G;
            C2569t8.e eVar = C2569t8.e.Interstitial;
            Y4 y4A = z42.a(eVar, strFetchDemandSourceId);
            if (y4A != null) {
                y4A.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new c(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(v.this.f10087c, "onInitInterstitialSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new C2346ge(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f10087c, "onInitInterstitialSuccess failed with no demand source");
            } else if (v.this.q(C2569t8.e.Interstitial.toString())) {
                v.this.b(new b(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            Logger.i(v.this.f10087c, "onInitRewardedVideoFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            Z4 z42 = v.this.G;
            C2569t8.e eVar = C2569t8.e.RewardedVideo;
            Y4 y4A = z42.a(eVar, strFetchDemandSourceId);
            if (y4A != null) {
                y4A.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new RunnableC0200v(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(v.this.f10087c, "onLoadBannerFail()");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            v.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(strFetchDemandSourceId) && v.this.q(C2569t8.e.Banner.toString())) {
                v.this.b(new j(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(v.this.f10087c, "onLoadBannerSuccess()");
            C2346ge c2346ge = new C2346ge(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            String strD = c2346ge.d("adViewId");
            v.this.a(str, true, (String) null, (String) null);
            K8 k8A = C2519q8.a().a(strD);
            if (k8A == null) {
                v.this.f10101z.c(strFetchDemandSourceId, "not found view for the current adViewId= " + strD);
                return;
            }
            if (k8A instanceof C2411k8) {
                C2411k8 c2411k8 = (C2411k8) k8A;
                if (v.this.q(C2569t8.e.Banner.toString())) {
                    v.this.b(new i(strFetchDemandSourceId, c2411k8));
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            Logger.i(v.this.f10087c, "onLoadInterstitialFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            a(strFetchDemandSourceId, false);
            if (v.this.q(C2569t8.e.Interstitial.toString())) {
                v.this.b(new f(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            Logger.i(v.this.f10087c, "onLoadInterstitialSuccess(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            JSONObject jSONObjectA = c2346ge.a();
            a(strFetchDemandSourceId, true);
            v.this.a(str, true, (String) null, (String) null);
            if (v.this.q(C2569t8.e.Interstitial.toString())) {
                v.this.b(new e(strFetchDemandSourceId, jSONObjectA));
            }
        }

        @JavascriptInterface
        public void onReceivedMessage(String str) {
            a0.m("onReceivedMessage(", str, ")", v.this.f10087c);
            V7.f7731a.b(new l(str));
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            Logger.i(v.this.f10087c, "onShowInterstitialFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            v.this.b(new androidx.camera.core.impl.utils.futures.d(this, v.this.q(C2569t8.e.Interstitial.toString()), strD, strFetchDemandSourceId));
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            a0.m("onShowInterstitialSuccess(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new C2346ge(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f10087c, "onShowInterstitialSuccess called with no demand");
                return;
            }
            Z0 z02 = v.this.D;
            C2569t8.e eVar = C2569t8.e.Interstitial;
            z02.a(eVar.ordinal());
            v.this.D.f(strFetchDemandSourceId);
            v.this.b(new androidx.work.impl.a(this, v.this.q(eVar.toString()), strFetchDemandSourceId));
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            Logger.i(v.this.f10087c, "onShowRewardedVideoFail(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
            if (v.this.q(C2569t8.e.RewardedVideo.toString())) {
                v.this.b(new a(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            a0.m("onShowRewardedVideoSuccess(", str, ")", v.this.f10087c);
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            Log.d(v.this.f10087c, "onVideoStatusChanged(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d(C2300e4.h.m);
            if (v.this.C == null || TextUtils.isEmpty(strD)) {
                return;
            }
            String strD2 = c2346ge.d("status");
            if (C2300e4.h.d0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStarted();
                return;
            }
            if (C2300e4.h.f8368e0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoPaused();
                return;
            }
            if (C2300e4.h.f0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoResumed();
                return;
            }
            if (C2300e4.h.g0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoEnded();
                return;
            }
            if (C2300e4.h.h0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStopped();
                return;
            }
            Logger.i(v.this.f10087c, "onVideoStatusChanged: unknown status: " + strD2);
        }

        @JavascriptInterface
        public void openUrl(String str) {
            try {
                Logger.i(v.this.f10087c, "openUrl(" + str + ")");
                C2346ge c2346ge = new C2346ge(str);
                p.c cVarA = new p.a(c2346ge.d("method"), new Uc(v.this.F, 805306368)).a(c2346ge.c(C2300e4.h.L0) ? v.this.Z.getContext() : v.this.p(), new Tc(c2346ge.d("url"), c2346ge.d(C2300e4.h.V)));
                if (cVarA instanceof p.c.a) {
                    v.this.a(str, false, ((p.c.a) cVarA).b(), (String) null);
                } else {
                    v.this.a(str, true, (String) null, (String) null);
                }
            } catch (Exception e4) {
                v.this.a(str, false, e4.getLocalizedMessage(), (String) null);
            }
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            v.this.c(new o());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                Logger.i(v.this.f10087c, "permissionsAPI(" + str + ")");
                v.this.I.a(new C2346ge(str).toString(), new w());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                Logger.i(v.this.f10087c, "permissionsAPI failed with exception " + e4.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            Exception exc;
            String str2;
            try {
                Logger.i(v.this.f10087c, "postAdEventNotification(" + str + ")");
                C2346ge c2346ge = new C2346ge(str);
                String strD = c2346ge.d(C2300e4.h.f8371j0);
                try {
                    if (TextUtils.isEmpty(strD)) {
                        v.this.a(str, false, C2300e4.c.f8322w, (String) null);
                        return;
                    }
                    String strD2 = c2346ge.d(C2300e4.h.k0);
                    String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(c2346ge);
                    String str3 = !TextUtils.isEmpty(strFetchDemandSourceId) ? strFetchDemandSourceId : strD2;
                    JSONObject jSONObject = (JSONObject) c2346ge.b(C2300e4.h.f8372l0);
                    String strD3 = c2346ge.d(C2300e4.h.m);
                    C2569t8.e eVarG = v.this.g(strD3);
                    try {
                        if (!v.this.q(strD3)) {
                            v.this.a(str, false, C2300e4.c.f8321v, (String) null);
                            return;
                        }
                        String strE = v.this.e(str);
                        if (TextUtils.isEmpty(strE)) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            v.this.i(v.this.a(strE, v.Z(v.this, C2300e4.h.m, strD3, C2300e4.h.f8371j0, strD, "demandSourceName", strD2, "demandSourceId", str2), C2300e4.g.f8343c0, C2300e4.g.d0));
                        }
                        try {
                            v.this.b(new m(eVarG, str2, strD, jSONObject));
                            return;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    exc = e9;
                }
            } catch (Exception e10) {
                e = e10;
            }
            exc = e;
            C2531r4.d().a(exc);
            IronLog.INTERNAL.error(exc.toString());
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            a0.m("removeCloseEventHandler(", str, ")", v.this.f10087c);
            CountDownTimer countDownTimer = v.this.l;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            v.this.k = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            v.this.c(new p());
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            Logger.i(v.this.f10087c, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            v.this.c(new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                Logger.i(v.this.f10087c, "saveFile(" + str + ")");
                C2346ge c2346ge = new C2346ge(str);
                String strD = c2346ge.d("path");
                String strD2 = c2346ge.d(C2300e4.h.f8363b);
                if (TextUtils.isEmpty(strD2)) {
                    v.this.a(str, false, C2300e4.c.g, "1");
                    return;
                }
                C8 c8 = new C8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD), SDKUtils.getFileName(strD2));
                IronSourceStorageUtils.ensurePathSafety(c8, v.this.A);
                v vVar = v.this;
                if (vVar.X.a(vVar.A) <= 0) {
                    v.this.a(str, false, C2336g4.A, (String) null);
                    return;
                }
                if (c8.exists()) {
                    v.this.a(str, false, C2336g4.f8587z, (String) null);
                    return;
                }
                if (!C2228a4.h(v.this.Z.getContext())) {
                    v.this.a(str, false, C2336g4.C, (String) null);
                    return;
                }
                v.this.a(str, true, (String) null, (String) null);
                v.this.h.a(c8, strD2, c2346ge.a("connectionTimeout", 0), c2346ge.a("readTimeout", 0));
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                v.this.a(str, false, e4.getMessage(), (String) null);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            Logger.i(v.this.f10087c, "setBackButtonState(" + str + ")");
            C2306ea.e().c(new C2346ge(str).d("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            Logger.i(v.this.f10087c, "setForceClose(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            String strD = c2346ge.d("width");
            String strD2 = c2346ge.d("height");
            v.this.f10091n = Integer.parseInt(strD);
            v.this.f10092o = Integer.parseInt(strD2);
            v.this.p = c2346ge.d(C2300e4.h.L);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            a0.m("setMixedContentAlwaysAllow(", str, ")", v.this.f10087c);
            v.this.c(new q());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            try {
                Logger.i(v.this.f10087c, "setOrientation(" + str + ")");
                String strD = new C2346ge(str).d("orientation");
                v.this.n(strD);
                v vVar = v.this;
                if (vVar.f10085a0 != null) {
                    v.this.f10085a0.onOrientationChanged(strD, vVar.X.K(vVar.Z.getContext()));
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            Logger.i(v.this.f10087c, "setStoreSearchKeys(" + str + ")");
            C2306ea.e().e(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            Logger.i(v.this.f10087c, "setUserData(" + str + ")");
            C2346ge c2346ge = new C2346ge(str);
            if (!c2346ge.a(C2300e4.h.W)) {
                v.this.a(str, false, C2300e4.c.F, (String) null);
                return;
            }
            if (!c2346ge.a("value")) {
                v.this.a(str, false, C2300e4.c.G, (String) null);
                return;
            }
            String strD = c2346ge.d(C2300e4.h.W);
            String strD2 = c2346ge.d("value");
            C2306ea.e().a(strD, strD2);
            v.this.i(v.this.e(v.this.e(str), v.Z(v.this, strD, strD2, null, null, null, null, null, null)));
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            a0.m("setWebviewBackgroundColor(", str, ")", v.this.f10087c);
            v.this.p(str);
        }

        @JavascriptInterface
        public void stillAlive(String str) {
            a0.m("stillAlive(", str, ")", v.this.f10087c);
            v.this.f10086b.a();
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", v.this.B.f());
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                Logger.d(v.this.f10087c, "Unable to add controller source data into controllerConfig");
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager featuresManager = FeaturesManager.getInstance();
                if (featuresManager.a().isEmpty()) {
                    return;
                }
                jSONObject.put(C2300e4.a.h, new JSONArray((Collection) featuresManager.a()));
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                A8.a(C2328fe.p, new C2603v8().a(G5.A, e4.getMessage()).a());
                Logger.d(v.this.f10087c, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject) {
            b(jSONObject);
            a(jSONObject, SDKUtils.getTesterParameters());
            if (v.this.W) {
                return;
            }
            a(jSONObject);
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class w implements InterfaceC2487oa {
            public w() {
            }

            @Override // com.ironsource.InterfaceC2487oa
            public void a(boolean z2, String str, String str2) {
                C2346ge c2346ge = new C2346ge();
                c2346ge.b(z2 ? v.g0 : v.h0, str);
                c2346ge.b("data", str2);
                v.this.a(c2346ge.toString(), z2, (String) null, (String) null);
            }

            @Override // com.ironsource.InterfaceC2487oa
            public void a(boolean z2, String str, C2346ge c2346ge) {
                c2346ge.b(z2 ? v.g0 : v.h0, str);
                v.this.a(c2346ge.toString(), z2, (String) null, (String) null);
            }

            @Override // com.ironsource.InterfaceC2487oa
            public void a(boolean z2, String str, JSONObject jSONObject) {
                try {
                    jSONObject.put(z2 ? v.g0 : v.h0, str);
                    v.this.a(jSONObject.toString(), z2, (String) null, (String) null);
                } catch (JSONException e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException e4) {
                    C2531r4.d().a(e4);
                    Logger.d(v.this.f10087c, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        public void c(String str) {
            v.this.i(v.this.a(C2300e4.g.f8344d, str, (String) null, (String) null));
        }

        public boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains(Y1.f7808f)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty()) {
                    return false;
                }
                return !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            try {
                InterfaceC2562t1 interfaceC2562t1A = ri.a(str);
                v vVar = v.this;
                C2528r1.a aVarA = vVar.N.a(vVar.Z.getContext(), interfaceC2562t1A);
                v.this.i(v.this.e(aVarA.f(), aVarA.i().toString()));
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }

        private void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            v.this.i(v.this.e(str, str2));
        }

        private void a(String str, int i2) {
            Y4 y4A;
            v vVar = v.this;
            C2569t8.e eVar = C2569t8.e.Interstitial;
            if (vVar.q(eVar.toString()) && (y4A = v.this.G.a(eVar, str)) != null && y4A.k()) {
                v.this.b(new u(str, i2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z2, String str) {
            if (z2) {
                v.this.y.c(C2569t8.e.Interstitial, str);
                v.this.y.b(str);
            }
            a(str, false);
        }

        private void a(String str, boolean z2) {
            Y4 y4A = v.this.G.a(C2569t8.e.Interstitial, str);
            if (y4A != null) {
                y4A.a(z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z2, String str, String str2) {
            if (z2) {
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.d(str2, str);
            }
            a(str2, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface s {
        void a(String str, C2569t8.e eVar, Y4 y42);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f10193b;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum u {
        Display,
        Gone
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$v, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class C0201v extends WebViewClient {
        public /* synthetic */ C0201v(v vVar, int i2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                v.this.z();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            com.ironsource.sdk.controller.c cVar;
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains(C2300e4.f8280f) && (cVar = v.this.Q) != null) {
                cVar.c("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i2 + ")");
            }
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.e(v.this.f10087c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            com.ironsource.sdk.controller.c cVar = v.this.Q;
            if (cVar != null) {
                cVar.b(str);
            }
            v.this.v();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean zContains;
            Logger.i("shouldInterceptRequest", str);
            try {
                zContains = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException e) {
                C2531r4.d().a(e);
                zContains = false;
            }
            if (zContains) {
                StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
                sb.append(v.this.A);
                String strR = a1.a.r(sb, File.separator, "mraid.js");
                try {
                    new FileInputStream(new File(strR));
                    return new WebResourceResponse("text/javascript", Key.STRING_CHARSET_NAME, getClass().getResourceAsStream(strR));
                } catch (FileNotFoundException e4) {
                    C2531r4.d().a(e4);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (v.this.h(str)) {
                    v.this.y();
                    return true;
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        private C0201v() {
        }
    }

    public v(Context context, Z4 z42, C2354h4 c2354h4, com.ironsource.sdk.controller.c cVar, V7 v7, int i2, C2390j5 c2390j5, String str, l.a aVar, l.b bVar, String str2, String str3) throws Throwable {
        int i8 = 0;
        C2360ha c2360ha = new C2360ha(context, new InterfaceC2554sa.a());
        this.Z = c2360ha;
        Logger.i(this.f10087c, "C'tor");
        this.Y = c2354h4;
        this.Q = cVar;
        this.f10084a = v7;
        this.G = z42;
        a(context, c2360ha);
        this.A = str;
        this.D = new Z0();
        this.S = new JSONObject();
        this.h = c2390j5;
        this.T = aVar;
        this.U = bVar;
        boolean zOptBoolean = SDKUtils.getNetworkConfiguration().optBoolean(C2300e4.a.f8296i, false);
        this.W = zOptBoolean;
        if (zOptBoolean) {
            this.V = new C2481o4(new C2425l4(SDKUtils.getControllerUrl(), this.A, SDKUtils.getNetworkConfiguration().optBoolean("useWebViewUserAgent", false), new C2309ed(SDKUtils.getControllerUrl())), new androidx.camera.core.impl.utils.a(this, 5), c2390j5, new InterfaceC2565t4.a());
        } else {
            c2390j5.a(this);
            this.B = new com.ironsource.sdk.controller.d(SDKUtils.getNetworkConfiguration(), this.A, SDKUtils.getControllerUrl(), c2390j5);
        }
        o oVar = new o(this, i8);
        this.f10093q = oVar;
        c2360ha.setWebViewClient(new C0201v(this, i8));
        c2360ha.setWebChromeClient(oVar);
        Ng.a(c2360ha);
        a(c2360ha);
        c2360ha.setDownloadListener(this);
        this.R = c(context);
        b(context);
        b(i2);
        this.f10089f = str2;
        this.g = str3;
        this.f10086b = ii.a(FeaturesManager.getInstance().getFeatureFlagHealthCheck());
    }

    public static /* bridge */ /* synthetic */ String Z(v vVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return vVar.a(str, str2, str3, str4, str5, str6, str7, str8, null, false);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
        Logger.i(this.f10087c, str + " " + str4);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f extends Y3 {
        public f(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        @Override // com.ironsource.Y3, com.ironsource.InterfaceC2619w7
        public void a(String str, JSONObject jSONObject) {
            v vVar = v.this;
            if (vVar.f10090i) {
                vVar.m(str);
            }
        }

        @Override // com.ironsource.Y3, com.ironsource.InterfaceC2619w7
        public void b(String str, JSONObject jSONObject) {
            if (jSONObject == null || !v.this.f10090i) {
                return;
            }
            try {
                jSONObject.put("connectionType", str);
                v.this.e(jSONObject);
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.Y3, com.ironsource.InterfaceC2619w7
        public void a() {
            v vVar = v.this;
            if (vVar.f10090i) {
                vVar.m("none");
            }
        }
    }

    private void F() {
    }

    private void a(WebView webView) {
        com.ironsource.sdk.controller.s sVar = new com.ironsource.sdk.controller.s(com.ironsource.sdk.controller.s.a());
        webView.addJavascriptInterface(a(sVar), C2300e4.f8279d);
        webView.addJavascriptInterface(b(sVar), C2300e4.e);
    }

    private Y3 c(Context context) {
        return new f(SDKUtils.getControllerConfigAsJSONObject(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] f(String str, String str2) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapG = null;
        if (TextUtils.isEmpty(str)) {
            z2 = true;
        } else {
            Y4 y4A = this.G.a(g(str), str2);
            if (y4A != null) {
                mapG = y4A.g();
                mapG.put("demandSourceName", y4A.f());
                mapG.put("demandSourceId", y4A.h());
            }
            try {
                jSONObject.put(C2300e4.h.m, str);
            } catch (JSONException e4) {
                C2531r4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e8) {
                C2531r4.d().a(e8);
                IronLog.INTERNAL.error(e8.toString());
            }
            z2 = false;
        }
        if (!TextUtils.isEmpty(this.g)) {
            try {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8405f), SDKUtils.encodeString(this.g));
            } catch (JSONException e9) {
                C2531r4.d().a(e9);
                IronLog.INTERNAL.error(e9.toString());
            }
        }
        if (TextUtils.isEmpty(this.f10089f)) {
            z2 = true;
        } else {
            try {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.g), SDKUtils.encodeString(this.f10089f));
            } catch (JSONException e10) {
                C2531r4.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
        if (mapG != null && !mapG.isEmpty()) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    o(entry.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString(entry.getKey()), SDKUtils.encodeString(entry.getValue()));
                } catch (JSONException e11) {
                    C2531r4.d().a(e11);
                    IronLog.INTERNAL.error(e11.toString());
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(new a3.c(23, this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str) {
        this.Z.a(new m.b(str, q()).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        try {
            Logger.i(this.f10087c, "load(): " + str);
            this.Z.loadUrl(str);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            Logger.e(this.f10087c, "WebViewController::load: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        C2346ge c2346ge = new C2346ge(str);
        String strD = c2346ge.d("color");
        String strD2 = c2346ge.d("adViewId");
        int color = !C2300e4.h.T.equalsIgnoreCase(strD) ? Color.parseColor(strD) : 0;
        if (strD2 == null) {
            this.Z.setBackgroundColor(color);
            return;
        }
        WebView presentingView = C2519q8.a().a(strD2).getPresentingView();
        if (presentingView != null) {
            presentingView.setBackgroundColor(color);
        }
    }

    public void A() {
        try {
            this.Z.onPause();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            Logger.i(this.f10087c, "WebViewController: onPause() - " + th);
        }
    }

    public void B() {
        this.C = null;
    }

    public void C() {
        this.Z.a();
        this.f10085a0 = null;
    }

    public void D() {
        this.Z.requestFocus();
    }

    public void E() {
        try {
            this.Z.onResume();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            Logger.i(this.f10087c, "WebViewController: onResume() - " + th);
        }
    }

    public com.ironsource.sdk.controller.r b(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.r(sVar);
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = C2300e4.c.f8324z;
        }
        i(e(C2300e4.g.f8341a0, a("errMsg", str, "url", str2, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
        i(f(C2300e4.g.f8353t));
    }

    public void g(String str, String str2) {
        i(e(C2300e4.g.W, a(C2300e4.h.p, str2, C2300e4.h.m, str, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.l
    public C2569t8.c h() {
        return C2569t8.c.Web;
    }

    public void k(String str) {
        i(e(C2300e4.g.f8356w, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void m(String str) {
        try {
            String strD = C2246b4.d(this.Z.getContext());
            Logger.i(this.f10087c, "device status changed, connection type " + str);
            C2654y8.a(str);
            C2654y8.b(strD);
            try {
                i(e(C2300e4.g.f8357x, a("connectionType", str, "rawConnectionType", strD, null, null, null, null, null, false)));
            } catch (Exception e4) {
                e = e4;
                Exception exc = e;
                C2531r4.d().a(exc);
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(exc));
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    public void n(String str) {
        this.f10099w = str;
    }

    public Mg o() {
        if (this.P == null) {
            this.P = new g();
        }
        return this.P;
    }

    public int q() {
        return f10082c0;
    }

    public FrameLayout r() {
        return this.f10097u;
    }

    public String s() {
        return this.f10099w;
    }

    public Z0 t() {
        return this.D;
    }

    public u u() {
        return this.f10098v;
    }

    public void v() {
        if (this.j == null) {
            return;
        }
        n();
        C2569t8.e eVarB = this.j.b();
        String strA = this.j.a();
        if (q(eVarB.toString())) {
            a(eVarB, strA);
        }
    }

    public void w() {
        this.f10093q.onHideCustomView();
    }

    public boolean x() {
        return this.f10094r != null;
    }

    public void y() {
        i(f(C2300e4.g.Z));
    }

    public void z() {
        i(f(C2300e4.g.A));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Sc sc = this.f10085a0;
        if (sc != null) {
            sc.onCloseRequested();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(String str) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.f10087c, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(C2569t8.e.Interstitial.toString()) ? !(!str.equalsIgnoreCase(C2569t8.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(C2569t8.e.Banner.toString()) || this.f10101z == null : this.f10100x == null) : this.y != null) {
            z2 = true;
        }
        if (!z2) {
            Logger.d(this.f10087c, "Trying to trigger a listener - no listener was found for product ".concat(str));
        }
        return z2;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
        if (this.W) {
            this.V.b();
            return;
        }
        this.B.a(new C2603v8());
        if (this.B.k()) {
            a(1);
        }
    }

    public void c(String str, String str2) {
        String str3;
        try {
            str3 = str;
        } catch (Exception e4) {
            e = e4;
            str3 = str;
        }
        try {
            i(e(C2300e4.g.p, a(C2300e4.h.f8363b, str3, "path", b(str2), null, null, null, null, null, false)));
        } catch (Exception e8) {
            e = e8;
            Exception exc = e;
            C2531r4.d().a(exc);
            b(str3, str2, exc.getMessage());
        }
    }

    public boolean h(String str) {
        try {
            if (!new Je(str, C2306ea.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().b()).a()) {
                return false;
            }
            C2366hg.a(p(), str);
            return true;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        return new C2346ge(str).d(g0);
    }

    private String d(JSONObject jSONObject) {
        C2265c5 c2265c5B = C2265c5.b(this.Z.getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            androidx.camera.core.processing.util.a.z(sb, "SDKVersion=", sDKVersion, C2300e4.i.f8401c);
        }
        String strE = c2265c5B.e();
        if (!TextUtils.isEmpty(strE)) {
            sb.append("deviceOs=");
            sb.append(strE);
        }
        Uri uri = Uri.parse(SDKUtils.getControllerUrl());
        if (uri != null) {
            String str = uri.getScheme() + ":";
            String host = uri.getHost();
            int port = uri.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            androidx.camera.core.processing.util.a.A(sb, "&protocol=", str, "&domain=", host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String string = new JSONObject(jSONObject, new String[]{C2300e4.i.Z, C2300e4.i.g}).toString();
                    if (!TextUtils.isEmpty(string)) {
                        sb.append(C2300e4.i.f8401c);
                        sb.append("controllerConfig");
                        sb.append(C2300e4.i.f8399b);
                        sb.append(string);
                    }
                } catch (JSONException e4) {
                    C2531r4.d().a(e4);
                    IronLog.INTERNAL.error(e4.toString());
                }
            }
            sb.append("&debug=");
            sb.append(q());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2569t8.e g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C2569t8.e eVar = C2569t8.e.Interstitial;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        C2569t8.e eVar2 = C2569t8.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        C2569t8.e eVar3 = C2569t8.e.Banner;
        if (str.equalsIgnoreCase(eVar3.toString())) {
            return eVar3;
        }
        return null;
    }

    private void o(String str) {
        if (str.equalsIgnoreCase("0")) {
            this.Z.getSettings().setCacheMode(2);
        } else {
            this.Z.getSettings().setCacheMode(-1);
        }
    }

    public void e(JSONObject jSONObject) {
        Logger.i(this.f10087c, "device connection info changed: " + jSONObject.toString());
        i(e(C2300e4.g.y, a(C2300e4.i.h0, jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    public com.ironsource.sdk.controller.g a(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.g(new com.ironsource.sdk.controller.b(new r()), sVar);
    }

    public void b(int i2) {
        f10082c0 = i2;
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
        i(f(C2300e4.g.f8354u));
    }

    private void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString("gpi"), C2291dd.d(this.Z.getContext()));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        a(y42, map);
    }

    public Context p() {
        return this.Y.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        try {
            Y3 y32 = this.R;
            if (y32 == null) {
                return;
            }
            y32.b(context);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a(com.ironsource.sdk.controller.o oVar) {
        this.H = oVar;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Y4 y42) {
        Map<String, String> mapB = y42.b();
        if (mapB != null) {
            i(e(C2300e4.g.T, SDKUtils.flatMapToJsonAsString(mapB)));
        }
        this.G.b(C2569t8.e.Interstitial, y42.h());
    }

    public void a(com.ironsource.sdk.controller.q qVar) {
        this.I = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(C8 c8) {
        this.h.a(this);
        if (c8 != null && c8.exists()) {
            a(c8);
            return null;
        }
        a(new C8(C2300e4.f8280f), new C2586u8(1, "Unable to download Html file"));
        return null;
    }

    public void a(com.ironsource.sdk.controller.u uVar) {
        this.J = uVar;
    }

    public void a(com.ironsource.sdk.controller.i iVar) {
        this.K = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, String str2) {
        return new m.a(str, str2).a();
    }

    public void a(com.ironsource.sdk.controller.a aVar) {
        this.L = aVar;
        aVar.a(o());
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        i(e(C2300e4.g.f8345e0, jSONObject != null ? jSONObject.toString() : null));
    }

    public void a(com.ironsource.sdk.controller.j jVar) {
        this.M = jVar;
    }

    public void c(String str) {
        if (str.equals(C2300e4.h.f8370i)) {
            n();
        }
        i(e(C2300e4.g.f8358z, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void a(C2528r1 c2528r1) {
        this.N = c2528r1;
    }

    private void a(Context context, WebView webView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f10097u = new FrameLayout(context);
        this.f10095s = new FrameLayout(context);
        this.f10095s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10095s.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(webView);
        this.f10097u.addView(this.f10095s, layoutParams);
        this.f10097u.addView(frameLayout);
    }

    private String b(String str) {
        String str2 = this.A + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    private String c(String str, String str2, String str3) {
        return new m.a(str, null, str2, str3).a();
    }

    public void b(String str, String str2, String str3) {
        try {
        } catch (Exception e4) {
            e = e4;
        }
        try {
            i(e(C2300e4.g.f8350q, a(C2300e4.h.f8363b, str, "path", b(str2), "errMsg", str3, null, null, null, false)));
        } catch (Exception e8) {
            e = e8;
            C2531r4.d().a(e);
        }
    }

    public void c(Runnable runnable) {
        V7 v7 = this.f10084a;
        if (v7 != null) {
            v7.d(runnable);
        }
    }

    private String b(String str, String str2) {
        return a(str, str2, "errMsg");
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        a(new c(context));
    }

    public void b(Runnable runnable) {
        V7 v7 = this.f10084a;
        if (v7 != null) {
            v7.c(runnable);
        }
    }

    private void a(WebSettings webSettings) {
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public void a(B4 b42) {
        this.O = b42;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC2599v4 a(C2569t8.e eVar) {
        if (eVar == C2569t8.e.Interstitial) {
            return this.y;
        }
        if (eVar == C2569t8.e.RewardedVideo) {
            return this.f10100x;
        }
        if (eVar == C2569t8.e.Banner) {
            return this.f10101z;
        }
        return null;
    }

    public void a(og ogVar) {
        this.C = ogVar;
    }

    public void a(int i2) {
        String string;
        if (!this.W && !this.B.m()) {
            Logger.i(this.f10087c, "load(): Mobile Controller HTML Does not exist");
            return;
        }
        JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
        String strD = d(controllerConfigAsJSONObject);
        Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
        if (initSDKParams != null && initSDKParams.containsKey("sessionid")) {
            strD = String.format("%s&sessionid=%s", strD, initSDKParams.get("sessionid"));
        }
        if (this.W) {
            string = this.V.c().toURI().toString();
        } else {
            string = this.B.g().toURI().toString();
        }
        this.f10084a.d(new h(controllerConfigAsJSONObject, this.Z, a1.a.D(string, "?", strD)));
        this.m = new i(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, 1000L, i2).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        try {
            Y3 y32 = this.R;
            if (y32 == null) {
                return;
            }
            y32.c(context);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return new C2346ge(str).d(h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] d(Context context) {
        boolean z2;
        C2265c5 c2265c5B = C2265c5.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C2300e4.i.f8425z, "none");
            jSONObject.put(C2300e4.i.A, SDKUtils.translateDeviceOrientation(this.X.z(context)));
            String strD = c2265c5B.d();
            if (strD != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(strD));
            }
            String strC = c2265c5B.c();
            if (strC != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(strC));
                z2 = false;
            } else {
                z2 = true;
            }
            try {
                SDKUtils.loadGoogleAdvertiserInfo(context);
                String advertiserId = SDKUtils.getAdvertiserId();
                if (!TextUtils.isEmpty(advertiserId)) {
                    Logger.i(this.f10087c, "add AID");
                    jSONObject.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
                }
                String limitAdTracking = SDKUtils.getLimitAdTracking();
                if (!TextUtils.isEmpty(limitAdTracking)) {
                    Logger.i(this.f10087c, "add LAT");
                    jSONObject.put(C2300e4.i.M, Boolean.parseBoolean(limitAdTracking));
                }
                String strE = c2265c5B.e();
                if (strE != null) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.m), SDKUtils.encodeString(strE));
                } else {
                    z2 = true;
                }
                String strF = c2265c5B.f();
                if (strF != null) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8410n), strF.replaceAll("[^0-9/.]", ""));
                } else {
                    z2 = true;
                }
                String strF2 = c2265c5B.f();
                if (strF2 != null) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8412o), SDKUtils.encodeString(strF2));
                }
                String strValueOf = String.valueOf(c2265c5B.a());
                if (strValueOf != null) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.p), strValueOf);
                } else {
                    z2 = true;
                }
                jSONObject.put(Q6.i0, String.valueOf(C2385j0.a()));
                String sDKVersion = SDKUtils.getSDKVersion();
                if (sDKVersion != null) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8415q), SDKUtils.encodeString(sDKVersion));
                }
                if (c2265c5B.b() != null && c2265c5B.b().length() > 0) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8417r), SDKUtils.encodeString(c2265c5B.b()));
                }
                String strB = C2246b4.b(context);
                if (strB.equals("none")) {
                    z2 = true;
                } else {
                    jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(strB));
                }
                String strD2 = C2246b4.d(context);
                if (strD2 != null) {
                    jSONObject.put(SDKUtils.encodeString("rawConnectionType"), SDKUtils.encodeString(strD2));
                } else {
                    z2 = true;
                }
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8422v), C2246b4.e(context));
                jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8424x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
                }
                jSONObject.put(C2300e4.i.y, SDKUtils.encodeString(String.valueOf(this.X.a(this.A))));
                String strValueOf2 = String.valueOf(this.X.o());
                if (TextUtils.isEmpty(strValueOf2)) {
                    z2 = true;
                } else {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.G) + C2300e4.i.f8403d + SDKUtils.encodeString("width") + C2300e4.i.e, SDKUtils.encodeString(strValueOf2));
                }
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.G) + C2300e4.i.f8403d + SDKUtils.encodeString("height") + C2300e4.i.e, SDKUtils.encodeString(String.valueOf(this.X.b())));
                String strG = C1.g(this.Z.getContext());
                if (!TextUtils.isEmpty(strG)) {
                    jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(strG));
                }
                String strValueOf3 = String.valueOf(this.X.r());
                if (!TextUtils.isEmpty(strValueOf3)) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.K), SDKUtils.encodeString(strValueOf3));
                }
                String strValueOf4 = String.valueOf(this.X.p());
                if (!TextUtils.isEmpty(strValueOf4)) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.O), SDKUtils.encodeString(strValueOf4));
                }
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.P), C2265c5.b(context).a(context));
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.Y), this.X.k(context));
                jSONObject.put(SDKUtils.encodeString("mcc"), C2228a4.b(context));
                jSONObject.put(SDKUtils.encodeString("mnc"), C2228a4.c(context));
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.S), C2228a4.f(context));
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.R), SDKUtils.encodeString(C2228a4.g(context)));
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.V), C1.f(context));
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.X), C1.d(context));
                jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(C1.b(context)));
                String strE2 = C1.e(context);
                if (!TextUtils.isEmpty(strE2)) {
                    jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8402c0), SDKUtils.encodeString(strE2));
                }
                c(jSONObject);
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8414p0), this.X.t(context));
            } catch (JSONException e4) {
                e = e4;
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        } catch (JSONException e8) {
            e = e8;
            z2 = false;
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    private String f(String str) {
        return new m.a(str).a();
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
        a(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, WebView webView) {
        boolean zOptBoolean = jSONObject.optBoolean("inspectWebview");
        if (zOptBoolean) {
            WebView.setWebContentsDebuggingEnabled(zOptBoolean);
        }
    }

    private void a(String str, C2569t8.e eVar, Y4 y42, s sVar) {
        if (TextUtils.isEmpty(str)) {
            sVar.a("Application key are missing", eVar, y42);
        } else {
            i(a(eVar, y42).f10193b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2650y4 interfaceC2650y4) {
        this.f10089f = str;
        this.g = str2;
        this.f10100x = interfaceC2650y4;
        this.D.i(str);
        this.D.j(str2);
        a(str, C2569t8.e.RewardedVideo, y42, new j());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2633x4 interfaceC2633x4) {
        this.f10089f = str;
        this.g = str2;
        this.y = interfaceC2633x4;
        this.D.g(str);
        this.D.h(this.g);
        a(this.f10089f, C2569t8.e.Interstitial, y42, new k());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC2633x4 interfaceC2633x4) {
        HashMap map = new HashMap();
        map.put("demandSourceName", str);
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        this.D.d(str, true);
        i(a(C2300e4.g.E, strFlatMapToJsonAsString, C2300e4.g.F, C2300e4.g.G));
    }

    private void a(Y4 y42, Map<String, String> map) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, y42.b()});
        if (map.containsKey("adm")) {
            this.f10086b.a(new z(this));
        }
        this.D.d(y42.h(), true);
        i(a(C2300e4.g.E, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), C2300e4.g.F, C2300e4.g.G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC2303e7 interfaceC2303e7) {
        interfaceC2303e7.a(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC2249b7 interfaceC2249b7) {
        try {
            this.Q.a(interfaceC2249b7);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            Logger.e(this.f10087c, "handleLoadAd: " + e4);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2633x4 interfaceC2633x4) {
        i(a(C2569t8.e.Interstitial, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4) {
        i(a(C2569t8.e.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, y42.b()}))));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        Y4 y4A = this.G.a(C2569t8.e.Interstitial, str);
        return y4A != null && y4A.d();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, Y4 y42, InterfaceC2616w4 interfaceC2616w4) {
        this.f10089f = str;
        this.g = str2;
        this.f10101z = interfaceC2616w4;
        a(str, C2569t8.e.Banner, y42, new l());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42, Map<String, String> map, InterfaceC2616w4 interfaceC2616w4) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, y42.b()});
        if (map != null) {
            i(a(C2300e4.g.N, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), C2300e4.g.O, C2300e4.g.R));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Y4 y42) {
        Map<String, String> mapB = y42.b();
        if (mapB != null) {
            i(a(C2300e4.g.S, SDKUtils.flatMapToJsonAsString(mapB), C2300e4.g.P, C2300e4.g.Q));
        }
        this.G.b(C2569t8.e.Banner, y42.h());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2616w4 interfaceC2616w4) {
        i(a(C2300e4.g.N, jSONObject.toString(), C2300e4.g.O, C2300e4.g.R));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        i(a(cVar.e(), cVar.h(), C2300e4.g.U, C2300e4.g.U));
    }

    private t a(C2569t8.e eVar, Y4 y42) {
        t tVar = new t();
        if (eVar != C2569t8.e.RewardedVideo && eVar != C2569t8.e.Interstitial && eVar != C2569t8.e.Banner) {
            return tVar;
        }
        HashMap map = new HashMap();
        map.put(C2300e4.i.g, this.f10089f);
        if (!TextUtils.isEmpty(this.g)) {
            map.put(C2300e4.i.f8405f, this.g);
        }
        if (y42 != null) {
            if (y42.g() != null) {
                map.putAll(y42.g());
                map.put(C2300e4.h.f8394y0, String.valueOf(L.f7071a.c(y42.h())));
            }
            map.put("demandSourceName", y42.f());
            map.put("demandSourceId", y42.h());
        }
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        C2300e4.g gVarA = C2300e4.g.a(eVar);
        String strA = a(gVarA.f8359a, strFlatMapToJsonAsString, gVarA.f8360b, gVarA.f8361c);
        tVar.f10192a = gVarA.f8359a;
        tVar.f10193b = strA;
        return tVar;
    }

    private String a(C2569t8.e eVar, JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String strOptString = jSONObject.optString("demandSourceName");
        String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        Y4 y4A = this.G.a(eVar, strFetchDemandSourceId);
        if (y4A != null) {
            if (y4A.g() != null) {
                map.putAll(y4A.g());
            }
            if (!TextUtils.isEmpty(strOptString)) {
                map.put("demandSourceName", strOptString);
            }
            if (!TextUtils.isEmpty(strFetchDemandSourceId)) {
                map.put("demandSourceId", strFetchDemandSourceId);
            }
        }
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        C2300e4.g gVarB = C2300e4.g.b(eVar);
        return a(gVarB.f8359a, strFlatMapToJsonAsString, gVarB.f8360b, gVarB.f8361c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, C2569t8.e eVar, Y4 y42) {
        if (q(eVar.toString())) {
            b(new m(eVar, y42, str));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC2650y4 interfaceC2650y4) {
        i(a(C2569t8.e.RewardedVideo, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.S = jSONObject;
        }
    }

    public void a(boolean z2, String str) {
        i(e(C2300e4.g.V, a(C2300e4.h.K, str, null, null, null, null, null, null, C2300e4.h.f8376o, z2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2, String str2, String str3) {
        String strD = new C2346ge(str).d(z2 ? g0 : h0);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        i(e(strD, a(b(str, str2), str3)));
    }

    private String a(String str, String str2) {
        return a(str, str2, C2300e4.h.g);
    }

    private String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                return new JSONObject(str).put(str3, str2).toString();
            } catch (JSONException e4) {
                C2531r4.d().a(e4);
            }
        }
        return str;
    }

    private String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z2);
            }
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
        return jSONObject.toString();
    }

    @Override // com.ironsource.Pc
    public void a(C8 c8) {
        if (this.W && this.V.a(c8)) {
            a(1);
        } else if (c8.getName().contains(C2300e4.f8280f)) {
            this.B.a(new n());
        } else {
            c(c8.getName(), c8.getParent());
        }
    }

    @Override // com.ironsource.Pc
    public void a(C8 c8, C2586u8 c2586u8) {
        if (this.W && this.V.a(c8)) {
            this.Q.c("controller html - failed to download - " + c2586u8.b());
            return;
        }
        if (c8.getName().contains(C2300e4.f8280f)) {
            this.B.a(new a(), new b(c2586u8));
        } else {
            b(c8.getName(), c8.getParent(), c2586u8.b());
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        a(new d(context));
    }

    public void a(Sc sc) {
        this.f10085a0 = sc;
        this.Z.a(sc);
    }

    public void a(u uVar) {
        this.f10098v = uVar;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
        this.Z.destroy();
        C2390j5 c2390j5 = this.h;
        if (c2390j5 != null) {
            c2390j5.d();
        }
        Y3 y32 = this.R;
        if (y32 != null) {
            y32.b();
        }
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4) {
        return new m.a(str, str2, str3, str4).a();
    }

    public void a(C2569t8.e eVar, String str) {
        b(new e(eVar, str));
    }

    public void a(Z0 z02) {
        synchronized (this.E) {
            try {
                if (z02.j() && this.f10090i) {
                    Log.d(this.f10087c, "restoreState(state:" + z02 + ")");
                    int iC = z02.c();
                    if (iC != -1) {
                        C2569t8.e eVar = C2569t8.e.RewardedVideo;
                        if (iC == eVar.ordinal()) {
                            Log.d(this.f10087c, "onRVAdClosed()");
                            String strB = z02.b();
                            InterfaceC2599v4 interfaceC2599v4A = a(eVar);
                            if (interfaceC2599v4A != null && !TextUtils.isEmpty(strB)) {
                                interfaceC2599v4A.b(eVar, strB);
                            }
                        } else {
                            C2569t8.e eVar2 = C2569t8.e.Interstitial;
                            if (iC == eVar2.ordinal()) {
                                Log.d(this.f10087c, "onInterstitialAdClosed()");
                                String strB2 = z02.b();
                                InterfaceC2599v4 interfaceC2599v4A2 = a(eVar2);
                                if (interfaceC2599v4A2 != null && !TextUtils.isEmpty(strB2)) {
                                    interfaceC2599v4A2.b(eVar2, strB2);
                                }
                            }
                        }
                        z02.a(-1);
                        z02.f(null);
                    } else {
                        Log.d(this.f10087c, "No ad was opened");
                    }
                    String strD = z02.d();
                    String strF = z02.f();
                    for (Y4 y42 : this.G.a(C2569t8.e.Interstitial)) {
                        if (y42.e() == 2) {
                            Log.d(this.f10087c, "initInterstitial(appKey:" + strD + ", userId:" + strF + ", demandSource:" + y42.f() + ")");
                            a(strD, strF, y42, this.y);
                        }
                    }
                    String strG = z02.g();
                    String strH = z02.h();
                    for (Y4 y43 : this.G.a(C2569t8.e.RewardedVideo)) {
                        if (y43.e() == 2) {
                            String strF2 = y43.f();
                            Log.d(this.f10087c, "onRVNoMoreOffers()");
                            this.f10100x.c(strF2);
                            Log.d(this.f10087c, "initRewardedVideo(appKey:" + strG + ", userId:" + strH + ", demandSource:" + strF2 + ")");
                            a(strG, strH, y43, this.f10100x);
                        }
                    }
                    z02.a(false);
                }
                this.D = z02;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Runnable runnable) {
        V7 v7 = this.f10084a;
        if (v7 != null) {
            v7.b(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.Y.a(activity);
    }
}
