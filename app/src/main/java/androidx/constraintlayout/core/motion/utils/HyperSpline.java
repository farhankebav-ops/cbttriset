package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d8, double d9, double d10, double d11) {
            this.mA = d8;
            this.mB = d9;
            this.mC = d10;
            this.mD = d11;
        }

        public double eval(double d8) {
            return (((((this.mD * d8) + this.mC) * d8) + this.mB) * d8) + this.mA;
        }

        public double vel(double d8) {
            return (((this.mC * 2.0d) + (this.mD * 3.0d * d8)) * d8) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i2, double[] dArr) {
        double[] dArr2 = new double[i2];
        double[] dArr3 = new double[i2];
        double[] dArr4 = new double[i2];
        int i8 = i2 - 1;
        int i9 = 0;
        dArr2[0] = 0.5d;
        int i10 = 1;
        for (int i11 = 1; i11 < i8; i11++) {
            dArr2[i11] = 1.0d / (4.0d - dArr2[i11 - 1]);
        }
        int i12 = i2 - 2;
        dArr2[i8] = 1.0d / (2.0d - dArr2[i12]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i10 < i8) {
            int i13 = i10 + 1;
            int i14 = i10 - 1;
            dArr3[i10] = (((dArr[i13] - dArr[i14]) * 3.0d) - dArr3[i14]) * dArr2[i10];
            i10 = i13;
        }
        double d8 = (((dArr[i8] - dArr[i12]) * 3.0d) - dArr3[i12]) * dArr2[i8];
        dArr3[i8] = d8;
        dArr4[i8] = d8;
        while (i12 >= 0) {
            dArr4[i12] = dArr3[i12] - (dArr2[i12] * dArr4[i12 + 1]);
            i12--;
        }
        Cubic[] cubicArr = new Cubic[i8];
        while (i9 < i8) {
            double d9 = dArr[i9];
            double d10 = dArr4[i9];
            int i15 = i9 + 1;
            double d11 = dArr[i15];
            double d12 = dArr4[i15];
            cubicArr[i9] = new Cubic((float) d9, d10, (((d11 - d9) * 3.0d) - (d10 * 2.0d)) - d12, ((d9 - d11) * 2.0d) + d10 + d12);
            i9 = i15;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i2;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d8 = 0.0d;
        double d9 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i2 = 0;
            if (d9 >= 1.0d) {
                break;
            }
            double d10 = 0.0d;
            while (i2 < length) {
                double d11 = dArr[i2];
                double dEval = cubicArr[i2].eval(d9);
                dArr[i2] = dEval;
                double d12 = d11 - dEval;
                d10 += d12 * d12;
                i2++;
            }
            if (d9 > 0.0d) {
                dSqrt += Math.sqrt(d10);
            }
            d9 += 0.1d;
        }
        while (i2 < length) {
            double d13 = dArr[i2];
            double dEval2 = cubicArr[i2].eval(1.0d);
            dArr[i2] = dEval2;
            double d14 = d13 - dEval2;
            d8 += d14 * d14;
            i2++;
        }
        return Math.sqrt(d8) + dSqrt;
    }

    public void getPos(double d8, double[] dArr) {
        double d9 = d8 * this.mTotalLength;
        int i2 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i2 >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i2];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i2++;
        }
        for (int i8 = 0; i8 < dArr.length; i8++) {
            dArr[i8] = this.mCurve[i8][i2].eval(d9 / this.mCurveLength[i2]);
        }
    }

    public void getVelocity(double d8, double[] dArr) {
        double d9 = d8 * this.mTotalLength;
        int i2 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i2 >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i2];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i2++;
        }
        for (int i8 = 0; i8 < dArr.length; i8++) {
            dArr[i8] = this.mCurve[i8][i2].vel(d9 / this.mCurveLength[i2]);
        }
    }

    public void setup(double[][] dArr) {
        int i2;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i8 = 0; i8 < this.mDimensionality; i8++) {
            for (int i9 = 0; i9 < this.mPoints; i9++) {
                this.mCtl[i8][i9] = dArr[i9][i8];
            }
        }
        int i10 = 0;
        while (true) {
            i2 = this.mDimensionality;
            if (i10 >= i2) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i10];
            cubicArr[i10] = calcNaturalCubic(dArr2.length, dArr2);
            i10++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i2];
        for (int i11 = 0; i11 < this.mCurveLength.length; i11++) {
            for (int i12 = 0; i12 < this.mDimensionality; i12++) {
                cubicArr2[i12] = this.mCurve[i12][i11];
            }
            double d8 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double dApproxLength = approxLength(cubicArr2);
            dArr3[i11] = dApproxLength;
            this.mTotalLength = d8 + dApproxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d8, float[] fArr) {
        double d9 = d8 * this.mTotalLength;
        int i2 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i2 >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i2];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i2++;
        }
        for (int i8 = 0; i8 < fArr.length; i8++) {
            fArr[i8] = (float) this.mCurve[i8][i2].eval(d9 / this.mCurveLength[i2]);
        }
    }

    public double getPos(double d8, int i2) {
        double[] dArr;
        double d9 = d8 * this.mTotalLength;
        int i8 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i8 >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i8];
            if (d10 >= d9) {
                break;
            }
            d9 -= d10;
            i8++;
        }
        return this.mCurve[i2][i8].eval(d9 / dArr[i8]);
    }
}
