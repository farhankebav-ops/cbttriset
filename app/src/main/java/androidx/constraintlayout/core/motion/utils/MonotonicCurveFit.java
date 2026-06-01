package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i2 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i2, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i8 = 0; i8 < length2; i8++) {
            int i9 = 0;
            while (i9 < i2) {
                int i10 = i9 + 1;
                double d8 = dArr[i10] - dArr[i9];
                double[] dArr5 = dArr3[i9];
                double d9 = (dArr2[i10][i8] - dArr2[i9][i8]) / d8;
                dArr5[i8] = d9;
                if (i9 == 0) {
                    dArr4[i9][i8] = d9;
                } else {
                    dArr4[i9][i8] = (dArr3[i9 - 1][i8] + d9) * 0.5d;
                }
                i9 = i10;
            }
            dArr4[i2][i8] = dArr3[length - 2][i8];
        }
        for (int i11 = 0; i11 < i2; i11++) {
            for (int i12 = 0; i12 < length2; i12++) {
                double d10 = dArr3[i11][i12];
                if (d10 == 0.0d) {
                    dArr4[i11][i12] = 0.0d;
                    dArr4[i11 + 1][i12] = 0.0d;
                } else {
                    double d11 = dArr4[i11][i12] / d10;
                    int i13 = i11 + 1;
                    double d12 = dArr4[i13][i12] / d10;
                    double dHypot = Math.hypot(d11, d12);
                    if (dHypot > 9.0d) {
                        double d13 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i11];
                        double[] dArr7 = dArr3[i11];
                        dArr6[i12] = d11 * d13 * dArr7[i12];
                        dArr4[i13][i12] = d13 * d12 * dArr7[i12];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i2 = 0;
        while (iIndexOf2 != -1) {
            dArr[i2] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i2++;
        }
        dArr[i2] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i2 + 1));
    }

    private static double diff(double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d9 * d9;
        double d15 = d9 * 6.0d;
        double d16 = 6.0d * d14 * d10;
        double d17 = (d16 + ((d15 * d11) + (((-6.0d) * d14) * d11))) - (d15 * d10);
        double d18 = 3.0d * d8;
        return (d8 * d12) + (((((d18 * d12) * d14) + (((d18 * d13) * d14) + d17)) - (((2.0d * d8) * d13) * d9)) - (((4.0d * d8) * d12) * d9));
    }

    private static double interpolate(double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d9 * d9;
        double d15 = d14 * d9;
        double d16 = 3.0d * d14;
        double d17 = d15 * 2.0d * d10;
        double d18 = ((d17 + ((d16 * d11) + (((-2.0d) * d15) * d11))) - (d16 * d10)) + d10;
        double d19 = d8 * d13;
        double d20 = (d19 * d15) + d18;
        double d21 = d8 * d12;
        return (d21 * d9) + ((((d15 * d21) + d20) - (d19 * d14)) - (((d8 * 2.0d) * d12) * d14));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i2 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d9 = dArr2[0];
            if (d8 <= d9) {
                getSlope(d9, this.mSlopeTemp);
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = ((d8 - this.mT[0]) * this.mSlopeTemp[i8]) + this.mY[0][i8];
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr2[i9];
            if (d8 >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i2 < length2) {
                    dArr[i2] = ((d8 - this.mT[i9]) * this.mSlopeTemp[i2]) + this.mY[i9][i2];
                    i2++;
                }
                return;
            }
        } else {
            if (d8 <= dArr2[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    dArr[i10] = this.mY[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr2[i11]) {
                while (i2 < length2) {
                    dArr[i2] = this.mY[i11][i2];
                    i2++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.mT[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.mY[i12][i13];
                }
            }
            double[] dArr3 = this.mT;
            int i14 = i12 + 1;
            double d11 = dArr3[i14];
            if (d8 < d11) {
                double d12 = dArr3[i12];
                double d13 = d11 - d12;
                double d14 = (d8 - d12) / d13;
                while (i2 < length2) {
                    double[][] dArr4 = this.mY;
                    double d15 = dArr4[i12][i2];
                    double d16 = dArr4[i14][i2];
                    double[][] dArr5 = this.mTangent;
                    dArr[i2] = interpolate(d13, d14, d15, d16, dArr5[i12][i2], dArr5[i14][i2]);
                    i2++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d8, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d9 = dArr2[0];
        if (d8 > d9) {
            d9 = dArr2[length - 1];
            if (d8 < d9) {
                d9 = d8;
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.mT;
            int i8 = i2 + 1;
            double d10 = dArr3[i8];
            if (d9 <= d10) {
                double d11 = dArr3[i2];
                double d12 = d10 - d11;
                double d13 = (d9 - d11) / d12;
                for (int i9 = 0; i9 < length2; i9++) {
                    double[][] dArr4 = this.mY;
                    double d14 = dArr4[i2][i9];
                    double d15 = dArr4[i8][i9];
                    double[][] dArr5 = this.mTangent;
                    dArr[i9] = diff(d12, d13, d14, d15, dArr5[i2][i9], dArr5[i8][i9]) / d12;
                }
                return;
            }
            i2 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d8 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            double d9 = dArr[i2];
            int i8 = i2 + length2;
            dArr2[i8][0] = d9;
            double d10 = ((double) i2) * d8;
            dArr3[i8] = d10;
            if (i2 > 0) {
                int i9 = (length2 * 2) + i2;
                dArr2[i9][0] = d9 + 1.0d;
                dArr3[i9] = d10 + 1.0d;
                int i10 = i2 - 1;
                dArr2[i10][0] = (d9 - 1.0d) - d8;
                dArr3[i10] = (d10 - 1.0d) - d8;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d8, int i2) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i8 = 0;
        double d9 = dArr[0];
        if (d8 >= d9) {
            d9 = dArr[length - 1];
            if (d8 < d9) {
                d9 = d8;
            }
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.mT;
            int i9 = i8 + 1;
            double d10 = dArr2[i9];
            if (d9 <= d10) {
                double d11 = dArr2[i8];
                double d12 = d10 - d11;
                double[][] dArr3 = this.mY;
                double d13 = dArr3[i8][i2];
                double d14 = dArr3[i9][i2];
                double[][] dArr4 = this.mTangent;
                return diff(d12, (d9 - d11) / d12, d13, d14, dArr4[i8][i2], dArr4[i9][i2]) / d12;
            }
            i8 = i9;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i2 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d9 = dArr[0];
            if (d8 <= d9) {
                getSlope(d9, this.mSlopeTemp);
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) (((d8 - this.mT[0]) * this.mSlopeTemp[i8]) + this.mY[0][i8]);
                }
                return;
            }
            int i9 = length - 1;
            double d10 = dArr[i9];
            if (d8 >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i2 < length2) {
                    fArr[i2] = (float) (((d8 - this.mT[i9]) * this.mSlopeTemp[i2]) + this.mY[i9][i2]);
                    i2++;
                }
                return;
            }
        } else {
            if (d8 <= dArr[0]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = (float) this.mY[0][i10];
                }
                return;
            }
            int i11 = length - 1;
            if (d8 >= dArr[i11]) {
                while (i2 < length2) {
                    fArr[i2] = (float) this.mY[i11][i2];
                    i2++;
                }
                return;
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d8 == this.mT[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.mY[i12][i13];
                }
            }
            double[] dArr2 = this.mT;
            int i14 = i12 + 1;
            double d11 = dArr2[i14];
            if (d8 < d11) {
                double d12 = dArr2[i12];
                double d13 = d11 - d12;
                double d14 = (d8 - d12) / d13;
                while (i2 < length2) {
                    double[][] dArr3 = this.mY;
                    double d15 = dArr3[i12][i2];
                    double d16 = dArr3[i14][i2];
                    double[][] dArr4 = this.mTangent;
                    fArr[i2] = (float) interpolate(d13, d14, d15, d16, dArr4[i12][i2], dArr4[i14][i2]);
                    i2++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d8, int i2) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i8 = 0;
        if (this.mExtrapolate) {
            double d9 = dArr[0];
            if (d8 <= d9) {
                return (getSlope(d9, i2) * (d8 - d9)) + this.mY[0][i2];
            }
            int i9 = length - 1;
            double d10 = dArr[i9];
            if (d8 >= d10) {
                return (getSlope(d10, i2) * (d8 - d10)) + this.mY[i9][i2];
            }
        } else {
            if (d8 <= dArr[0]) {
                return this.mY[0][i2];
            }
            int i10 = length - 1;
            if (d8 >= dArr[i10]) {
                return this.mY[i10][i2];
            }
        }
        while (i8 < length - 1) {
            double[] dArr2 = this.mT;
            double d11 = dArr2[i8];
            if (d8 == d11) {
                return this.mY[i8][i2];
            }
            int i11 = i8 + 1;
            double d12 = dArr2[i11];
            if (d8 < d12) {
                double d13 = d12 - d11;
                double d14 = (d8 - d11) / d13;
                double[][] dArr3 = this.mY;
                double d15 = dArr3[i8][i2];
                double d16 = dArr3[i11][i2];
                double[][] dArr4 = this.mTangent;
                return interpolate(d13, d14, d15, d16, dArr4[i8][i2], dArr4[i11][i2]);
            }
            i8 = i11;
        }
        return 0.0d;
    }
}
