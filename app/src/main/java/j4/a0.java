package j4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i4.b f12100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i4.y f12101c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f12099a.equals(a0Var.f12099a) && this.f12100b.equals(a0Var.f12100b) && Objects.equals(this.f12101c, a0Var.f12101c);
    }

    public final int hashCode() {
        return Objects.hash(this.f12099a, this.f12100b, null, this.f12101c);
    }
}
