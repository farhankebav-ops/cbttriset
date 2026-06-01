package q6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d1 extends j1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13542f = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final i1 e;

    public d1(i1 i1Var) {
        this.e = i1Var;
    }

    @Override // q6.j1
    public final boolean i() {
        return true;
    }

    @Override // q6.j1
    public final void j(Throwable th) {
        if (f13542f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
