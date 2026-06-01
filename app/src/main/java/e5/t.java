package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends k5.c implements s4.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u4.b f11296c;

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        if (y4.a.f(this.f11296c, bVar)) {
            this.f11296c = bVar;
            this.f12701a.f(this);
        }
    }

    @Override // o7.b
    public final void cancel() {
        set(4);
        this.f12702b = null;
        this.f11296c.dispose();
    }

    @Override // s4.j
    public final void onComplete() {
        this.f12701a.onComplete();
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        this.f12701a.onError(th);
    }
}
