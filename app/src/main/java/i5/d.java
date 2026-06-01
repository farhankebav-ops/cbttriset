package i5;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends s4.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f11990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f11991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11992d;
    public static final c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f11993a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        f11992d = iAvailableProcessors;
        c cVar = new c(new l("RxComputationShutdown"));
        e = cVar;
        cVar.dispose();
        l lVar = new l("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f11991c = lVar;
        b bVar = new b(0, lVar);
        f11990b = bVar;
        for (c cVar2 : bVar.f11988b) {
            cVar2.dispose();
        }
    }

    public d() {
        b bVar = f11990b;
        AtomicReference atomicReference = new AtomicReference(bVar);
        this.f11993a = atomicReference;
        b bVar2 = new b(f11992d, f11991c);
        while (!atomicReference.compareAndSet(bVar, bVar2)) {
            if (atomicReference.get() != bVar) {
                c[] cVarArr = bVar2.f11988b;
                for (c cVar : cVarArr) {
                    cVar.dispose();
                }
                return;
            }
        }
    }

    @Override // s4.p
    public final s4.o a() {
        c cVar;
        b bVar = (b) this.f11993a.get();
        int i2 = bVar.f11987a;
        if (i2 == 0) {
            cVar = e;
        } else {
            c[] cVarArr = bVar.f11988b;
            long j = bVar.f11989c;
            bVar.f11989c = 1 + j;
            cVar = cVarArr[(int) (j % ((long) i2))];
        }
        return new a(cVar);
    }

    @Override // s4.p
    public final u4.b c(Runnable runnable) {
        c cVar;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        b bVar = (b) this.f11993a.get();
        int i2 = bVar.f11987a;
        if (i2 == 0) {
            cVar = e;
        } else {
            c[] cVarArr = bVar.f11988b;
            long j = bVar.f11989c;
            bVar.f11989c = 1 + j;
            cVar = cVarArr[(int) (j % ((long) i2))];
        }
        ScheduledExecutorService scheduledExecutorService = cVar.f12011a;
        m mVar = new m(runnable);
        try {
            mVar.a(scheduledExecutorService.submit(mVar));
            return mVar;
        } catch (RejectedExecutionException e4) {
            n7.b.F(e4);
            return y4.b.f17849a;
        }
    }
}
