package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhux {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i2, zzhuw zzhuwVar) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        if (b8 < 0) {
            return zzb(b8, bArr, i8, zzhuwVar);
        }
        zzhuwVar.zza = b8;
        return i8;
    }

    public static int zzb(int i2, byte[] bArr, int i8, zzhuw zzhuwVar) {
        byte b8 = bArr[i8];
        int i9 = i8 + 1;
        int i10 = i2 & 127;
        if (b8 >= 0) {
            zzhuwVar.zza = i10 | (b8 << 7);
            return i9;
        }
        int i11 = i10 | ((b8 & 127) << 7);
        int i12 = i8 + 2;
        byte b9 = bArr[i9];
        if (b9 >= 0) {
            zzhuwVar.zza = i11 | (b9 << 14);
            return i12;
        }
        int i13 = i11 | ((b9 & 127) << 14);
        int i14 = i8 + 3;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            zzhuwVar.zza = i13 | (b10 << 21);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 21);
        int i16 = i8 + 4;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            zzhuwVar.zza = i15 | (b11 << 28);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 28);
        while (true) {
            int i18 = i16 + 1;
            if (bArr[i16] >= 0) {
                zzhuwVar.zza = i17;
                return i18;
            }
            i16 = i18;
        }
    }

    public static int zzc(byte[] bArr, int i2, zzhuw zzhuwVar) {
        long j = bArr[i2];
        int i8 = i2 + 1;
        if (j >= 0) {
            zzhuwVar.zzb = j;
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
        zzhuwVar.zzb = j3;
        return i9;
    }

    public static int zzd(byte[] bArr, int i2) {
        int i8 = bArr[i2] & 255;
        int i9 = bArr[i2 + 1] & 255;
        int i10 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i9 << 8) | i8 | (i10 << 16);
    }

    public static long zze(byte[] bArr, int i2) {
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | ((((long) bArr[i2 + 7]) & 255) << 56);
    }

    public static int zzf(byte[] bArr, int i2, zzhuw zzhuwVar) throws zzhxd {
        int iZza = zza(bArr, i2, zzhuwVar);
        int i8 = zzhuwVar.zza;
        if (i8 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i8 == 0) {
            zzhuwVar.zzc = "";
            return iZza;
        }
        zzhuwVar.zzc = zzhzo.zzf(bArr, iZza, i8);
        return iZza + i8;
    }

    public static int zzg(byte[] bArr, int i2, zzhuw zzhuwVar) throws zzhxd {
        int iZza = zza(bArr, i2, zzhuwVar);
        int i8 = zzhuwVar.zza;
        if (i8 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i8 > bArr.length - iZza) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i8 == 0) {
            zzhuwVar.zzc = zzhvi.zzb;
            return iZza;
        }
        zzhuwVar.zzc = zzhvi.zzr(bArr, iZza, i8);
        return iZza + i8;
    }

    public static int zzh(zzhyr zzhyrVar, byte[] bArr, int i2, int i8, zzhuw zzhuwVar) throws IOException {
        Object objZza = zzhyrVar.zza();
        int iZzj = zzj(objZza, zzhyrVar, bArr, i2, i8, zzhuwVar);
        zzhyrVar.zzk(objZza);
        zzhuwVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(zzhyr zzhyrVar, byte[] bArr, int i2, int i8, int i9, zzhuw zzhuwVar) throws IOException {
        Object objZza = zzhyrVar.zza();
        int iZzk = zzk(objZza, zzhyrVar, bArr, i2, i8, i9, zzhuwVar);
        zzhyrVar.zzk(objZza);
        zzhuwVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(Object obj, zzhyr zzhyrVar, byte[] bArr, int i2, int i8, zzhuw zzhuwVar) throws IOException {
        int iZzb = i2 + 1;
        int i9 = bArr[i2];
        if (i9 < 0) {
            iZzb = zzb(i9, bArr, iZzb, zzhuwVar);
            i9 = zzhuwVar.zza;
        }
        int i10 = iZzb;
        if (i9 < 0 || i9 > i8 - i10) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i11 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i11;
        zzq(i11);
        int i12 = i10 + i9;
        zzhyrVar.zzj(obj, bArr, i10, i12, zzhuwVar);
        zzhuwVar.zze--;
        zzhuwVar.zzc = obj;
        return i12;
    }

    public static int zzk(Object obj, zzhyr zzhyrVar, byte[] bArr, int i2, int i8, int i9, zzhuw zzhuwVar) throws IOException {
        int i10 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i10;
        zzq(i10);
        int iZzi = ((zzhyc) zzhyrVar).zzi(obj, bArr, i2, i8, i9, zzhuwVar);
        zzhuwVar.zze--;
        zzhuwVar.zzc = obj;
        return iZzi;
    }

    public static int zzl(int i2, byte[] bArr, int i8, int i9, zzhxa zzhxaVar, zzhuw zzhuwVar) {
        zzhwp zzhwpVar = (zzhwp) zzhxaVar;
        int iZza = zza(bArr, i8, zzhuwVar);
        zzhwpVar.zzi(zzhuwVar.zza);
        while (iZza < i9) {
            int iZza2 = zza(bArr, iZza, zzhuwVar);
            if (i2 != zzhuwVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzhuwVar);
            zzhwpVar.zzi(zzhuwVar.zza);
        }
        return iZza;
    }

    public static int zzm(byte[] bArr, int i2, zzhxa zzhxaVar, zzhuw zzhuwVar) throws IOException {
        zzhwp zzhwpVar = (zzhwp) zzhxaVar;
        int iZza = zza(bArr, i2, zzhuwVar);
        int i8 = zzhuwVar.zza + iZza;
        while (iZza < i8) {
            iZza = zza(bArr, iZza, zzhuwVar);
            zzhwpVar.zzi(zzhuwVar.zza);
        }
        if (iZza == i8) {
            return iZza;
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzn(zzhyr zzhyrVar, int i2, byte[] bArr, int i8, int i9, zzhxa zzhxaVar, zzhuw zzhuwVar) throws IOException {
        int iZzh = zzh(zzhyrVar, bArr, i8, i9, zzhuwVar);
        zzhxaVar.add(zzhuwVar.zzc);
        while (iZzh < i9) {
            int iZza = zza(bArr, iZzh, zzhuwVar);
            if (i2 != zzhuwVar.zza) {
                break;
            }
            iZzh = zzh(zzhyrVar, bArr, iZza, i9, zzhuwVar);
            zzhxaVar.add(zzhuwVar.zzc);
        }
        return iZzh;
    }

    public static int zzo(int i2, byte[] bArr, int i8, int i9, zzhzd zzhzdVar, zzhuw zzhuwVar) throws zzhxd {
        if ((i2 >>> 3) == 0) {
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            int iZzc = zzc(bArr, i8, zzhuwVar);
            zzhzdVar.zzk(i2, Long.valueOf(zzhuwVar.zzb));
            return iZzc;
        }
        if (i10 == 1) {
            zzhzdVar.zzk(i2, Long.valueOf(zze(bArr, i8)));
            return i8 + 8;
        }
        if (i10 == 2) {
            int iZza = zza(bArr, i8, zzhuwVar);
            int i11 = zzhuwVar.zza;
            if (i11 < 0) {
                throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i11 > bArr.length - iZza) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i11 == 0) {
                zzhzdVar.zzk(i2, zzhvi.zzb);
            } else {
                zzhzdVar.zzk(i2, zzhvi.zzr(bArr, iZza, i11));
            }
            return iZza + i11;
        }
        if (i10 != 3) {
            if (i10 != 5) {
                throw new zzhxd("Protocol message contained an invalid tag (zero).");
            }
            zzhzdVar.zzk(i2, Integer.valueOf(zzd(bArr, i8)));
            return i8 + 4;
        }
        int i12 = (i2 & (-8)) | 4;
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        int i13 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i13;
        zzq(i13);
        int i14 = 0;
        while (true) {
            if (i8 >= i9) {
                break;
            }
            int iZza2 = zza(bArr, i8, zzhuwVar);
            int i15 = zzhuwVar.zza;
            if (i15 == i12) {
                i14 = i15;
                i8 = iZza2;
                break;
            }
            i8 = zzo(i15, bArr, iZza2, i9, zzhzdVarZzb, zzhuwVar);
            i14 = i15;
        }
        zzhuwVar.zze--;
        if (i8 > i9 || i14 != i12) {
            throw new zzhxd("Failed to parse the message.");
        }
        zzhzdVar.zzk(i2, zzhzdVarZzb);
        return i8;
    }

    public static int zzp(int i2, byte[] bArr, int i8, int i9, zzhuw zzhuwVar) throws zzhxd {
        if ((i2 >>> 3) == 0) {
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            return zzc(bArr, i8, zzhuwVar);
        }
        if (i10 == 1) {
            return i8 + 8;
        }
        if (i10 == 2) {
            return zza(bArr, i8, zzhuwVar) + zzhuwVar.zza;
        }
        if (i10 != 3) {
            if (i10 == 5) {
                return i8 + 4;
            }
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i11 = (i2 & (-8)) | 4;
        int i12 = 0;
        while (i8 < i9) {
            i8 = zza(bArr, i8, zzhuwVar);
            i12 = zzhuwVar.zza;
            if (i12 == i11) {
                break;
            }
            i8 = zzp(i12, bArr, i8, i9, zzhuwVar);
        }
        if (i8 > i9 || i12 != i11) {
            throw new zzhxd("Failed to parse the message.");
        }
        return i8;
    }

    private static void zzq(int i2) throws zzhxd {
        if (i2 >= zzb) {
            throw new zzhxd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
