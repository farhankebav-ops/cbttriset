package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x1 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f11544a = new x1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f11545b = c1.a("kotlin.UInt", l0.f11478a);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return new q5.q(decoder.decodeInline(f11545b).decodeInt());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11545b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeInline(f11545b).encodeInt(((q5.q) obj).f13513a);
    }
}
