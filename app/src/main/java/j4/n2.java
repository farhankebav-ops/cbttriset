package j4;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n2 extends i4.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12332b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q2 f12334d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f12331a = new AtomicReference(q2.h0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l2 f12333c = new l2(this);

    public n2(q2 q2Var, String str) {
        this.f12334d = q2Var;
        r2.q.D(str, "authority");
        this.f12332b = str;
    }

    @Override // i4.e
    public final String e() {
        return this.f12332b;
    }

    @Override // i4.e
    public final i4.f f(i4.c1 c1Var, i4.d dVar) {
        q2 q2Var = this.f12334d;
        i4.s1 s1Var = q2Var.m;
        AtomicReference atomicReference = this.f12331a;
        Object obj = atomicReference.get();
        d2 d2Var = q2.h0;
        if (obj != d2Var) {
            return g(c1Var, dVar);
        }
        s1Var.execute(new a4.c(this, 9));
        if (atomicReference.get() != d2Var) {
            return g(c1Var, dVar);
        }
        if (q2Var.G.get()) {
            return new k0(2);
        }
        m2 m2Var = new m2(this, i4.q.b(), c1Var, dVar);
        s1Var.execute(new i0(this, m2Var));
        return m2Var;
    }

    public final i4.f g(i4.c1 c1Var, i4.d dVar) {
        i4.c0 c0Var = (i4.c0) this.f12331a.get();
        l2 l2Var = this.f12333c;
        if (c0Var == null) {
            return l2Var.f(c1Var, dVar);
        }
        if (!(c0Var instanceof v2)) {
            return new h2(c0Var, l2Var, this.f12334d.h, c1Var, dVar);
        }
        w2 w2Var = ((v2) c0Var).f12519b;
        u2 u2Var = (u2) w2Var.f12528b.get((String) c1Var.f11839d);
        if (u2Var == null) {
            u2Var = (u2) w2Var.f12529c.get((String) c1Var.e);
        }
        if (u2Var == null) {
            u2Var = w2Var.f12527a;
        }
        if (u2Var != null) {
            dVar = dVar.c(u2.g, u2Var);
        }
        return l2Var.f(c1Var, dVar);
    }

    public final void h(i4.c0 c0Var) {
        LinkedHashSet linkedHashSet;
        AtomicReference atomicReference = this.f12331a;
        i4.c0 c0Var2 = (i4.c0) atomicReference.get();
        atomicReference.set(c0Var);
        if (c0Var2 != q2.h0 || (linkedHashSet = this.f12334d.B) == null) {
            return;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((m2) it.next()).w();
        }
    }
}
