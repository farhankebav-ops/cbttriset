package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.CommonWebViewBridge;
import com.unity3d.ads.adplayer.WebViewBridge;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.a0;
import q6.m0;
import q6.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonGetWebViewBridgeUseCase implements GetWebViewBridgeUseCase {
    private final w dispatcher;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonGetWebViewBridgeUseCase(w dispatcher, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(dispatcher, "dispatcher");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.dispatcher = dispatcher;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.GetWebViewBridgeUseCase
    public WebViewBridge invoke(AndroidWebViewContainer webViewContainer, a0 adPlayerScope) {
        k.e(webViewContainer, "webViewContainer");
        k.e(adPlayerScope, "adPlayerScope");
        return new CommonWebViewBridge(this.dispatcher, webViewContainer, adPlayerScope, this.sendDiagnosticEvent);
    }

    public CommonGetWebViewBridgeUseCase(w wVar, SendDiagnosticEvent sendDiagnosticEvent, int i2, f fVar) {
        this((i2 & 1) != 0 ? m0.f13566a : wVar, sendDiagnosticEvent);
    }
}
