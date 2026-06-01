package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1874k4 implements J7 {
    public final List<C2105o2> A00;

    public C1874k4(List<C2105o2> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        C3M.A07(i2 == 0);
        return 0L;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A7w() {
        return 1;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A8S(long j) {
        return j < 0 ? 0 : -1;
    }
}
