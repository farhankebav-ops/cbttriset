package j4;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w4 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f12534d = Logger.getLogger(w4.class.getName());
    public static final z4 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f12536b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f12537c = 0;

    static {
        z4 v4Var;
        try {
            v4Var = new u4(AtomicIntegerFieldUpdater.newUpdater(w4.class, "c"));
        } catch (Throwable th) {
            f12534d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            v4Var = new v4();
        }
        e = v4Var;
    }

    public w4(Executor executor) {
        r2.q.D(executor, "'executor' must not be null.");
        this.f12535a = executor;
    }

    public final void a(Runnable runnable) {
        z4 z4Var = e;
        if (z4Var.p(this)) {
            try {
                this.f12535a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f12536b.remove(runnable);
                }
                z4Var.q(this);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        r2.q.D(runnable, "'r' must not be null.");
        this.f12536b.add(runnable);
        a(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        z4 z4Var = e;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f12536b;
        while (true) {
            try {
                Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                if (runnable == null) {
                    break;
                }
                try {
                    runnable.run();
                } catch (RuntimeException e4) {
                    f12534d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e4);
                }
            } catch (Throwable th) {
                z4Var.q(this);
                throw th;
            }
        }
        z4Var.q(this);
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        a(null);
    }
}
