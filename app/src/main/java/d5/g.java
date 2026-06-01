package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11092c;

    public g(Object obj, s4.g gVar) {
        this.f11091b = obj;
        this.f11090a = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        if (j <= 0 || this.f11092c) {
            return;
        }
        this.f11092c = true;
        Object obj = this.f11091b;
        s4.g gVar = this.f11090a;
        gVar.b(obj);
        gVar.onComplete();
    }

    @Override // o7.b
    public final void cancel() {
    }
}
