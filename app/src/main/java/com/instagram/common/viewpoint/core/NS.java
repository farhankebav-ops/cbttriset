package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class NS {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, 120};
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x00d7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(com.instagram.common.viewpoint.core.C1477dL r12, com.instagram.common.viewpoint.core.SF r13, com.instagram.common.viewpoint.core.AnonymousClass73 r14) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.NS.A02(com.facebook.ads.redexgen.X.dL, com.facebook.ads.redexgen.X.SF, com.facebook.ads.redexgen.X.73):void");
    }

    public static void A03(C1477dL c1477dL, SF sf, AnonymousClass73 anonymousClass73) {
        int i2 = 0;
        for (C0931Mp c0931Mp : anonymousClass73.A27()) {
            SD sd = new SD(c0931Mp.A0H().A08(), NN.A00(c0931Mp.A0H()), NN.A01(c0931Mp.A0H()), anonymousClass73.A17(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
            if (i2 == 0) {
                sf.A0c(sd);
            } else {
                sf.A0d(sd);
            }
            Iterator<String> it = c0931Mp.A0K().A02().iterator();
            while (it.hasNext()) {
                sf.A0d(new SD(it.next(), -1, -1, anonymousClass73.A17(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)));
            }
            if (!TextUtils.isEmpty(c0931Mp.A0H().A09())) {
                new SB(c0931Mp.A0H().A09(), anonymousClass73.A17(), A00(5, 12, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), c0931Mp.A0H().A06()).A04 = false;
            }
            i2++;
        }
    }
}
