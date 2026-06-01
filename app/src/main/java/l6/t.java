package l6;

import androidx.webkit.ProxyConfig;
import kotlin.jvm.internal.f0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f12828c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f12829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f12830b;

    static {
        new t(null, null);
    }

    public t(u uVar, f0 f0Var) {
        String str;
        this.f12829a = uVar;
        this.f12830b = f0Var;
        if ((uVar == null) == (f0Var == null)) {
            return;
        }
        if (uVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + uVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f12829a == tVar.f12829a && kotlin.jvm.internal.k.a(this.f12830b, tVar.f12830b);
    }

    public final int hashCode() {
        u uVar = this.f12829a;
        int iHashCode = (uVar == null ? 0 : uVar.hashCode()) * 31;
        r rVar = this.f12830b;
        return iHashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    public final String toString() {
        u uVar = this.f12829a;
        int i2 = uVar == null ? -1 : s.f12827a[uVar.ordinal()];
        if (i2 == -1) {
            return ProxyConfig.MATCH_ALL_SCHEMES;
        }
        r rVar = this.f12830b;
        if (i2 == 1) {
            return String.valueOf(rVar);
        }
        if (i2 == 2) {
            return "in " + rVar;
        }
        if (i2 != 3) {
            throw new e2.s(3);
        }
        return "out " + rVar;
    }
}
