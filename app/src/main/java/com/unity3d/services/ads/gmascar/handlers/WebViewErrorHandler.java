package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebViewErrorHandler implements d {
    private final IEventSender _eventSender;

    public WebViewErrorHandler() {
        this(SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public WebViewErrorHandler(IEventSender iEventSender) {
        this._eventSender = iEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void handleError(j jVar) {
        this._eventSender.sendEvent(WebViewEventCategory.valueOf(jVar.getDomain()), jVar.getErrorCategory(), jVar.getErrorArguments());
    }
}
