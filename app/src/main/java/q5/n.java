package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13510c;

    public n(Object obj, Object obj2, Object obj3) {
        this.f13508a = obj;
        this.f13509b = obj2;
        this.f13510c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.k.a(this.f13508a, nVar.f13508a) && kotlin.jvm.internal.k.a(this.f13509b, nVar.f13509b) && kotlin.jvm.internal.k.a(this.f13510c, nVar.f13510c);
    }

    public final int hashCode() {
        Object obj = this.f13508a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f13509b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f13510c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f13508a + ", " + this.f13509b + ", " + this.f13510c + ')';
    }
}
