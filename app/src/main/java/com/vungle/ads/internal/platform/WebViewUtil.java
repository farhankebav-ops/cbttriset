package com.vungle.ads.internal.platform;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.util.Consumer;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewUtil {
    public static final WebViewUtil INSTANCE = new WebViewUtil();
    private static final String TAG = "WebViewUtil";

    private WebViewUtil() {
    }

    public final void applyWebSettings(WebView webView, AdPayload.WebViewSettings webViewSettings) {
        Boolean allowUniversalAccessFromFileUrls;
        Boolean allowFileAccessFromFileUrls;
        k.e(webView, "webView");
        WebSettings settings = webView.getSettings();
        k.d(settings, "webView.settings");
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs((webViewSettings == null || (allowFileAccessFromFileUrls = webViewSettings.getAllowFileAccessFromFileUrls()) == null) ? false : allowFileAccessFromFileUrls.booleanValue());
        settings.setAllowUniversalAccessFromFileURLs((webViewSettings == null || (allowUniversalAccessFromFileUrls = webViewSettings.getAllowUniversalAccessFromFileUrls()) == null) ? false : allowUniversalAccessFromFileUrls.booleanValue());
        webView.setVisibility(4);
        settings.setMediaPlaybackRequiresUserGesture(false);
    }

    public final void getUserAgent(Context context, Consumer<String> consumer) {
        Object objM;
        k.e(context, "context");
        k.e(consumer, "consumer");
        try {
            objM = WebSettings.getDefaultUserAgent(context);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (!(objM instanceof j)) {
            consumer.accept((String) objM);
        }
        Throwable thA = q5.k.a(objM);
        if (thA != null) {
            Logger.Companion.e(TAG, "Failed to get user agent", thA);
            consumer.accept(null);
        }
    }
}
