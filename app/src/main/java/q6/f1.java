package q6;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface f1 extends v5.f {
    void a(CancellationException cancellationException);

    CancellationException g();

    o0 i(boolean z2, boolean z7, i1 i1Var);

    boolean isActive();

    boolean isCancelled();

    o k(n1 n1Var);

    o0 n(e6.l lVar);

    boolean start();
}
