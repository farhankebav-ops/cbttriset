package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1877k7 implements J7 {
    public final long[] A00;
    public final C2105o2[] A01;

    public C1877k7(C2105o2[] c2105o2Arr, long[] jArr) {
        this.A01 = c2105o2Arr;
        this.A00 = jArr;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        int iA0L = AbstractC04664a.A0L(this.A00, j, true, false);
        if (iA0L == -1 || this.A01[iA0L] == C2105o2.A0J) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.A01[iA0L]);
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        boolean z2 = true;
        C3M.A07(i2 >= 0);
        if (i2 >= this.A00.length) {
            z2 = false;
        }
        C3M.A07(z2);
        return this.A00[i2];
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A7w() {
        return this.A00.length;
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final int A8S(long j) {
        int iA0K = AbstractC04664a.A0K(this.A00, j, false, false);
        int index = this.A00.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
