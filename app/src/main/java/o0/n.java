package o0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13157a;

    public n(ArrayList arrayList) {
        this.f13157a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        return this.f13157a.equals(((n) ((y) obj)).f13157a);
    }

    public final int hashCode() {
        return this.f13157a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f13157a + "}";
    }
}
