package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1419cO implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C4L A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{98, 93, 80, 81, 91, 100, 88, 85, 77, 86, 85, 87, 95, 113, 70, 70, 91, 70};
    }

    public RunnableC1419cO(C4L c4l) {
        this.A00 = c4l;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0V.AFg(A00(0, 18, 82));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
