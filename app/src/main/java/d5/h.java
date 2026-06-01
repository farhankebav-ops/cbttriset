package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11095c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11096d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.c f11097f;

    public h(m mVar, int i2) {
        super(mVar);
        this.f11097f = z4.b.f17981a;
        this.f11096d = 3;
        this.e = i2;
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        switch (this.f11095c) {
            case 0:
                com.google.firebase.inappmessaging.internal.k kVar = (com.google.firebase.inappmessaging.internal.k) this.f11097f;
                s4.d dVar = this.f11051b;
                if (!r2.q.C0(dVar, gVar, kVar)) {
                    int iB = q0.c.b(this.e);
                    int i2 = this.f11096d;
                    dVar.d(iB != 1 ? iB != 2 ? new d(gVar, kVar, i2) : new c(gVar, kVar, i2, true) : new c(gVar, kVar, i2, false));
                    break;
                }
                break;
            default:
                r4.c cVar = (r4.c) this.f11097f;
                s4.d dVar2 = this.f11051b;
                if (!r2.q.C0(dVar2, gVar, cVar)) {
                    dVar2.d(new z(gVar, cVar, this.f11096d, this.e));
                    break;
                }
                break;
        }
    }

    public h(b0 b0Var, com.google.firebase.inappmessaging.internal.k kVar) {
        super(b0Var);
        this.f11097f = kVar;
        this.f11096d = 2;
        this.e = 1;
    }
}
