package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class m0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17465f;
    public int g;
    public final /* synthetic */ l h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(l lVar, v5.c cVar) {
        super(cVar);
        this.h = lVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17465f = obj;
        this.g |= Integer.MIN_VALUE;
        return this.h.emit(null, this);
    }
}
