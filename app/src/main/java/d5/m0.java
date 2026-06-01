package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m0 extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11121d;
    public final r4.c e;

    public m0(m mVar, int i2) {
        super(mVar);
        this.f11120c = i2;
        this.f11121d = true;
        this.e = z4.b.f17983c;
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        this.f11051b.d(new l0(gVar, this.f11120c, this.f11121d, this.e));
    }
}
