package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ow, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0988Ow implements X5 {
    public static byte[] A03;
    public int A00;
    public String A01;
    public final X5 A02;

    static {
        A02();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-93, -93, -107, -104};
    }

    public C0988Ow(X5 x52) {
        this.A02 = x52;
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.AGO(this.A01 + A00(0, 4, 67) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void AGO(String str) {
        if (X7.A0A(str)) {
            A01();
            this.A02.AGO(str);
            return;
        }
        String strA04 = X7.A04(str);
        String filtered = this.A01;
        if (strA04.equals(filtered)) {
            this.A00++;
            return;
        }
        A01();
        this.A01 = strA04;
        this.A00 = 1;
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
