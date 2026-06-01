package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f17491f;
    public /* synthetic */ Object g;
    public final /* synthetic */ w h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17492i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, v5.c cVar) {
        super(cVar);
        this.h = wVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f17492i |= Integer.MIN_VALUE;
        return this.h.emit(null, this);
    }
}
