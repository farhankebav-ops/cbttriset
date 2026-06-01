package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaje {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    @Nullable
    public static zzaeh zza(zzadb zzadbVar) throws IOException {
        return zzc(zzadbVar, true, false);
    }

    @Nullable
    public static zzaeh zzb(zzadb zzadbVar, boolean z2) throws IOException {
        return zzc(zzadbVar, false, z2);
    }

    @Nullable
    private static zzaeh zzc(zzadb zzadbVar, boolean z2, boolean z7) throws IOException {
        zzaeh zzaehVar;
        long j;
        zzeg zzegVar;
        int i2;
        int i8;
        long j3;
        int i9;
        int i10;
        int[] iArr;
        long jZzo = zzadbVar.zzo();
        long j8 = -1;
        long j9 = 4096;
        if (jZzo != -1 && jZzo <= 4096) {
            j9 = jZzo;
        }
        zzeg zzegVar2 = new zzeg(64);
        int i11 = (int) j9;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            zzegVar2.zza(8);
            if (!zzadbVar.zzh(zzegVar2.zzi(), i12, 8, true)) {
                break;
            }
            long jZzz = zzegVar2.zzz();
            int iZzB = zzegVar2.zzB();
            if (jZzz == 1) {
                j = j8;
                zzadbVar.zzi(zzegVar2.zzi(), 8, 8);
                i2 = 16;
                zzegVar2.zzf(16);
                jZzz = zzegVar2.zzD();
                zzegVar = zzegVar2;
            } else {
                j = j8;
                if (jZzz == 0) {
                    long jZzo2 = zzadbVar.zzo();
                    if (jZzo2 != j) {
                        jZzz = (jZzo2 - zzadbVar.zzm()) + 8;
                    }
                }
                zzegVar = zzegVar2;
                i2 = 8;
            }
            long j10 = jZzz;
            zzaehVar = null;
            long j11 = i2;
            if (j10 < j11) {
                i8 = 1;
                if (iZzB == 1718773093) {
                    if (i2 == 8) {
                        j10 = 8;
                        iZzB = 1718773093;
                    } else {
                        iZzB = 1718773093;
                    }
                }
                return new zzahy(iZzB, j10, i2);
            }
            i8 = 1;
            i13 += i2;
            if (iZzB == 1836019574) {
                i11 += (int) j10;
                if (jZzo != -1 && i11 > jZzo) {
                    i11 = (int) jZzo;
                }
                zzegVar2 = zzegVar;
                j8 = j;
                i12 = 0;
            } else {
                if (iZzB == 1953653099 || iZzB == 1835297121 || iZzB == 1835626086) {
                    j3 = jZzo;
                    i9 = 0;
                } else {
                    if (iZzB == 1836019558 || iZzB == 1836475768) {
                        i12 = i8;
                        break;
                    }
                    i14 |= (iZzB == 1835295092 ? 0 : i8) ^ 1;
                    if (iZzB == 1937007212) {
                        if (j10 > 1000000) {
                            i12 = 0;
                            break;
                        }
                        iZzB = 1937007212;
                    }
                    j3 = jZzo;
                    if ((((long) i13) + j10) - j11 >= i11) {
                        i12 = 0;
                        break;
                    }
                    int i15 = (int) (j10 - j11);
                    i13 += i15;
                    if (iZzB != 1718909296) {
                        i9 = 0;
                        if (i15 != 0) {
                            zzadbVar.zzk(i15);
                        }
                    } else {
                        if (i15 < 8) {
                            return new zzahy(1718909296, i15, 8);
                        }
                        zzegVar.zza(i15);
                        i9 = 0;
                        zzadbVar.zzi(zzegVar.zzi(), 0, i15);
                        int iZzB2 = zzegVar.zzB();
                        int i16 = (zzd(iZzB2, z7) ? 1 : 0) | i14;
                        zzegVar.zzk(4);
                        int iZzd = zzegVar.zzd() / 4;
                        if (i16 == 0 && iZzd > 0) {
                            iArr = new int[iZzd];
                            int i17 = 0;
                            while (true) {
                                if (i17 >= iZzd) {
                                    i10 = i16;
                                    break;
                                }
                                int iZzB3 = zzegVar.zzB();
                                iArr[i17] = iZzB3;
                                if (zzd(iZzB3, z7)) {
                                    i10 = i8;
                                    break;
                                }
                                i17++;
                            }
                        } else {
                            i10 = i16;
                            iArr = null;
                        }
                        if (i10 == 0) {
                            return new zzajj(iZzB2, iArr);
                        }
                        i14 = i10;
                    }
                }
                i12 = i9;
                zzegVar2 = zzegVar;
                jZzo = j3;
                j8 = j;
            }
        }
        zzaehVar = null;
        return i14 == 0 ? zzaja.zza : z2 != i12 ? i12 != 0 ? zzais.zza : zzais.zzb : zzaehVar;
    }

    private static boolean zzd(int i2, boolean z2) {
        if ((i2 >>> 8) == 3368816) {
            return true;
        }
        if (i2 == 1751476579) {
            if (z2) {
                return true;
            }
            i2 = 1751476579;
        }
        int[] iArr = zza;
        for (int i8 = 0; i8 < 29; i8++) {
            if (iArr[i8] == i2) {
                return true;
            }
        }
        return false;
    }
}
