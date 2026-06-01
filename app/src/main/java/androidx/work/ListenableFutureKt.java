package androidx.work;

import a.a;
import androidx.annotation.RestrictTo;
import j2.q;
import java.util.concurrent.ExecutionException;
import q6.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(q qVar, c<? super R> cVar) throws Throwable {
        if (qVar.isDone()) {
            try {
                return qVar.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        l lVar = new l(1, a.I(cVar));
        lVar.r();
        qVar.addListener(new ListenableFutureKt$await$2$1(lVar, qVar), DirectExecutor.INSTANCE);
        lVar.t(new ListenableFutureKt$await$2$2(qVar));
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(q qVar, c<? super R> cVar) throws Throwable {
        if (qVar.isDone()) {
            try {
                return qVar.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        l lVar = new l(1, a.I(cVar));
        lVar.r();
        qVar.addListener(new ListenableFutureKt$await$2$1(lVar, qVar), DirectExecutor.INSTANCE);
        lVar.t(new ListenableFutureKt$await$2$2(qVar));
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }
}
