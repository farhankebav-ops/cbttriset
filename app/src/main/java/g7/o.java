package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f11619a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7.h f11620b = r2.q.r("kotlinx.serialization.json.JsonElement", d7.c.f11182c, new d7.g[0], new androidx.activity.u(9));

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return r2.q.k(decoder).b();
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11620b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        m value = (m) obj;
        kotlin.jvm.internal.k.e(value, "value");
        r2.q.l(fVar);
        if (value instanceof b0) {
            fVar.encodeSerializableValue(c0.f11601a, value);
        } else if (value instanceof x) {
            fVar.encodeSerializableValue(z.f11632a, value);
        } else {
            if (!(value instanceof e)) {
                throw new e2.s(3);
            }
            fVar.encodeSerializableValue(g.f11607a, value);
        }
    }
}
