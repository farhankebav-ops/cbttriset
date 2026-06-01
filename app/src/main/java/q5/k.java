package q5;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13501a;

    public static final Throwable a(Object obj) {
        if (obj instanceof j) {
            return ((j) obj).f13500a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return kotlin.jvm.internal.k.a(this.f13501a, ((k) obj).f13501a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f13501a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f13501a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
