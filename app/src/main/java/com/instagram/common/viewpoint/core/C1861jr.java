package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1861jr implements KJ {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02 = -9223372036854775807L;
    public boolean A03;
    public final List<C0865Ka> A04;
    public final H1[] A05;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{1, 16, 16, 12, 9, 3, 1, 20, 9, 15, 14, -49, 4, 22, 2, 19, 21, 2, 19};
    }

    public C1861jr(List<C0865Ka> list) {
        this.A04 = list;
        this.A05 = new H1[list.size()];
    }

    private boolean A02(C4J c4j, int i2) {
        if (c4j.A07() == 0) {
            return false;
        }
        if (c4j.A0I() != i2) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A52(C4J c4j) {
        if (this.A03) {
            if (this.A00 == 2 && !A02(c4j, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c4j, 0)) {
                return;
            }
            int iA09 = c4j.A09();
            int iA07 = c4j.A07();
            for (H1 h12 : this.A05) {
                c4j.A0f(iA09);
                h12.AI7(c4j, iA07);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + iA07;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    @Override // com.instagram.common.viewpoint.core.KJ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5U(com.instagram.common.viewpoint.core.GY r8, com.instagram.common.viewpoint.core.C0869Ke r9) {
        /*
            r7 = this;
            r4 = 0
        L1:
            com.facebook.ads.redexgen.X.H1[] r0 = r7.A05
            int r0 = r0.length
            if (r4 >= r0) goto L52
            java.util.List<com.facebook.ads.redexgen.X.Ka> r0 = r7.A04
            java.lang.Object r6 = r0.get(r4)
            com.facebook.ads.redexgen.X.Ka r6 = (com.instagram.common.viewpoint.core.C0865Ka) r6
            r9.A05()
            int r1 = r9.A03()
            r0 = 3
            com.facebook.ads.redexgen.X.H1 r3 = r8.AJh(r1, r0)
            com.facebook.ads.redexgen.X.2D r1 = new com.facebook.ads.redexgen.X.2D
            r1.<init>()
            java.lang.String r0 = r9.A04()
            com.facebook.ads.redexgen.X.2D r5 = r1.A0y(r0)
            r2 = 0
            r1 = 19
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.2D r1 = r5.A11(r0)
            byte[] r0 = r6.A02
            java.util.List r0 = java.util.Collections.singletonList(r0)
            com.facebook.ads.redexgen.X.2D r1 = r1.A12(r0)
            java.lang.String r0 = r6.A01
            com.facebook.ads.redexgen.X.2D r0 = r1.A10(r0)
            com.facebook.ads.redexgen.X.or r0 = r0.A14()
            r3.A6W(r0)
            com.facebook.ads.redexgen.X.H1[] r0 = r7.A05
            r0[r4] = r3
            int r4 = r4 + 1
            goto L1
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1861jr.A5U(com.facebook.ads.redexgen.X.GY, com.facebook.ads.redexgen.X.Ke):void");
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG5() {
        if (this.A03) {
            if (this.A02 != -9223372036854775807L) {
                for (H1 h12 : this.A05) {
                    h12.AIA(this.A02, 1, this.A01, 0, null);
                }
            }
            this.A03 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG6(long j, int i2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.A03 = true;
        if (j != -9223372036854775807L) {
            this.A02 = j;
        }
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AIL() {
        this.A03 = false;
        this.A02 = -9223372036854775807L;
    }
}
