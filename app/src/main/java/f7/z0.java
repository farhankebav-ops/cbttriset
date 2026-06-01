package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f11553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1 f11554b;

    public z0(b7.c serializer) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
        this.f11553a = serializer;
        this.f11554b = new l1(serializer.getDescriptor());
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        return decoder.decodeNotNullMark() ? decoder.decodeSerializableValue(this.f11553a) : decoder.decodeNull();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && z0.class == obj.getClass() && kotlin.jvm.internal.k.a(this.f11553a, ((z0) obj).f11553a);
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f11554b;
    }

    public final int hashCode() {
        return this.f11553a.hashCode();
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        if (obj == null) {
            fVar.encodeNull();
        } else {
            fVar.encodeNotNullMark();
            fVar.encodeSerializableValue(this.f11553a, obj);
        }
    }
}
