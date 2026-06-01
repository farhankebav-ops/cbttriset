package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i2, int i8, int i9, @NonNull Rect rect, @NonNull Rect rect2, int i10) {
        Gravity.apply(i2, i8, i9, rect, rect2, i10);
    }

    public static void applyDisplay(int i2, @NonNull Rect rect, @NonNull Rect rect2, int i8) {
        Gravity.applyDisplay(i2, rect, rect2, i8);
    }

    public static int getAbsoluteGravity(int i2, int i8) {
        return Gravity.getAbsoluteGravity(i2, i8);
    }

    public static void apply(int i2, int i8, int i9, @NonNull Rect rect, int i10, int i11, @NonNull Rect rect2, int i12) {
        Gravity.apply(i2, i8, i9, rect, i10, i11, rect2, i12);
    }
}
