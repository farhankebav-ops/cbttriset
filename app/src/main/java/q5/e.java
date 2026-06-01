package q5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f13492b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13493a = 131584;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e other = (e) obj;
        kotlin.jvm.internal.k.e(other, "other");
        return this.f13493a - other.f13493a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f13493a == eVar.f13493a;
    }

    public final int hashCode() {
        return this.f13493a;
    }

    public final String toString() {
        return "2.2.0";
    }
}
