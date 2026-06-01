package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C9M implements AnonymousClass39 {
    public final C9J A00;
    public final C2035mt A01;
    public final AnonymousClass38[] A02;

    public C9M(AnonymousClass38... anonymousClass38Arr) {
        this(anonymousClass38Arr, new C9J(), new C2035mt());
    }

    public C9M(AnonymousClass38[] anonymousClass38Arr, C9J c9j, C2035mt c2035mt) {
        this.A02 = new AnonymousClass38[anonymousClass38Arr.length + 2];
        System.arraycopy(anonymousClass38Arr, 0, this.A02, 0, anonymousClass38Arr.length);
        this.A00 = c9j;
        this.A01 = c2035mt;
        this.A02[anonymousClass38Arr.length] = c9j;
        this.A02[anonymousClass38Arr.length + 1] = c2035mt;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass39
    public final C2138ob A47(C2138ob c2138ob) {
        this.A01.A02(c2138ob.A01);
        this.A01.A01(c2138ob.A00);
        return c2138ob;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass39
    public final boolean A48(boolean z2) {
        this.A00.A0D(z2);
        return z2;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass39
    public final AnonymousClass38[] A6r() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass39
    public final long A8M(long j) {
        return this.A01.A00(j);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass39
    public final long A90() {
        return this.A00.A0C();
    }
}
