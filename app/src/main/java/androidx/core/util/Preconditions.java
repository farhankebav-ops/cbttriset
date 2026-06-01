package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f4, @NonNull String str) {
        if (Float.isNaN(f4)) {
            throw new IllegalArgumentException(a1.a.C(str, " must not be NaN"));
        }
        if (Float.isInfinite(f4)) {
            throw new IllegalArgumentException(a1.a.C(str, " must not be infinite"));
        }
        return f4;
    }

    public static int checkArgumentInRange(int i2, int i8, int i9, @NonNull String str) {
        if (i2 < i8) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i8 + ", " + i9 + "] (too low)");
        }
        if (i2 <= i9) {
            return i2;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i8 + ", " + i9 + "] (too high)");
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public static int checkArgumentNonnegative(int i2, @Nullable String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkFlagsArgument(int i2, int i8) {
        if ((i2 & i8) == i2) {
            return i2;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(i8) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3) {
        t3.getClass();
        return t3;
    }

    public static void checkState(boolean z2, @Nullable String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException();
        }
        return t3;
    }

    public static void checkArgument(boolean z2, @NonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public static int checkArgumentNonnegative(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t3, @NonNull Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z2) {
        checkState(z2, null);
    }

    public static void checkArgument(boolean z2, @NonNull String str, @NonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3, @NonNull Object obj) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t3;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t3, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t3)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t3;
    }

    public static long checkArgumentInRange(long j, long j3, long j8, @NonNull String str) {
        if (j < j3) {
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is out of range of [");
            sb.append(j3);
            sb.append(", ");
            throw new IllegalArgumentException(a1.a.p(sb, j8, "] (too low)"));
        }
        if (j <= j8) {
            return j;
        }
        Locale locale2 = Locale.US;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" is out of range of [");
        sb2.append(j3);
        sb2.append(", ");
        throw new IllegalArgumentException(a1.a.p(sb2, j8, "] (too high)"));
    }

    public static float checkArgumentInRange(float f4, float f8, float f9, @NonNull String str) {
        if (f4 < f8) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f8), Float.valueOf(f9)));
        }
        if (f4 <= f9) {
            return f4;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f8), Float.valueOf(f9)));
    }

    public static double checkArgumentInRange(double d8, double d9, double d10, @NonNull String str) {
        if (d8 < d9) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d9), Double.valueOf(d10)));
        }
        if (d8 <= d10) {
            return d8;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d9), Double.valueOf(d10)));
    }
}
