package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1846jc implements GP {
    public static String[] A04 = {"sdKdmhexVnrlWGhX9TH5KtuHBxlX2", "B98Zkm438dg3YkwTFsWcwjYsIqopE2cW", "q7DFl2FydsE0DWNk8QJk98tFdBPGU17r", "uw89PlDwsU5CTp5ALy1o", "HmpI", "x0Unc4LQNUVImDERNKiE", "Klo4tVDdc3zNBBgsT3eAMryjwXw3w", "mmy2vPNb8zCZX"};
    public final int A00;
    public final int A01;
    public final C4J A02 = new C4J();
    public final C4R A03;

    public C1846jc(int i2, C4R c4r, int i8) {
        this.A00 = i2;
        this.A03 = c4r;
        this.A01 = i8;
    }

    private GN A00(C4J c4j, long j, long j3) {
        int iA00;
        int iA002;
        int iA0A = c4j.A0A();
        long j8 = -1;
        long j9 = -1;
        long lastPcrTimeUsInRange = -9223372036854775807L;
        while (c4j.A07() >= 188 && (iA002 = (iA00 = AbstractC0871Kg.A00(c4j.A0l(), c4j.A09(), iA0A)) + 188) <= iA0A) {
            long jA01 = AbstractC0871Kg.A01(c4j, iA00, this.A00);
            if (jA01 != -9223372036854775807L) {
                long jA06 = this.A03.A06(jA01);
                if (jA06 > j) {
                    String[] strArr = A04;
                    if (strArr[1].charAt(12) == strArr[2].charAt(12)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[3] = "aExFpEIrb6zE8t35yvld";
                    strArr2[5] = "jMLoot3yN0lnttWSwPI3";
                    if (lastPcrTimeUsInRange == -9223372036854775807L) {
                        return GN.A04(jA06, j3);
                    }
                    return GN.A03(j3 + j8);
                }
                long j10 = jA06 + 100000;
                String[] strArr3 = A04;
                if (strArr3[1].charAt(12) != strArr3[2].charAt(12)) {
                    String[] strArr4 = A04;
                    strArr4[3] = "ZHgwZuqrkfLn2FTfbKUV";
                    strArr4[5] = "99YI6qOyfmrUQVvNk1ZB";
                    if (j10 > j) {
                        return GN.A03(((long) iA00) + j3);
                    }
                    j8 = iA00;
                    lastPcrTimeUsInRange = jA06;
                } else {
                    A04[4] = "5ynNf";
                    if (j10 > j) {
                        return GN.A03(((long) iA00) + j3);
                    }
                    j8 = iA00;
                    lastPcrTimeUsInRange = jA06;
                }
            }
            c4j.A0f(iA002);
            j9 = iA002;
        }
        if (lastPcrTimeUsInRange != -9223372036854775807L) {
            return GN.A05(lastPcrTimeUsInRange, j3 + j9);
        }
        return GN.A03;
    }

    @Override // com.instagram.common.viewpoint.core.GP
    public final void AFA() {
        this.A02.A0i(AbstractC04664a.A07);
    }

    @Override // com.instagram.common.viewpoint.core.GP
    public final GN AIC(InterfaceC1943lN interfaceC1943lN, long j) throws IOException {
        long jA8f = interfaceC1943lN.A8f();
        int iMin = (int) Math.min(this.A01, interfaceC1943lN.A8G() - jA8f);
        this.A02.A0d(iMin);
        interfaceC1943lN.AG9(this.A02.A0l(), 0, iMin);
        return A00(this.A02, j, jA8f);
    }
}
