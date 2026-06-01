package sg.bigo.ads.common.h.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
class c extends ThreadPoolExecutor implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f15765a;

    private c(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(5, 8, 3000L, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    public static synchronized c a(boolean z2) {
        try {
            if (f15765a == null) {
                synchronized (c.class) {
                    try {
                        if (f15765a == null) {
                            b(z2);
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15765a;
    }

    private static synchronized void b(boolean z2) {
        f15765a = new c(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new sg.bigo.ads.common.n.c("Download", z2), new ThreadPoolExecutor.AbortPolicy());
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        androidx.appcompat.app.c.v(this);
    }
}
