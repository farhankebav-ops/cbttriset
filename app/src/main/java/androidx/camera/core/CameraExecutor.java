package androidx.camera.core;

import android.os.Process;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CameraExecutor implements Executor {
    private static final int CAMERA_THREAD_JAVA_PRIORITY = 7;
    private static final int CAMERA_THREAD_PROCESS_PRIORITY = -3;
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final String TAG = "CameraExecutor";
    private static final ThreadFactory THREAD_FACTORY = new AnonymousClass1();
    private final Object mExecutorLock = new Object();

    @GuardedBy("mExecutorLock")
    private ThreadPoolExecutor mThreadPoolExecutor = createExecutor();

    /* JADX INFO: renamed from: androidx.camera.core.CameraExecutor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements ThreadFactory {
        private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$newThread$0(Runnable runnable) {
            Process.setThreadPriority(-3);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(new f(runnable, 0));
            thread.setPriority(7);
            Locale locale = Locale.US;
            thread.setName("CameraX-core_camera_" + this.mThreadId.getAndIncrement());
            return thread;
        }
    }

    private static ThreadPoolExecutor createExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        threadPoolExecutor.setRejectedExecutionHandler(new e());
        return threadPoolExecutor;
    }

    public void deinit() {
        synchronized (this.mExecutorLock) {
            try {
                if (!this.mThreadPoolExecutor.isShutdown()) {
                    this.mThreadPoolExecutor.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.mExecutorLock) {
            this.mThreadPoolExecutor.execute(runnable);
        }
    }

    public void init(CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull(cameraFactory);
        synchronized (this.mExecutorLock) {
            try {
                if (this.mThreadPoolExecutor.isShutdown()) {
                    this.mThreadPoolExecutor = createExecutor();
                }
                threadPoolExecutor = this.mThreadPoolExecutor;
            } catch (Throwable th) {
                throw th;
            }
        }
        int iMax = Math.max(1, cameraFactory.getAvailableCameraIds().size());
        threadPoolExecutor.setMaximumPoolSize(iMax);
        threadPoolExecutor.setCorePoolSize(iMax);
    }
}
