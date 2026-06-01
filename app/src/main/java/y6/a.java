package y6;

import e6.q;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import q5.x;
import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a extends j implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17852b = new a(3, b.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        b bVar = (b) obj;
        f fVar = (f) obj2;
        long j = bVar.f17853a;
        x xVar = x.f13520a;
        if (j <= 0) {
            ((e) fVar).e = xVar;
            return xVar;
        }
        com.unity3d.scar.adapter.common.i iVar = new com.unity3d.scar.adapter.common.i(7, fVar, bVar, false);
        k.c(fVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        e eVar = (e) fVar;
        v5.h hVar = eVar.f17863a;
        eVar.f17865c = c0.o(hVar).e(j, iVar, hVar);
        return xVar;
    }
}
