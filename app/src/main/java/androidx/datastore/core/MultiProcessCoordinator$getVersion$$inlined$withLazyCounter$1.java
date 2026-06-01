package androidx.datastore.core;

import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1", f = "MultiProcessCoordinator.android.kt", l = {}, m = "invokeSuspend")
public final class MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1 extends i implements p {
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(MultiProcessCoordinator multiProcessCoordinator, c cVar) {
        super(2, cVar);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        return new Integer(this.this$0.getSharedCounter().getValue());
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super Integer> cVar) {
        return ((MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
