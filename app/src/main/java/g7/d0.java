package g7;

import f7.g0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d0 implements b7.c {
    private final b7.c tSerializer;

    public d0(g0 g0Var) {
        this.tSerializer = g0Var;
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        e7.e qVar;
        kotlin.jvm.internal.k.e(decoder, "decoder");
        k kVarK = r2.q.k(decoder);
        m mVarB = kVarK.b();
        c cVarA = kVarK.a();
        b7.c deserializer = this.tSerializer;
        m element = transformDeserialize(mVarB);
        cVarA.getClass();
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        kotlin.jvm.internal.k.e(element, "element");
        String str = null;
        if (element instanceof x) {
            qVar = new h7.s(cVarA, (x) element, str, 12);
        } else if (element instanceof e) {
            qVar = new h7.t(cVarA, (e) element);
        } else {
            if (!(element instanceof r) && !element.equals(u.INSTANCE)) {
                throw new e2.s(3);
            }
            qVar = new h7.q(cVarA, (b0) element, null);
        }
        return qVar.decodeSerializableValue(deserializer);
    }

    @Override // b7.j, b7.b
    public d7.g getDescriptor() {
        return this.tSerializer.getDescriptor();
    }

    @Override // b7.j
    public final void serialize(e7.f encoder, Object value) {
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(value, "value");
        p pVarL = r2.q.l(encoder);
        c json = pVarL.a();
        b7.c serializer = this.tSerializer;
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.e(serializer, "serializer");
        kotlin.jvm.internal.a0 a0Var = new kotlin.jvm.internal.a0();
        new h7.r(json, new androidx.camera.core.impl.utils.a(a0Var, 11), 1).encodeSerializableValue(serializer, value);
        Object obj = a0Var.f12717a;
        if (obj != null) {
            pVarL.b(transformSerialize((m) obj));
        } else {
            kotlin.jvm.internal.k.l("result");
            throw null;
        }
    }

    public abstract m transformDeserialize(m mVar);

    public m transformSerialize(m element) {
        kotlin.jvm.internal.k.e(element, "element");
        return element;
    }
}
