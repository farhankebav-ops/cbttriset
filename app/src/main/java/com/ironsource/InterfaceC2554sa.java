package com.ironsource;

import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: renamed from: com.ironsource.sa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2554sa {

    /* JADX INFO: renamed from: com.ironsource.sa$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2554sa {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WebView f9823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9824b;

        public a() {
            this(0, 1, null);
        }

        private final void b(String str) {
            WebView webView = this.f9823a;
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            }
        }

        private final void c(String str) {
            WebView webView = this.f9823a;
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }

        @Override // com.ironsource.InterfaceC2554sa
        public boolean a() {
            return this.f9823a != null;
        }

        public a(int i2) {
            this.f9824b = i2 >= 19;
        }

        @Override // com.ironsource.InterfaceC2554sa
        public void a(String script) {
            kotlin.jvm.internal.k.e(script, "script");
            try {
                if (this.f9824b) {
                    b(script);
                } else {
                    c(script);
                }
            } catch (Throwable th) {
                C2531r4.d().a(th);
                this.f9824b = false;
                c(script);
            }
        }

        public /* synthetic */ a(int i2, int i8, kotlin.jvm.internal.f fVar) {
            this((i8 & 1) != 0 ? Build.VERSION.SDK_INT : i2);
        }

        @Override // com.ironsource.InterfaceC2554sa
        public void a(WebView webView) {
            kotlin.jvm.internal.k.e(webView, "webView");
            this.f9823a = webView;
        }
    }

    void a(WebView webView);

    void a(String str);

    boolean a();
}
