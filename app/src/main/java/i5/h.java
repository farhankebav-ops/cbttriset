package i5;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends s4.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f12004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f12005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeUnit f12006d = TimeUnit.SECONDS;
    public static final g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f12007f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f12008a;

    static {
        g gVar = new g(new l("RxCachedThreadSchedulerShutdown"));
        e = gVar;
        gVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        l lVar = new l("RxCachedThreadScheduler", iMax, false);
        f12004b = lVar;
        f12005c = new l("RxCachedWorkerPoolEvictor", iMax, false);
        e eVar = new e(0L, null, lVar);
        f12007f = eVar;
        eVar.f11996c.dispose();
        ScheduledFuture scheduledFuture = eVar.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = eVar.f11997d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public h() {
        e eVar = f12007f;
        AtomicReference atomicReference = new AtomicReference(eVar);
        this.f12008a = atomicReference;
        e eVar2 = new e(60L, f12006d, f12004b);
        while (!atomicReference.compareAndSet(eVar, eVar2)) {
            if (atomicReference.get() != eVar) {
                eVar2.f11996c.dispose();
                ScheduledFuture scheduledFuture = eVar2.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = eVar2.f11997d;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    return;
                }
                return;
            }
        }
    }

    @Override // s4.p
    public final s4.o a() {
        return new f((e) this.f12008a.get());
    }
}
