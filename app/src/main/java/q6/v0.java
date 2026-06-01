package q6;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v0 extends w0 implements h0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13595f = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    public final void W(long j, t0 t0Var) {
        int iC;
        Thread threadQ;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13595f;
        if (g.get(this) != 0) {
            iC = 1;
        } else {
            u0 u0Var = (u0) atomicReferenceFieldUpdater.get(this);
            if (u0Var == null) {
                u0 u0Var2 = new u0();
                u0Var2.f13592c = j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, u0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                kotlin.jvm.internal.k.b(obj);
                u0Var = (u0) obj;
            }
            iC = t0Var.c(j, u0Var, this);
        }
        if (iC != 0) {
            if (iC == 1) {
                u(j, t0Var);
                return;
            } else {
                if (iC != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        u0 u0Var3 = (u0) atomicReferenceFieldUpdater.get(this);
        if (u0Var3 != null) {
            synchronized (u0Var3) {
                t0[] t0VarArr = u0Var3.f17652a;
                t0Var = t0VarArr != null ? t0VarArr[0] : null;
            }
        }
        if (t0Var != t0Var || Thread.currentThread() == (threadQ = q())) {
            return;
        }
        LockSupport.unpark(threadQ);
    }

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        v(runnable);
    }

    public o0 e(long j, Runnable runnable, v5.h hVar) {
        return e0.f13545a.e(j, runnable, hVar);
    }

    @Override // q6.h0
    public final void l(long j, l lVar) {
        long j3 = j > 0 ? j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j : 0L;
        if (j3 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            r0 r0Var = new r0(this, j3 + jNanoTime, lVar);
            W(jNanoTime, r0Var);
            lVar.u(new h(r0Var, 2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // q6.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long s() {
        /*
            r10 = this;
            e2.f r0 = q6.c0.f13534c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = q6.v0.e
            boolean r2 = r10.t()
            r3 = 0
            if (r2 == 0) goto Le
            goto Lb4
        Le:
            r10.w()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r2 instanceof v6.m
            if (r6 == 0) goto L3e
            r6 = r2
            v6.m r6 = (v6.m) r6
            java.lang.Object r7 = r6.d()
            e2.f r8 = v6.m.g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            v6.m r6 = r6.c()
        L30:
            boolean r5 = r1.compareAndSet(r10, r2, r6)
            if (r5 == 0) goto L37
            goto L11
        L37:
            java.lang.Object r5 = r1.get(r10)
            if (r5 == r2) goto L30
            goto L11
        L3e:
            if (r2 != r0) goto L41
            goto L18
        L41:
            boolean r6 = r1.compareAndSet(r10, r2, r5)
            if (r6 == 0) goto Lb9
            r7 = r2
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L4a:
            if (r7 == 0) goto L50
            r7.run()
            return r3
        L50:
            r5.i r2 = r10.f13599c
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != 0) goto L5b
        L59:
            r8 = r6
            goto L63
        L5b:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L62
            goto L59
        L62:
            r8 = r3
        L63:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L68
            goto Lb4
        L68:
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L90
            boolean r2 = r1 instanceof v6.m
            if (r2 == 0) goto L8d
            v6.m r1 = (v6.m) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = v6.m.f17636f
            long r0 = r0.get(r1)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r0
            int r2 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r0 = r0 & r8
            r8 = 30
            long r0 = r0 >> r8
            int r0 = (int) r0
            if (r2 != r0) goto L8c
            goto L90
        L8c:
            return r3
        L8d:
            if (r1 != r0) goto Lb4
            goto Lb8
        L90:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = q6.v0.f13595f
            java.lang.Object r0 = r0.get(r10)
            q6.u0 r0 = (q6.u0) r0
            if (r0 == 0) goto Lb8
            monitor-enter(r0)
            q6.t0[] r1 = r0.f17652a     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto La5
            r2 = 0
            r5 = r1[r2]     // Catch: java.lang.Throwable -> La3
            goto La5
        La3:
            r1 = move-exception
            goto Lb6
        La5:
            monitor-exit(r0)
            if (r5 != 0) goto La9
            goto Lb8
        La9:
            long r0 = r5.f13588a
            long r5 = java.lang.System.nanoTime()
            long r0 = r0 - r5
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto Lb5
        Lb4:
            return r3
        Lb5:
            return r0
        Lb6:
            monitor-exit(r0)
            throw r1
        Lb8:
            return r6
        Lb9:
            java.lang.Object r6 = r1.get(r10)
            if (r6 == r2) goto L41
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.v0.s():long");
    }

    @Override // q6.w0
    public void shutdown() {
        t0 t0VarC;
        x1.f13601a.set(null);
        g.set(this, 1);
        e2.f fVar = c0.f13534c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof v6.m)) {
                    if (obj != fVar) {
                        v6.m mVar = new v6.m(8, true);
                        mVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((v6.m) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, fVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (s() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            u0 u0Var = (u0) f13595f.get(this);
            if (u0Var == null) {
                return;
            }
            synchronized (u0Var) {
                t0VarC = v6.v.f17651b.get(u0Var) > 0 ? u0Var.c(0) : null;
            }
            if (t0VarC == null) {
                return;
            } else {
                u(jNanoTime, t0VarC);
            }
        }
    }

    public void v(Runnable runnable) {
        w();
        if (!x(runnable)) {
            d0.h.v(runnable);
            return;
        }
        Thread threadQ = q();
        if (Thread.currentThread() != threadQ) {
            LockSupport.unpark(threadQ);
        }
    }

    public final void w() {
        t0 t0VarC;
        u0 u0Var = (u0) f13595f.get(this);
        if (u0Var == null || v6.v.f17651b.get(u0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (u0Var) {
                try {
                    t0[] t0VarArr = u0Var.f17652a;
                    t0 t0Var = t0VarArr != null ? t0VarArr[0] : null;
                    if (t0Var != null) {
                        t0VarC = ((jNanoTime - t0Var.f13588a) > 0L ? 1 : ((jNanoTime - t0Var.f13588a) == 0L ? 0 : -1)) >= 0 ? x(t0Var) : false ? u0Var.c(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (t0VarC != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean x(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = q6.v0.e
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = q6.v0.g
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof v6.m
            if (r4 == 0) goto L47
            r4 = r1
            v6.m r4 = (v6.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            v6.m r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            e2.f r4 = q6.c0.f13534c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            v6.m r3 = new v6.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.v0.x(java.lang.Runnable):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean y() {
        /*
            r7 = this;
            r5.i r0 = r7.f13599c
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = q6.v0.f13595f
            java.lang.Object r0 = r0.get(r7)
            q6.u0 r0 = (q6.u0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = v6.v.f17651b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = q6.v0.e
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof v6.m
            if (r3 == 0) goto L4f
            v6.m r0 = (v6.m) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = v6.m.f17636f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r3 = (int) r3
            if (r0 != r3) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            e2.f r3 = q6.c0.f13534c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.v0.y():boolean");
    }
}
