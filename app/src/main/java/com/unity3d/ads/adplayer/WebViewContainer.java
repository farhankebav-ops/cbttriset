package com.unity3d.ads.adplayer;

import q5.x;
import t6.b1;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface WebViewContainer {
    Object addJavascriptInterface(WebViewBridge webViewBridge, String str, c<? super x> cVar);

    Object destroy(c<? super x> cVar);

    Object evaluateJavascript(String str, c<? super x> cVar);

    b1 getLastInputEvent();

    Object loadUrl(String str, c<? super x> cVar);
}
