package q4;

import i4.a1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends i4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.h f13475b;

    public r(k kVar, i4.h hVar) {
        this.f13474a = kVar;
        this.f13475b = hVar;
    }

    @Override // i4.h
    public final i4.i a(f2.b bVar, a1 a1Var) {
        i4.h hVar = this.f13475b;
        return hVar != null ? new p(this, hVar.a(bVar, a1Var)) : new q(this);
    }
}
