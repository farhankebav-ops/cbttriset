package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o1 f11493c = new o1(p1.f11497a);

    @Override // f7.a
    public final int e(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.k.e(sArr, "<this>");
        return sArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        n1 builder = (n1) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        short sDecodeShortElement = cVar.decodeShortElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        short[] sArr = builder.f11488a;
        int i8 = builder.f11489b;
        builder.f11489b = i8 + 1;
        sArr[i8] = sDecodeShortElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        short[] sArr = (short[]) obj;
        kotlin.jvm.internal.k.e(sArr, "<this>");
        n1 n1Var = new n1();
        n1Var.f11488a = sArr;
        n1Var.f11489b = sArr.length;
        n1Var.b(10);
        return n1Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new short[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        short[] content = (short[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeShortElement(this.f11464b, i8, content[i8]);
        }
    }
}
