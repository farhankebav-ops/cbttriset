package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kotlin.jvm.internal.a0 f17453f;
    public int g;
    public /* synthetic */ Object h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.a0 f17454i;
    public final /* synthetic */ f j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(kotlin.jvm.internal.a0 a0Var, f fVar, v5.c cVar) {
        super(2, cVar);
        this.f17454i = a0Var;
        this.j = fVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        j jVar = new j(this.f17454i, this.j, cVar);
        jVar.h = obj;
        return jVar;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create(new s6.o(((s6.o) obj).f13753a), (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.jvm.internal.a0 a0Var;
        kotlin.jvm.internal.a0 a0Var2;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.g;
        if (i2 == 0) {
            r2.q.z0(obj);
            Object obj2 = ((s6.o) this.h).f13753a;
            boolean z2 = obj2 instanceof s6.n;
            a0Var = this.f17454i;
            if (!z2) {
                a0Var.f12717a = obj2;
            }
            if (z2) {
                Throwable thA = s6.o.a(obj2);
                if (thA != null) {
                    throw thA;
                }
                Object obj3 = a0Var.f12717a;
                if (obj3 != null) {
                    if (obj3 == u6.c.f17544b) {
                        obj3 = null;
                    }
                    this.h = obj2;
                    this.f17453f = a0Var;
                    this.g = 1;
                    if (this.j.emit(obj3, this) == aVar) {
                        return aVar;
                    }
                    a0Var2 = a0Var;
                }
                a0Var.f12717a = u6.c.f17546d;
            }
            return q5.x.f13520a;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a0Var2 = this.f17453f;
        r2.q.z0(obj);
        a0Var = a0Var2;
        a0Var.f12717a = u6.c.f17546d;
        return q5.x.f13520a;
    }
}
