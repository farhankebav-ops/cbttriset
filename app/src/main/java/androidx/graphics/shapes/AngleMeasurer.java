package androidx.graphics.shapes;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f4, float f8) {
        this.centerX = f4;
        this.centerY = f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic c7, AngleMeasurer this$0, float f4, float f8, float f9) {
        k.e(c7, "$c");
        k.e(this$0, "this$0");
        long jM45pointOnCurveOOQOV4g$graphics_shapes_release = c7.m45pointOnCurveOOQOV4g$graphics_shapes_release(f9);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m57getXDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerX, PointKt.m58getYDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerY) - f4, Utils.getTwoPi()) - f8);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(final Cubic c7, final float f4) {
        k.e(c7, "c");
        final float fAngle = Utils.angle(c7.getAnchor0X() - this.centerX, c7.getAnchor0Y() - this.centerY);
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new FindMinimumFunction() { // from class: androidx.graphics.shapes.a
            @Override // androidx.graphics.shapes.FindMinimumFunction
            public final float invoke(float f8) {
                return AngleMeasurer.findCubicCutPoint$lambda$1(c7, this, fAngle, f4, f8);
            }
        });
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c7) {
        k.e(c7, "c");
        float fPositiveModulo = Utils.positiveModulo(Utils.angle(c7.getAnchor1X() - this.centerX, c7.getAnchor1Y() - this.centerY) - Utils.angle(c7.getAnchor0X() - this.centerX, c7.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (fPositiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return fPositiveModulo;
    }
}
