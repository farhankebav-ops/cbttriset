package com.instagram.common.viewpoint.core;

import com.facebook.ads.AudienceNetworkAds;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZW extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public static String[] A03 = {"w4GsGaTCcJA9wFWp2KNopTJOjqP8UDpw", "KJoDcXHO6XERgkU18ZjJw4XTw2kjUjU4", "R80wDz5faPpVYHVxJychiW2DfFSiKcfh", "t0Fzi1DjxmxSLCfz9XJ2VaEQot34azEH", "xhDPy00jOuqmtbPp3auQzix75rw9IX8h", "Uu427jBhvNl8yC5HrJluoVTOz", "6hGUj4iS9agb9", "ga1SCcoGdvIpCjYHRj6uJxXsB"};
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ C1451cu A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A03[1].charAt(16) != '8') {
                throw new RuntimeException();
            }
            A03[1] = "4HO8Ss9k2AmZ8k9M8zrjCYxt48xbOoMK";
            bArrCopyOfRange[i10] = (byte) ((b8 ^ i9) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{3, 52, 59, 112, 35, 37, 51, 51, 53, 35, 35, 54, 37, 60, 60, 41, 112, 57, 62, 57, 36, 57, 49, 60, 57, 42, 53, 52, 113};
    }

    static {
        A01();
    }

    public ZW(C1451cu c1451cu, AudienceNetworkAds.InitListener initListener) {
        this.A01 = c1451cu;
        this.A00 = initListener;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        try {
            C1188Wt.A02().A0C(this.A01);
        } catch (Throwable th) {
            this.A01.A08().A4A(th);
        }
        TK.A0C(this.A01);
        if (this.A00 != null) {
            TK.A04(this.A00, new TJ(true, A00(0, 29, 22)));
        }
    }
}
