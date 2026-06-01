package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s6.x f17417f;
    public /* synthetic */ Object g;
    public final /* synthetic */ c h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17418i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, x5.c cVar2) {
        super(cVar2);
        this.h = cVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f17418i |= Integer.MIN_VALUE;
        return this.h.b(null, this);
    }
}
