package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c1 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d1 f17423f;
    public f g;
    public e1 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q6.f1 f17424i;
    public Object j;
    public /* synthetic */ Object k;
    public final /* synthetic */ d1 l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(d1 d1Var, v5.c cVar) {
        super(cVar);
        this.l = d1Var;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.k = obj;
        this.m |= Integer.MIN_VALUE;
        this.l.collect(null, this);
        return w5.a.f17774a;
    }
}
