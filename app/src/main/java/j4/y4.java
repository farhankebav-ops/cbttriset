package j4;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.p0 f12558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12559b;

    public y4(i4.p0 p0Var, Object obj) {
        this.f12558a = p0Var;
        this.f12559b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && y4.class == obj.getClass()) {
            y4 y4Var = (y4) obj;
            if (Objects.equals(this.f12558a, y4Var.f12558a) && Objects.equals(this.f12559b, y4Var.f12559b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f12558a, this.f12559b);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12558a, IronSourceConstants.EVENTS_PROVIDER);
        iVarY.c(this.f12559b, "config");
        return iVarY.toString();
    }
}
