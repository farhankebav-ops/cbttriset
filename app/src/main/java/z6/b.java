package z6;

import e6.q;
import q5.x;
import q6.f2;
import q6.j;
import q6.k;
import q6.l;
import v6.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements j, f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f17990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f17991b;

    public b(c cVar, l lVar) {
        this.f17991b = cVar;
        this.f17990a = lVar;
    }

    @Override // q6.f2
    public final void b(s sVar, int i2) {
        this.f17990a.b(sVar, i2);
    }

    @Override // q6.j
    public final boolean e(Throwable th) {
        return this.f17990a.e(th);
    }

    @Override // q6.j
    public final e2.f f(Object obj, q qVar) {
        c cVar = this.f17991b;
        k kVar = new k(cVar, this);
        e2.f fVarD = this.f17990a.D((x) obj, kVar);
        if (fVarD != null) {
            c.g.set(cVar, null);
        }
        return fVarD;
    }

    @Override // v5.c
    public final v5.h getContext() {
        return this.f17990a.e;
    }

    @Override // q6.j
    public final boolean isActive() {
        return this.f17990a.isActive();
    }

    @Override // q6.j
    public final void q(Object obj) {
        this.f17990a.q(obj);
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        this.f17990a.resumeWith(obj);
    }
}
