package androidx.datastore.core;

import e6.p;
import q5.x;
import r2.q;
import t6.f;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
public final class SingleProcessCoordinator$updateNotifications$1 extends i implements p {
    int label;

    public SingleProcessCoordinator$updateNotifications$1(c<? super SingleProcessCoordinator$updateNotifications$1> cVar) {
        super(2, cVar);
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new SingleProcessCoordinator$updateNotifications$1(cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        return x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(f fVar, c<? super x> cVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(fVar, cVar)).invokeSuspend(x.f13520a);
    }
}
