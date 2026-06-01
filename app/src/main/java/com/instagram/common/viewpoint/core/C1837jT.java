package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.util.Pair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1837jT implements GX {
    public static byte[] A07;
    public static String[] A08 = {"DwCwNe", "sWjhkz5Jk0aFlWxF8RAhYepliqmDVBH5", "fJB4aZ6fjAPSNUZta8hrgw0qJ7r8hoM5", "QGFmFhkJVom57VKObFa8uqUV9", "rnOb7nHa90E2wPIfOCxC", "at6D0iA1D4bxl", "SWjjSn0lfORi", "B3tBBFyQt38AAQleoY5s"};
    public static final InterfaceC0763Gb A09;
    public GY A04;
    public H1 A05;
    public InterfaceC0874Kj A06;
    public int A01 = 0;
    public long A03 = -1;
    public int A00 = -1;
    public long A02 = -1;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{87, 91, 2, 39, 50, 39, 102, 35, 62, 37, 35, 35, 34, 53, 102, 47, 40, 54, 51, 50, 102, 42, 35, 40, 33, 50, 46, 124, 102, 39, 28, 1, 7, 2, 2, 29, 0, 6, 23, 22, 82, 37, 51, 36, 82, 20, 29, 0, 31, 19, 6, 82, 6, 11, 2, 23, 72, 82, 127, 68, 89, 95, 90, 90, 69, 88, 94, 79, 78, 10, 69, 88, 10, 95, 68, 88, 79, 73, 69, 77, 68, 67, 80, 79, 78, 10, 93, 75, 92, 10, 76, 67, 70, 79, 10, 94, 83, 90, 79, 4, 103, 81, 70, 117, 72, 68, 66, 81, 83, 68, 95, 66, 17, 5, 20, 25, 31, 95, 23, 71, 65, 65, 93, 17, 28, 17, 7, 127, 107, 122, 119, 113, 49, 121, 41, 47, 47, 51, 115, 114, 127, 105, 55, 35, 50, 63, 57, 121, 36, 55, 33};
    }

    static {
        A03();
        A09 = new InterfaceC0763Gb() { // from class: com.facebook.ads.redexgen.X.jW
            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final GX[] A5F() {
                return C1837jT.A08();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC0763Gb
            public final /* synthetic */ GX[] A5G(Uri uri, Map map) {
                return AbstractC0762Ga.A01(this, uri, map);
            }
        };
    }

    private int A00(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C3M.A08(this.A02 != -1);
        return ((InterfaceC0874Kj) C3M.A01(this.A06)).AI9(interfaceC1943lN, this.A02 - interfaceC1943lN.A8f()) ? -1 : 0;
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void A02() {
        C3M.A02(this.A05);
    }

    private void A04(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C3M.A08(interfaceC1943lN.A8f() == 0);
        int i2 = this.A00;
        if (A08[5].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[7] = "oJOrgM3DzNUfWcxP3ghI";
        strArr[4] = "cZhhMb4kvP2y4vGeSU9A";
        if (i2 != -1) {
            interfaceC1943lN.AJJ(this.A00);
            this.A01 = 4;
        } else {
            if (AbstractC0878Kn.A06(interfaceC1943lN)) {
                interfaceC1943lN.AJJ((int) (interfaceC1943lN.A8a() - interfaceC1943lN.A8f()));
                this.A01 = 1;
                return;
            }
            throw C04222i.A01(A01(58, 42, 8), null);
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void A05(InterfaceC1943lN interfaceC1943lN) throws IOException {
        C0876Kl wavFormat = AbstractC0878Kn.A02(interfaceC1943lN);
        if (wavFormat.A03 == 17) {
            this.A06 = new C1839jV(this.A04, this.A05, wavFormat);
        } else if (wavFormat.A03 == 6) {
            this.A06 = new C1838jU(this.A04, this.A05, wavFormat, A01(112, 15, 82), -1);
        } else if (wavFormat.A03 == 7) {
            this.A06 = new C1838jU(this.A04, this.A05, wavFormat, A01(127, 15, 60), -1);
        } else {
            int iA00 = H9.A00(wavFormat.A03, wavFormat.A01);
            if (iA00 != 0) {
                this.A06 = new C1838jU(this.A04, this.A05, wavFormat, A01(142, 9, 116), iA00);
            } else {
                throw C04222i.A00(A01(29, 29, 80) + wavFormat.A03);
            }
        }
        this.A01 = 3;
    }

    private void A06(InterfaceC1943lN interfaceC1943lN) throws IOException {
        this.A03 = AbstractC0878Kn.A00(interfaceC1943lN);
        this.A01 = 2;
    }

    private void A07(InterfaceC1943lN interfaceC1943lN) throws IOException {
        Pair<Long, Long> pairA01 = AbstractC0878Kn.A01(interfaceC1943lN);
        this.A00 = ((Long) pairA01.first).intValue();
        long jLongValue = ((Long) pairA01.second).longValue();
        if (this.A03 != -1) {
            String[] strArr = A08;
            if (strArr[7].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "zD8CpsX01ISLh3RSws8RgUnhS";
            strArr2[6] = "h3zG6U6JIHw0";
            if (jLongValue == 4294967295L) {
                jLongValue = this.A03;
            }
        }
        this.A02 = ((long) this.A00) + jLongValue;
        long jA8G = interfaceC1943lN.A8G();
        if (jA8G != -1 && this.A02 > jA8G) {
            AnonymousClass44.A07(A01(100, 12, 18), A01(2, 27, 100) + this.A02 + A01(0, 2, 89) + jA8G);
            this.A02 = jA8G;
        }
        ((InterfaceC0874Kj) C3M.A01(this.A06)).AA0(this.A00, this.A02);
        this.A01 = 4;
    }

    public static /* synthetic */ GX[] A08() {
        return new GX[]{new C1837jT()};
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AA4(GY gy) {
        this.A04 = gy;
        this.A05 = gy.AJh(0, 1);
        gy.A6G();
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final int AGb(InterfaceC1943lN interfaceC1943lN, C0781Gt c0781Gt) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                A04(interfaceC1943lN);
                return 0;
            case 1:
                A06(interfaceC1943lN);
                if (A08[5].length() != 13) {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[3] = "VLLh2GyvdfrrOjqYmUQdrqO3c";
                strArr[6] = "Miu4m4vLnYY2";
                return 0;
            case 2:
                A05(interfaceC1943lN);
                return 0;
            case 3:
                A07(interfaceC1943lN);
                return 0;
            case 4:
                return A00(interfaceC1943lN);
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AGr() {
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final void AIM(long j, long j3) {
        this.A01 = j == 0 ? 0 : 4;
        if (this.A06 != null) {
            this.A06.AI0(j3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GX
    public final boolean AJL(InterfaceC1943lN interfaceC1943lN) throws IOException {
        return AbstractC0878Kn.A06(interfaceC1943lN);
    }
}
