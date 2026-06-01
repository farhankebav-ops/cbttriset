package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t1 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t1 f11522c = new t1(u1.f11526a);

    @Override // f7.a
    public final int e(Object obj) {
        byte[] collectionSize = ((q5.p) obj).f13512a;
        kotlin.jvm.internal.k.e(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        s1 builder = (s1) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        byte bDecodeByte = cVar.decodeInlineElement(this.f11464b, i2).decodeByte();
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f11515a;
        int i8 = builder.f11516b;
        builder.f11516b = i8 + 1;
        bArr[i8] = bDecodeByte;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        byte[] toBuilder = ((q5.p) obj).f13512a;
        kotlin.jvm.internal.k.e(toBuilder, "$this$toBuilder");
        s1 s1Var = new s1();
        s1Var.f11515a = toBuilder;
        s1Var.f11516b = toBuilder.length;
        s1Var.b(10);
        return s1Var;
    }

    @Override // f7.h1
    public final Object l() {
        return new q5.p(new byte[0]);
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        byte[] bArr = ((q5.p) obj).f13512a;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeInlineElement(this.f11464b, i8).encodeByte(bArr[i8]);
        }
    }
}
