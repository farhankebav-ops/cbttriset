package com.instagram.common.viewpoint.core;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1188Wt implements SS {
    public static C1188Wt A07;
    public static byte[] A08;
    public LL A00;
    public SJ A01;
    public SR A02;
    public InterfaceC1076Sh A03;
    public TP A04;
    public InterfaceC1124Ue A05;
    public InterfaceC0647Bn A06;

    static {
        A07();
    }

    public static String A06(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{15, 13, 13, 18, 13, 17, 14, 58, 13, 31, 45, 45, 35, 41, 40, -38, 30, 27, 46, 27, -38, 35, 40, 35, 46, 35, 27, 38, 35, 52, 31, 30, 28, 15, 26, 25, 28, 30, -3, 15, 29, 29, 19, 25, 24, -18, 11, 30, 11, -13, 24, 19, 30, 19, 11, 22, 19, 36, 15, 14};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C1451cu c1451cu) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c1451cu);
        this.A06 = A05(c1451cu, this.A03, A03(c1451cu));
        A09(c1451cu, A00(c1451cu, this.A06));
        A0A(c1451cu, this.A06);
        A0B(c1451cu, this.A06);
        if (this.A06 != null) {
            this.A06.A6V();
        }
    }

    public static InterfaceC1053Rj A00(C1451cu c1451cu, InterfaceC0647Bn interfaceC0647Bn) {
        if (!U7.A1m(c1451cu) || interfaceC0647Bn == null) {
            return null;
        }
        return AbstractC1054Rk.A00().A00(interfaceC0647Bn);
    }

    public static InterfaceC1076Sh A01(C1451cu c1451cu) {
        return AbstractC1077Si.A00().A00(c1451cu, new YJ());
    }

    public static synchronized C1188Wt A02() {
        if (A07 == null) {
            A07 = new C1188Wt();
        }
        return A07;
    }

    public static InterfaceC1556ed A03(C1451cu c1451cu) {
        if (!U7.A1i(c1451cu)) {
            return null;
        }
        return C1574ev.A01(c1451cu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.SS
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC0647Bn A97() {
        return this.A06;
    }

    public static InterfaceC0647Bn A05(C1451cu c1451cu, InterfaceC1076Sh interfaceC1076Sh, InterfaceC1556ed interfaceC1556ed) {
        if (!U7.A2e(c1451cu) || interfaceC1556ed == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return AbstractC1596fI.A00().A00(c1451cu, interfaceC1076Sh, interfaceC1556ed, VZ.A04(c1451cu), new X8(new VR(c1451cu, A06(0, 0, 9), null, V6.A08, 0, new VB(), X7.A01(U7.A0N(c1451cu)), null, null, new C1709hB()), c1451cu), C1594fG.A00().A00());
    }

    public static void A08() {
        VF.A05(A06(32, 28, 52), A06(8, 24, 68), A06(0, 8, 99));
    }

    public static void A09(C1451cu c1451cu, InterfaceC1053Rj interfaceC1053Rj) {
        if (!U7.A1m(c1451cu) || interfaceC1053Rj == null) {
            return;
        }
        AbstractC1051Rh.A00().A00(interfaceC1053Rj, c1451cu);
    }

    public static void A0A(C1451cu c1451cu, InterfaceC0647Bn interfaceC0647Bn) {
        if (!U7.A0m(c1451cu) || interfaceC0647Bn == null) {
            return;
        }
        new S4(c1451cu, interfaceC0647Bn, new S5(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C1451cu c1451cu, InterfaceC0647Bn interfaceC0647Bn) {
        if (interfaceC0647Bn == null) {
            return;
        }
        UB.A00(c1451cu, interfaceC0647Bn);
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final US A6f(C1451cu c1451cu) {
        return VG.A01(c1451cu);
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized SR A6w(SQ sq) {
        if (this.A02 == null) {
            this.A02 = new XI(this);
        }
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized SJ A78() {
        if (this.A01 == null) {
            this.A01 = new C1500di();
        }
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized InterfaceC1076Sh A7d(SQ sq) {
        if (this.A03 == null) {
            this.A03 = A01(sq.A02());
        }
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized InterfaceC1089Su A7f(SQ sq) {
        return new C1250Zd(sq);
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized ST A7p(final SQ sq) {
        return new YI(sq) { // from class: com.facebook.ads.redexgen.X.6K
            @Override // com.instagram.common.viewpoint.core.ST
            public final boolean A9e() {
                return CM.A09();
            }

            @Override // com.instagram.common.viewpoint.core.ST
            public final void ABq() {
                TK.A06(RB.A09(super.A00));
            }

            @Override // com.instagram.common.viewpoint.core.ST
            public final void ACE() {
                TK.A07(RB.A09(super.A00));
            }

            @Override // com.instagram.common.viewpoint.core.ST
            public final void ACe(C1451cu c1451cu) {
                AbstractC0953Nl.A01(c1451cu);
            }
        };
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized LL A84(SQ sq) {
        if (!U7.A13(sq)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = LM.A00().A00(new YH(sq));
        }
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized SV A8q(SQ sq) {
        return new XN(sq);
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final C1451cu A8r(Context context) {
        C1451cu sdkContext = SP.A00();
        if (sdkContext == null) {
            C1451cu sdkContext2 = new C1451cu(context, this);
            SP.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized InterfaceC1124Ue A8s(C1451cu c1451cu) {
        if (this.A05 == null) {
            this.A05 = new VO(c1451cu);
        }
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.SS
    public final synchronized TP A8y() {
        if (this.A04 == null) {
            this.A04 = new TP();
            A08();
        }
        return this.A04;
    }
}
