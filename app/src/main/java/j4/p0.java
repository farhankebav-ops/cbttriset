package j4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 implements y2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f12359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.s1 f12360d;
    public n0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n0 f12361f;
    public n0 g;
    public a4.a h;
    public i4.n1 j;
    public i4.m0 k;
    public long l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.e0 f12357a = i4.e0.a(p0.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12358b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection f12362i = new LinkedHashSet();

    public p0(Executor executor, i4.s1 s1Var) {
        this.f12359c = executor;
        this.f12360d = s1Var;
    }

    @Override // i4.d0
    public final i4.e0 a() {
        return this.f12357a;
    }

    @Override // j4.z
    public final w b(i4.c1 c1Var, i4.a1 a1Var, i4.d dVar, i4.i[] iVarArr) {
        w y0Var;
        try {
            q3 q3Var = new q3(c1Var, a1Var, dVar);
            i4.m0 m0Var = null;
            long j = -1;
            while (true) {
                synchronized (this.f12358b) {
                    i4.n1 n1Var = this.j;
                    if (n1Var == null) {
                        i4.m0 m0Var2 = this.k;
                        if (m0Var2 != null) {
                            if (m0Var != null && j == this.l) {
                                y0Var = e(q3Var, iVarArr);
                                break;
                            }
                            j = this.l;
                            z zVarF = f1.f(m0Var2.a(q3Var), Boolean.TRUE.equals(dVar.e));
                            if (zVarF != null) {
                                y0Var = zVarF.b(q3Var.f12401c, q3Var.f12400b, q3Var.f12399a, iVarArr);
                                break;
                            }
                            m0Var = m0Var2;
                        } else {
                            y0Var = e(q3Var, iVarArr);
                            break;
                        }
                    } else {
                        y0Var = new y0(n1Var, x.f12538a, iVarArr);
                        break;
                    }
                }
            }
            return y0Var;
        } finally {
            this.f12360d.a();
        }
    }

    @Override // j4.y2
    public final Runnable c(x2 x2Var) {
        a4.a aVar = (a4.a) x2Var;
        this.h = aVar;
        this.e = new n0(aVar, 0);
        this.f12361f = new n0(aVar, 1);
        this.g = new n0(aVar, 2);
        return null;
    }

    @Override // j4.y2
    public final void d(i4.n1 n1Var) {
        n0 n0Var;
        synchronized (this.f12358b) {
            try {
                if (this.j != null) {
                    return;
                }
                this.j = n1Var;
                this.f12360d.b(new i0(5, this, n1Var));
                if (!f() && (n0Var = this.g) != null) {
                    this.f12360d.b(n0Var);
                    this.g = null;
                }
                this.f12360d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final o0 e(q3 q3Var, i4.i[] iVarArr) {
        int size;
        o0 o0Var = new o0(this, q3Var, iVarArr);
        this.f12362i.add(o0Var);
        synchronized (this.f12358b) {
            size = this.f12362i.size();
        }
        if (size == 1) {
            this.f12360d.b(this.e);
        }
        for (i4.i iVar : iVarArr) {
            iVar.a();
        }
        return o0Var;
    }

    public final boolean f() {
        boolean z2;
        synchronized (this.f12358b) {
            z2 = !this.f12362i.isEmpty();
        }
        return z2;
    }

    public final void g(i4.m0 m0Var) {
        n0 n0Var;
        synchronized (this.f12358b) {
            this.k = m0Var;
            this.l++;
            if (m0Var != null && f()) {
                ArrayList arrayList = new ArrayList(this.f12362i);
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    o0 o0Var = (o0) obj;
                    i4.k0 k0VarA = m0Var.a(o0Var.j);
                    i4.d dVar = o0Var.j.f12399a;
                    z zVarF = f1.f(k0VarA, Boolean.TRUE.equals(dVar.e));
                    if (zVarF != null) {
                        Executor executor = this.f12359c;
                        Executor executor2 = dVar.f11842b;
                        if (executor2 != null) {
                            executor = executor2;
                        }
                        i4.q qVar = o0Var.k;
                        i4.q qVarA = qVar.a();
                        try {
                            q3 q3Var = o0Var.j;
                            w wVarB = zVarF.b(q3Var.f12401c, q3Var.f12400b, q3Var.f12399a, o0Var.l);
                            qVar.c(qVarA);
                            q0 q0VarP = o0Var.p(wVarB);
                            if (q0VarP != null) {
                                executor.execute(q0VarP);
                            }
                            arrayList2.add(o0Var);
                        } catch (Throwable th) {
                            qVar.c(qVarA);
                            throw th;
                        }
                    }
                }
                synchronized (this.f12358b) {
                    try {
                        if (f()) {
                            this.f12362i.removeAll(arrayList2);
                            if (this.f12362i.isEmpty()) {
                                this.f12362i = new LinkedHashSet();
                            }
                            if (!f()) {
                                this.f12360d.b(this.f12361f);
                                if (this.j != null && (n0Var = this.g) != null) {
                                    this.f12360d.b(n0Var);
                                    this.g = null;
                                }
                            }
                            this.f12360d.a();
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
