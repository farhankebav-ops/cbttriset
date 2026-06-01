package j4;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b2 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12128b = Logger.getLogger(b2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f12129a;

    public b2(Runnable runnable) {
        this.f12129a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f12129a;
        try {
            runnable.run();
        } catch (Throwable th) {
            f12128b.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            Object obj = e2.r.f11251a;
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new AssertionError(th);
            }
            throw ((Error) th);
        }
    }

    public final String toString() {
        return "LogExceptionRunnable(" + this.f12129a + ")";
    }
}
