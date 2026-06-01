package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final v5.c<x> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(v5.c<? super x> cVar) {
        super(false);
        this.continuation = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(x.f13520a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
