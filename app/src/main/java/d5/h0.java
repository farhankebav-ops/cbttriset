package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h0 extends j5.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.c f11098f;

    public h0(s4.g gVar, w3.a aVar) {
        super(gVar);
        this.f11098f = aVar;
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
            Object objApply = this.f11098f.apply(obj);
            z4.b.a(objApply, "The mapper function returned a null value.");
            gVar.b(objApply);
        } catch (Throwable th) {
            r2.q.y0(th);
            this.f12579b.cancel();
            onError(th);
        }
    }

    @Override // a5.h
    public final Object poll() {
        Object objPoll = this.f12580c.poll();
        if (objPoll == null) {
            return null;
        }
        Object objApply = this.f11098f.apply(objPoll);
        z4.b.a(objApply, "The mapper function returned a null value.");
        return objApply;
    }
}
