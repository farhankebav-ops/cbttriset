package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f17493f;
    public f g;
    public y0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q6.f1 f17494i;
    public /* synthetic */ Object j;
    public final /* synthetic */ w0 k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(w0 w0Var, v5.c cVar) {
        super(cVar);
        this.k = w0Var;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.j = obj;
        this.l |= Integer.MIN_VALUE;
        w0.i(this.k, null, this);
        return w5.a.f17774a;
    }
}
