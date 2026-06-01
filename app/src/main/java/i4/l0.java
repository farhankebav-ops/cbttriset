package i4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11893c;

    public l0(List list, b bVar, Object obj) {
        r2.q.D(list, "addresses");
        this.f11891a = Collections.unmodifiableList(new ArrayList(list));
        r2.q.D(bVar, "attributes");
        this.f11892b = bVar;
        this.f11893c = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return Objects.equals(this.f11891a, l0Var.f11891a) && Objects.equals(this.f11892b, l0Var.f11892b) && Objects.equals(this.f11893c, l0Var.f11893c);
    }

    public final int hashCode() {
        return Objects.hash(this.f11891a, this.f11892b, this.f11893c);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11891a, "addresses");
        iVarY.c(this.f11892b, "attributes");
        iVarY.c(this.f11893c, "loadBalancingPolicyConfig");
        return iVarY.toString();
    }
}
