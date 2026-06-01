package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 extends i0 {
    public final a5.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11110n;

    public j0(a5.a aVar, s4.o oVar, int i2) {
        super(oVar, i2);
        this.m = aVar;
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
        a5.a aVar = this.m;
        a5.h hVar = this.f11105f;
        long j = this.k;
        long j3 = this.f11110n;
        int iAddAndGet = 1;
        while (true) {
            long j8 = this.f11104d.get();
            while (j != j8) {
                boolean z2 = this.h;
                try {
                    Object objPoll = hVar.poll();
                    boolean z7 = objPoll == null;
                    if (g(z2, z7, aVar)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    if (aVar.e(objPoll)) {
                        j++;
                    }
                    j3++;
                    if (j3 == this.f11103c) {
                        this.e.c(j3);
                        j3 = 0;
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    this.e.cancel();
                    hVar.clear();
                    aVar.onError(th);
                    this.f11101a.dispose();
                    return;
                }
            }
            if (j == j8 && g(this.h, hVar.isEmpty(), aVar)) {
                return;
            }
            int i2 = get();
            if (iAddAndGet == i2) {
                this.k = j;
                this.f11110n = j3;
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
        a5.a aVar = this.m;
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
                        aVar.onComplete();
                        this.f11101a.dispose();
                        return;
                    } else if (aVar.e(objPoll)) {
                        j++;
                    }
                } catch (Throwable th) {
                    r2.q.y0(th);
                    this.e.cancel();
                    aVar.onError(th);
                    this.f11101a.dispose();
                    return;
                }
            }
            if (this.g) {
                return;
            }
            if (hVar.isEmpty()) {
                aVar.onComplete();
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
            long j = this.f11110n + 1;
            if (j == this.f11103c) {
                this.f11110n = 0L;
                this.e.c(j);
                return objPoll;
            }
            this.f11110n = j;
        }
        return objPoll;
    }
}
