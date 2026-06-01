package q4;

import i4.n0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f13441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f13442c;

    public /* synthetic */ f(b bVar, n0 n0Var, int i2) {
        this.f13440a = i2;
        this.f13442c = bVar;
        this.f13441b = n0Var;
    }

    @Override // i4.n0
    public final void a(i4.n nVar) {
        switch (this.f13440a) {
            case 0:
                this.f13441b.a(nVar);
                ((g) this.f13442c).e.a(nVar);
                break;
            default:
                s sVar = (s) this.f13442c;
                sVar.g = nVar;
                if (!sVar.f13477f) {
                    this.f13441b.a(nVar);
                }
                break;
        }
    }
}
