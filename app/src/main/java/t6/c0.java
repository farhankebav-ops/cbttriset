package t6;

/* JADX INFO: loaded from: classes5.dex */
public final class c0 extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f17421f;
    public int g;
    public final /* synthetic */ android.support.v4.media.g h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f17422i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(android.support.v4.media.g gVar, v5.c cVar) {
        super(cVar);
        this.h = gVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.f17421f = obj;
        this.g |= Integer.MIN_VALUE;
        return this.h.collect(null, this);
    }
}
