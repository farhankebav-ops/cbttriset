package j4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f12342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f12343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f12344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i4.n1 f12345d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f12346f;
    public long g;
    public long h;
    public final q3 j;
    public final i4.i[] l;
    public final /* synthetic */ p0 m;
    public List e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f12347i = new ArrayList();
    public final i4.q k = i4.q.b();

    public o0(p0 p0Var, q3 q3Var, i4.i[] iVarArr) {
        this.m = p0Var;
        this.j = q3Var;
        this.l = iVarArr;
    }

    @Override // j4.w
    public final void a(int i2) {
        r2.q.H(this.f12343b == null, "May only be called before start");
        this.f12347i.add(new r0(this, i2, 1));
    }

    @Override // j4.e5
    public final void b(i4.k kVar) {
        r2.q.H(this.f12343b == null, "May only be called before start");
        this.f12347i.add(new i0(6, this, kVar));
    }

    public final void c(i4.n1 n1Var) {
        boolean z2 = false;
        boolean z7 = true;
        r2.q.H(this.f12343b != null, "May only be called after start");
        r2.q.D(n1Var, "reason");
        synchronized (this) {
            try {
                w wVar = this.f12344c;
                if (wVar == null) {
                    e3 e3Var = e3.f12176b;
                    if (wVar != null) {
                        z7 = false;
                    }
                    r2.q.G(wVar, "realStream already set to %s", z7);
                    this.f12344c = e3Var;
                    this.h = System.nanoTime();
                    this.f12345d = n1Var;
                } else {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            f(new i0(10, this, n1Var));
            return;
        }
        g();
        for (i4.i iVar : this.l) {
            iVar.m(n1Var);
        }
        this.f12343b.c(n1Var, x.f12538a, new i4.a1());
    }

    @Override // j4.w
    public final void d(i4.n1 n1Var) {
        c(n1Var);
        synchronized (this.m.f12358b) {
            try {
                p0 p0Var = this.m;
                if (p0Var.g != null) {
                    boolean zRemove = p0Var.f12362i.remove(this);
                    if (!this.m.f() && zRemove) {
                        p0 p0Var2 = this.m;
                        p0Var2.f12360d.b(p0Var2.f12361f);
                        p0 p0Var3 = this.m;
                        if (p0Var3.j != null) {
                            p0Var3.f12360d.b(p0Var3.g);
                            this.m.g = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.m.f12360d.a();
    }

    @Override // j4.e5
    public final void e(o4.a aVar) {
        r2.q.H(this.f12343b != null, "May only be called after start");
        if (this.f12342a) {
            this.f12344c.e(aVar);
        } else {
            f(new i0(9, this, aVar));
        }
    }

    public final void f(Runnable runnable) {
        r2.q.H(this.f12343b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f12342a) {
                    runnable.run();
                } else {
                    this.e.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.e5
    public final void flush() {
        r2.q.H(this.f12343b != null, "May only be called after start");
        if (this.f12342a) {
            this.f12344c.flush();
        } else {
            f(new q0(this, 3));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f12342a = r0     // Catch: java.lang.Throwable -> L1d
            j4.s0 r0 = r3.f12346f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.b()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.e     // Catch: java.lang.Throwable -> L1d
            r3.e = r0     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Iterator r0 = r1.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L28
        L38:
            r1.clear()
            r0 = r1
            goto L5
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.o0.g():void");
    }

    @Override // j4.w
    public final void h(i4.t tVar) {
        r2.q.H(this.f12343b == null, "May only be called before start");
        r2.q.D(tVar, "decompressorRegistry");
        this.f12347i.add(new i0(7, this, tVar));
    }

    @Override // j4.w
    public final void i(int i2) {
        r2.q.H(this.f12343b == null, "May only be called before start");
        this.f12347i.add(new r0(this, i2, 0));
    }

    @Override // j4.e5
    public final boolean isReady() {
        if (this.f12342a) {
            return this.f12344c.isReady();
        }
        return false;
    }

    @Override // j4.e5
    public final void j() {
        r2.q.H(this.f12343b == null, "May only be called before start");
        this.f12347i.add(new q0(this, 1));
    }

    @Override // j4.w
    public final void k(i4.r rVar) {
        r2.q.H(this.f12343b == null, "May only be called before start");
        this.f12347i.add(new i0(8, this, rVar));
    }

    @Override // j4.w
    public final void l() {
        r2.q.H(this.f12343b != null, "May only be called after start");
        f(new q0(this, 4));
    }

    @Override // j4.w
    public final void m(y yVar) {
        i4.n1 n1Var;
        boolean z2;
        r2.q.D(yVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        r2.q.H(this.f12343b == null, "already started");
        synchronized (this) {
            try {
                n1Var = this.f12345d;
                z2 = this.f12342a;
                if (!z2) {
                    s0 s0Var = new s0(yVar);
                    this.f12346f = s0Var;
                    yVar = s0Var;
                }
                this.f12343b = yVar;
                this.g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (n1Var != null) {
            yVar.c(n1Var, x.f12538a, new i4.a1());
        } else if (z2) {
            o(yVar);
        }
    }

    @Override // j4.w
    public final void n(l1 l1Var) {
        if (Boolean.TRUE.equals(this.j.f12399a.e)) {
            l1Var.f12300b.add("wait_for_ready");
        }
        synchronized (this) {
            try {
                if (this.f12343b == null) {
                    return;
                }
                if (this.f12344c != null) {
                    l1Var.a(Long.valueOf(this.h - this.g), "buffered_nanos");
                    this.f12344c.n(l1Var);
                } else {
                    l1Var.a(Long.valueOf(System.nanoTime() - this.g), "buffered_nanos");
                    l1Var.f12300b.add("waiting_for_connection");
                }
            } finally {
            }
        }
    }

    public final void o(y yVar) {
        ArrayList arrayList = this.f12347i;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Runnable) obj).run();
        }
        this.f12347i = null;
        this.f12344c.m(yVar);
    }

    public final q0 p(w wVar) {
        synchronized (this) {
            try {
                if (this.f12344c != null) {
                    return null;
                }
                r2.q.D(wVar, "stream");
                w wVar2 = this.f12344c;
                r2.q.G(wVar2, "realStream already set to %s", wVar2 == null);
                this.f12344c = wVar;
                this.h = System.nanoTime();
                y yVar = this.f12343b;
                if (yVar == null) {
                    this.e = null;
                    this.f12342a = true;
                }
                if (yVar == null) {
                    return null;
                }
                o(yVar);
                return new q0(this, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.e5
    public final void request() {
        r2.q.H(this.f12343b != null, "May only be called after start");
        if (this.f12342a) {
            this.f12344c.request();
        } else {
            f(new q0(this, 0));
        }
    }
}
