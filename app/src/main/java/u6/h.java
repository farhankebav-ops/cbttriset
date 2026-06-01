package u6;

import java.util.concurrent.atomic.AtomicInteger;
import q5.x;
import q6.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends x5.i implements e6.p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17550f;
    public final /* synthetic */ t6.e[] g;
    public final /* synthetic */ int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f17551i;
    public final /* synthetic */ s6.h j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(t6.e[] eVarArr, int i2, AtomicInteger atomicInteger, s6.h hVar, v5.c cVar) {
        super(2, cVar);
        this.g = eVarArr;
        this.h = i2;
        this.f17551i = atomicInteger;
        this.j = hVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        return new h(this.g, this.h, this.f17551i, this.j, cVar);
    }

    @Override // e6.p
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((a0) obj, (v5.c) obj2)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.f17550f;
        AtomicInteger atomicInteger = this.f17551i;
        s6.h hVar = this.j;
        try {
            if (i2 == 0) {
                r2.q.z0(obj);
                t6.e[] eVarArr = this.g;
                int i8 = this.h;
                t6.e eVar = eVarArr[i8];
                g gVar = new g(hVar, i8);
                this.f17550f = 1;
                if (eVar.collect(gVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r2.q.z0(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                hVar.o(null);
            }
            return x.f13520a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                hVar.o(null);
            }
        }
    }
}
