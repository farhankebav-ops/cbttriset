package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1764iE extends MR {
    public static byte[] A06;
    public static final String A07;
    public C1766iG A00;
    public V4 A01;
    public boolean A02;
    public final C1477dL A03;
    public final US A04;
    public final AbstractC1251Ze A05;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{-55, -56, -43, -43, -52, -39};
    }

    static {
        A05();
        A07 = C1764iE.class.getSimpleName();
    }

    public C1764iE(C1477dL c1477dL, US us, AbstractC1251Ze abstractC1251Ze, C1550eX c1550eX, MS ms, V4 v42) {
        super(c1477dL, ms, c1550eX);
        this.A04 = us;
        this.A05 = abstractC1251Ze;
        this.A03 = c1477dL;
        this.A01 = v42;
    }

    @Override // com.instagram.common.viewpoint.core.MR
    public final void A08(Map<String, String> map) {
        String string;
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7G())) {
            this.A03.A0F().A3D();
            AbstractC0964Nw.A02(this.A00.A05(), X0.A00(A04(0, 6, 50)));
            this.A04.AB5(this.A00.A7G(), map);
            if (U7.A19(this.A03)) {
                if (this.A01 == V4.A09) {
                    string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                } else {
                    string = AdPlacementType.BANNER.toString();
                }
                W2 w2A00 = W2.A00(this.A03);
                String placementType = this.A00.A7G();
                w2A00.A0E(string, placementType);
            }
        }
    }

    public final synchronized void A09() {
        if (!this.A02 && this.A00 != null) {
            this.A02 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                XJ.A00(new C1765iF(this));
            }
        }
    }

    public final void A0A(C1766iG c1766iG) {
        this.A00 = c1766iG;
    }
}
