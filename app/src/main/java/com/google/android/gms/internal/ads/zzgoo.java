package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgoo {
    public static Object zza(int i2) {
        if (i2 < 2 || i2 > 1073741824 || Integer.highestOneBit(i2) != i2) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 41), "must be power of 2 between 2^1 and 2^30: ", i2));
        }
        return i2 <= 256 ? new byte[i2] : i2 <= 65536 ? new short[i2] : new int[i2];
    }

    public static int zzb(Object obj, int i2) {
        return obj instanceof byte[] ? ((byte[]) obj)[i2] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i2] : ((int[]) obj)[i2];
    }

    public static void zzc(Object obj, int i2, int i8) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i8;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i8;
        } else {
            ((int[]) obj)[i2] = i8;
        }
    }

    public static int zzd(int i2) {
        return (i2 + 1) * (i2 < 32 ? 4 : 2);
    }

    public static int zze(Object obj, Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i8;
        int i9;
        int iZzb = zzgox.zzb(obj);
        int i10 = iZzb & i2;
        int iZzb2 = zzb(obj3, i10);
        if (iZzb2 != 0) {
            int i11 = ~i2;
            int i12 = iZzb & i11;
            int i13 = -1;
            while (true) {
                i8 = iZzb2 - 1;
                int i14 = iArr[i8];
                i9 = i14 & i2;
                if ((i14 & i11) != i12 || !Objects.equals(obj, objArr[i8]) || (objArr2 != null && !Objects.equals(obj2, objArr2[i8]))) {
                    if (i9 == 0) {
                        break;
                    }
                    i13 = i8;
                    iZzb2 = i9;
                } else {
                    break;
                }
            }
            if (i13 == -1) {
                zzc(obj3, i10, i9);
                return i8;
            }
            iArr[i13] = (iArr[i13] & i11) | (i9 & i2);
            return i8;
        }
        return -1;
    }
}
