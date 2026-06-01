package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y f17501f;
    public Object g;
    public /* synthetic */ Object h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ y f17502i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar, v5.c cVar) {
        super(cVar);
        this.f17502i = yVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= Integer.MIN_VALUE;
        return this.f17502i.emit(null, this);
    }
}
