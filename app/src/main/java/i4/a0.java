package i4;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f11814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f11816d;

    public a0(String str, z zVar, long j, j4.t1 t1Var) {
        this.f11813a = str;
        this.f11814b = zVar;
        this.f11815c = j;
        this.f11816d = t1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Objects.equals(this.f11813a, a0Var.f11813a) && Objects.equals(this.f11814b, a0Var.f11814b) && this.f11815c == a0Var.f11815c && Objects.equals(this.f11816d, a0Var.f11816d);
    }

    public final int hashCode() {
        return Objects.hash(this.f11813a, this.f11814b, Long.valueOf(this.f11815c), null, this.f11816d);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f11813a, "description");
        iVarY.c(this.f11814b, "severity");
        iVarY.d("timestampNanos", this.f11815c);
        iVarY.c(null, "channelRef");
        iVarY.c(this.f11816d, "subchannelRef");
        return iVarY.toString();
    }
}
