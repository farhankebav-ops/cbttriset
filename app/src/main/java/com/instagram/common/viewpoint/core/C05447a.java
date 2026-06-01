package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C05447a extends AbstractC1814j4<LT> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{83, 90, 81, 81};
    }

    public C05447a(String str) {
        super(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1814j4
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final LN A04(LT lt) {
        return new LN(this, lt == null ? A00(0, 4, 114) : lt.A03());
    }
}
