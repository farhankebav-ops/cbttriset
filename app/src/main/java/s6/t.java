package s6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends h {
    public final a k;

    public t(int i2, a aVar) {
        super(i2);
        this.k = aVar;
        if (aVar != a.f13718a) {
            if (i2 < 1) {
                throw new IllegalArgumentException(a1.a.h(i2, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.b0.a(h.class).f() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            s6.a r1 = r15.k
            s6.a r2 = s6.a.f13720c
            q5.x r8 = q5.x.f13520a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.d(r16)
            boolean r2 = r1 instanceof s6.n
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof s6.m
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            e2.f r6 = s6.j.f13740d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = s6.h.f13733f
            java.lang.Object r1 = r1.get(r15)
            s6.p r1 = (s6.p) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = s6.h.f13730b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.w(r2, r7)
            int r9 = s6.j.f13738b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f17648c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            s6.p r2 = s6.h.b(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = s6.h.f(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.b()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = s6.h.f13731c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.b()
        L7e:
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.i()
            java.lang.Throwable r1 = r15.t()
            s6.m r2 = new s6.m
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof q6.f2
            if (r3 == 0) goto La6
            q6.f2 r6 = (q6.f2) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.b(r1, r12)
        Lae:
            long r3 = r1.f17648c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.k(r3)
        Lb6:
            return r8
        Lb7:
            r1.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.t.L(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // s6.h, s6.a0
    public final Object c(Object obj, v5.c cVar) throws Throwable {
        if (L(obj, true) instanceof m) {
            throw t();
        }
        return q5.x.f13520a;
    }

    @Override // s6.h, s6.a0
    public final Object d(Object obj) {
        return L(obj, false);
    }

    @Override // s6.h
    public final boolean z() {
        return this.k == a.f13719b;
    }
}
