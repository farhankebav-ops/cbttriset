package com.bytedance.adsdk.IlO.MY.Cc.IlO;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static Object IlO(int i2, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(i2 < number.intValue());
        }
        if (number instanceof Long) {
            return Boolean.valueOf(((long) i2) < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) i2) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) i2) < number.doubleValue());
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static Object IlO(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(j < ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(j < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) j) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) j) < number.doubleValue());
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static Object IlO(float f4, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(f4 < ((float) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(f4 < ((float) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(f4 < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) f4) < number.doubleValue());
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    private static Object IlO(double d8, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(d8 < ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(d8 < ((double) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(d8 < ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Boolean.valueOf(d8 < number.doubleValue());
        }
        throw new UnsupportedOperationException(a0.b("This type of addition operation is not supported", number));
    }

    public static Object IlO(Object obj, Number number) {
        if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
            if (obj instanceof Long) {
                return IlO(((Long) obj).longValue(), number);
            }
            if (obj instanceof Float) {
                return IlO(((Float) obj).floatValue(), number);
            }
            if (obj instanceof Double) {
                return IlO(((Double) obj).doubleValue(), number);
            }
            if (obj instanceof String) {
                try {
                    return IlO(Float.parseFloat((String) obj), number);
                } catch (NumberFormatException unused) {
                    throw new UnsupportedOperationException(obj.getClass().getName().concat("This type of addition operation is not supported"));
                }
            }
            throw new UnsupportedOperationException(obj.getClass().getName().concat("This type of addition operation is not supported"));
        }
        return IlO(((Number) obj).intValue(), number);
    }
}
