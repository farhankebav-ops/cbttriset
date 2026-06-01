package l7;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final void a(c cVar, f fVar, long j, boolean z2) {
        cVar.getClass();
        if (f.head == null) {
            f.head = new f();
            i5.k kVar = new i5.k("Okio Watchdog");
            kVar.setDaemon(true);
            kVar.start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z2) {
            fVar.timeoutAt = Math.min(j, fVar.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            fVar.timeoutAt = j + jNanoTime;
        } else {
            if (!z2) {
                throw new AssertionError();
            }
            fVar.timeoutAt = fVar.deadlineNanoTime();
        }
        long jAccess$remainingNanos = f.access$remainingNanos(fVar, jNanoTime);
        f fVar2 = f.head;
        kotlin.jvm.internal.k.b(fVar2);
        while (fVar2.next != null) {
            f fVar3 = fVar2.next;
            kotlin.jvm.internal.k.b(fVar3);
            if (jAccess$remainingNanos < f.access$remainingNanos(fVar3, jNanoTime)) {
                break;
            }
            fVar2 = fVar2.next;
            kotlin.jvm.internal.k.b(fVar2);
        }
        fVar.next = fVar2.next;
        fVar2.next = fVar;
        if (fVar2 == f.head) {
            f.condition.signal();
        }
    }

    public static final void b(c cVar, f fVar) {
        cVar.getClass();
        for (f fVar2 = f.head; fVar2 != null; fVar2 = fVar2.next) {
            if (fVar2.next == fVar) {
                fVar2.next = fVar.next;
                fVar.next = null;
                return;
            }
        }
        throw new IllegalStateException("node was not found in the queue");
    }

    public static f c() throws InterruptedException {
        f fVar = f.head;
        kotlin.jvm.internal.k.b(fVar);
        f fVar2 = fVar.next;
        if (fVar2 == null) {
            long jNanoTime = System.nanoTime();
            f.condition.await(f.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            f fVar3 = f.head;
            kotlin.jvm.internal.k.b(fVar3);
            if (fVar3.next != null || System.nanoTime() - jNanoTime < f.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return f.head;
        }
        long jAccess$remainingNanos = f.access$remainingNanos(fVar2, System.nanoTime());
        if (jAccess$remainingNanos > 0) {
            f.condition.await(jAccess$remainingNanos, TimeUnit.NANOSECONDS);
            return null;
        }
        f fVar4 = f.head;
        kotlin.jvm.internal.k.b(fVar4);
        fVar4.next = fVar2.next;
        fVar2.next = null;
        fVar2.state = 2;
        return fVar2;
    }
}
