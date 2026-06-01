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
@e(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1$2$1", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {83}, m = "invokeSuspend")
public final class AndroidEmbeddableWebViewAdPlayer$show$1$2$1 extends i implements p {
    int label;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidEmbeddableWebViewAdPlayer$show$1$2$1(AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, c<? super AndroidEmbeddableWebViewAdPlayer$show$1$2$1> cVar) {
        super(2, cVar);
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new AndroidEmbeddableWebViewAdPlayer$show$1$2$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer = this.this$0;
            this.label = 1;
            if (androidEmbeddableWebViewAdPlayer.destroy(this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((AndroidEmbeddableWebViewAdPlayer$show$1$2$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
