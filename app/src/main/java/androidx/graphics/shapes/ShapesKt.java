package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k6.c;
import k6.d;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import r5.m;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        k.e(companion, "<this>");
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i2, float f4, float f8, float f9, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = 8;
        }
        if ((i8 & 2) != 0) {
            f4 = 1.0f;
        }
        if ((i8 & 4) != 0) {
            f8 = 0.0f;
        }
        if ((i8 & 8) != 0) {
            f9 = 0.0f;
        }
        return circle(companion, i2, f4, f8, f9);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        k.e(companion, "<this>");
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f4, float f8, float f9, float f10, float f11, int i2, Object obj) {
        float f12;
        float f13;
        float f14;
        float f15;
        RoundedPolygon.Companion companion2;
        float f16;
        if ((i2 & 1) != 0) {
            f4 = 2.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f9 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f10 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            f12 = 0.0f;
            f15 = f9;
            f13 = f10;
            f16 = f4;
            f14 = f8;
            companion2 = companion;
        } else {
            f12 = f11;
            f13 = f10;
            f14 = f8;
            f15 = f9;
            companion2 = companion;
            f16 = f4;
        }
        return pill(companion2, f16, f14, f15, f13, f12);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        k.e(companion, "<this>");
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f4, float f8, int i2, float f9, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f10, float f11, float f12, float f13, int i8, Object obj) {
        float f14;
        float f15;
        float f16;
        float f17;
        CornerRounding cornerRounding3;
        List list2;
        float f18;
        CornerRounding cornerRounding4;
        float f19;
        int i9;
        RoundedPolygon.Companion companion2;
        float f20;
        if ((i8 & 1) != 0) {
            f4 = 2.0f;
        }
        if ((i8 & 2) != 0) {
            f8 = 1.0f;
        }
        if ((i8 & 4) != 0) {
            i2 = 8;
        }
        if ((i8 & 8) != 0) {
            f9 = 0.5f;
        }
        if ((i8 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i8 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i8 & 64) != 0) {
            list = null;
        }
        if ((i8 & 128) != 0) {
            f10 = 0.5f;
        }
        if ((i8 & 256) != 0) {
            f11 = 0.0f;
        }
        if ((i8 & 512) != 0) {
            f12 = 0.0f;
        }
        if ((i8 & 1024) != 0) {
            f14 = 0.0f;
            f17 = f11;
            f15 = f12;
            list2 = list;
            f16 = f10;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i9 = i2;
            f18 = f9;
            f20 = f4;
            f19 = f8;
            companion2 = companion;
        } else {
            f14 = f13;
            f15 = f12;
            f16 = f10;
            f17 = f11;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f18 = f9;
            cornerRounding4 = cornerRounding;
            f19 = f8;
            i9 = i2;
            companion2 = companion;
            f20 = f4;
        }
        return pillStar(companion2, f20, f19, i9, f18, cornerRounding4, cornerRounding3, list2, f16, f17, f15, f14);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i2, float f4, float f8, float f9, float f10, float f11, float f12, float f13) {
        int i8;
        float f14;
        float f15;
        float f16;
        long jM9constructorimpl;
        float fMin = Math.min(f4, f8);
        float f17 = f8 - f4;
        if (f17 < 0.0f) {
            f17 = 0.0f;
        }
        float f18 = f4 - f8;
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        float f19 = 2;
        float f20 = f17 / f19;
        float f21 = f18 / f19;
        float fInterpolate = Utils.interpolate(f9, 1.0f, f10) * Utils.getTwoPi() * fMin;
        float f22 = (f19 * f17) + (f19 * f18) + fInterpolate;
        float f23 = fInterpolate / 4;
        float f24 = f20 + f23;
        float f25 = f24 + f18;
        float f26 = f25 + f23;
        float f27 = f26 + f17;
        float f28 = f27 + f23;
        float f29 = f28 + f18;
        float f30 = f29 + f23;
        float[] fArr = {0.0f, f20, f24, f25, f26, f27, f28, f29, f30, f30 + f20, f22};
        int i9 = i2 * 2;
        float f31 = f22 / i9;
        float f32 = f11 * f22;
        float[] fArr2 = new float[i2 * 4];
        float f33 = f18;
        long jM9constructorimpl2 = FloatFloatPair.m9constructorimpl(f21, f20);
        float f34 = -f21;
        long jM9constructorimpl3 = FloatFloatPair.m9constructorimpl(f34, f20);
        float f35 = -f20;
        long jM9constructorimpl4 = FloatFloatPair.m9constructorimpl(f34, f35);
        long jM9constructorimpl5 = FloatFloatPair.m9constructorimpl(f21, f35);
        float f36 = f17;
        float f37 = f20;
        int i10 = 0;
        float f38 = 0.0f;
        boolean z2 = false;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i9) {
            float f39 = f32 % f22;
            if (f39 < f38) {
                i11 = 0;
            }
            while (true) {
                int i13 = (i11 + 1) % 11;
                float f40 = fArr[i13];
                if (f39 >= f40) {
                    f37 = fArr[(i13 + 1) % 11];
                    i11 = i13;
                    f38 = f40;
                } else {
                    float f41 = (f39 - f38) / (f37 - f38);
                    if (z2) {
                        i8 = i10;
                        f14 = fMin * f9;
                    } else {
                        i8 = i10;
                        f14 = fMin;
                    }
                    switch (i11) {
                        case 0:
                            f15 = f20;
                            float f42 = f14;
                            f16 = f21;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f42, f41 * f15);
                            break;
                        case 1:
                            f15 = f20;
                            float f43 = f14;
                            f16 = f21;
                            jM9constructorimpl = PointKt.m61plusybeJwSQ(Utils.m77radialToCartesianL6JJ3z0$default(f43, (Utils.getFloatPi() * f41) / f19, 0L, 4, null), jM9constructorimpl2);
                            break;
                        case 2:
                            f15 = f20;
                            float f44 = f14;
                            f16 = f21;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f16 - (f41 * f33), f44);
                            break;
                        case 3:
                            f15 = f20;
                            float f45 = f14;
                            f16 = f21;
                            jM9constructorimpl = PointKt.m61plusybeJwSQ(Utils.m77radialToCartesianL6JJ3z0$default(f45, ((Utils.getFloatPi() * f41) / f19) + (Utils.getFloatPi() / f19), 0L, 4, null), jM9constructorimpl3);
                            break;
                        case 4:
                            f15 = f20;
                            float f46 = f14;
                            f16 = f21;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(-f46, f15 - (f41 * f36));
                            break;
                        case 5:
                            f15 = f20;
                            float f47 = f14;
                            f16 = f21;
                            jM9constructorimpl = PointKt.m61plusybeJwSQ(Utils.m77radialToCartesianL6JJ3z0$default(f47, ((Utils.getFloatPi() * f41) / f19) + Utils.getFloatPi(), 0L, 4, null), jM9constructorimpl4);
                            break;
                        case 6:
                            f15 = f20;
                            float f48 = f14;
                            f16 = f21;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl((f41 * f33) + f34, -f48);
                            break;
                        case 7:
                            f15 = f20;
                            float f49 = f14;
                            f16 = f21;
                            jM9constructorimpl = PointKt.m61plusybeJwSQ(Utils.m77radialToCartesianL6JJ3z0$default(f49, ((Utils.getFloatPi() * f41) / f19) + (Utils.getFloatPi() * 1.5f), 0L, 4, null), jM9constructorimpl5);
                            break;
                        default:
                            f15 = f20;
                            jM9constructorimpl = FloatFloatPair.m9constructorimpl(f14, (f41 * f20) + f35);
                            f16 = f21;
                            break;
                    }
                    int i14 = i12 + 1;
                    fArr2[i12] = PointKt.m57getXDnnuFBc(jM9constructorimpl) + f12;
                    i12 += 2;
                    fArr2[i14] = PointKt.m58getYDnnuFBc(jM9constructorimpl) + f13;
                    f32 += f31;
                    z2 = !z2;
                    f21 = f16;
                    i10 = i8 + 1;
                    f20 = f15;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f4, float f8, CornerRounding rounding, List<CornerRounding> list, float f9, float f10) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        float f11 = 2;
        float f12 = f4 / f11;
        float f13 = f9 - f12;
        float f14 = f8 / f11;
        float f15 = f10 - f14;
        float f16 = f12 + f9;
        float f17 = f14 + f10;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f16, f17, f13, f17, f13, f15, f16, f15}, rounding, list, f9, f10);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f4, float f8, CornerRounding cornerRounding, List list, float f9, float f10, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 2.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 2.0f;
        }
        if ((i2 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 8) != 0) {
            list = null;
        }
        if ((i2 & 16) != 0) {
            f9 = 0.0f;
        }
        if ((i2 & 32) != 0) {
            f10 = 0.0f;
        }
        return rectangle(companion, f4, f8, cornerRounding, list, f9, f10);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2) {
        k.e(companion, "<this>");
        return star$default(companion, i2, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f9, float f10, int i8, Object obj) {
        return star(companion, i2, (i8 & 2) != 0 ? 1.0f : f4, (i8 & 4) != 0 ? 0.5f : f8, (i8 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i8 & 16) != 0 ? null : cornerRounding2, (i8 & 32) == 0 ? list : null, (i8 & 64) != 0 ? 0.0f : f9, (i8 & 128) != 0 ? 0.0f : f10);
    }

    private static final float[] starVerticesFromNumVerts(int i2, float f4, float f8, float f9, float f10) {
        float[] fArr = new float[i2 * 4];
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            float f11 = i2;
            long jM77radialToCartesianL6JJ3z0$default = Utils.m77radialToCartesianL6JJ3z0$default(f4, (Utils.getFloatPi() / f11) * 2 * i9, 0L, 4, null);
            fArr[i8] = PointKt.m57getXDnnuFBc(jM77radialToCartesianL6JJ3z0$default) + f9;
            fArr[i8 + 1] = PointKt.m58getYDnnuFBc(jM77radialToCartesianL6JJ3z0$default) + f10;
            long jM77radialToCartesianL6JJ3z0$default2 = Utils.m77radialToCartesianL6JJ3z0$default(f8, (Utils.getFloatPi() / f11) * ((i9 * 2) + 1), 0L, 4, null);
            int i10 = i8 + 3;
            fArr[i8 + 2] = PointKt.m57getXDnnuFBc(jM77radialToCartesianL6JJ3z0$default2) + f9;
            i8 += 4;
            fArr[i10] = PointKt.m58getYDnnuFBc(jM77radialToCartesianL6JJ3z0$default2) + f10;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2) {
        k.e(companion, "<this>");
        return circle$default(companion, i2, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f4) {
        k.e(companion, "<this>");
        return pill$default(companion, f4, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4) {
        k.e(companion, "<this>");
        return pillStar$default(companion, f4, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4) {
        k.e(companion, "<this>");
        return star$default(companion, i2, f4, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f4) {
        k.e(companion, "<this>");
        return circle$default(companion, i2, f4, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f4, float f8) {
        k.e(companion, "<this>");
        return pill$default(companion, f4, f8, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8) {
        k.e(companion, "<this>");
        return pillStar$default(companion, f4, f8, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8) {
        k.e(companion, "<this>");
        return star$default(companion, i2, f4, f8, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f4, float f8) {
        k.e(companion, "<this>");
        return circle$default(companion, i2, f4, f8, 0.0f, 8, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f4, float f8, float f9) {
        k.e(companion, "<this>");
        return pill$default(companion, f4, f8, f9, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2) {
        k.e(companion, "<this>");
        return pillStar$default(companion, f4, f8, i2, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, IronSourceError.ERROR_INIT_ALREADY_FINISHED, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding rounding) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return star$default(companion, i2, f4, f8, rounding, null, null, 0.0f, 0.0f, 240, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f4, float f8, float f9) {
        k.e(companion, "<this>");
        if (i2 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i2, f4 / ((float) Math.cos(Utils.getFloatPi() / i2)), f8, f9, new CornerRounding(f4, 0.0f, 2, null), null, 32, null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f4, float f8, float f9, float f10) {
        k.e(companion, "<this>");
        return pill$default(companion, f4, f8, f9, f10, 0.0f, 16, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9) {
        k.e(companion, "<this>");
        return pillStar$default(companion, f4, f8, i2, f9, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding rounding, CornerRounding cornerRounding) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return star$default(companion, i2, f4, f8, rounding, cornerRounding, null, 0.0f, 0.0f, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f4, float f8, float f9, float f10, float f11) {
        k.e(companion, "<this>");
        if (f4 > 0.0f && f8 > 0.0f) {
            float f12 = 2;
            float f13 = f4 / f12;
            float f14 = f8 / f12;
            float f15 = f13 + f10;
            float f16 = f14 + f11;
            float f17 = (-f13) + f10;
            float f18 = (-f14) + f11;
            return RoundedPolygonKt.RoundedPolygon$default(new float[]{f15, f16, f17, f16, f17, f18, f15, f18}, new CornerRounding(Math.min(f13, f14), f9), null, f10, f11, 4, null);
        }
        throw new IllegalArgumentException("Pill shapes must have positive width and height");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return star$default(companion, i2, f4, f8, rounding, cornerRounding, list, 0.0f, 0.0f, 192, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, cornerRounding, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f9) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return star$default(companion, i2, f4, f8, rounding, cornerRounding, list, f9, 0.0f, 128, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, cornerRounding, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f4, float f8, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f9, float f10) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        if (f4 <= 0.0f || f8 <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f8 < f4) {
            if (list == null && cornerRounding != null) {
                d dVarD0 = q.D0(0, i2);
                ArrayList arrayList = new ArrayList();
                Iterator it = dVarD0.iterator();
                while (((c) it).f12714c) {
                    ((v) it).nextInt();
                    l.Q0(m.H0(rounding, cornerRounding), arrayList);
                }
                list = arrayList;
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i2, f4, f8, f9, f10), rounding, list, f9, f10);
        }
        throw new IllegalArgumentException("innerRadius must be less than radius");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, cornerRounding, list, f10, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, cornerRounding, list, f10, f11, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12) {
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        return pillStar$default(companion, f4, f8, i2, f9, rounding, cornerRounding, list, f10, f11, f12, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f4, float f8, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f9, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11, float f12, float f13) {
        List<CornerRounding> arrayList;
        k.e(companion, "<this>");
        k.e(rounding, "rounding");
        if (f4 <= 0.0f || f8 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        if (f9 > 0.0f && f9 <= 1.0f) {
            if (list != null || cornerRounding == null) {
                arrayList = list;
            } else {
                d dVarD0 = q.D0(0, i2);
                arrayList = new ArrayList<>();
                Iterator it = dVarD0.iterator();
                while (((c) it).f12714c) {
                    ((v) it).nextInt();
                    l.Q0(m.H0(rounding, cornerRounding), arrayList);
                }
            }
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i2, f4, f8, f9, f10, f11, f12, f13), rounding, arrayList, f12, f13);
        }
        throw new IllegalArgumentException("innerRadius must be between 0 and 1");
    }
}
