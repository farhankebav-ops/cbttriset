package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q0 implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13578a;

    public q0(boolean z2) {
        this.f13578a = z2;
    }

    @Override // q6.b1
    public final p1 b() {
        return null;
    }

    @Override // q6.b1
    public final boolean isActive() {
        return this.f13578a;
    }

    public final String toString() {
        return a1.a.e('}', this.f13578a ? "Active" : "New", new StringBuilder("Empty{"));
    }
}
