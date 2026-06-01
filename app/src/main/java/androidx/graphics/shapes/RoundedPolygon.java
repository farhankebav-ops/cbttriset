package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r2.q;
import r5.l;
import r5.m;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedPolygon {
    public static final Companion Companion = new Companion(null);
    private final float centerX;
    private final float centerY;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoundedPolygon(List<? extends Feature> features, float f4, float f8) {
        ArrayList arrayListI0;
        ArrayList arrayListI02;
        Cubic cubic;
        List<Cubic> cubics;
        k.e(features, "features");
        this.features = features;
        this.centerX = f4;
        this.centerY = f8;
        c cVarN = q.N();
        int i2 = 0;
        Cubic cubic2 = null;
        if (features.size() <= 0 || ((Feature) features.get(0)).getCubics().size() != 3) {
            arrayListI0 = null;
            arrayListI02 = null;
        } else {
            i iVarSplit = ((Feature) features.get(0)).getCubics().get(1).split(0.5f);
            Cubic cubic3 = (Cubic) iVarSplit.f13498a;
            Cubic cubic4 = (Cubic) iVarSplit.f13499b;
            arrayListI02 = m.I0(((Feature) features.get(0)).getCubics().get(0), cubic3);
            arrayListI0 = m.I0(cubic4, ((Feature) features.get(0)).getCubics().get(2));
        }
        int size = features.size();
        if (size >= 0) {
            int i8 = 0;
            Cubic cubic5 = null;
            while (true) {
                if (i8 == 0 && arrayListI0 != null) {
                    cubics = arrayListI0;
                } else if (i8 != this.features.size()) {
                    cubics = this.features.get(i8).getCubics();
                } else if (arrayListI02 == null) {
                    break;
                } else {
                    cubics = arrayListI02;
                }
                int size2 = cubics.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    Cubic cubic6 = cubics.get(i9);
                    if (!cubic6.zeroLength$graphics_shapes_release()) {
                        if (cubic5 != null) {
                            cVarN.add(cubic5);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic6;
                            cubic5 = cubic2;
                        } else {
                            cubic5 = cubic6;
                        }
                    } else if (cubic5 != null) {
                        cubic5.getPoints$graphics_shapes_release()[6] = cubic6.getAnchor1X();
                        cubic5.getPoints$graphics_shapes_release()[7] = cubic6.getAnchor1Y();
                    }
                }
                if (i8 == size) {
                    break;
                } else {
                    i8++;
                }
            }
            cubic = cubic2;
            cubic2 = cubic5;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            cVarN.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        }
        c cVarO = q.o(cVarN);
        this.cubics = cVarO;
        Object obj = cVarO.get(cVarO.a() - 1);
        int iA = cVarO.a();
        while (i2 < iA) {
            Cubic cubic7 = this.cubics.get(i2);
            Cubic cubic8 = (Cubic) obj;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i2++;
            obj = cubic7;
        }
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return roundedPolygon.calculateBounds(fArr, z2);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        k.e(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4");
        }
        int size = this.cubics.size();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            Cubic cubic = this.cubics.get(i2);
            float fDistanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
            long jM45pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m45pointOnCurveOOQOV4g$graphics_shapes_release(0.5f);
            fMax = Math.max(fMax, Math.max(fDistanceSquared, Utils.distanceSquared(PointKt.m57getXDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerX, PointKt.m58getYDnnuFBc(jM45pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerY)));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        float f4 = this.centerX;
        bounds[0] = f4 - fSqrt;
        float f8 = this.centerY;
        bounds[1] = f8 - fSqrt;
        bounds[2] = f4 + fSqrt;
        bounds[3] = f8 + fSqrt;
        return bounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedPolygon) {
            return k.a(this.features, ((RoundedPolygon) obj).features);
        }
        return false;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final List<Feature> getFeatures$graphics_shapes_release() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        float[] fArrCalculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f4 = fArrCalculateBounds$default[2] - fArrCalculateBounds$default[0];
        float f8 = fArrCalculateBounds$default[3] - fArrCalculateBounds$default[1];
        final float fMax = Math.max(f4, f8);
        float f9 = 2;
        final float f10 = ((fMax - f4) / f9) - fArrCalculateBounds$default[0];
        final float f11 = ((fMax - f8) / f9) - fArrCalculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon.normalized.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* JADX INFO: renamed from: transform-XgqJiTY */
            public final long mo66transformXgqJiTY(float f12, float f13) {
                float f14 = f12 + f10;
                float f15 = fMax;
                return FloatFloatPair.m9constructorimpl(f14 / f15, (f13 + f11) / f15);
            }
        });
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + l.c1(this.cubics, null, null, null, null, 63) + " || Features = " + l.c1(this.features, null, null, null, null, 63) + " || Center = (" + this.centerX + ", " + this.centerY + ")]";
    }

    public final RoundedPolygon transformed(PointTransformer f4) {
        k.e(f4, "f");
        long jM64transformedso9K2fw = PointKt.m64transformedso9K2fw(FloatFloatPair.m9constructorimpl(this.centerX, this.centerY), f4);
        c cVarN = q.N();
        int size = this.features.size();
        for (int i2 = 0; i2 < size; i2++) {
            cVarN.add(this.features.get(i2).transformed$graphics_shapes_release(f4));
        }
        return new RoundedPolygon(q.o(cVarN), PointKt.m57getXDnnuFBc(jM64transformedso9K2fw), PointKt.m58getYDnnuFBc(jM64transformedso9K2fw));
    }

    public final float[] calculateBounds(float[] bounds) {
        k.e(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean z2) {
        k.e(bounds, "bounds");
        if (bounds.length >= 4) {
            int size = this.cubics.size();
            float fMax = Float.MIN_VALUE;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = Float.MIN_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                this.cubics.get(i2).calculateBounds$graphics_shapes_release(bounds, z2);
                fMin = Math.min(fMin, bounds[0]);
                fMin2 = Math.min(fMin2, bounds[1]);
                fMax = Math.max(fMax, bounds[2]);
                fMax2 = Math.max(fMax2, bounds[3]);
            }
            bounds[0] = fMin;
            bounds[1] = fMin2;
            bounds[2] = fMax;
            bounds[3] = fMax2;
            return bounds;
        }
        throw new IllegalArgumentException("Required bounds size of 4");
    }
}
