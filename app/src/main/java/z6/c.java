package z6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q5.x;
import q6.c0;
import q6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends g implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c(boolean z2) {
        super(z2 ? 1 : 0);
        this.owner$volatile = z2 ? null : d.f17992a;
    }

    public final boolean c() {
        return Math.max(g.f17998f.get(this), 0) == 0;
    }

    public final Object d(x5.c cVar) {
        boolean zE = e(null);
        x xVar = x.f13520a;
        if (!zE) {
            l lVarQ = c0.q(a.a.I(cVar));
            try {
                a(new b(this, lVarQ));
                Object objP = lVarQ.p();
                w5.a aVar = w5.a.f17774a;
                if (objP != aVar) {
                    objP = xVar;
                }
                if (objP == aVar) {
                    return objP;
                }
            } catch (Throwable th) {
                lVarQ.y();
                throw th;
            }
        }
        return xVar;
    }

    public final boolean e(Object obj) {
        int i2;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g.f17998f;
            int i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 > 1) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1));
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
                if (i8 <= 0) {
                    if (obj == null) {
                        return false;
                    }
                    while (c()) {
                        Object obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 != d.f17992a) {
                            if (obj2 != obj) {
                                return false;
                            }
                            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
                        }
                    }
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i8, i8 - 1)) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    return true;
                }
            }
        }
    }

    public final void f(Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            e2.f fVar = d.f17992a;
            if (obj2 != fVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, fVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        return "Mutex@" + c0.p(this) + "[isLocked=" + c() + ",owner=" + g.get(this) + ']';
    }
}
