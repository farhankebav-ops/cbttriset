package f7;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 implements Map.Entry, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11514b;

    public s0(Object obj, Object obj2) {
        this.f11513a = obj;
        this.f11514b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return kotlin.jvm.internal.k.a(this.f11513a, s0Var.f11513a) && kotlin.jvm.internal.k.a(this.f11514b, s0Var.f11514b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11513a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11514b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f11513a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f11514b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "MapEntry(key=" + this.f11513a + ", value=" + this.f11514b + ')';
    }
}
