package j4;

import androidx.core.location.LocationRequestCompat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12546a = TimeUnit.SECONDS.toNanos(1);

    public static void a(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!(list.get(i2) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i2), Integer.valueOf(i2), list));
            }
        }
    }

    public static Boolean b(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    public static List c(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List d(String str, Map map) {
        List listC = c(str, map);
        if (listC == null) {
            return null;
        }
        for (int i2 = 0; i2 < listC.size(); i2++) {
            if (!(listC.get(i2) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", listC.get(i2), Integer.valueOf(i2), listC));
            }
        }
        return listC;
    }

    public static Double e(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    public static Integer f(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d8 = (Double) obj;
        int iIntValue = d8.intValue();
        if (iIntValue == d8.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d8);
    }

    public static Map g(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    public static String h(String str, Map map) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long i(String str, Map map) {
        String strH = h(str, map);
        if (strH == null) {
            return null;
        }
        try {
            return Long.valueOf(k(strH));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static long j(int i2, long j) {
        long j3 = i2;
        long j8 = f12546a;
        if (j3 <= (-j8) || j3 >= j8) {
            long j9 = j3 / j8;
            long j10 = j + j9;
            if (!((j9 ^ j) < 0) && !((j ^ j10) >= 0)) {
                throw new ArithmeticException();
            }
            i2 = (int) (j3 % j8);
            j = j10;
        }
        if (j > 0 && i2 < 0) {
            i2 = (int) (((long) i2) + j8);
            j--;
        }
        if (j < 0 && i2 > 0) {
            i2 = (int) (((long) i2) - j8);
            j++;
        }
        if (j >= -315576000000L && j <= 315576000000L) {
            long j11 = i2;
            if (j11 >= -999999999 && j11 < j8 && ((j >= 0 && i2 >= 0) || (j <= 0 && i2 <= 0))) {
                long nanos = TimeUnit.SECONDS.toNanos(j);
                long j12 = i2;
                long j13 = nanos + j12;
                return (((j12 ^ nanos) > 0L ? 1 : ((j12 ^ nanos) == 0L ? 0 : -1)) < 0) | ((nanos ^ j13) >= 0) ? j13 : ((j13 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }
        throw new IllegalArgumentException("Duration is not valid. See proto definition for valid values. Seconds (" + j + ") must be in range [-315,576,000,000, +315,576,000,000]. Nanos (" + i2 + ") must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds");
    }

    public static long k(String str) throws ParseException {
        boolean z2;
        String strSubstring;
        int iCharAt;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z2 = true;
        } else {
            z2 = false;
        }
        String strSubstring2 = str.substring(0, str.length() - 1);
        int iIndexOf = strSubstring2.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j = Long.parseLong(strSubstring2);
        if (strSubstring.isEmpty()) {
            iCharAt = 0;
        } else {
            iCharAt = 0;
            for (int i2 = 0; i2 < 9; i2++) {
                iCharAt *= 10;
                if (i2 < strSubstring.length()) {
                    if (strSubstring.charAt(i2) < '0' || strSubstring.charAt(i2) > '9') {
                        throw new ParseException("Invalid nanoseconds.", 0);
                    }
                    iCharAt = (strSubstring.charAt(i2) - '0') + iCharAt;
                }
            }
        }
        if (j < 0) {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (z2) {
            j = -j;
            iCharAt = -iCharAt;
        }
        try {
            return j(iCharAt, j);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }
}
