package d5;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i0 extends k5.a implements s4.g, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.o f11101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f11104d = new AtomicLong();
    public o7.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a5.h f11105f;
    public volatile boolean g;
    public volatile boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f11106i;
    public int j;
    public long k;
    public boolean l;

    public i0(s4.o oVar, int i2) {
        this.f11101a = oVar;
        this.f11102b = i2;
        this.f11103c = i2 - (i2 >> 2);
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.h) {
            return;
        }
        if (this.j == 2) {
            k();
            return;
        }
        if (!this.f11105f.offer(obj)) {
            this.e.cancel();
            this.f11106i = new v4.c("Queue is full?!");
            this.h = true;
        }
        k();
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j)) {
            a.a.f(this.f11104d, j);
            k();
        }
    }

    @Override // o7.b
    public final void cancel() {
        if (this.g) {
            return;
        }
        this.g = true;
        this.e.cancel();
        this.f11101a.dispose();
        if (getAndIncrement() == 0) {
            this.f11105f.clear();
        }
    }

    @Override // a5.h
    public final void clear() {
        this.f11105f.clear();
    }

    @Override // a5.d
    public final int d(int i2) {
        this.l = true;
        return 2;
    }

    public final boolean g(boolean z2, boolean z7, s4.g gVar) {
        if (this.g) {
            clear();
            return true;
        }
        if (!z2) {
            return false;
        }
        Throwable th = this.f11106i;
        if (th != null) {
            clear();
            gVar.onError(th);
            this.f11101a.dispose();
            return true;
        }
        if (!z7) {
            return false;
        }
        gVar.onComplete();
        this.f11101a.dispose();
        return true;
    }

    public abstract void h();

    public abstract void i();

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f11105f.isEmpty();
    }

    public abstract void j();

    public final void k() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.f11101a.b(this);
    }

    @Override // s4.g
    public final void onComplete() {
        if (this.h) {
            return;
        }
        this.h = true;
        k();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.h) {
            n7.b.F(th);
            return;
        }
        this.f11106i = th;
        this.h = true;
        k();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.l) {
            i();
        } else if (this.j == 1) {
            j();
        } else {
            h();
        }
    }
}
