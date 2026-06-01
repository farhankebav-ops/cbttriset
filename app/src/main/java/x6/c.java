package x6;

import e2.s;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import q6.c0;
import v6.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17804i = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");
    public static final e2.f k = new e2.f("NOT_IN_STACK", 5, false);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17807c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17808d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f17809f;
    public final q g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i2, int i8, String str, long j3) {
        this.f17805a = i2;
        this.f17806b = i8;
        this.f17807c = j3;
        this.f17808d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.h(i2, "Core pool size ", " should be at least 1").toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("Max pool size ", i8, " should be greater than or equals to core pool size ", i2).toString());
        }
        if (i8 > 2097150) {
            throw new IllegalArgumentException(a1.a.h(i8, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j3 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j3 + " must be positive").toString());
        }
        this.e = new f();
        this.f17809f = new f();
        this.g = new q((i2 + 1) * 2);
        this.controlState$volatile = ((long) i2) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void e(c cVar, Runnable runnable, int i2) {
        cVar.b(false, (i2 & 4) == 0, runnable);
    }

    public final int a() {
        synchronized (this.g) {
            try {
                if (j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f17804i;
                long j3 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j3 & 2097151);
                int i8 = i2 - ((int) ((j3 & 4398044413952L) >> 21));
                if (i8 < 0) {
                    i8 = 0;
                }
                if (i8 >= this.f17805a) {
                    return 0;
                }
                if (i2 >= this.f17806b) {
                    return 0;
                }
                int i9 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i9 <= 0 || this.g.b(i9) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i9);
                this.g.c(i9, aVar);
                if (i9 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i10 = i8 + 1;
                aVar.start();
                return i10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(boolean z2, boolean z7, Runnable runnable) {
        i jVar;
        b bVar;
        k.f17822f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f17815a = jNanoTime;
            jVar.f17816b = z2;
        } else {
            jVar = new j(jNanoTime, runnable, z2);
        }
        boolean z8 = jVar.f17816b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17804i;
        long jAddAndGet = z8 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !kotlin.jvm.internal.k.a(aVar.h, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f17796c) != b.e && (jVar.f17816b || bVar != b.f17800b)) {
            aVar.g = true;
            m mVar = aVar.f17794a;
            if (z7) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                i iVar = (i) m.f17824b.getAndSet(mVar, jVar);
                jVar = iVar == null ? null : mVar.a(iVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f17816b ? this.f17809f.a(jVar) : this.e.a(jVar))) {
                throw new RejectedExecutionException(a1.a.r(new StringBuilder(), this.f17808d, " was terminated"));
            }
        }
        boolean z9 = z7 && aVar != null;
        if (z8) {
            if (z9 || j() || i(jAddAndGet)) {
                return;
            }
            j();
            return;
        }
        if (z9 || j() || i(atomicLongFieldUpdater.get(this))) {
            return;
        }
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = x6.c.j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof x6.a
            r3 = 0
            if (r1 == 0) goto L17
            x6.a r0 = (x6.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            x6.c r1 = r0.h
            boolean r1 = kotlin.jvm.internal.k.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            v6.q r1 = r8.g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = x6.c.f17804i     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            v6.q r5 = r8.g
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.k.b(r5)
            x6.a r5 = (x6.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            x6.m r5 = r5.f17794a
            x6.f r6 = r8.f17809f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = x6.m.f17824b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            x6.i r7 = (x6.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            x6.i r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            x6.f r1 = r8.f17809f
            r1.b()
            x6.f r1 = r8.e
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            x6.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            x6.f r1 = r8.e
            java.lang.Object r1 = r1.d()
            x6.i r1 = (x6.i) r1
            if (r1 != 0) goto Lb2
            x6.f r1 = r8.f17809f
            java.lang.Object r1 = r1.d()
            x6.i r1 = (x6.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            x6.b r1 = x6.b.e
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = x6.c.h
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = x6.c.f17804i
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.c.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        e(this, runnable, 6);
    }

    public final void g(a aVar, int i2, int i8) {
        while (true) {
            long j3 = h.get(this);
            int i9 = (int) (2097151 & j3);
            long j8 = (2097152 + j3) & (-2097152);
            if (i9 == i2) {
                if (i8 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == k) {
                            i9 = -1;
                            break;
                        }
                        if (objC == null) {
                            i9 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i9 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i9 = i8;
                }
            }
            if (i9 >= 0) {
                if (h.compareAndSet(this, j3, ((long) i9) | j8)) {
                    return;
                }
            }
        }
    }

    public final boolean i(long j3) {
        int i2 = ((int) (2097151 & j3)) - ((int) ((j3 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i8 = this.f17805a;
        if (i2 < i8) {
            int iA = a();
            if (iA == 1 && i8 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        e2.f fVar;
        int iB;
        while (true) {
            long j3 = h.get(this);
            a aVar = (a) this.g.b((int) (2097151 & j3));
            if (aVar == null) {
                aVar = null;
            } else {
                long j8 = (2097152 + j3) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    fVar = k;
                    if (objC == fVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0) {
                    if (h.compareAndSet(this, j3, ((long) iB) | j8)) {
                        aVar.g(fVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f17793i.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        q qVar = this.g;
        int iA = qVar.a();
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 1; i12 < iA; i12++) {
            a aVar = (a) qVar.b(i12);
            if (aVar != null) {
                m mVar = aVar.f17794a;
                mVar.getClass();
                int i13 = m.f17824b.get(mVar) != null ? (m.f17825c.get(mVar) - m.f17826d.get(mVar)) + 1 : m.f17825c.get(mVar) - m.f17826d.get(mVar);
                int iOrdinal = aVar.f17796c.ordinal();
                if (iOrdinal == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i13);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i8++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i13);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i9++;
                } else if (iOrdinal == 3) {
                    i10++;
                    if (i13 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i13);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new s(3);
                    }
                    i11++;
                }
            }
        }
        long j3 = f17804i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f17808d);
        sb4.append('@');
        sb4.append(c0.p(this));
        sb4.append("[Pool Size {core = ");
        int i14 = this.f17805a;
        sb4.append(i14);
        sb4.append(", max = ");
        androidx.camera.core.processing.util.a.w(this.f17806b, i2, "}, Worker States {CPU = ", ", blocking = ", sb4);
        androidx.camera.core.processing.util.a.w(i8, i9, ", parked = ", ", dormant = ", sb4);
        androidx.camera.core.processing.util.a.w(i10, i11, ", terminated = ", "}, running workers queues = ", sb4);
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f17809f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j3));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j3) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i14 - ((int) ((j3 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
