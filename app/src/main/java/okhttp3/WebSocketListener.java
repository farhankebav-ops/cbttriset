package okhttp3;

import kotlin.jvm.internal.k;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i2, String reason) {
        k.e(webSocket, "webSocket");
        k.e(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i2, String reason) {
        k.e(webSocket, "webSocket");
        k.e(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t3, Response response) {
        k.e(webSocket, "webSocket");
        k.e(t3, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        k.e(webSocket, "webSocket");
        k.e(text, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        k.e(webSocket, "webSocket");
        k.e(response, "response");
    }

    public void onMessage(WebSocket webSocket, m bytes) {
        k.e(webSocket, "webSocket");
        k.e(bytes, "bytes");
    }
}
