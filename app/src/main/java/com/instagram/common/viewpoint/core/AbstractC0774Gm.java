package com.instagram.common.viewpoint.core;

import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0774Gm {
    public static byte[] A00;
    public static String[] A01 = {"wNk4F48Tu3AG7Z4F7CEax", "Q3Xv5sIL2TDrtW8yXR3dvi", "vexXXyFX5NNV4ziL4Q5MBx4locsFR2tR", "qvuj1ZZFgqOZzW4yl3sJoBizwIu3mzuW", "F9U7Z4TBUsCQBus7nNJljVmhfAVgv4lP", "pwS", "B3rn9fTC63wAJDGOR1lgaZRSiOmdejRD", "uz6PPvsEvjCr7qg3UfeXn9kgEA7UaI0b"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;
    public static final String[] A08;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{53, 73, 56, 61, 67, 3, 65, 68, 57, 59, -12, 8, -9, -4, 2, -62, 0, 3, -8, -6, -64, -33, -60, 47, 67, 50, 55, 61, -3, 59, 62, 51, 53, -5, 26, 0};
    }

    static {
        A05();
        A08 = new String[]{A04(10, 13, 22), A04(23, 13, 81), A04(0, 10, 87)};
        A07 = new int[]{DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE, 48000, 32000};
        A02 = new int[]{32000, 64000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
        A06 = new int[]{32000, 48000, 56000, 64000, 80000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
        A03 = new int[]{32000, 48000, 56000, 64000, 80000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
        A04 = new int[]{32000, 40000, 48000, 56000, 64000, 80000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
        A05 = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE, 112000, 128000, 144000, 160000};
    }

    public static int A00(int i2) {
        int i8;
        int layer;
        int padding;
        int i9;
        int samplingRate;
        int version;
        if (!A06(i2) || (i8 = (i2 >>> 19) & 3) == 1 || (layer = (i2 >>> 17) & 3) == 0 || (padding = (i2 >>> 12) & 15) == 0 || padding == 15 || (i9 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i10 = A07[i9];
        if (i8 == 2) {
            i10 /= 2;
        } else if (i8 == 0) {
            i10 /= 4;
        }
        int i11 = (i2 >>> 9) & 1;
        if (layer == 3) {
            if (i8 == 3) {
                int version2 = padding - 1;
                version = A02[version2];
            } else {
                int version3 = padding - 1;
                version = A06[version3];
            }
            return (((version * 12) / i10) + i11) * 4;
        }
        if (i8 == 3) {
            if (layer == 2) {
                int version4 = padding - 1;
                samplingRate = A03[version4];
            } else {
                int version5 = padding - 1;
                samplingRate = A04[version5];
            }
        } else {
            int[] iArr = A05;
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[1];
            int samplingRate2 = str.length();
            int version6 = str2.length();
            if (samplingRate2 == version6) {
                throw new RuntimeException();
            }
            A01[5] = "31X";
            int version7 = padding - 1;
            samplingRate = iArr[version7];
        }
        if (i8 == 3) {
            int version8 = samplingRate * 144;
            return (version8 / i10) + i11;
        }
        int version9 = layer == 1 ? 72 : 144;
        return ((version9 * samplingRate) / i10) + i11;
    }

    public static int A01(int i2) {
        int i8;
        int layer;
        if (!A06(i2) || (i8 = (i2 >>> 19) & 3) == 1 || (layer = (i2 >>> 17) & 3) == 0) {
            return -1;
        }
        int i9 = (i2 >>> 12) & 15;
        int version = i2 >>> 10;
        int version2 = version & 3;
        if (i9 == 0 || i9 == 15 || version2 == 3) {
            return -1;
        }
        int version3 = A02(i8, layer);
        return version3;
    }

    public static int A02(int i2, int i8) {
        switch (i8) {
            case 1:
                return i2 == 3 ? 1152 : 576;
            case 2:
                return 1152;
            case 3:
                return 384;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean A06(int i2) {
        return (i2 & (-2097152)) == -2097152;
    }

    public static /* synthetic */ int[] A0C() {
        int[] iArr = A04;
        if (A01[6].charAt(14) != 'G') {
            throw new RuntimeException();
        }
        A01[4] = "YpQ2FEpgCaHa1vzVK0UO04rJGRLP7Hel";
        return iArr;
    }
}
