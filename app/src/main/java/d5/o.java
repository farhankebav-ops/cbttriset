package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends j5.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.b f11126f;
    public final x4.b g;
    public final x4.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x4.a f11127i;

    public o(s4.g gVar, com.google.firebase.inappmessaging.internal.j jVar, w1.f fVar, r4.c cVar, r4.c cVar2) {
        super(gVar);
        this.f11126f = jVar;
        this.g = fVar;
        this.h = cVar;
        this.f11127i = cVar2;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.f12581d) {
            return;
        }
        int i2 = this.e;
        s4.g gVar = this.f12578a;
        if (i2 != 0) {
            gVar.b(null);
            return;
        }
        try {
            this.f11126f.accept(obj);
            gVar.b(obj);
        } catch (Throwable th) {
            r2.q.y0(th);
            this.f12579b.cancel();
            onError(th);
        }
    }

    @Override // j5.b, s4.g
    public final void onComplete() {
        if (this.f12581d) {
            return;
        }
        try {
            this.h.run();
            this.f12581d = true;
            this.f12578a.onComplete();
            try {
                this.f11127i.run();
            } catch (Throwable th) {
                r2.q.y0(th);
                n7.b.F(th);
            }
        } catch (Throwable th2) {
            r2.q.y0(th2);
            this.f12579b.cancel();
            onError(th2);
        }
    }

    @Override // j5.b, s4.g
    public final void onError(Throwable th) {
        s4.g gVar = this.f12578a;
        if (this.f12581d) {
            n7.b.F(th);
            return;
        }
        this.f12581d = true;
        try {
            this.g.accept(th);
            gVar.onError(th);
        } catch (Throwable th2) {
            r2.q.y0(th2);
            gVar.onError(new v4.b(th, th2));
        }
        try {
            this.f11127i.run();
        } catch (Throwable th3) {
            r2.q.y0(th3);
            n7.b.F(th3);
        }
    }

    @Override // a5.h
    public final Object poll() throws Exception {
        x4.b bVar = this.g;
        try {
            Object objPoll = this.f12580c.poll();
            x4.a aVar = this.f11127i;
            if (objPoll == null) {
                if (this.e == 1) {
                    this.h.run();
                    aVar.run();
                }
                return objPoll;
            }
            try {
                this.f11126f.accept(objPoll);
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
