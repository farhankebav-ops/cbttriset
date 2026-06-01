package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhe {
    public static final /* synthetic */ int zza = 0;
    private static final zzhb zzb;

    static {
        if (zzgz.zzx() && zzgz.zzy()) {
            int i2 = zzct.zza;
        }
        zzb = new zzhc();
    }

    public static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i2, int i8) {
        int i9 = i8 - i2;
        byte b8 = bArr[i2 - 1];
        if (i9 == 0) {
            if (b8 > -12) {
                return -1;
            }
            return b8;
        }
        if (i9 == 1) {
            return zzh(b8, bArr[i2]);
        }
        if (i9 == 2) {
            return zzi(b8, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static int zzd(String str, byte[] bArr, int i2, int i8) {
        int i9;
        int i10;
        int i11;
        char cCharAt;
        int length = str.length();
        int i12 = 0;
        while (true) {
            i9 = i2 + i8;
            if (i12 >= length || (i11 = i12 + i2) >= i9 || (cCharAt = str.charAt(i12)) >= 128) {
                break;
            }
            bArr[i11] = (byte) cCharAt;
            i12++;
        }
        if (i12 == length) {
            return i2 + length;
        }
        int i13 = i2 + i12;
        while (i12 < length) {
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 128 && i13 < i9) {
                bArr[i13] = (byte) cCharAt2;
                i13++;
            } else if (cCharAt2 < 2048 && i13 <= i9 - 2) {
                bArr[i13] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i13 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i13 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i13 > i9 - 3) {
                    if (i13 > i9 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i10 = i12 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i10)))) {
                            throw new zzhd(i12, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i13);
                    }
                    int i14 = i12 + 1;
                    if (i14 != str.length()) {
                        char cCharAt3 = str.charAt(i14);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i15 = i13 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i13] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i13 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i13 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i13 += 4;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i12 = i14;
                        } else {
                            i12 = i14;
                        }
                    }
                    throw new zzhd(i12 - 1, length);
                }
                bArr[i13] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i13 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i13 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i13 += 3;
            }
            i12++;
        }
        return i13;
    }

    public static int zze(String str) {
        int length = str.length();
        int i2 = 0;
        int i8 = 0;
        while (i8 < length && str.charAt(i8) < 128) {
            i8++;
        }
        int i9 = length;
        while (true) {
            if (i8 >= length) {
                break;
            }
            char cCharAt = str.charAt(i8);
            if (cCharAt < 2048) {
                i9 += (127 - cCharAt) >>> 31;
                i8++;
            } else {
                int length2 = str.length();
                while (i8 < length2) {
                    char cCharAt2 = str.charAt(i8);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i8) < 65536) {
                                throw new zzhd(i8, length2);
                            }
                            i8++;
                        }
                    }
                    i8++;
                }
                i9 += i2;
            }
        }
        if (i9 >= length) {
            return i9;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i9) + 4294967296L));
    }

    public static int zzf(int i2, byte[] bArr, int i8, int i9) {
        return zzb.zza(i2, bArr, i8, i9);
    }

    public static boolean zzg(byte[] bArr, int i2, int i8) {
        return zzb.zza(0, bArr, i2, i8) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzh(int i2, int i8) {
        if (i2 > -12 || i8 > -65) {
            return -1;
        }
        return i2 ^ (i8 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzi(int i2, int i8, int i9) {
        if (i2 > -12 || i8 > -65 || i9 > -65) {
            return -1;
        }
        return (i2 ^ (i8 << 8)) ^ (i9 << 16);
    }
}
