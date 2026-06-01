package j4;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t4 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f12480c = Logger.getLogger(t4.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f12482b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f12482b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f12480c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        r2.q.D(runnable, "'task' must not be null.");
        if (this.f12481a) {
            if (this.f12482b == null) {
                this.f12482b = new ArrayDeque(4);
            }
            this.f12482b.add(runnable);
            return;
        }
        this.f12481a = true;
        try {
            runnable.run();
        } catch (Throwable th) {
            try {
                f12480c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
                if (this.f12482b != null) {
                    a();
                }
                this.f12481a = false;
            } finally {
                if (this.f12482b != null) {
                    a();
                }
                this.f12481a = false;
            }
        }
    }
}
