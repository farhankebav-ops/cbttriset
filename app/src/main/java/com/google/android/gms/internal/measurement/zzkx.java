package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i2, zzkw zzkwVar) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        if (b8 < 0) {
            return zzb(b8, bArr, i8, zzkwVar);
        }
        zzkwVar.zza = b8;
        return i8;
    }

    public static int zzb(int i2, byte[] bArr, int i8, zzkw zzkwVar) {
        byte b8 = bArr[i8];
        int i9 = i8 + 1;
        int i10 = i2 & 127;
        if (b8 >= 0) {
            zzkwVar.zza = i10 | (b8 << 7);
            return i9;
        }
        int i11 = i10 | ((b8 & 127) << 7);
        int i12 = i8 + 2;
        byte b9 = bArr[i9];
        if (b9 >= 0) {
            zzkwVar.zza = i11 | (b9 << 14);
            return i12;
        }
        int i13 = i11 | ((b9 & 127) << 14);
        int i14 = i8 + 3;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            zzkwVar.zza = i13 | (b10 << 21);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 21);
        int i16 = i8 + 4;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            zzkwVar.zza = i15 | (b11 << 28);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 28);
        while (true) {
            int i18 = i16 + 1;
            if (bArr[i16] >= 0) {
                zzkwVar.zza = i17;
                return i18;
            }
            i16 = i18;
        }
    }

    public static int zzc(byte[] bArr, int i2, zzkw zzkwVar) {
        long j = bArr[i2];
        int i8 = i2 + 1;
        if (j >= 0) {
            zzkwVar.zzb = j;
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
        zzkwVar.zzb = j3;
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

    public static int zzf(byte[] bArr, int i2, zzkw zzkwVar) throws zzmr {
        int i8;
        int iZza = zza(bArr, i2, zzkwVar);
        int i9 = zzkwVar.zza;
        if (i9 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i9 == 0) {
            zzkwVar.zzc = "";
            return iZza;
        }
        int i10 = zzos.zza;
        int length = bArr.length;
        if ((((length - iZza) - i9) | iZza | i9) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZza), Integer.valueOf(i9)));
        }
        int i11 = iZza + i9;
        char[] cArr = new char[i9];
        int i12 = 0;
        while (iZza < i11) {
            byte b8 = bArr[iZza];
            if (!zzoq.zza(b8)) {
                break;
            }
            iZza++;
            cArr[i12] = (char) b8;
            i12++;
        }
        int i13 = i12;
        while (iZza < i11) {
            int i14 = iZza + 1;
            byte b9 = bArr[iZza];
            if (zzoq.zza(b9)) {
                cArr[i13] = (char) b9;
                i13++;
                iZza = i14;
                while (iZza < i11) {
                    byte b10 = bArr[iZza];
                    if (zzoq.zza(b10)) {
                        iZza++;
                        cArr[i13] = (char) b10;
                        i13++;
                    }
                }
            } else {
                if (b9 < -32) {
                    if (i14 >= i11) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i8 = i13 + 1;
                    iZza += 2;
                    zzoq.zzb(b9, bArr[i14], cArr, i13);
                } else if (b9 < -16) {
                    if (i14 >= i11 - 1) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    i8 = i13 + 1;
                    int i15 = iZza + 2;
                    iZza += 3;
                    zzoq.zzc(b9, bArr[i14], bArr[i15], cArr, i13);
                } else {
                    if (i14 >= i11 - 2) {
                        throw new zzmr("Protocol message had invalid UTF-8.");
                    }
                    byte b11 = bArr[i14];
                    int i16 = iZza + 3;
                    byte b12 = bArr[iZza + 2];
                    iZza += 4;
                    zzoq.zzd(b9, b11, b12, bArr[i16], cArr, i13);
                    i13 += 2;
                }
                i13 = i8;
            }
        }
        zzkwVar.zzc = new String(cArr, 0, i13);
        return i11;
    }

    public static int zzg(byte[] bArr, int i2, zzkw zzkwVar) throws zzmr {
        int iZza = zza(bArr, i2, zzkwVar);
        int i8 = zzkwVar.zza;
        if (i8 < 0) {
            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i8 > bArr.length - iZza) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i8 == 0) {
            zzkwVar.zzc = zzlh.zzb;
            return iZza;
        }
        zzkwVar.zzc = zzlh.zzh(bArr, iZza, i8);
        return iZza + i8;
    }

    public static int zzh(zznx zznxVar, byte[] bArr, int i2, int i8, zzkw zzkwVar) throws IOException {
        Object objZza = zznxVar.zza();
        int iZzj = zzj(objZza, zznxVar, bArr, i2, i8, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzj;
    }

    public static int zzi(zznx zznxVar, byte[] bArr, int i2, int i8, int i9, zzkw zzkwVar) throws IOException {
        Object objZza = zznxVar.zza();
        int iZzk = zzk(objZza, zznxVar, bArr, i2, i8, i9, zzkwVar);
        zznxVar.zzj(objZza);
        zzkwVar.zzc = objZza;
        return iZzk;
    }

    public static int zzj(Object obj, zznx zznxVar, byte[] bArr, int i2, int i8, zzkw zzkwVar) throws IOException {
        int iZzb = i2 + 1;
        int i9 = bArr[i2];
        if (i9 < 0) {
            iZzb = zzb(i9, bArr, iZzb, zzkwVar);
            i9 = zzkwVar.zza;
        }
        int i10 = iZzb;
        if (i9 < 0 || i9 > i8 - i10) {
            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i11 = zzkwVar.zze + 1;
        zzkwVar.zze = i11;
        zzq(i11);
        int i12 = i10 + i9;
        zznxVar.zzi(obj, bArr, i10, i12, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return i12;
    }

    public static int zzk(Object obj, zznx zznxVar, byte[] bArr, int i2, int i8, int i9, zzkw zzkwVar) throws IOException {
        int i10 = zzkwVar.zze + 1;
        zzkwVar.zze = i10;
        zzq(i10);
        int iZzh = ((zznp) zznxVar).zzh(obj, bArr, i2, i8, i9, zzkwVar);
        zzkwVar.zze--;
        zzkwVar.zzc = obj;
        return iZzh;
    }

    public static int zzl(int i2, byte[] bArr, int i8, int i9, zzmo zzmoVar, zzkw zzkwVar) {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i8, zzkwVar);
        zzmgVar.zzh(zzkwVar.zza);
        while (iZza < i9) {
            int iZza2 = zza(bArr, iZza, zzkwVar);
            if (i2 != zzkwVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        return iZza;
    }

    public static int zzm(byte[] bArr, int i2, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        zzmg zzmgVar = (zzmg) zzmoVar;
        int iZza = zza(bArr, i2, zzkwVar);
        int i8 = zzkwVar.zza + iZza;
        while (iZza < i8) {
            iZza = zza(bArr, iZza, zzkwVar);
            zzmgVar.zzh(zzkwVar.zza);
        }
        if (iZza == i8) {
            return iZza;
        }
        throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzn(zznx zznxVar, int i2, byte[] bArr, int i8, int i9, zzmo zzmoVar, zzkw zzkwVar) throws IOException {
        int iZzh = zzh(zznxVar, bArr, i8, i9, zzkwVar);
        zzmoVar.add(zzkwVar.zzc);
        while (iZzh < i9) {
            int iZza = zza(bArr, iZzh, zzkwVar);
            if (i2 != zzkwVar.zza) {
                break;
            }
            iZzh = zzh(zznxVar, bArr, iZza, i9, zzkwVar);
            zzmoVar.add(zzkwVar.zzc);
        }
        return iZzh;
    }

    public static int zzo(int i2, byte[] bArr, int i8, int i9, zzoj zzojVar, zzkw zzkwVar) throws zzmr {
        if ((i2 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            int iZzc = zzc(bArr, i8, zzkwVar);
            zzojVar.zzk(i2, Long.valueOf(zzkwVar.zzb));
            return iZzc;
        }
        if (i10 == 1) {
            zzojVar.zzk(i2, Long.valueOf(zze(bArr, i8)));
            return i8 + 8;
        }
        if (i10 == 2) {
            int iZza = zza(bArr, i8, zzkwVar);
            int i11 = zzkwVar.zza;
            if (i11 < 0) {
                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i11 > bArr.length - iZza) {
                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i11 == 0) {
                zzojVar.zzk(i2, zzlh.zzb);
            } else {
                zzojVar.zzk(i2, zzlh.zzh(bArr, iZza, i11));
            }
            return iZza + i11;
        }
        if (i10 != 3) {
            if (i10 != 5) {
                throw new zzmr("Protocol message contained an invalid tag (zero).");
            }
            zzojVar.zzk(i2, Integer.valueOf(zzd(bArr, i8)));
            return i8 + 4;
        }
        int i12 = (i2 & (-8)) | 4;
        zzoj zzojVarZzb = zzoj.zzb();
        int i13 = zzkwVar.zze + 1;
        zzkwVar.zze = i13;
        zzq(i13);
        int i14 = 0;
        while (true) {
            if (i8 >= i9) {
                break;
            }
            int iZza2 = zza(bArr, i8, zzkwVar);
            int i15 = zzkwVar.zza;
            if (i15 == i12) {
                i14 = i15;
                i8 = iZza2;
                break;
            }
            i8 = zzo(i15, bArr, iZza2, i9, zzojVarZzb, zzkwVar);
            i14 = i15;
        }
        zzkwVar.zze--;
        if (i8 > i9 || i14 != i12) {
            throw new zzmr("Failed to parse the message.");
        }
        zzojVar.zzk(i2, zzojVarZzb);
        return i8;
    }

    public static int zzp(int i2, byte[] bArr, int i8, int i9, zzkw zzkwVar) throws zzmr {
        if ((i2 >>> 3) == 0) {
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i10 = i2 & 7;
        if (i10 == 0) {
            return zzc(bArr, i8, zzkwVar);
        }
        if (i10 == 1) {
            return i8 + 8;
        }
        if (i10 == 2) {
            return zza(bArr, i8, zzkwVar) + zzkwVar.zza;
        }
        if (i10 != 3) {
            if (i10 == 5) {
                return i8 + 4;
            }
            throw new zzmr("Protocol message contained an invalid tag (zero).");
        }
        int i11 = (i2 & (-8)) | 4;
        int i12 = 0;
        while (i8 < i9) {
            i8 = zza(bArr, i8, zzkwVar);
            i12 = zzkwVar.zza;
            if (i12 == i11) {
                break;
            }
            i8 = zzp(i12, bArr, i8, i9, zzkwVar);
        }
        if (i8 > i9 || i12 != i11) {
            throw new zzmr("Failed to parse the message.");
        }
        return i8;
    }

    private static void zzq(int i2) throws zzmr {
        if (i2 >= zzb) {
            throw new zzmr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
