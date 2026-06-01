package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05999q extends AbstractC2132oU {
    public static byte[] A01;
    public static final C1R<C05999q> A02;
    public static final String A03;
    public final float A00;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{22, 3, 20, 5, 3, 8, 18, 70, 11, 19, 21, 18, 70, 4, 3, 70, 15, 8, 70, 18, 14, 3, 70, 20, 7, 8, 1, 3, 70, 9, 0, 70, 61, 86, 74, 70, 87, 86, 86, 59};
    }

    static {
        A03();
        A03 = AbstractC04664a.A0h(1);
        A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.of
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C05999q.A00(bundle);
            }
        };
    }

    public C05999q() {
        this.A00 = -1.0f;
    }

    public C05999q(float f4) {
        C3M.A09(f4 >= 0.0f && f4 <= 100.0f, A02(0, 40, 45));
        this.A00 = f4;
    }

    public static C05999q A00(Bundle bundle) {
        C3M.A07(bundle.getInt(AbstractC2132oU.A02, -1) == 1);
        float f4 = bundle.getFloat(A03, -1.0f);
        return f4 == -1.0f ? new C05999q() : new C05999q(f4);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C05999q) && this.A00 == ((C05999q) obj).A00;
    }

    public final int hashCode() {
        return BX.A00(Float.valueOf(this.A00));
    }
}
