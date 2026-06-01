package com.unity3d.ads.adplayer;

import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f0;
import q6.q;
import q6.r;
import q6.u;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Invocation {
    private final q _isHandled;
    private final q completableDeferred;
    private final String location;
    private final Object[] parameters;

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.Invocation$handle$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.Invocation$handle$2", f = "Invocation.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements l {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.adplayer.Invocation$handle$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.adplayer.Invocation$handle$3", f = "Invocation.kt", l = {23}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ l $handler;
        int label;
        final /* synthetic */ Invocation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(l lVar, Invocation invocation, c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$handler = lVar;
            this.this$0 = invocation;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass3(this.$handler, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    r2.q.z0(obj);
                    l lVar = this.$handler;
                    this.label = 1;
                    obj = lVar.invoke(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                ((r) this.this$0.completableDeferred).N(obj);
            } catch (Throwable th) {
                r rVar = (r) this.this$0.completableDeferred;
                rVar.getClass();
                rVar.N(new u(false, th));
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass3) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public Invocation(String location, Object[] parameters) {
        k.e(location, "location");
        k.e(parameters, "parameters");
        this.location = location;
        this.parameters = parameters;
        this._isHandled = c0.a();
        this.completableDeferred = c0.a();
    }

    public static /* synthetic */ Object handle$default(Invocation invocation, l lVar, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = new AnonymousClass2(null);
        }
        return invocation.handle(lVar, cVar);
    }

    public final String getLocation() {
        return this.location;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }

    public final Object getResult(c<Object> cVar) {
        Object objT = ((r) this.completableDeferred).t(cVar);
        a aVar = a.f17774a;
        return objT;
    }

    public final Object handle(l lVar, c<? super x> cVar) {
        r rVar = (r) this._isHandled;
        x xVar = x.f13520a;
        rVar.N(xVar);
        c0.u(c0.b(cVar.getContext()), null, new AnonymousClass3(lVar, this, null), 3);
        return xVar;
    }

    public final f0 isHandled() {
        return this._isHandled;
    }
}
