package g7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f11597d = new b(new j(false, false, false, true, "    ", "type", true, a.f11595b), i7.h.f12046a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f11598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i7.f f11599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.a f11600c = new a4.a(14);

    public c(j jVar, i7.f fVar) {
        this.f11598a = jVar;
        this.f11599b = fVar;
    }

    public final Object a(b7.b deserializer, String string) {
        kotlin.jvm.internal.k.e(deserializer, "deserializer");
        kotlin.jvm.internal.k.e(string, "string");
        h7.b0 b0Var = new h7.b0(string);
        Object objDecodeSerializableValue = new h7.y(this, h7.d0.f11749c, b0Var, deserializer.getDescriptor(), null).decodeSerializableValue(deserializer);
        if (b0Var.e() == 10) {
            return objDecodeSerializableValue;
        }
        h7.b0.m(b0Var, "Expected EOF after parsing, but had " + string.charAt(b0Var.f11741a - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final String b(b7.j serializer, Object obj) {
        char[] cArr;
        kotlin.jvm.internal.k.e(serializer, "serializer");
        com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a(1);
        h7.d dVar = h7.d.f11748c;
        synchronized (dVar) {
            r5.i iVar = dVar.f11754a;
            cArr = null;
            char[] cArr2 = (char[]) (iVar.isEmpty() ? null : iVar.removeLast());
            if (cArr2 != null) {
                dVar.f11755b -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        aVar.f10959c = cArr;
        try {
            new h7.z(new h7.g(aVar), this, h7.d0.f11749c, new p[h7.d0.h.size()]).encodeSerializableValue(serializer, obj);
            return aVar.toString();
        } finally {
            aVar.h();
        }
    }
}
