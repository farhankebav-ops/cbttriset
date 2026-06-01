package f5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends s4.l implements a5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11410a;

    public n(Object obj) {
        this.f11410a = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f11410a;
    }

    @Override // s4.l
    public final void d(s4.m mVar) {
        o oVar = new o(mVar, this.f11410a);
        mVar.a(oVar);
        oVar.run();
    }
}
