package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import com.ironsource.C2300e4;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int mCount;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CoreSpline extends SplineSet {
        long mStart;
        String mType;

        public CoreSpline(String str, long j) {
            this.mType = str;
            this.mStart = j;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f4) {
            typedValues.setValue(typedValues.getId(this.mType), get(f4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i2, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f4) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iNumberOfInterpolatedValues);
            for (int i8 = 0; i8 < size; i8++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i8);
                CustomAttribute customAttributeValueAt = this.mConstraintAttributeList.valueAt(i8);
                dArr[i8] = ((double) iKeyAt) * 0.01d;
                customAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i9 = 0;
                while (true) {
                    if (i9 < this.mTempValues.length) {
                        dArr2[i8][i9] = r6[i9];
                        i9++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomAttribute customAttribute) {
            this.mConstraintAttributeList.append(i2, customAttribute);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i2, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f4) {
            setProperty((MotionWidget) typedValues, f4);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iNumberOfInterpolatedValues);
            for (int i8 = 0; i8 < size; i8++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i8);
                CustomVariable customVariableValueAt = this.mConstraintAttributeList.valueAt(i8);
                dArr[i8] = ((double) iKeyAt) * 0.01d;
                customVariableValueAt.getValuesToInterpolate(this.mTempValues);
                int i9 = 0;
                while (true) {
                    if (i9 < this.mTempValues.length) {
                        dArr2[i8][i9] = r6[i9];
                        i9++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomVariable customVariable) {
            this.mConstraintAttributeList.append(i2, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f4) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mTempValues);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i2, int i8) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i8;
            iArr2[1] = i2;
            int i9 = 2;
            while (i9 > 0) {
                int i10 = iArr2[i9 - 1];
                int i11 = i9 - 2;
                int i12 = iArr2[i11];
                if (i10 < i12) {
                    int iPartition = partition(iArr, fArr, i10, i12);
                    iArr2[i11] = iPartition - 1;
                    iArr2[i9 - 1] = i10;
                    int i13 = i9 + 1;
                    iArr2[i9] = i12;
                    i9 += 2;
                    iArr2[i13] = iPartition + 1;
                } else {
                    i9 = i11;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i2, int i8) {
            int i9 = iArr[i8];
            int i10 = i2;
            while (i2 < i8) {
                if (iArr[i2] <= i9) {
                    swap(iArr, fArr, i10, i2);
                    i10++;
                }
                i2++;
            }
            swap(iArr, fArr, i10, i8);
            return i10;
        }

        private static void swap(int[] iArr, float[] fArr, int i2, int i8) {
            int i9 = iArr[i2];
            iArr[i2] = iArr[i8];
            iArr[i8] = i9;
            float f4 = fArr[i2];
            fArr[i2] = fArr[i8];
            fArr[i8] = f4;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j) {
        return new CoreSpline(str, j);
    }

    public float get(float f4) {
        return (float) this.mCurveFit.getPos(f4, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f4) {
        return (float) this.mCurveFit.getSlope(f4, 0);
    }

    public void setPoint(int i2, float f4) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.mCount + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i8 = this.mCount;
        iArr2[i8] = i2;
        this.mValues[i8] = f4;
        this.mCount = i8 + 1;
    }

    public void setProperty(TypedValues typedValues, float f4) {
        typedValues.setValue(a.a(this.mType), get(f4));
    }

    public void setType(String str) {
        this.mType = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setup(int r10) {
        /*
            r9 = this;
            int r0 = r9.mCount
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.mTimePoints
            float[] r2 = r9.mValues
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.core.motion.utils.SplineSet.Sort.doubleQuickSort(r1, r2, r4, r0)
            r0 = r3
            r1 = r0
        L11:
            int r2 = r9.mCount
            if (r0 >= r2) goto L24
            int[] r2 = r9.mTimePoints
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r3 = r2
        L37:
            int r5 = r9.mCount
            if (r2 >= r5) goto L63
            if (r2 <= 0) goto L48
            int[] r5 = r9.mTimePoints
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L48
            goto L60
        L48:
            int[] r5 = r9.mTimePoints
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.mValues
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L60:
            int r2 = r2 + 1
            goto L37
        L63:
            androidx.constraintlayout.core.motion.utils.CurveFit r10 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r10, r0, r1)
            r9.mCurveFit = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.SplineSet.setup(int):void");
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.mCount; i2++) {
            StringBuilder sbX = a1.a.x(string, C2300e4.i.f8403d);
            sbX.append(this.mTimePoints[i2]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.mValues[i2]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}
