package com.ironsource;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.K8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: renamed from: com.ironsource.o8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2485o8 extends WebViewClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9554b = "o8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final K8.a f9555a;

    public C2485o8(K8.a aVar) {
        this.f9555a = aVar;
    }

    private String a(String str, String str2) {
        return a1.a.n("ISNAdViewWebClient | External Adunit failed to load.", str, " Status code: ", str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        try {
            this.f9555a.a(a("onReceivedError", String.valueOf(i2)));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            this.f9555a.a(a("onReceivedHttpError", String.valueOf(webResourceResponse.getStatusCode())));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            Logger.e(f9554b, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            this.f9555a.b(renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system");
            return true;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.f9555a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
