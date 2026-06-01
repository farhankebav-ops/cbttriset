package j4;

import com.ironsource.C2300e4;
import java.lang.Thread;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f2 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q2 f12193a;

    public f2(q2 q2Var) {
        this.f12193a = q2Var;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Logger logger = q2.f12378c0;
        Level level = Level.SEVERE;
        StringBuilder sb = new StringBuilder(C2300e4.i.f8403d);
        q2 q2Var = this.f12193a;
        sb.append(q2Var.f12380a);
        sb.append("] Uncaught exception in the SynchronizationContext. Panic!");
        logger.log(level, sb.toString(), th);
        if (q2Var.f12398z) {
            return;
        }
        q2Var.f12398z = true;
        x3 x3Var = q2Var.f12381a0;
        x3Var.f12551f = false;
        ScheduledFuture scheduledFuture = x3Var.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            x3Var.g = null;
        }
        q2Var.k(false);
        e2 e2Var = new e2(th);
        q2Var.y = e2Var;
        q2Var.E.g(e2Var);
        q2Var.P.h(null);
        q2Var.N.i(4, "PANIC! Entering TRANSIENT_FAILURE");
        q2Var.f12391r.b(i4.m.f11896c);
    }
}
