package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1940lK implements InterfaceC0784Gw {
    public static String[] A02 = {"1Tt6ltc55g", "ops4n6D0RsDIbcNK2iFIW7Ay7S5Nano", "QFUbJLsUaFmSVLdjzr36RpAXorrqi07i", "7FxugF0ZmqBQk4dAnarwpNTfiaTe1g6g", "N3T7HRrxqFzk5rl0dpC6S3h47ocLp3rK", "Rq3uRmlvLOcLbWX3oXceNMTvaDTByq6j", "8TmLuftHICqYkzwVWbIwZIwFPzZSJxQj", "4hmJxBFNQAJLWam3xj85pvhcrB85xjeQ"};
    public final long A00;
    public final C0769Gh A01;

    public C1940lK(C0769Gh c0769Gh, long j) {
        this.A01 = c0769Gh;
        this.A00 = j;
    }

    private C0785Gx A00(long j, long j3) {
        return new C0785Gx((1000000 * j) / ((long) this.A01.A07), this.A00 + j3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A01.A06();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        long j3;
        C3M.A02(this.A01.A0A);
        long[] jArr = this.A01.A0A.A01;
        long[] jArr2 = this.A01.A0A.A00;
        int iA0L = AbstractC04664a.A0L(jArr, this.A01.A07(j), true, false);
        long j8 = 0;
        if (iA0L == -1) {
            j3 = 0;
        } else {
            j3 = jArr[iA0L];
        }
        if (iA0L != -1) {
            j8 = jArr2[iA0L];
        }
        C0785Gx c0785GxA00 = A00(j3, j8);
        if (c0785GxA00.A01 != j) {
            int length = jArr.length - 1;
            String[] strArr = A02;
            if (strArr[3].charAt(19) != strArr[6].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "o5tsTNyqew751hc5myqwVOdw8F1gICkG";
            strArr2[6] = "VidtQTuToVY7NImzxnJwSrK8bx75lEQY";
            if (iA0L != length) {
                C0785Gx secondSeekPoint = A00(jArr[iA0L + 1], jArr2[iA0L + 1]);
                return new C0783Gv(c0785GxA00, secondSeekPoint);
            }
        }
        return new C0783Gv(c0785GxA00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
