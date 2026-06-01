package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static void close(@NonNull WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    @NonNull
    public static WebMessage createWebMessage(@NonNull WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.getData(), WebMessagePortImpl.compatToPorts(webMessageCompat.getPorts()));
    }

    @NonNull
    public static WebMessagePort[] createWebMessageChannel(@NonNull WebView webView) {
        return webView.createWebMessageChannel();
    }

    @NonNull
    public static WebMessageCompat createWebMessageCompat(@NonNull WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.portsToCompat(webMessage.getPorts()));
    }

    @NonNull
    public static CharSequence getDescription(@NonNull WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int getErrorCode(@NonNull WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    public static void postMessage(@NonNull WebMessagePort webMessagePort, @NonNull WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void postVisualStateCallback(@NonNull WebView webView, long j, @NonNull final WebViewCompat.VisualStateCallback visualStateCallback) {
        webView.postVisualStateCallback(j, new WebView.VisualStateCallback() { // from class: androidx.webkit.internal.ApiHelperForM.3
            @Override // android.webkit.WebView.VisualStateCallback
            public void onComplete(long j3) {
                visualStateCallback.onComplete(j3);
            }
        });
    }

    public static void postWebMessage(@NonNull WebView webView, @NonNull WebMessage webMessage, @NonNull Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z2) {
        webSettings.setOffscreenPreRaster(z2);
    }

    public static void setWebMessageCallback(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: androidx.webkit.internal.ApiHelperForM.1
            @Override // android.webkit.WebMessagePort.WebMessageCallback
            public void onMessage(WebMessagePort webMessagePort2, WebMessage webMessage) {
                webMessageCallbackCompat.onMessage(new WebMessagePortImpl(webMessagePort2), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
            }
        });
    }

    public static void setWebMessageCallback(@NonNull WebMessagePort webMessagePort, @NonNull final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat, @Nullable Handler handler) {
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: androidx.webkit.internal.ApiHelperForM.2
            @Override // android.webkit.WebMessagePort.WebMessageCallback
            public void onMessage(WebMessagePort webMessagePort2, WebMessage webMessage) {
                webMessageCallbackCompat.onMessage(new WebMessagePortImpl(webMessagePort2), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
            }
        }, handler);
    }
}
