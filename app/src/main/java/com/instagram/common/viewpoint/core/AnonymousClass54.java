package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.54, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass54 extends DV {
    public static byte[] A01;
    public final /* synthetic */ C1380bl A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{19, 4, 4, 25, 4};
    }

    public AnonymousClass54(C1380bl c1380bl) {
        this.A00 = c1380bl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(DW dw) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1378bj(this));
        this.A00.A0B.AFh(A00(0, 5, 126), this.A00.A03());
    }
}
