package androidx.webkit.internal;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(24)
public class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static boolean getAllowContentAccess(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    public static boolean getAllowFileAccess(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    public static boolean getBlockNetworkLoads(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }

    public static int getCacheMode(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getCacheMode();
    }

    @NonNull
    public static File getDataDir(@NonNull Context context) {
        return context.getDataDir();
    }

    public static int getDisabledActionModeMenuItems(@NonNull WebSettings webSettings) {
        return webSettings.getDisabledActionModeMenuItems();
    }

    @NonNull
    public static ServiceWorkerController getServiceWorkerControllerInstance() {
        return ServiceWorkerController.getInstance();
    }

    @NonNull
    public static ServiceWorkerWebSettings getServiceWorkerWebSettings(@NonNull ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    @NonNull
    public static ServiceWorkerWebSettingsImpl getServiceWorkerWebSettingsImpl(@NonNull ServiceWorkerController serviceWorkerController) {
        return new ServiceWorkerWebSettingsImpl(getServiceWorkerWebSettings(serviceWorkerController));
    }

    public static boolean isRedirect(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    public static void setAllowContentAccess(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setAllowContentAccess(z2);
    }

    public static void setAllowFileAccess(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setAllowFileAccess(z2);
    }

    public static void setBlockNetworkLoads(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setBlockNetworkLoads(z2);
    }

    public static void setCacheMode(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, int i2) {
        serviceWorkerWebSettings.setCacheMode(i2);
    }

    public static void setDisabledActionModeMenuItems(@NonNull WebSettings webSettings, int i2) {
        webSettings.setDisabledActionModeMenuItems(i2);
    }

    public static void setServiceWorkerClient(@NonNull ServiceWorkerController serviceWorkerController, @Nullable ServiceWorkerClient serviceWorkerClient) {
        serviceWorkerController.setServiceWorkerClient(serviceWorkerClient);
    }

    public static void setServiceWorkerClientCompat(@NonNull ServiceWorkerController serviceWorkerController, @NonNull ServiceWorkerClientCompat serviceWorkerClientCompat) {
        serviceWorkerController.setServiceWorkerClient(new FrameworkServiceWorkerClient(serviceWorkerClientCompat));
    }
}
