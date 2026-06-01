package c5;

import e5.s;
import r2.q;
import s4.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements s4.b, u4.b, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u4.b f4213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4215d;

    public /* synthetic */ e(j jVar, Object obj, int i2) {
        this.f4212a = i2;
        this.f4214c = jVar;
        this.f4215d = obj;
    }

    @Override // s4.b, s4.j, s4.r
    public final void a(u4.b bVar) {
        switch (this.f4212a) {
            case 0:
                s4.b bVar2 = (s4.b) this.f4214c;
                if (y4.a.f(this.f4213b, bVar)) {
                    this.f4213b = bVar;
                    bVar2.a(this);
                }
                break;
            case 1:
                if (y4.a.f(this.f4213b, bVar)) {
                    this.f4213b = bVar;
                    ((j) this.f4214c).a(this);
                }
                break;
            default:
                j jVar = (j) this.f4214c;
                if (y4.a.f(this.f4213b, bVar)) {
                    this.f4213b = bVar;
                    jVar.a(this);
                }
                break;
        }
    }

    public void b(Throwable th) {
        try {
            ((s) this.f4215d).f11295c.accept(th);
        } catch (Throwable th2) {
            q.y0(th2);
            th = new v4.b(th, th2);
        }
        this.f4213b = y4.a.f17847a;
        ((j) this.f4214c).onError(th);
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f4212a) {
            case 0:
                this.f4213b.dispose();
                break;
            case 1:
                u4.b bVar = this.f4213b;
                this.f4213b = y4.a.f17847a;
                bVar.dispose();
                break;
            default:
                try {
                    ((s) this.f4215d).getClass();
                } catch (Throwable th) {
                    q.y0(th);
                    n7.b.F(th);
                }
                this.f4213b.dispose();
                this.f4213b = y4.a.f17847a;
                break;
        }
    }

    @Override // s4.b, s4.j
    public final void onComplete() {
        switch (this.f4212a) {
            case 0:
                s4.b bVar = (s4.b) this.f4214c;
                f fVar = (f) this.f4215d;
                if (this.f4213b != y4.a.f17847a) {
                    try {
                        fVar.f4218c.run();
                        bVar.onComplete();
                    } catch (Throwable th) {
                        q.y0(th);
                        bVar.onError(th);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                ((j) this.f4214c).onComplete();
                break;
            default:
                u4.b bVar2 = this.f4213b;
                y4.a aVar = y4.a.f17847a;
                if (bVar2 != aVar) {
                    this.f4213b = aVar;
                    ((j) this.f4214c).onComplete();
                    break;
                }
                break;
        }
    }

    @Override // s4.b, s4.j, s4.r
    public final void onError(Throwable th) {
        int i2 = this.f4212a;
        Object obj = this.f4214c;
        y4.a aVar = y4.a.f17847a;
        switch (i2) {
            case 0:
                f fVar = (f) this.f4215d;
                if (this.f4213b != aVar) {
                    try {
                        fVar.f4217b.accept(th);
                    } catch (Throwable th2) {
                        q.y0(th2);
                        th = new v4.b(th, th2);
                    }
                    ((s4.b) obj).onError(th);
                } else {
                    n7.b.F(th);
                }
                break;
            case 1:
                ((j) obj).onError(th);
                break;
            default:
                if (this.f4213b != aVar) {
                    b(th);
                } else {
                    n7.b.F(th);
                }
                break;
        }
    }

    @Override // s4.j, s4.r
    public void onSuccess(Object obj) {
        switch (this.f4212a) {
            case 1:
                j jVar = (j) this.f4214c;
                try {
                    Object objApply = ((x4.c) this.f4215d).apply(obj);
                    z4.b.a(objApply, "The mapper returned a null item");
                    jVar.onSuccess(objApply);
                } catch (Throwable th) {
                    q.y0(th);
                    jVar.onError(th);
                    return;
                }
                break;
            default:
                u4.b bVar = this.f4213b;
                y4.a aVar = y4.a.f17847a;
                if (bVar != aVar) {
                    try {
                        ((s) this.f4215d).f11294b.accept(obj);
                        this.f4213b = aVar;
                        ((j) this.f4214c).onSuccess(obj);
                    } catch (Throwable th2) {
                        q.y0(th2);
                        b(th2);
                    }
                    break;
                }
                break;
        }
    }

    public e(f fVar, s4.b bVar) {
        this.f4212a = 0;
        this.f4215d = fVar;
        this.f4214c = bVar;
    }
}
