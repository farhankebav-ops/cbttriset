package com.bytedance.adsdk.IlO.MY.Cc.IlO;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static boolean IlO(int i2, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return i2 == number.intValue();
        }
        if (number instanceof Long) {
            return ((long) i2) == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) i2) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) i2) == number.doubleValue();
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static boolean IlO(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return j == ((long) number.intValue());
        }
        if (number instanceof Long) {
            return j == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) j) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) j) == number.doubleValue();
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static boolean IlO(float f4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return f4 == ((float) number.intValue());
        }
        if (number instanceof Long) {
            return f4 == ((float) number.longValue());
        }
        if (number instanceof Float) {
            return f4 == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) f4) == number.doubleValue();
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static boolean IlO(double d8, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d8 == ((double) number.intValue());
        }
        if (number instanceof Long) {
            return d8 == ((double) number.longValue());
        }
        if (number instanceof Float) {
            return d8 == ((double) number.floatValue());
        }
        if (number instanceof Double) {
            return d8 == number.doubleValue();
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    public static boolean IlO(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return IlO(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return IlO(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return IlO(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
        }
        return IlO(number.intValue(), number2);
    }
}
