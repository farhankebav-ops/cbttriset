package i4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k0 {
    public static final k0 e = new k0(null, null, n1.e, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f11884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f11885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n1 f11886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11887d;

    public k0(f fVar, h hVar, n1 n1Var, boolean z2) {
        this.f11884a = fVar;
        this.f11885b = hVar;
        r2.q.D(n1Var, "status");
        this.f11886c = n1Var;
        this.f11887d = z2;
    }

    public static k0 a(n1 n1Var) {
        r2.q.y(!n1Var.f(), "error status shouldn't be OK");
        return new k0(null, null, n1Var, false);
    }

    public static k0 b(f fVar, q4.r rVar) {
        r2.q.D(fVar, "subchannel");
        return new k0(fVar, rVar, n1.e, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return Objects.equals(this.f11884a, k0Var.f11884a) && Objects.equals(this.f11886c, k0Var.f11886c) && Objects.equals(this.f11885b, k0Var.f11885b) && this.f11887d == k0Var.f11887d;
    }

    public final int hashCode() {
        return Objects.hash(this.f11884a, this.f11886c, this.f11885b, Boolean.valueOf(this.f11887d));
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11884a, "subchannel");
        iVarY.c(this.f11885b, "streamTracerFactory");
        iVarY.c(this.f11886c, "status");
        iVarY.e("drop", this.f11887d);
        return iVarY.toString();
    }
}
