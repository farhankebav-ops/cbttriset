package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double mPI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d8, float f4) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d8);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d8;
        this.mPeriod[iBinarySearch] = f4;
        this.mNormalized = false;
    }

    public double getDP(double d8) {
        if (d8 <= 0.0d) {
            return 0.0d;
        }
        if (d8 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d8);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f4 = fArr[iBinarySearch];
        int i2 = iBinarySearch - 1;
        float f8 = fArr[i2];
        double d9 = f4 - f8;
        double[] dArr = this.mPosition;
        double d10 = dArr[iBinarySearch];
        double d11 = dArr[i2];
        double d12 = d9 / (d10 - d11);
        return (((double) f8) - (d12 * d11)) + (d8 * d12);
    }

    public double getP(double d8) {
        if (d8 <= 0.0d) {
            return 0.0d;
        }
        if (d8 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d8);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f4 = fArr[iBinarySearch];
        int i2 = iBinarySearch - 1;
        float f8 = fArr[i2];
        double d9 = f4 - f8;
        double[] dArr = this.mPosition;
        double d10 = dArr[iBinarySearch];
        double d11 = dArr[i2];
        double d12 = d9 / (d10 - d11);
        return ((((d8 * d8) - (d11 * d11)) * d12) / 2.0d) + ((d8 - d11) * (((double) f8) - (d12 * d11))) + this.mArea[i2];
    }

    public double getSlope(double d8, double d9, double d10) {
        double d11;
        double dSignum;
        double p = getP(d8) + d9;
        double dp = getDP(d8) + d10;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d11 = dp * 4.0d;
                dSignum = Math.signum((((p * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d12 = this.mPI2;
                return Math.sin(d12 * p) * (-d12) * dp;
            case 6:
                return ((((p * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p % 1.0d, 0);
            default:
                double d13 = this.mPI2;
                d11 = dp * d13;
                dSignum = Math.cos(d13 * p);
                break;
        }
        return dSignum * d11;
    }

    public double getValue(double d8, double d9) {
        double dAbs;
        double p = getP(d8) + d9;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p % 1.0d));
            case 2:
                dAbs = Math.abs((((p * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((p * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d9 + p) * this.mPI2);
            case 6:
                double dAbs2 = 1.0d - Math.abs(((p * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p);
        }
        return 1.0d - dAbs;
    }

    public void normalize() {
        double d8 = 0.0d;
        int i2 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i2 >= fArr.length) {
                break;
            }
            d8 += (double) fArr[i2];
            i2++;
        }
        double d9 = 0.0d;
        int i8 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i8 >= fArr2.length) {
                break;
            }
            int i9 = i8 - 1;
            float f4 = (fArr2[i9] + fArr2[i8]) / 2.0f;
            double[] dArr = this.mPosition;
            d9 += (dArr[i8] - dArr[i9]) * ((double) f4);
            i8++;
        }
        int i10 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i10 >= fArr3.length) {
                break;
            }
            fArr3[i10] = fArr3[i10] * ((float) (d8 / d9));
            i10++;
        }
        this.mArea[0] = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i11 >= fArr4.length) {
                this.mNormalized = true;
                return;
            }
            int i12 = i11 - 1;
            float f8 = (fArr4[i12] + fArr4[i11]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d10 = dArr2[i11] - dArr2[i12];
            double[] dArr3 = this.mArea;
            dArr3[i11] = (d10 * ((double) f8)) + dArr3[i12];
            i11++;
        }
    }

    public void setType(int i2, String str) {
        this.mType = i2;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
