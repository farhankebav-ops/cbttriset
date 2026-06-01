package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 implements q6.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f17487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.l f17490d;

    public u0(w0 w0Var, long j, Object obj, q6.l lVar) {
        this.f17487a = w0Var;
        this.f17488b = j;
        this.f17489c = obj;
        this.f17490d = lVar;
    }

    @Override // q6.o0
    public final void dispose() {
        w0 w0Var = this.f17487a;
        synchronized (w0Var) {
            if (this.f17488b < w0Var.m()) {
                return;
            }
            Object[] objArr = w0Var.g;
            kotlin.jvm.internal.k.b(objArr);
            long j = this.f17488b;
            if (objArr[((int) j) & (objArr.length - 1)] != this) {
                return;
            }
            x0.f(objArr, j, x0.f17503a);
            w0Var.h();
        }
    }
}
