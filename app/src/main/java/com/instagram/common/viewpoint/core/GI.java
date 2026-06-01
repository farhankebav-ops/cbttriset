package com.instagram.common.viewpoint.core;

import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class GI {
    public static byte[] A00;
    public static String[] A01 = {"xbfghvjfzJvhku5N8OELiq204nVuVPFf", "QHdNkhaNqF6P8ZoHbM5E7ac9pSEOFT0I", "gTrjGkh7SJSYjcOCOWWCub6Uckq9Yltj", "B1r", "bt5fTN19iCcMkB3LBJCDNqZ6iO4ZjItL", "3vLSrbB7SQdOWYeFWsx", "mXdQOoT87saNovPMynKxKkWZ", "FMZbalTyTizDclIiFtsmYNu0onhdvCq9"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.instagram.common.viewpoint.core.GH A04(com.instagram.common.viewpoint.core.C4I r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.GI.A04(com.facebook.ads.redexgen.X.4I):com.facebook.ads.redexgen.X.GH");
    }

    public static String A05(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = bArrCopyOfRange[i10];
            if (A01[7].charAt(26) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "ZZS15YLfqnGzRKQmbGGBAS62S7daT6Pr";
            strArr[0] = "wbQ3s0ZhLtikxP7PtpYOpvXFjSSpaatC";
            bArrCopyOfRange[i10] = (byte) ((b8 - i9) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-121, -101, -118, -113, -107, 85, -121, -119, 90};
    }

    static {
        A06();
        A02 = new int[]{2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};
    }

    public static int A00(C4I c4i, int i2) {
        int i8 = 0;
        while (true) {
            int value = c4i.A04(i2);
            int i9 = i8 + value;
            if (!c4i.A0H()) {
                return i9;
            }
            i8 = (i9 + 1) << i2;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return A04(new C4I(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i2) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i8 = (headerSize & 255) << 8;
        int headerSize2 = bArr[3];
        int i9 = i8 | (headerSize2 & 255);
        int frameSize = 2 + 2;
        if (i9 == 65535) {
            int headerSize3 = bArr[4];
            int i10 = (headerSize3 & 255) << 16;
            int headerSize4 = bArr[5];
            int i11 = i10 | ((headerSize4 & 255) << 8);
            int headerSize5 = bArr[6];
            i9 = i11 | (headerSize5 & 255);
            frameSize += 3;
        }
        if (i2 == 44097) {
            frameSize += 2;
        }
        int i12 = i9 + frameSize;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[4];
        int iCharAt = str.charAt(27);
        int headerSize6 = str2.charAt(27);
        if (iCharAt == headerSize6) {
            throw new RuntimeException();
        }
        A01[7] = "5dLepgbvmcODZNjBgadRz1gh8sb0vEN9";
        return i12;
    }

    public static C2154or A03(C4J c4j, String str, String str2, DrmInitData drmInitData) {
        c4j.A0g(1);
        return new C2D().A0y(str).A11(A05(0, 9, 31)).A0b(2).A0m(((c4j.A0I() & 32) >> 5) == 1 ? 48000 : DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i2, C4J c4j) {
        c4j.A0d(7);
        byte[] bArrA0l = c4j.A0l();
        bArrA0l[0] = -84;
        bArrA0l[1] = 64;
        bArrA0l[2] = -1;
        bArrA0l[3] = -1;
        bArrA0l[4] = (byte) ((i2 >> 16) & 255);
        bArrA0l[5] = (byte) ((i2 >> 8) & 255);
        bArrA0l[6] = (byte) (i2 & 255);
    }
}
