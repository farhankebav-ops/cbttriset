package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BackEventCompat {
    public static final Companion Companion = new Companion(null);
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_NONE = 2;
    public static final int EDGE_RIGHT = 1;
    private final long frameTimeMillis;
    private final float progress;
    private final int swipeEdge;
    private final float touchX;
    private final float touchY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SwipeEdge {
    }

    @VisibleForTesting
    public BackEventCompat(float f4, float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, int i2) {
        this(f4, f8, f9, i2, 0L, 16, null);
    }

    public final long getFrameTimeMillis() {
        return this.frameTimeMillis;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    @RequiresApi(34)
    public final BackEvent toBackEvent() {
        return Build.VERSION.SDK_INT >= 36 ? Api36Impl.INSTANCE.createOnBackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge, this.frameTimeMillis) : Api34Impl.INSTANCE.createOnBackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge);
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + '}';
    }

    @VisibleForTesting
    public BackEventCompat(float f4, float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9, int i2, long j) {
        this.touchX = f4;
        this.touchY = f8;
        this.progress = f9;
        this.swipeEdge = i2;
        this.frameTimeMillis = j;
    }

    public /* synthetic */ BackEventCompat(float f4, float f8, float f9, int i2, long j, int i8, kotlin.jvm.internal.f fVar) {
        this(f4, f8, f9, i2, (i8 & 16) != 0 ? 0L : j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(34)
    public BackEventCompat(BackEvent backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        Api34Impl api34Impl = Api34Impl.INSTANCE;
        this(api34Impl.touchX(backEvent), api34Impl.touchY(backEvent), api34Impl.progress(backEvent), api34Impl.swipeEdge(backEvent), Build.VERSION.SDK_INT >= 36 ? Api36Impl.INSTANCE.frameTimeMillis(backEvent) : 0L);
    }
}
