package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends x5.i implements e6.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17449f;
    public final /* synthetic */ f g;
    public final /* synthetic */ kotlin.jvm.internal.a0 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.jvm.internal.a0 a0Var, f fVar, v5.c cVar) {
        super(1, cVar);
        this.g = fVar;
        this.h = a0Var;
    }

    @Override // x5.a
    public final v5.c create(v5.c cVar) {
        return new i(this.h, this.g, cVar);
    }

    @Override // e6.l
    public final Object invoke(Object obj) {
        return ((i) create((v5.c) obj)).invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.f17449f;
        kotlin.jvm.internal.a0 a0Var = this.h;
        if (i2 == 0) {
            r2.q.z0(obj);
            e2.f fVar = u6.c.f17544b;
            Object obj2 = a0Var.f12717a;
            if (obj2 == fVar) {
                obj2 = null;
            }
            this.f17449f = 1;
            if (this.g.emit(obj2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
        }
        a0Var.f12717a = null;
        return q5.x.f13520a;
    }
}
