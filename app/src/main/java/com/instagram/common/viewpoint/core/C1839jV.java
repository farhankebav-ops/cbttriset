package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1839jV implements InterfaceC0874Kj {
    public static byte[] A0C;
    public static String[] A0D = {"bYPw9lwZ90LIMnDVrWR9nivpaP", "yFs6hGP2BjxCIYW4vwAvQB", "ThDP9clSa9Dn", "ZJ8KrZKjZ6YsWfu6TvhIHbPrHjBQXt73", "tonD2drFJKLGWlZx83XdaJTA2vW", "BxtbVLMcuUKNP9oDIvLT", "q4ZypHVOEkKJ", "0njOXKHdBu5kWS0YMUnz8"};
    public static final int[] A0E;
    public static final int[] A0F;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public final int A04;
    public final int A05;
    public final C2154or A06;
    public final C4J A07;
    public final GY A08;
    public final H1 A09;
    public final C0876Kl A0A;
    public final byte[] A0B;

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{-120, 109, -76, -68, -63, -121, 109, -51, 0, -8, -19, -21, -4, -19, -20, -88, -18, -6, -23, -11, -19, -5, -88, -8, -19, -6, -88, -22, -12, -9, -21, -13, -62, -88, -7, 13, -4, 1, 7, -57, 10, -7, 15};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(byte[] bArr, int i2, int i8, byte[] bArr2) {
        int i9 = this.A0A.A02;
        int i10 = this.A0A.A05;
        int i11 = (i8 * 4) + (i2 * i9);
        int i12 = (i10 * 4) + i11;
        int i13 = (i9 / i10) - 4;
        int iA07 = ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
        int iMin = Math.min(bArr[i11 + 2] & 255, 88);
        int i14 = A0F[iMin];
        int i15 = ((this.A04 * i2 * i10) + i8) * 2;
        bArr2[i15] = (byte) (iA07 & 255);
        bArr2[i15 + 1] = (byte) (iA07 >> 8);
        for (int i16 = 0; i16 < i13 * 2; i16++) {
            int i17 = bArr[((i16 / 8) * i10 * 4) + i12 + ((i16 / 2) % 4)] & 255;
            int i18 = i16 % 2 == 0 ? i17 & 15 : i17 >> 4;
            int i19 = ((((i18 & 7) * 2) + 1) * i14) >> 3;
            if ((i18 & 8) != 0) {
                i19 = -i19;
            }
            iA07 = AbstractC04664a.A07(iA07 + i19, -32768, 32767);
            i15 += i10 * 2;
            bArr2[i15] = (byte) (iA07 & 255);
            bArr2[i15 + 1] = (byte) (iA07 >> 8);
            iMin = AbstractC04664a.A07(iMin + A0E[i18], 0, A0F.length - 1);
            i14 = A0F[iMin];
        }
    }

    static {
        A04();
        A0E = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        A0F = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 143, 157, 173, 190, Sdk.SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    }

    public C1839jV(GY gy, H1 h12, C0876Kl c0876Kl) throws C04222i {
        this.A08 = gy;
        this.A09 = h12;
        this.A0A = c0876Kl;
        this.A05 = Math.max(1, c0876Kl.A04 / 10);
        C4J scratch = new C4J(c0876Kl.A06);
        scratch.A0G();
        this.A04 = scratch.A0G();
        int i2 = c0876Kl.A05;
        int i8 = (((c0876Kl.A02 - (i2 * 4)) * 8) / (c0876Kl.A01 * i2)) + 1;
        if (this.A04 == i8) {
            int numChannels = AbstractC04664a.A05(this.A05, this.A04);
            this.A0B = new byte[c0876Kl.A02 * numChannels];
            int maxBlocksToDecode = A02(this.A04, i2);
            this.A07 = new C4J(maxBlocksToDecode * numChannels);
            int maxBlocksToDecode2 = c0876Kl.A04;
            int constantBitrate = ((maxBlocksToDecode2 * c0876Kl.A02) * 8) / this.A04;
            this.A06 = new C2D().A11(A03(34, 9, 83)).A0a(constantBitrate).A0j(constantBitrate).A0h(A02(this.A05, i2)).A0b(c0876Kl.A05).A0m(c0876Kl.A04).A0i(2).A14();
            return;
        }
        throw C04222i.A01(A03(7, 27, 67) + i8 + A03(0, 7, 8) + this.A04, null);
    }

    private int A00(int i2) {
        return i2 / (this.A0A.A05 * 2);
    }

    private int A01(int i2) {
        return A02(i2, this.A0A.A05);
    }

    public static int A02(int i2, int i8) {
        return i2 * 2 * i8;
    }

    private void A05(int i2) {
        long jA0U = this.A03 + AbstractC04664a.A0U(this.A02, 1000000L, this.A0A.A04);
        int iA01 = A01(i2);
        this.A09.AIA(jA0U, 1, iA01, this.A01 - iA01, null);
        long timeUs = i2;
        this.A02 += timeUs;
        this.A01 -= iA01;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(byte[] r4, int r5, com.instagram.common.viewpoint.core.C4J r6) {
        /*
            r3 = this;
            r2 = 0
        L1:
            if (r2 >= r5) goto L17
            r1 = 0
        L4:
            com.facebook.ads.redexgen.X.Kl r0 = r3.A0A
            int r0 = r0.A05
            if (r1 >= r0) goto L14
            byte[] r0 = r6.A0l()
            r3.A06(r4, r2, r1, r0)
            int r1 = r1 + 1
            goto L4
        L14:
            int r2 = r2 + 1
            goto L1
        L17:
            int r0 = r3.A04
            int r0 = r0 * r5
            int r1 = r3.A01(r0)
            r0 = 0
            r6.A0f(r0)
            r6.A0e(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1839jV.A07(byte[], int, com.facebook.ads.redexgen.X.4J):void");
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final void AA0(int i2, long j) {
        this.A08.AIN(new C1836jS(this.A0A, this.A04, i2, j));
        this.A09.A6W(this.A06);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final void AI0(long j) {
        this.A00 = 0;
        this.A03 = j;
        this.A01 = 0;
        this.A02 = 0L;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0874Kj
    public final boolean AI9(InterfaceC1943lN interfaceC1943lN, long j) throws IOException {
        int iA00 = this.A05 - A00(this.A01);
        int targetFramesRemaining = this.A04;
        int blocksToDecode = AbstractC04664a.A05(iA00, targetFramesRemaining);
        int i2 = this.A0A.A02 * blocksToDecode;
        boolean z2 = j == 0;
        while (!z2) {
            int targetFramesRemaining2 = this.A00;
            if (targetFramesRemaining2 >= i2) {
                break;
            }
            int targetFramesRemaining3 = this.A00;
            int targetReadBytes = (int) Math.min(i2 - targetFramesRemaining3, j);
            byte[] bArr = this.A0B;
            int targetFramesRemaining4 = this.A00;
            int blocksToDecode2 = interfaceC1943lN.read(bArr, targetFramesRemaining4, targetReadBytes);
            if (blocksToDecode2 == -1) {
                z2 = true;
            } else {
                int targetFramesRemaining5 = this.A00;
                this.A00 = targetFramesRemaining5 + blocksToDecode2;
            }
        }
        int targetReadBytes2 = this.A00;
        int targetFramesRemaining6 = this.A0A.A02;
        int targetReadBytes3 = targetReadBytes2 / targetFramesRemaining6;
        if (targetReadBytes3 > 0) {
            A07(this.A0B, targetReadBytes3, this.A07);
            int blocksToDecode3 = this.A00;
            int targetFramesRemaining7 = this.A0A.A02;
            this.A00 = blocksToDecode3 - (targetFramesRemaining7 * targetReadBytes3);
            int blocksToDecode4 = A0D[3].charAt(16);
            if (blocksToDecode4 != 84) {
                throw new RuntimeException();
            }
            A0D[0] = "TvVFAtGQ";
            int targetReadBytes4 = this.A07.A0A();
            this.A09.AI7(this.A07, targetReadBytes4);
            int targetFramesRemaining8 = this.A01;
            this.A01 = targetFramesRemaining8 + targetReadBytes4;
            int targetFramesRemaining9 = this.A01;
            int blocksToDecode5 = A00(targetFramesRemaining9);
            int targetFramesRemaining10 = this.A05;
            if (blocksToDecode5 >= targetFramesRemaining10) {
                int targetFramesRemaining11 = this.A05;
                A05(targetFramesRemaining11);
            }
        }
        if (z2) {
            int targetFramesRemaining12 = this.A01;
            int targetFramesRemaining13 = A00(targetFramesRemaining12);
            if (targetFramesRemaining13 > 0) {
                A05(targetFramesRemaining13);
            }
        }
        return z2;
    }
}
