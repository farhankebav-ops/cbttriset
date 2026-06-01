package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i2, int i8) {
        int i9 = i2 + i8;
        if ((i2 >= 0) == (i8 >= 0)) {
            if ((i2 >= 0) != (i9 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i9;
    }

    public static double clamp(double d8, double d9, double d10) {
        return d8 < d9 ? d9 : d8 > d10 ? d10 : d8;
    }

    public static int decrementExact(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            return i2 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i2, int i8) {
        int i9 = i2 * i8;
        if (i2 == 0 || i8 == 0 || (i9 / i2 == i8 && i9 / i8 == i2)) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return -i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i2, int i8) {
        int i9 = i2 - i8;
        if ((i2 < 0) != (i8 < 0)) {
            if ((i2 < 0) != (i9 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i9;
    }

    public static int toIntExact(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j;
    }

    public static long addExact(long j, long j3) {
        long j8 = j + j3;
        if ((j >= 0) == (j3 >= 0)) {
            if ((j >= 0) != (j8 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static float clamp(float f4, float f8, float f9) {
        return f4 < f8 ? f8 : f4 > f9 ? f9 : f4;
    }

    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j) {
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j, long j3) {
        long j8 = j - j3;
        if ((j < 0) != (j3 < 0)) {
            if ((j < 0) != (j8 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static int clamp(int i2, int i8, int i9) {
        return i2 < i8 ? i8 : i2 > i9 ? i9 : i2;
    }

    public static long multiplyExact(long j, long j3) {
        long j8 = j * j3;
        if (j == 0 || j3 == 0 || (j8 / j == j3 && j8 / j3 == j)) {
            return j8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j, long j3, long j8) {
        return j < j3 ? j3 : j > j8 ? j8 : j;
    }
}
