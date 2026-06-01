package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i4.n1 f12437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i4.a1 f12438d;
    public final /* synthetic */ e2.h e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(e2.h hVar, i4.n1 n1Var, i4.a1 a1Var) {
        super(((v) hVar.f11233c).h, 0);
        this.e = hVar;
        this.f12437c = n1Var;
        this.f12438d = a1Var;
    }

    @Override // j4.h0
    public final void b() {
        r4.b.c();
        try {
            r4.b.a();
            r4.a aVar = r4.b.f13625a;
            aVar.getClass();
            c();
            aVar.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c() {
        i4.n1 n1Var = this.f12437c;
        i4.a1 a1Var = this.f12438d;
        i4.n1 n1Var2 = (i4.n1) this.e.f11232b;
        if (n1Var2 != null) {
            a1Var = new i4.a1();
            n1Var = n1Var2;
        }
        ((v) this.e.f11233c).m = true;
        try {
            ((i4.x) this.e.f11231a).f(n1Var, a1Var);
            ((v) this.e.f11233c).u();
            h hVar = ((v) this.e.f11233c).g;
            if (n1Var.f()) {
                ((c2) hVar.f12233c).a();
            } else {
                ((c2) hVar.f12234d).a();
            }
        } catch (Throwable th) {
            ((v) this.e.f11233c).u();
            h hVar2 = ((v) this.e.f11233c).g;
            if (n1Var.f()) {
                ((c2) hVar2.f12233c).a();
            } else {
                ((c2) hVar2.f12234d).a();
            }
            throw th;
        }
    }
}
