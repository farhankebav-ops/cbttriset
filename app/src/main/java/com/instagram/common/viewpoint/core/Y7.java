package com.instagram.common.viewpoint.core;

import android.view.View;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y7 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ Y9 A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{124, 120, 116, 114, 112};
    }

    public Y7(Y9 y9) {
        this.A00 = y9;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A06.getCTAButton().A0E(A00(0, 5, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
