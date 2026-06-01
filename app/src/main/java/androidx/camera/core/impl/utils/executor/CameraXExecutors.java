package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraXExecutors {
    private CameraXExecutors() {
    }

    public static Executor audioExecutor() {
        return AudioExecutor.getInstance();
    }

    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    public static boolean isSequentialExecutor(Executor executor) {
        return executor instanceof SequentialExecutor;
    }

    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }

    public static ScheduledExecutorService newHandlerExecutor(Handler handler) {
        return new HandlerScheduledExecutorService(handler);
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
