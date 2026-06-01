package y6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f17860f;
    public /* synthetic */ Object g;
    public final /* synthetic */ e h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17861i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, x5.c cVar) {
        super(cVar);
        this.h = eVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f17861i |= Integer.MIN_VALUE;
        return this.h.d(this);
    }
}
