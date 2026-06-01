package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f13728f;
    public final /* synthetic */ h g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, x5.c cVar) {
        super(cVar);
        this.g = hVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f13728f = obj;
        this.h |= Integer.MIN_VALUE;
        Object objD = h.D(this.g, this);
        return objD == w5.a.f17774a ? objD : new o(objD);
    }
}
