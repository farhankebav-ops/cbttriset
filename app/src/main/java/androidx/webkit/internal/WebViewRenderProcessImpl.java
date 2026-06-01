package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.transition.e;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.internal.ApiFeature;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewRenderProcessImpl extends WebViewRenderProcess {
    private static final WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> sFrameworkMap = new WeakHashMap<>();
    private WebViewRendererBoundaryInterface mBoundaryInterface;
    private WeakReference<android.webkit.WebViewRenderProcess> mFrameworkObject;

    public WebViewRenderProcessImpl(@NonNull WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.mBoundaryInterface = webViewRendererBoundaryInterface;
    }

    @NonNull
    public static WebViewRenderProcessImpl forFrameworkObject(@NonNull android.webkit.WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> weakHashMap = sFrameworkMap;
        WebViewRenderProcessImpl webViewRenderProcessImpl = weakHashMap.get(webViewRenderProcess);
        if (webViewRenderProcessImpl != null) {
            return webViewRenderProcessImpl;
        }
        WebViewRenderProcessImpl webViewRenderProcessImpl2 = new WebViewRenderProcessImpl(webViewRenderProcess);
        weakHashMap.put(webViewRenderProcess, webViewRenderProcessImpl2);
        return webViewRenderProcessImpl2;
    }

    @NonNull
    public static WebViewRenderProcessImpl forInvocationHandler(@NonNull InvocationHandler invocationHandler) {
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) n7.b.h(WebViewRendererBoundaryInterface.class, invocationHandler);
        return (WebViewRenderProcessImpl) webViewRendererBoundaryInterface.getOrCreatePeer(new c(webViewRendererBoundaryInterface, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$forInvocationHandler$0(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) throws Exception {
        return new WebViewRenderProcessImpl(webViewRendererBoundaryInterface);
    }

    @Override // androidx.webkit.WebViewRenderProcess
    public boolean terminate() {
        ApiFeature.Q q7 = WebViewFeatureInternal.WEB_VIEW_RENDERER_TERMINATE;
        if (q7.isSupportedByFramework()) {
            android.webkit.WebViewRenderProcess webViewRenderProcessG = e.g(this.mFrameworkObject.get());
            return webViewRenderProcessG != null && ApiHelperForQ.terminate(webViewRenderProcessG);
        }
        if (q7.isSupportedByWebView()) {
            return this.mBoundaryInterface.terminate();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebViewRenderProcessImpl(@NonNull android.webkit.WebViewRenderProcess webViewRenderProcess) {
        this.mFrameworkObject = new WeakReference<>(webViewRenderProcess);
    }
}
