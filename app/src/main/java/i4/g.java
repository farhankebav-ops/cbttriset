package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p4.g f11864b;

    public g(e eVar, p4.g gVar) {
        this.f11863a = eVar;
        r2.q.D(gVar, "interceptor");
        this.f11864b = gVar;
    }

    @Override // i4.e
    public final String e() {
        return this.f11863a.e();
    }

    @Override // i4.e
    public final f f(c1 c1Var, d dVar) {
        p4.g gVar = this.f11864b;
        gVar.getClass();
        return new p4.f(gVar, this.f11863a.f(c1Var, dVar));
    }
}
