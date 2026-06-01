package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f11433a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11434b = new i1("kotlin.Float", d7.e.f11186f);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return Float.valueOf(decoder.decodeFloat());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11434b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeFloat(((Number) obj).floatValue());
    }
}
