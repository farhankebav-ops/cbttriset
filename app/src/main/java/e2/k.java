package e2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11238a;

    public k(Object obj) {
        this.f11238a = obj;
    }

    @Override // e2.j
    public final Object a() {
        return this.f11238a;
    }

    @Override // e2.j
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f11238a.equals(((k) obj).f11238a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11238a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f11238a + ")";
    }
}
