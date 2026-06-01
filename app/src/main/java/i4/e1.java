package i4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f11855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11856b;

    public e1(Object obj) {
        this.f11856b = obj;
        this.f11855a = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e1.class == obj.getClass()) {
            e1 e1Var = (e1) obj;
            if (Objects.equals(this.f11855a, e1Var.f11855a) && Objects.equals(this.f11856b, e1Var.f11856b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f11855a, this.f11856b);
    }

    public final String toString() {
        Object obj = this.f11856b;
        if (obj != null) {
            e2.i iVarY = a.a.Y(this);
            iVarY.c(obj, "config");
            return iVarY.toString();
        }
        e2.i iVarY2 = a.a.Y(this);
        iVarY2.c(this.f11855a, "error");
        return iVarY2.toString();
    }

    public e1(n1 n1Var) {
        this.f11856b = null;
        r2.q.D(n1Var, "status");
        this.f11855a = n1Var;
        r2.q.w(n1Var, "cannot use OK status: %s", !n1Var.f());
    }
}
