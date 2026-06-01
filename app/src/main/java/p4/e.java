package p4;

import i4.a1;
import i4.n1;
import i4.o1;
import i4.p1;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import r2.l;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f13333a = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f13335c;

    static {
        f13334b = !n7.b.R(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f13335c = new e2.f("internal-stub-type", 3, false);
    }

    public static void a(i4.f fVar, Throwable th) {
        try {
            fVar.a(null, th);
        } catch (Error | RuntimeException e) {
            f13333a.log(Level.SEVERE, "RuntimeException encountered while closing call", e);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new AssertionError(th);
        }
        throw ((Error) th);
    }

    public static a b(i4.f fVar, l lVar) {
        a aVar = new a(fVar);
        fVar.q(new d(aVar), new a1());
        fVar.m();
        try {
            fVar.o(lVar);
            fVar.g();
            return aVar;
        } catch (Error | RuntimeException e) {
            a(fVar, e);
            throw null;
        }
    }

    public static Object c(a aVar) {
        try {
            return aVar.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw n1.f11914f.h("Thread interrupted").g(e).a();
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            q.D(cause, "t");
            for (Throwable cause2 = cause; cause2 != null; cause2 = cause2.getCause()) {
                if (cause2 instanceof o1) {
                    throw new p1(((o1) cause2).f11926a, null);
                }
                if (cause2 instanceof p1) {
                    p1 p1Var = (p1) cause2;
                    throw new p1(p1Var.f11928a, p1Var.f11929b);
                }
            }
            throw n1.g.h("unexpected exception").g(cause).a();
        }
    }
}
