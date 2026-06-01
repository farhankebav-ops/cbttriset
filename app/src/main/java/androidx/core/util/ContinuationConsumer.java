package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {
    private final v5.c<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(v5.c<? super T> cVar) {
        super(false);
        this.continuation = cVar;
    }

    @Override // java.util.function.Consumer
    public void accept(T t3) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t3);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
