package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceOrientedMeteringPointFactory extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    public SurfaceOrientedMeteringPointFactory(float f4, float f8) {
        this.mWidth = f4;
        this.mHeight = f8;
    }

    private static Rational getUseCaseAspectRatio(UseCase useCase) {
        if (useCase == null) {
            return null;
        }
        Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
        if (attachedSurfaceResolution != null) {
            return new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        throw new IllegalStateException("UseCase " + useCase + " is not bound.");
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PointF convertPoint(float f4, float f8) {
        return new PointF(f4 / this.mWidth, f8 / this.mHeight);
    }

    public SurfaceOrientedMeteringPointFactory(float f4, float f8, UseCase useCase) {
        super(getUseCaseAspectRatio(useCase));
        this.mWidth = f4;
        this.mHeight = f8;
    }
}
