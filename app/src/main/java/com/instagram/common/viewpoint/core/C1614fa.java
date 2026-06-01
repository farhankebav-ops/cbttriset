package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1614fa implements NX {
    public static byte[] A03;
    public static String[] A04 = {"2TNZv5rtJTplZyjTIrSAFwUR6QP", "UjegX20Mk8HUIHIT", "Ti96PrkTuXG6IMzmEs5GDJe0LgUxYJn1", "WKFIsio5", "sT4eIPa9", "0D70Whi8Ioa2N41OWBvmw3gUZoSjgMHO", "iH11Sl", "erLbaj7N4o7d5mJ3hEM6"};
    public RO A00;
    public C1477dL A01;
    public final NativeAdBase.MediaCacheFlag A02;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[6].length() == 1) {
                throw new RuntimeException();
            }
            A04[0] = "MdmGKNh4C3mG92xgGyorPLR3SXO";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 88);
            i10++;
        }
    }

    public static void A03() {
        A03 = new byte[]{-26, -39, -20, -31, -18, -35, -28, -35, -38, -35, -34, -26, -35};
    }

    static {
        A03();
    }

    public C1614fa(RO ro, C1477dL c1477dL, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = ro;
        this.A01 = c1477dL;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.instagram.common.viewpoint.core.NX
    public final void ADB(V1 v12) {
        AbstractC1155Vk.A00(new C1617fd(this, v12));
    }

    @Override // com.instagram.common.viewpoint.core.NX
    public final void AEJ(List<C1773iN> list) {
        SF manager = new SF(this.A01);
        String firstRequestId = A02(6, 7, 23);
        for (C1773iN c1773iN : list) {
            if (A02(6, 7, 23).equals(firstRequestId)) {
                firstRequestId = c1773iN.A0G();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (c1773iN.A0E().A0F() != null) {
                    manager.A0c(new SD(c1773iN.A0E().A0F().getUrl(), c1773iN.A0E().A0F().getHeight(), c1773iN.A0E().A0F().getWidth(), c1773iN.A0G(), A02(0, 6, 32)));
                }
                if (c1773iN.A0E().A0E() != null) {
                    manager.A0c(new SD(c1773iN.A0E().A0E().getUrl(), c1773iN.A0E().A0E().getHeight(), c1773iN.A0E().A0E().getWidth(), c1773iN.A0G(), A02(0, 6, 32)));
                }
                if (!TextUtils.isEmpty(c1773iN.A0E().A0b())) {
                    manager.A0b(new SB(c1773iN.A0E().A0b(), c1773iN.A0G(), A02(0, 6, 32), c1773iN.A0E().A0A()));
                }
            }
        }
        manager.A0X(new C1615fb(this, list), new S8(firstRequestId, A02(0, 6, 32)));
    }
}
