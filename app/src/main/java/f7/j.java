package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11469a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11470b = new i1("kotlin.Byte", d7.e.f11184c);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return Byte.valueOf(decoder.decodeByte());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11470b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeByte(((Number) obj).byteValue());
    }
}
