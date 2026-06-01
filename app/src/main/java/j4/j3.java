package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.f f12269a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g3 f12271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12272d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i4.m f12270b = i4.m.f11897d;

    public j3(i4.f fVar, g3 g3Var) {
        this.f12269a = fVar;
        this.f12271c = g3Var;
    }

    public static void a(j3 j3Var, i4.m mVar) {
        j3Var.f12270b = mVar;
        if (mVar == i4.m.f11895b || mVar == i4.m.f11896c) {
            j3Var.f12272d = true;
        } else if (mVar == i4.m.f11897d) {
            j3Var.f12272d = false;
        }
    }
}
