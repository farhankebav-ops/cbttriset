package q4;

import i4.n1;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends i4.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f13473b;

    public q(r rVar) {
        this.f13473b = rVar;
    }

    @Override // i4.i
    public final void m(n1 n1Var) {
        k kVar = this.f13473b.f13474a;
        boolean zF = n1Var.f();
        o oVar = kVar.f13453a;
        if (oVar.e == null && oVar.f13470f == null) {
            return;
        }
        if (zF) {
            ((AtomicLong) kVar.f13454b.f3263b).getAndIncrement();
        } else {
            ((AtomicLong) kVar.f13454b.f3264c).getAndIncrement();
        }
    }
}
