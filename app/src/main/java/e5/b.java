package e5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends AtomicReference implements s4.j, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11259d;

    public b() {
        this.f11256a = 0;
        this.f11257b = z4.b.f17984d;
        this.f11258c = z4.b.e;
        this.f11259d = z4.b.f17983c;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        switch (this.f11256a) {
            case 0:
                y4.a.e(this, bVar);
                break;
            default:
                if (y4.a.f((u4.b) this.f11259d, bVar)) {
                    this.f11259d = bVar;
                    ((s4.j) this.f11257b).a(this);
                }
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11256a) {
            case 0:
                y4.a.a(this);
                break;
            default:
                y4.a.a(this);
                ((u4.b) this.f11259d).dispose();
                break;
        }
    }

    @Override // s4.j
    public final void onComplete() {
        switch (this.f11256a) {
            case 0:
                lazySet(y4.a.f17847a);
                try {
                    ((r4.c) this.f11259d).getClass();
                } catch (Throwable th) {
                    r2.q.y0(th);
                    n7.b.F(th);
                    return;
                }
                break;
            default:
                ((s4.j) this.f11257b).onComplete();
                break;
        }
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        switch (this.f11256a) {
            case 0:
                lazySet(y4.a.f17847a);
                try {
                    ((w1.f) this.f11258c).accept(th);
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    n7.b.F(new v4.b(th, th2));
                    return;
                }
                break;
            default:
                ((s4.j) this.f11257b).onError(th);
                break;
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        switch (this.f11256a) {
            case 0:
                lazySet(y4.a.f17847a);
                try {
                    ((w1.f) this.f11257b).getClass();
                } catch (Throwable th) {
                    r2.q.y0(th);
                    n7.b.F(th);
                }
                break;
            default:
                try {
                    Object objApply = ((x4.c) this.f11258c).apply(obj);
                    z4.b.a(objApply, "The mapper returned a null MaybeSource");
                    s4.k kVar = (s4.k) objApply;
                    if (!y4.a.b((u4.b) get())) {
                        ((s4.h) kVar).b(new a4.a(this, 9));
                    }
                } catch (Exception e) {
                    r2.q.y0(e);
                    ((s4.j) this.f11257b).onError(e);
                    return;
                }
                break;
        }
    }

    public b(s4.j jVar, x4.c cVar) {
        this.f11256a = 1;
        this.f11257b = jVar;
        this.f11258c = cVar;
    }
}
