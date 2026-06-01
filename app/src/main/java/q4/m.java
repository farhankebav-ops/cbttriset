package q4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f13460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.f f13461c;

    public m(o oVar, i4.f fVar, int i2) {
        this.f13459a = i2;
        switch (i2) {
            case 1:
                r2.q.y(oVar.e != null, "success rate ejection config is null");
                this.f13460b = oVar;
                this.f13461c = fVar;
                break;
            default:
                this.f13460b = oVar;
                this.f13461c = fVar;
                break;
        }
    }
}
