package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f12727a;

    public r(Class jClass) {
        k.e(jClass, "jClass");
        this.f12727a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f12727a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return k.a(this.f12727a, ((r) obj).f12727a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12727a.hashCode();
    }

    public final String toString() {
        return this.f12727a + " (Kotlin reflection is not available)";
    }
}
