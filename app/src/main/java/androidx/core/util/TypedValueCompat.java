package androidx.core.util;

import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i2, float f4, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i2, f4, displayMetrics);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i2, float f4, @NonNull DisplayMetrics displayMetrics) {
        float f8;
        float f9;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i2, f4, displayMetrics);
        }
        if (i2 == 0) {
            return f4;
        }
        if (i2 == 1) {
            float f10 = displayMetrics.density;
            if (f10 == 0.0f) {
                return 0.0f;
            }
            return f4 / f10;
        }
        if (i2 == 2) {
            float f11 = displayMetrics.scaledDensity;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            return f4 / f11;
        }
        if (i2 == 3) {
            float f12 = displayMetrics.xdpi;
            if (f12 == 0.0f) {
                return 0.0f;
            }
            f8 = f4 / f12;
            f9 = INCHES_PER_PT;
        } else {
            if (i2 == 4) {
                float f13 = displayMetrics.xdpi;
                if (f13 == 0.0f) {
                    return 0.0f;
                }
                return f4 / f13;
            }
            if (i2 != 5) {
                throw new IllegalArgumentException(a1.a.g(i2, "Invalid unitToConvertTo "));
            }
            float f14 = displayMetrics.xdpi;
            if (f14 == 0.0f) {
                return 0.0f;
            }
            f8 = f4 / f14;
            f9 = INCHES_PER_MM;
        }
        return f8 / f9;
    }

    public static float dpToPx(float f4, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f4, displayMetrics);
    }

    public static int getUnitFromComplexDimension(int i2) {
        return i2 & 15;
    }

    public static float pxToDp(float f4, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f4, displayMetrics);
    }

    public static float pxToSp(float f4, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f4, displayMetrics);
    }

    public static float spToPx(float f4, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f4, displayMetrics);
    }
}
