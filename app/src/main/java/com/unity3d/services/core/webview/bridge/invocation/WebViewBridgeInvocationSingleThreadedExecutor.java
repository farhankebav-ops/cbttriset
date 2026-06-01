package com.unity3d.services.core.webview.bridge.invocation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebViewBridgeInvocationSingleThreadedExecutor {
    private static WebViewBridgeInvocationSingleThreadedExecutor instance;
    private ExecutorService _ExecutorService = Executors.newSingleThreadExecutor();

    private WebViewBridgeInvocationSingleThreadedExecutor() {
    }

    public static WebViewBridgeInvocationSingleThreadedExecutor getInstance() {
        if (instance == null) {
            instance = new WebViewBridgeInvocationSingleThreadedExecutor();
        }
        return instance;
    }

    public ExecutorService getExecutorService() {
        return this._ExecutorService;
    }
}
