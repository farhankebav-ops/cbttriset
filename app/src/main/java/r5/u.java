package r5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13642b;

    public u(int i2, Object obj) {
        this.f13641a = i2;
        this.f13642b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f13641a == uVar.f13641a && kotlin.jvm.internal.k.a(this.f13642b, uVar.f13642b);
    }

    public final int hashCode() {
        int i2 = this.f13641a * 31;
        Object obj = this.f13642b;
        return i2 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f13641a + ", value=" + this.f13642b + ')';
    }
}
