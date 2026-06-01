package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1411cG implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C04674b A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{78, 113, 124, 125, 119, 72, 116, 121, 97, 122, 121, 123, 115, 93, 106, 106, 119, 106};
    }

    public RunnableC1411cG(C04674b c04674b) {
        this.A00 = c04674b;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0Z.AFg(A00(0, 18, 75));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
