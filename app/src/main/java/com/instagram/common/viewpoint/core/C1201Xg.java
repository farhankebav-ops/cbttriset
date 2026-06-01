package com.instagram.common.viewpoint.core;

import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1201Xg {
    public static byte[] A00;
    public static String[] A01 = {"CRKlMdJj7sWkVQXvhxP2gtYMKrwrdBdz", "MDVslC7yGiRJk7iB8DE8e8h4fEVrC5ER", "lH08WA", "RxIchMFZh", "vNyd6Jid8bvsA1cw15Ve5Ic9LBA7HcUI", "txgfdNfKSs8Co5f2ObGoVq", "d8ndlqqx7tIKNJdyWXTDq8r8sQB5dgXc", "5RbatCjsfF363SonahZsted9lIdQCMHb"};
    public static final String A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = bArrCopyOfRange[i10] - i9;
            String[] strArr = A01;
            if (strArr[4].charAt(3) != strArr[6].charAt(3)) {
                throw new RuntimeException();
            }
            A01[2] = "R3kMyn";
            bArrCopyOfRange[i10] = (byte) (i11 - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{109, -96, -117, -115, -104, -100, -111, -105, -106, 72, -111, -106, 72, -101, -117, -102, -115, -115, -106, 72, -111, -106, -100, -115, -102, -119, -117, -100, -111, -98, -115, 72, -117, -112, -115, -117, -109, 84, 72, -119, -101, -101, -99, -107, -111, -106, -113, 72, -111, -106, -100, -115, -102, -119, -117, -100, -111, -98, -115, 86, -33, -34, -26, -44, -31, -69, -78, -68, -76, -62};
    }

    static {
        A01();
        A02 = C1201Xg.class.getSimpleName();
    }

    public static boolean A02(C1477dL c1477dL) {
        return A03(c1477dL) && C1202Xh.A03(c1477dL);
    }

    public static boolean A03(C1477dL c1477dL) {
        if (c1477dL == null) {
            return true;
        }
        try {
            return ((PowerManager) c1477dL.getSystemService(A00(60, 5, 91))).isInteractive();
        } catch (Exception e) {
            Log.e(A02, A00(0, 60, 20), e);
            c1477dL.A08().AAy(A00(65, 5, 53), AbstractC1090Sv.A2S, new C1091Sw(e));
            return true;
        }
    }
}
