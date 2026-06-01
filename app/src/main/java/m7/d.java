package m7;

import e6.p;
import l7.g0;
import l7.t;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends x5.h implements p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13003f;
    public /* synthetic */ Object g;
    public final /* synthetic */ t h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g0 f13004i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(t tVar, g0 g0Var, v5.c cVar) {
        super(2, cVar);
        this.h = tVar;
        this.f13004i = g0Var;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        d dVar = new d(this.h, this.f13004i, cVar);
        dVar.g = obj;
        return dVar;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((m6.j) obj, (v5.c) obj2)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.f13003f;
        if (i2 == 0) {
            q.z0(obj);
            m6.j jVar = (m6.j) this.g;
            r5.i iVar = new r5.i();
            this.f13003f = 1;
            if (b.c(jVar, this.h, iVar, this.f13004i, false, true, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
        }
        return x.f13520a;
    }
}
