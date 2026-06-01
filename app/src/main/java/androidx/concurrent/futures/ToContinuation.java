package androidx.concurrent.futures;

import j2.q;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.k;
import q6.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ToContinuation<T> implements Runnable {
    private final j continuation;
    private final q futureToObserve;

    public ToContinuation(q qVar, j jVar) {
        if (qVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(k.h("futureToObserve"));
            k.i(illegalArgumentException, k.class.getName());
            throw illegalArgumentException;
        }
        if (jVar != null) {
            this.futureToObserve = qVar;
            this.continuation = jVar;
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(k.h("continuation"));
            k.i(illegalArgumentException2, k.class.getName());
            throw illegalArgumentException2;
        }
    }

    public final j getContinuation() {
        return this.continuation;
    }

    public final q getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.futureToObserve.isCancelled()) {
            this.continuation.e(null);
            return;
        }
        try {
            this.continuation.resumeWith(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve));
        } catch (ExecutionException e) {
            this.continuation.resumeWith(r2.q.M(ListenableFutureKt.nonNullCause(e)));
        }
    }
}
