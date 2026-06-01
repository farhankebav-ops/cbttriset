package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static <T, V> ObjectAnimator ofObject(T t3, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t3, property, (TypeConverter) null, path);
        }
    }

    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator ofPointF(T t3, Property<T, PointF> property, Path path) {
        return Api21Impl.ofObject(t3, property, path);
    }
}
