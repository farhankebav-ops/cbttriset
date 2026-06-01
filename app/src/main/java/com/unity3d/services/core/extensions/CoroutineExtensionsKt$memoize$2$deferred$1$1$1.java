package com.unity3d.services.core.extensions;

import e6.l;
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
@e(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$deferred$1$1$1", f = "CoroutineExtensions.kt", l = {41}, m = "invokeSuspend")
public final class CoroutineExtensionsKt$memoize$2$deferred$1$1$1 extends i implements p {
    final /* synthetic */ l $action;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineExtensionsKt$memoize$2$deferred$1$1$1(l lVar, c<? super CoroutineExtensionsKt$memoize$2$deferred$1$1$1> cVar) {
        super(2, cVar);
        this.$action = lVar;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(this.$action, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return obj;
        }
        q.z0(obj);
        l lVar = this.$action;
        this.label = 1;
        Object objInvoke = lVar.invoke(this);
        return objInvoke == aVar ? aVar : objInvoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$action.invoke(this);
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super T> cVar) {
        return ((CoroutineExtensionsKt$memoize$2$deferred$1$1$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
