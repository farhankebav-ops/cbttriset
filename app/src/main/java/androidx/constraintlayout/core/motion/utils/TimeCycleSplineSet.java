package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import com.ironsource.C2300e4;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i2, float f4, float f8, int i8, float f9) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f4, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            long j3 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f10 = (float) ((((j3 * 1.0E-9d) * ((double) f8)) + ((double) this.mLastCycle)) % 1.0d);
            this.mLastCycle = f10;
            this.mLastTime = j;
            float fCalcWave = calcWave(f10);
            this.mContinue = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z2 = this.mContinue;
                float f11 = this.mTempValues[i2];
                this.mContinue = z2 | (((double) f11) != 0.0d);
                fArr2[i2] = (f11 * fCalcWave) + f9;
                i2++;
            }
            motionWidget.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f8 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i8 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i8];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i8);
            for (int i9 = 0; i9 < size; i9++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i9);
                CustomAttribute customAttributeValueAt = this.mConstraintAttributeList.valueAt(i9);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i9);
                dArr[i9] = ((double) iKeyAt) * 0.01d;
                customAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i10 = 0;
                while (true) {
                    if (i10 < this.mTempValues.length) {
                        dArr2[i9][i10] = r8[i10];
                        i10++;
                    }
                }
                double[] dArr3 = dArr2[i9];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomAttribute customAttribute, float f4, int i8, float f8) {
            this.mConstraintAttributeList.append(i2, customAttribute);
            this.mWaveProperties.append(i2, new float[]{f4, f8});
            this.mWaveShape = Math.max(this.mWaveShape, i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i2, float f4, float f8, int i8, float f9) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f4, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            long j3 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f10 = (float) ((((j3 * 1.0E-9d) * ((double) f8)) + ((double) this.mLastCycle)) % 1.0d);
            this.mLastCycle = f10;
            this.mLastTime = j;
            float fCalcWave = calcWave(f10);
            this.mContinue = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z2 = this.mContinue;
                float f11 = this.mTempValues[i2];
                this.mContinue = z2 | (((double) f11) != 0.0d);
                fArr2[i2] = (f11 * fCalcWave) + f9;
                i2++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCustomCache);
            if (f8 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i8 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i8];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i8);
            for (int i9 = 0; i9 < size; i9++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i9);
                CustomVariable customVariableValueAt = this.mConstraintAttributeList.valueAt(i9);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i9);
                dArr[i9] = ((double) iKeyAt) * 0.01d;
                customVariableValueAt.getValuesToInterpolate(this.mTempValues);
                int i10 = 0;
                while (true) {
                    if (i10 < this.mTempValues.length) {
                        dArr2[i9][i10] = r8[i10];
                        i10++;
                    }
                }
                double[] dArr3 = dArr2[i9];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, CustomVariable customVariable, float f4, int i8, float f8) {
            this.mConstraintAttributeList.append(i2, customVariable);
            this.mWaveProperties.append(i2, new float[]{f4, f8});
            this.mWaveShape = Math.max(this.mWaveShape, i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i2, int i8) {
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

        private static int partition(int[] iArr, float[][] fArr, int i2, int i8) {
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

        private static void swap(int[] iArr, float[][] fArr, int i2, int i8) {
            int i9 = iArr[i2];
            iArr[i2] = iArr[i8];
            iArr[i8] = i9;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i8];
            fArr[i8] = fArr2;
        }
    }

    public float calcWave(float f4) {
        float fAbs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f4 * sVal2PI);
            case 2:
                fAbs = Math.abs(f4);
                break;
            case 3:
                return (((f4 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f4 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f4 * sVal2PI);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f4 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f4 * sVal2PI);
        }
        return 1.0f - fAbs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i2, float f4, float f8, int i8, float f9) {
        int[] iArr = this.mTimePoints;
        int i9 = this.mCount;
        iArr[i9] = i2;
        float[] fArr = this.mValues[i9];
        fArr[0] = f4;
        fArr[1] = f8;
        fArr[2] = f9;
        this.mWaveShape = Math.max(this.mWaveShape, i8);
        this.mCount++;
    }

    public void setStartTime(long j) {
        this.mLastTime = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setup(int r12) {
        /*
            r11 = this;
            int r0 = r11.mCount
            if (r0 != 0) goto L1a
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error no points added to "
            r0.<init>(r1)
            java.lang.String r1 = r11.mType
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.println(r0)
            return
        L1a:
            int[] r1 = r11.mTimePoints
            float[][] r2 = r11.mValues
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.Sort.doubleQuickSort(r1, r2, r4, r0)
            r0 = r3
            r1 = r4
        L26:
            int[] r2 = r11.mTimePoints
            int r5 = r2.length
            if (r0 >= r5) goto L38
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L35
            int r1 = r1 + 1
        L35:
            int r0 = r0 + 1
            goto L26
        L38:
            if (r1 != 0) goto L3b
            r1 = r3
        L3b:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r5 = new int[r2]
            r6 = 3
            r5[r3] = r6
            r5[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
            double[][] r1 = (double[][]) r1
            r5 = r4
            r6 = r5
        L4f:
            int r7 = r11.mCount
            if (r5 >= r7) goto L87
            if (r5 <= 0) goto L60
            int[] r7 = r11.mTimePoints
            r8 = r7[r5]
            int r9 = r5 + (-1)
            r7 = r7[r9]
            if (r8 != r7) goto L60
            goto L84
        L60:
            int[] r7 = r11.mTimePoints
            r7 = r7[r5]
            double r7 = (double) r7
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r7 = r7 * r9
            r0[r6] = r7
            r7 = r1[r6]
            float[][] r8 = r11.mValues
            r8 = r8[r5]
            r9 = r8[r4]
            double r9 = (double) r9
            r7[r4] = r9
            r9 = r8[r3]
            double r9 = (double) r9
            r7[r3] = r9
            r8 = r8[r2]
            double r8 = (double) r8
            r7[r2] = r8
            int r6 = r6 + 1
        L84:
            int r5 = r5 + 1
            goto L4f
        L87:
            androidx.constraintlayout.core.motion.utils.CurveFit r12 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r12, r0, r1)
            r11.mCurveFit = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.setup(int):void");
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
