package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z1 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z1 f11555c = new z1(a2.f11418a);

    @Override // f7.a
    public final int e(Object obj) {
        long[] collectionSize = ((q5.t) obj).f13516a;
        kotlin.jvm.internal.k.e(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        y1 builder = (y1) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        long jDecodeLong = cVar.decodeInlineElement(this.f11464b, i2).decodeLong();
        builder.b(builder.d() + 1);
        long[] jArr = builder.f11548a;
        int i8 = builder.f11549b;
        builder.f11549b = i8 + 1;
        jArr[i8] = jDecodeLong;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        long[] toBuilder = ((q5.t) obj).f13516a;
        kotlin.jvm.internal.k.e(toBuilder, "$this$toBuilder");
        y1 y1Var = new y1();
        y1Var.f11548a = toBuilder;
        y1Var.f11549b = toBuilder.length;
        y1Var.b(10);
        return y1Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new q5.t(new long[0]);
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        long[] jArr = ((q5.t) obj).f13516a;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeInlineElement(this.f11464b, i8).encodeLong(jArr[i8]);
        }
    }
}
