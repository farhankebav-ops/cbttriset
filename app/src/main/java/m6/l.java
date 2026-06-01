package m6;

import e6.p;
import java.util.Iterator;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends x5.h implements p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f12989f;
    public Iterator g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f12990i;
    public final /* synthetic */ q5.i j;
    public final /* synthetic */ c6.i k;
    public final /* synthetic */ p l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(q5.i iVar, c6.i iVar2, p pVar, v5.c cVar) {
        super(2, cVar);
        this.j = iVar;
        this.k = iVar2;
        this.l = pVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        l lVar = new l(this.j, this.k, this.l, cVar);
        lVar.f12990i = obj;
        return lVar;
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((j) obj, (v5.c) obj2)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Iterator it;
        j jVar = (j) this.f12990i;
        w5.a aVar = w5.a.f17774a;
        int i2 = this.h;
        Object obj2 = this.j;
        if (i2 == 0) {
            q.z0(obj);
            this.f12990i = jVar;
            this.h = 1;
            jVar.a(obj2, this);
            return aVar;
        }
        if (i2 == 1) {
            q.z0(obj);
            it = this.k.iterator();
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.g;
            obj2 = this.f12989f;
            q.z0(obj);
        }
        if (!it.hasNext()) {
            return x.f13520a;
        }
        Object objInvoke = this.l.invoke(obj2, it.next());
        this.f12990i = jVar;
        this.f12989f = objInvoke;
        this.g = it;
        this.h = 2;
        jVar.a(objInvoke, this);
        return aVar;
    }
}
