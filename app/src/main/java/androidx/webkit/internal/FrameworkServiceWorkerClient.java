package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(24)
public class FrameworkServiceWorkerClient extends ServiceWorkerClient {
    private final ServiceWorkerClientCompat mImpl;

    public FrameworkServiceWorkerClient(@NonNull ServiceWorkerClientCompat serviceWorkerClientCompat) {
        this.mImpl = serviceWorkerClientCompat;
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) {
        return this.mImpl.shouldInterceptRequest(webResourceRequest);
    }
}
