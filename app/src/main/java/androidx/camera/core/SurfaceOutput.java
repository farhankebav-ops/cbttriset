package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraInternal;
import androidx.core.util.Consumer;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface SurfaceOutput extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class CameraInputInfo {
        public static CameraInputInfo of(Size size, Rect rect, CameraInternal cameraInternal, int i2, boolean z2) {
            return new AutoValue_SurfaceOutput_CameraInputInfo(size, rect, cameraInternal, i2, z2);
        }

        public abstract CameraInternal getCameraInternal();

        public abstract Rect getInputCropRect();

        public abstract Size getInputSize();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface EventCode {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Event of(int i2, SurfaceOutput surfaceOutput) {
            return new AutoValue_SurfaceOutput_Event(i2, surfaceOutput);
        }

        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    int getFormat();

    Matrix getSensorToBufferTransform();

    Size getSize();

    Surface getSurface(Executor executor, Consumer<Event> consumer);

    int getTargets();

    void updateTransformMatrix(float[] fArr, float[] fArr2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void updateTransformMatrix(float[] fArr, float[] fArr2, boolean z2);
}
