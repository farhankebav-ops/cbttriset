package s4;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p {
    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract o a();

    public u4.b b(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return c(runnable);
    }

    public u4.b c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        o oVarA = a();
        n nVar = new n(runnable, oVarA);
        oVarA.a(nVar, timeUnit);
        return nVar;
    }
}
