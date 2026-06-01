package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f12348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12349b;

    public o1(f0 f0Var, h hVar) {
        this.f12348a = f0Var;
        this.f12349b = hVar;
    }

    @Override // j4.z
    public final w b(i4.c1 c1Var, i4.a1 a1Var, i4.d dVar, i4.i[] iVarArr) {
        return new g5(3, this, this.f12348a.b(c1Var, a1Var, dVar, iVarArr));
    }

    @Override // j4.a1
    public final f0 e() {
        return this.f12348a;
    }
}
