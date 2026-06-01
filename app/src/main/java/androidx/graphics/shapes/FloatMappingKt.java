package androidx.graphics.shapes;

import androidx.collection.FloatList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import k6.c;
import kotlin.jvm.internal.k;
import r2.q;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList xValues, FloatList yValues, float f4) {
        k.e(xValues, "xValues");
        k.e(yValues, "yValues");
        if (0.0f > f4 || f4 > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f4).toString());
        }
        Iterator it = q.D0(0, xValues._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((v) it).nextInt();
            int i2 = iNextInt + 1;
            if (progressInRange(f4, xValues.get(iNextInt), xValues.get(i2 % xValues.getSize()))) {
                int size = i2 % xValues.getSize();
                float fPositiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(iNextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(yValues.get(size) - yValues.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f4 - xValues.get(iNextInt), 1.0f) / fPositiveModulo)) + yValues.get(iNextInt), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final boolean progressInRange(float f4, float f8, float f9) {
        return f9 >= f8 ? f8 <= f4 && f4 <= f9 : f4 >= f8 || f4 <= f9;
    }

    public static final void validateProgress(FloatList p) {
        int i2;
        k.e(p, "p");
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = p.content;
        int i8 = p._size;
        int i9 = 0;
        while (true) {
            boolean z2 = true;
            if (i9 >= i8) {
                break;
            }
            float f4 = fArr[i9];
            if (!boolValueOf.booleanValue() || 0.0f > f4 || f4 > 1.0f) {
                z2 = false;
            }
            boolValueOf = Boolean.valueOf(z2);
            i9++;
        }
        if (!boolValueOf.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
        Iterable iterableD0 = q.D0(1, p.getSize());
        if ((iterableD0 instanceof Collection) && ((Collection) iterableD0).isEmpty()) {
            i2 = 0;
        } else {
            Iterator it = iterableD0.iterator();
            i2 = 0;
            while (((c) it).f12714c) {
                int iNextInt = ((v) it).nextInt();
                if (p.get(iNextInt) < p.get(iNextInt - 1) && (i2 = i2 + 1) < 0) {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        if (i2 <= 1) {
            return;
        }
        throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
    }
}
