package androidx.work;

import j2.q;
import java.util.concurrent.CancellationException;
import q6.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ j $cancellableContinuation;
    final /* synthetic */ q $this_await;

    public ListenableFutureKt$await$2$1(j jVar, q qVar) {
        this.$cancellableContinuation = jVar;
        this.$this_await = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.$cancellableContinuation.resumeWith(this.$this_await.get());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.e(cause);
            } else {
                this.$cancellableContinuation.resumeWith(r2.q.M(cause));
            }
        }
    }
}
