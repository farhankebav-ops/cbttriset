package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgsm {
    public static int zza(int i2, RoundingMode roundingMode) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("x (0) must be > 0");
        }
        switch (zzgsl.zza[roundingMode.ordinal()]) {
            case 1:
                zzgsp.zzb(((i2 + (-1)) & i2) == 0);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i2 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                return (31 - iNumberOfLeadingZeros) + ((((-1257966797) >>> iNumberOfLeadingZeros) - i2) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static int zzb(int i2, int i8, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i8 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i9 = i2 / i8;
        int i10 = i2 - (i8 * i9);
        if (i10 == 0) {
            return i9;
        }
        int i11 = ((i2 ^ i8) >> 31) | 1;
        switch (zzgsl.zza[roundingMode.ordinal()]) {
            case 1:
                zzgsp.zzb(false);
                return i9;
            case 2:
                return i9;
            case 3:
                if (i11 >= 0) {
                    return i9;
                }
                break;
            case 4:
                break;
            case 5:
                if (i11 <= 0) {
                    return i9;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i10);
                int iAbs2 = iAbs - (Math.abs(i8) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if ((i9 & 1 & (roundingMode != RoundingMode.HALF_EVEN ? 0 : 1)) == 0) {
                            return i9;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i9;
                }
            default:
                throw new AssertionError();
        }
        return i9 + i11;
    }
}
