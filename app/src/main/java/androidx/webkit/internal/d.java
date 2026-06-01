package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcessClient f4090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f4091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WebViewRenderProcess f4092d;

    public /* synthetic */ d(WebViewRenderProcessClient webViewRenderProcessClient, WebView webView, WebViewRenderProcessImpl webViewRenderProcessImpl, int i2) {
        this.f4089a = i2;
        this.f4090b = webViewRenderProcessClient;
        this.f4091c = webView;
        this.f4092d = webViewRenderProcessImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4089a) {
            case 0:
                this.f4090b.onRenderProcessResponsive(this.f4091c, this.f4092d);
                break;
            default:
                this.f4090b.onRenderProcessUnresponsive(this.f4091c, this.f4092d);
                break;
        }
    }
}
