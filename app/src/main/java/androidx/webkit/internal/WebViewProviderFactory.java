package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface WebViewProviderFactory {
    @NonNull
    WebViewProviderBoundaryInterface createWebView(@NonNull WebView webView);

    @NonNull
    DropDataContentProviderBoundaryInterface getDropDataProvider();

    @NonNull
    ProfileStoreBoundaryInterface getProfileStore();

    @NonNull
    ProxyControllerBoundaryInterface getProxyController();

    @NonNull
    ServiceWorkerControllerBoundaryInterface getServiceWorkerController();

    @NonNull
    StaticsBoundaryInterface getStatics();

    @NonNull
    TracingControllerBoundaryInterface getTracingController();

    @NonNull
    String[] getWebViewFeatures();

    @NonNull
    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
