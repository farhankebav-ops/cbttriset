package w5;

import e6.p;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import r2.q;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17779f;
    public final /* synthetic */ p g;
    public final /* synthetic */ v5.c h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(v5.c cVar, h hVar, p pVar, v5.c cVar2) {
        super(cVar, hVar);
        this.g = pVar;
        this.h = cVar2;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i2 = this.f17779f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f17779f = 2;
            q.z0(obj);
            return obj;
        }
        this.f17779f = 1;
        q.z0(obj);
        p pVar = this.g;
        k.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        d0.d(2, pVar);
        return pVar.invoke(this.h, this);
    }
}
