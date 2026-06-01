package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(float f4, float f8) {
            return new PathInterpolator(f4, f8);
        }

        @DoNotInline
        public static Interpolator createPathInterpolator(float f4, float f8, float f9, float f10) {
            return new PathInterpolator(f4, f8, f9, f10);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f4, float f8) {
        return Api21Impl.createPathInterpolator(f4, f8);
    }

    @NonNull
    public static Interpolator create(float f4, float f8, float f9, float f10) {
        return Api21Impl.createPathInterpolator(f4, f8, f9, f10);
    }
}
