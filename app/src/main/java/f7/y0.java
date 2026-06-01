package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f11546a = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f11547b = x0.f11543a;

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        throw new b7.i("'kotlin.Nothing' does not have instances");
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11547b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        Void value = (Void) obj;
        kotlin.jvm.internal.k.e(value, "value");
        throw new b7.i("'kotlin.Nothing' cannot be serialized");
    }
}
