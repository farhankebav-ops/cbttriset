package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2E extends IllegalStateException {
    public final int A00;
    public final long A01;
    public final Timeline A02;

    public C2E(Timeline timeline, int i2, long j) {
        this.A02 = timeline;
        this.A00 = i2;
        this.A01 = j;
    }
}
