package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PointKt {
    /* JADX INFO: renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m48clockwiseybeJwSQ(long j, long j3) {
        return (m58getYDnnuFBc(j3) * m57getXDnnuFBc(j)) - (m57getXDnnuFBc(j3) * m58getYDnnuFBc(j)) > 0.0f;
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m49copy5P9i7ZU(long j, float f4, float f8) {
        return FloatFloatPair.m9constructorimpl(f4, f8);
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m50copy5P9i7ZU$default(long j, float f4, float f8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i2 & 2) != 0) {
            f8 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m49copy5P9i7ZU(j, f4, f8);
    }

    /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m51divso9K2fw(long j, float f4) {
        return FloatFloatPair.m9constructorimpl(m57getXDnnuFBc(j) / f4, m58getYDnnuFBc(j) / f4);
    }

    /* JADX INFO: renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m52dotProduct5P9i7ZU(long j, float f4, float f8) {
        return (m58getYDnnuFBc(j) * f8) + (m57getXDnnuFBc(j) * f4);
    }

    /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m53dotProductybeJwSQ(long j, long j3) {
        return (m58getYDnnuFBc(j3) * m58getYDnnuFBc(j)) + (m57getXDnnuFBc(j3) * m57getXDnnuFBc(j));
    }

    /* JADX INFO: renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m54getDirectionDnnuFBc(long j) {
        float fM55getDistanceDnnuFBc = m55getDistanceDnnuFBc(j);
        if (fM55getDistanceDnnuFBc > 0.0f) {
            return m51divso9K2fw(j, fM55getDistanceDnnuFBc);
        }
        throw new IllegalArgumentException("Can't get the direction of a 0-length vector");
    }

    /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m55getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m58getYDnnuFBc(j) * m58getYDnnuFBc(j)) + (m57getXDnnuFBc(j) * m57getXDnnuFBc(j)));
    }

    /* JADX INFO: renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m56getDistanceSquaredDnnuFBc(long j) {
        return (m58getYDnnuFBc(j) * m58getYDnnuFBc(j)) + (m57getXDnnuFBc(j) * m57getXDnnuFBc(j));
    }

    /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m57getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m58getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m59interpolatedLqxh1s(long j, long j3, float f4) {
        return FloatFloatPair.m9constructorimpl(Utils.interpolate(m57getXDnnuFBc(j), m57getXDnnuFBc(j3), f4), Utils.interpolate(m58getYDnnuFBc(j), m58getYDnnuFBc(j3), f4));
    }

    /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m60minusybeJwSQ(long j, long j3) {
        return FloatFloatPair.m9constructorimpl(m57getXDnnuFBc(j) - m57getXDnnuFBc(j3), m58getYDnnuFBc(j) - m58getYDnnuFBc(j3));
    }

    /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m61plusybeJwSQ(long j, long j3) {
        return FloatFloatPair.m9constructorimpl(m57getXDnnuFBc(j3) + m57getXDnnuFBc(j), m58getYDnnuFBc(j3) + m58getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m62remso9K2fw(long j, float f4) {
        return FloatFloatPair.m9constructorimpl(m57getXDnnuFBc(j) % f4, m58getYDnnuFBc(j) % f4);
    }

    /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m63timesso9K2fw(long j, float f4) {
        return FloatFloatPair.m9constructorimpl(m57getXDnnuFBc(j) * f4, m58getYDnnuFBc(j) * f4);
    }

    /* JADX INFO: renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m64transformedso9K2fw(long j, PointTransformer f4) {
        k.e(f4, "f");
        long jMo66transformXgqJiTY = f4.mo66transformXgqJiTY(m57getXDnnuFBc(j), m58getYDnnuFBc(j));
        return FloatFloatPair.m9constructorimpl(Float.intBitsToFloat((int) (jMo66transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo66transformXgqJiTY & 4294967295L)));
    }

    /* JADX INFO: renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m65unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m9constructorimpl(-m57getXDnnuFBc(j), -m58getYDnnuFBc(j));
    }
}
