package i5;

import d5.i0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class j extends s4.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f12012b;

    public j(ThreadFactory threadFactory) {
        boolean z2 = p.f12026a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (p.f12026a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            p.f12029d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.f12011a = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // s4.o
    public final u4.b a(Runnable runnable, TimeUnit timeUnit) {
        return this.f12012b ? y4.b.f17849a : c(runnable, timeUnit, null);
    }

    @Override // s4.o
    public final void b(i0 i0Var) {
        a(i0Var, null);
    }

    public final n c(Runnable runnable, TimeUnit timeUnit, u4.a aVar) {
        ScheduledExecutorService scheduledExecutorService = this.f12011a;
        n nVar = new n(runnable, aVar);
        if (aVar != null && !aVar.a(nVar)) {
            return nVar;
        }
        try {
            nVar.a(scheduledExecutorService.submit((Callable) nVar));
            return nVar;
        } catch (RejectedExecutionException e) {
            if (aVar != null) {
                aVar.f(nVar);
            }
            n7.b.F(e);
            return nVar;
        }
    }

    @Override // u4.b
    public final void dispose() {
        if (this.f12012b) {
            return;
        }
        this.f12012b = true;
        this.f12011a.shutdownNow();
    }
}
