package com.unity3d.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import androidx.camera.core.impl.b;
import androidx.camera.core.processing.c;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.services.core.configuration.Experiments;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import kotlin.jvm.internal.k;
import n6.n;
import q5.f;
import q5.g;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebView extends android.webkit.WebView implements IServiceComponent {
    private final f sdkMetricsSender$delegate;
    private final WebViewBridgeInterface webViewBridgeInterface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context) {
        this(context, false, null, null, null, 30, null);
        k.e(context, "context");
    }

    private final void applySafeAreaInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this, 27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applySafeAreaInsets$lambda$3(WebView this$0, View v2, WindowInsetsCompat insets) {
        Object objM;
        k.e(this$0, "this$0");
        k.e(v2, "v");
        k.e(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        k.d(insets2, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.displayCutout());
        k.d(insets3, "insets.getInsets(WindowI…pat.Type.displayCutout())");
        try {
            objM = Float.valueOf(this$0.getContext().getResources().getDisplayMetrics().density);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        Object objValueOf = Float.valueOf(1.0f);
        if (objM instanceof j) {
            objM = objValueOf;
        }
        float fFloatValue = ((Number) objM).floatValue();
        int iApplySafeAreaInsets$lambda$3$toPx = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.left, insets3.left), fFloatValue);
        int iApplySafeAreaInsets$lambda$3$toPx2 = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.top, insets3.top), fFloatValue);
        int iApplySafeAreaInsets$lambda$3$toPx3 = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.right, insets3.right), fFloatValue);
        int iApplySafeAreaInsets$lambda$3$toPx4 = applySafeAreaInsets$lambda$3$toPx(Math.max(insets2.bottom, insets3.bottom), fFloatValue);
        StringBuilder sbW = a1.a.w(iApplySafeAreaInsets$lambda$3$toPx, "\n                (function() {\n                    const root = document.documentElement;\n                    root.style.setProperty('--safe-area-inset-left', '", "px');\n                    root.style.setProperty('--safe-area-inset-right', '", iApplySafeAreaInsets$lambda$3$toPx3, "px');\n                    root.style.setProperty('--safe-area-inset-top', '");
        sbW.append(iApplySafeAreaInsets$lambda$3$toPx2);
        sbW.append("px');\n                    root.style.setProperty('--safe-area-inset-bottom', '");
        sbW.append(iApplySafeAreaInsets$lambda$3$toPx4);
        sbW.append("px');\n                })();\n            ");
        this$0.evaluateJavascript(n.b0(sbW.toString()), null);
        return insets;
    }

    private static final int applySafeAreaInsets$lambda$3$toPx(int i2, float f4) {
        return (int) (i2 / f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateJavascript$lambda$1(WebView this$0, String script, ValueCallback valueCallback) {
        k.e(this$0, "this$0");
        k.e(script, "$script");
        super.evaluateJavascript(script, valueCallback);
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        return (SDKMetricsSender) this.sdkMetricsSender$delegate.getValue();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String script, ValueCallback<String> valueCallback) {
        k.e(script, "script");
        Utilities.runOnUiThread(new c(this, script, valueCallback, 29));
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        k.e(url, "url");
        DeviceLog.debug("Loading url: ".concat(url));
        super.loadUrl(url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2) {
        this(context, z2, null, null, null, 28, null);
        k.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge webViewBridge) {
        this(context, z2, webViewBridge, null, null, 24, null);
        k.e(context, "context");
        k.e(webViewBridge, "webViewBridge");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge webViewBridge, IInvocationCallbackInvoker callbackInvoker) {
        this(context, z2, webViewBridge, callbackInvoker, null, 16, null);
        k.e(context, "context");
        k.e(webViewBridge, "webViewBridge");
        k.e(callbackInvoker, "callbackInvoker");
    }

    public /* synthetic */ WebView(Context context, boolean z2, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments, int i2, kotlin.jvm.internal.f fVar) {
        this(context, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i2 & 8) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker, (i2 & 16) != 0 ? new Experiments() : iExperiments);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z2, IWebViewBridge webViewBridge, IInvocationCallbackInvoker callbackInvoker, IExperiments experiments) {
        super(context);
        k.e(context, "context");
        k.e(webViewBridge, "webViewBridge");
        k.e(callbackInvoker, "callbackInvoker");
        k.e(experiments, "experiments");
        this.sdkMetricsSender$delegate = n7.b.B(g.f13496c, new WebView$special$$inlined$inject$default$1(this, ""));
        final WebViewBridgeInterface webViewBridgeInterface = new WebViewBridgeInterface(webViewBridge, callbackInvoker);
        this.webViewBridgeInterface = webViewBridgeInterface;
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(false);
        settings.setEnableSmoothTransition(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(1);
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(!z2);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        boolean zIsWebMessageEnabled = experiments.isWebMessageEnabled();
        if (zIsWebMessageEnabled) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric());
        }
        boolean zIsFeatureSupported = WebViewFeature.isFeatureSupported(WebViewFeature.WEB_MESSAGE_LISTENER);
        if (zIsFeatureSupported) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric());
        }
        if (zIsWebMessageEnabled && zIsFeatureSupported) {
            final int i2 = 0;
            WebViewCompat.addWebMessageListener(this, "handleInvocation", n7.b.N(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.a
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z7, JavaScriptReplyProxy javaScriptReplyProxy) throws Exception {
                    switch (i2) {
                        case 0:
                            webViewBridgeInterface.onHandleInvocation(webView, webMessageCompat, uri, z7, javaScriptReplyProxy);
                            break;
                        default:
                            webViewBridgeInterface.onHandleCallback(webView, webMessageCompat, uri, z7, javaScriptReplyProxy);
                            break;
                    }
                }
            });
            final int i8 = 1;
            WebViewCompat.addWebMessageListener(this, "handleCallback", n7.b.N(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.a
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z7, JavaScriptReplyProxy javaScriptReplyProxy) throws Exception {
                    switch (i8) {
                        case 0:
                            webViewBridgeInterface.onHandleInvocation(webView, webMessageCompat, uri, z7, javaScriptReplyProxy);
                            break;
                        default:
                            webViewBridgeInterface.onHandleCallback(webView, webMessageCompat, uri, z7, javaScriptReplyProxy);
                            break;
                    }
                }
            });
        } else {
            addJavascriptInterface(webViewBridgeInterface, "webviewbridge");
        }
        applySafeAreaInsets();
    }
}
