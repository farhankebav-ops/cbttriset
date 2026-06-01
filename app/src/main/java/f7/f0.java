package f7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements d7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d7.g f11451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d7.g f11452c;

    public f0(String str, d7.g gVar, d7.g gVar2) {
        this.f11450a = str;
        this.f11451b = gVar;
        this.f11452c = gVar2;
    }

    @Override // d7.g
    public final boolean b() {
        return false;
    }

    @Override // d7.g
    public final int c(String name) {
        kotlin.jvm.internal.k.e(name, "name");
        Integer numO0 = n6.t.o0(name);
        if (numO0 != null) {
            return numO0.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid map index"));
    }

    @Override // d7.g
    public final int d() {
        return 2;
    }

    @Override // d7.g
    public final String e(int i2) {
        return String.valueOf(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return kotlin.jvm.internal.k.a(this.f11450a, f0Var.f11450a) && kotlin.jvm.internal.k.a(this.f11451b, f0Var.f11451b) && kotlin.jvm.internal.k.a(this.f11452c, f0Var.f11452c);
    }

    @Override // d7.g
    public final List f(int i2) {
        if (i2 >= 0) {
            return r5.r.f13638a;
        }
        throw new IllegalArgumentException(a1.a.r(a1.a.v(i2, "Illegal index ", ", "), this.f11450a, " expects only non-negative indices").toString());
    }

    @Override // d7.g
    public final d7.g g(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.r(a1.a.v(i2, "Illegal index ", ", "), this.f11450a, " expects only non-negative indices").toString());
        }
        int i8 = i2 % 2;
        if (i8 == 0) {
            return this.f11451b;
        }
        if (i8 == 1) {
            return this.f11452c;
        }
        throw new IllegalStateException("Unreached");
    }

    @Override // d7.g
    public final List getAnnotations() {
        return r5.r.f13638a;
    }

    @Override // d7.g
    public final a.a getKind() {
        return d7.m.f11203d;
    }

    @Override // d7.g
    public final String h() {
        return this.f11450a;
    }

    public final int hashCode() {
        return this.f11452c.hashCode() + ((this.f11451b.hashCode() + (this.f11450a.hashCode() * 31)) * 31);
    }

    @Override // d7.g
    public final boolean i(int i2) {
        if (i2 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(a1.a.r(a1.a.v(i2, "Illegal index ", ", "), this.f11450a, " expects only non-negative indices").toString());
    }

    @Override // d7.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return this.f11450a + '(' + this.f11451b + ", " + this.f11452c + ')';
    }
}
