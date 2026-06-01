package com.unity3d.ads.adplayer;

import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer$applySafeAreaInsets$1$1", f = "AndroidWebViewContainer.kt", l = {}, m = "invokeSuspend")
public final class AndroidWebViewContainer$applySafeAreaInsets$1$1 extends i implements p {
    final /* synthetic */ String $js;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidWebViewContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidWebViewContainer$applySafeAreaInsets$1$1(AndroidWebViewContainer androidWebViewContainer, String str, c<? super AndroidWebViewContainer$applySafeAreaInsets$1$1> cVar) {
        super(2, cVar);
        this.this$0 = androidWebViewContainer;
        this.$js = str;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        AndroidWebViewContainer$applySafeAreaInsets$1$1 androidWebViewContainer$applySafeAreaInsets$1$1 = new AndroidWebViewContainer$applySafeAreaInsets$1$1(this.this$0, this.$js, cVar);
        androidWebViewContainer$applySafeAreaInsets$1$1.L$0 = obj;
        return androidWebViewContainer$applySafeAreaInsets$1$1;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        AndroidWebViewContainer androidWebViewContainer = this.this$0;
        try {
            androidWebViewContainer.getWebView().evaluateJavascript(this.$js, null);
        } catch (Throwable th) {
            q.M(th);
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((AndroidWebViewContainer$applySafeAreaInsets$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
