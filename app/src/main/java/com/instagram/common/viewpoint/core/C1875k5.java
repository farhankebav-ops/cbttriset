package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1875k5 implements J7 {
    public static String[] A01 = {"5dk9XJP2wGzKf", "t9Sqq8YLjeTrFPP9jF9lF", "ZSSLQReFK2RnB4Tl20", "6LiPtiUXCvNXZPkDmbiLO", "ML1syn76y5DaiFADQPhnbgz9k8Qidn9e", "l6QdmjZcy6MGH", "", "GeXYkzAGCbUHzEIcx9bq6WN7r3"};
    public static final C1875k5 A02 = new C1875k5();
    public final List<C2105o2> A00;

    public C1875k5() {
        this.A00 = Collections.emptyList();
    }

    public C1875k5(C2105o2 c2105o2) {
        this.A00 = Collections.singletonList(c2105o2);
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final List<C2105o2> A7P(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.instagram.common.viewpoint.core.J7
    public final long A7v(int i2) {
        C3M.A07(i2 == 0);
        if (A01[5].length() != 13) {
            throw new RuntimeException();
        }
        A01[7] = "BSEyCnkUJKVAglTMpAGc69o360";
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
