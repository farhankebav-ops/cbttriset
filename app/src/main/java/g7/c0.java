package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f11601a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d7.h f11602b = r2.q.s("kotlinx.serialization.json.JsonPrimitive", d7.e.j, new d7.g[0]);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        m mVarB = r2.q.k(decoder).b();
        if (mVarB instanceof b0) {
            return (b0) mVarB;
        }
        throw h7.o.d("Unexpected JSON element, expected JsonPrimitive, had " + kotlin.jvm.internal.b0.a(mVarB.getClass()), mVarB.toString(), -1);
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11602b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        b0 value = (b0) obj;
        kotlin.jvm.internal.k.e(value, "value");
        r2.q.l(fVar);
        if (value instanceof u) {
            fVar.encodeSerializableValue(v.f11626a, u.INSTANCE);
        } else {
            fVar.encodeSerializableValue(s.f11624a, (r) value);
        }
    }
}
