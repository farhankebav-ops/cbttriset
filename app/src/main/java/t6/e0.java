package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class e0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f0 f17432f;
    public /* synthetic */ Object g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f0 f17433i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(f0 f0Var, v5.c cVar) {
        super(cVar);
        this.f17433i = f0Var;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.h |= Integer.MIN_VALUE;
        return this.f17433i.emit(null, this);
    }
}
