package com.unity3d.services.core.cache;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CacheEventSender implements Serializable {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender eventSender) {
        k.e(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    public final boolean sendEvent(CacheEvent eventId, Object... params) {
        k.e(eventId, "eventId");
        k.e(params, "params");
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, eventId, Arrays.copyOf(params, params.length));
    }
}
