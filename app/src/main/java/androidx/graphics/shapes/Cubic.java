package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Cubic {
    public static final Companion Companion = new Companion(null);
    private final float[] points;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Cubic circularArc(float f4, float f8, float f9, float f10, float f11, float f12) {
            float f13 = f9 - f4;
            float f14 = f10 - f8;
            long jDirectionVector = Utils.directionVector(f13, f14);
            float f15 = f11 - f4;
            float f16 = f12 - f8;
            long jDirectionVector2 = Utils.directionVector(f15, f16);
            long jM78rotate90DnnuFBc = Utils.m78rotate90DnnuFBc(jDirectionVector);
            long jM78rotate90DnnuFBc2 = Utils.m78rotate90DnnuFBc(jDirectionVector2);
            boolean z2 = PointKt.m52dotProduct5P9i7ZU(jM78rotate90DnnuFBc, f15, f16) >= 0.0f;
            float fM53dotProductybeJwSQ = PointKt.m53dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM53dotProductybeJwSQ > 0.999f) {
                return straightLine(f9, f10, f11, f12);
            }
            float fSqrt = (((((float) Math.sqrt(2 * r9)) - ((float) Math.sqrt(r5 - (fM53dotProductybeJwSQ * fM53dotProductybeJwSQ)))) * ((Utils.distance(f13, f14) * 4.0f) / 3.0f)) / (1 - fM53dotProductybeJwSQ)) * (z2 ? 1.0f : -1.0f);
            return CubicKt.Cubic(f9, f10, (PointKt.m57getXDnnuFBc(jM78rotate90DnnuFBc) * fSqrt) + f9, (PointKt.m58getYDnnuFBc(jM78rotate90DnnuFBc) * fSqrt) + f10, f11 - (PointKt.m57getXDnnuFBc(jM78rotate90DnnuFBc2) * fSqrt), f12 - (PointKt.m58getYDnnuFBc(jM78rotate90DnnuFBc2) * fSqrt), f11, f12);
        }

        public final Cubic straightLine(float f4, float f8, float f9, float f10) {
            return CubicKt.Cubic(f4, f8, Utils.interpolate(f4, f9, 0.33333334f), Utils.interpolate(f8, f10, 0.33333334f), Utils.interpolate(f4, f9, 0.6666667f), Utils.interpolate(f8, f10, 0.6666667f), f9, f10);
        }

        private Companion() {
        }
    }

    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z2);
    }

    public static final Cubic circularArc(float f4, float f8, float f9, float f10, float f11, float f12) {
        return Companion.circularArc(f4, f8, f9, f10, f11, f12);
    }

    public static final Cubic straightLine(float f4, float f8, float f9, float f10) {
        return Companion.straightLine(f4, f8, f9, f10);
    }

    private final boolean zeroIsh(float f4) {
        return Math.abs(f4) < 1.0E-4f;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cb A[PHI: r3 r7
  0x01cb: PHI (r3v15 float) = (r3v12 float), (r3v21 float) binds: [B:85:0x021a, B:62:0x01c9] A[DONT_GENERATE, DONT_INLINE]
  0x01cb: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:85:0x021a, B:62:0x01c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021d A[PHI: r9 r13
  0x021d: PHI (r9v5 float) = (r9v2 float), (r9v3 float), (r9v3 float), (r9v2 float), (r9v2 float), (r9v2 float) binds: [B:65:0x01d4, B:77:0x0203, B:79:0x0207, B:51:0x01a8, B:54:0x01b2, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]
  0x021d: PHI (r13v13 float) = (r13v9 float), (r13v10 float), (r13v10 float), (r13v9 float), (r13v9 float), (r13v9 float) binds: [B:65:0x01d4, B:77:0x0203, B:79:0x0207, B:51:0x01a8, B:54:0x01b2, B:56:0x01b6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void calculateBounds$graphics_shapes_release(float[] r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float f4) {
        return times(1.0f / f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) obj).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o2) {
        k.e(o2, "o");
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = this.points[i2] + o2.points[i2];
        }
        return new Cubic(fArr);
    }

    /* JADX INFO: renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m45pointOnCurveOOQOV4g$graphics_shapes_release(float f4) {
        float f8 = 1 - f4;
        float f9 = f8 * f8 * f8;
        float f10 = 3 * f4;
        float f11 = f10 * f8 * f8;
        float f12 = f10 * f4 * f8;
        float f13 = f4 * f4 * f4;
        return FloatFloatPair.m9constructorimpl((getAnchor1X() * f13) + (getControl1X() * f12) + (getControl0X() * f11) + (getAnchor0X() * f9), (getAnchor1Y() * f13) + (getControl1Y() * f12) + (getControl0Y() * f11) + (getAnchor0Y() * f9));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final i split(float f4) {
        float f8 = 1 - f4;
        long jM45pointOnCurveOOQOV4g$graphics_shapes_release = m45pointOnCurveOOQOV4g$graphics_shapes_release(f4);
        float f9 = f8 * f8;
        float f10 = 2 * f8 * f4;
        float f11 = f4 * f4;
        return new i(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f8) + (getControl0X() * f4), (getAnchor0Y() * f8) + (getControl0Y() * f4), (getControl1X() * f11) + (getControl0X() * f10) + (getAnchor0X() * f9), (getControl1Y() * f11) + (getControl0Y() * f10) + (getAnchor0Y() * f9), PointKt.m57getXDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m58getYDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m57getXDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m58getYDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f11) + (getControl1X() * f10) + (getControl0X() * f9), (getAnchor1Y() * f11) + (getControl1Y() * f10) + (getControl0Y() * f9), (getAnchor1X() * f4) + (getControl1X() * f8), (getAnchor1Y() * f4) + (getControl1Y() * f8), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float f4) {
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = this.points[i2] * f4;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f4) {
        k.e(f4, "f");
        MutableCubic mutableCubic = new MutableCubic();
        float[] fArr = this.points;
        j.d0(fArr, 0, mutableCubic.getPoints$graphics_shapes_release(), 0, fArr.length);
        mutableCubic.transform(f4);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    public /* synthetic */ Cubic(long j, long j3, long j8, long j9, f fVar) {
        this(j, j3, j8, j9);
    }

    public final Cubic div(int i2) {
        return div(i2);
    }

    public final Cubic times(int i2) {
        return times(i2);
    }

    public Cubic(float[] points) {
        k.e(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i2, f fVar) {
        this((i2 & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j, long j3, long j8, long j9) {
        this(new float[]{PointKt.m57getXDnnuFBc(j), PointKt.m58getYDnnuFBc(j), PointKt.m57getXDnnuFBc(j3), PointKt.m58getYDnnuFBc(j3), PointKt.m57getXDnnuFBc(j8), PointKt.m58getYDnnuFBc(j8), PointKt.m57getXDnnuFBc(j9), PointKt.m58getYDnnuFBc(j9)});
    }
}
