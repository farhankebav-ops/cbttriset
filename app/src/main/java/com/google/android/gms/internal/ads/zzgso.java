package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgso {
    public static long zza(long j, long j3, RoundingMode roundingMode) {
        roundingMode.getClass();
        long j8 = j / j3;
        long j9 = j - (j3 * j8);
        if (j9 == 0) {
            return j8;
        }
        int i2 = ((int) ((j ^ j3) >> 63)) | 1;
        switch (zzgsn.zza[roundingMode.ordinal()]) {
            case 1:
                zzgsp.zzb(false);
                return j8;
            case 2:
                return j8;
            case 3:
                if (i2 >= 0) {
                    return j8;
                }
                break;
            case 4:
                break;
            case 5:
                if (i2 <= 0) {
                    return j8;
                }
                break;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j9);
                long jAbs2 = jAbs - (Math.abs(j3) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j8) == 0)) {
                        return j8;
                    }
                } else if (jAbs2 <= 0) {
                    return j8;
                }
            default:
                throw new AssertionError();
        }
        return j8 + ((long) i2);
    }

    public static long zzb(long j, long j3) {
        zzgsp.zza("a", j);
        zzgsp.zza("b", j3);
        if (j == 0) {
            return j3;
        }
        if (j3 == 0) {
            return j;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long jNumberOfTrailingZeros = j >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
        long j8 = j3 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j8) {
            long j9 = jNumberOfTrailingZeros - j8;
            long j10 = (j9 >> 63) & j9;
            long j11 = (j9 - j10) - j10;
            jNumberOfTrailingZeros = j11 >> Long.numberOfTrailingZeros(j11);
            j8 += j10;
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long zzc(long j, long j3) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j3;
        }
        long j8 = j ^ j3;
        boolean z2 = (iNumberOfLeadingZeros < 64) | ((j3 == Long.MIN_VALUE) & (j < 0));
        long j9 = (j8 >>> 63) + LocationRequestCompat.PASSIVE_INTERVAL;
        if (!z2) {
            long j10 = j * j3;
            if (j == 0 || j10 / j == j3) {
                return j10;
            }
        }
        return j9;
    }
}
