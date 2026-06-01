package q6;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q1 extends v5.a implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f13579a = new q1(e1.f13546a);

    @Override // q6.f1
    public final CancellationException g() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // q6.f1
    public final o0 i(boolean z2, boolean z7, i1 i1Var) {
        return r1.f13582a;
    }

    @Override // q6.f1
    public final boolean isActive() {
        return true;
    }

    @Override // q6.f1
    public final boolean isCancelled() {
        return false;
    }

    @Override // q6.f1
    public final o k(n1 n1Var) {
        return r1.f13582a;
    }

    @Override // q6.f1
    public final o0 n(e6.l lVar) {
        return r1.f13582a;
    }

    @Override // q6.f1
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // q6.f1
    public final void a(CancellationException cancellationException) {
    }
}
