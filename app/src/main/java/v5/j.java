package v5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements c, x5.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17611b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f17612a;
    private volatile Object result;

    public j(c cVar) {
        w5.a aVar = w5.a.f17775b;
        this.f17612a = cVar;
        this.result = aVar;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        w5.a aVar = w5.a.f17775b;
        if (obj == aVar) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17611b;
            w5.a aVar2 = w5.a.f17774a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, aVar2)) {
                if (atomicReferenceFieldUpdater.get(this) != aVar) {
                    obj = this.result;
                }
            }
            return w5.a.f17774a;
        }
        if (obj == w5.a.f17776c) {
            return w5.a.f17774a;
        }
        if (obj instanceof q5.j) {
            throw ((q5.j) obj).f13500a;
        }
        return obj;
    }

    @Override // x5.d
    public final x5.d getCallerFrame() {
        c cVar = this.f17612a;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // v5.c
    public final h getContext() {
        return this.f17612a.getContext();
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            w5.a aVar = w5.a.f17775b;
            if (obj2 == aVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17611b;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != aVar) {
                        break;
                    }
                }
                return;
            }
            w5.a aVar2 = w5.a.f17774a;
            if (obj2 != aVar2) {
                throw new IllegalStateException("Already resumed");
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f17611b;
            w5.a aVar3 = w5.a.f17776c;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, aVar2, aVar3)) {
                if (atomicReferenceFieldUpdater2.get(this) != aVar2) {
                    break;
                }
            }
            this.f17612a.resumeWith(obj);
            return;
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.f17612a;
    }
}
