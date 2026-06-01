package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PathUtils {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float[] approximate(Path path, float f4) {
            return path.approximate(f4);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f4) {
        float[] fArrApproximate = Api26Impl.approximate(path, f4);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 1; i2 < length; i2++) {
            int i8 = i2 * 3;
            int i9 = (i2 - 1) * 3;
            float f8 = fArrApproximate[i8];
            float f9 = fArrApproximate[i8 + 1];
            float f10 = fArrApproximate[i8 + 2];
            float f11 = fArrApproximate[i9];
            float f12 = fArrApproximate[i9 + 1];
            float f13 = fArrApproximate[i9 + 2];
            if (f8 != f11 && (f9 != f12 || f10 != f13)) {
                arrayList.add(new PathSegment(new PointF(f12, f13), f11, new PointF(f9, f10), f8));
            }
        }
        return arrayList;
    }
}
