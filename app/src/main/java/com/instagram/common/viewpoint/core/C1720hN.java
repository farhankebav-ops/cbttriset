package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1720hN extends AbstractRunnableC1164Vt {
    public static byte[] A05;
    public static String[] A06 = {"oXE2C4io4CadFj", "SLi30xh9eEh4aNBWy87TaVqEnPCRDurp", "eis5RYtigxDn0kuTv6xEcFlmBnmepzOu", "7zfUioi34Z20h4XlF6Svx2fywMYufGtL", "3ch3CCIwylkue97fKtVgZja7Sq2vQTLD", "WcYwUSLGNymzaUHoHnyTUfb", "YL0d97V0Q3k08jxWq5XvLfGqClGTo7H3", "GhmWEJEURttFfnvoo6VO1smQO3ReaFoJ"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ C1773iN A01;
    public final /* synthetic */ NU A02;
    public final /* synthetic */ C05406w A03;
    public final /* synthetic */ TC A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-97, -93, -59, -24, -27, -12, -8, -23, -10, -92, -8, -19, -15, -23, -13, -7, -8, -78, -74, -61, -61, -64, -61, -73, -67, -79, -4, -15, -11, -19, -9, -3, -4};
        String[] strArr = A06;
        if (strArr[6].charAt(10) != strArr[4].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[6] = "j4Ns4hKT00kRsJcq4mYGiSVRR39xkXLE";
        strArr2[4] = "aj4N2GTd0jkYX56rliTu9cnftT6aRfqb";
    }

    static {
        A01();
    }

    public C1720hN(C05406w c05406w, NU nu, C1773iN c1773iN, long j, TC tc) {
        this.A03 = c05406w;
        this.A02 = nu;
        this.A01 = c1773iN;
        this.A00 = j;
        this.A04 = tc;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A03.A0T(this.A02);
        this.A03.A0Q(this.A01);
        Map mapA01 = this.A03.A01(this.A00);
        mapA01.put(A00(18, 5, 53), A00(0, 2, 86));
        mapA01.put(A00(23, 3, 46), A00(26, 7, 108));
        this.A03.A05(this.A04.A03(TG.A04), mapA01);
        this.A03.ADB(new V1(AdErrorType.NETWORK_ERROR, A00(2, 16, 104)));
    }
}
