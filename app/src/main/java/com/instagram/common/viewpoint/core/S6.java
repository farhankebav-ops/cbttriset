package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S6 {
    public static byte[] A03;
    public static final AtomicBoolean A04;
    public C1451cu A00;
    public String A01;
    public final C1194Wz A02 = new C1194Wz(300000000000L, new C1509ds(this));

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{-56, -43, -56, -45, -42, -50, -86, -95, -80, -77, -85, -82, -89, -69, -80, -75, -84, -95, -64, -78, -64, -64, -74, -68, -69, -52, -63, -74, -70, -78};
    }

    static {
        A04();
        A04 = new AtomicBoolean(false);
    }

    public static TV A00(C1451cu c1451cu) {
        if (U7.A1A(c1451cu)) {
            return TW.A01(A01(0, 6, 55), A01(18, 12, 29), A01(6, 12, 12));
        }
        return TW.A00();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C1451cu c1451cu;
        synchronized (this) {
            c1451cu = this.A00;
        }
        if (c1451cu == null) {
            return;
        }
        String strA05 = TY.A00().A01(c1451cu, true).A05(A00(c1451cu));
        synchronized (this) {
            this.A01 = strA05;
        }
    }

    public static void A03() {
        A04.set(true);
    }

    public final synchronized String A06(C1451cu c1451cu) {
        this.A00 = c1451cu;
        this.A00.A08().ABq();
        this.A00.A04().ACe(c1451cu);
        if (this.A00.A07().AJC() || ((A04.get() && U7.A1w(this.A00)) || this.A01 == null)) {
            A02();
            this.A02.A04().A03();
            A04.set(false);
        }
        this.A02.A06();
        return this.A01;
    }

    public final void A07() {
        this.A02.A05();
    }
}
