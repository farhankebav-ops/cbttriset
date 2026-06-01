package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends j5.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.b f11122f;
    public final x4.b g;
    public final x4.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x4.a f11123i;

    public n(a5.a aVar, com.google.firebase.inappmessaging.internal.j jVar, w1.f fVar, r4.c cVar, r4.c cVar2) {
        super(aVar);
        this.f11122f = jVar;
        this.g = fVar;
        this.h = cVar;
        this.f11123i = cVar2;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.f12577d) {
            return;
        }
        int i2 = this.e;
        a5.a aVar = this.f12574a;
        if (i2 != 0) {
            aVar.b(null);
            return;
        }
        try {
            this.f11122f.accept(obj);
            aVar.b(obj);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // a5.a
    public final boolean e(Object obj) {
        if (this.f12577d) {
            return false;
        }
        try {
            this.f11122f.accept(obj);
            return this.f12574a.e(obj);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    @Override // j5.a, s4.g
    public final void onComplete() {
        if (this.f12577d) {
            return;
        }
        try {
            this.h.run();
            this.f12577d = true;
            this.f12574a.onComplete();
            try {
                this.f11123i.run();
            } catch (Throwable th) {
                r2.q.y0(th);
                n7.b.F(th);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    @Override // j5.a, s4.g
    public final void onError(Throwable th) {
        a5.a aVar = this.f12574a;
        if (this.f12577d) {
            n7.b.F(th);
            return;
        }
        this.f12577d = true;
        try {
            this.g.accept(th);
            aVar.onError(th);
        } catch (Throwable th2) {
            r2.q.y0(th2);
            aVar.onError(new v4.b(th, th2));
        }
        try {
            this.f11123i.run();
        } catch (Throwable th3) {
            r2.q.y0(th3);
            n7.b.F(th3);
        }
    }

    @Override // a5.h
    public final Object poll() throws Exception {
        x4.b bVar = this.g;
        try {
            Object objPoll = this.f12576c.poll();
            x4.a aVar = this.f11123i;
            if (objPoll == null) {
                if (this.e == 1) {
                    this.h.run();
                    aVar.run();
                }
                return objPoll;
            }
            try {
                this.f11122f.accept(objPoll);
                aVar.run();
                return objPoll;
            } catch (Throwable th) {
                try {
                    r2.q.y0(th);
                    try {
                        bVar.accept(th);
                        j2.b bVar2 = l5.c.f12823a;
                        if (th instanceof Exception) {
                            throw th;
                        }
                        throw th;
                    } catch (Throwable th2) {
                        throw new v4.b(th, th2);
                    }
                } catch (Throwable th3) {
                    aVar.run();
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            r2.q.y0(th4);
            try {
                bVar.accept(th4);
                j2.b bVar3 = l5.c.f12823a;
                if (th4 instanceof Exception) {
                    throw th4;
                }
                throw th4;
            } catch (Throwable th5) {
                throw new v4.b(th4, th5);
            }
        }
    }
}
