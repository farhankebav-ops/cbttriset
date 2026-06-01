package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p0 f11496c = new p0(q0.f11499a);

    @Override // f7.a
    public final int e(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.k.e(jArr, "<this>");
        return jArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        o0 builder = (o0) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        long jDecodeLongElement = cVar.decodeLongElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        long[] jArr = builder.f11491a;
        int i8 = builder.f11492b;
        builder.f11492b = i8 + 1;
        jArr[i8] = jDecodeLongElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        long[] jArr = (long[]) obj;
        kotlin.jvm.internal.k.e(jArr, "<this>");
        o0 o0Var = new o0();
        o0Var.f11491a = jArr;
        o0Var.f11492b = jArr.length;
        o0Var.b(10);
        return o0Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new long[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        long[] content = (long[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeLongElement(this.f11464b, i8, content[i8]);
        }
    }
}
