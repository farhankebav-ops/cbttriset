package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ie, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1790ie extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public final /* synthetic */ MW A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{36, 48, 39, 51, 55, 39, 44, 33, 59, 29, 33, 35, 50, 50, 43, 44, 37};
    }

    public C1790ie(MW mw, String str) {
        this.A00 = mw;
        this.A01 = str;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        String strA00 = A00(0, 17, 81);
        try {
            this.A00.A06.await();
            if (this.A00.A0J(this.A01)) {
                ((N2) this.A00.A02.A05().get(this.A01)).A04((int) (System.currentTimeMillis() / 1000));
                this.A00.A02.A07(this.A01);
                this.A00.A02.A06();
                this.A00.A08();
            }
        } catch (InterruptedException e) {
            this.A00.A03.A08().AAy(strA00, AbstractC1090Sv.A1B, new C1091Sw(e));
        } catch (JSONException e4) {
            this.A00.A0M();
            this.A00.A03.A08().AAy(strA00, AbstractC1090Sv.A1A, new C1091Sw(e4));
        }
    }
}
