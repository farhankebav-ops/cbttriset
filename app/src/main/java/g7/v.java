package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11626a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7.h f11627b = r2.q.s("kotlinx.serialization.json.JsonNull", d7.l.f11200b, new d7.g[0]);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        r2.q.k(decoder);
        if (decoder.decodeNotNullMark()) {
            throw new h7.k("Expected 'null' literal");
        }
        decoder.decodeNull();
        return u.INSTANCE;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11627b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        u value = (u) obj;
        kotlin.jvm.internal.k.e(value, "value");
        r2.q.l(fVar);
        fVar.encodeNull();
    }
}
