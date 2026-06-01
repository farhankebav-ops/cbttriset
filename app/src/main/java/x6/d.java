package x6;

import java.util.concurrent.Executor;
import q6.w;
import q6.x0;
import v6.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends x0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17810a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f17811b;

    static {
        l lVar = l.f17823a;
        int i2 = u.f17650a;
        if (64 >= i2) {
            i2 = 64;
        }
        f17811b = w.limitedParallelism$default(lVar, v6.a.j(i2, 12, "kotlinx.coroutines.io.parallelism"), null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        f17811b.dispatch(hVar, runnable);
    }

    @Override // q6.w
    public final void dispatchYield(v5.h hVar, Runnable runnable) {
        f17811b.dispatchYield(hVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(v5.i.f17610a, runnable);
    }

    @Override // q6.w
    public final w limitedParallelism(int i2, String str) {
        return l.f17823a.limitedParallelism(i2, str);
    }

    @Override // q6.w
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // q6.x0
    public final Executor o() {
        return this;
    }
}
