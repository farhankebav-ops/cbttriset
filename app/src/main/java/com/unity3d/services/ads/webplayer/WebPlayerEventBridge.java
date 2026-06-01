package com.unity3d.services.ads.webplayer;

import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebPlayerEventBridge {
    public static void error(String str, String str2, String str3) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.ERROR, str2, str3, str);
        }
    }

    public static void sendFrameUpdate(String str, int i2, int i8, int i9, int i10, float f4) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FRAME_UPDATE, str, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Float.valueOf(f4));
        }
    }

    public static void sendGetFrameResponse(String str, String str2, int i2, int i8, int i9, int i10, float f4) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GET_FRAME_RESPONSE, str, str2, Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Float.valueOf(f4));
        }
    }
}
