package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d2 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f11437a = new d2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f11438b = c1.a("kotlin.UShort", p1.f11497a);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return new q5.v(decoder.decodeInline(f11438b).decodeShort());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11438b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeInline(f11438b).encodeShort(((q5.v) obj).f13518a);
    }
}
