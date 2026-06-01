package f7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n0 implements d7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d7.g f11487a;

    public n0(d7.g gVar) {
        this.f11487a = gVar;
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
        throw new IllegalArgumentException(name.concat(" is not a valid list index"));
    }

    @Override // d7.g
    public final int d() {
        return 1;
    }

    @Override // d7.g
    public final String e(int i2) {
        return String.valueOf(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return kotlin.jvm.internal.k.a(this.f11487a, n0Var.f11487a) && kotlin.jvm.internal.k.a(h(), n0Var.h());
    }

    @Override // d7.g
    public final List f(int i2) {
        if (i2 >= 0) {
            return r5.r.f13638a;
        }
        StringBuilder sbV = a1.a.v(i2, "Illegal index ", ", ");
        sbV.append(h());
        sbV.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbV.toString().toString());
    }

    @Override // d7.g
    public final d7.g g(int i2) {
        if (i2 >= 0) {
            return this.f11487a;
        }
        StringBuilder sbV = a1.a.v(i2, "Illegal index ", ", ");
        sbV.append(h());
        sbV.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbV.toString().toString());
    }

    @Override // d7.g
    public final List getAnnotations() {
        return r5.r.f13638a;
    }

    @Override // d7.g
    public final a.a getKind() {
        return d7.m.f11202c;
    }

    public final int hashCode() {
        return h().hashCode() + (this.f11487a.hashCode() * 31);
    }

    @Override // d7.g
    public final boolean i(int i2) {
        if (i2 >= 0) {
            return false;
        }
        StringBuilder sbV = a1.a.v(i2, "Illegal index ", ", ");
        sbV.append(h());
        sbV.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbV.toString().toString());
    }

    @Override // d7.g
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return h() + '(' + this.f11487a + ')';
    }
}
