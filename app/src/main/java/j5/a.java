package j5;

import a5.e;
import k5.f;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements a5.a, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a5.a f12574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o7.b f12575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f12576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12577d;
    public int e;

    public a(a5.a aVar) {
        this.f12574a = aVar;
    }

    public final void a(Throwable th) {
        q.y0(th);
        this.f12575b.cancel();
        onError(th);
    }

    @Override // o7.b
    public final void c(long j) {
        this.f12575b.c(j);
    }

    @Override // o7.b
    public final void cancel() {
        this.f12575b.cancel();
    }

    @Override // a5.h
    public final void clear() {
        this.f12576c.clear();
    }

    @Override // a5.d
    public int d(int i2) {
        e eVar = this.f12576c;
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
        if (f.e(this.f12575b, bVar)) {
            this.f12575b = bVar;
            if (bVar instanceof e) {
                this.f12576c = (e) bVar;
            }
            this.f12574a.f(this);
        }
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f12576c.isEmpty();
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // s4.g
    public void onComplete() {
        if (this.f12577d) {
            return;
        }
        this.f12577d = true;
        this.f12574a.onComplete();
    }

    @Override // s4.g
    public void onError(Throwable th) {
        if (this.f12577d) {
            n7.b.F(th);
        } else {
            this.f12577d = true;
            this.f12574a.onError(th);
        }
    }
}
