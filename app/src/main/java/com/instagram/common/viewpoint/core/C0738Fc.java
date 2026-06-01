package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0738Fc extends AbstractRunnableC1164Vt {
    public static byte[] A01;
    public static String[] A02 = {"zQTxaAZtyj5Zf7xpyBa5Wo13", "ZyRPoqiC9PInhvt4VYdLIOd5Fjjwld3Q", "AJVcAlxtfo1o3uDwHkILc2qtWBcw5I", "qm4l90vWWtQXhhB5Cv7", "msnWA3qGYryppWjZvi7PZr4M3Bb415RH", "kQT0oRvSr6py", "zmROIVOKOovaIXaapuTgFe6PU", "TFR8Ke0ijybG7ZAZ7LbnVmkovmXx0N"};
    public final /* synthetic */ C04573r A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-116, -97, -102, -101, -91, 86, -92, -101, -84, -101, -88, 86, -87, -86, -105, -88, -86, -101, -102, 86, -90, -94, -105, -81, -97, -92, -99};
    }

    static {
        A01();
    }

    public C0738Fc(C04573r c04573r) {
        this.A00 = c04573r;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.A0F) {
            C04573r c04573r = this.A00;
            if (A02[1].charAt(3) != 'P') {
                throw new RuntimeException();
            }
            A02[3] = "tIcfuB5su4wQORzkX2J";
            c04573r.A0R(A00(0, 27, 32));
        }
    }
}
