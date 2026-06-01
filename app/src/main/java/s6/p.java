package s6;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends v6.s {
    public final h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f13754f;

    public p(long j, p pVar, h hVar, int i2) {
        super(j, pVar, i2);
        this.e = hVar;
        this.f13754f = new AtomicReferenceArray(j.f13738b * 2);
    }

    @Override // v6.s
    public final int g() {
        return j.f13738b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        kotlin.jvm.internal.k.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // v6.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(int r5, v5.h r6) {
        /*
            r4 = this;
            int r6 = s6.j.f13738b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f13754f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof q6.f2
            s6.h r2 = r4.e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof s6.b0
            if (r1 == 0) goto L21
            goto L62
        L21:
            e2.f r1 = s6.j.j
            if (r6 == r1) goto L59
            e2.f r1 = s6.j.k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            e2.f r1 = s6.j.g
            if (r6 == r1) goto L11
            e2.f r1 = s6.j.f13741f
            if (r6 != r1) goto L33
            goto L11
        L33:
            e2.f r5 = s6.j.f13742i
            if (r6 == r5) goto L7c
            e2.f r5 = s6.j.f13740d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            e2.f r5 = s6.j.l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.n(r5, r3)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.k.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            e2.f r1 = s6.j.j
            goto L69
        L67:
            e2.f r1 = s6.j.k
        L69:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L7c
            kotlin.jvm.internal.k.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.p.h(int, v5.h):void");
    }

    public final boolean k(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i8 = (i2 * 2) + 1;
        do {
            atomicReferenceArray = this.f13754f;
            if (atomicReferenceArray.compareAndSet(i8, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i8) == obj);
        return false;
    }

    public final Object l(int i2) {
        return this.f13754f.get((i2 * 2) + 1);
    }

    public final void m(int i2, boolean z2) {
        if (z2) {
            h hVar = this.e;
            kotlin.jvm.internal.k.b(hVar);
            hVar.K((this.f17648c * ((long) j.f13738b)) + ((long) i2));
        }
        i();
    }

    public final void n(int i2, Object obj) {
        this.f13754f.set(i2 * 2, obj);
    }

    public final void o(int i2, Object obj) {
        this.f13754f.set((i2 * 2) + 1, obj);
    }
}
