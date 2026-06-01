package f7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i1 implements d7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d7.f f11468b;

    public i1(String str, d7.f kind) {
        kotlin.jvm.internal.k.e(kind, "kind");
        this.f11467a = str;
        this.f11468b = kind;
    }

    @Override // d7.g
    public final boolean b() {
        return false;
    }

    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // d7.g
    public final int d() {
        return 0;
    }

    @Override // d7.g
    public final String e(int i2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return kotlin.jvm.internal.k.a(this.f11467a, i1Var.f11467a) && kotlin.jvm.internal.k.a(this.f11468b, i1Var.f11468b);
    }

    @Override // d7.g
    public final List f(int i2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // d7.g
    public final d7.g g(int i2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // d7.g
    public final List getAnnotations() {
        return r5.r.f13638a;
    }

    @Override // d7.g
    public final a.a getKind() {
        return this.f11468b;
    }

    @Override // d7.g
    public final String h() {
        return this.f11467a;
    }

    public final int hashCode() {
        return (this.f11468b.hashCode() * 31) + this.f11467a.hashCode();
    }

    @Override // d7.g
    public final boolean i(int i2) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // d7.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return a1.a.e(')', this.f11467a, new StringBuilder("PrimitiveDescriptor("));
    }
}
