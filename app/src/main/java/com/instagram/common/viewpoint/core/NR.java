package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class NR {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{11, 77, 81, 72, 73};
    }

    public static void A02(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, boolean z2, NP np) {
        if (!U7.A27(c1477dL)) {
            SF sf = new SF(c1477dL);
            NB nbA07 = abstractC1752hy.A20().A0H().A07();
            sf.A0e(new C1120Ua(abstractC1752hy.A25(), c1477dL.A0A()));
            if (nbA07 == null) {
                np.AEZ(AdError.CACHE_ERROR);
                return;
            }
            if (nbA07.A0O()) {
                np.AEa();
                return;
            }
            SB sb = new SB(nbA07.A0F(), abstractC1752hy.A17(), abstractC1752hy.A0v());
            sb.A04 = true;
            sb.A03 = A00(0, 5, 86);
            switch (NO.A00[nbA07.A0A().ordinal()]) {
                case 1:
                case 2:
                    sf.A0Y(sb);
                    break;
            }
            sf.A0c(new SD(abstractC1752hy.A23().A01(), -1, -1, abstractC1752hy.A17(), abstractC1752hy.A0v()));
            sf.A0c(new SD(nbA07.A0E(), -1, -1, abstractC1752hy.A17(), abstractC1752hy.A0v()));
            sf.A0X(new C1732hZ(c1477dL, np, sf, nbA07, z2), new S8(abstractC1752hy.A17(), abstractC1752hy.A0v()));
            return;
        }
        np.AEa();
    }
}
