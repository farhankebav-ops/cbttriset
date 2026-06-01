package s6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class e extends kotlin.jvm.internal.j implements e6.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f13727b = new e(3, h.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        h hVar = (h) obj;
        AtomicLongFieldUpdater atomicLongFieldUpdater = h.f13730b;
        hVar.getClass();
        if (obj3 == j.l) {
            obj3 = new m(hVar.r());
        }
        return new o(obj3);
    }
}
