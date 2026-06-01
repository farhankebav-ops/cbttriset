package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory() {
        this(null);
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract PointF convertPoint(float f4, float f8);

    public final MeteringPoint createPoint(float f4, float f8) {
        return createPoint(f4, f8, getDefaultPointSize());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSurfaceAspectRatio(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MeteringPointFactory(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    public final MeteringPoint createPoint(float f4, float f8, float f9) {
        PointF pointFConvertPoint = convertPoint(f4, f8);
        return new MeteringPoint(pointFConvertPoint.x, pointFConvertPoint.y, f9, this.mSurfaceAspectRatio);
    }
}
