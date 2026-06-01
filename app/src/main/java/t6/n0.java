package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class n0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17468f;
    public int g;
    public final /* synthetic */ w h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f17469i;
    public f j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(w wVar, v5.c cVar) {
        super(cVar);
        this.h = wVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17468f = obj;
        this.g |= Integer.MIN_VALUE;
        return this.h.emit(null, this);
    }
}
