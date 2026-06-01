package i4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e1 f11862c;

    public f1(List list, b bVar, e1 e1Var) {
        this.f11860a = Collections.unmodifiableList(new ArrayList(list));
        r2.q.D(bVar, "attributes");
        this.f11861b = bVar;
        this.f11862c = e1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return Objects.equals(this.f11860a, f1Var.f11860a) && Objects.equals(this.f11861b, f1Var.f11861b) && Objects.equals(this.f11862c, f1Var.f11862c);
    }

    public final int hashCode() {
        return Objects.hash(this.f11860a, this.f11861b, this.f11862c);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11860a, "addresses");
        iVarY.c(this.f11861b, "attributes");
        iVarY.c(this.f11862c, "serviceConfig");
        return iVarY.toString();
    }
}
