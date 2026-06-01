package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE};
    private final Executor mExecutor;
    private final WebViewRenderProcessClient mWebViewRenderProcessClient;

    public WebViewRenderProcessClientAdapter(@Nullable Executor executor, @Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mExecutor = executor;
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @NonNull
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererResponsive(@NonNull WebView webView, @NonNull InvocationHandler invocationHandler) {
        WebViewRenderProcessImpl webViewRenderProcessImplForInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessResponsive(webView, webViewRenderProcessImplForInvocationHandler);
        } else {
            executor.execute(new d(webViewRenderProcessClient, webView, webViewRenderProcessImplForInvocationHandler, 0));
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererUnresponsive(@NonNull WebView webView, @NonNull InvocationHandler invocationHandler) {
        WebViewRenderProcessImpl webViewRenderProcessImplForInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessUnresponsive(webView, webViewRenderProcessImplForInvocationHandler);
        } else {
            executor.execute(new d(webViewRenderProcessClient, webView, webViewRenderProcessImplForInvocationHandler, 1));
        }
    }
}
