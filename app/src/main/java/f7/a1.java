package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a1 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11417a = n7.b.B(q5.g.f13495b, new androidx.activity.result.b(this, 7));

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        int iDecodeElementIndex;
        kotlin.jvm.internal.k.e(decoder, "decoder");
        d7.g descriptor = getDescriptor();
        e7.c cVarBeginStructure = decoder.beginStructure(descriptor);
        if (!cVarBeginStructure.decodeSequentially() && (iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new b7.i(a1.a.g(iDecodeElementIndex, "Unexpected index "));
        }
        cVarBeginStructure.endStructure(descriptor);
        return q5.x.f13520a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, q5.f] */
    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return (d7.g) this.f11417a.getValue();
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object value) {
        kotlin.jvm.internal.k.e(value, "value");
        fVar.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
