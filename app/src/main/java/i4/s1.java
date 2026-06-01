package i4;

import java.lang.Thread;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f11951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f11952b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f11953c = new AtomicReference();

    public s1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f11951a = uncaughtExceptionHandler;
    }

    public final void a() {
        AtomicReference atomicReference;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f11952b;
        do {
            Thread threadCurrentThread = Thread.currentThread();
            do {
                atomicReference = this.f11953c;
                if (atomicReference.compareAndSet(null, threadCurrentThread)) {
                    while (true) {
                        try {
                            Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                            if (runnable == null) {
                                break;
                            }
                            try {
                                runnable.run();
                            } catch (Throwable th) {
                                this.f11951a.uncaughtException(Thread.currentThread(), th);
                            }
                        } catch (Throwable th2) {
                            atomicReference.set(null);
                            throw th2;
                        }
                    }
                    atomicReference.set(null);
                }
            } while (atomicReference.get() == null);
            return;
        } while (!concurrentLinkedQueue.isEmpty());
    }

    public final void b(Runnable runnable) {
        r2.q.D(runnable, "runnable is null");
        this.f11952b.add(runnable);
    }

    public final android.support.v4.media.g c(Runnable runnable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        r1 r1Var = new r1(runnable);
        return new android.support.v4.media.g(r1Var, scheduledExecutorService.schedule(new a4.b(this, r1Var, runnable, 3), j, timeUnit));
    }

    public final void d() {
        r2.q.H(Thread.currentThread() == this.f11953c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
