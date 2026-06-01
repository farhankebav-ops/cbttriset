package androidx.graphics.shapes;

import androidx.graphics.shapes.MeasuredPolygon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r2.q;
import r5.l;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Morph {
    public static final Companion Companion = new Companion(null);
    private final List<i> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final List<i> match$graphics_shapes_release(RoundedPolygon p12, RoundedPolygon p2) {
            i iVarCutAtProgress;
            i iVarCutAtProgress2;
            k.e(p12, "p1");
            k.e(p2, "p2");
            MeasuredPolygon.Companion companion = MeasuredPolygon.Companion;
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p12.getCenterX(), p12.getCenterY()), p12);
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p2.getCenterX(), p2.getCenterY()), p2);
            DoubleMapper doubleMapperFeatureMapper = FeatureMappingKt.featureMapper(measuredPolygonMeasurePolygon$graphics_shapes_release.getFeatures(), measuredPolygonMeasurePolygon$graphics_shapes_release2.getFeatures());
            float map = doubleMapperFeatureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon measuredPolygonCutAndShift = measuredPolygonMeasurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) l.Z0(0, measuredPolygonMeasurePolygon$graphics_shapes_release);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) l.Z0(0, measuredPolygonCutAndShift);
            int i2 = 1;
            int i8 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i2 == measuredPolygonMeasurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float fMapBack = i8 == measuredPolygonCutAndShift.size() ? 1.0f : doubleMapperFeatureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float fMin = Math.min(endOutlineProgress, fMapBack);
                String unused2 = MorphKt.LOG_TAG;
                float f4 = 1.0E-6f + fMin;
                if (endOutlineProgress > f4) {
                    String unused3 = MorphKt.LOG_TAG;
                    iVarCutAtProgress = measuredCubic.cutAtProgress(fMin);
                } else {
                    i iVar = new i(measuredCubic, l.Z0(i2, measuredPolygonMeasurePolygon$graphics_shapes_release));
                    i2++;
                    iVarCutAtProgress = iVar;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress.f13498a;
                measuredCubic = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress.f13499b;
                if (fMapBack > f4) {
                    String unused4 = MorphKt.LOG_TAG;
                    iVarCutAtProgress2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(doubleMapperFeatureMapper.map(fMin) - map, 1.0f));
                } else {
                    i iVar2 = new i(measuredCubic2, l.Z0(i8, measuredPolygonCutAndShift));
                    i8++;
                    iVarCutAtProgress2 = iVar2;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic4 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress2.f13498a;
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) iVarCutAtProgress2.f13499b;
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(new i(measuredCubic3.getCubic(), measuredCubic4.getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched");
        }

        private Companion() {
        }
    }

    public Morph(RoundedPolygon start, RoundedPolygon end) {
        k.e(start, "start");
        k.e(end, "end");
        this.start = start;
        this.end = end;
        this._morphMatch = Companion.match$graphics_shapes_release(start, end);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return morph.calculateBounds(fArr, z2);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static void forEachCubic$default(Morph morph, float f4, MutableCubic mutableCubic, e6.l callback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        k.e(mutableCubic, "mutableCubic");
        k.e(callback, "callback");
        int size = morph.getMorphMatch().size();
        for (int i8 = 0; i8 < size; i8++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i8).f13498a, (Cubic) morph.getMorphMatch().get(i8).f13499b, f4);
            callback.invoke(mutableCubic);
        }
    }

    public final List<Cubic> asCubics(float f4) {
        c cVarN = q.N();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i2 = 0;
        while (i2 < size) {
            float[] fArr = new float[8];
            for (int i8 = 0; i8 < 8; i8++) {
                fArr[i8] = Utils.interpolate(((Cubic) this._morphMatch.get(i2).f13498a).getPoints$graphics_shapes_release()[i8], ((Cubic) this._morphMatch.get(i2).f13499b).getPoints$graphics_shapes_release()[i8], f4);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                cVarN.add(cubic);
            }
            i2++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            cVarN.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return q.o(cVarN);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        k.e(bounds, "bounds");
        this.start.calculateMaxBounds(bounds);
        float f4 = bounds[0];
        float f8 = bounds[1];
        float f9 = bounds[2];
        float f10 = bounds[3];
        this.end.calculateMaxBounds(bounds);
        bounds[0] = Math.min(f4, bounds[0]);
        bounds[1] = Math.min(f8, bounds[1]);
        bounds[2] = Math.max(f9, bounds[2]);
        bounds[3] = Math.max(f10, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f4, MutableCubic mutableCubic, e6.l callback) {
        k.e(mutableCubic, "mutableCubic");
        k.e(callback, "callback");
        int size = getMorphMatch().size();
        for (int i2 = 0; i2 < size; i2++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i2).f13498a, (Cubic) getMorphMatch().get(i2).f13499b, f4);
            callback.invoke(mutableCubic);
        }
    }

    public final List<i> getMorphMatch() {
        return this._morphMatch;
    }

    public final float[] calculateBounds(float[] bounds) {
        k.e(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean z2) {
        k.e(bounds, "bounds");
        this.start.calculateBounds(bounds, z2);
        float f4 = bounds[0];
        float f8 = bounds[1];
        float f9 = bounds[2];
        float f10 = bounds[3];
        this.end.calculateBounds(bounds, z2);
        bounds[0] = Math.min(f4, bounds[0]);
        bounds[1] = Math.min(f8, bounds[1]);
        bounds[2] = Math.max(f9, bounds[2]);
        bounds[3] = Math.max(f10, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f4, e6.l callback) {
        k.e(callback, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i2 = 0; i2 < size; i2++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i2).f13498a, (Cubic) getMorphMatch().get(i2).f13499b, f4);
            callback.invoke(mutableCubic);
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }
}
