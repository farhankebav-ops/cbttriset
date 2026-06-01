package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1283aC implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"fjtAB", "bsaRMRqbX1J53zhFSd", "3x", "d1GXs2u7l6dphEhs75uHz8nXS", "xBLq5iNxiropzdSod3RzWHu9Svz5m1J", "bqiGUlPWwNgoqXE8vIE4LDwWoR3rV8W6", "Cst7knLO4cVZP", "zRpbMV9q"};
    public final /* synthetic */ C04995h A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{115, 119, 123, 125, 127};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1283aC(C04995h c04995h) {
        this.A00 = c04995h;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A0E(A00(0, 5, 73));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            if (A02[2].length() == 17) {
                throw new RuntimeException();
            }
            A02[0] = "IkNABMfZpUuzelGW3VlRw";
        }
    }
}
