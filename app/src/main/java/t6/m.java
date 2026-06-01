package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f17463f;
    public int g;
    public /* synthetic */ Object h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f17464i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(Object obj, v5.c cVar, int i2) {
        super(2, cVar);
        this.f17463f = i2;
        this.f17464i = obj;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        switch (this.f17463f) {
            case 0:
                m mVar = new m((d1) this.f17464i, cVar, 0);
                mVar.h = obj;
                return mVar;
            case 1:
                return new m((e) this.h, (w0) this.f17464i, cVar);
            case 2:
                m mVar2 = new m((d) this.f17464i, cVar, 2);
                mVar2.h = obj;
                return mVar2;
            case 3:
                m mVar3 = new m((d) this.f17464i, cVar, 3);
                mVar3.h = obj;
                return mVar3;
            default:
                m mVar4 = new m((f) this.f17464i, cVar, 4);
                mVar4.h = obj;
                return mVar4;
        }
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f17463f) {
            case 0:
                return ((m) create((s6.x) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
            case 1:
                return ((m) create((q6.a0) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
            case 2:
                return ((m) create((s6.x) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
            case 3:
                return ((m) create((f) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
            default:
                return ((m) create(obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
        }
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f17463f) {
            case 0:
                w5.a aVar = w5.a.f17774a;
                int i2 = this.g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                    return q5.x.f13520a;
                }
                r2.q.z0(obj);
                s6.x xVar = (s6.x) this.h;
                d1 d1Var = (d1) this.f17464i;
                l lVar = new l(xVar, 0);
                this.g = 1;
                d1Var.collect(lVar, this);
                return aVar;
            case 1:
                e eVar = (e) this.h;
                w0 w0Var = (w0) this.f17464i;
                w5.a aVar2 = w5.a.f17774a;
                int i8 = this.g;
                q5.x xVar2 = q5.x.f13520a;
                if (i8 == 0) {
                    r2.q.z0(obj);
                    this.g = 1;
                    if (eVar.collect(w0Var, this) == aVar2) {
                        return aVar2;
                    }
                } else if (i8 == 1) {
                    r2.q.z0(obj);
                } else if (i8 != 2) {
                    if (i8 != 3 && i8 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                } else {
                    r2.q.z0(obj);
                    this.g = 3;
                    if (eVar.collect(w0Var, this) == aVar2) {
                        return aVar2;
                    }
                }
                return xVar2;
            case 2:
                w5.a aVar3 = w5.a.f17774a;
                int i9 = this.g;
                if (i9 == 0) {
                    r2.q.z0(obj);
                    s6.x xVar3 = (s6.x) this.h;
                    d dVar = (d) this.f17464i;
                    this.g = 1;
                    if (dVar.b(xVar3, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return q5.x.f13520a;
            case 3:
                w5.a aVar4 = w5.a.f17774a;
                int i10 = this.g;
                if (i10 == 0) {
                    r2.q.z0(obj);
                    f fVar = (f) this.h;
                    d dVar2 = (d) this.f17464i;
                    this.g = 1;
                    if (dVar2.f(fVar, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return q5.x.f13520a;
            default:
                w5.a aVar5 = w5.a.f17774a;
                int i11 = this.g;
                if (i11 == 0) {
                    r2.q.z0(obj);
                    Object obj2 = this.h;
                    f fVar2 = (f) this.f17464i;
                    this.g = 1;
                    if (fVar2.emit(obj2, this) == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r2.q.z0(obj);
                }
                return q5.x.f13520a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(e eVar, w0 w0Var, v5.c cVar) {
        super(2, cVar);
        this.f17463f = 1;
        this.h = eVar;
        this.f17464i = w0Var;
    }
}
