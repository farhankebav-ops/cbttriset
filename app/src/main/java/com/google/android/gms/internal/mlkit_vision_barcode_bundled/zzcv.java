package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcv {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i2, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i2, zzcuVar);
        int i8 = zzcuVar.zza;
        if (i8 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i8 > bArr.length - iZzj) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i8 == 0) {
            zzcuVar.zzc = zzdf.zzb;
            return iZzj;
        }
        zzcuVar.zzc = zzdf.zzr(bArr, iZzj, i8);
        return iZzj + i8;
    }

    public static int zzb(int i2, byte[] bArr, int i8, int i9, zzed zzedVar, zzef zzefVar, zzgs zzgsVar, zzcu zzcuVar) throws IOException {
        zzdx zzdxVar = zzedVar.zzb;
        zzhf zzhfVar = zzefVar.zzb.zzb;
        Object objValueOf = null;
        if (zzhfVar == zzhf.zzn) {
            zzj(bArr, i8, zzcuVar);
            throw null;
        }
        switch (zzhfVar.ordinal()) {
            case 0:
                i8 += 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(zzq(bArr, i8)));
                break;
            case 1:
                i8 += 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(zzc(bArr, i8)));
                break;
            case 2:
            case 3:
                i8 = zzm(bArr, i8, zzcuVar);
                objValueOf = Long.valueOf(zzcuVar.zzb);
                break;
            case 4:
            case 12:
                i8 = zzj(bArr, i8, zzcuVar);
                objValueOf = Integer.valueOf(zzcuVar.zza);
                break;
            case 5:
            case 15:
                i8 += 8;
                objValueOf = Long.valueOf(zzq(bArr, i8));
                break;
            case 6:
            case 14:
                i8 += 4;
                objValueOf = Integer.valueOf(zzc(bArr, i8));
                break;
            case 7:
                i8 = zzm(bArr, i8, zzcuVar);
                objValueOf = Boolean.valueOf(zzcuVar.zzb != 0);
                break;
            case 8:
                i8 = zzh(bArr, i8, zzcuVar);
                objValueOf = zzcuVar.zzc;
                break;
            case 9:
                int i10 = ((i2 >>> 3) << 3) | 4;
                zzge zzgeVarZzb = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze = zzdxVar.zze(zzefVar.zzb);
                if (objZze == null) {
                    objZze = zzgeVarZzb.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze);
                }
                return zzn(objZze, zzgeVarZzb, bArr, i8, i9, i10, zzcuVar);
            case 10:
                zzge zzgeVarZzb2 = zzfu.zza().zzb(zzefVar.zza.getClass());
                Object objZze2 = zzdxVar.zze(zzefVar.zzb);
                if (objZze2 == null) {
                    objZze2 = zzgeVarZzb2.zze();
                    zzdxVar.zzi(zzefVar.zzb, objZze2);
                }
                return zzo(objZze2, zzgeVarZzb2, bArr, i8, i9, zzcuVar);
            case 11:
                i8 = zza(bArr, i8, zzcuVar);
                objValueOf = zzcuVar.zzc;
                break;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i8 = zzj(bArr, i8, zzcuVar);
                objValueOf = Integer.valueOf(zzdj.zzb(zzcuVar.zza));
                break;
            case 17:
                i8 = zzm(bArr, i8, zzcuVar);
                objValueOf = Long.valueOf(zzdj.zzc(zzcuVar.zzb));
                break;
        }
        zzdxVar.zzi(zzefVar.zzb, objValueOf);
        return i8;
    }

    public static int zzc(byte[] bArr, int i2) {
        int i8 = bArr[i2] & 255;
        int i9 = bArr[i2 + 1] & 255;
        int i10 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i9 << 8) | i8 | (i10 << 16);
    }

    public static int zzd(zzge zzgeVar, byte[] bArr, int i2, int i8, int i9, zzcu zzcuVar) throws IOException {
        Object objZze = zzgeVar.zze();
        int iZzn = zzn(objZze, zzgeVar, bArr, i2, i8, i9, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzn;
    }

    public static int zze(zzge zzgeVar, byte[] bArr, int i2, int i8, zzcu zzcuVar) throws IOException {
        Object objZze = zzgeVar.zze();
        int iZzo = zzo(objZze, zzgeVar, bArr, i2, i8, zzcuVar);
        zzgeVar.zzf(objZze);
        zzcuVar.zzc = objZze;
        return iZzo;
    }

    public static int zzf(zzge zzgeVar, int i2, byte[] bArr, int i8, int i9, zzeo zzeoVar, zzcu zzcuVar) throws IOException {
        int iZze = zze(zzgeVar, bArr, i8, i9, zzcuVar);
        zzeoVar.add(zzcuVar.zzc);
        while (iZze < i9) {
            int iZzj = zzj(bArr, iZze, zzcuVar);
            if (i2 != zzcuVar.zza) {
                break;
            }
            iZze = zze(zzgeVar, bArr, iZzj, i9, zzcuVar);
            zzeoVar.add(zzcuVar.zzc);
        }
        return iZze;
    }

    public static int zzg(byte[] bArr, int i2, zzeo zzeoVar, zzcu zzcuVar) throws IOException {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i2, zzcuVar);
        int i8 = zzcuVar.zza + iZzj;
        while (iZzj < i8) {
            iZzj = zzj(bArr, iZzj, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        if (iZzj == i8) {
            return iZzj;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzh(byte[] bArr, int i2, zzcu zzcuVar) throws zzer {
        int iZzj = zzj(bArr, i2, zzcuVar);
        int i8 = zzcuVar.zza;
        if (i8 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i8 == 0) {
            zzcuVar.zzc = "";
            return iZzj;
        }
        zzcuVar.zzc = new String(bArr, iZzj, i8, zzep.zza);
        return iZzj + i8;
    }

    public static int zzi(int i2, byte[] bArr, int i8, int i9, zzgt zzgtVar, zzcu zzcuVar) throws zzer {
        if ((i2 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            int iZzm = zzm(bArr, i8, zzcuVar);
            zzgtVar.zzj(i2, Long.valueOf(zzcuVar.zzb));
            return iZzm;
        }
        if (i10 == 1) {
            zzgtVar.zzj(i2, Long.valueOf(zzq(bArr, i8)));
            return i8 + 8;
        }
        if (i10 == 2) {
            int iZzj = zzj(bArr, i8, zzcuVar);
            int i11 = zzcuVar.zza;
            if (i11 < 0) {
                throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i11 > bArr.length - iZzj) {
                throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i11 == 0) {
                zzgtVar.zzj(i2, zzdf.zzb);
            } else {
                zzgtVar.zzj(i2, zzdf.zzr(bArr, iZzj, i11));
            }
            return iZzj + i11;
        }
        if (i10 != 3) {
            if (i10 != 5) {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
            zzgtVar.zzj(i2, Integer.valueOf(zzc(bArr, i8)));
            return i8 + 4;
        }
        int i12 = (i2 & (-8)) | 4;
        zzgt zzgtVarZzf = zzgt.zzf();
        int i13 = zzcuVar.zze + 1;
        zzcuVar.zze = i13;
        zzr(i13);
        int i14 = 0;
        while (true) {
            if (i8 >= i9) {
                break;
            }
            int iZzj2 = zzj(bArr, i8, zzcuVar);
            int i15 = zzcuVar.zza;
            if (i15 == i12) {
                i14 = i15;
                i8 = iZzj2;
                break;
            }
            i8 = zzi(i15, bArr, iZzj2, i9, zzgtVarZzf, zzcuVar);
            i14 = i15;
        }
        zzcuVar.zze--;
        if (i8 > i9 || i14 != i12) {
            throw new zzer("Failed to parse the message.");
        }
        zzgtVar.zzj(i2, zzgtVarZzf);
        return i8;
    }

    public static int zzj(byte[] bArr, int i2, zzcu zzcuVar) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        if (b8 < 0) {
            return zzk(b8, bArr, i8, zzcuVar);
        }
        zzcuVar.zza = b8;
        return i8;
    }

    public static int zzk(int i2, byte[] bArr, int i8, zzcu zzcuVar) {
        byte b8 = bArr[i8];
        int i9 = i8 + 1;
        int i10 = i2 & 127;
        if (b8 >= 0) {
            zzcuVar.zza = i10 | (b8 << 7);
            return i9;
        }
        int i11 = i10 | ((b8 & 127) << 7);
        int i12 = i8 + 2;
        byte b9 = bArr[i9];
        if (b9 >= 0) {
            zzcuVar.zza = i11 | (b9 << 14);
            return i12;
        }
        int i13 = i11 | ((b9 & 127) << 14);
        int i14 = i8 + 3;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            zzcuVar.zza = i13 | (b10 << 21);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 21);
        int i16 = i8 + 4;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            zzcuVar.zza = i15 | (b11 << 28);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 28);
        while (true) {
            int i18 = i16 + 1;
            if (bArr[i16] >= 0) {
                zzcuVar.zza = i17;
                return i18;
            }
            i16 = i18;
        }
    }

    public static int zzl(int i2, byte[] bArr, int i8, int i9, zzeo zzeoVar, zzcu zzcuVar) {
        zzei zzeiVar = (zzei) zzeoVar;
        int iZzj = zzj(bArr, i8, zzcuVar);
        zzeiVar.zzg(zzcuVar.zza);
        while (iZzj < i9) {
            int iZzj2 = zzj(bArr, iZzj, zzcuVar);
            if (i2 != zzcuVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzcuVar);
            zzeiVar.zzg(zzcuVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i2, zzcu zzcuVar) {
        long j = bArr[i2];
        int i8 = i2 + 1;
        if (j >= 0) {
            zzcuVar.zzb = j;
            return i8;
        }
        int i9 = i2 + 2;
        byte b8 = bArr[i8];
        long j3 = (j & 127) | (((long) (b8 & 127)) << 7);
        int i10 = 7;
        while (b8 < 0) {
            int i11 = i9 + 1;
            byte b9 = bArr[i9];
            i10 += 7;
            j3 |= ((long) (b9 & 127)) << i10;
            b8 = b9;
            i9 = i11;
        }
        zzcuVar.zzb = j3;
        return i9;
    }

    public static int zzn(Object obj, zzge zzgeVar, byte[] bArr, int i2, int i8, int i9, zzcu zzcuVar) throws IOException {
        int i10 = zzcuVar.zze + 1;
        zzcuVar.zze = i10;
        zzr(i10);
        int iZzc = ((zzfp) zzgeVar).zzc(obj, bArr, i2, i8, i9, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, zzge zzgeVar, byte[] bArr, int i2, int i8, zzcu zzcuVar) throws IOException {
        int iZzk = i2 + 1;
        int i9 = bArr[i2];
        if (i9 < 0) {
            iZzk = zzk(i9, bArr, iZzk, zzcuVar);
            i9 = zzcuVar.zza;
        }
        int i10 = iZzk;
        if (i9 < 0 || i9 > i8 - i10) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i11 = zzcuVar.zze + 1;
        zzcuVar.zze = i11;
        zzr(i11);
        int i12 = i10 + i9;
        zzgeVar.zzh(obj, bArr, i10, i12, zzcuVar);
        zzcuVar.zze--;
        zzcuVar.zzc = obj;
        return i12;
    }

    public static int zzp(int i2, byte[] bArr, int i8, int i9, zzcu zzcuVar) throws zzer {
        if ((i2 >>> 3) == 0) {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            return zzm(bArr, i8, zzcuVar);
        }
        if (i10 == 1) {
            return i8 + 8;
        }
        if (i10 == 2) {
            return zzj(bArr, i8, zzcuVar) + zzcuVar.zza;
        }
        if (i10 != 3) {
            if (i10 == 5) {
                return i8 + 4;
            }
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
        int i11 = (i2 & (-8)) | 4;
        int i12 = 0;
        while (i8 < i9) {
            i8 = zzj(bArr, i8, zzcuVar);
            i12 = zzcuVar.zza;
            if (i12 == i11) {
                break;
            }
            i8 = zzp(i12, bArr, i8, i9, zzcuVar);
        }
        if (i8 > i9 || i12 != i11) {
            throw new zzer("Failed to parse the message.");
        }
        return i8;
    }

    public static long zzq(byte[] bArr, int i2) {
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | ((((long) bArr[i2 + 7]) & 255) << 56);
    }

    private static void zzr(int i2) throws zzer {
        if (i2 >= zzb) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
