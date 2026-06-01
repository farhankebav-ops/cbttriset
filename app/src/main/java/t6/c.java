package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x5.i f17420f;

    /* JADX WARN: Multi-variable type inference failed */
    public c(e6.p pVar, v5.h hVar, int i2, s6.a aVar) {
        super(pVar, hVar, i2, aVar);
        this.f17420f = (x5.i) pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // t6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(s6.x r5, v5.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof t6.b
            if (r0 == 0) goto L13
            r0 = r6
            t6.b r0 = (t6.b) r0
            int r1 = r0.f17418i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17418i = r1
            goto L1a
        L13:
            t6.b r0 = new t6.b
            x5.c r6 = (x5.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.f17418i
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            s6.x r5 = r0.f17417f
            r2.q.z0(r6)
            goto L41
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            r2.q.z0(r6)
            r0.f17417f = r5
            r0.f17418i = r3
            java.lang.Object r6 = super.b(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            s6.w r5 = (s6.w) r5
            s6.h r5 = r5.f13759d
            boolean r5 = r5.y()
            if (r5 == 0) goto L4e
            q5.x r5 = q5.x.f13520a
            return r5
        L4e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.c.b(s6.x, v5.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [e6.p, x5.i] */
    @Override // t6.d
    public final d c(v5.h hVar, int i2, s6.a aVar) {
        return new c(this.f17420f, hVar, i2, aVar);
    }
}
