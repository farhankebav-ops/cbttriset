package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f11517c = new t(u.f11523a);

    @Override // f7.a
    public final int e(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.k.e(dArr, "<this>");
        return dArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        s builder = (s) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        double dDecodeDoubleElement = cVar.decodeDoubleElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        double[] dArr = builder.f11511a;
        int i8 = builder.f11512b;
        builder.f11512b = i8 + 1;
        dArr[i8] = dDecodeDoubleElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        double[] dArr = (double[]) obj;
        kotlin.jvm.internal.k.e(dArr, "<this>");
        s sVar = new s();
        sVar.f11511a = dArr;
        sVar.f11512b = dArr.length;
        sVar.b(10);
        return sVar;
    }

    @Override // f7.h1
    public final Object l() {
        return new double[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        double[] content = (double[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeDoubleElement(this.f11464b, i8, content[i8]);
        }
    }
}
