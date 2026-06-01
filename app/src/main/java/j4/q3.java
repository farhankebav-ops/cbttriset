package j4;

import com.ironsource.C2300e4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.d f12399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.a1 f12400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.c1 f12401c;

    public q3(i4.c1 c1Var, i4.a1 a1Var, i4.d dVar) {
        r2.q.D(c1Var, "method");
        this.f12401c = c1Var;
        r2.q.D(a1Var, "headers");
        this.f12400b = a1Var;
        r2.q.D(dVar, "callOptions");
        this.f12399a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q3.class == obj.getClass()) {
            q3 q3Var = (q3) obj;
            if (Objects.equals(this.f12399a, q3Var.f12399a) && Objects.equals(this.f12400b, q3Var.f12400b) && Objects.equals(this.f12401c, q3Var.f12401c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f12399a, this.f12400b, this.f12401c);
    }

    public final String toString() {
        return "[method=" + this.f12401c + " headers=" + this.f12400b + " callOptions=" + this.f12399a + C2300e4.i.e;
    }
}
