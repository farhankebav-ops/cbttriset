package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6A {
    public static String[] A04 = {"8qiLNNQ5vyMVHTnGSRqIYH7vmKWFglWA", "MmZLlpUmCeAJmbrnsvUlOeosT2b4trAw", "F6OhdvzD3alSBTyOt6RaJoXj3nzaYsfx", "Xx287Yna8TF6bT1u1Go86DeoE2qCPeph", "3UZ5i1ilvbC05GJFJQV3kBZois6ux7zX", "EjY6nrBNo27Sp872cFf6GtSg6OGn5", "mF6jYE7WEwd2TxTTRWKuDem5zACYSEbg", "YtiRIUv5IVo7m2JEFXkoL0U8gRnX79g8"};
    public int A00;
    public int A01;
    public C05416x A02;
    public boolean A03;

    public C6A() {
    }

    public final void A03(int i2) {
        this.A01 += i2;
    }

    public final void A04(int i2) {
        if (this.A03 && this.A00 != 4) {
            C3M.A07(i2 == 4);
        } else {
            this.A03 = true;
            this.A00 = i2;
        }
    }

    public final void A05(C05416x c05416x) {
        this.A02 = c05416x;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(C05416x c05416x) {
        if (c05416x == this.A02) {
            int i2 = this.A01;
            if (A04[5].length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[3] = "a8XkvjAywsklqJZ77zbAyDpR6RKD2BNQ";
            strArr[2] = "VuupfHWuP4U2DCcYrL3QbObgg99PbZin";
            if (i2 <= 0 && !this.A03) {
                return false;
            }
        }
        return true;
    }
}
