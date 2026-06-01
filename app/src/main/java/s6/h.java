package s6;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.d0;
import q6.c0;
import q6.f2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class h implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f13730b = AtomicLongFieldUpdater.newUpdater(h.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f13731c = AtomicLongFieldUpdater.newUpdater(h.class, "receivers$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f13732d = AtomicLongFieldUpdater.newUpdater(h.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(h.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13733f = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13734i = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_closeCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13735a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public h(int i2) {
        this.f13735a = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        p pVar = j.f13737a;
        this.bufferEnd$volatile = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : LocationRequestCompat.PASSIVE_INTERVAL : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f13732d.get(this);
        p pVar2 = new p(0L, null, this, 3);
        this.sendSegment$volatile = pVar2;
        this.receiveSegment$volatile = pVar2;
        if (A()) {
            pVar2 = j.f13737a;
            kotlin.jvm.internal.k.c(pVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = pVar2;
        this._closeCause$volatile = j.f13747s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object D(s6.h r13, x5.c r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof s6.f
            if (r0 == 0) goto L14
            r0 = r14
            s6.f r0 = (s6.f) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            s6.f r0 = new s6.f
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f13728f
            w5.a r0 = w5.a.f17774a
            int r1 = r6.h
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            r2.q.z0(r14)
            s6.o r14 = (s6.o) r14
            java.lang.Object r13 = r14.f13753a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            r2.q.z0(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = s6.h.g
            java.lang.Object r14 = r14.get(r13)
            s6.p r14 = (s6.p) r14
        L40:
            boolean r1 = r13.x()
            if (r1 == 0) goto L50
            java.lang.Throwable r13 = r13.r()
            s6.m r14 = new s6.m
            r14.<init>(r13)
            return r14
        L50:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = s6.h.f13731c
            long r4 = r1.getAndIncrement(r13)
            int r1 = s6.j.f13738b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f17648c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6d
            s6.p r1 = r13.q(r9, r14)
            if (r1 != 0) goto L6b
            goto L40
        L6b:
            r8 = r1
            goto L6e
        L6d:
            r8 = r14
        L6e:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.I(r8, r9, r10, r12)
            r1 = r7
            e2.f r14 = s6.j.m
            if (r13 == r14) goto La0
            e2.f r14 = s6.j.f13744o
            if (r13 != r14) goto L8d
            long r13 = r1.u()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8a
            r8.b()
        L8a:
            r13 = r1
            r14 = r8
            goto L40
        L8d:
            e2.f r14 = s6.j.f13743n
            if (r13 != r14) goto L9c
            r6.h = r2
            r2 = r8
            java.lang.Object r13 = r1.E(r2, r3, r4, r6)
            if (r13 != r0) goto L9b
            return r0
        L9b:
            return r13
        L9c:
            r8.b()
            return r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.D(s6.h, x5.c):java.lang.Object");
    }

    public static final p b(h hVar, long j3, p pVar) {
        Object objB;
        h hVar2;
        p pVar2 = j.f13737a;
        i iVar = i.f13736b;
        loop0: while (true) {
            objB = v6.a.b(pVar, j3, iVar);
            if (!v6.a.e(objB)) {
                v6.s sVarC = v6.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13733f;
                    v6.s sVar = (v6.s) atomicReferenceFieldUpdater.get(hVar);
                    if (sVar.f17648c >= sVarC.f17648c) {
                        break loop0;
                    }
                    if (!sVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != sVar) {
                            if (sVarC.f()) {
                                sVarC.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            } else {
                break;
            }
        }
        boolean zE = v6.a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13731c;
        if (zE) {
            hVar.y();
            if (pVar.f17648c * ((long) j.f13738b) < atomicLongFieldUpdater.get(hVar)) {
                pVar.b();
                return null;
            }
        } else {
            p pVar3 = (p) v6.a.c(objB);
            long j8 = pVar3.f17648c;
            if (j8 <= j3) {
                return pVar3;
            }
            long j9 = ((long) j.f13738b) * j8;
            while (true) {
                long j10 = f13730b.get(hVar);
                long j11 = 1152921504606846975L & j10;
                if (j11 >= j9) {
                    hVar2 = hVar;
                    break;
                }
                hVar2 = hVar;
                if (f13730b.compareAndSet(hVar2, j10, (((long) ((int) (j10 >> 60))) << 60) + j11)) {
                    break;
                }
                hVar = hVar2;
            }
            if (j8 * ((long) j.f13738b) < atomicLongFieldUpdater.get(hVar2)) {
                pVar3.b();
            }
        }
        return null;
    }

    public static final void e(h hVar, Object obj, q6.l lVar) {
        lVar.resumeWith(r2.q.M(hVar.t()));
    }

    public static final int f(h hVar, p pVar, int i2, Object obj, long j3, Object obj2, boolean z2) {
        pVar.n(i2, obj);
        if (z2) {
            return hVar.J(pVar, i2, obj, j3, obj2, z2);
        }
        Object objL = pVar.l(i2);
        if (objL == null) {
            if (hVar.g(j3)) {
                if (pVar.k(i2, null, j.f13740d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (pVar.k(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof f2) {
            pVar.n(i2, null);
            if (hVar.G(objL, obj)) {
                pVar.o(i2, j.f13742i);
                return 0;
            }
            e2.f fVar = j.k;
            if (pVar.f13754f.getAndSet((i2 * 2) + 1, fVar) == fVar) {
                return 5;
            }
            pVar.m(i2, true);
            return 5;
        }
        return hVar.J(pVar, i2, obj, j3, obj2, z2);
    }

    public static void v(h hVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if ((atomicLongFieldUpdater.addAndGet(hVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(hVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final boolean A() {
        long j3 = f13732d.get(this);
        return j3 == 0 || j3 == LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(long r5, s6.p r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f17648c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            v6.b r0 = r7.c()
            s6.p r0 = (s6.p) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            v6.b r5 = r7.c()
            s6.p r5 = (s6.p) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = s6.h.h
            java.lang.Object r6 = r5.get(r4)
            v6.s r6 = (v6.s) r6
            long r0 = r6.f17648c
            long r2 = r7.f17648c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.f()
            if (r5 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.B(long, s6.p):void");
    }

    public final Object C(Object obj, v5.c cVar) {
        q6.l lVar = new q6.l(1, a.a.I(cVar));
        lVar.r();
        lVar.resumeWith(r2.q.M(t()));
        Object objP = lVar.p();
        return objP == w5.a.f17774a ? objP : q5.x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(s6.p r15, int r16, long r17, x5.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.E(s6.p, int, long, x5.c):java.lang.Object");
    }

    public final void F(f2 f2Var, boolean z2) {
        if (f2Var instanceof q6.j) {
            ((v5.c) f2Var).resumeWith(r2.q.M(z2 ? s() : t()));
            return;
        }
        if (f2Var instanceof y) {
            ((y) f2Var).f13760a.resumeWith(new o(new m(r())));
            return;
        }
        if (!(f2Var instanceof c)) {
            if (f2Var instanceof y6.f) {
                ((y6.e) ((y6.f) f2Var)).g(this, j.l);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + f2Var).toString());
            }
        }
        c cVar = (c) f2Var;
        q6.l lVar = cVar.f13724b;
        kotlin.jvm.internal.k.b(lVar);
        cVar.f13724b = null;
        cVar.f13723a = j.l;
        Throwable thR = cVar.f13725c.r();
        if (thR == null) {
            lVar.resumeWith(Boolean.FALSE);
        } else {
            lVar.resumeWith(r2.q.M(thR));
        }
    }

    public final boolean G(Object obj, Object obj2) {
        if (obj instanceof y6.f) {
            return ((y6.e) ((y6.f) obj)).g(this, obj2) == 0;
        }
        if (obj instanceof y) {
            return j.a(((y) obj).f13760a, new o(obj2), null);
        }
        if (!(obj instanceof c)) {
            if (obj instanceof q6.j) {
                return j.a((q6.j) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        c cVar = (c) obj;
        q6.l lVar = cVar.f13724b;
        kotlin.jvm.internal.k.b(lVar);
        cVar.f13724b = null;
        cVar.f13723a = obj2;
        return j.a(lVar, Boolean.TRUE, null);
    }

    public final boolean H(Object obj, p pVar, int i2) {
        y6.i iVar;
        boolean z2 = obj instanceof q6.j;
        q5.x xVar = q5.x.f13520a;
        if (z2) {
            return j.a((q6.j) obj, xVar, null);
        }
        if (!(obj instanceof y6.f)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        int iG = ((y6.e) obj).g(this, xVar);
        if (iG == 0) {
            iVar = y6.i.f17872a;
        } else if (iG == 1) {
            iVar = y6.i.f17873b;
        } else if (iG == 2) {
            iVar = y6.i.f17874c;
        } else {
            if (iG != 3) {
                throw new IllegalStateException(("Unexpected internal result: " + iG).toString());
            }
            iVar = y6.i.f17875d;
        }
        if (iVar == y6.i.f17873b) {
            pVar.n(i2, null);
        }
        return iVar == y6.i.f17872a;
    }

    public final Object I(p pVar, int i2, long j3, Object obj) {
        Object objL = pVar.l(i2);
        AtomicReferenceArray atomicReferenceArray = pVar.f13754f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13730b;
        if (objL == null) {
            if (j3 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return j.f13743n;
                }
                if (pVar.k(i2, objL, obj)) {
                    n();
                    return j.m;
                }
            }
        } else if (objL == j.f13740d && pVar.k(i2, objL, j.f13742i)) {
            n();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            pVar.n(i2, null);
            return obj2;
        }
        while (true) {
            Object objL2 = pVar.l(i2);
            if (objL2 == null || objL2 == j.e) {
                if (j3 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (pVar.k(i2, objL2, j.h)) {
                        n();
                        return j.f13744o;
                    }
                } else {
                    if (obj == null) {
                        return j.f13743n;
                    }
                    if (pVar.k(i2, objL2, obj)) {
                        n();
                        return j.m;
                    }
                }
            } else if (objL2 != j.f13740d) {
                e2.f fVar = j.j;
                if (objL2 == fVar) {
                    return j.f13744o;
                }
                if (objL2 == j.h) {
                    return j.f13744o;
                }
                if (objL2 == j.l) {
                    n();
                    return j.f13744o;
                }
                if (objL2 != j.g && pVar.k(i2, objL2, j.f13741f)) {
                    boolean z2 = objL2 instanceof b0;
                    if (z2) {
                        objL2 = ((b0) objL2).f13722a;
                    }
                    if (H(objL2, pVar, i2)) {
                        pVar.o(i2, j.f13742i);
                        n();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        pVar.n(i2, null);
                        return obj3;
                    }
                    pVar.o(i2, fVar);
                    pVar.i();
                    if (z2) {
                        n();
                    }
                    return j.f13744o;
                }
            } else if (pVar.k(i2, objL2, j.f13742i)) {
                n();
                Object obj4 = atomicReferenceArray.get(i2 * 2);
                pVar.n(i2, null);
                return obj4;
            }
        }
    }

    public final int J(p pVar, int i2, Object obj, long j3, Object obj2, boolean z2) {
        while (true) {
            Object objL = pVar.l(i2);
            if (objL == null) {
                if (!g(j3) || z2) {
                    if (z2) {
                        if (pVar.k(i2, null, j.j)) {
                            pVar.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (pVar.k(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (pVar.k(i2, null, j.f13740d)) {
                    break;
                }
            } else {
                if (objL != j.e) {
                    e2.f fVar = j.k;
                    if (objL == fVar) {
                        pVar.n(i2, null);
                        return 5;
                    }
                    if (objL == j.h) {
                        pVar.n(i2, null);
                        return 5;
                    }
                    if (objL == j.l) {
                        pVar.n(i2, null);
                        y();
                        return 4;
                    }
                    pVar.n(i2, null);
                    if (objL instanceof b0) {
                        objL = ((b0) objL).f13722a;
                    }
                    if (G(objL, obj)) {
                        pVar.o(i2, j.f13742i);
                        return 0;
                    }
                    if (pVar.f13754f.getAndSet((i2 * 2) + 1, fVar) != fVar) {
                        pVar.m(i2, true);
                    }
                    return 5;
                }
                if (pVar.k(i2, objL, j.f13740d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void K(long j3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        h hVar = this;
        if (hVar.A()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f13732d;
            if (atomicLongFieldUpdater.get(hVar) > j3) {
                break;
            } else {
                hVar = this;
            }
        }
        int i2 = j.f13739c;
        int i8 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (i8 < i2) {
                long j8 = atomicLongFieldUpdater.get(hVar);
                if (j8 == (4611686018427387903L & atomicLongFieldUpdater2.get(hVar)) && j8 == atomicLongFieldUpdater.get(hVar)) {
                    return;
                } else {
                    i8++;
                }
            } else {
                while (true) {
                    long j9 = atomicLongFieldUpdater2.get(hVar);
                    if (atomicLongFieldUpdater2.compareAndSet(hVar, j9, (j9 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        hVar = this;
                    }
                }
                while (true) {
                    long j10 = atomicLongFieldUpdater.get(hVar);
                    long j11 = atomicLongFieldUpdater2.get(hVar);
                    long j12 = j11 & 4611686018427387903L;
                    boolean z2 = (j11 & 4611686018427387904L) != 0;
                    if (j10 == j12 && j10 == atomicLongFieldUpdater.get(hVar)) {
                        break;
                    }
                    if (z2) {
                        hVar = this;
                    } else {
                        hVar = this;
                        atomicLongFieldUpdater2.compareAndSet(hVar, j11, 4611686018427387904L + j12);
                    }
                }
                while (true) {
                    long j13 = atomicLongFieldUpdater2.get(hVar);
                    if (atomicLongFieldUpdater2.compareAndSet(hVar, j13, j13 & 4611686018427387903L)) {
                        return;
                    } else {
                        hVar = this;
                    }
                }
            }
        }
    }

    @Override // s6.z
    public final void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        i(true, cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
    
        e(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0173 A[RETURN] */
    @Override // s6.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(java.lang.Object r24, v5.c r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.c(java.lang.Object, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // s6.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = s6.h.f13730b
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.w(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.g(r1)
            r1 = r1 ^ r10
        L1b:
            s6.n r13 = s6.o.f13752b
            if (r1 == 0) goto L20
            return r13
        L20:
            e2.f r6 = s6.j.j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = s6.h.f13733f
            java.lang.Object r1 = r1.get(r15)
            s6.p r1 = (s6.p) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.w(r2, r9)
            int r14 = s6.j.f13738b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.f17648c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            s6.p r3 = b(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        L54:
            r9 = 0
            r10 = 1
        L56:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r9 = f(r0, r1, r2, r3, r4, r6, r7)
            q5.x r3 = q5.x.f13520a
            if (r9 == 0) goto Lbe
            r10 = 1
            if (r9 == r10) goto Lbd
            r3 = 2
            if (r9 == r3) goto L9c
            r2 = 3
            if (r9 == r2) goto L94
            r2 = 4
            if (r9 == r2) goto L7d
            r2 = 5
            if (r9 == r2) goto L78
            goto L7b
        L78:
            r1.b()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = s6.h.f13731c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.b()
        L8a:
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        L94:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L9c:
            if (r7 == 0) goto Lab
            r1.i()
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        Lab:
            boolean r3 = r6 instanceof q6.f2
            if (r3 == 0) goto Lb2
            q6.f2 r6 = (q6.f2) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.b(r1, r2)
        Lb9:
            r1.i()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.b()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.d(java.lang.Object):java.lang.Object");
    }

    public final boolean g(long j3) {
        return j3 < f13732d.get(this) || j3 < f13731c.get(this) + ((long) this.f13735a);
    }

    @Override // s6.z
    public final android.support.v4.media.g h() {
        d0.d(3, d.f13726b);
        d0.d(3, e.f13727b);
        return new android.support.v4.media.g(this, (b) null);
    }

    public final boolean i(boolean z2, Throwable th) {
        h hVar;
        boolean z7;
        long j3;
        long j8;
        long j9;
        Object obj;
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13730b;
        if (!z2) {
            hVar = this;
            break;
        }
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (((int) (j11 >> 60)) != 0) {
                hVar = this;
                break;
            }
            p pVar = j.f13737a;
            hVar = this;
        } while (!atomicLongFieldUpdater.compareAndSet(hVar, j11, (j11 & 1152921504606846975L) + (((long) 1) << 60)));
        e2.f fVar = j.f13747s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13734i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, fVar, th)) {
                z7 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != fVar) {
                z7 = false;
                break;
            }
        }
        if (z2) {
            do {
                j10 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(hVar, j10, (((long) 3) << 60) + (j10 & 1152921504606846975L)));
        } else {
            do {
                j3 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j3 >> 60);
                if (i2 == 0) {
                    j8 = j3 & 1152921504606846975L;
                    j9 = 2;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j8 = j3 & 1152921504606846975L;
                    j9 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(hVar, j3, (j9 << 60) + j8));
        }
        y();
        if (z7) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = j;
                obj = atomicReferenceFieldUpdater2.get(this);
                e2.f fVar2 = obj == null ? j.f13745q : j.f13746r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, fVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                d0.d(1, obj);
                ((e6.l) obj).invoke(r());
                return z7;
            }
        }
        return z7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (s6.p) ((v6.b) v6.b.f17619b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final s6.p j(long r13) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.j(long):s6.p");
    }

    public final void k(long j3) {
        p pVar = (p) g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f13731c;
            long j8 = atomicLongFieldUpdater.get(this);
            if (j3 < Math.max(((long) this.f13735a) + j8, f13732d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j8, 1 + j8)) {
                long j9 = j.f13738b;
                long j10 = j8 / j9;
                int i2 = (int) (j8 % j9);
                if (pVar.f17648c != j10) {
                    p pVarQ = q(j10, pVar);
                    if (pVarQ != null) {
                        pVar = pVarQ;
                    }
                }
                p pVar2 = pVar;
                if (I(pVar2, i2, j8, null) != j.f13744o || j8 < u()) {
                    pVar2.b();
                }
                pVar = pVar2;
            }
        }
    }

    @Override // s6.z
    public final Object l() {
        p pVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f13731c;
        long j3 = atomicLongFieldUpdater.get(this);
        long j8 = f13730b.get(this);
        if (w(j8, true)) {
            return new m(r());
        }
        long j9 = j8 & 1152921504606846975L;
        n nVar = o.f13752b;
        if (j3 >= j9) {
            return nVar;
        }
        Object obj = j.k;
        p pVar2 = (p) g.get(this);
        while (!x()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j10 = j.f13738b;
            long j11 = andIncrement / j10;
            int i2 = (int) (andIncrement % j10);
            if (pVar2.f17648c != j11) {
                p pVarQ = q(j11, pVar2);
                if (pVarQ == null) {
                    continue;
                } else {
                    pVar = pVarQ;
                }
            } else {
                pVar = pVar2;
            }
            Object objI = I(pVar, i2, andIncrement, obj);
            p pVar3 = pVar;
            if (objI == j.m) {
                f2 f2Var = obj instanceof f2 ? (f2) obj : null;
                if (f2Var != null) {
                    f2Var.b(pVar3, i2);
                }
                K(andIncrement);
                pVar3.i();
                return nVar;
            }
            if (objI != j.f13744o) {
                if (objI == j.f13743n) {
                    throw new IllegalStateException("unexpected");
                }
                pVar3.b();
                return objI;
            }
            if (andIncrement < u()) {
                pVar3.b();
            }
            pVar2 = pVar3;
        }
        return new m(r());
    }

    @Override // s6.z
    public final Object m(v5.c cVar) throws Throwable {
        p pVar;
        Throwable th;
        p pVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        p pVar3 = (p) atomicReferenceFieldUpdater.get(this);
        while (!x()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f13731c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j3 = j.f13738b;
            long j8 = andIncrement / j3;
            int i2 = (int) (andIncrement % j3);
            if (pVar3.f17648c != j8) {
                p pVarQ = q(j8, pVar3);
                if (pVarQ == null) {
                    continue;
                } else {
                    pVar = pVarQ;
                }
            } else {
                pVar = pVar3;
            }
            Object objI = I(pVar, i2, andIncrement, null);
            e2.f fVar = j.m;
            if (objI == fVar) {
                throw new IllegalStateException("unexpected");
            }
            e2.f fVar2 = j.f13744o;
            if (objI == fVar2) {
                if (andIncrement < u()) {
                    pVar.b();
                }
                pVar3 = pVar;
            } else {
                if (objI != j.f13743n) {
                    pVar.b();
                    return objI;
                }
                q6.l lVarQ = c0.q(a.a.I(cVar));
                h hVar = this;
                try {
                    Object objI2 = hVar.I(pVar, i2, andIncrement, lVarQ);
                    if (objI2 == fVar) {
                        lVarQ.b(pVar, i2);
                    } else {
                        if (objI2 == fVar2) {
                            if (andIncrement < u()) {
                                pVar.b();
                            }
                            p pVar4 = (p) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (x()) {
                                    lVarQ.resumeWith(r2.q.M(s()));
                                    break;
                                }
                                q6.l lVar = lVarQ;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j9 = j.f13738b;
                                    long j10 = andIncrement2 / j9;
                                    int i8 = (int) (andIncrement2 % j9);
                                    if (pVar4.f17648c != j10) {
                                        try {
                                            p pVarQ2 = q(j10, pVar4);
                                            if (pVarQ2 == null) {
                                                lVarQ = lVar;
                                            } else {
                                                pVar2 = pVarQ2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            lVarQ = lVar;
                                            lVarQ.y();
                                            throw th;
                                        }
                                    } else {
                                        pVar2 = pVar4;
                                    }
                                    objI2 = hVar.I(pVar2, i8, andIncrement2, lVar);
                                    p pVar5 = pVar2;
                                    lVarQ = lVar;
                                    if (objI2 == j.m) {
                                        lVarQ.b(pVar5, i8);
                                        break;
                                    }
                                    if (objI2 == j.f13744o) {
                                        if (andIncrement2 < u()) {
                                            pVar5.b();
                                        }
                                        hVar = this;
                                        pVar4 = pVar5;
                                    } else {
                                        if (objI2 == j.f13743n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        pVar5.b();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    lVarQ = lVar;
                                    th = th;
                                    lVarQ.y();
                                    throw th;
                                }
                            }
                        } else {
                            pVar.b();
                        }
                        lVarQ.z(objI2, null);
                    }
                    Object objP = lVarQ.p();
                    w5.a aVar = w5.a.f17774a;
                    return objP;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thS = s();
        int i9 = v6.t.f17649a;
        throw thS;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        v(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.n():void");
    }

    @Override // s6.a0
    public final boolean o(Throwable th) {
        return i(false, th);
    }

    @Override // s6.z
    public final Object p(u6.i iVar) {
        return D(this, iVar);
    }

    public final p q(long j3, p pVar) {
        Object objB;
        long j8;
        p pVar2 = j.f13737a;
        i iVar = i.f13736b;
        loop0: while (true) {
            objB = v6.a.b(pVar, j3, iVar);
            if (!v6.a.e(objB)) {
                v6.s sVarC = v6.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
                    v6.s sVar = (v6.s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f17648c >= sVarC.f17648c) {
                        break loop0;
                    }
                    if (!sVarC.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.f()) {
                                sVarC.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            } else {
                break;
            }
        }
        if (v6.a.e(objB)) {
            y();
            if (pVar.f17648c * ((long) j.f13738b) < u()) {
                pVar.b();
                return null;
            }
        } else {
            p pVar3 = (p) v6.a.c(objB);
            long j9 = pVar3.f17648c;
            if (!A() && j3 <= f13732d.get(this) / ((long) j.f13738b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
                    v6.s sVar2 = (v6.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f17648c >= j9 || !pVar3.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, pVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                            if (pVar3.f()) {
                                pVar3.e();
                            }
                        }
                    }
                    if (sVar2.f()) {
                        sVar2.e();
                    }
                }
            }
            if (j9 <= j3) {
                return pVar3;
            }
            long j10 = j9 * ((long) j.f13738b);
            do {
                j8 = f13731c.get(this);
                if (j8 >= j10) {
                    break;
                }
            } while (!f13731c.compareAndSet(this, j8, j10));
            if (j9 * ((long) j.f13738b) < u()) {
                pVar3.b();
            }
        }
        return null;
    }

    public final Throwable r() {
        return (Throwable) f13734i.get(this);
    }

    public final Throwable s() {
        Throwable thR = r();
        return thR == null ? new r("Channel was closed") : thR;
    }

    public final Throwable t() {
        Throwable thR = r();
        return thR == null ? new s("Channel was closed") : thR;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b7, code lost:
    
        r16 = r7;
        r3 = (s6.p) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c0, code lost:
    
        if (r3 != null) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.toString():java.lang.String");
    }

    public final long u() {
        return f13730b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (s6.p) ((v6.b) v6.b.f17619b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean w(long r14, boolean r16) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.h.w(long, boolean):boolean");
    }

    public final boolean x() {
        return w(f13730b.get(this), true);
    }

    public final boolean y() {
        return w(f13730b.get(this), false);
    }

    public boolean z() {
        return false;
    }
}
