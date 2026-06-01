package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 implements b1, e, u6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f17483a;

    public s0(q0 q0Var) {
        this.f17483a = q0Var;
    }

    @Override // t6.e
    public final Object collect(f fVar, v5.c cVar) {
        return this.f17483a.collect(fVar, cVar);
    }

    @Override // u6.l
    public final e e(v5.h hVar, int i2, s6.a aVar) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || aVar != s6.a.f13719b) ? x0.n(this, hVar, i2, aVar) : this;
    }

    @Override // t6.b1
    public final Object getValue() {
        return this.f17483a.getValue();
    }
}
