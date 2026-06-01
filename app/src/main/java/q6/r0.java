package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r0 extends t0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f13580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v0 f13581d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(v0 v0Var, long j, l lVar) {
        super(j);
        this.f13581d = v0Var;
        this.f13580c = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13580c.B(this.f13581d);
    }

    @Override // q6.t0
    public final String toString() {
        return super.toString() + this.f13580c;
    }
}
