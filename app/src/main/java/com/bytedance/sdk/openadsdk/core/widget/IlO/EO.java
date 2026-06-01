package com.bytedance.sdk.openadsdk.core.widget.IlO;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.oeT;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private final WeakReference<Context> IlO;
    private boolean MY = true;
    private final boolean EO = true;
    private final boolean tV = true;
    private final boolean Cc = false;
    private final boolean vCE = true;
    private boolean Bc = true;

    private EO(Context context) {
        this.IlO = new WeakReference<>(context);
    }

    public static EO IlO(Context context) {
        return new EO(context);
    }

    public EO MY(boolean z2) {
        this.MY = z2;
        return this;
    }

    public static void MY(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            oeT.EO(th.toString(), new Object[0]);
        }
    }

    public EO IlO(boolean z2) {
        this.Bc = z2;
        return this;
    }

    public void IlO(WebView webView) {
        if (webView == null || this.IlO.get() == null) {
            return;
        }
        MY(webView);
        WebSettings settings = webView.getSettings();
        IlO(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            oeT.EO("SSWebSettings", e.getMessage());
        }
        try {
            if (this.MY) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            oeT.EO("SSWebSettings", th.getMessage());
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(false);
        try {
            if (this.Bc) {
                webView.setLayerType(2, null);
            } else {
                webView.setLayerType(0, null);
            }
        } catch (Throwable th2) {
            oeT.EO("SSWebSettings", th2.getMessage());
        }
    }

    private void IlO(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            oeT.EO(th.toString(), new Object[0]);
        }
    }

    public static void IlO(com.bytedance.sdk.component.DmF.vCE vce) {
        if (vce == null) {
            return;
        }
        int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("clear_web_cache_new", 0);
        if (iIlO == 0) {
            vce.IlO(true);
        } else if (iIlO == 1) {
            vce.IlO(false);
        }
    }
}
