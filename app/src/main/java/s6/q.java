package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f13755f;
    public int g;
    public /* synthetic */ Object h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f13756i;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, Object obj2, v5.c cVar, int i2) {
        super(2, cVar);
        this.f13755f = i2;
        this.f13756i = obj;
        this.j = obj2;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [e6.q, x5.i] */
    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        switch (this.f13755f) {
            case 0:
                q qVar = new q((a0) this.j, this.f13756i, cVar);
                qVar.h = obj;
                return qVar;
            case 1:
                q qVar2 = new q((t6.e) this.f13756i, (e6.q) this.j, cVar);
                qVar2.h = obj;
                return qVar2;
            case 2:
                q qVar3 = new q((t6.f) this.f13756i, (t6.d) this.j, cVar, 2);
                qVar3.h = obj;
                return qVar3;
            default:
                q qVar4 = new q((t6.n) this.f13756i, (t6.f) this.j, cVar, 3);
                qVar4.h = obj;
                return qVar4;
        }
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f13755f) {
        }
        return ((q) create((q6.a0) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d0  */
    /* JADX WARN: Type inference failed for: r3v2, types: [e6.q, x5.i] */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(a0 a0Var, Object obj, v5.c cVar) {
        super(2, cVar);
        this.f13755f = 0;
        this.j = a0Var;
        this.f13756i = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q(t6.e eVar, e6.q qVar, v5.c cVar) {
        super(2, cVar);
        this.f13755f = 1;
        this.f13756i = eVar;
        this.j = (x5.i) qVar;
    }
}
