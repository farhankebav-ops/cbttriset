package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZF implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"sP3gpwd6Zoi5atkrMGPTc5EXN8BQ3Rhb", "CuI3HGsHCqf5OUDiTkLeplOhcTm9T7NI", "qUh1oDSzqsBPPR1tLa2Ioa4F3OHVyWz", "9USBf0H8rgb5C7JYpIITcKF8xtKeHlI", "rVv7rCrqZ3PnTP4EIzYeJpV", "KXSca88saLVPZ5uec2yV3IdyBKC0ygXP", "JOf8s03jk9aSXntkdxYTuuj", "1B5kCc4TTNYrg"};
    public final /* synthetic */ ZH A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[5].charAt(30) == 'J') {
                throw new RuntimeException();
            }
            A02[6] = "NOG9o";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 53);
            i10++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-68, -67, -54, -48, -49, -107, -67, -57, -68, -55, -58, -106, -93, -108, -106, -104, -87, -98, -85, -98, -87, -82, 20, 33, 23, 37, 34, 28, 23, -31, 28, 33, 39, 24, 33, 39, -31, 20, 22, 39, 28, 34, 33, -31, 9, -4, -8, 10};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
        if (!TextUtils.isEmpty(this.A00.A06) && !A00(0, 11, 38).equals(this.A00.A06)) {
            Intent intent = new Intent(A00(22, 26, 126), WQ.A00(this.A00.A06));
            intent.addFlags(268435456);
            this.A00.A09.A0F().A9q();
            try {
                WB.A0D(this.A00.A09, intent);
                if (this.A00.A04 != null) {
                    this.A00.A04.AEL();
                    return;
                }
                return;
            } catch (W9 e) {
                Throwable cause = e.getCause();
                W9 cause2 = e;
                if (cause != null) {
                    cause2 = e.getCause();
                }
                this.A00.A09.A08().AAy(A00(11, 11, 0), AbstractC1090Sv.A00, new C1091Sw(cause2));
                return;
            }
            AbstractC1156Vl.A00(th, this);
        }
    }

    static {
        A01();
    }

    public ZF(ZH zh) {
        this.A00 = zh;
    }
}
