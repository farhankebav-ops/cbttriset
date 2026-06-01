package i5;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends AtomicReference implements Callable, u4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FutureTask f12017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FutureTask f12018d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f12019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f12020b;

    static {
        o oVar = z4.b.f17982b;
        f12017c = new FutureTask(oVar, null);
        f12018d = new FutureTask(oVar, null);
    }

    public m(Runnable runnable) {
        this.f12019a = runnable;
    }

    public final void a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == f12017c) {
                return;
            }
            if (future2 == f12018d) {
                future.cancel(this.f12020b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        FutureTask futureTask = f12017c;
        this.f12020b = Thread.currentThread();
        try {
            this.f12019a.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.f12020b = null;
        }
    }

    @Override // u4.b
    public final void dispose() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == f12017c || future == (futureTask = f12018d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f12020b != Thread.currentThread());
    }
}
