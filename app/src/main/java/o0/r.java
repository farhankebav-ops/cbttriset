package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f13162a;

    public r(Integer num) {
        this.f13162a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        Integer num = this.f13162a;
        r rVar = (r) ((e0) obj);
        return num == null ? rVar.f13162a == null : num.equals(rVar.f13162a);
    }

    public final int hashCode() {
        Integer num = this.f13162a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f13162a + "}";
    }
}
