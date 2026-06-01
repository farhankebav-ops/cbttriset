package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {
    private final androidx.webkit.WebViewRenderProcessClient mWebViewRenderProcessClient;

    public WebViewRenderProcessClientFrameworkAdapter(@NonNull androidx.webkit.WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    @Nullable
    public androidx.webkit.WebViewRenderProcessClient getFrameworkRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public void onRenderProcessResponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        this.mWebViewRenderProcessClient.onRenderProcessResponsive(webView, WebViewRenderProcessImpl.forFrameworkObject(webViewRenderProcess));
    }

    public void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        this.mWebViewRenderProcessClient.onRenderProcessUnresponsive(webView, WebViewRenderProcessImpl.forFrameworkObject(webViewRenderProcess));
    }
}
