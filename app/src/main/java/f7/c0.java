package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f11426c = new c0(d0.f11433a);

    @Override // f7.a
    public final int e(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.k.e(fArr, "<this>");
        return fArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        b0 builder = (b0) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        float fDecodeFloatElement = cVar.decodeFloatElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        float[] fArr = builder.f11420a;
        int i8 = builder.f11421b;
        builder.f11421b = i8 + 1;
        fArr[i8] = fDecodeFloatElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        float[] fArr = (float[]) obj;
        kotlin.jvm.internal.k.e(fArr, "<this>");
        b0 b0Var = new b0();
        b0Var.f11420a = fArr;
        b0Var.f11421b = fArr.length;
        b0Var.b(10);
        return b0Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new float[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        float[] content = (float[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeFloatElement(this.f11464b, i8, content[i8]);
        }
    }
}
