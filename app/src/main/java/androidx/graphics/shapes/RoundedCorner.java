package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.f;
import r2.q;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private final long f4023d1;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    private final long f4024d2;
    private final float expectedRoundCut;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final long f4025p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private final long f4026p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j, long j3, long j8, CornerRounding cornerRounding, f fVar) {
        this(j, j3, j8, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float f4) {
        if (f4 > getExpectedCut()) {
            return this.smoothing;
        }
        float f8 = this.expectedRoundCut;
        if (f4 <= f8) {
            return 0.0f;
        }
        return ((f4 - f8) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* JADX INFO: renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m67computeFlankingCurveoAJzIJU(float f4, float f8, long j, long j3, long j8, long j9, long j10, float f9) {
        long jM54getDirectionDnnuFBc = PointKt.m54getDirectionDnnuFBc(PointKt.m60minusybeJwSQ(j3, j));
        long jM61plusybeJwSQ = PointKt.m61plusybeJwSQ(j, PointKt.m63timesso9K2fw(PointKt.m63timesso9K2fw(jM54getDirectionDnnuFBc, f4), 1 + f8));
        long jM17unboximpl = j8;
        long jM59interpolatedLqxh1s = PointKt.m59interpolatedLqxh1s(jM17unboximpl, PointKt.m51divso9K2fw(PointKt.m61plusybeJwSQ(j8, j9), 2.0f), f8);
        long jM61plusybeJwSQ2 = PointKt.m61plusybeJwSQ(j10, PointKt.m63timesso9K2fw(Utils.directionVector(PointKt.m57getXDnnuFBc(jM59interpolatedLqxh1s) - PointKt.m57getXDnnuFBc(j10), PointKt.m58getYDnnuFBc(jM59interpolatedLqxh1s) - PointKt.m58getYDnnuFBc(j10)), f9));
        FloatFloatPair floatFloatPairM68lineIntersectionCBFvKDc = m68lineIntersectionCBFvKDc(j3, jM54getDirectionDnnuFBc, jM61plusybeJwSQ2, Utils.m78rotate90DnnuFBc(PointKt.m60minusybeJwSQ(jM61plusybeJwSQ2, j10)));
        if (floatFloatPairM68lineIntersectionCBFvKDc != null) {
            jM17unboximpl = floatFloatPairM68lineIntersectionCBFvKDc.m17unboximpl();
        }
        return new Cubic(jM61plusybeJwSQ, PointKt.m51divso9K2fw(PointKt.m61plusybeJwSQ(jM61plusybeJwSQ, PointKt.m63timesso9K2fw(jM17unboximpl, 2.0f)), 3.0f), jM17unboximpl, jM61plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f4, float f8, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f8 = f4;
        }
        return roundedCorner.getCubics(f4, f8);
    }

    /* JADX INFO: renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m68lineIntersectionCBFvKDc(long j, long j3, long j8, long j9) {
        long jM78rotate90DnnuFBc = Utils.m78rotate90DnnuFBc(j9);
        float fM53dotProductybeJwSQ = PointKt.m53dotProductybeJwSQ(j3, jM78rotate90DnnuFBc);
        if (Math.abs(fM53dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM53dotProductybeJwSQ2 = PointKt.m53dotProductybeJwSQ(PointKt.m60minusybeJwSQ(j8, j), jM78rotate90DnnuFBc);
        if (Math.abs(fM53dotProductybeJwSQ) < Math.abs(fM53dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m6boximpl(PointKt.m61plusybeJwSQ(j, PointKt.m63timesso9K2fw(j3, fM53dotProductybeJwSQ2 / fM53dotProductybeJwSQ)));
    }

    /* JADX INFO: renamed from: getCenter-1ufDz9w, reason: not valid java name */
    public final long m69getCenter1ufDz9w() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f4) {
        return getCubics$default(this, f4, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: getD1-1ufDz9w, reason: not valid java name */
    public final long m70getD11ufDz9w() {
        return this.f4023d1;
    }

    /* JADX INFO: renamed from: getD2-1ufDz9w, reason: not valid java name */
    public final long m71getD21ufDz9w() {
        return this.f4024d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* JADX INFO: renamed from: getP0-1ufDz9w, reason: not valid java name */
    public final long m72getP01ufDz9w() {
        return this.f4025p0;
    }

    /* JADX INFO: renamed from: getP1-1ufDz9w, reason: not valid java name */
    public final long m73getP11ufDz9w() {
        return this.f4026p1;
    }

    /* JADX INFO: renamed from: getP2-1ufDz9w, reason: not valid java name */
    public final long m74getP21ufDz9w() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* JADX INFO: renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m75setCenterDnnuFBc(long j) {
        this.center = j;
    }

    private RoundedCorner(long j, long j3, long j8, CornerRounding cornerRounding) {
        this.f4025p0 = j;
        this.f4026p1 = j3;
        this.p2 = j8;
        this.rounding = cornerRounding;
        long jM54getDirectionDnnuFBc = PointKt.m54getDirectionDnnuFBc(PointKt.m60minusybeJwSQ(j, j3));
        this.f4023d1 = jM54getDirectionDnnuFBc;
        long jM54getDirectionDnnuFBc2 = PointKt.m54getDirectionDnnuFBc(PointKt.m60minusybeJwSQ(j8, j3));
        this.f4024d2 = jM54getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM53dotProductybeJwSQ = PointKt.m53dotProductybeJwSQ(jM54getDirectionDnnuFBc, jM54getDirectionDnnuFBc2);
        this.cosAngle = fM53dotProductybeJwSQ;
        float f4 = 1;
        float fSqrt = (float) Math.sqrt(f4 - Utils.square(fM53dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM53dotProductybeJwSQ + f4) * radius) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m9constructorimpl(0.0f, 0.0f);
    }

    public final List<Cubic> getCubics(float f4, float f8) {
        float fMin = Math.min(f4, f8);
        float f9 = this.expectedRoundCut;
        if (f9 < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j = this.f4026p1;
            this.center = j;
            return q.j0(Cubic.Companion.straightLine(PointKt.m57getXDnnuFBc(j), PointKt.m58getYDnnuFBc(this.f4026p1), PointKt.m57getXDnnuFBc(this.f4026p1), PointKt.m58getYDnnuFBc(this.f4026p1)));
        }
        float fMin2 = Math.min(fMin, f9);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(f4);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(f8);
        float f10 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m61plusybeJwSQ(this.f4026p1, PointKt.m63timesso9K2fw(PointKt.m54getDirectionDnnuFBc(PointKt.m51divso9K2fw(PointKt.m61plusybeJwSQ(this.f4023d1, this.f4024d2), 2.0f)), (float) Math.sqrt(Utils.square(fMin2) + Utils.square(f10))));
        long jM61plusybeJwSQ = PointKt.m61plusybeJwSQ(this.f4026p1, PointKt.m63timesso9K2fw(this.f4023d1, fMin2));
        long jM61plusybeJwSQ2 = PointKt.m61plusybeJwSQ(this.f4026p1, PointKt.m63timesso9K2fw(this.f4024d2, fMin2));
        Cubic cubicM67computeFlankingCurveoAJzIJU = m67computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.f4026p1, this.f4025p0, jM61plusybeJwSQ, jM61plusybeJwSQ2, this.center, f10);
        Cubic cubicReverse = m67computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.f4026p1, this.p2, jM61plusybeJwSQ2, jM61plusybeJwSQ, this.center, f10).reverse();
        return m.H0(cubicM67computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m57getXDnnuFBc(this.center), PointKt.m58getYDnnuFBc(this.center), cubicM67computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM67computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse);
    }

    public /* synthetic */ RoundedCorner(long j, long j3, long j8, CornerRounding cornerRounding, int i2, f fVar) {
        this(j, j3, j8, (i2 & 8) != 0 ? null : cornerRounding, null);
    }
}
