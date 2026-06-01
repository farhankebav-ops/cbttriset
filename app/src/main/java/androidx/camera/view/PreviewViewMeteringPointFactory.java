package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);

    @GuardedBy("this")
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;

    @GuardedBy("this")
    private Rect mSensorRect = null;

    public PreviewViewMeteringPointFactory(PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @AnyThread
    public PointF convertPoint(float f4, float f8) {
        float[] fArr = {f4, f8};
        synchronized (this) {
            try {
                Matrix matrix = this.mMatrix;
                if (matrix == null) {
                    return INVALID_POINT;
                }
                matrix.mapPoints(fArr);
                return new PointF(fArr[0], fArr[1]);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @UiThread
    public void recalculate(Size size, int i2) {
        Rect rect;
        Threads.checkMainThread();
        synchronized (this) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = this.mSensorRect) != null) {
                    this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSensorMatrix(size, i2, rect);
                    return;
                }
                this.mMatrix = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setSensorRect(Rect rect) {
        setSurfaceAspectRatio(new Rational(rect.width(), rect.height()));
        synchronized (this) {
            this.mSensorRect = rect;
        }
    }
}
