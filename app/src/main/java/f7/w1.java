package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w1 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w1 f11538c = new w1(x1.f11544a);

    @Override // f7.a
    public final int e(Object obj) {
        int[] collectionSize = ((q5.r) obj).f13514a;
        kotlin.jvm.internal.k.e(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        v1 builder = (v1) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        int iDecodeInt = cVar.decodeInlineElement(this.f11464b, i2).decodeInt();
        builder.b(builder.d() + 1);
        int[] iArr = builder.f11530a;
        int i8 = builder.f11531b;
        builder.f11531b = i8 + 1;
        iArr[i8] = iDecodeInt;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        int[] toBuilder = ((q5.r) obj).f13514a;
        kotlin.jvm.internal.k.e(toBuilder, "$this$toBuilder");
        v1 v1Var = new v1();
        v1Var.f11530a = toBuilder;
        v1Var.f11531b = toBuilder.length;
        v1Var.b(10);
        return v1Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new q5.r(new int[0]);
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        int[] iArr = ((q5.r) obj).f13514a;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeInlineElement(this.f11464b, i8).encodeInt(iArr[i8]);
        }
    }
}
