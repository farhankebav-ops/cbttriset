package sg.bigo.ads.controller.landing;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import sg.bigo.ads.a.a;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.h.e;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final sg.bigo.ads.api.core.c f16681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final c.b f16682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f16684d = false;
    String e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    e f16685f;
    long g;

    /* JADX INFO: renamed from: sg.bigo.ads.controller.landing.a$a, reason: collision with other inner class name */
    public interface InterfaceC0310a {
        void a(String str);

        void a(String str, long j, boolean z2, int i2);
    }

    public a(@NonNull sg.bigo.ads.api.core.c cVar) {
        this.f16681a = cVar;
        c.b bVarN = cVar.N();
        this.f16682b = bVarN;
        this.f16683c = bVarN.f();
    }

    public final void a() {
        sg.bigo.ads.common.t.a.a(0, 3, "Preload", "recycleLandWebView isPreloadWebViewReady=" + this.f16684d);
        e eVar = this.f16685f;
        if (eVar != null) {
            eVar.destroy();
            this.f16685f = null;
        }
    }

    public final boolean b() {
        int i2 = this.f16683c;
        return i2 == 3 || i2 == 4;
    }

    public final void a(Context context, final String str, @NonNull final InterfaceC0310a interfaceC0310a) {
        this.g = SystemClock.elapsedRealtime();
        interfaceC0310a.a(str);
        e eVarA = e.a(context);
        this.f16685f = eVarA;
        if (eVarA == null) {
            return;
        }
        eVarA.setWebChromeClient(new sg.bigo.ads.core.h.c());
        this.f16685f.setWebViewClient(new sg.bigo.ads.core.h.d() { // from class: sg.bigo.ads.controller.landing.a.2
            @Override // sg.bigo.ads.core.h.d
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                a.this.f16685f = null;
                interfaceC0310a.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                sg.bigo.ads.common.t.a.a(0, 3, "Preload", "onPageFinished: url=" + webView.getUrl());
                interfaceC0310a.a(str2, SystemClock.elapsedRealtime() - a.this.g, true, 0);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i2, String str2, String str3) {
                super.onReceivedError(webView, i2, str2, str3);
                sg.bigo.ads.common.t.a.b("Preload", "onReceivedError: " + i2 + " " + str2);
                interfaceC0310a.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
                }
            }

            @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
            }
        });
        this.f16685f.setLeft(0);
        this.f16685f.setTop(0);
        this.f16685f.setRight(sg.bigo.ads.common.utils.e.b(context));
        this.f16685f.setBottom(sg.bigo.ads.common.utils.e.c(context) - sg.bigo.ads.common.utils.e.a(context, 55));
        this.f16685f.loadUrl(str);
    }

    public static /* synthetic */ void a(a aVar, Context context, final String str, int i2, final InterfaceC0310a interfaceC0310a) {
        if (i2 == 0) {
            aVar.a(context, str, interfaceC0310a);
            return;
        }
        if (i2 != 2) {
            sg.bigo.ads.common.t.a.a(0, "Preload", "PreloadLand: error open type.");
            return;
        }
        aVar.g = SystemClock.elapsedRealtime();
        a.C0225a c0225a = new a.C0225a();
        c0225a.f13779a = str;
        sg.bigo.ads.a.a aVarA = c0225a.a();
        sg.bigo.ads.a.c.a(context, aVarA.f13774a, new a.b() { // from class: sg.bigo.ads.controller.landing.a.1
            @Override // sg.bigo.ads.a.a.b
            public final void a(Context context2, String str2, final int i8, String str3) {
                sg.bigo.ads.common.t.a.a(0, 3, "Preload", "Preload by chrome tabs failed, using webView.");
                a.this.a(context2, str2, new InterfaceC0310a() { // from class: sg.bigo.ads.controller.landing.a.1.1
                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0310a
                    public final void a(String str4) {
                        InterfaceC0310a interfaceC0310a2 = interfaceC0310a;
                        if (interfaceC0310a2 != null) {
                            interfaceC0310a2.a(str4);
                        }
                    }

                    @Override // sg.bigo.ads.controller.landing.a.InterfaceC0310a
                    public final void a(String str4, long j, boolean z2, int i9) {
                        InterfaceC0310a interfaceC0310a2 = interfaceC0310a;
                        if (interfaceC0310a2 != null) {
                            interfaceC0310a2.a(str4, j, z2, d.a(i8));
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.a.a.b
            public final void a(String str2, String str3, String str4) {
                InterfaceC0310a interfaceC0310a2 = interfaceC0310a;
                if (interfaceC0310a2 != null) {
                    interfaceC0310a2.a(str, SystemClock.elapsedRealtime() - a.this.g, true, 2);
                }
            }
        });
    }
}
