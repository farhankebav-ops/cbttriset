package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f11523a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11524b = new i1("kotlin.Double", d7.e.e);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return Double.valueOf(decoder.decodeDouble());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11524b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeDouble(((Number) obj).doubleValue());
    }
}
