package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k0 f11475c = new k0(l0.f11478a);

    @Override // f7.a
    public final int e(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.k.e(iArr, "<this>");
        return iArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        j0 builder = (j0) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        int iDecodeIntElement = cVar.decodeIntElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        int[] iArr = builder.f11471a;
        int i8 = builder.f11472b;
        builder.f11472b = i8 + 1;
        iArr[i8] = iDecodeIntElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        int[] iArr = (int[]) obj;
        kotlin.jvm.internal.k.e(iArr, "<this>");
        j0 j0Var = new j0();
        j0Var.f11471a = iArr;
        j0Var.f11472b = iArr.length;
        j0Var.b(10);
        return j0Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new int[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        int[] content = (int[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeIntElement(this.f11464b, i8, content[i8]);
        }
    }
}
