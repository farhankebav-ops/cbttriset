package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ih, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1791ih extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public final /* synthetic */ MW A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{117, 97, 118, 98, 102, 118, 125, 112, 106, 76, 112, 114, 99, 99, 122, 125, 116};
    }

    public C1791ih(MW mw, JSONObject jSONObject) {
        this.A00 = mw;
        this.A01 = jSONObject;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        try {
            this.A00.A05.await();
            synchronized (this.A00.A02) {
                this.A00.A02.A0B(this.A01);
                this.A00.A06.countDown();
            }
        } catch (InterruptedException e) {
            this.A00.A03.A08().AAy(A00(0, 17, 25), AbstractC1090Sv.A1B, new C1091Sw(e));
        } catch (JSONException e4) {
            this.A00.A0M();
            this.A00.A03.A08().AAy(A00(0, 17, 25), AbstractC1090Sv.A1A, new C1091Sw(e4));
        }
    }
}
