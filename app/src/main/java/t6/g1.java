package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g1 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f17443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x5.i f17444b;

    /* JADX WARN: Multi-variable type inference failed */
    public g1(e6.p pVar, f fVar) {
        this.f17443a = fVar;
        this.f17444b = (x5.i) pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [x5.c] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v4, types: [e6.p, x5.i] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(x5.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof t6.f1
            if (r0 == 0) goto L13
            r0 = r8
            t6.f1 r0 = (t6.f1) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            t6.f1 r0 = new t6.f1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.h
            w5.a r1 = w5.a.f17774a
            int r2 = r0.j
            q5.x r3 = q5.x.f13520a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            r2.q.z0(r8)
            return r3
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            u6.o r2 = r0.g
            t6.g1 r5 = r0.f17437f
            r2.q.z0(r8)     // Catch: java.lang.Throwable -> L3c
            goto L5c
        L3c:
            r8 = move-exception
            goto L76
        L3e:
            r2.q.z0(r8)
            u6.o r2 = new u6.o
            t6.f r8 = r7.f17443a
            v5.h r6 = r0.getContext()
            r2.<init>(r8, r6)
            x5.i r8 = r7.f17444b     // Catch: java.lang.Throwable -> L3c
            r0.f17437f = r7     // Catch: java.lang.Throwable -> L3c
            r0.g = r2     // Catch: java.lang.Throwable -> L3c
            r0.j = r5     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r8 = r8.invoke(r2, r0)     // Catch: java.lang.Throwable -> L3c
            if (r8 != r1) goto L5b
            goto L74
        L5b:
            r5 = r7
        L5c:
            r2.releaseIntercepted()
            t6.f r8 = r5.f17443a
            boolean r2 = r8 instanceof t6.g1
            if (r2 == 0) goto L75
            t6.g1 r8 = (t6.g1) r8
            r2 = 0
            r0.f17437f = r2
            r0.g = r2
            r0.j = r4
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L75
        L74:
            return r1
        L75:
            return r3
        L76:
            r2.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.g1.a(x5.c):java.lang.Object");
    }

    @Override // t6.f
    public final Object emit(Object obj, v5.c cVar) {
        return this.f17443a.emit(obj, cVar);
    }
}
