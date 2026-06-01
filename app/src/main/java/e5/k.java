package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x4.c f11280c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(s4.h hVar, x4.c cVar, int i2) {
        super(hVar);
        this.f11279b = i2;
        this.f11280c = cVar;
    }

    @Override // s4.h
    public final void c(s4.j jVar) {
        switch (this.f11279b) {
            case 0:
                ((s4.h) this.f11255a).b(new b(jVar, this.f11280c));
                break;
            case 1:
                ((s4.h) this.f11255a).b(new c5.e(jVar, this.f11280c, 1));
                break;
            default:
                ((s4.h) this.f11255a).b(new r(jVar, this.f11280c));
                break;
        }
    }
}
