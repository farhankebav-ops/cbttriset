package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17445f;
    public final /* synthetic */ e g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, v5.c cVar) {
        super(2, cVar);
        this.g = eVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        return new h(this.g, cVar);
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((q6.a0) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.f17445f;
        q5.x xVar = q5.x.f13520a;
        if (i2 == 0) {
            r2.q.z0(obj);
            this.f17445f = 1;
            Object objCollect = this.g.collect(u6.n.f17558a, this);
            if (objCollect != aVar) {
                objCollect = xVar;
            }
            if (objCollect == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
        }
        return xVar;
    }
}
