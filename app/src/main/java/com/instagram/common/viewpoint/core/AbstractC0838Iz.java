package com.instagram.common.viewpoint.core;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0838Iz {
    public static String[] A0D = {"XeH1UKKuz1EDpBeQKhAXaKjrjZgsodJU", "Qh9sfVWsiKdbMkoZ0Fly5mM08PFSskfX", "g5Vgu", "IbV76iHRvjKg6MHaSQGzPOhr6f1ApNQX", "p6vckuBwU2Q2AllMmzSrbAD", "CWShENYx4MqsFhdcA74Ut20lXSF9FxoW", "efy3JamC8vBQUYLSbDR2yGzuJR", "AxMKck"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public GY A06;
    public H1 A07;
    public InterfaceC0835Iw A08;
    public boolean A0A;
    public boolean A0B;
    public final C0833Iu A0C = new C0833Iu();
    public C0837Iy A09 = new C0837Iy();

    public abstract long A09(C4J c4j);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean A0C(C4J c4j, long j, C0837Iy c0837Iy) throws IOException;

    @RequiresNonNull({"trackOutput"})
    private int A00(InterfaceC1943lN interfaceC1943lN) throws IOException {
        if (A03(interfaceC1943lN)) {
            this.A00 = this.A09.A00.A0G;
            if (!this.A0A) {
                this.A07.A6W(this.A09.A00);
                this.A0A = true;
            }
            InterfaceC0835Iw interfaceC0835Iw = this.A09.A01;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                throw new RuntimeException();
            }
            A0D[7] = "ikA5IIIrIRBN8L1z";
            if (interfaceC0835Iw != null) {
                this.A08 = this.A09.A01;
            } else if (interfaceC1943lN.A8G() == -1) {
                this.A08 = new C1895kP();
            } else {
                C0834Iv c0834IvA02 = this.A0C.A02();
                this.A08 = new C1901kV(this, this.A04, interfaceC1943lN.A8G(), c0834IvA02.A01 + c0834IvA02.A00, c0834IvA02.A05, (c0834IvA02.A04 & 4) != 0);
            }
            this.A01 = 2;
            this.A0C.A04();
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(com.instagram.common.viewpoint.core.InterfaceC1943lN r19, com.instagram.common.viewpoint.core.C0781Gt r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.AbstractC0838Iz.A01(com.facebook.ads.redexgen.X.lN, com.facebook.ads.redexgen.X.Gt):int");
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void A02() {
        C3M.A02(this.A07);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean A03(InterfaceC1943lN interfaceC1943lN) throws IOException {
        while (true) {
            C0833Iu c0833Iu = this.A0C;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                break;
            }
            A0D[7] = "RUb6h5R55PuDixsZqq";
            if (!c0833Iu.A05(interfaceC1943lN)) {
                this.A01 = 3;
                return false;
            }
            this.A03 = interfaceC1943lN.A8f() - this.A04;
            if (A0C(this.A0C.A01(), this.A04, this.A09)) {
                long jA8f = interfaceC1943lN.A8f();
                if (A0D[7].length() == 17) {
                    break;
                }
                A0D[0] = "MjaWWlFxdP245keDLyVkXHL1D0C1Hazn";
                this.A04 = jA8f;
            } else {
                return true;
            }
        }
        throw new RuntimeException();
    }

    public final int A04(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                return A00(interfaceC1943lN);
            case 1:
                interfaceC1943lN.AJJ((int) this.A04);
                this.A01 = 2;
                return 0;
            case 2:
                return A01(interfaceC1943lN, c0781Gt);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A05(long j) {
        return (1000000 * j) / ((long) this.A00);
    }

    public final long A06(long j) {
        return (((long) this.A00) * j) / 1000000;
    }

    public final void A07(long j, long j3) {
        this.A0C.A03();
        if (j == 0) {
            A0B(!this.A0B);
        } else {
            if (this.A01 == 0) {
                return;
            }
            this.A05 = A06(j3);
            ((InterfaceC0835Iw) AbstractC04664a.A0f(this.A08)).AJR(this.A05);
            this.A01 = 2;
        }
    }

    public final void A08(GY gy, H1 h12) {
        this.A06 = gy;
        this.A07 = h12;
        A0B(true);
    }

    public void A0A(long j) {
        this.A02 = j;
    }

    public void A0B(boolean z2) {
        if (z2) {
            this.A09 = new C0837Iy();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
