package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.inappmessaging.internal.j f11131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w1.f f11132d;
    public final r4.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r4.c f11133f;

    public p(s4.d dVar, com.google.firebase.inappmessaging.internal.j jVar) {
        super(dVar);
        this.f11131c = jVar;
        this.f11132d = z4.b.f17984d;
        r4.c cVar = z4.b.f17983c;
        this.e = cVar;
        this.f11133f = cVar;
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        boolean z2 = gVar instanceof a5.a;
        s4.d dVar = this.f11051b;
        if (z2) {
            dVar.d(new n((a5.a) gVar, this.f11131c, this.f11132d, this.e, this.f11133f));
        } else {
            dVar.d(new o(gVar, this.f11131c, this.f11132d, this.e, this.f11133f));
        }
    }
}
