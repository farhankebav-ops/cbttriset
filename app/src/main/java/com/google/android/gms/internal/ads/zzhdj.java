package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhdj {
    private static final zzhde zzb = new zzhde(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final zzhdg zzc = new zzhdg(new zzhdh(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] zza = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    public static byte[] zza(byte[] bArr) {
        int i2;
        byte[] bArr2 = new byte[64];
        int i8 = 0;
        while (true) {
            if (i8 >= 32) {
                break;
            }
            int i9 = i8 + i8;
            bArr2[i9] = (byte) (bArr[i8] & 15);
            bArr2[i9 + 1] = (byte) ((bArr[i8] & 255) >> 4);
            i8++;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < 63) {
            byte b8 = (byte) (bArr2[i10] + i11);
            bArr2[i10] = b8;
            int i12 = (b8 + 8) >> 4;
            bArr2[i10] = (byte) (b8 - (i12 << 4));
            i10++;
            i11 = i12;
        }
        bArr2[63] = (byte) (bArr2[63] + i11);
        zzhdg zzhdgVar = new zzhdg(zzc);
        zzhdi zzhdiVar = new zzhdi();
        for (i2 = 1; i2 < 64; i2 += 2) {
            zzhde zzhdeVar = new zzhde(zzb);
            zzk(zzhdeVar, i2 / 2, bArr2[i2]);
            zzhdi.zza(zzhdiVar, zzhdgVar);
            zzg(zzhdgVar, zzhdiVar, zzhdeVar);
        }
        zzhdh zzhdhVar = new zzhdh();
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        for (int i13 = 0; i13 < 64; i13 += 2) {
            zzhde zzhdeVar2 = new zzhde(zzb);
            zzk(zzhdeVar2, i13 / 2, bArr2[i13]);
            zzhdi.zza(zzhdiVar, zzhdgVar);
            zzg(zzhdgVar, zzhdiVar, zzhdeVar2);
        }
        zzhdh zzhdhVar2 = new zzhdh(zzhdgVar);
        long[] jArr = new long[10];
        zzhdq.zzf(jArr, zzhdhVar2.zza);
        long[] jArr2 = new long[10];
        zzhdq.zzf(jArr2, zzhdhVar2.zzb);
        long[] jArr3 = new long[10];
        zzhdq.zzf(jArr3, zzhdhVar2.zzc);
        long[] jArr4 = new long[10];
        zzhdq.zzf(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhdq.zzb(jArr5, jArr2, jArr);
        zzhdq.zze(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhdq.zze(jArr6, jArr, jArr2);
        zzhdq.zze(jArr6, jArr6, zzhdl.zza);
        zzhdq.zza(jArr6, jArr6, jArr4);
        zzhdq.zzc(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhdq.zzh(jArr5), zzhdq.zzh(jArr6))) {
            return zzhdhVar2.zzb();
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) zzhrz.zzd.zzb("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i2 = bArrDigest[31] & 127;
        bArrDigest[31] = (byte) i2;
        bArrDigest[31] = (byte) (i2 | 64);
        return bArrDigest;
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte b8;
        byte[] bArr4 = bArr2;
        byte[] bArr5 = bArr3;
        if (bArr4.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, 32, 64);
        int i2 = 31;
        while (true) {
            if (i2 < 0) {
                break;
            }
            int i8 = bArrCopyOfRange[i2] & 255;
            int i9 = zza[i2] & 255;
            if (i8 == i9) {
                i2--;
                bArr4 = bArr2;
                bArr5 = bArr3;
            } else if (i8 < i9) {
                MessageDigest messageDigest = (MessageDigest) zzhrz.zzd.zzb("SHA-512");
                messageDigest.update(bArr4, 0, 32);
                messageDigest.update(bArr5);
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                long jZzn = zzn(bArrDigest, 0) & 2097151;
                long jZzo = zzo(bArrDigest, 2) >> 5;
                long jZzn2 = zzn(bArrDigest, 5) >> 2;
                long jZzo2 = zzo(bArrDigest, 7) >> 7;
                long jZzo3 = zzo(bArrDigest, 10) >> 4;
                long jZzn3 = zzn(bArrDigest, 13) >> 1;
                long jZzo4 = zzo(bArrDigest, 15) >> 6;
                long jZzn4 = zzn(bArrDigest, 18) >> 3;
                long jZzn5 = zzn(bArrDigest, 21) & 2097151;
                long jZzo5 = zzo(bArrDigest, 23) >> 5;
                long jZzn6 = zzn(bArrDigest, 26) >> 2;
                long jZzo6 = zzo(bArrDigest, 28) >> 7;
                long jZzo7 = zzo(bArrDigest, 31) >> 4;
                long jZzn7 = zzn(bArrDigest, 34) >> 1;
                long jZzo8 = zzo(bArrDigest, 36) >> 6;
                long jZzn8 = zzn(bArrDigest, 39) >> 3;
                long jZzn9 = zzn(bArrDigest, 42) & 2097151;
                long jZzo9 = zzo(bArrDigest, 44) >> 5;
                long jZzn10 = (zzn(bArrDigest, 47) >> 2) & 2097151;
                long jZzo10 = (zzo(bArrDigest, 49) >> 7) & 2097151;
                long jZzo11 = (zzo(bArrDigest, 52) >> 4) & 2097151;
                long jZzn11 = (zzn(bArrDigest, 55) >> 1) & 2097151;
                long jZzo12 = (zzo(bArrDigest, 57) >> 6) & 2097151;
                long jZzo13 = zzo(bArrDigest, 60) >> 3;
                long j = (jZzo11 * 666643) + jZzn5;
                long j3 = (jZzo10 * 666643) + jZzn4;
                long j8 = (jZzn10 * 666643) + (jZzo4 & 2097151);
                long j9 = (j8 + 1048576) >> 21;
                long j10 = j9 << 21;
                long j11 = (jZzn10 * 654183) + (jZzo10 * 470296) + j;
                long j12 = (j11 + 1048576) >> 21;
                long j13 = j12 << 21;
                long j14 = (jZzn10 * 136657) + (((jZzo11 * 654183) + ((jZzn11 * 470296) + ((jZzo12 * 666643) + (jZzn6 & 2097151)))) - (jZzo10 * 997805));
                long j15 = (j14 + 1048576) >> 21;
                long j16 = j15 << 21;
                long j17 = ((jZzo11 * 136657) + (((jZzo12 * 654183) + ((jZzo13 * 470296) + (jZzo7 & 2097151))) - (jZzn11 * 997805))) - (jZzo10 * 683901);
                long j18 = (j17 + 1048576) >> 21;
                long j19 = ((jZzo12 * 136657) + ((jZzo8 & 2097151) - (jZzo13 * 997805))) - (jZzn11 * 683901);
                long j20 = (j19 + 1048576) >> 21;
                long j21 = j20 << 21;
                long j22 = jZzn9 - (jZzo13 * 683901);
                long j23 = (j22 + 1048576) >> 21;
                long j24 = (jZzn10 * 470296) + j3 + j9;
                long j25 = (j24 + 1048576) >> 21;
                long j26 = j25 << 21;
                long j27 = (((jZzo10 * 654183) + ((jZzo11 * 470296) + ((jZzn11 * 666643) + (jZzo5 & 2097151)))) - (jZzn10 * 997805)) + j12;
                long j28 = (j27 + 1048576) >> 21;
                long j29 = j28 << 21;
                long j30 = (((jZzo10 * 136657) + (((jZzn11 * 654183) + ((jZzo12 * 470296) + ((jZzo13 * 666643) + (jZzo6 & 2097151)))) - (jZzo11 * 997805))) - (jZzn10 * 683901)) + j15;
                long j31 = (j30 + 1048576) >> 21;
                long j32 = j31 << 21;
                long j33 = (((jZzn11 * 136657) + (((jZzo13 * 654183) + (jZzn7 & 2097151)) - (jZzo12 * 997805))) - (jZzo11 * 683901)) + j18;
                long j34 = (j33 + 1048576) >> 21;
                long j35 = (((jZzo13 * 136657) + jZzn8) - (jZzo12 * 683901)) + j20;
                long j36 = (j35 + 1048576) >> 21;
                long j37 = (j17 - (j18 << 21)) + j31;
                long j38 = (j37 * 666643) + jZzn;
                long j39 = (j38 + 1048576) >> 21;
                long j40 = j39 << 21;
                long j41 = (j19 - j21) + j34;
                long j42 = j33 - (j34 << 21);
                long j43 = (j37 * 654183) + (j42 * 470296) + (j41 * 666643) + (jZzn2 & 2097151);
                long j44 = (j43 + 1048576) >> 21;
                long j45 = j44 << 21;
                long j46 = (j22 - (j23 << 21)) + j36;
                long j47 = j35 - (j36 << 21);
                long j48 = (j37 * 136657) + (((j41 * 654183) + ((j47 * 470296) + ((j46 * 666643) + (jZzo3 & 2097151)))) - (j42 * 997805));
                long j49 = (j48 + 1048576) >> 21;
                long j50 = j49 << 21;
                long j51 = (jZzo9 & 2097151) + j23;
                long j52 = ((j41 * 136657) + (((j46 * 654183) + ((j51 * 470296) + (j8 - j10))) - (j47 * 997805))) - (j42 * 683901);
                long j53 = (j52 + 1048576) >> 21;
                long j54 = j53 << 21;
                long j55 = ((j46 * 136657) + (((j11 - j13) + j25) - (j51 * 997805))) - (j47 * 683901);
                long j56 = (j55 + 1048576) >> 21;
                long j57 = j56 << 21;
                long j58 = ((j14 - j16) + j28) - (j51 * 683901);
                long j59 = (j58 + 1048576) >> 21;
                long j60 = j59 << 21;
                long j61 = (j37 * 470296) + (j42 * 666643) + (jZzo & 2097151) + j39;
                long j62 = (j61 + 1048576) >> 21;
                long j63 = (((j42 * 654183) + ((j41 * 470296) + ((j47 * 666643) + (jZzo2 & 2097151)))) - (j37 * 997805)) + j44;
                long j64 = (j63 + 1048576) >> 21;
                long j65 = (((j42 * 136657) + (((j47 * 654183) + ((j46 * 470296) + ((j51 * 666643) + (jZzn3 & 2097151)))) - (j41 * 997805))) - (j37 * 683901)) + j49;
                long j66 = (j65 + 1048576) >> 21;
                long j67 = (((j47 * 136657) + (((j51 * 654183) + (j24 - j26)) - (j46 * 997805))) - (j41 * 683901)) + j53;
                long j68 = (j67 + 1048576) >> 21;
                long j69 = (((j51 * 136657) + (j27 - j29)) - (j46 * 683901)) + j56;
                long j70 = (j69 + 1048576) >> 21;
                long j71 = (j30 - j32) + j59;
                long j72 = (j71 + 1048576) >> 21;
                long j73 = j72 << 21;
                long j74 = (j72 * 666643) + (j38 - j40);
                long j75 = j74 >> 21;
                long j76 = j75 << 21;
                long j77 = (j72 * 470296) + (j61 - (j62 << 21)) + j75;
                long j78 = j77 >> 21;
                long j79 = j78 << 21;
                long j80 = (j72 * 654183) + (j43 - j45) + j62 + j78;
                long j81 = j80 >> 21;
                long j82 = j81 << 21;
                long j83 = ((j63 - (j64 << 21)) - (j72 * 997805)) + j81;
                long j84 = j83 >> 21;
                long j85 = j84 << 21;
                long j86 = (j72 * 136657) + (j48 - j50) + j64 + j84;
                long j87 = j86 >> 21;
                long j88 = j87 << 21;
                long j89 = ((j65 - (j66 << 21)) - (j72 * 683901)) + j87;
                long j90 = j89 >> 21;
                long j91 = j90 << 21;
                long j92 = (j52 - j54) + j66 + j90;
                long j93 = j92 >> 21;
                long j94 = j93 << 21;
                long j95 = (j67 - (j68 << 21)) + j93;
                long j96 = j95 >> 21;
                long j97 = j96 << 21;
                long j98 = (j55 - j57) + j68 + j96;
                long j99 = j98 >> 21;
                long j100 = j99 << 21;
                long j101 = (j69 - (j70 << 21)) + j99;
                long j102 = j101 >> 21;
                long j103 = j102 << 21;
                long j104 = (j58 - j60) + j70 + j102;
                long j105 = j104 >> 21;
                long j106 = j105 << 21;
                long j107 = (j71 - j73) + j105;
                long j108 = j107 >> 21;
                long j109 = j108 << 21;
                long j110 = (666643 * j108) + (j74 - j76);
                long j111 = j110 >> 21;
                long j112 = j111 << 21;
                long j113 = (470296 * j108) + (j77 - j79) + j111;
                long j114 = j113 >> 21;
                long j115 = j114 << 21;
                long j116 = (654183 * j108) + (j80 - j82) + j114;
                long j117 = j116 >> 21;
                long j118 = j117 << 21;
                long j119 = ((j83 - j85) - (997805 * j108)) + j117;
                long j120 = j119 >> 21;
                long j121 = j120 << 21;
                long j122 = (136657 * j108) + (j86 - j88) + j120;
                long j123 = j122 >> 21;
                long j124 = j123 << 21;
                long j125 = ((j89 - j91) - (j108 * 683901)) + j123;
                long j126 = j125 >> 21;
                long j127 = j126 << 21;
                long j128 = (j92 - j94) + j126;
                long j129 = j128 >> 21;
                long j130 = j129 << 21;
                long j131 = (j95 - j97) + j129;
                long j132 = j131 >> 21;
                long j133 = j132 << 21;
                long j134 = (j98 - j100) + j132;
                long j135 = j134 >> 21;
                long j136 = j135 << 21;
                long j137 = (j101 - j103) + j135;
                long j138 = j137 >> 21;
                long j139 = j138 << 21;
                long j140 = (j104 - j106) + j138;
                long j141 = j140 >> 21;
                bArrDigest[0] = (byte) (j110 - j112);
                long j142 = j131 - j133;
                long j143 = j128 - j130;
                long j144 = j125 - j127;
                long j145 = j122 - j124;
                long j146 = j119 - j121;
                long j147 = j116 - j118;
                long j148 = j113 - j115;
                bArrDigest[1] = (byte) (r7 >> 8);
                bArrDigest[2] = (byte) ((r7 >> 16) | (j148 << 5));
                bArrDigest[3] = (byte) (j148 >> 3);
                bArrDigest[4] = (byte) (j148 >> 11);
                bArrDigest[5] = (byte) ((j148 >> 19) | (j147 << 2));
                bArrDigest[6] = (byte) (j147 >> 6);
                bArrDigest[7] = (byte) ((j147 >> 14) | (j146 << 7));
                bArrDigest[8] = (byte) (j146 >> 1);
                bArrDigest[9] = (byte) (j146 >> 9);
                bArrDigest[10] = (byte) ((j146 >> 17) | (j145 << 4));
                bArrDigest[11] = (byte) (j145 >> 4);
                bArrDigest[12] = (byte) (j145 >> 12);
                bArrDigest[13] = (byte) ((j145 >> 20) | (j144 + j144));
                bArrDigest[14] = (byte) (j144 >> 7);
                bArrDigest[15] = (byte) ((j144 >> 15) | (j143 << 6));
                bArrDigest[16] = (byte) (j143 >> 2);
                bArrDigest[17] = (byte) (j143 >> 10);
                bArrDigest[18] = (byte) ((j143 >> 18) | (j142 << 3));
                long j149 = j140 - (j141 << 21);
                long j150 = (j107 - j109) + j141;
                long j151 = j137 - j139;
                bArrDigest[19] = (byte) (j142 >> 5);
                bArrDigest[20] = (byte) (j142 >> 13);
                bArrDigest[21] = (byte) (j134 - j136);
                bArrDigest[22] = (byte) (r7 >> 8);
                bArrDigest[23] = (byte) ((r7 >> 16) | (j151 << 5));
                bArrDigest[24] = (byte) (j151 >> 3);
                bArrDigest[25] = (byte) (j151 >> 11);
                bArrDigest[26] = (byte) ((j151 >> 19) | (j149 << 2));
                bArrDigest[27] = (byte) (j149 >> 6);
                bArrDigest[28] = (byte) ((j149 >> 14) | (j150 << 7));
                bArrDigest[29] = (byte) (j150 >> 1);
                bArrDigest[30] = (byte) (j150 >> 9);
                bArrDigest[31] = (byte) (j150 >> 17);
                long[] jArr = new long[10];
                long[] jArrZzg = zzhdq.zzg(bArr5);
                long[] jArr2 = new long[10];
                jArr2[0] = 1;
                long[] jArr3 = new long[10];
                long[] jArr4 = new long[10];
                long[] jArr5 = new long[10];
                long[] jArr6 = new long[10];
                long[] jArr7 = new long[10];
                zzhdq.zzf(jArr4, jArrZzg);
                zzhdq.zze(jArr5, jArr4, zzhdl.zza);
                zzhdq.zzb(jArr4, jArr4, jArr2);
                zzhdq.zza(jArr5, jArr5, jArr2);
                long[] jArr8 = new long[10];
                zzhdq.zzf(jArr8, jArr5);
                zzhdq.zze(jArr8, jArr8, jArr5);
                zzhdq.zzf(jArr, jArr8);
                zzhdq.zze(jArr, jArr, jArr5);
                zzhdq.zze(jArr, jArr, jArr4);
                long[] jArr9 = new long[10];
                long[] jArr10 = new long[10];
                long[] jArr11 = new long[10];
                zzhdq.zzf(jArr9, jArr);
                zzhdq.zzf(jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr10);
                zzhdq.zze(jArr10, jArr, jArr10);
                zzhdq.zze(jArr9, jArr9, jArr10);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                for (int i10 = 1; i10 < 5; i10++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                for (int i11 = 1; i11 < 10; i11++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr10, jArr10, jArr9);
                zzhdq.zzf(jArr11, jArr10);
                for (int i12 = 1; i12 < 20; i12++) {
                    zzhdq.zzf(jArr11, jArr11);
                }
                zzhdq.zze(jArr10, jArr11, jArr10);
                zzhdq.zzf(jArr10, jArr10);
                for (int i13 = 1; i13 < 10; i13++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                for (int i14 = 1; i14 < 50; i14++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr10, jArr10, jArr9);
                zzhdq.zzf(jArr11, jArr10);
                for (int i15 = 1; i15 < 100; i15++) {
                    zzhdq.zzf(jArr11, jArr11);
                }
                zzhdq.zze(jArr10, jArr11, jArr10);
                zzhdq.zzf(jArr10, jArr10);
                for (int i16 = 1; i16 < 50; i16++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zze(jArr, jArr9, jArr);
                zzhdq.zze(jArr, jArr, jArr8);
                zzhdq.zze(jArr, jArr, jArr4);
                zzhdq.zzf(jArr6, jArr);
                zzhdq.zze(jArr6, jArr6, jArr5);
                zzhdq.zzb(jArr7, jArr6, jArr4);
                if (zze(jArr7)) {
                    zzhdq.zza(jArr7, jArr6, jArr4);
                    if (zze(jArr7)) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                    }
                    zzhdq.zze(jArr, jArr, zzhdl.zzc);
                }
                if (zze(jArr)) {
                    b8 = 255;
                } else {
                    b8 = 255;
                    if (((bArr3[31] & 255) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                }
                if (zzf(jArr) == ((bArr3[31] & b8) >> 7)) {
                    zzm(jArr, jArr);
                }
                zzhdq.zze(jArr3, jArr, jArrZzg);
                zzhdi zzhdiVar = new zzhdi(new zzhdh(jArr, jArrZzg, jArr2), jArr3);
                zzhdf[] zzhdfVarArr = new zzhdf[8];
                zzhdfVarArr[0] = new zzhdf(zzhdiVar);
                zzhdg zzhdgVar = new zzhdg(new zzhdh(), new long[10]);
                zzi(zzhdgVar, zzhdiVar.zza);
                zzhdi zzhdiVar2 = new zzhdi(zzhdgVar);
                for (int i17 = 1; i17 < 8; i17++) {
                    zzg(zzhdgVar, zzhdiVar2, zzhdfVarArr[i17 - 1]);
                    zzhdfVarArr[i17] = new zzhdf(new zzhdi(zzhdgVar));
                }
                byte[] bArrZzl = zzl(bArrDigest);
                byte[] bArrZzl2 = zzl(bArrCopyOfRange);
                zzhdg zzhdgVar2 = new zzhdg(zzc);
                zzhdi zzhdiVar3 = new zzhdi();
                int i18 = b8;
                while (i18 >= 0 && bArrZzl[i18] == 0 && bArrZzl2[i18] == 0) {
                    i18--;
                }
                while (i18 >= 0) {
                    zzi(zzhdgVar2, new zzhdh(zzhdgVar2));
                    byte b9 = bArrZzl[i18];
                    if (b9 > 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzg(zzhdgVar2, zzhdiVar3, zzhdfVarArr[bArrZzl[i18] / 2]);
                    } else if (b9 < 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzh(zzhdgVar2, zzhdiVar3, zzhdfVarArr[(-bArrZzl[i18]) / 2]);
                    }
                    byte b10 = bArrZzl2[i18];
                    if (b10 > 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzg(zzhdgVar2, zzhdiVar3, zzhdl.zze[bArrZzl2[i18] / 2]);
                    } else if (b10 < 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzh(zzhdgVar2, zzhdiVar3, zzhdl.zze[(-bArrZzl2[i18]) / 2]);
                    }
                    i18--;
                }
                byte[] bArrZzb = new zzhdh(zzhdgVar2).zzb();
                for (int i19 = 0; i19 < 32; i19++) {
                    if (bArrZzb[i19] != bArr2[i19]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void zzd() {
        if (zzhdl.zza == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    public static /* synthetic */ boolean zze(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhdq.zzd(jArr2);
        byte[] bArrZzh = zzhdq.zzh(jArr2);
        for (int i2 = 0; i2 < 32; i2++) {
            if (bArrZzh[i2] != 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int zzf(long[] jArr) {
        return zzhdq.zzh(jArr)[0] & 1;
    }

    private static void zzg(zzhdg zzhdgVar, zzhdi zzhdiVar, zzhde zzhdeVar) {
        zzhdh zzhdhVar = zzhdiVar.zza;
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhdhVar2.zza;
        long[] jArr3 = zzhdhVar.zzb;
        long[] jArr4 = zzhdhVar.zza;
        zzhdq.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhdhVar2.zzb;
        zzhdq.zzb(jArr5, jArr3, jArr4);
        zzhdq.zze(jArr5, jArr5, zzhdeVar.zzb);
        long[] jArr6 = zzhdeVar.zza;
        long[] jArr7 = zzhdhVar2.zzc;
        zzhdq.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhdgVar.zzb;
        zzhdq.zze(jArr8, zzhdiVar.zzb, zzhdeVar.zzc);
        zzhdeVar.zza(jArr2, zzhdhVar.zzc);
        zzhdq.zza(jArr, jArr2, jArr2);
        zzhdq.zzb(jArr2, jArr7, jArr5);
        zzhdq.zza(jArr5, jArr7, jArr5);
        zzhdq.zza(jArr7, jArr, jArr8);
        zzhdq.zzb(jArr8, jArr, jArr8);
    }

    private static void zzh(zzhdg zzhdgVar, zzhdi zzhdiVar, zzhde zzhdeVar) {
        zzhdh zzhdhVar = zzhdiVar.zza;
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhdhVar2.zza;
        long[] jArr3 = zzhdhVar.zzb;
        long[] jArr4 = zzhdhVar.zza;
        zzhdq.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhdhVar2.zzb;
        zzhdq.zzb(jArr5, jArr3, jArr4);
        zzhdq.zze(jArr5, jArr5, zzhdeVar.zza);
        long[] jArr6 = zzhdeVar.zzb;
        long[] jArr7 = zzhdhVar2.zzc;
        zzhdq.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhdgVar.zzb;
        zzhdq.zze(jArr8, zzhdiVar.zzb, zzhdeVar.zzc);
        zzhdeVar.zza(jArr2, zzhdhVar.zzc);
        zzhdq.zza(jArr, jArr2, jArr2);
        zzhdq.zzb(jArr2, jArr7, jArr5);
        zzhdq.zza(jArr5, jArr7, jArr5);
        zzhdq.zzb(jArr7, jArr, jArr8);
        zzhdq.zza(jArr8, jArr, jArr8);
    }

    private static void zzi(zzhdg zzhdgVar, zzhdh zzhdhVar) {
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = zzhdhVar2.zza;
        long[] jArr2 = zzhdhVar.zza;
        long[] jArr3 = new long[10];
        zzhdq.zzf(jArr, jArr2);
        long[] jArr4 = zzhdhVar2.zzc;
        long[] jArr5 = zzhdhVar.zzb;
        zzhdq.zzf(jArr4, jArr5);
        long[] jArr6 = zzhdgVar.zzb;
        zzhdq.zzf(jArr6, zzhdhVar.zzc);
        zzhdq.zza(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhdhVar2.zzb;
        zzhdq.zza(jArr7, jArr2, jArr5);
        zzhdq.zzf(jArr3, jArr7);
        zzhdq.zza(jArr7, jArr4, jArr);
        zzhdq.zzb(jArr4, jArr4, jArr);
        zzhdq.zzb(jArr, jArr3, jArr7);
        zzhdq.zzb(jArr6, jArr6, jArr4);
    }

    private static int zzj(int i2, int i8) {
        int i9 = (~(i2 ^ i8)) & 255;
        int i10 = i9 & (i9 << 4);
        int i11 = i10 & (i10 << 2);
        return (i11 & (i11 + i11)) >> 7;
    }

    private static void zzk(zzhde zzhdeVar, int i2, byte b8) {
        zzhde[][] zzhdeVarArr = zzhdl.zzd;
        int i8 = (b8 & 255) >> 7;
        int i9 = (-i8) & b8;
        int i10 = b8 - (i9 + i9);
        zzhdeVar.zzb(zzhdeVarArr[i2][0], zzj(i10, 1));
        zzhdeVar.zzb(zzhdeVarArr[i2][1], zzj(i10, 2));
        zzhdeVar.zzb(zzhdeVarArr[i2][2], zzj(i10, 3));
        zzhdeVar.zzb(zzhdeVarArr[i2][3], zzj(i10, 4));
        zzhdeVar.zzb(zzhdeVarArr[i2][4], zzj(i10, 5));
        zzhdeVar.zzb(zzhdeVarArr[i2][5], zzj(i10, 6));
        zzhdeVar.zzb(zzhdeVarArr[i2][6], zzj(i10, 7));
        zzhdeVar.zzb(zzhdeVarArr[i2][7], zzj(i10, 8));
        long[] jArr = zzhdeVar.zzc;
        long[] jArr2 = zzhdeVar.zza;
        long[] jArrCopyOf = Arrays.copyOf(zzhdeVar.zzb, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(jArr, 10);
        zzm(jArrCopyOf3, jArrCopyOf3);
        zzhdeVar.zzb(new zzhde(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i8);
    }

    private static byte[] zzl(byte[] bArr) {
        int i2;
        byte[] bArr2 = new byte[256];
        for (int i8 = 0; i8 < 256; i8++) {
            bArr2[i8] = (byte) (1 & ((bArr[i8 >> 3] & 255) >> (i8 & 7)));
        }
        for (int i9 = 0; i9 < 256; i9++) {
            if (bArr2[i9] != 0) {
                for (int i10 = 1; i10 <= 6 && (i2 = i9 + i10) < 256; i10++) {
                    byte b8 = bArr2[i2];
                    if (b8 != 0) {
                        byte b9 = bArr2[i9];
                        int i11 = b8 << i10;
                        int i12 = b9 + i11;
                        if (i12 <= 15) {
                            bArr2[i9] = (byte) i12;
                            bArr2[i2] = 0;
                        } else {
                            int i13 = b9 - i11;
                            if (i13 >= -15) {
                                bArr2[i9] = (byte) i13;
                                while (true) {
                                    if (i2 >= 256) {
                                        break;
                                    }
                                    if (bArr2[i2] == 0) {
                                        bArr2[i2] = 1;
                                        break;
                                    }
                                    bArr2[i2] = 0;
                                    i2++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void zzm(long[] jArr, long[] jArr2) {
        for (int i2 = 0; i2 < jArr2.length; i2++) {
            jArr[i2] = -jArr2[i2];
        }
    }

    private static long zzn(byte[] bArr, int i2) {
        return (((long) (bArr[i2 + 2] & 255)) << 16) | (bArr[i2] & 255) | (((long) (bArr[i2 + 1] & 255)) << 8);
    }

    private static long zzo(byte[] bArr, int i2) {
        return (((long) (bArr[i2 + 3] & 255)) << 24) | zzn(bArr, i2);
    }
}
