package g7;

import f7.a2;
import f7.i1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f11624a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11625b = r2.q.e("kotlinx.serialization.json.JsonLiteral", d7.e.j);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        m mVarB = r2.q.k(decoder).b();
        if (mVarB instanceof r) {
            return (r) mVarB;
        }
        throw h7.o.d("Unexpected JSON element, expected JsonLiteral, had " + kotlin.jvm.internal.b0.a(mVarB.getClass()), mVarB.toString(), -1);
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11625b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        r value = (r) obj;
        kotlin.jvm.internal.k.e(value, "value");
        String str = value.f11623c;
        r2.q.l(fVar);
        if (value.f11621a) {
            fVar.encodeString(str);
            return;
        }
        d7.g gVar = value.f11622b;
        if (gVar != null) {
            fVar.encodeInline(gVar).encodeString(str);
            return;
        }
        Long lP0 = n6.t.p0(str);
        if (lP0 != null) {
            fVar.encodeLong(lP0.longValue());
            return;
        }
        q5.s sVarT = n7.b.T(str);
        if (sVarT != null) {
            fVar.encodeInline(a2.f11419b).encodeLong(sVarT.f13515a);
            return;
        }
        Boolean bool = null;
        Double dValueOf = n6.s.d0(str) ? Double.valueOf(Double.parseDouble(str)) : null;
        if (dValueOf != null) {
            fVar.encodeDouble(dValueOf.doubleValue());
            return;
        }
        if (str.equals(com.ironsource.mediationsdk.metadata.a.g)) {
            bool = Boolean.TRUE;
        } else if (str.equals("false")) {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            fVar.encodeBoolean(bool.booleanValue());
        } else {
            fVar.encodeString(str);
        }
    }
}
