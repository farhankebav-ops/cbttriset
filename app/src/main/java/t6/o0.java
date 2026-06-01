package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends x5.i implements e6.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17471f;
    public /* synthetic */ f g;
    public /* synthetic */ Object[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x5.i f17472i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public o0(e6.q qVar, v5.c cVar) {
        super(3, cVar);
        this.f17472i = (x5.i) qVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [e6.q, x5.i] */
    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        o0 o0Var = new o0(this.f17472i, (v5.c) obj3);
        o0Var.g = (f) obj;
        o0Var.h = (Object[]) obj2;
        return o0Var.invokeSuspend(q5.x.f13520a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r1.emit(r6, r5) == r0) goto L15;
     */
    /* JADX WARN: Type inference failed for: r3v1, types: [e6.q, x5.i] */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r5.f17471f
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            r2.q.z0(r6)
            goto L43
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            t6.f r1 = r5.g
            r2.q.z0(r6)
            goto L37
        L1e:
            r2.q.z0(r6)
            t6.f r1 = r5.g
            java.lang.Object[] r6 = r5.h
            r4 = 0
            r4 = r6[r4]
            r6 = r6[r3]
            r5.g = r1
            r5.f17471f = r3
            x5.i r3 = r5.f17472i
            java.lang.Object r6 = r3.invoke(r4, r6, r5)
            if (r6 != r0) goto L37
            goto L42
        L37:
            r3 = 0
            r5.g = r3
            r5.f17471f = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L43
        L42:
            return r0
        L43:
            q5.x r6 = q5.x.f13520a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.o0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
