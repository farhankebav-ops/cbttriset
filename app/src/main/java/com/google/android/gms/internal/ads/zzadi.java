package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadi {
    public static boolean zza(zzeg zzegVar, zzadn zzadnVar, int i2, zzadh zzadhVar) {
        int iZzg = zzegVar.zzg();
        long jZzz = zzegVar.zzz();
        long j = jZzz >>> 16;
        if (j != i2) {
            return false;
        }
        boolean z2 = (j & 1) == 1;
        long j3 = jZzz >> 12;
        long j8 = jZzz >> 8;
        long j9 = jZzz >> 4;
        long j10 = jZzz >> 1;
        long j11 = jZzz & 1;
        int i8 = (int) (j9 & 15);
        if (i8 <= 7) {
            if (i8 != zzadnVar.zzg - 1) {
                return false;
            }
        } else if (i8 > 10 || zzadnVar.zzg != 2) {
            return false;
        }
        int i9 = (int) (j10 & 7);
        if ((i9 != 0 && i9 != zzadnVar.zzi) || j11 == 1 || !zzd(zzegVar, zzadnVar, z2, zzadhVar)) {
            return false;
        }
        long j12 = zzadhVar.zza;
        int iZzc = zzc(zzegVar, (int) (j3 & 15));
        long j13 = zzadnVar.zzj;
        boolean z7 = j13 == 0 || j12 + ((long) iZzc) >= j13;
        if (iZzc == -1) {
            return false;
        }
        if ((!z7 && iZzc < zzadnVar.zza) || iZzc > zzadnVar.zzb) {
            return false;
        }
        int i10 = zzadnVar.zze;
        int i11 = (int) (j8 & 15);
        if (i11 != 0) {
            if (i11 <= 11) {
                if (i11 != zzadnVar.zzf) {
                    return false;
                }
            } else if (i11 == 12) {
                if (zzegVar.zzs() * 1000 != i10) {
                    return false;
                }
            } else {
                if (i11 > 14) {
                    return false;
                }
                int iZzt = zzegVar.zzt();
                if (i11 == 14) {
                    iZzt *= 10;
                }
                if (iZzt != i10) {
                    return false;
                }
            }
        }
        if (zzegVar.zzs() != zzep.zzJ(zzegVar.zzi(), iZzg, zzegVar.zzg() - 1, 0)) {
            return false;
        }
        if (zzegVar.zzd() != 0) {
            int iZzn = zzegVar.zzn();
            if ((iZzn & 128) != 0) {
                return false;
            }
            int i12 = (iZzn & 126) >> 1;
            if ((i12 >= 2 && i12 <= 7) || (i12 >= 13 && i12 <= 31)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 57);
                sb.append("Ignoring frame where first subframe has a reserved type: ");
                sb.append(i12);
                zzdt.zzb("FlacFrameReader", sb.toString());
                return false;
            }
        }
        return true;
    }

    public static long zzb(zzadb zzadbVar, zzadn zzadnVar) throws IOException {
        zzadbVar.zzl();
        zzadbVar.zzk(1);
        byte[] bArr = new byte[1];
        zzadbVar.zzi(bArr, 0, 1);
        int i2 = bArr[0] & 1;
        boolean z2 = 1 == i2;
        zzadbVar.zzk(2);
        int i8 = 1 != i2 ? 6 : 7;
        zzeg zzegVar = new zzeg(i8);
        zzegVar.zzf(zzade.zzb(zzadbVar, zzegVar.zzi(), 0, i8));
        zzadbVar.zzl();
        zzadh zzadhVar = new zzadh();
        if (zzd(zzegVar, zzadnVar, z2, zzadhVar)) {
            return zzadhVar.zza;
        }
        throw zzat.zzb(null, null);
    }

    public static int zzc(zzeg zzegVar, int i2) {
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return zzegVar.zzs() + 1;
            case 7:
                return zzegVar.zzt() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }

    private static boolean zzd(zzeg zzegVar, zzadn zzadnVar, boolean z2, zzadh zzadhVar) {
        try {
            long jZzO = zzegVar.zzO();
            if (!z2) {
                jZzO *= (long) zzadnVar.zzb;
            }
            long j = zzadnVar.zzj;
            if (j != 0 && jZzO > j) {
                return false;
            }
            zzadhVar.zza = jZzO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
