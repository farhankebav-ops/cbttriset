package androidx.webkit;

import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface Profile {
    public static final String DEFAULT_PROFILE_NAME = "Default";

    @NonNull
    @AnyThread
    CookieManager getCookieManager();

    @NonNull
    @AnyThread
    GeolocationPermissions getGeolocationPermissions();

    @NonNull
    @AnyThread
    String getName();

    @NonNull
    @AnyThread
    ServiceWorkerController getServiceWorkerController();

    @NonNull
    @AnyThread
    WebStorage getWebStorage();
}
