package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17419f;
    public final /* synthetic */ y g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(y yVar, v5.c cVar) {
        super(cVar);
        this.g = yVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17419f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.emit(null, this);
    }
}
