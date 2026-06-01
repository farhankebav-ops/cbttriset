package u6;

import n6.u;
import q5.x;
import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends x5.c implements t6.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t6.f f17559f;
    public final v5.h g;
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v5.h f17560i;
    public v5.c j;

    public o(t6.f fVar, v5.h hVar) {
        super(m.f17557a, v5.i.f17610a);
        this.f17559f = fVar;
        this.g = hVar;
        this.h = ((Number) hVar.fold(0, new androidx.camera.camera2.internal.compat.workaround.a(6))).intValue();
    }

    public final Object a(v5.c cVar, Object obj) {
        v5.h context = cVar.getContext();
        c0.l(context);
        v5.h hVar = this.f17560i;
        if (hVar != context) {
            if (hVar instanceof j) {
                throw new IllegalStateException(n6.n.b0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((j) hVar).f17556b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new u(this, 2))).intValue() != this.h) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.g + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f17560i = context;
        }
        this.j = cVar;
        e6.q qVar = q.f17562a;
        t6.f fVar = this.f17559f;
        kotlin.jvm.internal.k.c(fVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objInvoke = qVar.invoke(fVar, obj, this);
        if (!kotlin.jvm.internal.k.a(objInvoke, w5.a.f17774a)) {
            this.j = null;
        }
        return objInvoke;
    }

    @Override // t6.f
    public final Object emit(Object obj, v5.c cVar) {
        try {
            Object objA = a(cVar, obj);
            return objA == w5.a.f17774a ? objA : x.f13520a;
        } catch (Throwable th) {
            this.f17560i = new j(cVar.getContext(), th);
            throw th;
        }
    }

    @Override // x5.a, x5.d
    public final x5.d getCallerFrame() {
        v5.c cVar = this.j;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // x5.c, v5.c
    public final v5.h getContext() {
        v5.h hVar = this.f17560i;
        return hVar == null ? v5.i.f17610a : hVar;
    }

    @Override // x5.a
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        Throwable thA = q5.k.a(obj);
        if (thA != null) {
            this.f17560i = new j(getContext(), thA);
        }
        v5.c cVar = this.j;
        if (cVar != null) {
            cVar.resumeWith(obj);
        }
        return w5.a.f17774a;
    }
}
