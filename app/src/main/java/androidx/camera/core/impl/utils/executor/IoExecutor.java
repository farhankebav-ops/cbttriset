package androidx.camera.core.impl.utils.executor;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class IoExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: androidx.camera.core.impl.utils.executor.IoExecutor.1
        private static final String THREAD_NAME_STEM = "CameraX-camerax_io_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Locale locale = Locale.US;
            thread.setName("CameraX-camerax_io_" + this.mThreadId.getAndIncrement());
            return thread;
        }
    });

    public static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (IoExecutor.class) {
            try {
                if (sExecutor == null) {
                    sExecutor = new IoExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sExecutor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mIoService.execute(runnable);
    }
}
