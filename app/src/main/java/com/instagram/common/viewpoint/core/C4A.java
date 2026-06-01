package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4A {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-13, -21, -14, -15, -24};
    }

    public static void A02(Context context, C4D c4d) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C3M.A01((TelephonyManager) context.getSystemService(A00(0, 5, 11)));
            AnonymousClass49 callback = new AnonymousClass49(c4d);
            telephonyManager.registerTelephonyCallback(context.getMainExecutor(), callback);
            telephonyManager.unregisterTelephonyCallback(callback);
        } catch (RuntimeException unused) {
            c4d.A07(5);
        }
    }
}
