package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    private static final long Zero = FloatFloatPair.m9constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final float angle(float f4, float f8) {
        float fAtan2 = (float) Math.atan2(f8, f4);
        float f9 = TwoPi;
        return (fAtan2 + f9) % f9;
    }

    public static final void debugLog(String tag, e6.a messageFactory) {
        k.e(tag, "tag");
        k.e(messageFactory, "messageFactory");
    }

    public static final long directionVector(float f4, float f8) {
        float fDistance = distance(f4, f8);
        if (fDistance > 0.0f) {
            return FloatFloatPair.m9constructorimpl(f4 / fDistance, f8 / fDistance);
        }
        throw new IllegalArgumentException("Required distance greater than zero");
    }

    public static final float distance(float f4, float f8) {
        return (float) Math.sqrt((f8 * f8) + (f4 * f4));
    }

    public static final float distanceSquared(float f4, float f8) {
        return (f8 * f8) + (f4 * f4);
    }

    public static final float findMinimum(float f4, float f8, float f9, FindMinimumFunction f10) {
        k.e(f10, "f");
        while (f8 - f4 > f9) {
            float f11 = 2;
            float f12 = 3;
            float f13 = ((f11 * f4) + f8) / f12;
            float f14 = ((f11 * f8) + f4) / f12;
            if (f10.invoke(f13) < f10.invoke(f14)) {
                f8 = f14;
            } else {
                f4 = f13;
            }
        }
        return (f4 + f8) / 2;
    }

    public static /* synthetic */ float findMinimum$default(float f4, float f8, float f9, FindMinimumFunction findMinimumFunction, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f9 = 0.001f;
        }
        return findMinimum(f4, f8, f9, findMinimumFunction);
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final long getZero() {
        return Zero;
    }

    public static final float interpolate(float f4, float f8, float f9) {
        return (f9 * f8) + ((1 - f9) * f4);
    }

    public static final float positiveModulo(float f4, float f8) {
        return ((f4 % f8) + f8) % f8;
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0, reason: not valid java name */
    public static final long m76radialToCartesianL6JJ3z0(float f4, float f8, long j) {
        return PointKt.m61plusybeJwSQ(PointKt.m63timesso9K2fw(directionVector(f8), f4), j);
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0$default, reason: not valid java name */
    public static /* synthetic */ long m77radialToCartesianL6JJ3z0$default(float f4, float f8, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = Zero;
        }
        return m76radialToCartesianL6JJ3z0(f4, f8, j);
    }

    /* JADX INFO: renamed from: rotate90-DnnuFBc, reason: not valid java name */
    public static final long m78rotate90DnnuFBc(long j) {
        return FloatFloatPair.m9constructorimpl(-PointKt.m58getYDnnuFBc(j), PointKt.m57getXDnnuFBc(j));
    }

    public static final float square(float f4) {
        return f4 * f4;
    }

    public static final long directionVector(float f4) {
        double d8 = f4;
        return FloatFloatPair.m9constructorimpl((float) Math.cos(d8), (float) Math.sin(d8));
    }
}
