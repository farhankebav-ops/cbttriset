package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1999mJ implements InterfaceC0675Cr, InterfaceC0676Cs {
    public final int A00;
    public final /* synthetic */ C9A A01;

    public C1999mJ(C9A c9a, int i2) {
        this.A01 = c9a;
        this.A00 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0676Cs
    @MetaExoPlayerCustomization("Added in D21840558 for FBVP")
    public final long A81() {
        return this.A01.A0L[this.A00].A0S();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0675Cr
    public final boolean AAV() {
        return this.A01.A0f(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0675Cr
    public final void ABs() throws IOException {
        this.A01.A0d(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0675Cr
    public final int AGf(C6N c6n, C2076nY c2076nY, int i2) {
        return this.A01.A0Y(this.A00, c6n, c2076nY, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0675Cr
    public final int AJI(long j) {
        return this.A01.A0X(this.A00, j);
    }
}
