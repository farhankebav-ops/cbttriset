package com.unity3d.services.ads.api;

import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Topics {
    private static final TopicsService topicsService = (TopicsService) Utilities.getService(TopicsService.class);

    @WebViewExposed
    public static void checkAvailability(WebViewCallback webViewCallback) {
        webViewCallback.invoke(topicsService.checkAvailability());
    }

    @WebViewExposed
    public static void getTopics(String str, Boolean bool, WebViewCallback webViewCallback) {
        topicsService.getTopics(str, bool.booleanValue());
        webViewCallback.invoke(new Object[0]);
    }
}
