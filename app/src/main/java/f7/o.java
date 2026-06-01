package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f11490c = new o(p.f11494a);

    @Override // f7.a
    public final int e(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.k.e(cArr, "<this>");
        return cArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        n builder = (n) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        char cDecodeCharElement = cVar.decodeCharElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        char[] cArr = builder.f11485a;
        int i8 = builder.f11486b;
        builder.f11486b = i8 + 1;
        cArr[i8] = cDecodeCharElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        char[] cArr = (char[]) obj;
        kotlin.jvm.internal.k.e(cArr, "<this>");
        n nVar = new n();
        nVar.f11485a = cArr;
        nVar.f11486b = cArr.length;
        nVar.b(10);
        return nVar;
    }

    @Override // f7.h1
    public final Object l() {
        return new char[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        char[] content = (char[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeCharElement(this.f11464b, i8, content[i8]);
        }
    }
}
