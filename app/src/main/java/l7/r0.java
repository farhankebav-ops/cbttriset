package l7;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class r0 {
    public static final q0 Companion = new q0();
    public static final r0 NONE = new p0();
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public void awaitSignal(Condition condition) throws InterruptedIOException {
        kotlin.jvm.internal.k.e(condition, "condition");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(jTimeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public r0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public r0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final r0 deadline(long j, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        if (j <= 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("duration <= 0: ", j).toString());
        }
        return deadlineNanoTime(unit.toNanos(j) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(r0 other, e6.a block) {
        kotlin.jvm.internal.k.e(other, "other");
        kotlin.jvm.internal.k.e(block, "block");
        long jTimeoutNanos = timeoutNanos();
        q0 q0Var = Companion;
        long jTimeoutNanos2 = other.timeoutNanos();
        long jTimeoutNanos3 = timeoutNanos();
        q0Var.getClass();
        if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
            jTimeoutNanos2 = jTimeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jTimeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                T t3 = (T) block.invoke();
                timeout(jTimeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                return t3;
            } catch (Throwable th) {
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                throw th;
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (other.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
        }
        try {
            T t7 = (T) block.invoke();
            timeout(jTimeoutNanos, timeUnit);
            if (other.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            return t7;
        } catch (Throwable th2) {
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public r0 timeout(long j, TimeUnit unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("timeout < 0: ", j).toString());
        }
        this.timeoutNanos = unit.toNanos(j);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.k.e(monitor, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            if (!zHasDeadline && jTimeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime;
            }
            if (jTimeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            long j = jTimeoutNanos / 1000000;
            Long.signum(j);
            monitor.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
            if (System.nanoTime() - jNanoTime >= jTimeoutNanos && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public r0 deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
