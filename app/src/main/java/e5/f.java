package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements s4.j, u4.b, s4.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s4.j f11266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x4.d f11267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u4.b f11268d;

    public /* synthetic */ f(s4.j jVar, x4.d dVar, int i2) {
        this.f11265a = i2;
        this.f11266b = jVar;
        this.f11267c = dVar;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        switch (this.f11265a) {
            case 0:
                if (y4.a.f(this.f11268d, bVar)) {
                    this.f11268d = bVar;
                    this.f11266b.a(this);
                }
                break;
            default:
                if (y4.a.f(this.f11268d, bVar)) {
                    this.f11268d = bVar;
                    this.f11266b.a(this);
                }
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11265a) {
            case 0:
                u4.b bVar = this.f11268d;
                this.f11268d = y4.a.f17847a;
                bVar.dispose();
                break;
            default:
                u4.b bVar2 = this.f11268d;
                this.f11268d = y4.a.f17847a;
                bVar2.dispose();
                break;
        }
    }

    @Override // s4.j
    public void onComplete() {
        this.f11266b.onComplete();
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        switch (this.f11265a) {
            case 0:
                this.f11266b.onError(th);
                break;
            default:
                this.f11266b.onError(th);
                break;
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        switch (this.f11265a) {
            case 0:
                s4.j jVar = this.f11266b;
                try {
                    if (!this.f11267c.test(obj)) {
                        jVar.onComplete();
                    } else {
                        jVar.onSuccess(obj);
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    jVar.onError(th);
                    return;
                }
                break;
            default:
                s4.j jVar2 = this.f11266b;
                try {
                    if (!this.f11267c.test(obj)) {
                        jVar2.onComplete();
                    } else {
                        jVar2.onSuccess(obj);
                    }
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    jVar2.onError(th2);
                }
                break;
        }
    }
}
