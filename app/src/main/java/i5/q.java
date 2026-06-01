package i5;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends s4.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.a f12031b = new u4.a(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f12032c;

    public q(ScheduledExecutorService scheduledExecutorService) {
        this.f12030a = scheduledExecutorService;
    }

    @Override // s4.o
    public final u4.b a(Runnable runnable, TimeUnit timeUnit) {
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        y4.b bVar = y4.b.f17849a;
        if (this.f12032c) {
            return bVar;
        }
        n nVar = new n(runnable, this.f12031b);
        this.f12031b.a(nVar);
        try {
            nVar.a(this.f12030a.submit((Callable) nVar));
            return nVar;
        } catch (RejectedExecutionException e) {
            dispose();
            n7.b.F(e);
            return bVar;
        }
    }

    @Override // u4.b
    public final void dispose() {
        if (this.f12032c) {
            return;
        }
        this.f12032c = true;
        this.f12031b.dispose();
    }
}
