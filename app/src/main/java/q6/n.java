package q6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends j1 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f13572f;

    public /* synthetic */ n(l lVar, int i2) {
        this.e = i2;
        this.f13572f = lVar;
    }

    @Override // q6.j1
    public final boolean i() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // q6.j1
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                n1 n1VarH = h();
                l lVar = this.f13572f;
                Throwable thO = lVar.o(n1VarH);
                if (lVar.v()) {
                    v6.f fVar = (v6.f) lVar.f13562d;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v6.f.h;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        e2.f fVar2 = v6.a.f17615c;
                        if (kotlin.jvm.internal.k.a(obj, fVar2)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, fVar2, thO)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != fVar2) {
                                }
                                break;
                            }
                        } else if (!(obj instanceof Throwable)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                                }
                            }
                        }
                    }
                }
                lVar.e(thO);
                if (!lVar.v()) {
                    lVar.m();
                }
                break;
            default:
                this.f13572f.resumeWith(q5.x.f13520a);
                break;
        }
    }
}
