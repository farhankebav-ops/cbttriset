package k6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends b implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f12716d = new d(1, 0, 1);

    @Override // k6.b
    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f12709a == dVar.f12709a && this.f12710b == dVar.f12710b;
    }

    @Override // k6.a
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.f12710b);
    }

    @Override // k6.a
    public final Comparable getStart() {
        return Integer.valueOf(this.f12709a);
    }

    @Override // k6.b
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f12709a * 31) + this.f12710b;
    }

    @Override // k6.b
    public final boolean isEmpty() {
        return this.f12709a > this.f12710b;
    }

    @Override // k6.b
    public final String toString() {
        return this.f12709a + ".." + this.f12710b;
    }
}
