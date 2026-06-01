package com.unity3d.ads.adplayer;

import com.unity3d.services.core.device.Storage;
import q6.x;
import q6.y;
import v5.a;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 extends a implements y {
    final /* synthetic */ WebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(x xVar, WebViewAdPlayer webViewAdPlayer) {
        super(xVar);
        this.this$0 = webViewAdPlayer;
    }

    @Override // q6.y
    public void handleException(h hVar, Throwable th) {
        Storage.Companion.removeStorageEventCallback(this.this$0.storageEventCallback);
    }
}
