package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S4 {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06;
    public final S5 A00;
    public final S6 A01;
    public final C1451cu A02;
    public final InterfaceC1581f2 A03;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{122, 108, 71, 125, 96, 108, 106, 121, 107};
    }

    static {
        A01();
        A06 = S4.class.getSimpleName();
    }

    public S4(C1451cu c1451cu, InterfaceC0647Bn interfaceC0647Bn, S5 s52, S6 s62) {
        this.A02 = c1451cu;
        this.A03 = interfaceC0647Bn.A5M(EnumC1582f3.A06);
        this.A00 = s52;
        this.A01 = s62;
        this.A03.A3t(new C1512dv(this));
        A02();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            if (!this.A03.AAV()) {
                this.A02.A05().AAF();
                return;
            }
            String btExtras = this.A03.A7a().optString(A00(0, 9, 7));
            if (!TextUtils.isEmpty(btExtras)) {
                this.A00.A04(this.A02, btExtras);
                if (!A04 || U7.A0j(this.A02)) {
                    A04 = true;
                    this.A01.A07();
                }
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
        }
    }
}
