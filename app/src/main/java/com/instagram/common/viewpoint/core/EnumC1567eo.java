package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1567eo {
    A05(true, false),
    A06(true, true);

    public static byte[] A02;
    public static String[] A03 = {"2ontwM2arFslKncjF33kbqsw34bOv6le", "G9q7n4RrTr1", "g4gCsJajd0OYdOA8Ye5rYJWq4JgSICF", "NFoKf805ct", "mafT0Rfur7fS0CNoj1tBpTWo2FQFb5xI", "EiMXCOKYsXD", "uVuWHRjrR7UDLAS", "0Dp8HE0WixXMfpgDKF4PEgrQKOmjSnl7"};
    public boolean A00;
    public boolean A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{39, 37, 52, 86, 73, 85, 82};
    }

    static {
        A01();
    }

    EnumC1567eo(boolean z2, boolean z7) {
        this.A00 = z2;
        this.A01 = z7;
    }

    public final String A03() {
        return toString();
    }

    public final boolean A04() {
        return this.A00;
    }

    public final boolean A05() {
        return this.A01;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1567eo[] valuesCustom() {
        EnumC1567eo[] enumC1567eoArrValuesCustom = values();
        if (A03[7].charAt(2) != 'p') {
            throw new RuntimeException();
        }
        A03[7] = "eYpi2UA0ZlC7PiDY55aF0B4EyL2494ge";
        return (EnumC1567eo[]) enumC1567eoArrValuesCustom.clone();
    }
}
