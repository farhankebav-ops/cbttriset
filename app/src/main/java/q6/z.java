package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends v5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f13604b = new e1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13605a;

    public z(String str) {
        super(f13604b);
        this.f13605a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z) && kotlin.jvm.internal.k.a(this.f13605a, ((z) obj).f13605a);
    }

    public final int hashCode() {
        return this.f13605a.hashCode();
    }

    public final String toString() {
        return a1.a.e(')', this.f13605a, new StringBuilder("CoroutineName("));
    }
}
