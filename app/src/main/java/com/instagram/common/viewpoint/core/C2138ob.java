package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ob, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2138ob implements C1S {
    public static byte[] A03;
    public static String[] A04 = {"UnBMZo2POSkJfz8F5ORuhqz31kXq7ERt", "GIL9xJe6rQGrNyWVB8WflXUexCYVOXiL", "1YJSMghIf03NGeOR9kmJ9bGOSAOIDk9h", "FbkWhL7EvytxWPK79enAjrYaTxkw07sQ", "DvmeNztcauqB3GuZI4NFBZAXEAF", "3h1K0W52WnqAecgG5ddVr1SgL8ZiRxH3", "SzBXc", "YkLyJW6tcdkoyMoq5nPmYT201JvYdNzP"};
    public static final C1R<C2138ob> A05;
    public static final C2138ob A06;
    public static final String A07;
    public static final String A08;
    public final float A00;
    public final float A01;
    public final int A02;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{109, 81, 92, 68, 95, 92, 94, 86, 109, 92, 79, 92, 80, 88, 73, 88, 79, 78, 21, 78, 77, 88, 88, 89, 0, 24, 19, 15, 91, 17, 29, 77, 84, 73, 94, 85, 0, 24, 19, 15, 91, 20};
    }

    static {
        A02();
        A06 = new C2138ob(1.0f);
        A08 = AbstractC04664a.A0h(0);
        A07 = AbstractC04664a.A0h(1);
        A05 = new C1R() { // from class: com.facebook.ads.redexgen.X.oc
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C2138ob.A00(bundle);
            }
        };
    }

    public C2138ob(float f4) {
        this(f4, 1.0f);
    }

    public C2138ob(float f4, float f8) {
        C3M.A07(f4 > 0.0f);
        C3M.A07(f8 > 0.0f);
        this.A01 = f4;
        this.A00 = f8;
        this.A02 = Math.round(1000.0f * f4);
    }

    public static /* synthetic */ C2138ob A00(Bundle bundle) {
        float f4 = bundle.getFloat(A08, 1.0f);
        float pitch = bundle.getFloat(A07, 1.0f);
        return new C2138ob(f4, pitch);
    }

    public final long A03(long j) {
        return ((long) this.A02) * j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2138ob c2138ob = (C2138ob) obj;
        if (this.A01 == c2138ob.A01) {
            float f4 = this.A00;
            float f8 = c2138ob.A00;
            if (A04[7].charAt(19) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "pC9U2";
            strArr[4] = "3ca7HvojzYBlvf3WwnTfkyYQmWq";
            if (f4 == f8) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = Float.floatToRawIntBits(this.A01);
        return (((17 * 31) + result) * 31) + Float.floatToRawIntBits(this.A00);
    }

    public final String toString() {
        return AbstractC04664a.A0n(A01(0, 42, 46), Float.valueOf(this.A01), Float.valueOf(this.A00));
    }
}
