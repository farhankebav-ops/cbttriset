package j4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k1 {
    public static final Logger g = Logger.getLogger(k1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.m f12280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashMap f12281c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12282d;
    public i4.o1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12283f;

    public k1(long j, e2.m mVar) {
        this.f12279a = j;
        this.f12280b = mVar;
    }

    public final void a(z1 z1Var) {
        j2.n nVar = j2.n.f12086a;
        synchronized (this) {
            try {
                if (!this.f12282d) {
                    this.f12281c.put(z1Var, nVar);
                    return;
                }
                i4.o1 o1Var = this.e;
                j1 j1Var = o1Var != null ? new j1(z1Var, o1Var) : new j1(z1Var, this.f12283f);
                try {
                    nVar.execute(j1Var);
                } catch (Throwable th) {
                    g.log(Level.SEVERE, "Failed to execute PingCallback", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                if (this.f12282d) {
                    return;
                }
                this.f12282d = true;
                e2.m mVar = this.f12280b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jA = mVar.a();
                this.f12283f = jA;
                LinkedHashMap linkedHashMap = this.f12281c;
                this.f12281c = null;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    try {
                        ((Executor) entry.getValue()).execute(new j1((z1) entry.getKey(), jA));
                    } catch (Throwable th) {
                        g.log(Level.SEVERE, "Failed to execute PingCallback", th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(i4.o1 o1Var) {
        synchronized (this) {
            try {
                if (this.f12282d) {
                    return;
                }
                this.f12282d = true;
                this.e = o1Var;
                LinkedHashMap linkedHashMap = this.f12281c;
                this.f12281c = null;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    try {
                        ((Executor) entry.getValue()).execute(new j1((z1) entry.getKey(), o1Var));
                    } catch (Throwable th) {
                        g.log(Level.SEVERE, "Failed to execute PingCallback", th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
