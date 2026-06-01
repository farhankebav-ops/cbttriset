package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f13500a;

    public j(Throwable exception) {
        kotlin.jvm.internal.k.e(exception, "exception");
        this.f13500a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.k.a(this.f13500a, ((j) obj).f13500a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13500a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f13500a + ')';
    }
}
