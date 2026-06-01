package j4;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12553b;

    public x4(String str, Map map) {
        r2.q.D(str, "policyName");
        this.f12552a = str;
        r2.q.D(map, "rawConfigValue");
        this.f12553b = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof x4) {
            x4 x4Var = (x4) obj;
            if (this.f12552a.equals(x4Var.f12552a) && this.f12553b.equals(x4Var.f12553b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f12552a, this.f12553b);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12552a, "policyName");
        iVarY.c(this.f12553b, "rawConfigValue");
        return iVarY.toString();
    }
}
