package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r4 extends i4.x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i4.a f12433d = new i4.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.x f12434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f12435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.s1 f12436c;

    public r4(v0 v0Var, l lVar, i4.s1 s1Var) {
        this.f12434a = v0Var;
        this.f12435b = lVar;
        this.f12436c = s1Var;
    }

    @Override // i4.x
    public String d() {
        return this.f12434a.d();
    }

    @Override // i4.x
    public final void j() {
        this.f12434a.j();
    }

    @Override // i4.x
    public final void l() {
        this.f12434a.l();
        l lVar = this.f12435b;
        i4.s1 s1Var = lVar.f12294b;
        s1Var.d();
        s1Var.execute(new com.vungle.ads.internal.omsdk.a(lVar, 6));
    }

    @Override // i4.x
    public final void m(i4.f fVar) {
        this.f12434a.m(new q4(this, fVar));
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12434a, "delegate");
        return iVarY.toString();
    }
}
