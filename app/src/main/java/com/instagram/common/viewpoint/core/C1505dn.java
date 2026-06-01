package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1505dn extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public final /* synthetic */ C1504dm A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{14, 44, 46, 51, 48, -21, 49, 44, 52, 55, -7, -110, -80, -78, -73, -76, 111, -62, -60, -78, -78, -76, -62, -62, 125};
    }

    public C1505dn(C1504dm c1504dm, AtomicBoolean atomicBoolean) {
        this.A00 = c1504dm;
        this.A01 = atomicBoolean;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0I(UZ.A0H);
                SI.A02(this.A00.A02.A04, this.A00.A01, SI.A00, A00(11, 14, 1), this.A00.A02.A00);
                this.A00.A02.A0U();
                this.A00.A00.ACq();
                return;
            }
            this.A00.A02.A0I(UZ.A0G);
            SI.A02(this.A00.A02.A04, this.A00.A01, SI.A04, A00(0, 11, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), this.A00.A02.A00);
            this.A00.A02.A0V();
            this.A00.A00.ACh();
        }
    }
}
