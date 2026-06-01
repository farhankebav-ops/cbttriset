package j4;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c5 f12146d = new c5(new e3(19));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f12147a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f12148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f12149c;

    public c5(e3 e3Var) {
        this.f12148b = e3Var;
    }

    public static Object a(b5 b5Var) {
        Object obj;
        c5 c5Var = f12146d;
        synchronized (c5Var) {
            try {
                a5 a5Var = (a5) c5Var.f12147a.get(b5Var);
                if (a5Var == null) {
                    a5Var = new a5(b5Var.create());
                    c5Var.f12147a.put(b5Var, a5Var);
                }
                ScheduledFuture scheduledFuture = a5Var.f12122c;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    a5Var.f12122c = null;
                }
                a5Var.f12121b++;
                obj = a5Var.f12120a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public static void b(b5 b5Var, Object obj) {
        c5 c5Var = f12146d;
        synchronized (c5Var) {
            try {
                a5 a5Var = (a5) c5Var.f12147a.get(b5Var);
                if (a5Var == null) {
                    throw new IllegalArgumentException("No cached instance found for " + b5Var);
                }
                r2.q.y(obj == a5Var.f12120a, "Releasing the wrong instance");
                r2.q.H(a5Var.f12121b > 0, "Refcount has already reached zero");
                int i2 = a5Var.f12121b - 1;
                a5Var.f12121b = i2;
                if (i2 == 0) {
                    r2.q.H(a5Var.f12122c == null, "Destroy task already scheduled");
                    if (c5Var.f12149c == null) {
                        c5Var.f12148b.getClass();
                        c5Var.f12149c = Executors.newSingleThreadScheduledExecutor(f1.e("grpc-shared-destroyer-%d"));
                    }
                    a5Var.f12122c = c5Var.f12149c.schedule(new b2(new b(c5Var, a5Var, b5Var, obj, 3)), 1L, TimeUnit.SECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
