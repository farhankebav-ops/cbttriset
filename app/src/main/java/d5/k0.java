package d5;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends i0 {
    public final s4.g m;

    public k0(s4.g gVar, s4.o oVar, int i2) {
        super(oVar, i2);
        this.m = gVar;
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.e, bVar)) {
            this.e = bVar;
            if (bVar instanceof a5.e) {
                a5.e eVar = (a5.e) bVar;
                int iD = eVar.d(7);
                if (iD == 1) {
                    this.j = 1;
                    this.f11105f = eVar;
                    this.h = true;
                    this.m.f(this);
                    return;
                }
                if (iD == 2) {
                    this.j = 2;
                    this.f11105f = eVar;
                    this.m.f(this);
                    bVar.c(this.f11102b);
                    return;
                }
            }
            this.f11105f = new h5.a(this.f11102b);
            this.m.f(this);
            bVar.c(this.f11102b);
        }
    }

    @Override // d5.i0
    public final void h() {
        s4.g gVar = this.m;
        a5.h hVar = this.f11105f;
        long j = this.k;
        int iAddAndGet = 1;
        while (true) {
            long jAddAndGet = this.f11104d.get();
            while (j != jAddAndGet) {
                boolean z2 = this.h;
                try {
                    Object objPoll = hVar.poll();
                    boolean z7 = objPoll == null;
                    if (g(z2, z7, gVar)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    gVar.b(objPoll);
                    j++;
                    if (j == this.f11103c) {
                        if (jAddAndGet != LocationRequestCompat.PASSIVE_INTERVAL) {
                            jAddAndGet = this.f11104d.addAndGet(-j);
                        }
                        this.e.c(j);
                        j = 0;
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    this.e.cancel();
                    hVar.clear();
                    gVar.onError(th);
                    this.f11101a.dispose();
                    return;
                }
            }
            if (j == jAddAndGet && g(this.h, hVar.isEmpty(), gVar)) {
                return;
            }
            int i2 = get();
            if (iAddAndGet == i2) {
                this.k = j;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i2;
            }
        }
    }

    @Override // d5.i0
    public final void i() {
        int iAddAndGet = 1;
        while (!this.g) {
            boolean z2 = this.h;
            this.m.b(null);
            if (z2) {
                Throwable th = this.f11106i;
                if (th != null) {
                    this.m.onError(th);
                } else {
                    this.m.onComplete();
                }
                this.f11101a.dispose();
                return;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // d5.i0
    public final void j() {
        s4.g gVar = this.m;
        a5.h hVar = this.f11105f;
        long j = this.k;
        int iAddAndGet = 1;
        while (true) {
            long j3 = this.f11104d.get();
            while (j != j3) {
                try {
                    Object objPoll = hVar.poll();
                    if (this.g) {
                        return;
                    }
                    if (objPoll == null) {
                        gVar.onComplete();
                        this.f11101a.dispose();
                        return;
                    } else {
                        gVar.b(objPoll);
                        j++;
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    this.e.cancel();
                    gVar.onError(th);
                    this.f11101a.dispose();
                    return;
                }
            }
            if (this.g) {
                return;
            }
            if (hVar.isEmpty()) {
                gVar.onComplete();
                this.f11101a.dispose();
                return;
            }
            int i2 = get();
            if (iAddAndGet == i2) {
                this.k = j;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                iAddAndGet = i2;
            }
        }
    }

    @Override // a5.h
    public final Object poll() {
        Object objPoll = this.f11105f.poll();
        if (objPoll != null && this.j != 1) {
            long j = this.k + 1;
            if (j == this.f11103c) {
                this.k = 0L;
                this.e.c(j);
                return objPoll;
            }
            this.k = j;
        }
        return objPoll;
    }
}
