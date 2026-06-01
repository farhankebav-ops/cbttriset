package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1857jn implements KJ {
    public static byte[] A0E;
    public static String[] A0F = {"InS58bT42EZESXm9qvWYUvire34TyqEd", "0QsKXE5Mty2kdKkFlxzakLoeZj9v1JPl", "NRhrqdNeBR4CDjsc7Q9NAC", "KBnn09jRwf0uKhIPK3OJ0VUHuR4AgDGD", "Nq6SUzmzwDzIZ8w7Fc8GQLnhk8OKIhKk", "EhougHeDeIMt7rS1ZxwR1ONoVKreOkGZ", "d5GlJf2nLv2o9PLs5SG9FlMqVuWi5Y0h", "iroqlmoe0TAfPMqOpys1zY2UwesgA9Cl"};
    public long A01;
    public H1 A02;
    public KR A03;
    public String A04;
    public boolean A05;
    public final KX A0C;
    public final boolean[] A0D = new boolean[3];
    public final KS A0B = new KS(32, 128);
    public final KS A09 = new KS(33, 128);
    public final KS A07 = new KS(34, 128);
    public final KS A08 = new KS(39, 128);
    public final KS A0A = new KS(40, 128);
    public long A00 = -9223372036854775807L;
    public final C4J A06 = new C4J();

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0E = new byte[]{7, 125, 121, 122, 29, 42, 46, 43, 42, 61, 93, 102, 109, 112, 120, 109, 107, 124, 109, 108, 40, 105, 123, 120, 109, 107, 124, 87, 122, 105, 124, 97, 103, 87, 97, 108, 107, 40, 126, 105, 100, 125, 109, 50, 40, 63, 32, 45, 44, 38, 102, 33, 44, 63, 42};
    }

    static {
        A03();
    }

    public C1857jn(KX kx) {
        this.A0C = kx;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.instagram.common.viewpoint.core.C2154or A00(java.lang.String r22, com.instagram.common.viewpoint.core.KS r23, com.instagram.common.viewpoint.core.KS r24, com.instagram.common.viewpoint.core.KS r25) {
        /*
            Method dump skipped, instruction units count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1857jn.A00(java.lang.String, com.facebook.ads.redexgen.X.KS, com.facebook.ads.redexgen.X.KS, com.facebook.ads.redexgen.X.KS):com.facebook.ads.redexgen.X.or");
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void A02() {
        C3M.A02(this.A02);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void A04(long j, int i2, int i8, long j3) {
        this.A03.A05(j, i2, this.A05);
        if (!this.A05) {
            this.A0B.A04(i8);
            this.A09.A04(i8);
            this.A07.A04(i8);
            if (this.A0B.A03() && this.A09.A03() && this.A07.A03()) {
                this.A02.A6W(A00(this.A04, this.A0B, this.A09, this.A07));
                this.A05 = true;
            }
        }
        KS ks = this.A08;
        if (A0F[2].length() == 29) {
            throw new RuntimeException();
        }
        A0F[7] = "vr6kqTkennNRVlA9BYLGssdVYhiLrcAb";
        if (ks.A04(i8)) {
            this.A06.A0j(this.A08.A01, AbstractC0778Gq.A02(this.A08.A01, this.A08.A00));
            this.A06.A0g(5);
            this.A0C.A02(j3, this.A06);
        }
        if (this.A0A.A04(i8)) {
            this.A06.A0j(this.A0A.A01, AbstractC0778Gq.A02(this.A0A.A01, this.A0A.A00));
            this.A06.A0g(5);
            this.A0C.A02(j3, this.A06);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void A05(long j, int i2, int i8, long j3) {
        this.A03.A04(j, i2, i8, j3, this.A05);
        if (!this.A05) {
            this.A0B.A01(i8);
            this.A09.A01(i8);
            this.A07.A01(i8);
        }
        this.A08.A01(i8);
        String[] strArr = A0F;
        if (strArr[4].charAt(1) == strArr[6].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[3] = "1KFxNiiYNj5YwxcZPXf7qOLOZg48Utfw";
        strArr2[0] = "AJhXWbHH6DfoOyxWmdhumfQDrV4Rkjlm";
        this.A0A.A01(i8);
    }

    public static void A06(C0780Gs c0780Gs) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i8 = 0;
            while (i8 < 6) {
                int i9 = 1;
                if (!c0780Gs.A0A()) {
                    c0780Gs.A04();
                } else {
                    int sizeId = i2 << 1;
                    int iMin = Math.min(64, 1 << (sizeId + 4));
                    if (i2 > 1) {
                        c0780Gs.A03();
                    }
                    for (int coefNum = 0; coefNum < iMin; coefNum++) {
                        c0780Gs.A03();
                        String[] strArr = A0F;
                        String str = strArr[1];
                        String str2 = strArr[5];
                        int iCharAt = str.charAt(22);
                        int sizeId2 = str2.charAt(22);
                        if (iCharAt == sizeId2) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0F;
                        strArr2[1] = "RIQaKQF3d2DPjAKRmkcEP1Qw2m8MXhOp";
                        strArr2[5] = "Zvlj8YgWRgjcS6ffkQSgKy13bXSJEEo8";
                    }
                }
                if (i2 == 3) {
                    i9 = 3;
                }
                i8 += i9;
            }
        }
    }

    public static void A07(C0780Gs c0780Gs) {
        int iA04 = c0780Gs.A04();
        boolean zA0A = false;
        int numNegativePics = 0;
        for (int stRpsIdx = 0; stRpsIdx < iA04; stRpsIdx++) {
            if (stRpsIdx != 0) {
                zA0A = c0780Gs.A0A();
            }
            if (zA0A) {
                c0780Gs.A06();
                c0780Gs.A04();
                for (int i2 = 0; i2 <= numNegativePics; i2++) {
                    if (c0780Gs.A0A()) {
                        c0780Gs.A06();
                    }
                }
            } else {
                int previousNumDeltaPocs = c0780Gs.A04();
                int iA042 = c0780Gs.A04();
                numNegativePics = previousNumDeltaPocs + iA042;
                for (int numShortTermRefPicSets = 0; numShortTermRefPicSets < previousNumDeltaPocs; numShortTermRefPicSets++) {
                    c0780Gs.A04();
                    c0780Gs.A06();
                }
                for (int numShortTermRefPicSets2 = 0; numShortTermRefPicSets2 < iA042; numShortTermRefPicSets2++) {
                    c0780Gs.A04();
                    c0780Gs.A06();
                }
            }
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void A08(byte[] bArr, int i2, int i8) {
        this.A03.A06(bArr, i2, i8);
        if (!this.A05) {
            this.A0B.A02(bArr, i2, i8);
            this.A09.A02(bArr, i2, i8);
            this.A07.A02(bArr, i2, i8);
        }
        this.A08.A02(bArr, i2, i8);
        this.A0A.A02(bArr, i2, i8);
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A52(C4J c4j) {
        A02();
        while (c4j.A07() > 0) {
            int limit = c4j.A09();
            int iA0A = c4j.A0A();
            byte[] bArrA0l = c4j.A0l();
            long j = this.A01;
            int offset = c4j.A07();
            this.A01 = j + ((long) offset);
            H1 h12 = this.A02;
            int offset2 = c4j.A07();
            h12.AI7(c4j, offset2);
            while (limit < iA0A) {
                int iA04 = AbstractC0778Gq.A04(bArrA0l, limit, iA0A, this.A0D);
                if (iA04 == iA0A) {
                    A08(bArrA0l, limit, iA0A);
                    return;
                }
                int bytesWrittenPastPosition = AbstractC0778Gq.A00(bArrA0l, iA04);
                int i2 = iA04 - limit;
                if (A0F[7].charAt(7) != 'e') {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[1] = "NnhvxMiSCkNhwXkURhMspTAR6cceqM1j";
                strArr[5] = "7ARxjazDMsknrtTfPy5OOEp3py29nWBE";
                if (i2 > 0) {
                    A08(bArrA0l, limit, iA04);
                }
                int lengthToNalUnit = iA0A - iA04;
                long j3 = this.A01 - ((long) lengthToNalUnit);
                int offset3 = i2 < 0 ? -i2 : 0;
                A04(j3, lengthToNalUnit, offset3, this.A00);
                long absolutePosition = this.A00;
                A05(j3, lengthToNalUnit, bytesWrittenPastPosition, absolutePosition);
                limit = iA04 + 3;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A5U(GY gy, C0869Ke c0869Ke) {
        c0869Ke.A05();
        this.A04 = c0869Ke.A04();
        this.A02 = gy.AJh(c0869Ke.A03(), 2);
        this.A03 = new KR(this.A02);
        this.A0C.A03(gy, c0869Ke);
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG5() {
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG6(long j, int i2) {
        if (j != -9223372036854775807L) {
            this.A00 = j;
        }
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AIL() {
        this.A01 = 0L;
        this.A00 = -9223372036854775807L;
        AbstractC0778Gq.A0H(this.A0D);
        this.A0B.A00();
        this.A09.A00();
        this.A07.A00();
        this.A08.A00();
        this.A0A.A00();
        if (this.A03 != null) {
            this.A03.A03();
        }
    }
}
