package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u1 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f11526a = new u1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f11527b = c1.a("kotlin.UByte", j.f11469a);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return new q5.o(decoder.decodeInline(f11527b).decodeByte());
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11527b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        fVar.encodeInline(f11527b).encodeByte(((q5.o) obj).f13511a);
    }
}
