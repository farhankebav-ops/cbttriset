package e5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends AtomicReference implements s4.j, s4.b, u4.b, s4.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11276c;

    public /* synthetic */ i(int i2, Object obj, Object obj2) {
        this.f11274a = i2;
        this.f11275b = obj;
        this.f11276c = obj2;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        switch (this.f11274a) {
            case 0:
                y4.a.c(this, bVar);
                break;
            case 1:
                y4.a.e(this, bVar);
                break;
            case 2:
                if (y4.a.e(this, bVar)) {
                    ((s4.j) this.f11275b).a(this);
                }
                break;
            default:
                if (y4.a.e(this, bVar)) {
                    ((s4.r) this.f11275b).a(this);
                }
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11274a) {
            case 0:
                y4.a.a(this);
                break;
            case 1:
                y4.a.a(this);
                b5.b bVar = (b5.b) this.f11275b;
                bVar.getClass();
                y4.a.a(bVar);
                break;
            case 2:
                y4.a.a(this);
                break;
            default:
                y4.a.a(this);
                break;
        }
    }

    @Override // s4.j
    public void onComplete() {
        switch (this.f11274a) {
            case 0:
                ((s4.b) this.f11275b).onComplete();
                break;
            case 1:
                ((s4.j) this.f11276c).onComplete();
                break;
            default:
                u4.b bVar = (u4.b) get();
                if (bVar != y4.a.f17847a && compareAndSet(bVar, null)) {
                    ((s4.h) this.f11276c).b(new android.support.v4.media.g(5, (s4.j) this.f11275b, this));
                    break;
                }
                break;
        }
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        int i2 = this.f11274a;
        Object obj = this.f11276c;
        Object obj2 = this.f11275b;
        switch (i2) {
            case 0:
                ((s4.b) obj2).onError(th);
                break;
            case 1:
                ((s4.j) obj).onError(th);
                break;
            case 2:
                ((s4.j) obj2).onError(th);
                break;
            default:
                s4.r rVar = (s4.r) obj2;
                try {
                    ((s4.q) ((z4.a) obj).f17980a).b(new android.support.v4.media.g(1, this, rVar));
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    rVar.onError(new v4.b(th, th2));
                }
                break;
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        switch (this.f11274a) {
            case 0:
                try {
                    Object objApply = ((x4.c) this.f11276c).apply(obj);
                    z4.b.a(objApply, "The mapper returned a null CompletableSource");
                    s4.c cVar = (s4.c) objApply;
                    if (!y4.a.b((u4.b) get())) {
                        ((s4.a) cVar).d(this);
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    onError(th);
                    return;
                }
                break;
            case 1:
                ((s4.j) this.f11276c).onSuccess(obj);
                break;
            case 2:
                ((s4.j) this.f11275b).onSuccess(obj);
                break;
            default:
                ((s4.r) this.f11275b).onSuccess(obj);
                break;
        }
    }

    public i(s4.j jVar) {
        this.f11274a = 1;
        this.f11276c = jVar;
        this.f11275b = new b5.b(2);
    }
}
