package com.unity3d.services.core.webview;

import android.content.Context;
import android.webkit.WebSettings;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebViewWithCache extends WebView {
    /* JADX WARN: Illegal instructions before constructor call */
    public WebViewWithCache(Context context, boolean z2, IExperiments iExperiments) {
        SharedInstances sharedInstances = SharedInstances.INSTANCE;
        this(context, z2, sharedInstances.getWebViewBridge(), sharedInstances.getWebViewAppInvocationCallbackInvoker(), iExperiments);
    }

    public WebViewWithCache(Context context, boolean z2, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments) {
        super(context, z2, iWebViewBridge, iInvocationCallbackInvoker, iExperiments);
        WebSettings settings = getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        if (z2) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
    }
}
