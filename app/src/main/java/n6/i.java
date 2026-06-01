package n6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k6.d f13100b;

    public i(String str, k6.d dVar) {
        this.f13099a = str;
        this.f13100b = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.k.a(this.f13099a, iVar.f13099a) && kotlin.jvm.internal.k.a(this.f13100b, iVar.f13100b);
    }

    public final int hashCode() {
        return this.f13100b.hashCode() + (this.f13099a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f13099a + ", range=" + this.f13100b + ')';
    }
}
