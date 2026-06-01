package q6;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2.f f13532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2.f f13533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f13534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.f f13535d;
    public static final e2.f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e2.f f13536f;
    public static final e2.f g;
    public static final e2.f h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q0 f13537i = new q0(false);
    public static final q0 j = new q0(true);

    static {
        int i2 = 5;
        boolean z2 = false;
        f13532a = new e2.f("RESUME_TOKEN", i2, z2);
        f13533b = new e2.f("REMOVED_TASK", i2, z2);
        f13534c = new e2.f("CLOSED_EMPTY", i2, z2);
        f13535d = new e2.f("COMPLETING_ALREADY", i2, z2);
        e = new e2.f("COMPLETING_WAITING_CHILDREN", i2, z2);
        f13536f = new e2.f("COMPLETING_RETRY", i2, z2);
        g = new e2.f("TOO_LATE_TO_CANCEL", i2, z2);
        h = new e2.f("SEALED", i2, z2);
    }

    public static final Object A(v5.h hVar, e6.p pVar) throws Throwable {
        w0 w0VarA;
        v5.h hVarM;
        Thread threadCurrentThread = Thread.currentThread();
        v5.g gVar = v5.d.f17609a;
        v5.e eVar = (v5.e) hVar.get(gVar);
        v5.i iVar = v5.i.f17610a;
        if (eVar == null) {
            w0VarA = x1.a();
            hVarM = m(iVar, hVar.plus(w0VarA), true);
            x6.e eVar2 = m0.f13566a;
            if (hVarM != eVar2 && hVarM.get(gVar) == null) {
                hVarM = hVarM.plus(eVar2);
            }
        } else {
            if (eVar instanceof w0) {
            }
            w0VarA = (w0) x1.f13601a.get();
            hVarM = m(iVar, hVar, true);
            x6.e eVar3 = m0.f13566a;
            if (hVarM != eVar3 && hVarM.get(gVar) == null) {
                hVarM = hVarM.plus(eVar3);
            }
        }
        f fVar = new f(hVarM, threadCurrentThread, w0VarA);
        fVar.c0(b0.f13526a, fVar, pVar);
        w0 w0Var = fVar.e;
        if (w0Var != null) {
            int i2 = w0.f13596d;
            w0Var.r(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jS = w0Var != null ? w0Var.s() : LocationRequestCompat.PASSIVE_INTERVAL;
                if (fVar.K()) {
                    if (w0Var != null) {
                        int i8 = w0.f13596d;
                        w0Var.o(false);
                    }
                    Object objF = F(n1.f13574a.get(fVar));
                    u uVar = objF instanceof u ? (u) objF : null;
                    if (uVar == null) {
                        return objF;
                    }
                    throw uVar.f13591a;
                }
                LockSupport.parkNanos(fVar, jS);
            } catch (Throwable th) {
                if (w0Var != null) {
                    int i9 = w0.f13596d;
                    w0Var.o(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        fVar.u(interruptedException);
        throw interruptedException;
    }

    public static final Object C(a2 a2Var, e6.p pVar) throws Throwable {
        Object uVar;
        Object objO;
        s(a2Var, true, new p0(o(a2Var.f17646d.getContext()).e(a2Var.e, a2Var, a2Var.f13523c), 0));
        try {
            if (pVar instanceof x5.a) {
                kotlin.jvm.internal.d0.d(2, pVar);
                uVar = pVar.invoke(a2Var, a2Var);
            } else {
                uVar = a.a.Z(pVar, a2Var, a2Var);
            }
        } catch (Throwable th) {
            uVar = new u(false, th);
        }
        w5.a aVar = w5.a.f17774a;
        if (uVar == aVar || (objO = a2Var.O(uVar)) == e) {
            return aVar;
        }
        if (objO instanceof u) {
            Throwable th2 = ((u) objO).f13591a;
            if (!(th2 instanceof z1) || ((z1) th2).f13607a != a2Var) {
                throw th2;
            }
            if (uVar instanceof u) {
                throw ((u) uVar).f13591a;
            }
        } else {
            uVar = F(objO);
        }
        return uVar;
    }

    public static final String D(v5.c cVar) {
        Object objM;
        if (cVar instanceof v6.f) {
            return ((v6.f) cVar).toString();
        }
        try {
            objM = cVar + '@' + p(cVar);
        } catch (Throwable th) {
            objM = r2.q.M(th);
        }
        if (q5.k.a(objM) != null) {
            objM = cVar.getClass().getName() + '@' + p(cVar);
        }
        return (String) objM;
    }

    public static final long E(long j3) {
        int i2 = o6.a.f13207d;
        boolean z2 = j3 > 0;
        if (z2) {
            return o6.a.d(o6.a.g(j3, r2.q.B0(999999L, o6.c.f13210b)));
        }
        if (z2) {
            throw new e2.s(3);
        }
        return 0L;
    }

    public static final Object F(Object obj) {
        b1 b1Var;
        c1 c1Var = obj instanceof c1 ? (c1) obj : null;
        return (c1Var == null || (b1Var = c1Var.f13538a) == null) ? obj : b1Var;
    }

    public static final d2 G(v5.c cVar, v5.h hVar, Object obj) {
        d2 d2Var = null;
        if ((cVar instanceof x5.d) && hVar.get(e2.f13547a) != null) {
            x5.d callerFrame = (x5.d) cVar;
            while (true) {
                if ((callerFrame instanceof j0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof d2) {
                    d2Var = (d2) callerFrame;
                    break;
                }
            }
            if (d2Var != null) {
                d2Var.e0(hVar, obj);
            }
        }
        return d2Var;
    }

    public static final Object H(e6.p pVar, v5.h hVar, v5.c cVar) throws Throwable {
        Object objF;
        v5.h context = cVar.getContext();
        v5.h hVarPlus = !((Boolean) hVar.fold(Boolean.FALSE, new androidx.camera.camera2.internal.compat.workaround.a(3))).booleanValue() ? context.plus(hVar) : m(context, hVar, false);
        l(hVarPlus);
        if (hVarPlus == context) {
            v6.r rVar = new v6.r(cVar, hVarPlus);
            objF = n7.b.Q(rVar, rVar, pVar);
        } else {
            v5.d dVar = v5.d.f17609a;
            if (kotlin.jvm.internal.k.a(hVarPlus.get(dVar), context.get(dVar))) {
                d2 d2Var = new d2(cVar, hVarPlus);
                v5.h hVar2 = d2Var.f13523c;
                Object objL = v6.a.l(hVar2, null);
                try {
                    objF = n7.b.Q(d2Var, d2Var, pVar);
                } finally {
                    v6.a.g(hVar2, objL);
                }
            } else {
                j0 j0Var = new j0(cVar, hVarPlus);
                try {
                    v6.a.h(q5.x.f13520a, a.a.I(a.a.s(pVar, j0Var, j0Var)));
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j0.e;
                    while (true) {
                        int i2 = atomicIntegerFieldUpdater.get(j0Var);
                        if (i2 != 0) {
                            if (i2 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            objF = F(n1.f13574a.get(j0Var));
                            if (objF instanceof u) {
                                throw ((u) objF).f13591a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(j0Var, 0, 1)) {
                            objF = w5.a.f17774a;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    j0Var.resumeWith(r2.q.M(th));
                    throw th;
                }
            }
        }
        w5.a aVar = w5.a.f17774a;
        return objF;
    }

    public static final Object I(long j3, e6.p pVar, x5.c cVar) throws Throwable {
        if (j3 <= 0) {
            throw new z1("Timed out immediately", null);
        }
        Object objC = C(new a2(j3, cVar), pVar);
        w5.a aVar = w5.a.f17774a;
        return objC;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object J(long r6, e6.p r8, v5.c r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof q6.b2
            if (r0 == 0) goto L13
            r0 = r9
            q6.b2 r0 = (q6.b2) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            q6.b2 r0 = new q6.b2
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.a0 r6 = r0.f13530f
            r2.q.z0(r9)     // Catch: q6.z1 -> L29
            return r9
        L29:
            r7 = move-exception
            goto L57
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            r2.q.z0(r9)
            r4 = 0
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L3d
            goto L5d
        L3d:
            kotlin.jvm.internal.a0 r9 = new kotlin.jvm.internal.a0
            r9.<init>()
            r0.f13530f = r9     // Catch: q6.z1 -> L55
            r0.h = r3     // Catch: q6.z1 -> L55
            q6.a2 r2 = new q6.a2     // Catch: q6.z1 -> L55
            r2.<init>(r6, r0)     // Catch: q6.z1 -> L55
            r9.f12717a = r2     // Catch: q6.z1 -> L55
            java.lang.Object r6 = C(r2, r8)     // Catch: q6.z1 -> L55
            if (r6 != r1) goto L54
            return r1
        L54:
            return r6
        L55:
            r7 = move-exception
            r6 = r9
        L57:
            q6.f1 r8 = r7.f13607a
            java.lang.Object r6 = r6.f12717a
            if (r8 != r6) goto L5f
        L5d:
            r6 = 0
            return r6
        L5f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.c0.J(long, e6.p, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object K(x5.c r7) {
        /*
            v5.h r0 = r7.getContext()
            l(r0)
            v5.c r7 = a.a.I(r7)
            boolean r1 = r7 instanceof v6.f
            if (r1 == 0) goto L12
            v6.f r7 = (v6.f) r7
            goto L13
        L12:
            r7 = 0
        L13:
            q5.x r1 = q5.x.f13520a
            if (r7 != 0) goto L1a
        L17:
            r7 = r1
            goto L88
        L1a:
            q6.w r2 = r7.f17623d
            boolean r3 = r2.isDispatchNeeded(r0)
            r4 = 1
            if (r3 == 0) goto L2b
            r7.f17624f = r1
            r7.f13559c = r4
            r2.dispatchYield(r0, r7)
            goto L86
        L2b:
            q6.g2 r3 = new q6.g2
            q6.e1 r5 = q6.g2.f13550b
            r3.<init>(r5)
            v5.h r0 = r0.plus(r3)
            r7.f17624f = r1
            r7.f13559c = r4
            r2.dispatchYield(r0, r7)
            boolean r0 = r3.f13551a
            if (r0 == 0) goto L86
            q6.w0 r0 = q6.x1.a()
            r5.i r2 = r0.f13599c
            if (r2 == 0) goto L4e
            boolean r2 = r2.isEmpty()
            goto L4f
        L4e:
            r2 = r4
        L4f:
            if (r2 == 0) goto L52
            goto L17
        L52:
            long r2 = r0.f13597a
            r5 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L5f
            r2 = r4
            goto L60
        L5f:
            r2 = 0
        L60:
            if (r2 == 0) goto L6c
            r7.f17624f = r1
            r7.f13559c = r4
            r0.p(r7)
            w5.a r7 = w5.a.f17774a
            goto L88
        L6c:
            r0.r(r4)
            r7.run()     // Catch: java.lang.Throwable -> L7c
        L72:
            boolean r2 = r0.t()     // Catch: java.lang.Throwable -> L7c
            if (r2 != 0) goto L72
        L78:
            r0.o(r4)
            goto L17
        L7c:
            r2 = move-exception
            r7.h(r2)     // Catch: java.lang.Throwable -> L81
            goto L78
        L81:
            r7 = move-exception
            r0.o(r4)
            throw r7
        L86:
            w5.a r7 = w5.a.f17774a
        L88:
            w5.a r0 = w5.a.f17774a
            if (r7 != r0) goto L8d
            return r7
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.c0.K(x5.c):java.lang.Object");
    }

    public static r a() {
        r rVar = new r(true);
        rVar.I(null);
        return rVar;
    }

    public static final v6.c b(v5.h hVar) {
        if (hVar.get(e1.f13546a) == null) {
            hVar = hVar.plus(c());
        }
        return new v6.c(hVar);
    }

    public static h1 c() {
        return new h1(null);
    }

    public static final v6.c d() {
        v1 v1VarE = e();
        x6.e eVar = m0.f13566a;
        return new v6.c(a.a.O(v1VarE, v6.n.f17641a));
    }

    public static v1 e() {
        return new v1(null);
    }

    public static final Executor f(w wVar) {
        Executor executorO;
        x0 x0Var = wVar instanceof x0 ? (x0) wVar : null;
        return (x0Var == null || (executorO = x0Var.o()) == null) ? new l0(wVar) : executorO;
    }

    public static g0 g(a0 a0Var, v5.h hVar, e6.p pVar, int i2) {
        if ((i2 & 1) != 0) {
            hVar = v5.i.f17610a;
        }
        b0 b0Var = b0.f13526a;
        v5.h hVarV = v(a0Var, hVar);
        b0 b0Var2 = b0.f13526a;
        g0 g0Var = new g0(hVarV, true);
        g0Var.c0(b0Var, g0Var, pVar);
        return g0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(x5.c r4) throws java.lang.Throwable {
        /*
            boolean r0 = r4 instanceof q6.i0
            if (r0 == 0) goto L13
            r0 = r4
            q6.i0 r0 = (q6.i0) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            q6.i0 r0 = new q6.i0
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f13555f
            w5.a r1 = w5.a.f17774a
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2b:
            r2.q.z0(r4)
            goto L47
        L2f:
            r2.q.z0(r4)
            r0.g = r3
            q6.l r4 = new q6.l
            v5.c r0 = a.a.I(r0)
            r4.<init>(r3, r0)
            r4.r()
            java.lang.Object r4 = r4.p()
            if (r4 != r1) goto L47
            return
        L47:
            e2.s r4 = new e2.s
            r0 = 2
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.c0.h(x5.c):void");
    }

    public static final void i(a0 a0Var, CancellationException cancellationException) {
        f1 f1Var = (f1) a0Var.getCoroutineContext().get(e1.f13546a);
        if (f1Var != null) {
            f1Var.a(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + a0Var).toString());
        }
    }

    public static final Object j(e6.p pVar, v5.c cVar) throws Throwable {
        v6.r rVar = new v6.r(cVar, cVar.getContext());
        Object objQ = n7.b.Q(rVar, rVar, pVar);
        w5.a aVar = w5.a.f17774a;
        return objQ;
    }

    public static final Object k(long j3, v5.c cVar) {
        if (j3 > 0) {
            l lVar = new l(1, a.a.I(cVar));
            lVar.r();
            if (j3 < LocationRequestCompat.PASSIVE_INTERVAL) {
                o(lVar.e).l(j3, lVar);
            }
            Object objP = lVar.p();
            if (objP == w5.a.f17774a) {
                return objP;
            }
        }
        return q5.x.f13520a;
    }

    public static final void l(v5.h hVar) {
        f1 f1Var = (f1) hVar.get(e1.f13546a);
        if (f1Var != null && !f1Var.isActive()) {
            throw f1Var.g();
        }
    }

    public static final v5.h m(v5.h hVar, v5.h hVar2, boolean z2) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.fold(bool, new androidx.camera.camera2.internal.compat.workaround.a(3))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.fold(bool, new androidx.camera.camera2.internal.compat.workaround.a(3))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.plus(hVar2);
        }
        androidx.camera.camera2.internal.compat.workaround.a aVar = new androidx.camera.camera2.internal.compat.workaround.a(4);
        v5.i iVar = v5.i.f17610a;
        v5.h hVar3 = (v5.h) hVar.fold(iVar, aVar);
        Object objFold = hVar2;
        if (zBooleanValue2) {
            objFold = hVar2.fold(iVar, new androidx.camera.camera2.internal.compat.workaround.a(5));
        }
        return hVar3.plus((v5.h) objFold);
    }

    public static final w n(Executor executor) {
        w wVar;
        l0 l0Var = executor instanceof l0 ? (l0) executor : null;
        return (l0Var == null || (wVar = l0Var.f13563a) == null) ? new y0(executor) : wVar;
    }

    public static final h0 o(v5.h hVar) {
        v5.f fVar = hVar.get(v5.d.f17609a);
        h0 h0Var = fVar instanceof h0 ? (h0) fVar : null;
        return h0Var == null ? e0.f13545a : h0Var;
    }

    public static final String p(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final l q(v5.c cVar) {
        l lVar;
        l lVar2;
        if (!(cVar instanceof v6.f)) {
            return new l(1, cVar);
        }
        v6.f fVar = (v6.f) cVar;
        e2.f fVar2 = v6.a.f17615c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = v6.f.h;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            lVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, fVar2);
                lVar2 = null;
                break;
            }
            if (obj instanceof l) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, fVar2)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                lVar2 = (l) obj;
                break loop0;
            }
            if (obj != fVar2 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (lVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l.g;
            Object obj2 = atomicReferenceFieldUpdater2.get(lVar2);
            if (!(obj2 instanceof t) || ((t) obj2).f13587d == null) {
                l.f13561f.set(lVar2, 536870911);
                atomicReferenceFieldUpdater2.set(lVar2, b.f13525a);
                lVar = lVar2;
            } else {
                lVar2.m();
            }
            if (lVar != null) {
                return lVar;
            }
        }
        return new l(2, cVar);
    }

    public static final void r(v5.h hVar, Throwable th) {
        try {
            y yVar = (y) hVar.get(x.f13600a);
            if (yVar != null) {
                yVar.handleException(hVar, th);
            } else {
                v6.a.d(hVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a.a.h(runtimeException, th);
                th = runtimeException;
            }
            v6.a.d(hVar, th);
        }
    }

    public static final o0 s(f1 f1Var, boolean z2, j1 j1Var) {
        return f1Var instanceof n1 ? ((n1) f1Var).J(z2, j1Var) : f1Var.i(j1Var.i(), z2, new i1(1, j1Var, j1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    public static final boolean t(a0 a0Var) {
        f1 f1Var = (f1) a0Var.getCoroutineContext().get(e1.f13546a);
        if (f1Var != null) {
            return f1Var.isActive();
        }
        return true;
    }

    public static u1 u(a0 a0Var, v5.h hVar, e6.p pVar, int i2) {
        b0 b0Var = b0.f13529d;
        if ((i2 & 1) != 0) {
            hVar = v5.i.f17610a;
        }
        if ((i2 & 2) != 0) {
            b0Var = b0.f13526a;
        }
        v5.h hVarV = v(a0Var, hVar);
        u1 o1Var = b0Var == b0.f13527b ? new o1(hVarV, pVar) : new u1(hVarV, true);
        o1Var.c0(b0Var, o1Var, pVar);
        return o1Var;
    }

    public static final v5.h v(a0 a0Var, v5.h hVar) {
        v5.h hVarM = m(a0Var.getCoroutineContext(), hVar, true);
        x6.e eVar = m0.f13566a;
        return (hVarM == eVar || hVarM.get(v5.d.f17609a) != null) ? hVarM : hVarM.plus(eVar);
    }

    public static final y0 w(final String str) {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return new y0(Executors.newScheduledThreadPool(1, new ThreadFactory(str, atomicInteger) { // from class: q6.y1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13603a;

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, this.f13603a);
                thread.setDaemon(true);
                return thread;
            }
        }));
    }

    public static final v6.c x(a0 a0Var, v5.h hVar) {
        return new v6.c(a0Var.getCoroutineContext().plus(hVar));
    }

    public static final Object y(Object obj) {
        return obj instanceof u ? r2.q.M(((u) obj).f13591a) : obj;
    }

    public static final void z(l lVar, v5.c cVar, boolean z2) {
        Object obj = l.g.get(lVar);
        Throwable thD = lVar.d(obj);
        Object objM = thD != null ? r2.q.M(thD) : lVar.g(obj);
        if (!z2) {
            cVar.resumeWith(objM);
            return;
        }
        kotlin.jvm.internal.k.c(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        v6.f fVar = (v6.f) cVar;
        v5.c cVar2 = fVar.e;
        Object obj2 = fVar.g;
        v5.h context = cVar2.getContext();
        Object objL = v6.a.l(context, obj2);
        d2 d2VarG = objL != v6.a.f17616d ? G(cVar2, context, objL) : null;
        try {
            cVar2.resumeWith(objM);
            if (d2VarG == null || d2VarG.d0()) {
                v6.a.g(context, objL);
            }
        } catch (Throwable th) {
            if (d2VarG == null || d2VarG.d0()) {
                v6.a.g(context, objL);
            }
            throw th;
        }
    }
}
