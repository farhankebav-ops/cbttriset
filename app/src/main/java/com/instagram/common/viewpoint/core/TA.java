package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class TA extends MQ {
    public static byte[] A01;
    public final /* synthetic */ C1020Qc A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{95, 112, 101, 120, 103, 116, 49, 112, 117, 98, 49, 124, 112, 127, 112, 118, 116, 99, 49, 101, 121, 116, 120, 99, 49, 126, 102, 127, 49, 120, 124, 97, 99, 116, 98, 98, 120, 126, 127, 98, 63};
    }

    public TA(C1020Qc c1020Qc) {
        this.A00 = c1020Qc;
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0B(C1773iN c1773iN) {
        this.A00.A1W(c1773iN);
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0C() {
        if (this.A00.A0G != null) {
            this.A00.A0G.ACD();
        }
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 15));
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0F(MP mp) {
        if (this.A00.A0A != null) {
            this.A00.A0A.A0M();
        }
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0G(V1 v12) {
        this.A00.A12().A0F().A3F(XG.A01(this.A00.A00), v12.A03().getErrorCode(), v12.A04());
        if (this.A00.A0G != null) {
            this.A00.A0G.ADB(v12);
        }
    }
}
