package j4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p2 extends i4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.j0 f12366d;
    public final i4.e0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f12367f;
    public final q g;
    public List h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t1 f12368i;
    public boolean j;
    public boolean k;
    public android.support.v4.media.g l;
    public final /* synthetic */ q2 m;

    public p2(q2 q2Var, i4.j0 j0Var) {
        this.m = q2Var;
        List list = j0Var.f11878b;
        this.h = list;
        Logger logger = q2.f12378c0;
        this.f12366d = j0Var;
        i4.e0 e0Var = new i4.e0("Subchannel", q2Var.f12393t.e(), i4.e0.f11851d.incrementAndGet());
        this.e = e0Var;
        e3 e3Var = q2Var.l;
        q qVar = new q(e0Var, e3Var.p(), "Subchannel for " + list);
        this.g = qVar;
        this.f12367f = new o(qVar, e3Var);
    }

    @Override // i4.f
    public final List c() {
        this.m.m.d();
        r2.q.H(this.j, "not started");
        return this.h;
    }

    @Override // i4.f
    public final i4.b d() {
        return this.f12366d.f11879c;
    }

    @Override // i4.f
    public final i4.f e() {
        return this.f12367f;
    }

    @Override // i4.f
    public final Object f() {
        r2.q.H(this.j, "Subchannel is not started");
        return this.f12368i;
    }

    @Override // i4.f
    public final void n() {
        this.m.m.d();
        r2.q.H(this.j, "not started");
        t1 t1Var = this.f12368i;
        if (t1Var.f12470v != null) {
            return;
        }
        t1Var.k.execute(new n1(t1Var, 1));
    }

    @Override // i4.f
    public final void p() {
        android.support.v4.media.g gVar;
        q2 q2Var = this.m;
        q2Var.m.d();
        if (this.f12368i == null) {
            this.k = true;
            return;
        }
        if (!this.k) {
            this.k = true;
        } else {
            if (!q2Var.H || (gVar = this.l) == null) {
                return;
            }
            gVar.c();
            this.l = null;
        }
        if (!q2Var.H) {
            this.l = q2Var.m.c(new b2(new a4.c(this, 10)), 5L, TimeUnit.SECONDS, q2Var.f12386f.f12326a.f12636d);
        } else {
            t1 t1Var = this.f12368i;
            t1Var.k.execute(new i0(15, t1Var, q2.f12379e0));
        }
    }

    @Override // i4.f
    public final void r(i4.n0 n0Var) {
        q2 q2Var = this.m;
        q2Var.m.d();
        r2.q.H(!this.j, "already started");
        r2.q.H(!this.k, "already shutdown");
        r2.q.H(!q2Var.H, "Channel is being terminated");
        this.j = true;
        List list = this.f12366d.f11878b;
        String strE = q2Var.f12393t.e();
        e3 e3Var = q2Var.f12392s;
        n nVar = q2Var.f12386f;
        ScheduledExecutorService scheduledExecutorService = nVar.f12326a.f12636d;
        e2.n nVar2 = q2Var.p;
        i4.s1 s1Var = q2Var.m;
        g5 g5Var = new g5(4, this, n0Var);
        i4.b0 b0Var = q2Var.O;
        q2Var.K.getClass();
        t1 t1Var = new t1(list, strE, e3Var, nVar, scheduledExecutorService, nVar2, s1Var, g5Var, b0Var, new h(), this.g, this.e, this.f12367f, q2Var.f12394u);
        q2Var.M.b(new i4.a0("Child Subchannel started", i4.z.f11979a, q2Var.l.p(), t1Var));
        this.f12368i = t1Var;
        q2Var.A.add(t1Var);
    }

    @Override // i4.f
    public final void s(List list) {
        this.m.m.d();
        this.h = list;
        t1 t1Var = this.f12368i;
        t1Var.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r2.q.D(it.next(), "newAddressGroups contains null entry");
        }
        r2.q.y(!list.isEmpty(), "newAddressGroups is empty");
        t1Var.k.execute(new i0(14, t1Var, Collections.unmodifiableList(new ArrayList(list))));
    }

    public final String toString() {
        return this.e.toString();
    }
}
