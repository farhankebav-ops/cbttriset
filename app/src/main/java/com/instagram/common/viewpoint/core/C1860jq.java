package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1860jq implements KJ {
    public static byte[] A0G;
    public static String[] A0H = {"cAtU07tvAHmpQwteCa8pEQH5gF5iUcfh", "Hjeg7grS71Jm6r5NKbmR8o7Al25NvLrB", "8TbkpeEOwiN436cBQhp4NSePMq1Z0ZNp", "wFA3Sleqv", "yws6lvEdJf3TdH9okNAymdfPd8aH69ii", "xvx7jE251jeLUpmQ5JTTtAODp7RTPAZj", "flKrm8KbmQNj7vJDUwRTOfFPMCPuTaKn", "2PQM5lIFNms8BVmrvHkuPmbcHqu7a2gR"};
    public static final double[] A0I;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public H1 A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final C4J A0B;
    public final KK A0C;
    public final KS A0D;
    public final C0872Kh A0E;
    public final boolean[] A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<C2154or, Long> A00(KK kk, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(kk.A02, kk.A00);
        int i2 = bArrCopyOf[4] & 255;
        int i8 = bArrCopyOf[5] & 255;
        int i9 = (i2 << 4) | (i8 >> 4);
        int i10 = ((i8 & 15) << 8) | (bArrCopyOf[6] & 255);
        float f4 = 1.0f;
        switch ((bArrCopyOf[7] & 240) >> 4) {
            case 2:
                float f8 = i10 * 4;
                float f9 = i9 * 3;
                if (A0H[2].charAt(3) == 'k') {
                    A0H[1] = "IKG5315UEoYuWi8w79ZvxkF28jax6fmF";
                    f4 = f8 / f9;
                    break;
                }
                throw new RuntimeException();
            case 3:
                f4 = (i10 * 16) / (i9 * 9);
                break;
            case 4:
                f4 = (i10 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE) / (i9 * 100);
                break;
        }
        C2154or c2154orA14 = new C2D().A0y(str).A11(A01(0, 11, 62)).A0r(i9).A0f(i10).A0Y(f4).A12(Collections.singletonList(bArrCopyOf)).A14();
        long j = 0;
        int i11 = (bArrCopyOf[7] & 15) - 1;
        if (i11 >= 0 && i11 < A0I.length) {
            double d8 = A0I[i11];
            int i12 = kk.A01;
            int i13 = (bArrCopyOf[i12 + 9] & 96) >> 5;
            int i14 = bArrCopyOf[i12 + 9] & 31;
            if (i13 != i14) {
                double d9 = i13;
                if (A0H[2].charAt(3) == 'k') {
                    String[] strArr = A0H;
                    strArr[5] = "rAMAKKtXIRKmVhmwxuLKv06bcSnWRDth";
                    strArr[7] = "TlBzrdA8FTcPVEmXq7DzDEHR3QnpW5Am";
                    d8 *= (d9 + 1.0d) / ((double) (i14 + 1));
                }
                throw new RuntimeException();
            }
            j = (long) (1000000.0d / d8);
        }
        return Pair.create(c2154orA14, Long.valueOf(j));
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {50, 45, 32, 33, 43, 107, 41, 52, 33, 35, 118};
        if (A0H[4].charAt(19) != 'y') {
            throw new RuntimeException();
        }
        A0H[2] = "5b4kHrs0qMccPUXJRINIqLrMs4aEtqXr";
        A0G = bArr;
    }

    static {
        A02();
        A0I = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public C1860jq() {
        this(null);
    }

    public C1860jq(C0872Kh c0872Kh) {
        this.A0E = c0872Kh;
        this.A0F = new boolean[4];
        this.A0C = new KK(128);
        if (c0872Kh != null) {
            this.A0D = new KS(178, 128);
            this.A0B = new C4J();
        } else {
            this.A0D = null;
            this.A0B = null;
        }
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0117  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.instagram.common.viewpoint.core.KJ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A52(com.instagram.common.viewpoint.core.C4J r24) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1860jq.A52(com.facebook.ads.redexgen.X.4J):void");
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void A5U(GY gy, C0869Ke c0869Ke) {
        c0869Ke.A05();
        this.A06 = c0869Ke.A04();
        this.A05 = gy.AJh(c0869Ke.A03(), 2);
        if (this.A0E != null) {
            this.A0E.A03(gy, c0869Ke);
        }
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG5() {
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AG6(long j, int i2) {
        this.A01 = j;
    }

    @Override // com.instagram.common.viewpoint.core.KJ
    public final void AIL() {
        AbstractC0778Gq.A0H(this.A0F);
        this.A0C.A00();
        if (this.A0D != null) {
            KS ks = this.A0D;
            if (A0H[1].length() != 32) {
                throw new RuntimeException();
            }
            A0H[0] = "joVCJevLOtmtIagsqVBvfxemqq2mA7LA";
            ks.A00();
        }
        this.A04 = 0L;
        this.A0A = false;
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }
}
