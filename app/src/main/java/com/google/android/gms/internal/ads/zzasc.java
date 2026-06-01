package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzasc {
    public static zzatc zza(final long j) {
        return zzatc.zzf(new zzasu() { // from class: com.google.android.gms.internal.ads.zzasb
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                try {
                    ((zzasx) obj).zzb.zzb(zzatc.zzb(j));
                    return Optional.empty();
                } catch (zzass unused) {
                    return Optional.of(zzarm.zza);
                }
            }
        });
    }

    public static int zzb(long j, zzatb zzatbVar, boolean z2) throws IOException {
        long[] jArr = {2000490107, 1476547902, 1834034217, 268849430, 1839467528, 4368198174L, 449620248, 1652701270, 1629190168};
        long j3 = jArr[0];
        long j8 = jArr[1];
        long j9 = jArr[2];
        long j10 = jArr[3];
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = (((((~j3) & j8) | j9) + ((j3 & j10) | j11)) - j12) + j13;
        long j16 = j14 % 1629190168;
        int i2 = ((((~1725868784) & 388366538) | 739792167) + ((1725868784 & 1395525853) | 1087913783)) - 2073845026;
        int i8 = 1550046828 % 184366026;
        int i9 = ((((~84870791) & 719462960) | 688752780) + ((84870791 & 317383283) | 806209731)) - 1437974767;
        int i10 = 2023762697 % 959200313;
        int i11 = ((((~294151249) & 1465191424) | 201912514) + ((294151249 & 1398095366) | 75641662)) - 1330100008;
        int i12 = 1583887958 % 619175679;
        long j17 = z2 ? (j >> ((((((~1375552878) & 930005102) | 1249030018) + ((1375552878 & 1024213116) | 136481682)) - 2090967727) ^ (2014126950 % 228698447))) ^ (j + j) : j;
        int i13 = 1;
        while (true) {
            long j18 = j15 ^ j16;
            long j19 = j17 >>> (i9 ^ i10);
            boolean z7 = j19 != 0 || i13 < 0;
            int i14 = (int) (j17 & j18);
            if (z7) {
                int i15 = i2 ^ i8;
                i14 = ((i14 | (i11 ^ i12)) << i15) >> i15;
            }
            zzatbVar.zza((byte) i14);
            if (!z7) {
                return i13;
            }
            i13++;
            j17 = j19;
        }
    }
}
