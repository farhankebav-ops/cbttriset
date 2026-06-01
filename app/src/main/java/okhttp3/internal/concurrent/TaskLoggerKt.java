package okhttp3.internal.concurrent;

import a1.a;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j <= -999500000 ? a.p(new StringBuilder(), (j - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ") : j <= -999500 ? a.p(new StringBuilder(), (j - ((long) 500000)) / ((long) 1000000), " ms") : j <= 0 ? a.p(new StringBuilder(), (j - ((long) 500)) / ((long) 1000), " µs") : j < 999500 ? a.p(new StringBuilder(), (j + ((long) 500)) / ((long) 1000), " µs") : j < 999500000 ? a.p(new StringBuilder(), (j + ((long) 500000)) / ((long) 1000000), " ms") : a.p(new StringBuilder(), (j + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS), " s ")}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        logger.fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Logger logger, Task task, TaskQueue queue, e6.a block) {
        long jNanoTime;
        k.e(logger, "<this>");
        k.e(task, "task");
        k.e(queue, "queue");
        k.e(block, "block");
        boolean zIsLoggable = logger.isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(logger, task, queue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T t3 = (T) block.invoke();
            if (zIsLoggable) {
                log(logger, task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
            return t3;
        } catch (Throwable th) {
            if (zIsLoggable) {
                log(logger, task, queue, "failed a run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
            throw th;
        }
    }

    public static final void taskLog(Logger logger, Task task, TaskQueue queue, e6.a messageBlock) {
        k.e(logger, "<this>");
        k.e(task, "task");
        k.e(queue, "queue");
        k.e(messageBlock, "messageBlock");
        if (logger.isLoggable(Level.FINE)) {
            log(logger, task, queue, (String) messageBlock.invoke());
        }
    }
}
