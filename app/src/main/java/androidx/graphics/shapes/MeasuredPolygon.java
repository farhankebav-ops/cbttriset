package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.i;
import r2.q;
import r5.e;
import r5.l;
import r5.m;
import r5.n;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MeasuredPolygon extends e {
    public static final Companion Companion = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon polygon) {
            List listJ0;
            k.e(measurer, "measurer");
            k.e(polygon, "polygon");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = polygon.getFeatures$graphics_shapes_release().size();
            for (int i2 = 0; i2 < size; i2++) {
                Feature feature = polygon.getFeatures$graphics_shapes_release().get(i2);
                int size2 = feature.getCubics().size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if ((feature instanceof Feature.Corner) && i8 == feature.getCubics().size() / 2) {
                        arrayList2.add(new i(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i8));
                }
            }
            Float fValueOf = Float.valueOf(0.0f);
            int iL0 = n.L0(arrayList, 9);
            if (iL0 == 0) {
                listJ0 = q.j0(fValueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(iL0 + 1);
                arrayList3.add(fValueOf);
                int size3 = arrayList.size();
                int i9 = 0;
                while (i9 < size3) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    float fFloatValue = fValueOf.floatValue();
                    float fMeasureCubic = measurer.measureCubic((Cubic) obj);
                    if (fMeasureCubic < 0.0f) {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                    }
                    fValueOf = Float.valueOf(fFloatValue + fMeasureCubic);
                    arrayList3.add(fValueOf);
                }
                listJ0 = arrayList3;
            }
            float fFloatValue2 = ((Number) l.d1(listJ0)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(listJ0.size());
            int size4 = listJ0.size();
            for (int i10 = 0; i10 < size4; i10++) {
                mutableFloatList.add(((Number) listJ0.get(i10)).floatValue() / fFloatValue2);
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            c cVarN = q.N();
            int size5 = arrayList2.size();
            for (int i11 = 0; i11 < size5; i11++) {
                int iIntValue = ((Number) ((i) arrayList2.get(i11)).f13499b).intValue();
                cVarN.add(new ProgressableFeature((mutableFloatList.get(iIntValue + 1) + mutableFloatList.get(iIntValue)) / 2, (Feature) ((i) arrayList2.get(i11)).f13498a));
            }
            return new MeasuredPolygon(measurer, q.o(cVarN), arrayList, mutableFloatList, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = 1.0d) Cubic cubic, @FloatRange(from = 0.0d, to = 1.0d) float f4, float f8) {
            k.e(cubic, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f8 < f4) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.measuredSize = measuredPolygon.measurer.measureCubic(cubic);
            this.startOutlineProgress = f4;
            this.endOutlineProgress = f8;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f4, float f8, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f4 = measuredCubic.startOutlineProgress;
            }
            if ((i2 & 2) != 0) {
                f8 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f4, f8);
        }

        public final i cutAtProgress(float f4) {
            float f8 = this.startOutlineProgress;
            float f9 = this.endOutlineProgress;
            if (f8 > f9) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f9 + " is less than minimum " + f8 + '.');
            }
            if (f4 < f8) {
                f4 = f8;
            } else if (f4 > f9) {
                f4 = f9;
            }
            float fFindCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((f4 - f8) / (f9 - f8)) * this.measuredSize);
            if (0.0f > fFindCubicCutPoint || fFindCubicCutPoint > 1.0f) {
                throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            i iVarSplit = this.cubic.split(fFindCubicCutPoint);
            return new i(new MeasuredCubic(this.this$0, (Cubic) iVarSplit.f13498a, this.startOutlineProgress, f4), new MeasuredCubic(this.this$0, (Cubic) iVarSplit.f13499b, f4, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float f4, float f8) {
            if (f8 < f4) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.startOutlineProgress = f4;
            this.endOutlineProgress = f8;
        }
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, f fVar) {
        this(measurer, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    public final MeasuredPolygon cutAndShift(float f4) {
        if (0.0f > f4 || f4 > 1.0f) {
            throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1");
        }
        if (f4 < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float startOutlineProgress = next.getStartOutlineProgress();
            if (f4 <= next.getEndOutlineProgress() && startOutlineProgress <= f4) {
                break;
            }
            i2++;
        }
        i iVarCutAtProgress = this.cubics.get(i2).cutAtProgress(f4);
        MeasuredCubic measuredCubic = (MeasuredCubic) iVarCutAtProgress.f13498a;
        MeasuredCubic measuredCubic2 = (MeasuredCubic) iVarCutAtProgress.f13499b;
        String unused = PolygonMeasureKt.LOG_TAG;
        ArrayList arrayListI0 = m.I0(measuredCubic2.getCubic());
        int size = this.cubics.size();
        for (int i8 = 1; i8 < size; i8++) {
            List<MeasuredCubic> list = this.cubics;
            arrayListI0.add(list.get((i8 + i2) % list.size()).getCubic());
        }
        arrayListI0.add(measuredCubic.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        int i9 = 0;
        while (i9 < size2) {
            mutableFloatList.add(i9 == 0 ? 0.0f : i9 == this.cubics.size() + 1 ? 1.0f : Utils.positiveModulo(this.cubics.get(((i2 + i9) - 1) % this.cubics.size()).getEndOutlineProgress() - f4, 1.0f));
            i9++;
        }
        c cVarN = q.N();
        int size3 = this.features.size();
        for (int i10 = 0; i10 < size3; i10++) {
            cVarN.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i10).getProgress() - f4, 1.0f), this.features.get(i10).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, q.o(cVarN), arrayListI0, mutableFloatList);
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // r5.a
    public int getSize() {
        return this.cubics.size();
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        }
        if (floatList.first() != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        }
        if (floatList.last() != 1.0f) {
            throw new IllegalArgumentException("Last outline progress value is expected to be one");
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i2 = 0;
        float f4 = 0.0f;
        while (i2 < size) {
            int i8 = i2 + 1;
            if (floatList.get(i8) - floatList.get(i2) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i2), f4, floatList.get(i8)));
                f4 = floatList.get(i8);
            }
            i2 = i8;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(m.G0(arrayList)), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    @Override // r5.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    @Override // java.util.List
    public MeasuredCubic get(int i2) {
        return this.cubics.get(i2);
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // r5.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }
}
