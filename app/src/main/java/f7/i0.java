package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i0 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b7.c f11466a;

    public i0(b7.c cVar) {
        this.f11466a = cVar;
    }

    @Override // f7.e0
    public final b7.c[] childSerializers() {
        return new b7.c[]{this.f11466a};
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        throw new IllegalStateException("unsupported");
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        throw new IllegalStateException("unsupported");
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        throw new IllegalStateException("unsupported");
    }

    @Override // f7.e0
    public final b7.c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
