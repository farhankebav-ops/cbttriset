package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements s4.m, o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u4.b f11089b;

    public f0(s4.g gVar) {
        this.f11088a = gVar;
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        this.f11089b = bVar;
        this.f11088a.f(this);
    }

    @Override // s4.m
    public final void b(Object obj) {
        this.f11088a.b(obj);
    }

    @Override // o7.b
    public final void cancel() {
        this.f11089b.dispose();
    }

    @Override // s4.m
    public final void onComplete() {
        this.f11088a.onComplete();
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        this.f11088a.onError(th);
    }

    @Override // o7.b
    public final void c(long j) {
    }
}
