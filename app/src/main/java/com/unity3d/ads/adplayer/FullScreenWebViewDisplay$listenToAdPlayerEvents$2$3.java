package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.DisplayMessage;
import e6.p;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3", f = "FullScreenWebViewDisplay.kt", l = {}, m = "invokeSuspend")
public final class FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FullScreenWebViewDisplay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3(FullScreenWebViewDisplay fullScreenWebViewDisplay, c<? super FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3> cVar) {
        super(2, cVar);
        this.this$0 = fullScreenWebViewDisplay;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3 fullScreenWebViewDisplay$listenToAdPlayerEvents$2$3 = new FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3(this.this$0, cVar);
        fullScreenWebViewDisplay$listenToAdPlayerEvents$2$3.L$0 = obj;
        return fullScreenWebViewDisplay$listenToAdPlayerEvents$2$3;
    }

    @Override // e6.p
    public final Object invoke(DisplayMessage displayMessage, c<? super x> cVar) {
        return ((FullScreenWebViewDisplay$listenToAdPlayerEvents$2$3) create(displayMessage, cVar)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        DisplayMessage displayMessage = (DisplayMessage) this.L$0;
        if (displayMessage instanceof DisplayMessage.DisplayFinishRequest) {
            this.this$0.finish();
        } else if (displayMessage instanceof DisplayMessage.WebViewInstanceResponse) {
            this.this$0.loadWebView(((DisplayMessage.WebViewInstanceResponse) displayMessage).getWebView());
        } else if (displayMessage instanceof DisplayMessage.SetOrientation) {
            this.this$0.setRequestedOrientation(((DisplayMessage.SetOrientation) displayMessage).getOrientation());
        }
        return x.f13520a;
    }
}
