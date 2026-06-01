package com.instagram.common.viewpoint.core;

import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1933lD extends GQ {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1933lD(final C0769Gh c0769Gh, int i2, long j, long j3) {
        super(new GL() { // from class: com.facebook.ads.redexgen.X.lF
            @Override // com.instagram.common.viewpoint.core.GL
            public final long AJf(long j8) {
                return c0769Gh.A07(j8);
            }
        }, new C1934lE(c0769Gh, i2), c0769Gh.A06(), 0L, c0769Gh.A09, j, j3, c0769Gh.A05(), Math.max(6, c0769Gh.A06));
        Objects.requireNonNull(c0769Gh);
    }
}
