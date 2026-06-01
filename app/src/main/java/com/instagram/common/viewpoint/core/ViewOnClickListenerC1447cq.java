package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1447cq implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"G2UpIRG7nHrOr90n", "kYhtZYHz7C3TU0WVzw0hA6O", "uW0OSEs2O", "98fx3b2TZyak0tYZ", "bs30TCHyJSAD4FU59WYQYpULQNB9Thj8", "Z9AhNL9JKwL2XNGWvK18w1A8N2mtiW", "DrOsL5ff6T5Di1pSQXw1oWhHj1xrfAsq", "4UtMvRkaUwptTB"};
    public final /* synthetic */ C04563q A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 45);
            if (A02[6].charAt(5) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "wiUvRTIpL";
            strArr[5] = "IscvqafGu8CzUXymljnx6wLgaNtEmJ";
            bArrCopyOfRange[i10] = b8;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{127, 114, 118, 115, 114, 101};
    }

    static {
        A01();
    }

    public ViewOnClickListenerC1447cq(C04563q c04563q) {
        this.A00 = c04563q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A01(A00(0, 6, 58));
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
