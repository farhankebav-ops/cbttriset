package com.unity3d.ads.adplayer;

import androidx.lifecycle.LifecycleOwnerKt;
import com.unity3d.ads.adplayer.DisplayMessage;
import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.j;
import r2.q;
import t6.f;
import t6.p0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1", f = "FullScreenWebViewDisplay.kt", l = {}, m = "invokeSuspend")
public final class FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1 extends i implements p {
    final /* synthetic */ j $continuation;
    int label;
    final /* synthetic */ FullScreenWebViewDisplay this$0;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1$1", f = "FullScreenWebViewDisplay.kt", l = {102}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ j $continuation;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FullScreenWebViewDisplay this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FullScreenWebViewDisplay fullScreenWebViewDisplay, j jVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = fullScreenWebViewDisplay;
            this.$continuation = jVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$continuation, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a0 a0Var;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                a0 a0Var2 = (a0) this.L$0;
                p0 displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
                DisplayMessage.WebViewInstanceRequest webViewInstanceRequest = new DisplayMessage.WebViewInstanceRequest(this.this$0.opportunityId);
                this.L$0 = a0Var2;
                this.label = 1;
                if (displayMessages.emit(webViewInstanceRequest, this) == aVar) {
                    return aVar;
                }
                a0Var = a0Var2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a0Var = (a0) this.L$0;
                q.z0(obj);
            }
            c0.l(a0Var.getCoroutineContext());
            j jVar = this.$continuation;
            x xVar = x.f13520a;
            jVar.resumeWith(xVar);
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1(FullScreenWebViewDisplay fullScreenWebViewDisplay, j jVar, c<? super FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1> cVar) {
        super(2, cVar);
        this.this$0 = fullScreenWebViewDisplay;
        this.$continuation = jVar;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1(this.this$0, this.$continuation, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        c0.u(LifecycleOwnerKt.getLifecycleScope(this.this$0), this.this$0.getDispatchers().getDefault(), new AnonymousClass1(this.this$0, this.$continuation, null), 2);
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(f fVar, c<? super x> cVar) {
        return ((FullScreenWebViewDisplay$listenToAdPlayerEvents$2$1) create(fVar, cVar)).invokeSuspend(x.f13520a);
    }
}
