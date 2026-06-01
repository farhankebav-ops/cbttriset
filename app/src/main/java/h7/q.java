package h7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g7.m f11768f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(g7.c json, g7.m value, String str) {
        super(json, str);
        kotlin.jvm.internal.k.e(json, "json");
        kotlin.jvm.internal.k.e(value, "value");
        this.f11768f = value;
        this.f11732a.add("primitive");
    }

    @Override // h7.a
    public final g7.m c(String tag) {
        kotlin.jvm.internal.k.e(tag, "tag");
        if (tag == "primitive") {
            return this.f11768f;
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    @Override // e7.c
    public final int decodeElementIndex(d7.g descriptor) {
        kotlin.jvm.internal.k.e(descriptor, "descriptor");
        return 0;
    }

    @Override // h7.a
    public final g7.m q() {
        return this.f11768f;
    }
}
