package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends x5.h implements e6.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11778f;
    public /* synthetic */ q5.b g;
    public final /* synthetic */ com.unity3d.scar.adapter.common.a h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(com.unity3d.scar.adapter.common.a aVar, v5.c cVar) {
        super(3, cVar);
        this.h = aVar;
    }

    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        w wVar = new w(this.h, (v5.c) obj3);
        wVar.g = (q5.b) obj;
        return wVar.invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        com.unity3d.scar.adapter.common.a aVar = this.h;
        b0 b0Var = (b0) aVar.f10959c;
        w5.a aVar2 = w5.a.f17774a;
        int i2 = this.f11778f;
        if (i2 == 0) {
            r2.q.z0(obj);
            q5.b bVar = this.g;
            byte bQ = b0Var.q();
            if (bQ == 1) {
                return aVar.g(true);
            }
            if (bQ == 0) {
                return aVar.g(false);
            }
            if (bQ != 6) {
                if (bQ == 8) {
                    return aVar.f();
                }
                b0.m(b0Var, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f11778f = 1;
            obj = com.unity3d.scar.adapter.common.a.a(aVar, bVar, this);
            if (obj == aVar2) {
                return aVar2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
        }
        return (g7.m) obj;
    }
}
