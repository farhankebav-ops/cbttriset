package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f11465c = new i(j.f11469a);

    @Override // f7.a
    public final int e(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.k.e(bArr, "<this>");
        return bArr.length;
    }

    @Override // f7.r, f7.a
    public final void h(e7.c cVar, int i2, Object obj) {
        h builder = (h) obj;
        kotlin.jvm.internal.k.e(builder, "builder");
        byte bDecodeByteElement = cVar.decodeByteElement(this.f11464b, i2);
        builder.b(builder.d() + 1);
        byte[] bArr = builder.f11462a;
        int i8 = builder.f11463b;
        builder.f11463b = i8 + 1;
        bArr[i8] = bDecodeByteElement;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        byte[] bArr = (byte[]) obj;
        kotlin.jvm.internal.k.e(bArr, "<this>");
        h hVar = new h();
        hVar.f11462a = bArr;
        hVar.f11463b = bArr.length;
        hVar.b(10);
        return hVar;
    }

    @Override // f7.h1
    public final Object l() {
        return new byte[0];
    }

    @Override // f7.h1
    public final void m(e7.d encoder, Object obj, int i2) {
        byte[] content = (byte[]) obj;
        kotlin.jvm.internal.k.e(encoder, "encoder");
        kotlin.jvm.internal.k.e(content, "content");
        for (int i8 = 0; i8 < i2; i8++) {
            encoder.encodeByteElement(this.f11464b, i8, content[i8]);
        }
    }
}
