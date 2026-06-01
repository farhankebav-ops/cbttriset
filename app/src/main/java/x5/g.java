package x5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g extends a {
    public g(v5.c cVar) {
        super(cVar);
        if (cVar != null && cVar.getContext() != v5.i.f17610a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // v5.c
    public v5.h getContext() {
        return v5.i.f17610a;
    }
}
