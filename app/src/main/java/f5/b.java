package f5;

import r2.q;
import s4.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements s4.m, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.f f11366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u4.b f11367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11368d;
    public final Object e;

    public /* synthetic */ b(Object obj, e2.f fVar, int i2) {
        this.f11365a = i2;
        this.e = obj;
        this.f11366b = fVar;
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        switch (this.f11365a) {
            case 0:
                if (y4.a.f(this.f11367c, bVar)) {
                    this.f11367c = bVar;
                    ((s4.m) this.e).a(this);
                }
                break;
            default:
                if (y4.a.f(this.f11367c, bVar)) {
                    this.f11367c = bVar;
                    ((r) this.e).a(this);
                }
                break;
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        switch (this.f11365a) {
            case 0:
                s4.m mVar = (s4.m) this.e;
                if (!this.f11368d) {
                    try {
                        if (this.f11366b.test(obj)) {
                            this.f11368d = true;
                            this.f11367c.dispose();
                            mVar.b(Boolean.TRUE);
                            mVar.onComplete();
                        }
                    } catch (Throwable th) {
                        q.y0(th);
                        this.f11367c.dispose();
                        onError(th);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!this.f11368d) {
                    try {
                        if (this.f11366b.test(obj)) {
                            this.f11368d = true;
                            this.f11367c.dispose();
                            ((r) this.e).onSuccess(Boolean.TRUE);
                        }
                    } catch (Throwable th2) {
                        q.y0(th2);
                        this.f11367c.dispose();
                        onError(th2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11365a) {
            case 0:
                this.f11367c.dispose();
                break;
            default:
                this.f11367c.dispose();
                break;
        }
    }

    @Override // s4.m
    public final void onComplete() {
        switch (this.f11365a) {
            case 0:
                s4.m mVar = (s4.m) this.e;
                if (!this.f11368d) {
                    this.f11368d = true;
                    mVar.b(Boolean.FALSE);
                    mVar.onComplete();
                }
                break;
            default:
                if (!this.f11368d) {
                    this.f11368d = true;
                    ((r) this.e).onSuccess(Boolean.FALSE);
                }
                break;
        }
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        switch (this.f11365a) {
            case 0:
                if (!this.f11368d) {
                    this.f11368d = true;
                    ((s4.m) this.e).onError(th);
                } else {
                    n7.b.F(th);
                }
                break;
            default:
                if (!this.f11368d) {
                    this.f11368d = true;
                    ((r) this.e).onError(th);
                } else {
                    n7.b.F(th);
                }
                break;
        }
    }
}
