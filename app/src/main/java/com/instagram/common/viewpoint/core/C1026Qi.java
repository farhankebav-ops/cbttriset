package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1026Qi {
    public static String[] A05 = {"40gNEszX7YLOKw1QAED", "e7K0z1bDPzofCfI", "ASnLeHz2bV9", "nmSIAJ68DE4LOtHWgfxbIilOKN", "hLnVaEL0YJl", "iKeUOsk7q", "", "C"};
    public int A00 = 0;
    public int A01;
    public int A02;
    public int A03;
    public int A04;

    private final int A00(int i2, int i8) {
        if (i2 > i8) {
            return 1;
        }
        if (i2 == i8) {
            return 2;
        }
        return 4;
    }

    public final void A01() {
        this.A00 = 0;
    }

    public final void A02(int i2) {
        this.A00 |= i2;
    }

    public final void A03(int i2, int i8, int i9, int i10) {
        this.A04 = i2;
        this.A03 = i8;
        this.A02 = i9;
        this.A01 = i10;
    }

    public final boolean A04() {
        if ((this.A00 & 7) != 0 && (this.A00 & (A00(this.A02, this.A04) << 0)) == 0) {
            return false;
        }
        if ((this.A00 & 112) != 0 && (this.A00 & (A00(this.A02, this.A03) << 4)) == 0) {
            return false;
        }
        if ((this.A00 & 1792) != 0 && (this.A00 & (A00(this.A01, this.A04) << 8)) == 0) {
            return false;
        }
        if ((this.A00 & 28672) != 0 && (this.A00 & (A00(this.A01, this.A03) << 12)) == 0) {
            return false;
        }
        if (A05[0].length() == 6) {
            throw new RuntimeException();
        }
        A05[0] = "B0e1SHPnLLvWk0RI25GHgx";
        return true;
    }
}
