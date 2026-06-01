package q6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 extends x0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13602a;

    public y0(Executor executor) {
        this.f13602a = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f13602a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        try {
            this.f13602a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            f1 f1Var = (f1) hVar.get(e1.f13546a);
            if (f1Var != null) {
                f1Var.a(cancellationException);
            }
            x6.e eVar = m0.f13566a;
            x6.d.f17810a.dispatch(hVar, runnable);
        }
    }

    @Override // q6.h0
    public final o0 e(long j, Runnable runnable, v5.h hVar) {
        Executor executor = this.f13602a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                f1 f1Var = (f1) hVar.get(e1.f13546a);
                if (f1Var != null) {
                    f1Var.a(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new n0(scheduledFutureSchedule) : d0.h.e(j, runnable, hVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y0) && ((y0) obj).f13602a == this.f13602a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f13602a);
    }

    @Override // q6.h0
    public final void l(long j, l lVar) {
        Executor executor = this.f13602a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            com.unity3d.scar.adapter.common.i iVar = new com.unity3d.scar.adapter.common.i(3, this, lVar, false);
            v5.h hVar = lVar.e;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(iVar, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                f1 f1Var = (f1) hVar.get(e1.f13546a);
                if (f1Var != null) {
                    f1Var.a(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            lVar.u(new h(scheduledFutureSchedule, 0));
        } else {
            d0.h.l(j, lVar);
        }
    }

    @Override // q6.x0
    public final Executor o() {
        return this.f13602a;
    }

    @Override // q6.w
    public final String toString() {
        return this.f13602a.toString();
    }
}
