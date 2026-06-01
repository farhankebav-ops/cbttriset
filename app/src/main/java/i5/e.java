package i5;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f11995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u4.a f11996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f11997d;
    public final ScheduledFuture e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ThreadFactory f11998f;

    public e(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        e eVar;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
        this.f11994a = nanos;
        this.f11995b = new ConcurrentLinkedQueue();
        this.f11996c = new u4.a(0);
        this.f11998f = threadFactory;
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, h.f12005c);
            eVar = this;
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(eVar, nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            eVar = this;
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        eVar.f11997d = scheduledExecutorServiceNewScheduledThreadPool;
        eVar.e = scheduledFutureScheduleWithFixedDelay;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue<g> concurrentLinkedQueue = this.f11995b;
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        for (g gVar : concurrentLinkedQueue) {
            if (gVar.f12003c > jNanoTime) {
                return;
            }
            if (concurrentLinkedQueue.remove(gVar)) {
                this.f11996c.f(gVar);
            }
        }
    }
}
