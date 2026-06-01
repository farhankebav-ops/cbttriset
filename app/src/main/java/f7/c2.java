package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c2 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c2 f11430c = new c2(d2.f11437a);

    @Override // f7.a
    public final int e(Object obj) {
        short[] collectionSize = ((q5.w) obj).f13519a;
        kotlin.jvm.internal.k.e(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        b2 builder = (b2) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        short sDecodeShort = cVar.decodeInlineElement(this.f11464b, i2).decodeShort();
        builder.b(builder.d() + 1);
        short[] sArr = builder.f11423a;
        int i8 = builder.f11424b;
        builder.f11424b = i8 + 1;
        sArr[i8] = sDecodeShort;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        short[] toBuilder = ((q5.w) obj).f13519a;
        kotlin.jvm.internal.k.e(toBuilder, "$this$toBuilder");
        b2 b2Var = new b2();
        b2Var.f11423a = toBuilder;
        b2Var.f11424b = toBuilder.length;
        b2Var.b(10);
        return b2Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new q5.w(new short[0]);
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        short[] sArr = ((q5.w) obj).f13519a;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeInlineElement(this.f11464b, i8).encodeShort(sArr[i8]);
        }
    }
}
