package sg.bigo.ads.common.n;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends ThreadPoolExecutor implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f15835a;

    public e(String str, int i2, int i8) {
        super(i8, i2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str, false));
        this.f15835a = new AtomicInteger(0);
    }

    public static void a(a aVar) {
        c.a(aVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        this.f15835a.decrementAndGet();
        super.afterExecute(runnable, th);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        f.b(this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f15835a.incrementAndGet();
        super.execute(runnable);
    }

    public e(String str, int i2, boolean z2) {
        super(0, i2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str, z2));
        this.f15835a = new AtomicInteger(0);
    }
}
