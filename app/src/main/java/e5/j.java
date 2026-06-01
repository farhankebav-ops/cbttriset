package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends s4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.h f11277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.c f11278b;

    public j(s4.h hVar, x4.c cVar) {
        this.f11277a = hVar;
        this.f11278b = cVar;
    }

    @Override // s4.a
    public final void e(s4.b bVar) {
        i iVar = new i(0, bVar, this.f11278b);
        bVar.a(iVar);
        this.f11277a.b(iVar);
    }
}
