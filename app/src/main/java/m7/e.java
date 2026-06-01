package m7;

import e6.p;
import java.util.Iterator;
import l7.g0;
import l7.t;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends x5.h implements p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r5.i f13005f;
    public Iterator g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f13006i;
    public final /* synthetic */ g0 j;
    public final /* synthetic */ t k;
    public final /* synthetic */ boolean l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g0 g0Var, t tVar, boolean z2, v5.c cVar) {
        super(2, cVar);
        this.j = g0Var;
        this.k = tVar;
        this.l = z2;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        e eVar = new e(this.j, this.k, this.l, cVar);
        eVar.f13006i = obj;
        return eVar;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((m6.j) obj, (v5.c) obj2)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        r5.i iVar;
        Iterator it;
        m6.j jVar;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.h;
        t tVar = this.k;
        if (i2 == 0) {
            q.z0(obj);
            m6.j jVar2 = (m6.j) this.f13006i;
            r5.i iVar2 = new r5.i();
            g0 g0Var = this.j;
            iVar2.addLast(g0Var);
            iVar = iVar2;
            it = tVar.list(g0Var).iterator();
            jVar = jVar2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.g;
            r5.i iVar3 = this.f13005f;
            m6.j jVar3 = (m6.j) this.f13006i;
            q.z0(obj);
            iVar = iVar3;
            jVar = jVar3;
        }
        while (it.hasNext()) {
            g0 g0Var2 = (g0) it.next();
            this.f13006i = jVar;
            this.f13005f = iVar;
            this.g = it;
            this.h = 1;
            if (b.c(jVar, tVar, iVar, g0Var2, this.l, false, this) == aVar) {
                return aVar;
            }
        }
        return x.f13520a;
    }
}
