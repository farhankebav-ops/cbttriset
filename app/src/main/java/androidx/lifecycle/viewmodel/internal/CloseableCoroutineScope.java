package androidx.lifecycle.viewmodel.internal;

import kotlin.jvm.internal.k;
import q6.a0;
import q6.e1;
import q6.f1;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScope implements AutoCloseable, a0 {
    private final h coroutineContext;

    public CloseableCoroutineScope(h coroutineContext) {
        k.e(coroutineContext, "coroutineContext");
        this.coroutineContext = coroutineContext;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        f1 f1Var = (f1) getCoroutineContext().get(e1.f13546a);
        if (f1Var != null) {
            f1Var.a(null);
        }
    }

    @Override // q6.a0
    public h getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableCoroutineScope(a0 coroutineScope) {
        this(coroutineScope.getCoroutineContext());
        k.e(coroutineScope, "coroutineScope");
    }
}
