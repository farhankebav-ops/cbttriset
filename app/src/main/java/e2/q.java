package e2;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class q implements n, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11250a;

    public q(Object obj) {
        this.f11250a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return Objects.equals(this.f11250a, ((q) obj).f11250a);
        }
        return false;
    }

    @Override // e2.n
    public final Object get() {
        return this.f11250a;
    }

    public final int hashCode() {
        return Objects.hash(this.f11250a);
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f11250a + ")";
    }
}
