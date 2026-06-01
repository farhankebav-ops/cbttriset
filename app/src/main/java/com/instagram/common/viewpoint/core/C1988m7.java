package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1988m7 implements J7 {
    public final long A00;
    public final AbstractC0621Am<C2105o2> A01;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.text.Cue> */
    public C1988m7(long j, AbstractC0621Am<C2105o2> abstractC0621Am) {
        this.A00 = j;
        this.A01 = abstractC0621Am;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        return j >= this.A00 ? this.A01 : Collections.emptyList();
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        C3M.A07(i2 == 0);
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A7w() {
        return 1;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A8S(long j) {
        return this.A00 > j ? 0 : -1;
    }
}
