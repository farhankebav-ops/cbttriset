package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1763iD extends MR {
    public static byte[] A02;

    @Nullable
    public final C1761iB A00;
    public final US A01;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 69, 74, 74, 65, 86};
    }

    public C1763iD(C1477dL c1477dL, MS ms, C1550eX c1550eX, US us, C1761iB c1761iB) {
        super(c1477dL, ms, c1550eX);
        this.A01 = us;
        this.A00 = c1761iB;
    }

    @Override // com.instagram.common.viewpoint.core.MR
    public final void A08(Map<String, String> map) {
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7G())) {
            this.A02.A0F().A3D();
            AbstractC0964Nw.A02(this.A00.A0X(), X0.A00(A01(0, 6, 62)));
            this.A01.AB5(this.A00.A7G(), map);
            if (U7.A19(this.A02)) {
                String string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                W2 w2A00 = W2.A00(this.A02);
                String placementType = this.A00.A7G();
                w2A00.A0E(string, placementType);
            }
        }
    }
}
