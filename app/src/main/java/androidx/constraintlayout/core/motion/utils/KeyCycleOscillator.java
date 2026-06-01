package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import com.ironsource.C2300e4;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f4) {
            motionWidget.setValue(this.mTypeId, get(f4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i2, String str, int i8, int i9) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i2;
            this.mVariesBy = i8;
            oscillator.setType(i2, str);
            this.mValues = new float[i9];
            this.mPosition = new double[i9];
            this.mPeriod = new float[i9];
            this.mOffsetArr = new float[i9];
            this.mPhaseArr = new float[i9];
            this.mScale = new float[i9];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f4) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d8 = f4;
                curveFit.getSlope(d8, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d8, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d9 = f4;
            double value = this.mOscillator.getValue(d9, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d9, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f4) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f4, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f4, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i2, int i8, float f4, float f8, float f9, float f10) {
            this.mPosition[i2] = ((double) i8) / 100.0d;
            this.mPeriod[i2] = f4;
            this.mOffsetArr[i2] = f8;
            this.mPhaseArr[i2] = f9;
            this.mValues[i2] = f10;
        }

        public void setup(float f4) {
            this.mPathLength = f4;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                double[] dArr3 = dArr[i2];
                dArr3[0] = this.mOffsetArr[i2];
                dArr3[1] = this.mPhaseArr[i2];
                dArr3[2] = this.mValues[i2];
                this.mOscillator.addPoint(this.mPosition[i2], this.mPeriod[i2]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f4, double d8, double d9) {
            motionWidget.setRotationZ(get(f4) + ((float) Math.toDegrees(Math.atan2(d9, d8))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f4) {
            motionWidget.setValue(this.mTypeId, get(f4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i2, float f4, float f8, float f9, float f10) {
            this.mPosition = i2;
            this.mValue = f10;
            this.mOffset = f8;
            this.mPeriod = f4;
            this.mPhase = f9;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f4) {
        return (float) this.mCycleOscillator.getValues(f4);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f4) {
        return (float) this.mCycleOscillator.getSlope(f4);
    }

    public void setPoint(int i2, int i8, String str, int i9, float f4, float f8, float f9, float f10, Object obj) {
        this.mWavePoints.add(new WavePoint(i2, f4, f8, f9, f10));
        if (i9 != -1) {
            this.mVariesBy = i9;
        }
        this.mWaveShape = i8;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f4) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        char c7 = 2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size2 = arrayList.size();
        int i2 = 0;
        int i8 = 0;
        while (i2 < size2) {
            int i9 = i2 + 1;
            WavePoint wavePoint = arrayList.get(i2);
            float f8 = wavePoint.mPeriod;
            dArr[i8] = ((double) f8) * 0.01d;
            double[] dArr3 = dArr2[i8];
            float f9 = wavePoint.mValue;
            dArr3[0] = f9;
            float f10 = wavePoint.mOffset;
            char c8 = c7;
            dArr3[1] = f10;
            float f11 = wavePoint.mPhase;
            dArr3[c8] = f11;
            this.mCycleOscillator.setPoint(i8, wavePoint.mPosition, f8, f10, f11, f9);
            i8++;
            i2 = i9;
            c7 = c8;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f4);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            WavePoint wavePoint = arrayList.get(i2);
            i2++;
            StringBuilder sbX = a1.a.x(string, C2300e4.i.f8403d);
            sbX.append(wavePoint.mPosition);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(r5.mValue));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i2, int i8, String str, int i9, float f4, float f8, float f9, float f10) {
        this.mWavePoints.add(new WavePoint(i2, f4, f8, f9, f10));
        if (i9 != -1) {
            this.mVariesBy = i9;
        }
        this.mWaveShape = i8;
        this.mWaveString = str;
    }

    public void setCustom(Object obj) {
    }

    public void setProperty(MotionWidget motionWidget, float f4) {
    }
}
