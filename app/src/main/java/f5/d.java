package f5;

import s4.q;
import s4.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends q implements a5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.f f11372b;

    public d(c cVar, e2.f fVar) {
        this.f11371a = cVar;
        this.f11372b = fVar;
    }

    @Override // a5.b
    public final s4.l a() {
        return new c(this.f11371a, this.f11372b, 0);
    }

    @Override // s4.q
    public final void c(r rVar) {
        this.f11371a.c(new b(rVar, this.f11372b, 1));
    }
}
