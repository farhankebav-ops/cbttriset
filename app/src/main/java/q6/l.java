package q6;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class l extends k0 implements j, x5.d, f2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f13561f = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v5.c f13562d;
    public final v5.h e;

    public l(int i2, v5.c cVar) {
        super(i2);
        this.f13562d = cVar;
        this.e = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f13525a;
    }

    public static Object C(s1 s1Var, Object obj, int i2, e6.q qVar) {
        if (obj instanceof u) {
            return obj;
        }
        if (i2 != 1 && i2 != 2) {
            return obj;
        }
        if (qVar != null || (s1Var instanceof i)) {
            return new t(obj, s1Var instanceof i ? (i) s1Var : null, qVar, (Throwable) null, 16);
        }
        return obj;
    }

    public static void w(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(Object obj, int i2, e6.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof s1) {
                Object objC = C((s1) obj2, obj, i2, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!v()) {
                    m();
                }
                n(i2);
                return;
            }
            if (obj2 instanceof m) {
                m mVar = (m) obj2;
                if (m.f13565c.compareAndSet(mVar, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, mVar.f13591a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final void B(w wVar) {
        v5.c cVar = this.f13562d;
        v6.f fVar = cVar instanceof v6.f ? (v6.f) cVar : null;
        A(q5.x.f13520a, (fVar != null ? fVar.f17623d : null) == wVar ? 4 : this.f13559c, null);
    }

    public final e2.f D(Object obj, e6.q qVar) {
        e2.f fVar = c0.f13532a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof s1)) {
                return null;
            }
            Object objC = C((s1) obj2, obj, this.f13559c, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!v()) {
                m();
            }
            return fVar;
        }
    }

    @Override // q6.k0
    public final void a(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof s1) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof u) {
                return;
            }
            if (!(obj instanceof t)) {
                cancellationException2 = cancellationException;
                t tVar = new t(obj, (i) null, (e6.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, tVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            t tVar2 = (t) obj;
            if (tVar2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            t tVarA = t.a(tVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, tVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            i iVar = tVar2.f13585b;
            if (iVar != null) {
                j(iVar, cancellationException);
            }
            e6.q qVar = tVar2.f13586c;
            if (qVar != null) {
                k(qVar, cancellationException, tVar2.f13584a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // q6.f2
    public final void b(v6.s sVar, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        do {
            atomicIntegerFieldUpdater = f13561f;
            i8 = atomicIntegerFieldUpdater.get(this);
            if ((i8 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, ((i8 >> 29) << 29) + i2));
        u(sVar);
    }

    @Override // q6.k0
    public final v5.c c() {
        return this.f13562d;
    }

    @Override // q6.k0
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // q6.j
    public final boolean e(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof s1)) {
                return false;
            }
            m mVar = new m(this, th, (obj instanceof i) || (obj instanceof v6.s));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            s1 s1Var = (s1) obj;
            if (s1Var instanceof i) {
                j((i) obj, th);
            } else if (s1Var instanceof v6.s) {
                l((v6.s) obj, th);
            }
            if (!v()) {
                m();
            }
            n(this.f13559c);
            return true;
        }
    }

    @Override // q6.j
    public final e2.f f(Object obj, e6.q qVar) {
        return D(obj, qVar);
    }

    @Override // q6.k0
    public final Object g(Object obj) {
        return obj instanceof t ? ((t) obj).f13584a : obj;
    }

    @Override // x5.d
    public final x5.d getCallerFrame() {
        v5.c cVar = this.f13562d;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // v5.c
    public final v5.h getContext() {
        return this.e;
    }

    @Override // q6.k0
    public final Object i() {
        return g.get(this);
    }

    @Override // q6.j
    public final boolean isActive() {
        return g.get(this) instanceof s1;
    }

    public final void j(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            c0.r(this.e, new e2.s("Exception in invokeOnCancellation handler for " + this, th2, 5));
        }
    }

    public final void k(e6.q qVar, Throwable th, Object obj) {
        v5.h hVar = this.e;
        try {
            qVar.invoke(th, obj, hVar);
        } catch (Throwable th2) {
            c0.r(hVar, new e2.s("Exception in resume onCancellation handler for " + this, th2, 5));
        }
    }

    public final void l(v6.s sVar, Throwable th) {
        v5.h hVar = this.e;
        int i2 = f13561f.get(this) & 536870911;
        if (i2 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            sVar.h(i2, hVar);
        } catch (Throwable th2) {
            c0.r(hVar, new e2.s("Exception in invokeOnCancellation handler for " + this, th2, 5));
        }
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        o0 o0Var = (o0) atomicReferenceFieldUpdater.get(this);
        if (o0Var == null) {
            return;
        }
        o0Var.dispose();
        atomicReferenceFieldUpdater.set(this, r1.f13582a);
    }

    public final void n(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i8;
        do {
            atomicIntegerFieldUpdater = f13561f;
            i8 = atomicIntegerFieldUpdater.get(this);
            int i9 = i8 >> 29;
            if (i9 != 0) {
                if (i9 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z2 = i2 == 4;
                v5.c cVar = this.f13562d;
                if (!z2 && (cVar instanceof v6.f)) {
                    boolean z7 = i2 == 1 || i2 == 2;
                    int i10 = this.f13559c;
                    if (z7 == (i10 == 1 || i10 == 2)) {
                        v6.f fVar = (v6.f) cVar;
                        w wVar = fVar.f17623d;
                        v5.h context = fVar.e.getContext();
                        if (wVar.isDispatchNeeded(context)) {
                            wVar.dispatch(context, this);
                            return;
                        }
                        w0 w0VarA = x1.a();
                        if (w0VarA.f13597a >= 4294967296L) {
                            w0VarA.p(this);
                            return;
                        }
                        w0VarA.r(true);
                        try {
                            c0.z(this, cVar, true);
                            do {
                            } while (w0VarA.t());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        return;
                    }
                }
                c0.z(this, cVar, z2);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, BasicMeasure.EXACTLY + (536870911 & i8)));
    }

    public Throwable o(n1 n1Var) {
        return n1Var.g();
    }

    public final Object p() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        f1 f1Var;
        boolean zV = v();
        do {
            atomicIntegerFieldUpdater = f13561f;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i8 = i2 >> 29;
            if (i8 != 0) {
                if (i8 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zV) {
                    y();
                }
                Object obj = g.get(this);
                if (obj instanceof u) {
                    throw ((u) obj).f13591a;
                }
                int i9 = this.f13559c;
                if ((i9 != 1 && i9 != 2) || (f1Var = (f1) this.e.get(e1.f13546a)) == null || f1Var.isActive()) {
                    return g(obj);
                }
                CancellationException cancellationExceptionG = f1Var.g();
                a(cancellationExceptionG);
                throw cancellationExceptionG;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((o0) h.get(this)) == null) {
            s();
        }
        if (zV) {
            y();
        }
        return w5.a.f17774a;
    }

    @Override // q6.j
    public final void q(Object obj) {
        n(this.f13559c);
    }

    public final void r() {
        o0 o0VarS = s();
        if (o0VarS == null || (g.get(this) instanceof s1)) {
            return;
        }
        o0VarS.dispose();
        h.set(this, r1.f13582a);
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        Throwable thA = q5.k.a(obj);
        if (thA != null) {
            obj = new u(false, thA);
        }
        A(obj, this.f13559c, null);
    }

    public final o0 s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        f1 f1Var = (f1) this.e.get(e1.f13546a);
        if (f1Var == null) {
            return null;
        }
        o0 o0VarS = c0.s(f1Var, true, new n(this, 0));
        do {
            atomicReferenceFieldUpdater = h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, o0VarS)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return o0VarS;
    }

    public final void t(e6.l lVar) {
        u(new h(lVar, 1));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(x());
        sb.append('(');
        sb.append(c0.D(this.f13562d));
        sb.append("){");
        Object obj = g.get(this);
        sb.append(obj instanceof s1 ? "Active" : obj instanceof m ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(c0.p(this));
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        w(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b1, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(q6.s1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = q6.l.g
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof q6.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto La5
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof q6.i
            r3 = 0
            if (r1 != 0) goto Lae
            boolean r1 = r2 instanceof v6.s
            if (r1 != 0) goto Lae
            boolean r1 = r2 instanceof q6.u
            if (r1 == 0) goto L52
            r0 = r2
            q6.u r0 = (q6.u) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = q6.u.f13590b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L4e
            boolean r1 = r2 instanceof q6.m
            if (r1 == 0) goto La5
            java.lang.Throwable r0 = r0.f13591a
            boolean r1 = r8 instanceof q6.i
            if (r1 == 0) goto L43
            q6.i r8 = (q6.i) r8
            r7.j(r8, r0)
            return
        L43:
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>"
            kotlin.jvm.internal.k.c(r8, r1)
            v6.s r8 = (v6.s) r8
            r7.l(r8, r0)
            return
        L4e:
            w(r8, r2)
            throw r3
        L52:
            boolean r1 = r2 instanceof q6.t
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler"
            if (r1 == 0) goto L8b
            r1 = r2
            q6.t r1 = (q6.t) r1
            q6.i r5 = r1.f13585b
            if (r5 != 0) goto L87
            boolean r5 = r8 instanceof v6.s
            if (r5 == 0) goto L64
            return
        L64:
            kotlin.jvm.internal.k.c(r8, r4)
            r4 = r8
            q6.i r4 = (q6.i) r4
            java.lang.Throwable r5 = r1.e
            if (r5 == 0) goto L72
            r7.j(r4, r5)
            return
        L72:
            r5 = 29
            q6.t r1 = q6.t.a(r1, r4, r3, r5)
        L78:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7f
            goto La5
        L7f:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L78
            goto L0
        L87:
            w(r8, r2)
            throw r3
        L8b:
            boolean r1 = r8 instanceof v6.s
            if (r1 == 0) goto L90
            return
        L90:
            kotlin.jvm.internal.k.c(r8, r4)
            r3 = r8
            q6.i r3 = (q6.i) r3
            q6.t r1 = new q6.t
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L9f:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto La6
        La5:
            return
        La6:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L9f
            goto L0
        Lae:
            w(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.l.u(q6.s1):void");
    }

    public final boolean v() {
        if (this.f13559c != 2) {
            return false;
        }
        v5.c cVar = this.f13562d;
        kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return v6.f.h.get((v6.f) cVar) != null;
    }

    public String x() {
        return "CancellableContinuation";
    }

    public final void y() {
        v5.c cVar = this.f13562d;
        Throwable th = null;
        v6.f fVar = cVar instanceof v6.f ? (v6.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v6.f.h;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                e2.f fVar2 = v6.a.f17615c;
                if (obj == fVar2) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, fVar2, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != fVar2) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            m();
            e(th);
        }
    }

    public final void z(Object obj, e6.q qVar) {
        A(obj, this.f13559c, qVar);
    }
}
