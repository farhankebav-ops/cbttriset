package n6;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class t extends s {
    public static String e0(byte[] bArr) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        return new String(bArr, a.f13073a);
    }

    public static boolean f0(String str, String suffix, boolean z2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        return !z2 ? str.endsWith(suffix) : j0(str, str.length() - suffix.length(), true, suffix, 0, suffix.length());
    }

    public static boolean g0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static void h0() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.k.d(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
    }

    public static final void i0(String str) {
        throw new NumberFormatException(androidx.camera.core.processing.util.a.f('\'', "Invalid number format: '", str));
    }

    public static boolean j0(String str, int i2, boolean z2, String other, int i8, int i9) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        return !z2 ? str.regionMatches(i2, other, i8, i9) : str.regionMatches(z2, i2, other, i8, i9);
    }

    public static String k0(String str, char c7, char c8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        String strReplace = str.replace(c7, c8);
        kotlin.jvm.internal.k.d(strReplace, "replace(...)");
        return strReplace;
    }

    public static String l0(String str, String str2, String newValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(newValue, "newValue");
        int iV0 = m.v0(str, str2, 0, false);
        if (iV0 < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i8 = 0;
        do {
            sb.append((CharSequence) str, i8, iV0);
            sb.append(newValue);
            i8 = iV0 + length;
            if (iV0 >= str.length()) {
                break;
            }
            iV0 = m.v0(str, str2, iV0 + i2, false);
        } while (iV0 > 0);
        sb.append((CharSequence) str, i8, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }

    public static boolean m0(String str, String str2, int i2, boolean z2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return !z2 ? str.startsWith(str2, i2) : j0(str, i2, z2, str2, 0, str2.length());
    }

    public static boolean n0(String str, String prefix, boolean z2) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z2 ? str.startsWith(prefix) : j0(str, 0, z2, prefix, 0, prefix.length());
    }

    public static Integer o0(String str) {
        boolean z2;
        int i2;
        int i8;
        kotlin.jvm.internal.k.e(str, "<this>");
        n7.b.i(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        int i10 = -2147483647;
        if (kotlin.jvm.internal.k.g(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i10 = Integer.MIN_VALUE;
                z2 = true;
            }
        } else {
            z2 = false;
            i2 = 0;
        }
        int i11 = -59652323;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i9 < i11 && (i11 != -59652323 || i9 < (i11 = i10 / 10))) || (i8 = i9 * 10) < i10 + iDigit) {
                return null;
            }
            i9 = i8 - iDigit;
            i2++;
        }
        return z2 ? Integer.valueOf(i9) : Integer.valueOf(-i9);
    }

    public static Long p0(String str) {
        boolean z2;
        kotlin.jvm.internal.k.e(str, "<this>");
        n7.b.i(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (kotlin.jvm.internal.k.g(cCharAt, 48) < 0) {
            z2 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z2 = false;
        }
        long j3 = 0;
        long j8 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j3 < j8) {
                if (j8 != -256204778801521550L) {
                    return null;
                }
                j8 = j / ((long) 10);
                if (j3 < j8) {
                    return null;
                }
            }
            long j9 = j3 * ((long) 10);
            long j10 = iDigit;
            if (j9 < j + j10) {
                return null;
            }
            j3 = j9 - j10;
            i2++;
        }
        return z2 ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
