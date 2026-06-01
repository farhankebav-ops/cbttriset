package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2132oU implements C1S {
    public static byte[] A00;
    public static String[] A01 = {"aC8uc30vckBh0ldJ8CsDkWWGmQgl7sOm", "2", "dPCbCdxH5PRV4edn", "QHj", "dDf", "KHWYQA", "nwDl9CeJStZlhkBKgBcw2akg3aHE6X2p", "I5"};
    public static final String A02;
    public static final C1R<AbstractC2132oU> A03;

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-126, -101, -104, -101, -100, -92, -101, 77, 127, -114, -95, -106, -101, -108, -127, -90, -99, -110, 103, 77};
    }

    static {
        A07();
        A02 = AbstractC04664a.A0h(0);
        A03 = new C1R() { // from class: com.facebook.ads.redexgen.X.oX
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return AbstractC2132oU.A04(bundle);
            }
        };
    }

    public static AbstractC2132oU A04(Bundle bundle) {
        int i2 = bundle.getInt(A02, -1);
        switch (i2) {
            case 0:
                return (AbstractC2132oU) C06019s.A02.A6X(bundle);
            case 1:
                AbstractC2132oU abstractC2132oU = (AbstractC2132oU) C05999q.A02.A6X(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr = A01;
                    strArr[7] = "RK";
                    strArr[1] = "0";
                    return abstractC2132oU;
                }
                break;
            case 2:
                return (AbstractC2132oU) C05989p.A04.A6X(bundle);
            case 3:
                C1S c1sA6X = C05979o.A02.A6X(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr2 = A01;
                    strArr2[7] = "Vr";
                    strArr2[1] = "2";
                    return (AbstractC2132oU) c1sA6X;
                }
                break;
            default:
                throw new IllegalArgumentException(A06(0, 20, 36) + i2);
        }
        throw new RuntimeException();
    }
}
