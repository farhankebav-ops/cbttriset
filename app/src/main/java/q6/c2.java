package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c2 extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f13539a = new c2();

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        g2 g2Var = (g2) hVar.get(g2.f13550b);
        if (g2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        g2Var.f13551a = true;
    }

    @Override // q6.w
    public final w limitedParallelism(int i2, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // q6.w
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
