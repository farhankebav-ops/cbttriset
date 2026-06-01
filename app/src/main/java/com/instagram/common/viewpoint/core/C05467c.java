package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C05467c extends AbstractC1814j4<LF> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-56, -49, -58, -58};
    }

    public C05467c(String str) {
        super(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1814j4
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final LN A04(LF lf) {
        return new LN(this, lf == null ? A00(0, 4, 46) : A00(0, 0, 18) + lf.A03());
    }
}
