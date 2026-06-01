package androidx.concurrent.futures;

import a.a;
import j2.q;
import java.util.concurrent.ExecutionException;
import kotlin.jvm.internal.k;
import q5.d;
import q6.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFutureKt {
    public static final <T> Object await(q qVar, c<? super T> cVar) throws Throwable {
        try {
            if (qVar.isDone()) {
                return AbstractResolvableFuture.getUninterruptibly(qVar);
            }
            l lVar = new l(1, a.I(cVar));
            qVar.addListener(new ToContinuation(qVar, lVar), DirectExecutor.INSTANCE);
            lVar.t(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(qVar));
            Object objP = lVar.p();
            w5.a aVar = w5.a.f17774a;
            return objP;
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause != null) {
            return cause;
        }
        d dVar = new d();
        k.i(dVar, k.class.getName());
        throw dVar;
    }
}
