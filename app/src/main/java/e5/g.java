package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11270c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(s4.h hVar, Object obj, int i2) {
        super(hVar);
        this.f11269b = i2;
        this.f11270c = obj;
    }

    @Override // s4.h
    public final void c(s4.j jVar) {
        switch (this.f11269b) {
            case 0:
                ((s4.h) this.f11255a).b(new f(jVar, (x4.d) this.f11270c, 0));
                break;
            case 1:
                ((s4.h) this.f11255a).b(new q(jVar, (s4.p) this.f11270c));
                break;
            default:
                ((s4.h) this.f11255a).b(new i(2, jVar, (s4.h) this.f11270c));
                break;
        }
    }
}
