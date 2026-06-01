package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class t extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17484f;
    public int g;
    public final /* synthetic */ s h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f17485i;
    public f j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, v5.c cVar) {
        super(cVar);
        this.h = sVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17484f = obj;
        this.g |= Integer.MIN_VALUE;
        return this.h.collect(null, this);
    }
}
