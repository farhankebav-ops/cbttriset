package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05627s implements InterfaceC1916kk {
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, Long> A00(long j, long[] jArr, long[] jArr2) {
        int iA0L = AbstractC04664a.A0L(jArr, j, true, true);
        long j3 = jArr[iA0L];
        long j8 = jArr2[iA0L];
        int i2 = iA0L + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j8));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr2[i2] - j8) * (jArr[i2] == j3 ? 0.0d : (j - j3) / (r4 - j3)))) + j8));
    }

    public C05627s(long[] jArr, long[] jArr2, long j) {
        this.A01 = jArr;
        this.A02 = jArr2;
        this.A00 = j == -9223372036854775807L ? AbstractC04664a.A0O(jArr2[jArr2.length - 1]) : j;
    }

    public static C05627s A01(long j, MlltFrame mlltFrame, long j3) {
        int length = mlltFrame.A03.length;
        int referenceCount = length + 1;
        long[] jArr = new long[referenceCount];
        int referenceCount2 = length + 1;
        long[] jArr2 = new long[referenceCount2];
        jArr[0] = j;
        jArr2[0] = 0;
        long j8 = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int referenceCount3 = i2 - 1;
            j += (long) (mlltFrame.A00 + mlltFrame.A03[referenceCount3]);
            int referenceCount4 = i2 - 1;
            j8 += (long) (mlltFrame.A01 + mlltFrame.A04[referenceCount4]);
            jArr[i2] = j;
            jArr2[i2] = j8;
        }
        return new C05627s(jArr, jArr2, j3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A7b() {
        return -1L;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        Pair<Long, Long> pairA00 = A00(AbstractC04664a.A0P(AbstractC04664a.A0T(j, 0L, this.A00)), this.A02, this.A01);
        return new C0783Gv(new C0785Gx(AbstractC04664a.A0O(((Long) pairA00.first).longValue()), ((Long) pairA00.second).longValue()));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A99(long j) {
        Pair<Long, Long> positionAndTimeMs = A00(j, this.A01, this.A02);
        return AbstractC04664a.A0O(((Long) positionAndTimeMs.second).longValue());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
