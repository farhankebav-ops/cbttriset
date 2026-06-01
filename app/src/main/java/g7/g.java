package g7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f11607a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f11608b = f.f11604b;

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        r2.q.k(decoder);
        return new e((List) r2.q.c(o.f11619a).deserialize(decoder));
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11608b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        e value = (e) obj;
        kotlin.jvm.internal.k.e(value, "value");
        r2.q.l(fVar);
        r2.q.c(o.f11619a).serialize(fVar, value);
    }
}
