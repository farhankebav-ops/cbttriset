package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f17475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x5.i f17476b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(e eVar, e6.q qVar) {
        this.f17475a = eVar;
        this.f17476b = (x5.i) qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v4, types: [e6.q, x5.i] */
    /* JADX WARN: Type inference failed for: r9v6, types: [e6.q, x5.i] */
    @Override // t6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(t6.f r9, v5.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof t6.p
            if (r0 == 0) goto L13
            r0 = r10
            t6.p r0 = (t6.p) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            t6.p r0 = new t6.p
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f17473f
            w5.a r1 = w5.a.f17774a
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.f17474i
            u6.o r9 = (u6.o) r9
            r2.q.z0(r10)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r10 = move-exception
            goto L86
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.f17474i
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r2.q.z0(r10)
            goto La0
        L44:
            t6.f r9 = r0.j
            java.lang.Object r2 = r0.f17474i
            t6.q r2 = (t6.q) r2
            r2.q.z0(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8c
        L50:
            r2.q.z0(r10)
            t6.e r10 = r8.f17475a     // Catch: java.lang.Throwable -> L8a
            r0.f17474i = r8     // Catch: java.lang.Throwable -> L8a
            r0.j = r9     // Catch: java.lang.Throwable -> L8a
            r0.g = r5     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L8a
            if (r10 != r1) goto L62
            goto L9f
        L62:
            r2 = r8
        L63:
            u6.o r10 = new u6.o
            v5.h r4 = r0.getContext()
            r10.<init>(r9, r4)
            x5.i r9 = r2.f17476b     // Catch: java.lang.Throwable -> L82
            r0.f17474i = r10     // Catch: java.lang.Throwable -> L82
            r0.j = r6     // Catch: java.lang.Throwable -> L82
            r0.g = r3     // Catch: java.lang.Throwable -> L82
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L82
            if (r9 != r1) goto L7b
            goto L9f
        L7b:
            r9 = r10
        L7c:
            r9.releaseIntercepted()
            q5.x r9 = q5.x.f13520a
            return r9
        L82:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L86:
            r9.releaseIntercepted()
            throw r10
        L8a:
            r9 = move-exception
            r2 = r8
        L8c:
            t6.i1 r10 = new t6.i1
            r10.<init>(r9)
            x5.i r2 = r2.f17476b
            r0.f17474i = r9
            r0.j = r6
            r0.g = r4
            java.lang.Object r10 = t6.x0.e(r10, r2, r9, r0)
            if (r10 != r1) goto La0
        L9f:
            return r1
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.collect(t6.f, v5.c):java.lang.Object");
    }
}
