package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h1 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17448f;
    public final /* synthetic */ android.support.v4.media.g g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(android.support.v4.media.g gVar, v5.c cVar) {
        super(cVar);
        this.g = gVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f17448f = obj;
        this.h |= Integer.MIN_VALUE;
        this.g.collect(null, this);
        return w5.a.f17774a;
    }
}
