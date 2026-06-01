package g7;

import f7.q1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f11632a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f11633b = y.f11629b;

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        r2.q.k(decoder);
        q1 q1Var = q1.f11501a;
        return new x((Map) r2.q.d(o.f11619a).deserialize(decoder));
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11633b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        x value = (x) obj;
        kotlin.jvm.internal.k.e(value, "value");
        r2.q.l(fVar);
        q1 q1Var = q1.f11501a;
        r2.q.d(o.f11619a).serialize(fVar, value);
    }
}
