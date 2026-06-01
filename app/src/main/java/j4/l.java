package j4;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l {
    public static final Logger e = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.s1 f12294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x0 f12295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public android.support.v4.media.g f12296d;

    public l(e3 e3Var, o2 o2Var, i4.s1 s1Var) {
        this.f12293a = o2Var;
        this.f12294b = s1Var;
    }

    public final void a(a4.c cVar) {
        this.f12294b.d();
        if (this.f12295c == null) {
            this.f12295c = e3.q();
        }
        android.support.v4.media.g gVar = this.f12296d;
        if (gVar != null) {
            i4.r1 r1Var = (i4.r1) gVar.f3263b;
            if (!r1Var.f11948c && !r1Var.f11947b) {
                return;
            }
        }
        long jA = this.f12295c.a();
        this.f12296d = this.f12294b.c(cVar, jA, TimeUnit.NANOSECONDS, this.f12293a);
        e.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
    }
}
