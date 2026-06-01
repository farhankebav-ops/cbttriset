package v6;

import q6.c0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class r extends q6.a implements x5.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v5.c f17646d;

    public r(v5.c cVar, v5.h hVar) {
        super(hVar, true);
        this.f17646d = cVar;
    }

    @Override // q6.n1
    public final boolean L() {
        return true;
    }

    @Override // x5.d
    public final x5.d getCallerFrame() {
        v5.c cVar = this.f17646d;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // q6.n1
    public void r(Object obj) {
        a.h(c0.y(obj), a.a.I(this.f17646d));
    }

    @Override // q6.n1
    public void s(Object obj) {
        this.f17646d.resumeWith(c0.y(obj));
    }
}
