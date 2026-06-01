package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 extends k5.a implements s4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5.g f11113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x4.a f11114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o7.b f11115d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11116f;
    public Throwable g;
    public final AtomicLong h = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11117i;

    public l0(s4.g gVar, int i2, boolean z2, r4.c cVar) {
        this.f11112a = gVar;
        this.f11114c = cVar;
        this.f11113b = z2 ? new h5.b(i2) : new h5.a(i2);
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.f11113b.offer(obj)) {
            if (this.f11117i) {
                this.f11112a.b(null);
                return;
            } else {
                h();
                return;
            }
        }
        this.f11115d.cancel();
        v4.c cVar = new v4.c("Buffer is full");
        try {
            this.f11114c.run();
        } catch (Throwable th) {
            r2.q.y0(th);
            cVar.initCause(th);
        }
        onError(cVar);
    }

    @Override // o7.b
    public final void c(long j) {
        if (this.f11117i || !k5.f.d(j)) {
            return;
        }
        a.a.f(this.h, j);
        h();
    }

    @Override // o7.b
    public final void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f11115d.cancel();
        if (getAndIncrement() == 0) {
            this.f11113b.clear();
        }
    }

    @Override // a5.h
    public final void clear() {
        this.f11113b.clear();
    }

    @Override // a5.d
    public final int d(int i2) {
        this.f11117i = true;
        return 2;
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11115d, bVar)) {
            this.f11115d = bVar;
            this.f11112a.f(this);
            bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    public final boolean g(boolean z2, boolean z7, s4.g gVar) {
        if (this.e) {
            this.f11113b.clear();
            return true;
        }
        if (!z2) {
            return false;
        }
        Throwable th = this.g;
        if (th != null) {
            this.f11113b.clear();
            gVar.onError(th);
            return true;
        }
        if (!z7) {
            return false;
        }
        gVar.onComplete();
        return true;
    }

    public final void h() {
        if (getAndIncrement() == 0) {
            a5.g gVar = this.f11113b;
            s4.g gVar2 = this.f11112a;
            int iAddAndGet = 1;
            while (!g(this.f11116f, gVar.isEmpty(), gVar2)) {
                long j = this.h.get();
                long j3 = 0;
                while (j3 != j) {
                    boolean z2 = this.f11116f;
                    Object objPoll = gVar.poll();
                    boolean z7 = objPoll == null;
                    if (g(z2, z7, gVar2)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    gVar2.b(objPoll);
                    j3++;
                }
                if (j3 == j && g(this.f11116f, gVar.isEmpty(), gVar2)) {
                    return;
                }
                if (j3 != 0 && j != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.h.addAndGet(-j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.f11113b.isEmpty();
    }

    @Override // s4.g
    public final void onComplete() {
        this.f11116f = true;
        if (this.f11117i) {
            this.f11112a.onComplete();
        } else {
            h();
        }
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        this.g = th;
        this.f11116f = true;
        if (this.f11117i) {
            this.f11112a.onError(th);
        } else {
            h();
        }
    }

    @Override // a5.h
    public final Object poll() {
        return this.f11113b.poll();
    }
}
