package p4;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends ConcurrentLinkedQueue implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f13327b = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f13328c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f13329a;

    public final void a() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Runnable runnable = (Runnable) poll();
        if (runnable == null) {
            this.f13329a = Thread.currentThread();
            do {
                try {
                    Runnable runnable2 = (Runnable) poll();
                    if (runnable2 == null) {
                        LockSupport.park(this);
                    } else {
                        this.f13329a = null;
                        runnable = runnable2;
                    }
                } catch (Throwable th) {
                    this.f13329a = null;
                    throw th;
                }
            } while (!Thread.interrupted());
            throw new InterruptedException();
        }
        do {
            try {
                runnable.run();
            } catch (Throwable th2) {
                f13327b.log(Level.WARNING, "Runnable threw exception", th2);
            }
            runnable = (Runnable) poll();
        } while (runnable != null);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        add(runnable);
        Object obj = this.f13329a;
        if (obj != f13328c) {
            LockSupport.unpark((Thread) obj);
        } else if (remove(runnable) && e.f13334b) {
            throw new RejectedExecutionException();
        }
    }

    public final void shutdown() {
        this.f13329a = f13328c;
        while (true) {
            Runnable runnable = (Runnable) poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f13327b.log(Level.WARNING, "Runnable threw exception", th);
            }
        }
    }
}
