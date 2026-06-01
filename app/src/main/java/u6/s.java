package u6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements v5.c, x5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5.c f17564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v5.h f17565b;

    public s(v5.c cVar, v5.h hVar) {
        this.f17564a = cVar;
        this.f17565b = hVar;
    }

    @Override // x5.d
    public final x5.d getCallerFrame() {
        v5.c cVar = this.f17564a;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // v5.c
    public final v5.h getContext() {
        return this.f17565b;
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        this.f17564a.resumeWith(obj);
    }
}
