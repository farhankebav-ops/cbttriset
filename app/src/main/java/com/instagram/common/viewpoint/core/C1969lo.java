package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1969lo implements C1S {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int[] A03;
    public static String[] A04 = {"0EeRaofkOnG82pPuB", "jcjJv", "T4n", "y6LXg9kPowsRJwalOEx6K", "cypgHvauDeb", "sGCac32Lryl6ta5A9qPel0ZSNDpSTc", "mAWrtqCYM7sM8yItQ0fM", "xdW2EE8FfL1ekapcbmlM6yOkR5Ux1S1"};
    public static final String A06 = AbstractC04664a.A0h(0);
    public static final String A07 = AbstractC04664a.A0h(1);
    public static final String A08 = AbstractC04664a.A0h(2);
    public static final C1R<C1969lo> A05 = new C1R() { // from class: com.facebook.ads.redexgen.X.lp
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C1969lo.A00(bundle);
        }
    };

    public C1969lo(int i2, int[] iArr, int i8) {
        this.A00 = i2;
        this.A03 = Arrays.copyOf(iArr, iArr.length);
        this.A01 = iArr.length;
        this.A02 = i8;
        Arrays.sort(this.A03);
    }

    public static /* synthetic */ C1969lo A00(Bundle bundle) {
        int i2 = bundle.getInt(A06, -1);
        int[] tracks = bundle.getIntArray(A07);
        int trackType = bundle.getInt(A08, -1);
        C3M.A07(i2 >= 0 && trackType >= 0);
        C3M.A01(tracks);
        return new C1969lo(i2, tracks, trackType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A04;
        if (strArr[5].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[6] = "RoyHwRFBbL3TyB1YuYs";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1969lo c1969lo = (C1969lo) obj;
        if (this.A00 == c1969lo.A00 && Arrays.equals(this.A03, c1969lo.A03) && this.A02 == c1969lo.A02) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.A00 * 31) + Arrays.hashCode(this.A03)) * 31;
        int hash = this.A02;
        return iHashCode + hash;
    }
}
