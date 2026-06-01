package t6;

import q6.u1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2.f f17503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e2.f f17504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e2.f f17505c;

    static {
        int i2 = 5;
        boolean z2 = false;
        f17503a = new e2.f("NO_VALUE", i2, z2);
        f17504b = new e2.f("NONE", i2, z2);
        f17505c = new e2.f("PENDING", i2, z2);
    }

    public static final w0 a(int i2, int i8, s6.a aVar) {
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.g(i2, "replay cannot be negative, but was ").toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(a1.a.g(i8, "extraBufferCapacity cannot be negative, but was ").toString());
        }
        if (i2 <= 0 && i8 <= 0 && aVar != s6.a.f13718a) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
        }
        int i9 = i8 + i2;
        if (i9 < 0) {
            i9 = Integer.MAX_VALUE;
        }
        return new w0(i2, i9, aVar);
    }

    public static final d1 c(Object obj) {
        if (obj == null) {
            obj = u6.c.f17544b;
        }
        return new d1(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(t6.f r4, java.lang.Object r5, java.lang.Object r6, x5.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof t6.z
            if (r0 == 0) goto L13
            r0 = r7
            t6.z r0 = (t6.z) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            t6.z r0 = new t6.z
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            java.lang.Object r6 = r0.f17512f
            r2.q.z0(r7)
            goto L3f
        L31:
            r2.q.z0(r7)
            r0.f17512f = r6
            r0.h = r3
            java.lang.Object r4 = r4.emit(r5, r0)
            if (r4 != r1) goto L3f
            return
        L3f:
            u6.a r4 = new u6.a
            r4.<init>(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.d(t6.f, java.lang.Object, java.lang.Object, x5.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(t6.i1 r4, e6.q r5, java.lang.Throwable r6, x5.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof t6.o
            if (r0 == 0) goto L13
            r0 = r7
            t6.o r0 = (t6.o) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            t6.o r0 = new t6.o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r6 = r0.f17470f
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L29
            goto L41
        L29:
            r4 = move-exception
            goto L44
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            r2.q.z0(r7)
            r0.f17470f = r6     // Catch: java.lang.Throwable -> L29
            r0.h = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L41
            return r1
        L41:
            q5.x r4 = q5.x.f13520a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            a.a.h(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.e(t6.i1, e6.q, java.lang.Throwable, x5.c):java.lang.Object");
    }

    public static final void f(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }

    public static e g(e eVar, int i2) {
        s6.a aVar = s6.a.f13718a;
        if (i2 < 0 && i2 != -2 && i2 != -1) {
            throw new IllegalArgumentException(a1.a.g(i2, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
        }
        if (i2 == -1) {
            aVar = s6.a.f13719b;
            i2 = 0;
        }
        return eVar instanceof u6.l ? u6.c.a((u6.l) eVar, null, i2, aVar, 1) : new d(i2, aVar, eVar, v5.i.f17610a);
    }

    public static final c h(e6.p pVar) {
        return new c(pVar, v5.i.f17610a, -2, s6.a.f13718a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable i(t6.e r5, t6.f r6, x5.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof t6.u
            if (r0 == 0) goto L13
            r0 = r7
            t6.u r0 = (t6.u) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            t6.u r0 = new t6.u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.jvm.internal.a0 r5 = r0.f17486f
            r2.q.z0(r7)     // Catch: java.lang.Throwable -> L29
            goto L4c
        L29:
            r6 = move-exception
            goto L50
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            r2.q.z0(r7)
            kotlin.jvm.internal.a0 r7 = new kotlin.jvm.internal.a0
            r7.<init>()
            t6.w r2 = new t6.w     // Catch: java.lang.Throwable -> L4e
            r4 = 0
            r2.<init>(r4, r6, r7)     // Catch: java.lang.Throwable -> L4e
            r0.f17486f = r7     // Catch: java.lang.Throwable -> L4e
            r0.h = r3     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: java.lang.Throwable -> L4e
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r5 = 0
            return r5
        L4e:
            r6 = move-exception
            r5 = r7
        L50:
            java.lang.Object r5 = r5.f12717a
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            if (r5 == 0) goto L5c
            boolean r7 = r5.equals(r6)
            if (r7 != 0) goto L7e
        L5c:
            v5.h r7 = r0.getContext()
            q6.e1 r0 = q6.e1.f13546a
            v5.f r7 = r7.get(r0)
            q6.f1 r7 = (q6.f1) r7
            if (r7 == 0) goto L7f
            boolean r0 = r7.isCancelled()
            if (r0 != 0) goto L71
            goto L7f
        L71:
            java.util.concurrent.CancellationException r7 = r7.g()
            if (r7 == 0) goto L7f
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L7e
            goto L7f
        L7e:
            throw r6
        L7f:
            if (r5 != 0) goto L82
            return r6
        L82:
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException
            if (r7 == 0) goto L8a
            a.a.h(r5, r6)
            throw r5
        L8a:
            a.a.h(r6, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.i(t6.e, t6.f, x5.c):java.io.Serializable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        if (r2.emit(r11, r0) == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:25:0x005e, B:29:0x0072, B:31:0x007a, B:33:0x0080, B:35:0x0086, B:38:0x0097, B:39:0x009f, B:40:0x00a0, B:41:0x00a7, B:20:0x0049, B:24:0x0054), top: B:60:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0094 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object j(t6.f r8, s6.w r9, boolean r10, x5.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.j(t6.f, s6.w, boolean, x5.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [e6.p] */
    /* JADX WARN: Type inference failed for: r6v0, types: [t6.e] */
    /* JADX WARN: Type inference failed for: r7v0, types: [e6.p, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object k(t6.e r6, e6.p r7, x5.c r8) throws java.lang.Throwable {
        /*
            e2.f r0 = u6.c.f17544b
            boolean r1 = r8 instanceof t6.j0
            if (r1 == 0) goto L15
            r1 = r8
            t6.j0 r1 = (t6.j0) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.j = r2
            goto L1a
        L15:
            t6.j0 r1 = new t6.j0
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.f17456i
            w5.a r2 = w5.a.f17774a
            int r3 = r1.j
            r4 = 1
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L33
            t6.w r6 = r1.h
            kotlin.jvm.internal.a0 r7 = r1.g
            x5.i r1 = r1.f17455f
            e6.p r1 = (e6.p) r1
            r2.q.z0(r8)     // Catch: u6.a -> L31
            goto L69
        L31:
            r8 = move-exception
            goto L65
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            r2.q.z0(r8)
            kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
            r8.<init>()
            r8.f12717a = r0
            t6.w r3 = new t6.w
            r5 = 2
            r3.<init>(r5, r7, r8)
            r5 = r7
            x5.i r5 = (x5.i) r5     // Catch: u6.a -> L60
            r1.f17455f = r5     // Catch: u6.a -> L60
            r1.g = r8     // Catch: u6.a -> L60
            r1.h = r3     // Catch: u6.a -> L60
            r1.j = r4     // Catch: u6.a -> L60
            java.lang.Object r6 = r6.collect(r3, r1)     // Catch: u6.a -> L60
            if (r6 != r2) goto L5d
            return r2
        L5d:
            r1 = r7
            r7 = r8
            goto L69
        L60:
            r6 = move-exception
            r1 = r7
            r7 = r8
            r8 = r6
            r6 = r3
        L65:
            java.lang.Object r2 = r8.f17539a
            if (r2 != r6) goto L82
        L69:
            java.lang.Object r6 = r7.f12717a
            if (r6 == r0) goto L6e
            return r6
        L6e:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Expected at least one element matching the predicate "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L82:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.k(t6.e, e6.p, x5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object l(t6.e r6, v5.c r7) throws java.lang.Throwable {
        /*
            e2.f r0 = u6.c.f17544b
            boolean r1 = r7 instanceof t6.i0
            if (r1 == 0) goto L15
            r1 = r7
            t6.i0 r1 = (t6.i0) r1
            int r2 = r1.f17451i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f17451i = r2
            goto L1a
        L15:
            t6.i0 r1 = new t6.i0
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.h
            w5.a r2 = w5.a.f17774a
            int r3 = r1.f17451i
            r4 = 1
            if (r3 == 0) goto L37
            if (r3 != r4) goto L2f
            t6.g0 r6 = r1.g
            kotlin.jvm.internal.a0 r1 = r1.f17450f
            r2.q.z0(r7)     // Catch: u6.a -> L2d
            goto L5e
        L2d:
            r7 = move-exception
            goto L5a
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            r2.q.z0(r7)
            kotlin.jvm.internal.a0 r7 = new kotlin.jvm.internal.a0
            r7.<init>()
            r7.f12717a = r0
            t6.g0 r3 = new t6.g0
            r5 = 0
            r3.<init>(r7, r5)
            r1.f17450f = r7     // Catch: u6.a -> L56
            r1.g = r3     // Catch: u6.a -> L56
            r1.f17451i = r4     // Catch: u6.a -> L56
            java.lang.Object r6 = r6.collect(r3, r1)     // Catch: u6.a -> L56
            if (r6 != r2) goto L54
            return r2
        L54:
            r1 = r7
            goto L5e
        L56:
            r6 = move-exception
            r1 = r7
            r7 = r6
            r6 = r3
        L5a:
            java.lang.Object r2 = r7.f17539a
            if (r2 != r6) goto L6b
        L5e:
            java.lang.Object r6 = r1.f12717a
            if (r6 == r0) goto L63
            return r6
        L63:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Expected at least one element"
            r6.<init>(r7)
            throw r6
        L6b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.l(t6.e, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m(t6.e r5, x5.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof t6.k0
            if (r0 == 0) goto L13
            r0 = r6
            t6.k0 r0 = (t6.k0) r0
            int r1 = r0.f17459i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17459i = r1
            goto L18
        L13:
            t6.k0 r0 = new t6.k0
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.h
            w5.a r1 = w5.a.f17774a
            int r2 = r0.f17459i
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            t6.g0 r5 = r0.g
            kotlin.jvm.internal.a0 r0 = r0.f17458f
            r2.q.z0(r6)     // Catch: u6.a -> L2b
            goto L5a
        L2b:
            r6 = move-exception
            goto L56
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            r2.q.z0(r6)
            kotlin.jvm.internal.a0 r6 = new kotlin.jvm.internal.a0
            r6.<init>()
            t6.g0 r2 = new t6.g0
            r4 = 1
            r2.<init>(r6, r4)
            r0.f17458f = r6     // Catch: u6.a -> L52
            r0.g = r2     // Catch: u6.a -> L52
            r0.f17459i = r3     // Catch: u6.a -> L52
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch: u6.a -> L52
            if (r5 != r1) goto L50
            return r1
        L50:
            r0 = r6
            goto L5a
        L52:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L56:
            java.lang.Object r1 = r6.f17539a
            if (r1 != r5) goto L5d
        L5a:
            java.lang.Object r5 = r0.f12717a
            return r5
        L5d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.m(t6.e, x5.c):java.lang.Object");
    }

    public static final e n(t0 t0Var, v5.h hVar, int i2, s6.a aVar) {
        return ((i2 == 0 || i2 == -3) && aVar == s6.a.f13718a) ? t0Var : new d(i2, aVar, t0Var, hVar);
    }

    public static final u1 o(e eVar, q6.a0 a0Var) {
        return q6.c0.u(a0Var, null, new h(eVar, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final t6.r0 p(t6.e r8, q6.a0 r9, int r10) {
        /*
            s6.k r0 = s6.l.f13750z6
            r0.getClass()
            int r0 = s6.k.f13749b
            if (r10 >= r0) goto La
            goto Lb
        La:
            r0 = r10
        Lb:
            int r0 = r0 - r10
            boolean r1 = r8 instanceof t6.d
            r2 = 1
            if (r1 == 0) goto L43
            r1 = r8
            t6.d r1 = (t6.d) r1
            s6.a r3 = r1.f17427c
            int r4 = r1.f17428d
            switch(r4) {
                case 1: goto L1d;
                default: goto L1b;
            }
        L1b:
            r4 = 0
            goto L21
        L1d:
            java.lang.Object r4 = r1.e
            t6.e r4 = (t6.e) r4
        L21:
            if (r4 == 0) goto L43
            k4.y r8 = new k4.y
            int r5 = r1.f17426b
            r6 = -3
            if (r5 == r6) goto L31
            r6 = -2
            if (r5 == r6) goto L31
            if (r5 == 0) goto L31
            r0 = r5
            goto L3d
        L31:
            s6.a r6 = s6.a.f13718a
            r7 = 0
            if (r3 != r6) goto L3a
            if (r5 != 0) goto L3d
        L38:
            r0 = r7
            goto L3d
        L3a:
            if (r10 != 0) goto L38
            r0 = r2
        L3d:
            v5.h r1 = r1.f17425a
            r8.<init>(r0, r3, r4, r1)
            goto L4d
        L43:
            k4.y r1 = new k4.y
            s6.a r3 = s6.a.f13718a
            v5.i r4 = v5.i.f17610a
            r1.<init>(r0, r3, r8, r4)
            r8 = r1
        L4d:
            int r0 = r8.f12697a
            java.lang.Object r1 = r8.f12699c
            s6.a r1 = (s6.a) r1
            t6.w0 r10 = a(r10, r0, r1)
            java.lang.Object r0 = r8.f12700d
            v5.h r0 = (v5.h) r0
            java.lang.Object r8 = r8.f12698b
            t6.e r8 = (t6.e) r8
            t6.a1 r1 = t6.z0.f17513a
            boolean r1 = r1.equals(r1)
            if (r1 == 0) goto L6a
            q6.b0 r1 = q6.b0.f13526a
            goto L6c
        L6a:
            q6.b0 r1 = q6.b0.f13529d
        L6c:
            t6.m r3 = new t6.m
            r4 = 0
            r3.<init>(r8, r10, r4)
            v5.h r8 = q6.c0.v(r9, r0)
            q6.b0 r9 = q6.b0.f13527b
            if (r1 != r9) goto L80
            q6.o1 r9 = new q6.o1
            r9.<init>(r8, r3)
            goto L85
        L80:
            q6.u1 r9 = new q6.u1
            r9.<init>(r8, r2)
        L85:
            r9.c0(r1, r9, r3)
            t6.r0 r8 = new t6.r0
            r8.<init>(r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.p(t6.e, q6.a0, int):t6.r0");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object q(t6.e r6, x5.c r7) throws java.lang.Throwable {
        /*
            e2.f r0 = u6.c.f17544b
            boolean r1 = r7 instanceof t6.l0
            if (r1 == 0) goto L15
            r1 = r7
            t6.l0 r1 = (t6.l0) r1
            int r2 = r1.h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.h = r2
            goto L1a
        L15:
            t6.l0 r1 = new t6.l0
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.g
            w5.a r2 = w5.a.f17774a
            int r3 = r1.h
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.jvm.internal.a0 r6 = r1.f17462f
            r2.q.z0(r7)
            goto L4f
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            r2.q.z0(r7)
            kotlin.jvm.internal.a0 r7 = new kotlin.jvm.internal.a0
            r7.<init>()
            r7.f12717a = r0
            t6.g0 r3 = new t6.g0
            r5 = 2
            r3.<init>(r7, r5)
            r1.f17462f = r7
            r1.h = r4
            java.lang.Object r6 = r6.collect(r3, r1)
            if (r6 != r2) goto L4e
            return r2
        L4e:
            r6 = r7
        L4f:
            java.lang.Object r6 = r6.f12717a
            if (r6 == r0) goto L54
            return r6
        L54:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
            java.lang.String r7 = "Flow is empty"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.x0.q(t6.e, x5.c):java.lang.Object");
    }
}
