package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IAdModule<T extends IWebViewSharedObject, T2> extends IWebViewBridgeSharedObjectStore<T> {
    void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, T2 t22);

    SDKMetricsSender getMetricSender();
}
