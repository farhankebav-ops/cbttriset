package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d extends kotlin.jvm.internal.j implements e6.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f13726b = new d(3, h.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        return q5.x.f13520a;
     */
    @Override // e6.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r9, java.lang.Object r10, java.lang.Object r11) {
        /*
            r8 = this;
            r0 = r9
            s6.h r0 = (s6.h) r0
            r5 = r10
            y6.f r5 = (y6.f) r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = s6.h.f13730b
            r0.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = s6.h.g
            java.lang.Object r9 = r9.get(r0)
            s6.p r9 = (s6.p) r9
        L13:
            boolean r10 = r0.x()
            if (r10 == 0) goto L20
            e2.f r9 = s6.j.l
            y6.e r5 = (y6.e) r5
            r5.e = r9
            goto L73
        L20:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = s6.h.f13731c
            long r3 = r10.getAndIncrement(r0)
            int r10 = s6.j.f13738b
            long r10 = (long) r10
            long r1 = r3 / r10
            long r10 = r3 % r10
            int r10 = (int) r10
            long r6 = r9.f17648c
            int r11 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r11 == 0) goto L3e
            s6.p r11 = r0.q(r1, r9)
            if (r11 != 0) goto L3b
            goto L13
        L3b:
            r1 = r11
        L3c:
            r2 = r10
            goto L40
        L3e:
            r1 = r9
            goto L3c
        L40:
            java.lang.Object r9 = r0.I(r1, r2, r3, r5)
            r11 = r1
            e2.f r10 = s6.j.m
            if (r9 != r10) goto L57
            boolean r9 = r5 instanceof q6.f2
            if (r9 == 0) goto L50
            q6.f2 r5 = (q6.f2) r5
            goto L51
        L50:
            r5 = 0
        L51:
            if (r5 == 0) goto L73
            r5.b(r11, r2)
            goto L73
        L57:
            e2.f r10 = s6.j.f13744o
            if (r9 != r10) goto L68
            long r9 = r0.u()
            int r9 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r9 >= 0) goto L66
            r11.b()
        L66:
            r9 = r11
            goto L13
        L68:
            e2.f r10 = s6.j.f13743n
            if (r9 == r10) goto L76
            r11.b()
            y6.e r5 = (y6.e) r5
            r5.e = r9
        L73:
            q5.x r9 = q5.x.f13520a
            return r9
        L76:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "unexpected"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.d.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
