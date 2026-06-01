package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u6.o f17412f;
    public /* synthetic */ Object g;
    public final /* synthetic */ a4.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17413i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a4.a aVar, v5.c cVar) {
        super(cVar);
        this.h = aVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.f17413i |= Integer.MIN_VALUE;
        return this.h.collect(null, this);
    }
}
