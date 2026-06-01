package i5;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends s4.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f12033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f12034c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f12035a;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f12034c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f12033b = new l("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public r() {
        AtomicReference atomicReference = new AtomicReference();
        this.f12035a = atomicReference;
        boolean z2 = p.f12026a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, f12033b);
        if (p.f12026a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            p.f12029d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        atomicReference.lazySet(scheduledExecutorServiceNewScheduledThreadPool);
    }

    @Override // s4.p
    public final s4.o a() {
        return new q((ScheduledExecutorService) this.f12035a.get());
    }

    @Override // s4.p
    public final u4.b c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        AtomicReference atomicReference = this.f12035a;
        m mVar = new m(runnable);
        try {
            mVar.a(((ScheduledExecutorService) atomicReference.get()).submit(mVar));
            return mVar;
        } catch (RejectedExecutionException e) {
            n7.b.F(e);
            return y4.b.f17849a;
        }
    }
}
