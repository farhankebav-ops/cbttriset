package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k6.d;
import kotlin.jvm.internal.k;
import q5.i;
import r2.q;
import r5.l;
import r5.n;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2) {
        return RoundedPolygon$default(i2, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i2, float f4, float f8, float f9, CornerRounding cornerRounding, List list, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            f4 = 1.0f;
        }
        if ((i8 & 4) != 0) {
            f8 = 0.0f;
        }
        if ((i8 & 8) != 0) {
            f9 = 0.0f;
        }
        if ((i8 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i8 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i2, f4, f8, f9, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f4 = 0.0f;
        int i2 = 0;
        float f8 = 0.0f;
        while (i2 < fArr.length) {
            int i8 = i2 + 1;
            f4 += fArr[i2];
            i2 += 2;
            f8 += fArr[i8];
        }
        float f9 = 2;
        return FloatFloatPair.m9constructorimpl((f4 / fArr.length) / f9, (f8 / fArr.length) / f9);
    }

    private static final float[] verticesFromNumVerts(int i2, float f4, float f8, float f9) {
        float[] fArr = new float[i2 * 2];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i2) {
            float f10 = f4;
            long jM61plusybeJwSQ = PointKt.m61plusybeJwSQ(Utils.m77radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / i2) * 2 * i8, 0L, 4, null), FloatFloatPair.m9constructorimpl(f8, f9));
            int i10 = i9 + 1;
            fArr[i9] = PointKt.m57getXDnnuFBc(jM61plusybeJwSQ);
            i9 += 2;
            fArr[i10] = PointKt.m58getYDnnuFBc(jM61plusybeJwSQ);
            i8++;
            f4 = f10;
        }
        return fArr;
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f4) {
        return RoundedPolygon$default(i2, f4, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f4, float f8) {
        return RoundedPolygon$default(i2, f4, f8, 0.0f, null, null, 56, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f4, float f8, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 4) != 0) {
            list = null;
        }
        if ((i2 & 8) != 0) {
            f4 = Float.MIN_VALUE;
        }
        if ((i2 & 16) != 0) {
            f8 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f4, f8);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f4, float f8, float f9) {
        return RoundedPolygon$default(i2, f4, f8, f9, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f4, float f8, float f9, CornerRounding rounding) {
        k.e(rounding, "rounding");
        return RoundedPolygon$default(i2, f4, f8, f9, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        k.e(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        k.e(vertices, "vertices");
        k.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        k.e(vertices, "vertices");
        k.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f4) {
        k.e(vertices, "vertices");
        k.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f4, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f4, float f8, float f9, CornerRounding rounding, List<CornerRounding> list) {
        k.e(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i2, f4, f8, f9), rounding, list, f8, f9);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        k.e(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f4, float f8) {
        long jCalculateCenter;
        i iVar;
        CornerRounding cornerRounding;
        Float fValueOf = Float.valueOf(1.0f);
        k.e(vertices, "vertices");
        k.e(rounding, "rounding");
        if (vertices.length >= 6) {
            int i2 = 2;
            int i8 = 1;
            if (vertices.length % 2 != 1) {
                if (list != null && list.size() * 2 != vertices.length) {
                    throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length / 2;
                ArrayList arrayList2 = new ArrayList();
                int i9 = 0;
                int i10 = 0;
                while (i10 < length) {
                    CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i10)) == null) ? rounding : cornerRounding;
                    int i11 = (((i10 + length) - i8) % length) * 2;
                    int i12 = i10 + 1;
                    int i13 = (i12 % length) * 2;
                    int i14 = i10 * 2;
                    arrayList2.add(new RoundedCorner(FloatFloatPair.m9constructorimpl(vertices[i11], vertices[i11 + i8]), FloatFloatPair.m9constructorimpl(vertices[i14], vertices[i14 + i8]), FloatFloatPair.m9constructorimpl(vertices[i13], vertices[i13 + 1]), cornerRounding2, null));
                    i10 = i12;
                    i8 = i8;
                }
                int i15 = i8;
                d dVarD0 = q.D0(0, length);
                ArrayList arrayList3 = new ArrayList(n.L0(dVarD0, 10));
                Iterator it = dVarD0.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((v) it).nextInt();
                    int i16 = (iNextInt + 1) % length;
                    float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i16)).getExpectedRoundCut();
                    float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i16)).getExpectedCut();
                    int i17 = iNextInt * 2;
                    int i18 = i16 * 2;
                    float fDistance = Utils.distance(vertices[i17] - vertices[i18], vertices[i17 + 1] - vertices[i18 + 1]);
                    if (expectedRoundCut > fDistance) {
                        iVar = new i(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f));
                    } else if (expectedCut > fDistance) {
                        iVar = new i(fValueOf, Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
                    } else {
                        iVar = new i(fValueOf, fValueOf);
                    }
                    arrayList3.add(iVar);
                }
                for (int i19 = 0; i19 < length; i19++) {
                    MutableFloatList mutableFloatList = new MutableFloatList(2);
                    for (int i20 = 0; i20 < 2; i20++) {
                        i iVar2 = (i) arrayList3.get((((i19 + length) - 1) + i20) % length);
                        mutableFloatList.add(((((RoundedCorner) arrayList2.get(i19)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i19)).getExpectedRoundCut()) * ((Number) iVar2.f13499b).floatValue()) + (((RoundedCorner) arrayList2.get(i19)).getExpectedRoundCut() * ((Number) iVar2.f13498a).floatValue()));
                    }
                    arrayList.add(((RoundedCorner) arrayList2.get(i19)).getCubics(mutableFloatList.get(0), mutableFloatList.get(i15)));
                }
                ArrayList arrayList4 = new ArrayList();
                while (i9 < length) {
                    int iC = androidx.camera.core.processing.util.a.C(i9, length, i15, length);
                    int i21 = i9 + 1;
                    int i22 = i21 % length;
                    int i23 = i9 * 2;
                    long jM9constructorimpl = FloatFloatPair.m9constructorimpl(vertices[i23], vertices[i23 + i15]);
                    int i24 = iC * i2;
                    long jM9constructorimpl2 = FloatFloatPair.m9constructorimpl(vertices[i24], vertices[i24 + i15]);
                    int i25 = i22 * 2;
                    arrayList4.add(new Feature.Corner((List) arrayList.get(i9), jM9constructorimpl, ((RoundedCorner) arrayList2.get(i9)).m69getCenter1ufDz9w(), PointKt.m48clockwiseybeJwSQ(PointKt.m60minusybeJwSQ(jM9constructorimpl, jM9constructorimpl2), PointKt.m60minusybeJwSQ(FloatFloatPair.m9constructorimpl(vertices[i25], vertices[i25 + i15]), jM9constructorimpl)), null));
                    arrayList4.add(new Feature.Edge(q.j0(Cubic.Companion.straightLine(((Cubic) l.d1((List) arrayList.get(i9))).getAnchor1X(), ((Cubic) l.d1((List) arrayList.get(i9))).getAnchor1Y(), ((Cubic) l.X0((List) arrayList.get(i22))).getAnchor0X(), ((Cubic) l.X0((List) arrayList.get(i22))).getAnchor0Y()))));
                    i9 = i21;
                    i2 = 2;
                }
                if (f4 == Float.MIN_VALUE || f8 == Float.MIN_VALUE) {
                    jCalculateCenter = calculateCenter(vertices);
                } else {
                    jCalculateCenter = FloatFloatPair.m9constructorimpl(f4, f8);
                }
                return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
            }
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        throw new IllegalArgumentException("Polygons must have at least 3 vertices");
    }
}
