package t6;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class w0 extends u6.b implements p0, e, u6.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17498d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s6.a f17499f;
    public Object[] g;
    public long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f17500i;
    public int j;
    public int k;

    public w0(int i2, int i8, s6.a aVar) {
        this.f17498d = i2;
        this.e = i8;
        this.f17499f = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ba, code lost:
    
        throw r2.g();
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void i(t6.w0 r8, t6.f r9, v5.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.w0.i(t6.w0, t6.f, v5.c):void");
    }

    @Override // u6.b
    public final u6.d b() {
        y0 y0Var = new y0();
        y0Var.f17510a = -1L;
        return y0Var;
    }

    @Override // u6.b
    public final u6.d[] c() {
        return new y0[2];
    }

    @Override // t6.e
    public final Object collect(f fVar, v5.c cVar) throws Throwable {
        i(this, fVar, cVar);
        return w5.a.f17774a;
    }

    @Override // t6.p0
    public final boolean d(Object obj) {
        int i2;
        boolean z2;
        v5.c[] cVarArrL = u6.c.f17543a;
        synchronized (this) {
            if (o(obj)) {
                cVarArrL = l(cVarArrL);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        for (v5.c cVar : cVarArrL) {
            if (cVar != null) {
                cVar.resumeWith(q5.x.f13520a);
            }
        }
        return z2;
    }

    @Override // u6.l
    public final e e(v5.h hVar, int i2, s6.a aVar) {
        return x0.n(this, hVar, i2, aVar);
    }

    @Override // t6.p0, t6.f
    public final Object emit(Object obj, v5.c cVar) throws Throwable {
        Throwable th;
        v5.c[] cVarArrL;
        u0 u0Var;
        if (d(obj)) {
            return q5.x.f13520a;
        }
        q6.l lVar = new q6.l(1, a.a.I(cVar));
        lVar.r();
        v5.c[] cVarArrL2 = u6.c.f17543a;
        synchronized (this) {
            try {
                if (o(obj)) {
                    try {
                        lVar.resumeWith(q5.x.f13520a);
                        cVarArrL = l(cVarArrL2);
                        u0Var = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        u0 u0Var2 = new u0(this, m() + ((long) (this.j + this.k)), obj, lVar);
                        k(u0Var2);
                        this.k++;
                        if (this.e == 0) {
                            cVarArrL2 = l(cVarArrL2);
                        }
                        cVarArrL = cVarArrL2;
                        u0Var = u0Var2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (u0Var != null) {
                    lVar.u(new q6.h(u0Var, 2));
                }
                for (v5.c cVar2 : cVarArrL) {
                    if (cVar2 != null) {
                        cVar2.resumeWith(q5.x.f13520a);
                    }
                }
                Object objP = lVar.p();
                w5.a aVar = w5.a.f17774a;
                if (objP != aVar) {
                    objP = q5.x.f13520a;
                }
                return objP == aVar ? objP : q5.x.f13520a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final Object g(y0 y0Var, v0 v0Var) {
        q6.l lVar = new q6.l(1, a.a.I(v0Var));
        lVar.r();
        synchronized (this) {
            try {
                if (p(y0Var) < 0) {
                    y0Var.f17511b = lVar;
                } else {
                    lVar.resumeWith(q5.x.f13520a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objP = lVar.p();
        return objP == w5.a.f17774a ? objP : q5.x.f13520a;
    }

    public final void h() {
        if (this.e != 0 || this.k > 1) {
            Object[] objArr = this.g;
            kotlin.jvm.internal.k.b(objArr);
            while (this.k > 0) {
                long jM = m();
                int i2 = this.j;
                int i8 = this.k;
                if (objArr[((int) ((jM + ((long) (i2 + i8))) - 1)) & (objArr.length - 1)] != x0.f17503a) {
                    return;
                }
                this.k = i8 - 1;
                x0.f(objArr, m() + ((long) (this.j + this.k)), null);
            }
        }
    }

    public final void j() {
        u6.d[] dVarArr;
        Object[] objArr = this.g;
        kotlin.jvm.internal.k.b(objArr);
        x0.f(objArr, m(), null);
        this.j--;
        long jM = m() + 1;
        if (this.h < jM) {
            this.h = jM;
        }
        if (this.f17500i < jM) {
            if (this.f17541b != 0 && (dVarArr = this.f17540a) != null) {
                for (u6.d dVar : dVarArr) {
                    if (dVar != null) {
                        y0 y0Var = (y0) dVar;
                        long j = y0Var.f17510a;
                        if (j >= 0 && j < jM) {
                            y0Var.f17510a = jM;
                        }
                    }
                }
            }
            this.f17500i = jM;
        }
    }

    public final void k(Object obj) {
        int i2 = this.j + this.k;
        Object[] objArrN = this.g;
        if (objArrN == null) {
            objArrN = n(0, 2, null);
        } else if (i2 >= objArrN.length) {
            objArrN = n(i2, objArrN.length * 2, objArrN);
        }
        x0.f(objArrN, m() + ((long) i2), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [v5.c[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final v5.c[] l(v5.c[] cVarArr) {
        u6.d[] dVarArr;
        y0 y0Var;
        q6.l lVar;
        int length = cVarArr.length;
        if (this.f17541b != 0 && (dVarArr = this.f17540a) != null) {
            int length2 = dVarArr.length;
            int i2 = 0;
            cVarArr = cVarArr;
            while (i2 < length2) {
                u6.d dVar = dVarArr[i2];
                if (dVar != null && (lVar = (y0Var = (y0) dVar).f17511b) != null && p(y0Var) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) cVarArr, Math.max(2, cVarArr.length * 2));
                        kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(...)");
                        cVarArr = objArrCopyOf;
                    }
                    ((v5.c[]) cVarArr)[length] = lVar;
                    y0Var.f17511b = null;
                    length++;
                }
                i2++;
                cVarArr = cVarArr;
            }
        }
        return (v5.c[]) cVarArr;
    }

    public final long m() {
        return Math.min(this.f17500i, this.h);
    }

    public final Object[] n(int i2, int i8, Object[] objArr) {
        if (i8 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i8];
        this.g = objArr2;
        if (objArr != null) {
            long jM = m();
            for (int i9 = 0; i9 < i2; i9++) {
                long j = ((long) i9) + jM;
                x0.f(objArr2, j, objArr[((int) j) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean o(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.f17541b
            int r2 = r12.f17498d
            r9 = 1
            if (r1 != 0) goto L23
            if (r2 != 0) goto Lb
            goto L80
        Lb:
            r12.k(r13)
            int r1 = r12.j
            int r1 = r1 + r9
            r12.j = r1
            if (r1 <= r2) goto L18
            r12.j()
        L18:
            long r1 = r12.m()
            int r3 = r12.j
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.f17500i = r1
            return r9
        L23:
            int r1 = r12.j
            int r3 = r12.e
            if (r1 < r3) goto L48
            long r4 = r12.f17500i
            long r6 = r12.h
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L48
            s6.a r1 = r12.f17499f
            int r1 = r1.ordinal()
            if (r1 == 0) goto L46
            if (r1 == r9) goto L48
            r2 = 2
            if (r1 != r2) goto L3f
            goto L80
        L3f:
            e2.s r1 = new e2.s
            r2 = 3
            r1.<init>(r2)
            throw r1
        L46:
            r1 = 0
            return r1
        L48:
            r12.k(r13)
            int r1 = r12.j
            int r1 = r1 + r9
            r12.j = r1
            if (r1 <= r3) goto L55
            r12.j()
        L55:
            long r3 = r12.m()
            int r1 = r12.j
            long r5 = (long) r1
            long r3 = r3 + r5
            long r5 = r12.h
            long r3 = r3 - r5
            int r1 = (int) r3
            if (r1 <= r2) goto L80
            r1 = 1
            long r1 = r1 + r5
            long r3 = r12.f17500i
            long r5 = r12.m()
            int r7 = r12.j
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.m()
            int r10 = r12.j
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.k
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.r(r1, r3, r5, r7)
        L80:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.w0.o(java.lang.Object):boolean");
    }

    public final long p(y0 y0Var) {
        long j = y0Var.f17510a;
        if (j < m() + ((long) this.j)) {
            return j;
        }
        if (this.e <= 0 && j <= m() && this.k != 0) {
            return j;
        }
        return -1L;
    }

    public final Object q(y0 y0Var) {
        Object obj;
        v5.c[] cVarArrS = u6.c.f17543a;
        synchronized (this) {
            try {
                long jP = p(y0Var);
                if (jP < 0) {
                    obj = x0.f17503a;
                } else {
                    long j = y0Var.f17510a;
                    Object[] objArr = this.g;
                    kotlin.jvm.internal.k.b(objArr);
                    Object obj2 = objArr[((int) jP) & (objArr.length - 1)];
                    if (obj2 instanceof u0) {
                        obj2 = ((u0) obj2).f17489c;
                    }
                    y0Var.f17510a = jP + 1;
                    Object obj3 = obj2;
                    cVarArrS = s(j);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (v5.c cVar : cVarArrS) {
            if (cVar != null) {
                cVar.resumeWith(q5.x.f13520a);
            }
        }
        return obj;
    }

    public final void r(long j, long j3, long j8, long j9) {
        long jMin = Math.min(j3, j);
        for (long jM = m(); jM < jMin; jM++) {
            Object[] objArr = this.g;
            kotlin.jvm.internal.k.b(objArr);
            x0.f(objArr, jM, null);
        }
        this.h = j;
        this.f17500i = j3;
        this.j = (int) (j8 - jMin);
        this.k = (int) (j9 - j8);
    }

    public final v5.c[] s(long j) {
        long j3;
        long j8;
        long j9;
        v5.c[] cVarArr;
        v5.c[] cVarArr2;
        u6.d[] dVarArr;
        e2.f fVar = x0.f17503a;
        v5.c[] cVarArr3 = u6.c.f17543a;
        if (j <= this.f17500i) {
            long jM = m();
            long j10 = ((long) this.j) + jM;
            int i2 = this.e;
            if (i2 == 0 && this.k > 0) {
                j10++;
            }
            int i8 = 0;
            if (this.f17541b != 0 && (dVarArr = this.f17540a) != null) {
                for (u6.d dVar : dVarArr) {
                    if (dVar != null) {
                        long j11 = ((y0) dVar).f17510a;
                        if (j11 >= 0 && j11 < j10) {
                            j10 = j11;
                        }
                    }
                }
            }
            if (j10 > this.f17500i) {
                long jM2 = m() + ((long) this.j);
                int iMin = this.f17541b > 0 ? Math.min(this.k, i2 - ((int) (jM2 - j10))) : this.k;
                long j12 = ((long) this.k) + jM2;
                if (iMin > 0) {
                    j9 = 1;
                    Object[] objArr = this.g;
                    kotlin.jvm.internal.k.b(objArr);
                    j3 = jM;
                    v5.c[] cVarArr4 = new v5.c[iMin];
                    long j13 = jM2;
                    while (true) {
                        if (jM2 >= j12) {
                            cVarArr2 = cVarArr4;
                            j8 = j10;
                            break;
                        }
                        cVarArr2 = cVarArr4;
                        Object obj = objArr[(objArr.length - 1) & ((int) jM2)];
                        if (obj != fVar) {
                            kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                            u0 u0Var = (u0) obj;
                            int i9 = i8 + 1;
                            j8 = j10;
                            cVarArr2[i8] = u0Var.f17490d;
                            x0.f(objArr, jM2, fVar);
                            x0.f(objArr, j13, u0Var.f17489c);
                            j13++;
                            if (i9 >= iMin) {
                                break;
                            }
                            i8 = i9;
                        } else {
                            j8 = j10;
                        }
                        jM2++;
                        cVarArr4 = cVarArr2;
                        j10 = j8;
                    }
                    jM2 = j13;
                    cVarArr = cVarArr2;
                } else {
                    j3 = jM;
                    j8 = j10;
                    j9 = 1;
                    cVarArr = cVarArr3;
                }
                int i10 = (int) (jM2 - j3);
                long j14 = this.f17541b == 0 ? jM2 : j8;
                long jMax = Math.max(this.h, jM2 - ((long) Math.min(this.f17498d, i10)));
                if (i2 == 0 && jMax < j12) {
                    Object[] objArr2 = this.g;
                    kotlin.jvm.internal.k.b(objArr2);
                    if (kotlin.jvm.internal.k.a(objArr2[((int) jMax) & (objArr2.length - 1)], fVar)) {
                        jM2 += j9;
                        jMax += j9;
                    }
                }
                r(jMax, j14, jM2, j12);
                h();
                return cVarArr.length == 0 ? cVarArr : l(cVarArr);
            }
        }
        return cVarArr3;
    }
}
