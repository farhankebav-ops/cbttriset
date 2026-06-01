package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhdq {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzc = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzd = {67108863, 33554431};
    private static final int[] zze = {26, 25};

    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] + jArr3[i2];
        }
    }

    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i2 = 0; i2 < 10; i2++) {
            jArr[i2] = jArr2[i2] - jArr3[i2];
        }
    }

    public static void zzc(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        if (length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, length);
            jArr = jArr3;
        }
        long j = jArr[8];
        long j3 = jArr[18];
        long j8 = j + (j3 << 4);
        jArr[8] = j8;
        long j9 = j3 + j3 + j8;
        jArr[8] = j9;
        jArr[8] = j9 + j3;
        long j10 = jArr[7];
        long j11 = jArr[17];
        long j12 = j10 + (j11 << 4);
        jArr[7] = j12;
        long j13 = j11 + j11 + j12;
        jArr[7] = j13;
        jArr[7] = j13 + j11;
        long j14 = jArr[6];
        long j15 = jArr[16];
        long j16 = j14 + (j15 << 4);
        jArr[6] = j16;
        long j17 = j15 + j15 + j16;
        jArr[6] = j17;
        jArr[6] = j17 + j15;
        long j18 = jArr[5];
        long j19 = jArr[15];
        long j20 = j18 + (j19 << 4);
        jArr[5] = j20;
        long j21 = j19 + j19 + j20;
        jArr[5] = j21;
        jArr[5] = j21 + j19;
        long j22 = jArr[4];
        long j23 = jArr[14];
        long j24 = j22 + (j23 << 4);
        jArr[4] = j24;
        long j25 = j23 + j23 + j24;
        jArr[4] = j25;
        jArr[4] = j25 + j23;
        long j26 = jArr[3];
        long j27 = jArr[13];
        long j28 = j26 + (j27 << 4);
        jArr[3] = j28;
        long j29 = j27 + j27 + j28;
        jArr[3] = j29;
        jArr[3] = j29 + j27;
        long j30 = jArr[2];
        long j31 = jArr[12];
        long j32 = j30 + (j31 << 4);
        jArr[2] = j32;
        long j33 = j31 + j31 + j32;
        jArr[2] = j33;
        jArr[2] = j33 + j31;
        long j34 = jArr[1];
        long j35 = jArr[11];
        long j36 = j34 + (j35 << 4);
        jArr[1] = j36;
        long j37 = j35 + j35 + j36;
        jArr[1] = j37;
        jArr[1] = j37 + j35;
        long j38 = jArr[0];
        long j39 = jArr[10];
        long j40 = j38 + (j39 << 4);
        jArr[0] = j40;
        long j41 = j39 + j39 + j40;
        jArr[0] = j41;
        jArr[0] = j41 + j39;
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i2 = 0;
        while (i2 < 10) {
            long j = jArr[i2];
            long j3 = j / 67108864;
            jArr[i2] = j - (j3 << 26);
            int i8 = i2 + 1;
            long j8 = jArr[i8] + j3;
            jArr[i8] = j8;
            long j9 = j8 / 33554432;
            jArr[i8] = j8 - (j9 << 25);
            i2 += 2;
            jArr[i2] = jArr[i2] + j9;
        }
        long j10 = jArr[0];
        long j11 = jArr[10];
        long j12 = j10 + (j11 << 4);
        jArr[0] = j12;
        long j13 = j11 + j11 + j12;
        jArr[0] = j13;
        long j14 = j13 + j11;
        jArr[0] = j14;
        jArr[10] = 0;
        long j15 = j14 / 67108864;
        jArr[0] = j14 - (j15 << 26);
        jArr[1] = jArr[1] + j15;
    }

    public static void zze(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr2[0];
        long j3 = jArr3[0];
        long j8 = j * j3;
        long j9 = jArr3[1];
        long j10 = jArr2[1];
        long j11 = (j10 * j3) + (j * j9);
        long j12 = jArr3[2];
        long j13 = jArr2[2];
        long j14 = ((j10 + j10) * j9) + (j * j12) + (j13 * j3);
        long j15 = jArr3[3];
        long j16 = jArr2[3];
        long j17 = (j10 * j12) + (j13 * j9) + (j * j15) + (j16 * j3);
        long j18 = jArr3[4];
        long j19 = jArr2[4];
        long j20 = (j10 * j15) + (j16 * j9);
        long j21 = j20 + j20 + (j13 * j12) + (j * j18) + (j19 * j3);
        long j22 = jArr3[5];
        long j23 = jArr2[5];
        long j24 = (j13 * j15) + (j16 * j12) + (j10 * j18) + (j19 * j9) + (j * j22) + (j23 * j3);
        long j25 = jArr3[6];
        long j26 = jArr2[6];
        long j27 = (j16 * j15) + (j10 * j22) + (j23 * j9);
        long j28 = j27 + j27 + (j13 * j18) + (j19 * j12) + (j * j25) + (j26 * j3);
        long j29 = jArr3[7];
        long j30 = jArr2[7];
        long j31 = (j16 * j18) + (j19 * j15) + (j13 * j22) + (j23 * j12) + (j10 * j25) + (j26 * j9) + (j * j29) + (j30 * j3);
        long j32 = jArr3[8];
        long j33 = jArr2[8];
        long j34 = (j16 * j22) + (j23 * j15) + (j10 * j29) + (j30 * j9);
        long j35 = j34 + j34 + (j19 * j18) + (j13 * j25) + (j26 * j12) + (j * j32) + (j33 * j3);
        long j36 = jArr3[9];
        long j37 = jArr2[9];
        long j38 = (j19 * j22) + (j23 * j18) + (j16 * j25) + (j26 * j15) + (j13 * j29) + (j30 * j12) + (j10 * j32) + (j33 * j9) + (j * j36) + (j3 * j37);
        long j39 = (j23 * j22) + (j16 * j29) + (j30 * j15) + (j10 * j36) + (j9 * j37);
        long j40 = (j23 * j29) + (j30 * j22) + (j16 * j36) + (j15 * j37);
        long j41 = (j30 * j29) + (j23 * j36) + (j22 * j37);
        long j42 = (j30 * j32) + (j33 * j29) + (j26 * j36) + (j25 * j37);
        long j43 = (j29 * j37) + (j30 * j36);
        zzc(new long[]{j8, j11, j14, j17, j21, j24, j28, j31, j35, j38, j39 + j39 + (j19 * j25) + (j26 * j18) + (j13 * j32) + (j33 * j12), (j23 * j25) + (j26 * j22) + (j19 * j29) + (j30 * j18) + (j16 * j32) + (j33 * j15) + (j13 * j36) + (j12 * j37), j40 + j40 + (j26 * j25) + (j19 * j32) + (j33 * j18), (j26 * j29) + (j30 * j25) + (j23 * j32) + (j33 * j22) + (j19 * j36) + (j18 * j37), j41 + j41 + (j26 * j32) + (j33 * j25), j42, j43 + j43 + (j33 * j32), (j32 * j37) + (j33 * j36), (j37 + j37) * j36}, jArr);
    }

    public static void zzf(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j3 = j * j;
        long j8 = jArr2[1];
        long j9 = (j + j) * j8;
        long j10 = jArr2[2];
        long j11 = (j * j10) + (j8 * j8);
        long j12 = jArr2[3];
        long j13 = (j * j12) + (j8 * j10);
        long j14 = jArr2[4];
        long j15 = (j10 * j10) + (j8 * 4 * j12) + ((j + j) * j14);
        long j16 = jArr2[5];
        long j17 = (j10 * j12) + (j8 * j14) + (j * j16);
        long j18 = jArr2[6];
        long j19 = (j12 * j12) + (j10 * j14) + (j * j18) + ((j8 + j8) * j16);
        long j20 = jArr2[7];
        long j21 = (j12 * j14) + (j10 * j16) + (j8 * j18) + (j * j20);
        long j22 = jArr2[8];
        long j23 = (j12 * j16) + (j8 * j20);
        long j24 = j23 + j23 + (j10 * j18) + (j * j22);
        long j25 = j24 + j24 + (j14 * j14);
        long j26 = jArr2[9];
        long j27 = (j14 * j16) + (j12 * j18) + (j10 * j20) + (j8 * j22) + (j * j26);
        long j28 = (j8 * j26) + (j12 * j20);
        long j29 = j28 + j28 + (j16 * j16) + (j14 * j18) + (j10 * j22);
        long j30 = (j16 * j18) + (j14 * j20) + (j12 * j22) + (j10 * j26);
        long j31 = (j12 * j26) + (j16 * j20);
        long j32 = j31 + j31 + (j14 * j22);
        long j33 = j32 + j32 + (j18 * j18);
        long j34 = (j18 * j20) + (j16 * j22) + (j14 * j26);
        long j35 = (j20 * j20) + (j18 * j22) + ((j16 + j16) * j26);
        long j36 = (j18 * j26) + (j20 * j22);
        zzc(new long[]{j3, j9, j11 + j11, j13 + j13, j15, j17 + j17, j19 + j19, j21 + j21, j25, j27 + j27, j29 + j29, j30 + j30, j33, j34 + j34, j35 + j35, j36 + j36, (j20 * 4 * j26) + (j22 * j22), (j22 + j22) * j26, (j26 + j26) * j26}, jArr);
    }

    public static long[] zzg(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i2 = 0; i2 < 10; i2++) {
            int i8 = zzb[i2];
            int i9 = bArr[i8] & 255;
            int i10 = bArr[i8 + 1] & 255;
            long j = ((long) i9) | (((long) i10) << 8);
            jArr[i2] = (((j | (((long) (bArr[i8 + 2] & 255)) << 16)) | (((long) (bArr[i8 + 3] & 255)) << 24)) >> zzc[i2]) & ((long) zzd[i2 & 1]);
        }
        return jArr;
    }

    public static byte[] zzh(long[] jArr) {
        int i2;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= 2) {
                break;
            }
            int i10 = 0;
            while (i10 < 9) {
                long j = jArrCopyOf[i10];
                int i11 = zze[i10 & 1];
                int i12 = -((int) (((j >> 31) & j) >> i11));
                jArrCopyOf[i10] = j + ((long) (i12 << i11));
                i10++;
                jArrCopyOf[i10] = jArrCopyOf[i10] - ((long) i12);
            }
            long j3 = jArrCopyOf[9];
            int i13 = -((int) (((j3 >> 31) & j3) >> 25));
            jArrCopyOf[9] = j3 + ((long) (i13 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - (((long) i13) * 19);
            i9++;
        }
        long j8 = jArrCopyOf[0];
        int i14 = -((int) (((j8 >> 31) & j8) >> 26));
        jArrCopyOf[0] = j8 + ((long) (i14 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i14);
        int i15 = 0;
        while (i15 < 2) {
            int i16 = i8;
            while (i16 < 9) {
                long j9 = jArrCopyOf[i16];
                int i17 = i16 & 1;
                int i18 = i8;
                long j10 = j9 >> zze[i17];
                jArrCopyOf[i16] = j9 & ((long) zzd[i17]);
                i16++;
                jArrCopyOf[i16] = jArrCopyOf[i16] + ((long) ((int) j10));
                i8 = i18;
                i15 = i15;
            }
            i15++;
        }
        int i19 = i8;
        long j11 = jArrCopyOf[9];
        jArrCopyOf[9] = j11 & 33554431;
        jArrCopyOf[i19] = (((long) ((int) (j11 >> 25))) * 19) + jArrCopyOf[i19];
        int i20 = ~((((int) r6) - 67108845) >> 31);
        for (int i21 = 1; i21 < 10; i21++) {
            int i22 = ~(((int) jArrCopyOf[i21]) ^ zzd[i21 & 1]);
            int i23 = i22 & (i22 << 16);
            int i24 = i23 & (i23 << 8);
            int i25 = i24 & (i24 << 4);
            int i26 = i25 & (i25 << 2);
            i20 &= (i26 & (i26 + i26)) >> 31;
        }
        jArrCopyOf[i19] = jArrCopyOf[i19] - ((long) (67108845 & i20));
        long j12 = 33554431 & i20;
        jArrCopyOf[1] = jArrCopyOf[1] - j12;
        for (i2 = 2; i2 < 10; i2 += 2) {
            jArrCopyOf[i2] = jArrCopyOf[i2] - ((long) (67108863 & i20));
            int i27 = i2 + 1;
            jArrCopyOf[i27] = jArrCopyOf[i27] - j12;
        }
        for (int i28 = i19; i28 < 10; i28++) {
            jArrCopyOf[i28] = jArrCopyOf[i28] << zzc[i28];
        }
        byte[] bArr = new byte[32];
        for (int i29 = i19; i29 < 10; i29++) {
            int i30 = zzb[i29];
            long j13 = bArr[i30];
            long j14 = jArrCopyOf[i29];
            bArr[i30] = (byte) (j13 | (j14 & 255));
            bArr[i30 + 1] = (byte) (((long) bArr[r5]) | ((j14 >> 8) & 255));
            bArr[i30 + 2] = (byte) (((long) bArr[r5]) | ((j14 >> 16) & 255));
            bArr[i30 + 3] = (byte) (((long) bArr[r4]) | ((j14 >> 24) & 255));
        }
        return bArr;
    }
}
