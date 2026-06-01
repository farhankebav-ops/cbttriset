package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends j5.b implements a5.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.d f11155f;

    public w(s4.g gVar, x4.d dVar) {
        super(gVar);
        this.f11155f = dVar;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (e(obj)) {
            return;
        }
        this.f12579b.c(1L);
    }

    @Override // a5.a
    public final boolean e(Object obj) {
        if (this.f12581d) {
            return false;
        }
        int i2 = this.e;
        s4.g gVar = this.f12578a;
        if (i2 != 0) {
            gVar.b(null);
            return true;
        }
        try {
            boolean zTest = this.f11155f.test(obj);
            if (zTest) {
                gVar.b(obj);
            }
            return zTest;
        } catch (Throwable th) {
            r2.q.y0(th);
            this.f12579b.cancel();
            onError(th);
            return true;
        }
    }

    @Override // a5.h
    public final Object poll() {
        a5.e eVar = this.f12580c;
        while (true) {
            Object objPoll = eVar.poll();
            if (objPoll == null) {
                return null;
            }
            if (this.f11155f.test(objPoll)) {
                return objPoll;
            }
            if (this.e == 2) {
                eVar.c(1L);
            }
        }
    }
}
