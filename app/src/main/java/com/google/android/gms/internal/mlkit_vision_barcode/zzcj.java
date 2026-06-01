package com.google.android.gms.internal.mlkit_vision_barcode;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcj {
    public static int zza(int i2) {
        return (i2 + 1) * (i2 < 32 ? 4 : 2);
    }

    public static int zzb(Object obj, Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i8;
        int i9;
        int iZza = zzck.zza(obj);
        int i10 = iZza & i2;
        int iZzc = zzc(obj3, i10);
        if (iZzc != 0) {
            int i11 = ~i2;
            int i12 = iZza & i11;
            int i13 = -1;
            while (true) {
                i8 = iZzc - 1;
                int i14 = iArr[i8];
                i9 = i14 & i2;
                if ((i14 & i11) != i12 || !zzax.zza(obj, objArr[i8]) || (objArr2 != null && !zzax.zza(obj2, objArr2[i8]))) {
                    if (i9 == 0) {
                        break;
                    }
                    i13 = i8;
                    iZzc = i9;
                } else {
                    break;
                }
            }
            if (i13 == -1) {
                zze(obj3, i10, i9);
                return i8;
            }
            iArr[i13] = (iArr[i13] & i11) | (i9 & i2);
            return i8;
        }
        return -1;
    }

    public static int zzc(Object obj, int i2) {
        return obj instanceof byte[] ? ((byte[]) obj)[i2] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i2] : ((int[]) obj)[i2];
    }

    public static Object zzd(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException(a.g(i2, "must be power of 2 between 2^1 and 2^30: "));
        }
        return i2 <= 256 ? new byte[i2] : i2 <= 65536 ? new short[i2] : new int[i2];
    }

    public static void zze(Object obj, int i2, int i8) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i8;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i8;
        } else {
            ((int[]) obj)[i2] = i8;
        }
    }
}
