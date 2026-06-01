package j2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12070b = AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12071c = AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12072d = AtomicReferenceFieldUpdater.newUpdater(m.class, l.class, "c");
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(m.class, d.class, "b");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12073f = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "a");

    @Override // a.a
    public final void Q(l lVar, l lVar2) {
        f12071c.lazySet(lVar, lVar2);
    }

    @Override // a.a
    public final void R(l lVar, Thread thread) {
        f12070b.lazySet(lVar, thread);
    }

    @Override // a.a
    public final boolean k(p4.a aVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = e;
            if (atomicReferenceFieldUpdater.compareAndSet(aVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(aVar) == dVar);
        return false;
    }

    @Override // a.a
    public final boolean l(m mVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f12073f;
            if (atomicReferenceFieldUpdater.compareAndSet(mVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(mVar) == obj);
        return false;
    }

    @Override // a.a
    public final boolean m(m mVar, l lVar, l lVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f12072d;
            if (atomicReferenceFieldUpdater.compareAndSet(mVar, lVar, lVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(mVar) == lVar);
        return false;
    }

    @Override // a.a
    public final d y(p4.a aVar) {
        return (d) e.getAndSet(aVar, d.f12066d);
    }

    @Override // a.a
    public final l z(p4.a aVar) {
        return (l) f12072d.getAndSet(aVar, l.f12078c);
    }
}
