package b7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends f7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6.c f4152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4153b;

    public f(l6.c baseClass) {
        kotlin.jvm.internal.k.e(baseClass, "baseClass");
        this.f4152a = baseClass;
        this.f4153b = n7.b.B(q5.g.f13495b, new androidx.activity.result.b(this, 4));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, q5.f] */
    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return (d7.g) this.f4153b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f4152a + ')';
    }
}
