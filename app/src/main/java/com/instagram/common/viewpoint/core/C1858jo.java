package com.instagram.common.viewpoint.core;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1858jo implements KJ {
    public static byte[] A0F;
    public static String[] A0G = {"mAIJKcC20Y3eOfYyWQRzrg7mLeRMrJFl", "eZxkBrFzPoxgu8goyyke6z3uoIiInH7I", "", "7SF2NgL0Q5eCPREDvftOSH9OstPB", "tBtJ4FuF4UkjOIbBZeVQSFTGpUKvKhYU", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "JQCW8upC74KuI6xTj5WGF", "PsTmzjLTY6QrmqAE1gFrtVK8jOOfhc8D"};
    public long A01;
    public H1 A02;
    public KQ A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final KX A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean[] A0E = new boolean[3];
    public final KS A0A = new KS(7, 128);
    public final KS A08 = new KS(8, 128);
    public final KS A09 = new KS(6, 128);
    public long A00 = -9223372036854775807L;
    public final C4J A07 = new C4J();

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{60, 35, 46, 47, 37, 101, 43, 60, 41};
    }

    static {
        A02();
    }

    public C1858jo(KX kx, boolean z2, boolean z7) {
        this.A0B = kx;
        this.A0C = z2;
        this.A0D = z7;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void A01() {
        C3M.A02(this.A02);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void A03(long j, int i2, int i8, long j3) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A04(i8);
            this.A08.A04(i8);
            if (!this.A05) {
                if (this.A0A.A03() && this.A08.A03()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.A0A.A01, this.A0A.A00));
                    arrayList.add(Arrays.copyOf(this.A08.A01, this.A08.A00));
                    C0777Gp c0777GpA09 = AbstractC0778Gq.A09(this.A0A.A01, 3, this.A0A.A00);
                    C0776Go c0776GoA07 = AbstractC0778Gq.A07(this.A08.A01, 3, this.A08.A00);
                    this.A02.A6W(new C2D().A0y(this.A04).A11(A00(0, 9, 116)).A0w(C3U.A01(c0777GpA09.A08, c0777GpA09.A01, c0777GpA09.A04)).A0r(c0777GpA09.A0A).A0f(c0777GpA09.A03).A0Y(c0777GpA09.A00).A12(arrayList).A14());
                    this.A05 = true;
                    this.A03.A04(c0777GpA09);
                    this.A03.A03(c0776GoA07);
                    this.A0A.A00();
                    this.A08.A00();
                }
            } else {
                boolean sampleIsKeyFrame = this.A0A.A03();
                if (sampleIsKeyFrame) {
                    this.A03.A04(AbstractC0778Gq.A09(this.A0A.A01, 3, this.A0A.A00));
                    this.A0A.A00();
                } else if (this.A08.A03()) {
                    this.A03.A03(AbstractC0778Gq.A07(this.A08.A01, 3, this.A08.A00));
                    this.A08.A00();
                }
            }
        }
        if (this.A09.A04(i8)) {
            byte[] bArr = this.A09.A01;
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "IcPmfl1yBNDnokE5CaufU";
            strArr[2] = "";
            this.A07.A0j(this.A09.A01, AbstractC0778Gq.A02(bArr, this.A09.A00));
            this.A07.A0f(4);
            this.A0B.A02(j3, this.A07);
        }
        boolean sampleIsKeyFrame2 = this.A03.A07(j, i2, this.A05, this.A06);
        if (sampleIsKeyFrame2) {
            this.A06 = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void A04(long j, int i2, long j3) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A01(i2);
            this.A08.A01(i2);
        }
        this.A09.A01(i2);
        this.A03.A02(j, i2, j3);
    }

    @RequiresNonNull({"sampleReader"})
    private void A05(byte[] bArr, int i2, int i8) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A02(bArr, i2, i8);
            this.A08.A02(bArr, i2, i8);
        }
        this.A09.A02(bArr, i2, i8);
        this.A03.A05(bArr, i2, i8);
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A52(C4J c4j) {
        A01();
        int iA09 = c4j.A09();
        int iA0A = c4j.A0A();
        byte[] bArrA0l = c4j.A0l();
        long j = this.A01;
        int offset = c4j.A07();
        this.A01 = j + ((long) offset);
        H1 h12 = this.A02;
        int offset2 = c4j.A07();
        h12.AI7(c4j, offset2);
        while (true) {
            int iA04 = AbstractC0778Gq.A04(bArrA0l, iA09, iA0A, this.A0E);
            if (iA04 == iA0A) {
                A05(bArrA0l, iA09, iA0A);
                return;
            }
            int lengthToNalUnit = AbstractC0778Gq.A01(bArrA0l, iA04);
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "800XsA7BA4hpamNrxbWO1";
            strArr[2] = "";
            int i2 = iA04 - iA09;
            if (i2 > 0) {
                A05(bArrA0l, iA09, iA04);
            }
            int i8 = iA0A - iA04;
            long j3 = this.A01 - ((long) i8);
            int offset3 = i2 < 0 ? -i2 : 0;
            A03(j3, i8, offset3, this.A00);
            A04(j3, lengthToNalUnit, this.A00);
            iA09 = iA04 + 3;
        }
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A5U(GY gy, C0869Ke c0869Ke) {
        c0869Ke.A05();
        this.A04 = c0869Ke.A04();
        this.A02 = gy.AJh(c0869Ke.A03(), 2);
        this.A03 = new KQ(this.A02, this.A0C, this.A0D);
        this.A0B.A03(gy, c0869Ke);
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG5() {
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG6(long j, int i2) {
        if (j != -9223372036854775807L) {
            this.A00 = j;
        }
        this.A06 |= (i2 & 2) != 0;
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AIL() {
        this.A01 = 0L;
        this.A06 = false;
        this.A00 = -9223372036854775807L;
        AbstractC0778Gq.A0H(this.A0E);
        this.A0A.A00();
        this.A08.A00();
        this.A09.A00();
        if (this.A03 != null) {
            this.A03.A01();
        }
    }
}
