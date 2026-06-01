package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationSingleThreadedExecutor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AdModule<T extends IWebViewSharedObject, T2> extends WebViewBridgeSharedObjectStore<T> implements IAdModule<T, T2> {
    protected ExecutorService _executorService = WebViewBridgeInvocationSingleThreadedExecutor.getInstance().getExecutorService();
    protected SDKMetricsSender _sdkMetrics;

    public AdModule(SDKMetricsSender sDKMetricsSender) {
        this._sdkMetrics = sDKMetricsSender;
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public SDKMetricsSender getMetricSender() {
        return this._sdkMetrics;
    }
}
