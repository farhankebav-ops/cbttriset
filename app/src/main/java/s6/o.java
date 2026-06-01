package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f13752b = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13753a;

    public static final Throwable a(Object obj) {
        m mVar = obj instanceof m ? (m) obj : null;
        if (mVar != null) {
            return mVar.f13751a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return kotlin.jvm.internal.k.a(this.f13753a, ((o) obj).f13753a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f13753a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f13753a;
        if (obj instanceof m) {
            return ((m) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
