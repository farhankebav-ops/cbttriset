package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17414f;
    public int g;
    public final /* synthetic */ a4.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f17415i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(a4.a aVar, v5.c cVar) {
        super(cVar);
        this.h = aVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17414f = obj;
        this.g |= Integer.MIN_VALUE;
        return this.h.collect(null, this);
    }
}
