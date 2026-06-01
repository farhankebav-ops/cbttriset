package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e2 implements b7.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2 f11447b = new e2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f11448a = new a1();

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        this.f11448a.deserialize(decoder);
        return q5.x.f13520a;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f11448a.getDescriptor();
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        q5.x value = (q5.x) obj;
        kotlin.jvm.internal.k.e(value, "value");
        this.f11448a.serialize(fVar, value);
    }
}
