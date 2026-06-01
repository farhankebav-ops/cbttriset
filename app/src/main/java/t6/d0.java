package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class d0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f17429f;
    public /* synthetic */ Object g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ w f17430i;
    public Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(w wVar, v5.c cVar) {
        super(cVar);
        this.f17430i = wVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.h |= Integer.MIN_VALUE;
        return this.f17430i.emit(null, this);
    }
}
