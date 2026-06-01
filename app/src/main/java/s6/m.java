package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f13751a;

    public m(Throwable th) {
        this.f13751a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return kotlin.jvm.internal.k.a(this.f13751a, ((m) obj).f13751a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f13751a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // s6.n
    public final String toString() {
        return "Closed(" + this.f13751a + ')';
    }
}
