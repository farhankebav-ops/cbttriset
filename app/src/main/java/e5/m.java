package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m implements s4.b, u4.b, s4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u4.b f11284c;

    public /* synthetic */ m(Object obj, int i2) {
        this.f11282a = i2;
        this.f11283b = obj;
    }

    @Override // s4.b, s4.j, s4.r
    public final void a(u4.b bVar) {
        switch (this.f11282a) {
            case 0:
                if (y4.a.f(this.f11284c, bVar)) {
                    this.f11284c = bVar;
                    ((s4.j) this.f11283b).a(this);
                }
                break;
            case 1:
                if (y4.a.f(this.f11284c, bVar)) {
                    this.f11284c = bVar;
                    ((s4.j) this.f11283b).a(this);
                }
                break;
            default:
                if (y4.a.f(this.f11284c, bVar)) {
                    this.f11284c = bVar;
                    ((s4.r) this.f11283b).a(this);
                }
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11282a) {
            case 0:
                this.f11284c.dispose();
                this.f11284c = y4.a.f17847a;
                break;
            case 1:
                this.f11284c.dispose();
                break;
            default:
                this.f11284c.dispose();
                this.f11284c = y4.a.f17847a;
                break;
        }
    }

    @Override // s4.b, s4.j
    public final void onComplete() {
        switch (this.f11282a) {
            case 0:
                this.f11284c = y4.a.f17847a;
                ((s4.j) this.f11283b).onComplete();
                break;
            case 1:
                ((s4.j) this.f11283b).onSuccess(Boolean.TRUE);
                break;
            default:
                this.f11284c = y4.a.f17847a;
                ((s4.r) this.f11283b).onSuccess(Boolean.TRUE);
                break;
        }
    }

    @Override // s4.b, s4.j, s4.r
    public final void onError(Throwable th) {
        switch (this.f11282a) {
            case 0:
                this.f11284c = y4.a.f17847a;
                ((s4.j) this.f11283b).onError(th);
                break;
            case 1:
                ((s4.j) this.f11283b).onError(th);
                break;
            default:
                this.f11284c = y4.a.f17847a;
                ((s4.r) this.f11283b).onError(th);
                break;
        }
    }

    @Override // s4.j, s4.r
    public void onSuccess(Object obj) {
        switch (this.f11282a) {
            case 1:
                ((s4.j) this.f11283b).onSuccess(Boolean.FALSE);
                break;
            default:
                this.f11284c = y4.a.f17847a;
                ((s4.r) this.f11283b).onSuccess(Boolean.FALSE);
                break;
        }
    }
}
