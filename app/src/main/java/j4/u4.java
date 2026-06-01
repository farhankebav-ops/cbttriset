package j4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u4 extends z4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicIntegerFieldUpdater f12492c;

    public u4(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.f12492c = atomicIntegerFieldUpdater;
    }

    @Override // j4.z4
    public final boolean p(w4 w4Var) {
        return this.f12492c.compareAndSet(w4Var, 0, -1);
    }

    @Override // j4.z4
    public final void q(w4 w4Var) {
        this.f12492c.set(w4Var, 0);
    }
}
