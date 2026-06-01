package q6;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends j1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;
    public final l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o0 f13531f;
    public final /* synthetic */ e g;

    public c(e eVar, l lVar) {
        this.g = eVar;
        this.e = lVar;
    }

    @Override // q6.j1
    public final boolean i() {
        return false;
    }

    @Override // q6.j1
    public final void j(Throwable th) {
        l lVar = this.e;
        if (th != null) {
            lVar.getClass();
            e2.f fVarD = lVar.D(new u(false, th), null);
            if (fVarD != null) {
                lVar.q(fVarD);
                d dVar = (d) h.get(this);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f13543b;
        e eVar = this.g;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            f0[] f0VarArr = eVar.f13544a;
            ArrayList arrayList = new ArrayList(f0VarArr.length);
            for (f0 f0Var : f0VarArr) {
                arrayList.add(f0Var.b());
            }
            lVar.resumeWith(arrayList);
        }
    }
}
