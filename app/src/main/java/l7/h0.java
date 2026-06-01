package l7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f12857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f12858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k0 f12859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12860d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12861f;

    public h0(l lVar) {
        this.f12857a = lVar;
        j buffer = lVar.getBuffer();
        this.f12858b = buffer;
        k0 k0Var = buffer.f12867a;
        this.f12859c = k0Var;
        this.f12860d = k0Var != null ? k0Var.f12873b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f12873b) goto L15;
     */
    @Override // l7.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long read(l7.j r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.k.e(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.e
            if (r3 != 0) goto L63
            l7.k0 r3 = r8.f12859c
            l7.j r4 = r8.f12858b
            if (r3 == 0) goto L2b
            l7.k0 r5 = r4.f12867a
            if (r3 != r5) goto L23
            int r3 = r8.f12860d
            kotlin.jvm.internal.k.b(r5)
            int r5 = r5.f12873b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f12861f
            r2 = 1
            long r0 = r0 + r2
            l7.l r2 = r8.f12857a
            boolean r0 = r2.c(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            l7.k0 r0 = r8.f12859c
            if (r0 != 0) goto L4c
            l7.k0 r0 = r4.f12867a
            if (r0 == 0) goto L4c
            r8.f12859c = r0
            int r0 = r0.f12873b
            r8.f12860d = r0
        L4c:
            long r0 = r4.f12868b
            long r2 = r8.f12861f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            l7.j r2 = r8.f12858b
            long r3 = r8.f12861f
            r5 = r9
            r2.g(r3, r5, r6)
            long r9 = r8.f12861f
            long r9 = r9 + r6
            r8.f12861f = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = androidx.camera.core.processing.util.a.j(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.h0.read(l7.j, long):long");
    }

    @Override // l7.o0
    public final r0 timeout() {
        return this.f12857a.timeout();
    }
}
