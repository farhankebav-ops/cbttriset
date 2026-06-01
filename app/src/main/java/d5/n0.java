package d5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 implements o7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f11124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11125b;

    public n0(AtomicReference atomicReference, int i2) {
        this.f11124a = atomicReference;
        this.f11125b = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0008, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // o7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(s4.g r8) {
        /*
            r7 = this;
            d5.o0 r0 = new d5.o0
            r0.<init>(r8)
            r8.f(r0)
        L8:
            java.util.concurrent.atomic.AtomicReference r8 = r7.f11124a
            java.lang.Object r8 = r8.get()
            d5.p0 r8 = (d5.p0) r8
            if (r8 == 0) goto L1b
            boolean r1 = r8.d()
            if (r1 == 0) goto L19
            goto L1b
        L19:
            r3 = r8
            goto L2d
        L1b:
            d5.p0 r1 = new d5.p0
            java.util.concurrent.atomic.AtomicReference r2 = r7.f11124a
            int r3 = r7.f11125b
            r1.<init>(r2, r3)
            java.util.concurrent.atomic.AtomicReference r2 = r7.f11124a
        L26:
            boolean r3 = r2.compareAndSet(r8, r1)
            if (r3 == 0) goto L67
            r3 = r1
        L2d:
            java.util.concurrent.atomic.AtomicReference r4 = r3.f11137c
        L2f:
            java.lang.Object r8 = r4.get()
            r5 = r8
            d5.o0[] r5 = (d5.o0[]) r5
            d5.o0[] r8 = d5.p0.j
            if (r5 != r8) goto L3b
            goto L8
        L3b:
            int r8 = r5.length
            int r1 = r8 + 1
            d5.o0[] r6 = new d5.o0[r1]
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r6, r1, r8)
            r6[r8] = r0
        L46:
            boolean r8 = r4.compareAndSet(r5, r6)
            if (r8 == 0) goto L60
            long r1 = r0.get()
            r4 = -9223372036854775808
            int r8 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r8 != 0) goto L5a
            r3.g(r0)
            goto L5c
        L5a:
            r0.f11129b = r3
        L5c:
            r3.c()
            return
        L60:
            java.lang.Object r8 = r4.get()
            if (r8 == r5) goto L46
            goto L2f
        L67:
            java.lang.Object r3 = r2.get()
            if (r3 == r8) goto L26
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.n0.a(s4.g):void");
    }
}
