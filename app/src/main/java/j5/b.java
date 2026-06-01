package j5;

import a5.e;
import k5.f;
import s4.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements g, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f12578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o7.b f12579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f12580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12581d;
    public int e;

    public b(g gVar) {
        this.f12578a = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        this.f12579b.c(j);
    }

    @Override // o7.b
    public final void cancel() {
        this.f12579b.cancel();
    }

    @Override // a5.h
    public final void clear() {
        this.f12580c.clear();
    }

    @Override // a5.d
    public int d(int i2) {
        e eVar = this.f12580c;
        if (eVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iD = eVar.d(i2);
        if (iD == 0) {
            return iD;
        }
        this.e = iD;
        return iD;
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (f.e(this.f12579b, bVar)) {
            this.f12579b = bVar;
            if (bVar instanceof e) {
                this.f12580c = (e) bVar;
            }
            this.f12578a.f(this);
        }
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f12580c.isEmpty();
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // s4.g
    public void onComplete() {
        if (this.f12581d) {
            return;
        }
        this.f12581d = true;
        this.f12578a.onComplete();
    }

    @Override // s4.g
    public void onError(Throwable th) {
        if (this.f12581d) {
            n7.b.F(th);
        } else {
            this.f12581d = true;
            this.f12578a.onError(th);
        }
    }
}
