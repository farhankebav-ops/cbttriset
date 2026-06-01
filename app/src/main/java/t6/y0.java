package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 extends u6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q6.l f17511b;

    @Override // u6.d
    public final boolean a(u6.b bVar) {
        w0 w0Var = (w0) bVar;
        if (this.f17510a >= 0) {
            return false;
        }
        long j = w0Var.h;
        if (j < w0Var.f17500i) {
            w0Var.f17500i = j;
        }
        this.f17510a = j;
        return true;
    }

    @Override // u6.d
    public final v5.c[] b(u6.b bVar) {
        long j = this.f17510a;
        this.f17510a = -1L;
        this.f17511b = null;
        return ((w0) bVar).s(j);
    }
}
