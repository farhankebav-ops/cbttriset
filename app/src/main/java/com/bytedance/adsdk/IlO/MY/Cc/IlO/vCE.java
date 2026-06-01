package com.bytedance.adsdk.IlO.MY.Cc.IlO;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private static Object IlO(int i2, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i2 % number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(((long) i2) % number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i2 % number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) i2) % number.doubleValue());
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static Object IlO(long j, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(j % number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(j % number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(j % number.doubleValue());
            }
            throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
        }
        return Long.valueOf(j % ((long) number.intValue()));
    }

    private static Object IlO(float f4, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f4 % number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(f4 % number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(((double) f4) % number.doubleValue());
            }
            throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
        }
        return Float.valueOf(f4 % number.intValue());
    }

    private static Object IlO(double d8, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Double.valueOf(d8 % number.longValue());
            }
            if (number instanceof Float) {
                return Double.valueOf(d8 % ((double) number.floatValue()));
            }
            if (number instanceof Double) {
                return Double.valueOf(d8 % number.doubleValue());
            }
            throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
        }
        return Double.valueOf(d8 % ((double) number.intValue()));
    }

    public static Object IlO(Number number, Number number2) {
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
