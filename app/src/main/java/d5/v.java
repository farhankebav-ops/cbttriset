package d5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends j5.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11154f;
    public final Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(a5.a aVar, Object obj, int i2) {
        super(aVar);
        this.f11154f = i2;
        this.g = obj;
    }

    @Override // s4.g
    public final void b(Object obj) {
        switch (this.f11154f) {
            case 0:
                if (!e(obj)) {
                    this.f12575b.c(1L);
                }
                break;
            default:
                if (!this.f12577d) {
                    int i2 = this.e;
                    a5.a aVar = this.f12574a;
                    if (i2 != 0) {
                        aVar.b(null);
                    } else {
                        try {
                            Object objApply = ((x4.c) this.g).apply(obj);
                            z4.b.a(objApply, "The mapper function returned a null value.");
                            aVar.b(objApply);
                        } catch (Throwable th) {
                            a(th);
                        }
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r1.e(r4) != false) goto L23;
     */
    @Override // a5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r3.f11154f
            switch(r0) {
                case 0: goto L25;
                default: goto L5;
            }
        L5:
            boolean r0 = r3.f12577d
            if (r0 == 0) goto Lb
            r4 = 0
            goto L24
        Lb:
            java.lang.Object r0 = r3.g     // Catch: java.lang.Throwable -> L1f
            x4.c r0 = (x4.c) r0     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r4 = r0.apply(r4)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = "The mapper function returned a null value."
            z4.b.a(r4, r0)     // Catch: java.lang.Throwable -> L1f
            a5.a r0 = r3.f12574a
            boolean r4 = r0.e(r4)
            goto L24
        L1f:
            r4 = move-exception
            r3.a(r4)
            r4 = 1
        L24:
            return r4
        L25:
            boolean r0 = r3.f12577d
            if (r0 == 0) goto L2a
            goto L49
        L2a:
            int r0 = r3.e
            a5.a r1 = r3.f12574a
            if (r0 == 0) goto L36
            r4 = 0
            boolean r4 = r1.e(r4)
            goto L50
        L36:
            r0 = 1
            java.lang.Object r2 = r3.g     // Catch: java.lang.Throwable -> L4b
            x4.d r2 = (x4.d) r2     // Catch: java.lang.Throwable -> L4b
            boolean r2 = r2.test(r4)     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto L49
            boolean r4 = r1.e(r4)
            if (r4 == 0) goto L49
        L47:
            r4 = r0
            goto L50
        L49:
            r4 = 0
            goto L50
        L4b:
            r4 = move-exception
            r3.a(r4)
            goto L47
        L50:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.v.e(java.lang.Object):boolean");
    }

    @Override // a5.h
    public final Object poll() {
        switch (this.f11154f) {
            case 0:
                a5.e eVar = this.f12576c;
                x4.d dVar = (x4.d) this.g;
                while (true) {
                    Object objPoll = eVar.poll();
                    if (objPoll == null) {
                        return null;
                    }
                    if (dVar.test(objPoll)) {
                        return objPoll;
                    }
                    if (this.e == 2) {
                        eVar.c(1L);
                    }
                }
                break;
            default:
                Object objPoll2 = this.f12576c.poll();
                if (objPoll2 == null) {
                    return null;
                }
                Object objApply = ((x4.c) this.g).apply(objPoll2);
                z4.b.a(objApply, "The mapper function returned a null value.");
                return objApply;
        }
    }
}
