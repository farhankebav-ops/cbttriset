package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f11449c = new f(g.f11455a);

    @Override // f7.a
    public final int e(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.k.e(zArr, "<this>");
        return zArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        e builder = (e) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        boolean zDecodeBooleanElement = cVar.decodeBooleanElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        boolean[] zArr = builder.f11439a;
        int i8 = builder.f11440b;
        builder.f11440b = i8 + 1;
        zArr[i8] = zDecodeBooleanElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        kotlin.jvm.internal.k.e(zArr, "<this>");
        e eVar = new e();
        eVar.f11439a = zArr;
        eVar.f11440b = zArr.length;
        eVar.b(10);
        return eVar;
    }

    @Override // f7.h1
    public final Object l() {
        return new boolean[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        boolean[] content = (boolean[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeBooleanElement(this.f11464b, i8, content[i8]);
        }
    }
}
