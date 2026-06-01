package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13499b;

    public i(Object obj, Object obj2) {
        this.f13498a = obj;
        this.f13499b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.k.a(this.f13498a, iVar.f13498a) && kotlin.jvm.internal.k.a(this.f13499b, iVar.f13499b);
    }

    public final int hashCode() {
        Object obj = this.f13498a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f13499b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f13498a + ", " + this.f13499b + ')';
    }
}
