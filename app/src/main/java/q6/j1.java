package q6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class j1 extends v6.j implements o0, b1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n1 f13556d;

    @Override // q6.b1
    public final p1 b() {
        return null;
    }

    @Override // q6.o0
    public final void dispose() {
        n1 n1VarH = h();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n1.f13574a;
            Object obj = atomicReferenceFieldUpdater.get(n1VarH);
            if (obj instanceof j1) {
                if (obj != this) {
                    return;
                }
                q0 q0Var = c0.j;
                while (!atomicReferenceFieldUpdater.compareAndSet(n1VarH, obj, q0Var)) {
                    if (atomicReferenceFieldUpdater.get(n1VarH) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof b1) || ((b1) obj).b() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = v6.j.f17631a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof v6.p) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                v6.j jVar = (v6.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = v6.j.f17633c;
                v6.p pVar = (v6.p) atomicReferenceFieldUpdater3.get(jVar);
                if (pVar == null) {
                    pVar = new v6.p(jVar);
                    atomicReferenceFieldUpdater3.set(jVar, pVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, pVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar.d();
                return;
            }
        }
    }

    public f1 getParent() {
        return h();
    }

    public final n1 h() {
        n1 n1Var = this.f13556d;
        if (n1Var != null) {
            return n1Var;
        }
        kotlin.jvm.internal.k.l("job");
        throw null;
    }

    public abstract boolean i();

    @Override // q6.b1
    public final boolean isActive() {
        return true;
    }

    public abstract void j(Throwable th);

    @Override // v6.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + c0.p(this) + "[job@" + c0.p(h()) + ']';
    }
}
