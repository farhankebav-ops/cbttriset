package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1262Zp {
    public static byte[] A01;
    public final Map<String, String> A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-25, -6, -10, -12, -29, -31, -22, -21, -16, -10, -11, -37, -42, -36, -54, -49};
    }

    public C1262Zp() {
        this.A00 = new HashMap();
    }

    public C1262Zp(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final C1262Zp A02(XH xh) {
        if (xh != null) {
            this.A00.put(A00(11, 5, 48), AbstractC1186Wr.A01(xh.A04()));
        }
        return this;
    }

    public final C1262Zp A03(C1550eX c1550eX) {
        if (c1550eX != null) {
            this.A00.putAll(c1550eX.A0S());
        }
        return this;
    }

    public final C1262Zp A04(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 75), str);
        }
        return this;
    }

    public final Map<String, String> A05() {
        return this.A00;
    }
}
