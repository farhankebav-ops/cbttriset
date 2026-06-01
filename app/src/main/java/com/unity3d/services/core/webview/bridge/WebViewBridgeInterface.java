package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    public WebViewBridgeInterface() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JavascriptInterface
    public final void handleCallback(String callbackId, String callbackStatus, String rawParameters) throws Exception {
        k.e(callbackId, "callbackId");
        k.e(callbackStatus, "callbackStatus");
        k.e(rawParameters, "rawParameters");
        DeviceLog.debug("handleCallback " + callbackId + ' ' + callbackStatus + ' ' + rawParameters);
        this.webViewBridge.handleCallback(callbackId, callbackStatus, JSONArrayExtensionsKt.toTypedArray(new JSONArray(rawParameters)));
    }

    @JavascriptInterface
    public final void handleInvocation(String data) throws JSONException {
        k.e(data, "data");
        DeviceLog.debug("handleInvocation ".concat(data));
        JSONArray jSONArray = new JSONArray(data);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            k.c(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            k.c(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            k.c(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            k.c(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            k.c(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, JSONArrayExtensionsKt.toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    public final void onHandleCallback(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean z2, JavaScriptReplyProxy replyProxy) throws Exception {
        k.e(view, "view");
        k.e(message, "message");
        k.e(sourceOrigin, "sourceOrigin");
        k.e(replyProxy, "replyProxy");
        String data = message.getData();
        if (!z2 || data == null || m.A0(data)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(data);
        String callbackId = jSONObject.getString("id");
        String callbackStatus = jSONObject.getString("status");
        String rawParameters = jSONObject.getString("parameters");
        k.d(callbackId, "callbackId");
        k.d(callbackStatus, "callbackStatus");
        k.d(rawParameters, "rawParameters");
        handleCallback(callbackId, callbackStatus, rawParameters);
    }

    public final void onHandleInvocation(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean z2, JavaScriptReplyProxy replyProxy) throws JSONException {
        k.e(view, "view");
        k.e(message, "message");
        k.e(sourceOrigin, "sourceOrigin");
        k.e(replyProxy, "replyProxy");
        String data = message.getData();
        if (!z2 || data == null || m.A0(data)) {
            return;
        }
        handleInvocation(data);
    }

    public WebViewBridgeInterface(IWebViewBridge webViewBridge, IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker) {
        k.e(webViewBridge, "webViewBridge");
        k.e(webViewAppInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = webViewBridge;
        this.webViewAppInvocationCallbackInvoker = webViewAppInvocationCallbackInvoker;
    }

    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i2, f fVar) {
        this((i2 & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i2 & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }
}
