package f7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m0 implements l6.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6.r f11484a;

    public m0(l6.r origin) {
        kotlin.jvm.internal.k.e(origin, "origin");
        this.f11484a = origin;
    }

    @Override // l6.r
    public final boolean b() {
        return this.f11484a.b();
    }

    @Override // l6.r
    public final l6.c c() {
        return this.f11484a.c();
    }

    @Override // l6.r
    public final List d() {
        return this.f11484a.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        m0 m0Var = obj instanceof m0 ? (m0) obj : null;
        l6.r rVar = m0Var != null ? m0Var.f11484a : null;
        l6.r rVar2 = this.f11484a;
        if (!kotlin.jvm.internal.k.a(rVar2, rVar)) {
            return false;
        }
        l6.c cVarC = rVar2.c();
        if (cVarC instanceof l6.c) {
            l6.r rVar3 = obj instanceof l6.r ? (l6.r) obj : null;
            l6.c cVarC2 = rVar3 != null ? rVar3.c() : null;
            if (cVarC2 != null && (cVarC2 instanceof l6.c)) {
                return a.a.B(cVarC).equals(a.a.B(cVarC2));
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11484a.hashCode();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.f11484a;
    }
}
