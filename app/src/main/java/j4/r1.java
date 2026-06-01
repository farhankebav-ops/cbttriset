package j4;

import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r1 implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f12410c;

    public r1(t1 t1Var, o1 o1Var) {
        this.f12410c = t1Var;
        this.f12408a = false;
        this.f12409b = o1Var;
    }

    public void a(ScheduledFuture scheduledFuture) {
        synchronized (this.f12409b) {
            try {
                if (!this.f12408a) {
                    this.f12410c = scheduledFuture;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(boolean z2) {
        t1 t1Var = (t1) this.f12410c;
        t1Var.k.execute(new e1.g(1, t1Var, (o1) this.f12409b, z2));
    }

    public void c(i4.n1 n1Var) {
        t1 t1Var = (t1) this.f12410c;
        t1Var.f12462i.j(2, "{0} SHUTDOWN with {1}", ((o1) this.f12409b).a(), t1.h(n1Var));
        this.f12408a = true;
        t1Var.k.execute(new i0(16, this, n1Var));
    }

    public void d() {
        r2.q.H(this.f12408a, "transportShutdown() must be called before transportTerminated().");
        t1 t1Var = (t1) this.f12410c;
        i4.f fVar = t1Var.f12462i;
        o1 o1Var = (o1) this.f12409b;
        int i2 = 1;
        fVar.j(2, "{0} Terminated", o1Var.a());
        i4.s1 s1Var = t1Var.k;
        s1Var.execute(new e1.g(1, t1Var, o1Var, false));
        Iterator it = t1Var.j.iterator();
        if (!it.hasNext()) {
            s1Var.execute(new q1(this, i2));
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            o1Var.getAttributes();
            throw null;
        }
    }

    public r1(Object obj) {
        this.f12409b = obj;
    }
}
