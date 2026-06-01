package q6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class n1 implements f1, t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13574a = AtomicReferenceFieldUpdater.newUpdater(n1.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13575b = AtomicReferenceFieldUpdater.newUpdater(n1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public n1(boolean z2) {
        this._state$volatile = z2 ? c0.j : c0.f13537i;
    }

    public static p Q(v6.j jVar) {
        while (jVar.g()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v6.j.f17632b;
            v6.j jVarD = jVar.d();
            if (jVarD == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (v6.j) obj;
                    if (!jVar.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = jVarD;
            }
        }
        while (true) {
            jVar = jVar.f();
            if (!jVar.g()) {
                if (jVar instanceof p) {
                    return (p) jVar;
                }
                if (jVar instanceof p1) {
                    return null;
                }
            }
        }
    }

    public static String X(Object obj) {
        if (!(obj instanceof m1)) {
            return obj instanceof b1 ? ((b1) obj).isActive() ? "Active" : "New" : obj instanceof u ? "Cancelled" : "Completed";
        }
        m1 m1Var = (m1) obj;
        return m1Var.d() ? "Cancelling" : m1.f13568b.get(m1Var) != 0 ? "Completing" : "Active";
    }

    public final Throwable A(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        n1 n1Var = (n1) ((t1) obj);
        Object obj2 = f13574a.get(n1Var);
        if (obj2 instanceof m1) {
            thC = ((m1) obj2).c();
        } else if (obj2 instanceof u) {
            thC = ((u) obj2).f13591a;
        } else {
            if (obj2 instanceof b1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new g1("Parent job is ".concat(X(obj2)), thC, n1Var) : cancellationException;
    }

    public final Object B(m1 m1Var, Object obj) {
        Throwable thC;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th = uVar != null ? uVar.f13591a : null;
        synchronized (m1Var) {
            m1Var.d();
            ArrayList arrayListE = m1Var.e(th);
            thC = C(m1Var, arrayListE);
            if (thC != null && arrayListE.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListE.size()));
                int size = arrayListE.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayListE.get(i2);
                    i2++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != thC && th2 != thC && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        a.a.h(thC, th2);
                    }
                }
            }
        }
        if (thC != null && thC != th) {
            obj = new u(false, thC);
        }
        if (thC != null && (w(thC) || G(thC))) {
            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            u.f13590b.compareAndSet((u) obj, 0, 1);
        }
        S(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13574a;
        Object c1Var = obj instanceof b1 ? new c1((b1) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, m1Var, c1Var) && atomicReferenceFieldUpdater.get(this) == m1Var) {
        }
        z(m1Var, obj);
        return obj;
    }

    public final Throwable C(m1 m1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (m1Var.d()) {
                return new g1(x(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i8);
            i8++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof z1) {
            int size2 = arrayList.size();
            while (true) {
                if (i2 >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i2);
                i2++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof z1)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean D() {
        return true;
    }

    public boolean E() {
        return this instanceof r;
    }

    public final p1 F(b1 b1Var) {
        p1 p1VarB = b1Var.b();
        if (p1VarB != null) {
            return p1VarB;
        }
        if (b1Var instanceof q0) {
            return new p1();
        }
        if (b1Var instanceof j1) {
            V((j1) b1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + b1Var).toString());
    }

    public boolean G(Throwable th) {
        return false;
    }

    public final void I(f1 f1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13575b;
        r1 r1Var = r1.f13582a;
        if (f1Var == null) {
            atomicReferenceFieldUpdater.set(this, r1Var);
            return;
        }
        f1Var.start();
        o oVarK = f1Var.k(this);
        atomicReferenceFieldUpdater.set(this, oVarK);
        if (K()) {
            oVarK.dispose();
            atomicReferenceFieldUpdater.set(this, r1Var);
        }
    }

    public final o0 J(boolean z2, j1 j1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        r1 r1Var;
        boolean z7;
        boolean zC;
        j1Var.f13556d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f13574a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z8 = obj instanceof q0;
            r1Var = r1.f13582a;
            z7 = true;
            if (!z8) {
                if (!(obj instanceof b1)) {
                    z7 = false;
                    break;
                }
                b1 b1Var = (b1) obj;
                p1 p1VarB = b1Var.b();
                if (p1VarB == null) {
                    V((j1) obj);
                } else {
                    if (j1Var.i()) {
                        m1 m1Var = b1Var instanceof m1 ? (m1) b1Var : null;
                        Throwable thC = m1Var != null ? m1Var.c() : null;
                        if (thC == null) {
                            zC = p1VarB.c(j1Var, 5);
                        } else if (z2) {
                            j1Var.j(thC);
                            return r1Var;
                        }
                    } else {
                        zC = p1VarB.c(j1Var, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                q0 q0Var = (q0) obj;
                if (q0Var.f13578a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, j1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                U(q0Var);
            }
        }
        if (z7) {
            return j1Var;
        }
        if (z2) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            j1Var.j(uVar != null ? uVar.f13591a : null);
        }
        return r1Var;
    }

    public final boolean K() {
        return !(f13574a.get(this) instanceof b1);
    }

    public boolean L() {
        return this instanceof f;
    }

    public final Object M(v5.c cVar) {
        Object obj;
        q5.x xVar;
        do {
            obj = f13574a.get(this);
            boolean z2 = obj instanceof b1;
            xVar = q5.x.f13520a;
            if (!z2) {
                c0.l(cVar.getContext());
                return xVar;
            }
        } while (W(obj) < 0);
        l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        lVar.u(new h(c0.s(this, true, new n(lVar, 1)), 2));
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        if (objP != aVar) {
            objP = xVar;
        }
        return objP == aVar ? objP : xVar;
    }

    public final boolean N(Object obj) {
        Object objY;
        do {
            objY = Y(f13574a.get(this), obj);
            if (objY == c0.f13535d) {
                return false;
            }
            if (objY == c0.e) {
                return true;
            }
        } while (objY == c0.f13536f);
        r(objY);
        return true;
    }

    public final Object O(Object obj) {
        Object objY;
        do {
            objY = Y(f13574a.get(this), obj);
            if (objY == c0.f13535d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                u uVar = obj instanceof u ? (u) obj : null;
                throw new IllegalStateException(str, uVar != null ? uVar.f13591a : null);
            }
        } while (objY == c0.f13536f);
        return objY;
    }

    public String P() {
        return getClass().getSimpleName();
    }

    public final void R(p1 p1Var, Throwable th) {
        p1Var.c(new v6.h(4), 4);
        Object obj = v6.j.f17631a.get(p1Var);
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        e2.s sVar = null;
        for (v6.j jVarF = (v6.j) obj; !jVarF.equals(p1Var); jVarF = jVarF.f()) {
            if ((jVarF instanceof j1) && ((j1) jVarF).i()) {
                try {
                    ((j1) jVarF).j(th);
                } catch (Throwable th2) {
                    if (sVar != null) {
                        a.a.h(sVar, th2);
                    } else {
                        sVar = new e2.s("Exception in completion handler " + jVarF + " for " + this, th2, 5);
                    }
                }
            }
        }
        if (sVar != null) {
            H(sVar);
        }
        w(th);
    }

    public final void U(q0 q0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        p1 p1Var = new p1();
        Object a1Var = p1Var;
        if (!q0Var.f13578a) {
            a1Var = new a1(p1Var);
        }
        do {
            atomicReferenceFieldUpdater = f13574a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, q0Var, a1Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == q0Var);
    }

    public final void V(j1 j1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        p1 p1Var = new p1();
        j1Var.getClass();
        v6.j.f17632b.set(p1Var, j1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = v6.j.f17631a;
        atomicReferenceFieldUpdater2.set(p1Var, j1Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(j1Var) == j1Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(j1Var, j1Var, p1Var)) {
                    if (atomicReferenceFieldUpdater2.get(j1Var) != j1Var) {
                        break;
                    }
                }
                p1Var.e(j1Var);
                break loop0;
            }
            break;
        }
        v6.j jVarF = j1Var.f();
        do {
            atomicReferenceFieldUpdater = f13574a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, j1Var, jVarF)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == j1Var);
    }

    public final int W(Object obj) {
        boolean z2 = obj instanceof q0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13574a;
        if (z2) {
            if (((q0) obj).f13578a) {
                return 0;
            }
            q0 q0Var = c0.j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            T();
            return 1;
        }
        if (!(obj instanceof a1)) {
            return 0;
        }
        p1 p1Var = ((a1) obj).f13524a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, p1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        T();
        return 1;
    }

    public final Object Y(Object obj, Object obj2) {
        if (!(obj instanceof b1)) {
            return c0.f13535d;
        }
        if (((obj instanceof q0) || (obj instanceof j1)) && !(obj instanceof p) && !(obj2 instanceof u)) {
            b1 b1Var = (b1) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13574a;
            Object c1Var = obj2 instanceof b1 ? new c1((b1) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, b1Var, c1Var)) {
                if (atomicReferenceFieldUpdater.get(this) != b1Var) {
                    return c0.f13536f;
                }
            }
            S(obj2);
            z(b1Var, obj2);
            return obj2;
        }
        b1 b1Var2 = (b1) obj;
        p1 p1VarF = F(b1Var2);
        if (p1VarF == null) {
            return c0.f13536f;
        }
        m1 m1Var = b1Var2 instanceof m1 ? (m1) b1Var2 : null;
        if (m1Var == null) {
            m1Var = new m1(p1VarF, null);
        }
        synchronized (m1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m1.f13568b;
            if (atomicIntegerFieldUpdater.get(m1Var) != 0) {
                return c0.f13535d;
            }
            atomicIntegerFieldUpdater.set(m1Var, 1);
            if (m1Var != b1Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f13574a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, b1Var2, m1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != b1Var2) {
                        return c0.f13536f;
                    }
                }
            }
            boolean zD = m1Var.d();
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            if (uVar != null) {
                m1Var.a(uVar.f13591a);
            }
            Throwable thC = zD ? null : m1Var.c();
            if (thC != null) {
                R(p1VarF, thC);
            }
            p pVarQ = Q(p1VarF);
            if (pVarQ != null && Z(m1Var, pVarQ, obj2)) {
                return c0.e;
            }
            p1VarF.c(new v6.h(2), 2);
            p pVarQ2 = Q(p1VarF);
            return (pVarQ2 == null || !Z(m1Var, pVarQ2, obj2)) ? B(m1Var, obj2) : c0.e;
        }
    }

    public final boolean Z(m1 m1Var, p pVar, Object obj) {
        while (c0.s(pVar.e, false, new l1(this, m1Var, pVar, obj)) == r1.f13582a) {
            pVar = Q(pVar);
            if (pVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // q6.f1
    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new g1(x(), null, this);
        }
        v(cancellationException);
    }

    public Object b() throws Throwable {
        Object obj = f13574a.get(this);
        if (obj instanceof b1) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof u) {
            throw ((u) obj).f13591a;
        }
        return c0.F(obj);
    }

    @Override // v5.h
    public final Object fold(Object obj, e6.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // q6.f1
    public final CancellationException g() {
        CancellationException cancellationException;
        Object obj = f13574a.get(this);
        if (!(obj instanceof m1)) {
            if (obj instanceof b1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(obj instanceof u)) {
                return new g1(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((u) obj).f13591a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new g1(x(), th, this) : cancellationException;
        }
        Throwable thC = ((m1) obj).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = x();
        }
        return new g1(strConcat, thC, this);
    }

    @Override // v5.h
    public final v5.f get(v5.g gVar) {
        return a.a.A(this, gVar);
    }

    @Override // v5.f
    public final v5.g getKey() {
        return e1.f13546a;
    }

    @Override // q6.f1
    public final o0 i(boolean z2, boolean z7, i1 i1Var) {
        return J(z7, z2 ? new d1(i1Var) : new p0(i1Var, 1));
    }

    @Override // q6.f1
    public boolean isActive() {
        Object obj = f13574a.get(this);
        return (obj instanceof b1) && ((b1) obj).isActive();
    }

    @Override // q6.f1
    public final boolean isCancelled() {
        Object obj = f13574a.get(this);
        if (obj instanceof u) {
            return true;
        }
        return (obj instanceof m1) && ((m1) obj).d();
    }

    @Override // q6.f1
    public final o k(n1 n1Var) {
        p pVar = new p(n1Var);
        pVar.f13556d = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13574a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof q0) {
                q0 q0Var = (q0) obj;
                if (q0Var.f13578a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                U(q0Var);
            } else {
                boolean z2 = obj instanceof b1;
                r1 r1Var = r1.f13582a;
                if (!z2) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    u uVar = obj2 instanceof u ? (u) obj2 : null;
                    pVar.j(uVar != null ? uVar.f13591a : null);
                    return r1Var;
                }
                p1 p1VarB = ((b1) obj).b();
                if (p1VarB == null) {
                    V((j1) obj);
                } else if (!p1VarB.c(pVar, 7)) {
                    boolean zC = p1VarB.c(pVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof m1) {
                        thC = ((m1) obj3).c();
                    } else {
                        u uVar2 = obj3 instanceof u ? (u) obj3 : null;
                        if (uVar2 != null) {
                            thC = uVar2.f13591a;
                        }
                    }
                    pVar.j(thC);
                    if (zC) {
                        break loop0;
                    }
                    return r1Var;
                }
            }
        }
        return pVar;
    }

    @Override // v5.h
    public final v5.h minusKey(v5.g gVar) {
        return a.a.N(this, gVar);
    }

    @Override // q6.f1
    public final o0 n(e6.l lVar) {
        return J(true, new p0(lVar, 1));
    }

    @Override // v5.h
    public final v5.h plus(v5.h hVar) {
        return a.a.O(this, hVar);
    }

    public void s(Object obj) {
        r(obj);
    }

    @Override // q6.f1
    public final boolean start() {
        int iW;
        do {
            iW = W(f13574a.get(this));
            if (iW == 0) {
                return false;
            }
        } while (iW != 1);
        return true;
    }

    public final Object t(v5.c cVar) throws Throwable {
        Object obj;
        do {
            obj = f13574a.get(this);
            if (!(obj instanceof b1)) {
                if (obj instanceof u) {
                    throw ((u) obj).f13591a;
                }
                return c0.F(obj);
            }
        } while (W(obj) < 0);
        k1 k1Var = new k1(a.a.I(cVar), this);
        k1Var.r();
        int i2 = 2;
        k1Var.u(new h(c0.s(this, true, new p0(k1Var, i2)), i2));
        Object objP = k1Var.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(P() + '{' + X(f13574a.get(this)) + '}');
        sb.append('@');
        sb.append(c0.p(this));
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r0
  0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.n1.u(java.lang.Object):boolean");
    }

    public void v(CancellationException cancellationException) {
        u(cancellationException);
    }

    public final boolean w(Throwable th) {
        if (L()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        o oVar = (o) f13575b.get(this);
        return (oVar == null || oVar == r1.f13582a) ? z2 : oVar.a(th) || z2;
    }

    public String x() {
        return "Job was cancelled";
    }

    public boolean y(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return u(th) && D();
    }

    public final void z(b1 b1Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13575b;
        o oVar = (o) atomicReferenceFieldUpdater.get(this);
        if (oVar != null) {
            oVar.dispose();
            atomicReferenceFieldUpdater.set(this, r1.f13582a);
        }
        e2.s sVar = null;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th = uVar != null ? uVar.f13591a : null;
        if (b1Var instanceof j1) {
            try {
                ((j1) b1Var).j(th);
                return;
            } catch (Throwable th2) {
                H(new e2.s("Exception in completion handler " + b1Var + " for " + this, th2, 5));
                return;
            }
        }
        p1 p1VarB = b1Var.b();
        if (p1VarB != null) {
            p1VarB.c(new v6.h(1), 1);
            Object obj2 = v6.j.f17631a.get(p1VarB);
            kotlin.jvm.internal.k.c(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            for (v6.j jVarF = (v6.j) obj2; !jVarF.equals(p1VarB); jVarF = jVarF.f()) {
                if (jVarF instanceof j1) {
                    try {
                        ((j1) jVarF).j(th);
                    } catch (Throwable th3) {
                        if (sVar != null) {
                            a.a.h(sVar, th3);
                        } else {
                            sVar = new e2.s("Exception in completion handler " + jVarF + " for " + this, th3, 5);
                        }
                    }
                }
            }
            if (sVar != null) {
                H(sVar);
            }
        }
    }

    public void T() {
    }

    public void H(e2.s sVar) {
        throw sVar;
    }

    public void S(Object obj) {
    }

    public void r(Object obj) {
    }
}
